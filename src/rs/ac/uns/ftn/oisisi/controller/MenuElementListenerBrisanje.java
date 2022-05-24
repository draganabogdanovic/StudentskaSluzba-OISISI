package rs.ac.uns.ftn.oisisi.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rs.ac.uns.ftn.oisisi.view.StudentiTable;
import rs.ac.uns.ftn.oisisi.view.TabbedPane;

public class MenuElementListenerBrisanje implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(TabbedPane.aktivanTab == 0) {
			
			StudentiController.getInstance().brisanjeStudenta();
			StudentiTable.getInstance().refreshTable();
			
		}
		
		
	}

}
