package rs.ac.uns.ftn.oisisi.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import rs.ac.uns.ftn.oisisi.view.DodavanjePredmetaDijalog;
import rs.ac.uns.ftn.oisisi.view.DodavanjeProfesoraDijalog;
import rs.ac.uns.ftn.oisisi.view.DodavanjeStudentaDijalog;
import rs.ac.uns.ftn.oisisi.view.GlavniProzor;
import rs.ac.uns.ftn.oisisi.view.TabbedPane;
import rs.ac.uns.ftn.oisisi.view.ToolBar;

public class DodavanjeListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(TabbedPane.aktivanTab == 0){
			DodavanjeStudentaDijalog dialog = new DodavanjeStudentaDijalog(GlavniProzor.getInstance(), "Dodavanje studenta", true);
			dialog.setVisible(true);
			ToolBar.getInstance().setSelectedButton();
		}else if(TabbedPane.aktivanTab == 1){
			DodavanjePredmetaDijalog dijalog = new DodavanjePredmetaDijalog(GlavniProzor.getInstance(), "Dodavanje predmeta", true);
			dijalog.setVisible(true);
			ToolBar.getInstance().setSelectedButton();
			
		}else if(TabbedPane.aktivanTab == 2){
			DodavanjeProfesoraDijalog dijalog = new DodavanjeProfesoraDijalog(GlavniProzor.getInstance(), "Dodavanje profesora", true);
			dijalog.setVisible(true);
			ToolBar.getInstance().setSelectedButton();
			//ProfesoriTable.getInstance().resfreshTable();
		}
		
	}

}
