package rs.ac.uns.ftn.oisisi.controller;


import java.io.IOException;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.BazaStudent;
import rs.ac.uns.ftn.oisisi.model.Predmet;
import rs.ac.uns.ftn.oisisi.model.Student;
import rs.ac.uns.ftn.oisisi.view.GlavniProzor;
import rs.ac.uns.ftn.oisisi.view.IzmjenaStudentaDijalog;
import rs.ac.uns.ftn.oisisi.view.StudentiTable;
import rs.ac.uns.ftn.oisisi.view.StudentiTablePane;
import rs.ac.uns.ftn.oisisi.view.ToolBar;

public class StudentiController {
	
	static private StudentiController instance = null;
	
	static public StudentiController getInstance(){
		if(instance == null){
			instance = new StudentiController();
		}
		return instance;
		
	}

	public boolean DodajStudenta(String[] p) {
		
		return BazaStudent.getInstance().Dodavanje(p);
	}

	public void brisanjeStudenta() {
		int row = StudentiTablePane.getSelectedRow();

		if (row >= 0 && row < BazaStudent.getBrStudenata() && BazaStudent.getBrojStudenataUPretrazi() == 0) {
			int pritisnuo = JOptionPane.showConfirmDialog(GlavniProzor.getInstance(),
					"Da li ste sigurni da zelite da obrisete studenta?", "Brisanje Studenta",
					JOptionPane.YES_NO_OPTION);
			if (pritisnuo == JOptionPane.YES_OPTION) {
				if (BazaStudent.getInstance().getSpisakStudenata().get(row).getSpisakPredmeta().size() == 0) {

					BazaStudent.getInstance().BrisanjeStudenta(row);
				} else {

					for (Predmet predmet : BazaStudent.getInstance().getSpisakStudenata().get(row)
							.getSpisakPredmeta()) {

						for (int i = 0; i < BazaPredmeta.getInstance().getPredmeti().size(); i++) {
							if (BazaPredmeta.getInstance().getPredmeti().get(i).getSifraPredmeta().equals(predmet.getSifraPredmeta())) {

								for (int j = 0; j < BazaPredmeta.getInstance().getPredmeti().get(i).getStudenti().size(); j++) {

									if (BazaPredmeta.getInstance().getPredmeti().get(i).getStudenti().get(j)
											.getBrIndeksa().equals(BazaStudent.getInstance().getSpisakStudenata()
													.get(row).getBrIndeksa())) {
										BazaPredmeta.getInstance().getPredmeti().get(i).getStudenti().remove(j);

									}

								}
							}
						}
					}
					BazaStudent.getInstance().BrisanjeStudenta(row);
				}

			}

		} else if (row >= 0 && row < BazaStudent.getBrojStudenataUPretrazi()) {

			int pritisnuo = JOptionPane.showConfirmDialog(GlavniProzor.getInstance(),
					"Da li ste sigurni da zelite da obrisete studenta?", "Brisanje Studenta",
					JOptionPane.YES_NO_OPTION);
			if (pritisnuo == JOptionPane.YES_OPTION) {
				
				if (BazaStudent.getInstance().getRezultatPretrage().get(row).getSpisakPredmeta().size() == 0) {
					Student s = BazaStudent.getInstance().getRezultatPretrage().get(row);
					BazaStudent.getInstance().getRezultatPretrage().remove(row);
					BazaStudent.getInstance().smanjiBrojPretrage();
					BazaStudent.getInstance().brisanjePoIndeksu(s.getBrIndeksa());
				} else {

					for (Predmet predmet : BazaStudent.getInstance().getRezultatPretrage().get(row).getSpisakPredmeta()) {

						for (int i = 0; i < BazaPredmeta.getInstance().getPredmeti().size(); i++) {
							if (BazaPredmeta.getInstance().getPredmeti().get(i).getSifraPredmeta().equals(predmet.getSifraPredmeta())) {

								for (int j = 0; j < BazaPredmeta.getInstance().getPredmeti().get(i).getStudenti().size(); j++) {

									if (BazaPredmeta.getInstance().getPredmeti().get(i).getStudenti().get(j)
											.getBrIndeksa().equals(BazaStudent.getInstance().getRezultatPretrage().get(row)
													.getBrIndeksa())) {
										BazaPredmeta.getInstance().getPredmeti().get(i).getStudenti().remove(j);

									}

								}
							}
						}
					}

					Student s = BazaStudent.getInstance().getRezultatPretrage().get(row);
					BazaStudent.getInstance().getRezultatPretrage().remove(row);
					BazaStudent.getInstance().smanjiBrojPretrage();
					BazaStudent.getInstance().brisanjePoIndeksu(s.getBrIndeksa());

				}

			}

		} else {
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Student nije selektovan", "EROR",
					JOptionPane.ERROR_MESSAGE);
			;

		}

	}

	public void izmjenaStudenta() {
		int row = StudentiTablePane.getSelectedRow();
		System.out.println(row);

		if (row >= 0 && row < BazaStudent.getBrStudenata() && BazaStudent.getBrojStudenataUPretrazi() == 0) {

			IzmjenaStudentaDijalog d = new IzmjenaStudentaDijalog(GlavniProzor.getInstance(), "Izjmena studenta", true);
			d.setVisible(true);
		} else if (row >= 0 && row < BazaStudent.getBrStudenata()) {

			IzmjenaStudentaDijalog d = new IzmjenaStudentaDijalog(GlavniProzor.getInstance(), "Izjmena studenta", true);
			d.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Student nije selektovan", "Greska!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void saveData() throws IOException {
		BazaStudent.getInstance().saveStudenti();
		
	}

	public void loadData() throws IOException {
		BazaStudent.getInstance().loadStudent();
		
	}
	public void pretragaStudenta(){
		String ulaz = ToolBar.getInstance().getSearchField().getText();
		BazaStudent.getInstance().pretraziStudente(ulaz);
		StudentiTable.getInstance().refreshTable();
	}

	public boolean indeksPostoji(String p) {
				return BazaStudent.getInstance().ProveraIndeksa(p);
	}

	public Student getStudentPoIndeksu(String p) {
		if(BazaStudent.getBrStudenata() != 0){
			return BazaStudent.getInstance().getStudent(p);
		}
		return null;
	}

	public void dodavanjePredmetaStudenta(Predmet predmet, String p) {
		BazaStudent.getInstance().dodajPredmetStudentu(predmet,p);
		
	}

	public void IzbrisiPredmetStudentu(String sifraPredmeta, String brIndeksa) {
		BazaStudent.getInstance().izbrisiPredmetStudentu(sifraPredmeta, brIndeksa);
		
	}

	

}
