package rs.ac.uns.ftn.oisisi.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.Predmet;
import rs.ac.uns.ftn.oisisi.model.Profesor;
import rs.ac.uns.ftn.oisisi.model.Student;
import rs.ac.uns.ftn.oisisi.view.DijalogStudentNaPredmet;
import rs.ac.uns.ftn.oisisi.view.GlavniProzor;
import rs.ac.uns.ftn.oisisi.view.IzmjenaPredmetaDijalog;
import rs.ac.uns.ftn.oisisi.view.PredmetiTable;
import rs.ac.uns.ftn.oisisi.view.PredmetiTablePane;
import rs.ac.uns.ftn.oisisi.view.TabelaIndeksa;
import rs.ac.uns.ftn.oisisi.view.ToolBar;

public class PredmetiController {

	private static PredmetiController instance = null;

	public static PredmetiController getInstance() {
		if (instance == null) {
			instance = new PredmetiController();
		}
		return instance;
	}

	public boolean dodajProfesoraNaPredmet(Profesor profesor) {
		return BazaPredmeta.getInstance().dodajProfesoraNaPredmet(profesor);
	}

	public void obrisiProfesoraSaPredmeta() {
		BazaPredmeta.getInstance().obrisiProfesoraSaPredmeta();

	}

	public boolean dodajPredmet(String col[]) {
		boolean d = BazaPredmeta.getInstance().dodajPredmet(col);
		return d;

	}

	public void saveData() throws IOException {
		BazaPredmeta.getInstance().sacuvajPredmet();
	}

	public void loadData() throws IOException {
		BazaPredmeta.getInstance().loadPredmete();

	}

	public void izmjenaPredmeta() {

			
		



		int selectedRow = PredmetiTable.getInstance().getSelectedRow();

		if (selectedRow >= 0 && selectedRow < BazaPredmeta.getBrojUnijetihPredmeta()
				&& BazaPredmeta.getBrojPredmetaKojiSuUPretrazi() == 0) {

			IzmjenaPredmetaDijalog dijalog = new IzmjenaPredmetaDijalog(GlavniProzor.getInstance(), "Izmjena predmeta",
					true);
			dijalog.setVisible(true);
		} else if (selectedRow >= 0 && selectedRow < BazaPredmeta.getBrojPredmetaKojiSuUPretrazi()) {
			IzmjenaPredmetaDijalog dijalog = new IzmjenaPredmetaDijalog(GlavniProzor.getInstance(), "Izmjena predmeta",
					true);
			dijalog.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Predmet nije selektovan!", "Greska",
					JOptionPane.ERROR_MESSAGE);

		}
	}

	public void pretragaPredmeta() {
		String input = ToolBar.getInstance().getSearchField().getText();

		BazaPredmeta.getInstance().pretraziPredmet(input);

		PredmetiTable.getInstance().refreshTable();
	}

	public void brisanjePredmeta() {
		int selectedRow = PredmetiTablePane.selectedRow;
		if (selectedRow >= 0 && selectedRow < BazaPredmeta.getBrojUnijetihPredmeta()
				&& BazaPredmeta.getBrojPredmetaKojiSuUPretrazi() == 0) {

			int biraj = JOptionPane.showConfirmDialog(GlavniProzor.getInstance(), "Da li sigurno brisete predmet?",
					"Brisanje predmeta", JOptionPane.YES_NO_OPTION);

			if (biraj == JOptionPane.YES_OPTION) {
				BazaPredmeta.getInstance().obrisiPredmet(selectedRow);
			}
		} else if (selectedRow >= 0 && selectedRow < BazaPredmeta.getBrojPredmetaKojiSuUPretrazi()) {
			int biraj = JOptionPane.showConfirmDialog(GlavniProzor.getInstance(), "Da li sigurno brisete predmet",
					"Brisanje predmeta", JOptionPane.YES_NO_OPTION);

			if (biraj == JOptionPane.YES_OPTION) {
				Predmet p = BazaPredmeta.getInstance().getRezultat().get(selectedRow);
				BazaPredmeta.getInstance().getRezultat().remove(selectedRow);
				BazaPredmeta.getInstance().smanjiBrojPredmetaKojiSuUPretrazi();
				BazaPredmeta.getInstance().brisiPoKljucu(p.getSifraPredmeta());
			} else {
				JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Niste odabrali predmet.", "Greska",
						JOptionPane.ERROR_MESSAGE);

			}
		}

	}

	public boolean postojiStudentSaIndeksom(String p, int row) {
		return BazaPredmeta.getInstance().proveraStudenta(p, row);
	}

	public Predmet getPredmetPoIndeksu(int i) {
		if (BazaPredmeta.getBrojUnijetihPredmeta() != 0 && BazaPredmeta.getBrojPredmetaKojiSuUPretrazi() == 0) {
			return BazaPredmeta.getInstance().getPredmeti().get(i);

		} else {
			return BazaPredmeta.getInstance().getRezultat().get(i);
		}
	}

	public void dodavanjeStudentaNaPredmet() {
		int red = PredmetiTable.getInstance().getSelectedRow();

		if (red >= 0 && red < BazaPredmeta.getBrojUnijetihPredmeta()) {
			DijalogStudentNaPredmet dijalog = new DijalogStudentNaPredmet(GlavniProzor.getInstance(),
					"Dodavanje studenta na predmet", true);
			dijalog.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Selektujte predmet!", "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void IzbrisiStudentaSaPredmeta() {
		int selektovanPredmet = PredmetiTablePane.getSelectedRow();
		int selektovanStudent = TabelaIndeksa.getInstance().getSelectedRow();
		String ret[] = null;
		if (selektovanStudent != -1) {
			int pritisnuo = JOptionPane.showConfirmDialog(GlavniProzor.getInstance(),
					"Da li ste sigurni da zelite da obrisete studenta?", "Brisanje Studenta",
					JOptionPane.YES_NO_OPTION);
			if (pritisnuo == JOptionPane.YES_OPTION) {
				ret = BazaPredmeta.getInstance().IzbrisiStudentaSaPredmeta(selektovanPredmet, selektovanStudent);
				StudentiController.getInstance().IzbrisiPredmetStudentu(ret[0], ret[1]);
				TabelaIndeksa.getInstance().refreshTable();
				JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Uspjesno brisanje studenta", "Potvrdi",
						JOptionPane.INFORMATION_MESSAGE);

			}

		} else {
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Student nije selektovan", "Greska",
					JOptionPane.ERROR_MESSAGE);

		}

	}

	

	public void dodavanjeStudetaNaPredmet1(Student s, int row, Predmet predmet) {
		BazaPredmeta.getInstance().dodajStudentaNaPredmet(s, row, predmet);

	}

}
