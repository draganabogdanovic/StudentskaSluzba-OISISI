package rs.ac.uns.ftn.oisisi.view;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisisi.controller.StudentiController;

public class DodavanjeStudentaDijalog extends DialogStudent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9116098046827441615L;

	public DodavanjeStudentaDijalog(Frame parent,String title,boolean model){
		super(parent,title,model);
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String p[] = podaci();
				boolean dodavanje = StudentiController.getInstance().DodajStudenta(p);
				if(dodavanje){
					dispose();
					
					JOptionPane.showMessageDialog((Component) e.getSource(), "Uspijesno dodavanje studenta");
					StudentiTable.getInstance().refreshTable();
				}else{
					setVisible(false);
					JOptionPane.showMessageDialog((Component)e.getSource(), "Vec postoji indeks sa ovim  brojem inedeksa");
					setVisible(true);
				}
			}
		});
		
	
		
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
	}
	
}
