package rs.ac.uns.ftn.oisisi.model;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisisi.view.GlavniProzor;
import rs.ac.uns.ftn.oisisi.view.PredmetiTablePane;

public class BazaPredmeta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1062741159611725946L;



	private static BazaPredmeta instance;
	private static int brojPredmetaKojiSuUPretrazi = 0;

	public static int getBrojPredmetaKojiSuUPretrazi() {
		return brojPredmetaKojiSuUPretrazi;
	}

	// ovo sada radi? pokreni program,mislim da nece :D
	// mislio sam da nece jer si isla serijalizaciju na prazan kad si iskljucivala :D mislio sam da ce da ponisti ali nije,nego
	//mogu pogledam projekat? 1min
	//naravno i HVALA PUNOO!!! :)
	//nistaa bree uzivaj 
	// kako si stavila JTable da bude prosiren do dole,meni ga kako se to kazeee aa assign na broj studenata
	//Cek ne kontam sta mislis
	
	public static void setBrojPredmetaKojiSuUPretrazi(int brojPredmetaKojiSuUPretrazi) {
		BazaPredmeta.brojPredmetaKojiSuUPretrazi = brojPredmetaKojiSuUPretrazi;
	}

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}

	private static int brojUnijetihPredmeta = 0;

	private ArrayList<String> naziviKolona;
	private ArrayList<Predmet> predmeti;
	private ArrayList<Predmet> rezultat;

	private int BrojStudenataNaPredmetu = 0;

	private BazaPredmeta() {
		super();
		naziviKolona = new ArrayList<String>();
		predmeti = new ArrayList<Predmet>();
		rezultat = new ArrayList<Predmet>();
		naziviKolona.add("Sifra predmeta");
		naziviKolona.add("Naziv predmeta");
		naziviKolona.add("Semestar");
		naziviKolona.add("Godina izvodjenja");
		naziviKolona.add("Profesor");
		naziviKolona.add("Studenti");
	}

	public ArrayList<String> getNaziviKolona() {
		return naziviKolona;
	}

	public void setNaziviKolona(ArrayList<String> naziviKolona) {
		this.naziviKolona = naziviKolona;
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public static void setInstance(BazaPredmeta instance) {
		BazaPredmeta.instance = instance;
	}

	public static void setBrojUnijetihPredmeta(int brojUnijetihPredmeta) {
		BazaPredmeta.brojUnijetihPredmeta = brojUnijetihPredmeta;
	}

	public static int getBrojUnijetihPredmeta() {
		return brojUnijetihPredmeta;
	}

	public String getValueA(int row, int colon) {
		ArrayList<Predmet> temp;
		if (rezultat.size() == 0) {
			temp = predmeti;
		} else {
			temp = rezultat;
		}
		if (row < temp.size()) {
			Predmet predmet = temp.get(row);

			switch (colon) {
			case 0:
				return predmet.getSifraPredmeta();
			case 1:
				return predmet.getNazivPredmeta();
			case 2:
				return predmet.getSemestar();
			case 3:
				return predmet.getGodinaKadSeIzvodi();
			case 4:
				return "Profesori";
			case 5:
				return "Studenti";
			default:
				return null;
			}
		} else {
			return null;
		}
	}
	public void brisiPoKljucu(String kljuc) {
		int i = 0;
		
		for(; i < predmeti.size(); i++) {
			if(kljuc.equals(predmeti.get(i).getSifraPredmeta())) {
				break;
			}
		}
		predmeti.remove(i);
		
			}
	
	public void obrisiPredmet(int indeks) {
		predmeti.remove(indeks);
		brojUnijetihPredmeta--;
		
	}
	public boolean dodajPredmet(String col[]) {
		brojUnijetihPredmeta++;
		String kljuc = col[0];
		if (ovajNePostojiPredmet(kljuc)) {
			Predmet newPredmet = new Predmet(col[0], col[1], col[2], col[3]);
			predmeti.add(newPredmet);
			return true;
		}
		return false;
	}

	public boolean ovajNePostojiPredmet(String kljuc) {
		for (Predmet p : predmeti) {
			if (kljuc.equals(p.getSifraPredmeta())) {
				return false;
			}
		}
		return true;
	}

	public void sacuvajPredmet() throws IOException {
		try { ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("./data/predmetiFile.txt")); 
            out.writeObject(this.getPredmeti());  
            out.close();
      }catch(IOException e) {
          e.printStackTrace();
      }catch(Exception e) {
          e.printStackTrace();
      }
	}
	
	

	@SuppressWarnings("unchecked")
	public void loadPredmete() throws IOException {
		try {  ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("./data/predmetiFile.txt")); 
          this.setPredmeti((ArrayList<Predmet>)in.readObject()); 
          BazaPredmeta.setBrojUnijetihPredmeta(BazaPredmeta.getInstance().predmeti.size());
          
          in.close();
      }catch(FileNotFoundException e) {
      }
      catch(IOException e) {
          e.printStackTrace();
      }catch(Exception e) {
          e.printStackTrace();
      }

	}

	public void smanjiBrojPredmetaKojiSuUPretrazi() {
		brojPredmetaKojiSuUPretrazi--;
	}

	public void pretraziPredmet(String input) {
		if (input.trim().length() == 0) {
			rezultat.clear();
			brojPredmetaKojiSuUPretrazi = 0;
			return;
		}
		rezultat.clear();
		brojPredmetaKojiSuUPretrazi = 0;

		String podjelaUnosa[] = input.split(";");
		String s = podjelaUnosa[0];
		String[] obje = s.trim().split(":");
		if (obje.length != 2 || obje[1].trim().length() == 0) {
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Pretraga nije dobro napisana", "Greska",
					JOptionPane.ERROR_MESSAGE);
			return;

		}
		if (obje[0].toUpperCase().equals("SIFRA")) {
			for (Predmet p : predmeti) {
				if (p.getSifraPredmeta().toUpperCase().equals(obje[1].trim().toUpperCase())) {
					rezultat.add(p);
				}
			}
		} else if (obje[0].toUpperCase().equals("NAZIV")) {
			for (Predmet p : predmeti) {
				if (p.getNazivPredmeta().toUpperCase().equals(obje[1].trim().toUpperCase())) {
					rezultat.add(p);
				}
			}
		} else if (obje[0].toUpperCase().equals("SEMESTAR")) {
			for (Predmet p : predmeti) {
				if (p.getSemestar().toUpperCase().equals(obje[1].trim().toUpperCase())) {
					rezultat.add(p);
				}
			}
		} else if (obje[0].toUpperCase().equals("GODINA IZVODJENJA")) {
			for (Predmet p : predmeti) {
				if (p.getGodinaKadSeIzvodi().toUpperCase().equals(obje[1].trim().toUpperCase())) {
					rezultat.add(p);
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

				if (obje[0].toUpperCase().equals("SIFRA")) {
					for (Predmet p : predmeti) {
						if (!p.getSifraPredmeta().toUpperCase().equals(obje[1].trim().toUpperCase())) {
							rezultat.remove(p);
						}
					}
				} else if (obje[0].toUpperCase().equals("NAZIV")) {
					for (Predmet p : predmeti) {
						if (!p.getNazivPredmeta().toUpperCase().equals(obje[1].trim().toUpperCase())) {
							rezultat.remove(p);
						}
					}

				} else if (obje[0].toUpperCase().equals("SEMESTAR")) {
					for (Predmet p : predmeti) {
						if (!p.getSemestar().toUpperCase().equals(obje[1].trim().toUpperCase())) {
							rezultat.remove(p);
						}
					}
				} else if (obje[0].toUpperCase().equals("GODINA IZVODJENJA")) {
					for (Predmet p : predmeti) {
						if (!p.getGodinaKadSeIzvodi().toUpperCase().equals(obje[1].trim().toUpperCase())) {
							rezultat.remove(p);
						}
					}
				} else {
					JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Pretraga nije dobro napisana!", "Greska",
							JOptionPane.ERROR_MESSAGE);

					return;

				}
			}

		}
		brojPredmetaKojiSuUPretrazi = rezultat.size();

		if (rezultat.size() == 0) {
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Neuspjesna pretraga!", "Greska",
					JOptionPane.ERROR_MESSAGE);

		}
	}
	public Predmet vratiPredmetPoKljucu(String key) {
		Predmet povratka = null;
		for (Predmet p : predmeti) {
			if (p.getSifraPredmeta().equals(key)) {
				povratka = p;
			}
		}
		return povratka;

	}

	public ArrayList<Predmet> getRezultat() {
		return rezultat;
	}

	public void setRezultat(ArrayList<Predmet> rezultat) {
		this.rezultat = rezultat;
	}

	public boolean proveraStudenta(String p, int row) {
		if(BrojStudenataNaPredmetu != 0){
			for(Student s: predmeti.get(row).getStudenti()){
				if(s.getBrIndeksa().equals(p)){
					return false;
				}
			}
		}
		return true;
	}

	public void dodajStudentaNaPredmet(Student s, int row, Predmet predmet) {
		if(brojPredmetaKojiSuUPretrazi == 0){
			predmeti.get(row).getStudenti().add(s);
			BrojStudenataNaPredmetu++;
		}else{
			for(Predmet p : predmeti){
				if(p.getSifraPredmeta().equals(predmet.getSifraPredmeta())){
					p.getStudenti().add(s);
				}
			}
		}
		
	}
	public boolean dodajProfesoraNaPredmet(Profesor profesor) {
		// TODO Auto-generated method stub
		int selectedRow = PredmetiTablePane.getSelectedRow();
		Predmet predmet;
		if (brojPredmetaKojiSuUPretrazi == 0) {
			predmet = predmeti.get(selectedRow);
		} else {
			predmet = rezultat.get(selectedRow);
		}
		return predmet.dodajProfesoraNaPredmet(profesor);

	}
	public String[] IzbrisiStudentaSaPredmeta(int selektovanPredmet, int selektovanStudent) {
		String sifrIndeks[] = new String[2];

		sifrIndeks[0] = predmeti.get(selektovanPredmet).getSifraPredmeta();
		sifrIndeks[1] = predmeti.get(selektovanPredmet).getStudenti().get(selektovanStudent).getBrIndeksa();
		predmeti.get(selektovanPredmet).getStudenti().remove(selektovanStudent);
		BrojStudenataNaPredmetu--;
		return sifrIndeks;

	}

	

	

	public void obrisiProfesoraSaPredmeta() {
		int selectedPredmet = PredmetiTablePane.getSelectedRow();
		Predmet predmet = predmeti.get(selectedPredmet);
		predmet.setProfesor(null);
	}
	public void obrisiProfesoraSaPredmeta(String licna) {
		for (Predmet predmet : predmeti) {
			if (predmet.getProfesor() != null) {
				if (predmet.getProfesor().getBrojLicneKarte().equals(licna)) {
					predmet.setProfesor(null);
				}
			}
		}
	}
	

}
