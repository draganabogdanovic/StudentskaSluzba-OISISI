package rs.ac.uns.ftn.oisisi.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rs.ac.uns.ftn.oisisi.view.DodavanjeProfesoraDijalog;
import rs.ac.uns.ftn.oisisi.view.DodavanjeStudentaDijalog;
import rs.ac.uns.ftn.oisisi.view.GlavniProzor;
import rs.ac.uns.ftn.oisisi.view.PredmetiTable;
import rs.ac.uns.ftn.oisisi.view.TabbedPane;

public class MenuElementListenerDodavanje implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (TabbedPane.aktivanTab == 0) {
			DodavanjeStudentaDijalog di = new DodavanjeStudentaDijalog(GlavniProzor.getInstance(), "Dodavanje studenta",
					true);
			di.setVisible(true);
		}

		if (TabbedPane.aktivanTab == 1) {

			PredmetiController.getInstance().dodavanjeStudentaNaPredmet();
			PredmetiTable.getInstance().refreshTable();
			
		}

		if (TabbedPane.aktivanTab == 2) {
			DodavanjeProfesoraDijalog di = new DodavanjeProfesoraDijalog(GlavniProzor.getInstance(), "Dodavanje profesora",
					true);
			di.setVisible(true);
		}

		
	}

}
