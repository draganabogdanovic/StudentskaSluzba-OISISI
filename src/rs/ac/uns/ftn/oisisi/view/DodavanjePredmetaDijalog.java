package rs.ac.uns.ftn.oisisi.view;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisisi.controller.PredmetiController;

public class DodavanjePredmetaDijalog extends PredmetDijalog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8806551372666051401L;

	public DodavanjePredmetaDijalog(Frame p, String t, boolean m) {
		super(p,t,m);
		

	
	potvrdaButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String unesi[] = prikupiUnos();
			boolean dodao = PredmetiController.getInstance().dodajPredmet(unesi);
			if(dodao) {
				dispose();
				PredmetiTable.getInstance().refreshTable();
				JOptionPane.showMessageDialog((Component) e.getSource(), "Uspjesno ste dodali predmet.");
				System.out.println(TabbedPane.aktivanTab);
			}else {
				setVisible(false);
				JOptionPane.showMessageDialog((Component) e.getSource(), "Predmet sa tom sifrom vec postoji", "Greska", JOptionPane.ERROR);
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
