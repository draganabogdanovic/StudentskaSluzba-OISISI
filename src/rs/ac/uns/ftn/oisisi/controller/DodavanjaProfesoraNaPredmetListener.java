package rs.ac.uns.ftn.oisisi.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.Predmet;
import rs.ac.uns.ftn.oisisi.view.DodavanjeProfesoraNaPredmetDialog;
import rs.ac.uns.ftn.oisisi.view.GlavniProzor;
import rs.ac.uns.ftn.oisisi.view.PredmetiTablePane;
import rs.ac.uns.ftn.oisisi.view.ToolBar;

public class DodavanjaProfesoraNaPredmetListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int selectedRow = PredmetiTablePane.getSelectedRow();
		
		if(selectedRow < 0) {
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Nije selektovan predmet!", "Greska",
					JOptionPane.ERROR_MESSAGE);
			ToolBar.getInstance().setSelectedButton();
			return;
			
		}
		
		
		Predmet predmet;
		if(BazaPredmeta.getBrojPredmetaKojiSuUPretrazi() == 0) {
			predmet = PredmetiController.getInstance().getPredmetPoIndeksu(selectedRow);
		} else {
			predmet = BazaPredmeta.getInstance().getRezultat().get(selectedRow);
			
		}
		
		
		if(predmet.getProfesor() == null) {
			DodavanjeProfesoraNaPredmetDialog dijalog = new DodavanjeProfesoraNaPredmetDialog(GlavniProzor.getInstance(), "Dodavanje profesora na predmet", true);
			dijalog.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Selektovani predmet ima predmetnog profesora.", "Greska", JOptionPane.ERROR_MESSAGE);
			ToolBar.getInstance().setSelectedButton();
		}
	}

}
