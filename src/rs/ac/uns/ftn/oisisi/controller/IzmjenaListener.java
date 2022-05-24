package rs.ac.uns.ftn.oisisi.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rs.ac.uns.ftn.oisisi.view.PredmetiTable;
import rs.ac.uns.ftn.oisisi.view.PredmetiTablePane;
import rs.ac.uns.ftn.oisisi.view.ProfesoriTable;
import rs.ac.uns.ftn.oisisi.view.ProfesoriTablePane;
import rs.ac.uns.ftn.oisisi.view.StudentiTable;
import rs.ac.uns.ftn.oisisi.view.StudentiTablePane;
import rs.ac.uns.ftn.oisisi.view.TabbedPane;
import rs.ac.uns.ftn.oisisi.view.ToolBar;



public class IzmjenaListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(TabbedPane.aktivanTab == 0){
			
			StudentiController.getInstance().izmjenaStudenta();
			StudentiTable.getInstance().refreshTable();
			StudentiTablePane.setSelectedRow(-1);
			ToolBar.getInstance().setSelectedButton();
			
		}else if(TabbedPane.aktivanTab == 1){
			PredmetiController.getInstance().izmjenaPredmeta();
			PredmetiTable.getInstance().refreshTable();
			PredmetiTablePane.setSelectedRow(-1);
			ToolBar.getInstance().setSelectedButton();
		}else if(TabbedPane.aktivanTab== 2){
			ProfesoriController.getInstance().izmjenaProfesora();
			ProfesoriTable.getInstance().resfreshTable();
			ProfesoriTablePane.setSelectedRow(-1);
			ToolBar.getInstance().setSelectedButton();
			
		}
		
	}

}
