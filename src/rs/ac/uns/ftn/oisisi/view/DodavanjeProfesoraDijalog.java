package rs.ac.uns.ftn.oisisi.view;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisisi.controller.ProfesoriController;

public class DodavanjeProfesoraDijalog extends ProfesorDijalog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2510817338623409311L;

	
	
	public DodavanjeProfesoraDijalog(Frame p,String t,boolean m){
		super(p,t,m);
		
		
		potvrdaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String unesi[] = unosPodataka();
				boolean dodato = ProfesoriController.getInstance().dodajProfesor(unesi);
				if(dodato) {
					dispose();
					ProfesoriTable.getInstance().resfreshTable();
					JOptionPane.showMessageDialog((Component) e.getSource(), "Uspjesno ste dodali profesora.");
				}else {
					setVisible(false);
					JOptionPane.showMessageDialog((Component) e.getSource(), "Profesor sa tim brojem licne karte postoji", "Greska", JOptionPane.ERROR_MESSAGE);
					setVisible(true);
					
				}
			}
				
			
		});
		
		odustaniButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
	}
		
}
