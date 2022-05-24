package rs.ac.uns.ftn.oisisi.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisisi.model.BazaProfesora;
import rs.ac.uns.ftn.oisisi.model.Profesor;
import rs.ac.uns.ftn.oisisi.view.GlavniProzor;
import rs.ac.uns.ftn.oisisi.view.IzmjenaProfesoraDijalog;
import rs.ac.uns.ftn.oisisi.view.ProfesoriTable;
import rs.ac.uns.ftn.oisisi.view.ToolBar;

public class ProfesoriController {
	private static ProfesoriController instance = null;

	public static ProfesoriController getInstance() {
		if (instance == null) {
			instance = new ProfesoriController();
		}
		return instance;
	}

	

	

	public void izmjenaProfesora() {
		
		int row = ProfesoriTable.getInstance().getSelectedRow();
		
		if(row >= 0 && row < BazaProfesora.getBrojUnijetihProfesora()){
			IzmjenaProfesoraDijalog d = new IzmjenaProfesoraDijalog(GlavniProzor.getInstance(), "Izmjena profesora", true);
			d.setVisible(true);
		}
		else{
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(),"Profesor nije selektovan","GRESKA",JOptionPane.ERROR_MESSAGE);
		}
		
	
	}

	public void pretragaProfesora() {
		String input = ToolBar.getInstance().getSearchField().getText();

		BazaProfesora.getInstance().pretraziProfesora(input);

		ProfesoriTable.getInstance().resfreshTable();
	}

	public void brisanjeProfesora() {
		int selectedRow = ProfesoriTable.getInstance().getSelectedRow();
		if (selectedRow >= 0 && selectedRow < BazaProfesora.getBrojUnijetihProfesora()
				&& BazaProfesora.getBrojProfesoraKojiSuUPretrazi() == 0) {

			int biraj = JOptionPane.showConfirmDialog(GlavniProzor.getInstance(), "Da li sigurno brisete profesora?",
					"Brisanje profesora", JOptionPane.YES_NO_OPTION);

			if (biraj == JOptionPane.YES_OPTION) {
				BazaProfesora.getInstance().obrisiProfesora(selectedRow);
			}
		} else if (selectedRow >= 0 && selectedRow < BazaProfesora.getBrojProfesoraKojiSuUPretrazi()) {
			int biraj = JOptionPane.showConfirmDialog(GlavniProzor.getInstance(), "Da li sigurno brisete profesora",
					"Brisanje profesora", JOptionPane.YES_NO_OPTION);

			if (biraj == JOptionPane.YES_OPTION) {
				Profesor p = BazaProfesora.getInstance().getRezultat().get(selectedRow);
				BazaProfesora.getInstance().getRezultat().remove(selectedRow);
				BazaProfesora.getInstance().smanjiBrojProfesoraKojiSuUPretrazi();
				BazaProfesora.getInstance().brisiPoKljucu(p.getBrojLicneKarte());
			} else {
				JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Niste odabrali profesora.", "Greska",
						JOptionPane.ERROR_MESSAGE);

			}
		}

	}



	public boolean dodajProfesor(String unos[]) {
		boolean ret = BazaProfesora.getInstance().dodajProfesora(unos);
		return ret;
	}
	
	public void loadData() throws IOException {
		BazaProfesora.getInstance().loadProfesora();

	}
	public void saveData() throws IOException {
		BazaProfesora.getInstance().sacuvajProfesora();
	}

	public boolean dodajPredmetNaProfesora(String text) {
		
		return BazaProfesora.getInstance().dodajPredmetNaProfesora(text);
	}


	public void obrisiPredmetSaProfesora() {
		BazaProfesora.getInstance().obrisiPredmetSaProfesora();
		
	}

}
