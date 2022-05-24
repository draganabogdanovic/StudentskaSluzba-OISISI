package rs.ac.uns.ftn.oisisi.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rs.ac.uns.ftn.oisisi.view.TabbedPane;

public class PretragaListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(TabbedPane.aktivanTab == 0) {
			StudentiController.getInstance().pretragaStudenta();
		}else if(TabbedPane.aktivanTab == 1) {
			PredmetiController.getInstance().pretragaPredmeta();
			
			
		}else if (TabbedPane.aktivanTab == 2) {
			ProfesoriController.getInstance().pretragaProfesora();
			
			
			
		}
	}

}
