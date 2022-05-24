package rs.ac.uns.ftn.oisisi.controller;



import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import rs.ac.uns.ftn.oisisi.view.MenuBar;
import rs.ac.uns.ftn.oisisi.view.PredmetiTablePane;
import rs.ac.uns.ftn.oisisi.view.ProfesoriTablePane;
import rs.ac.uns.ftn.oisisi.view.StudentiTablePane;
import rs.ac.uns.ftn.oisisi.view.TabbedPane;
import rs.ac.uns.ftn.oisisi.view.ToolBar;

public class TabbedPaneListener implements ChangeListener{

	@Override
	public void stateChanged(ChangeEvent e) {
		TabbedPane tabbedPane = (TabbedPane) e.getSource();
		ToolBar toolBar = ToolBar.getInstance();
		toolBar.paintComponents(toolBar.getTip(TabbedPane.aktivanTab=tabbedPane.getSelectedIndex()));
		ToolBar.getInstance().getSearchField().setText("");
		
		PredmetiController.getInstance().pretragaPredmeta();
		ProfesoriController.getInstance().pretragaProfesora();
		StudentiController.getInstance().pretragaStudenta();
		
		PredmetiTablePane.setSelectedRow(-1);
		ProfesoriTablePane.setSelectedRow(-1);
		StudentiTablePane.setSelectedRow(-1);
		MenuBar.getInstance().brisanjeIzmjenaProvjera(TabbedPane.aktivanTab);
		
		
		}
	
	

}
