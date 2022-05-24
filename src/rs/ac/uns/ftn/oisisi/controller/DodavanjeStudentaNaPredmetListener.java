package rs.ac.uns.ftn.oisisi.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rs.ac.uns.ftn.oisisi.view.PredmetiTable;

public class DodavanjeStudentaNaPredmetListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		PredmetiController.getInstance().dodavanjeStudentaNaPredmet();
		PredmetiTable.getInstance().refreshTable();
		
	}

}
