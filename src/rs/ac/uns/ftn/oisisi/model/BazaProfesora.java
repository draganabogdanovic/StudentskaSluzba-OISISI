package rs.ac.uns.ftn.oisisi.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisisi.controller.PredmetiController;
import rs.ac.uns.ftn.oisisi.model.Profesor;
import rs.ac.uns.ftn.oisisi.view.GlavniProzor;
import rs.ac.uns.ftn.oisisi.view.PredmetiTablePane;

public class BazaProfesora {
	
	private ArrayList<Profesor> profesoriLista;
	private ArrayList<Profesor> rezultati;
	private ArrayList<String> naziviKolona;
	private static BazaProfesora instance = null;
	private static int brojUnijetihProfesora = 0;
	private static int brojProfesoraKojiSuUPretrazi = 0;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}

	private BazaProfesora() {
		super();
		naziviKolona = new ArrayList<String>();
		profesoriLista = new ArrayList<Profesor>();
		rezultati = new ArrayList<Profesor>();
		naziviKolona.add("Broj licne karte");
		naziviKolona.add("Ime");
		naziviKolona.add("Prezime");
		naziviKolona.add("Datum rodjenja");
		naziviKolona.add("Adresa stanovanja");
		naziviKolona.add("Telefon");
		naziviKolona.add("Email");
		naziviKolona.add("Adresa kancelarije");
		naziviKolona.add("Titula");
		naziviKolona.add("Zvanje");
		naziviKolona.add("Spisak predmeta na kojima je profesor");

	}

	public static int getBrojUnijetihProfesora() {
		return brojUnijetihProfesora;
	}

	public static void setBrojUnijetihProfesora(int brojUnijetihProfesora) {
		BazaProfesora.brojUnijetihProfesora = brojUnijetihProfesora;
	}

	public ArrayList<String> getNaziviKolona() {
		return naziviKolona;
	}

	public void setNaziviKolona(ArrayList<String> naziviKolona) {
		this.naziviKolona = naziviKolona;
	}

	public ArrayList<Profesor> getProfesori() {
		return profesoriLista;
	}

	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesoriLista = profesori;
	}

	public static void setInstance(BazaProfesora instance) {
		BazaProfesora.instance = instance;
	}

	public String getValueA(int row, int colon) {
		ArrayList<Profesor> temp;
		if (rezultati.size() == 0) { 
			temp = profesoriLista;
		} else {
			temp = rezultati;
		}
		
		
		
		if (row < temp.size()) {
			Profesor profesor = temp.get(row);

			switch (colon) {
			case 0:
				return profesor.getBrojLicneKarte();
			case 1:
				return profesor.getIme();
			case 2:
				return profesor.getPrezime();
			case 3:
				return profesor.getDatumRodj();
			case 4:
				return profesor.getAdresaStanovanja();
			case 5:
				return profesor.getKontTelefon();
			case 6:
				return profesor.getEmail();
			case 7:
				return profesor.getAdresaKancelarije();
			case 8:
				return profesor.getTitula();
			case 9:
				return profesor.getZvanje();
			case 10:
				return "Predmeti";
			default:
				return null;
			}
		} else {
			return null;
		}
	}

	public void brisiPoKljucu(String kljuc) {
		int i = 0;

		for (; i < profesoriLista.size(); i++) {
			if (kljuc.equals(profesoriLista.get(i).getBrojLicneKarte())) {
				break;
			}
		}
		profesoriLista.remove(i);

	}

	public boolean dodajPredmetNaProfesora(String text) {
		int selectedRow = PredmetiTablePane.getSelectedRow();
		Predmet predmet;
		if (BazaPredmeta.getBrojPredmetaKojiSuUPretrazi() == 0) {
			predmet = PredmetiController.getInstance().getPredmetPoIndeksu(selectedRow);
		} else {
			predmet = BazaPredmeta.getInstance().getRezultat().get(selectedRow);
		}
		Profesor profesor = getProfesora(text.trim());

		for (Predmet p : profesor.getPredajeNaPredmetima()) {
			if (p.getSifraPredmeta().equals(predmet.getSifraPredmeta())) {
				return false;
			}
		}

		profesor.getPredajeNaPredmetima().add(predmet);

		return true;
	}

	public void obrisiPredmetSaProfesora(String sifraPredmeta) {
		for (Profesor profesor : profesoriLista) {
			for (Predmet predmet : profesor.getPredajeNaPredmetima()) {
				if (sifraPredmeta.equals(predmet.getSifraPredmeta())) {
					profesor.getPredajeNaPredmetima().remove(predmet);
					break;
				}
			}
		}

	}

	public void obrisiPredmetSaProfesora() {
		int selectedPredmet = PredmetiTablePane.getSelectedRow();

		Predmet predmet = BazaPredmeta.getInstance().getPredmeti().get(selectedPredmet);
		Profesor profesor = predmet.getProfesor();
		
		for (Predmet p : profesor.getPredajeNaPredmetima()) {
			System.out.println(p.getSifraPredmeta());
			if (p.getSifraPredmeta().trim().equals(predmet.getSifraPredmeta().trim())) {
				profesor.getPredajeNaPredmetima().remove(p);
				
				break;
			}
		}
	}
	public Profesor getProfesora(String licna) {
		Profesor prof = null;
		for (Profesor p : profesoriLista) {
			if (p.getBrojLicneKarte().trim().equals(licna)) {
				prof = p;
				break;
			}
		}
		return prof;

	}

	public void obrisiProfesora(int brojLicne) {
		profesoriLista.remove(brojLicne);
		brojUnijetihProfesora--;

	}

	public boolean dodajProfesora(String col[]) {
		String kljuc = col[7];
		if (provjeraPostojanjaProfesora(kljuc)) {
			Profesor newProfesor = new Profesor(col[0], col[1], col[2], col[3], col[4], col[5], col[6], col[7], col[8],
					col[9]);
			profesoriLista.add(newProfesor);
			brojUnijetihProfesora++;

			return true;
		}
		return false;
	}

	public boolean provjeraPostojanjaProfesora(String kljuc) {
		for (Profesor p : profesoriLista) {
			if (kljuc.equals(p.getBrojLicneKarte())) {
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public void loadProfesora() throws IOException {
		try {  ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("./data/profesoriFile.txt")); 
          this.setProfesori((ArrayList<Profesor>)in.readObject()); 
          BazaProfesora.setBrojUnijetihProfesora(BazaProfesora.getInstance().profesoriLista.size());
          in.close();
      }catch(FileNotFoundException e) {
      }
      catch(IOException e) {
          e.printStackTrace();
      }catch(Exception e) {
          e.printStackTrace();
      }

	}

	public void sacuvajProfesora() throws IOException {
		try { ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("./data/profesoriFile.txt")); 
            out.writeObject(this.getProfesoriLista());  
            out.close();
      }catch(IOException e) {
          e.printStackTrace();
      }catch(Exception e) {
          e.printStackTrace();
      }
	}

	public boolean profesorSaKljucemNePostoji(String key) {
		for (Profesor p : profesoriLista) {
			if (key.equals(p.getBrojLicneKarte())) {
				return false;
			}
		}
		return true;
	}


	public boolean DodajProf(String[] p) {
		String brLicneKarte = p[7];
		if (profesorSaKljucemNePostoji(brLicneKarte)) {
			brojUnijetihProfesora++;
			Profesor profesor = new Profesor(p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[7], p[8], p[9]);
			profesoriLista.add(profesor);
			return true;
		}
		return false;
	}

	public void smanjiBrojProfesoraKojiSuUPretrazi() {
		brojProfesoraKojiSuUPretrazi--;
	}

	public void pretraziProfesora(String input) {
		if (input.trim().length() == 0) {
			rezultati.clear();
			brojProfesoraKojiSuUPretrazi = 0;
			return;
		}
		rezultati.clear();
		brojProfesoraKojiSuUPretrazi = 0;

		String podjelaUnosa[] = input.split(";");
		String s = podjelaUnosa[0];
		String[] obje = s.trim().split(":");
		if (obje.length != 2 || obje[1].trim().length() == 0) {
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Pretraga nije dobro napisana", "Greska",
					JOptionPane.ERROR_MESSAGE);
			return;

		}

		if (obje[0].toUpperCase().equals("BROJ LICNE KARTE")) {
			for (Profesor p : profesoriLista) {
				if (p.getBrojLicneKarte().toUpperCase().equals(obje[1].trim().toUpperCase())) {

					rezultati.add(p);
				}
			}
		} else if (obje[0].toUpperCase().equals("IME")) {
			for (Profesor p : profesoriLista) {
				if (p.getIme().toUpperCase().equals(obje[1].trim().toUpperCase())) {
					rezultati.add(p);
				}
			}
		} else if (obje[0].toUpperCase().equals("PREZIME")) {
			for (Profesor p : profesoriLista) {
				if (p.getPrezime().toUpperCase().equals(obje[1].trim().toUpperCase())) {
					rezultati.add(p);
				}
			}
		} else if (obje[0].toUpperCase().equals("DATUM RODJENJA")) {
			for (Profesor p : profesoriLista) {
				if (p.getDatumRodj().toUpperCase().equals(obje[1].trim().toUpperCase())) {
					rezultati.add(p);
				}
			}
		} else if (obje[0].toUpperCase().equals("ADRESA STANOVANJA")) {
			for (Profesor p : profesoriLista) {
				if (p.getAdresaStanovanja().toUpperCase().equals(obje[1].trim().toUpperCase())) {
					rezultati.add(p);
				}
			}
		} else if (obje[0].toUpperCase().equals("TELEFON")) {
			for (Profesor p : profesoriLista) {
				if (p.getKontTelefon().toUpperCase().equals(obje[1].trim().toUpperCase())) {
					rezultati.add(p);
				}
			}
		} else if (obje[0].toUpperCase().equals("TITULA")) {
			for (Profesor p : profesoriLista) {
				if (p.getTitula().toUpperCase().equals(obje[1].trim().toUpperCase())) {
					rezultati.add(p);
				}
			}
		} else if (obje[0].toUpperCase().equals("ZVANJE")) {
			for (Profesor p : profesoriLista) {
				if (p.getZvanje().toUpperCase().equals(obje[1].trim().toUpperCase())) {
					rezultati.add(p);
				}
			}

		} else {
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Pretraga nije dobro napisana!", "Greska",
					JOptionPane.ERROR_MESSAGE);

			return;

		}
		if (podjelaUnosa.length > 1) {
			for (int i = 1; i < podjelaUnosa.length; i++) {
				s = podjelaUnosa[i];
				obje = s.trim().split(":");
				if (obje.length != 2 || obje[1].trim().length() == 0) {
					JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Pretraga nije dobra!", "Greska",
							JOptionPane.ERROR_MESSAGE);
					return;

				}

				if (obje[0].toUpperCase().equals("BROJ LICNE KARTE")) {
					for (Profesor p : profesoriLista) {
						if (p.getBrojLicneKarte().toUpperCase().equals(obje[1].trim().toUpperCase())) {

							rezultati.remove(p);
						}
					}
				} else if (obje[0].toUpperCase().equals("IME")) {
					for (Profesor p : profesoriLista) {
						if (p.getIme().toUpperCase().equals(obje[1].trim().toUpperCase())) {
							rezultati.remove(p);
						}
					}
				} else if (obje[0].toUpperCase().equals("PREZIME")) {
					for (Profesor p : profesoriLista) {
						if (p.getPrezime().toUpperCase().equals(obje[1].trim().toUpperCase())) {
							rezultati.remove(p);
						}
					}
				} else if (obje[0].toUpperCase().equals("DATUM RODJENJA")) {
					for (Profesor p : profesoriLista) {
						if (p.getDatumRodj().toUpperCase().equals(obje[1].trim().toUpperCase())) {
							rezultati.remove(p);
						}
					}
				} else if (obje[0].toUpperCase().equals("ADRESA STANOVANJA")) {
					for (Profesor p : profesoriLista) {
						if (p.getAdresaStanovanja().toUpperCase().equals(obje[1].trim().toUpperCase())) {
							rezultati.remove(p);
						}
					}
				} else if (obje[0].toUpperCase().equals("TELEFON")) {
					for (Profesor p : profesoriLista) {
						if (p.getKontTelefon().toUpperCase().equals(obje[1].trim().toUpperCase())) {
							rezultati.remove(p);
						}
					}
				} else if (obje[0].toUpperCase().equals("TITULA")) {
					for (Profesor p : profesoriLista) {
						if (p.getTitula().toUpperCase().equals(obje[1].trim().toUpperCase())) {
							rezultati.remove(p);
						}
					}
				} else if (obje[0].toUpperCase().equals("ZVANJE")) {
					for (Profesor p : profesoriLista) {
						if (p.getZvanje().toUpperCase().equals(obje[1].trim().toUpperCase())) {
							rezultati.remove(p);
						}
					}

				} else {
					JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Pretraga nije dobro napisana!", "Greska",
							JOptionPane.ERROR_MESSAGE);
					return;

				}
			}
		}

		brojProfesoraKojiSuUPretrazi = rezultati.size();

		if (rezultati.size() == 0) {
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Neuspjesna pretraga!", "Greska",
					JOptionPane.ERROR_MESSAGE);

		}
	}

	/*
	 * public boolean nepostojeciProfesor(String kljuc) { for(Profesor p :
	 * profesoriLista) { if(kljuc.equals(p.getBrojLicneKarte())){ return false; } }
	 * return true; }
	 */
	public void brisiPoLicnoj(String brojLicneKarte) {
		int i = 0;
		for (; i < profesoriLista.size(); i++) {
			if (brojLicneKarte.equals(profesoriLista.get(i).getBrojLicneKarte())) {
				break;
			}
		}

		profesoriLista.remove(i);

		brojUnijetihProfesora--;

	}

	public static int getBrojProfesoraKojiSuUPretrazi() {
		return brojProfesoraKojiSuUPretrazi;
	}

	public ArrayList<Profesor> getRezultat() {
		return rezultati;
	}

	public void setRezultat(ArrayList<Profesor> rezultat) {
		this.rezultati = rezultat;
	}


	public ArrayList<Profesor> getProfesoriLista() {
		return profesoriLista;
	}

	public void setProfesoriLista(ArrayList<Profesor> profesoriLista) {
		this.profesoriLista = profesoriLista;
	}

	public ArrayList<Profesor> getRezultati() {
		return rezultati;
	}

	public void setRezultati(ArrayList<Profesor> rezultati) {
		this.rezultati = rezultati;
	}

	public static void setBrojProfesoraKojiSuUPretrazi(int brojProfesoraKojiSuUPretrazi) {
		BazaProfesora.brojProfesoraKojiSuUPretrazi = brojProfesoraKojiSuUPretrazi;
	}
}