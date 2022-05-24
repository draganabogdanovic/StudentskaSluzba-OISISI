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

public class BazaStudent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static BazaStudent instance = null;
	private ArrayList<String> colon;
	private ArrayList<Student> spisakStudenata;

	private ArrayList<Student> rezultatPretrage;
	private static int brPredmeta = 0;
	private static int brojStudenataUPretrazi = 0;
	private static int brStudenata = 0;

	public static BazaStudent getInstance() {
		if (instance == null) {
			instance = new BazaStudent();
		}
		return instance;
	}

	private BazaStudent() {
		colon = new ArrayList<String>();
		spisakStudenata = new ArrayList<Student>();
		rezultatPretrage = new ArrayList<>();
		colon.add("Broj indeksa");
		colon.add("Ime");
		colon.add("Prezime");
		colon.add("Godina studija");
		colon.add("Status");
		// colon.add("Prosek");
		colon.add("Email");
		colon.add("Datum upisa");
		colon.add("Datum rodjenja");
		colon.add("Adresa");
		colon.add("Kontakt telefon");
		colon.add("Spisak predmeta");

	}

	public ArrayList<String> getColon() {
		return colon;
	}

	public void setColon(ArrayList<String> colon) {
		this.colon = colon;
	}

	public ArrayList<Student> getSpisakStudenata() {
		return spisakStudenata;
	}

	public void setSpisakStudenata(ArrayList<Student> spisakStudenata) {
		this.spisakStudenata = spisakStudenata;
	}

	public String getValueAt(int row, int colon) {
		ArrayList<Student> temp;
		if (rezultatPretrage.size() == 0) {
			temp = spisakStudenata;
		} else {
			temp = rezultatPretrage;
		}

		if (row < temp.size()) {
			Student student = temp.get(row);
			switch (colon) {
			case 0:
				return student.getBrIndeksa();
			case 1:
				return student.getIme();
			case 2:
				return student.getPrezime();
			case 3:
				return student.getGodinaS();
			case 4:
				return student.getStatusS();
			case 5:
				return student.getEmail();
			case 6:
				return student.getDatumUpisa();
			case 7:
				return student.getDatumRodj();
			case 8:
				return student.getAdresaStanovanja();
			case 9:
				return student.getKontTelefon();
			case 10:
				return "Predmeti:";
			default:
				return null;
			}
		} else {
			return null;
		}

	}

	public static int getBrStudenata() {
		return brStudenata;
	}

	public static void setBrStudenata(int brStudenata) {
		BazaStudent.brStudenata = brStudenata;
	}

	public void BrisanjeStudenta(int row) {
		spisakStudenata.remove(row);
		brStudenata--;

	}
	
	public boolean Dodavanje(String[] p) {
		String index = p[6];

		if (ProveraIndeksa(index)) {
			brStudenata++;

			Student s = new Student(p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[7], GodinaStudija.valueOf(p[8]),
					Status.valueOf(p[9]));
			spisakStudenata.add(s);
			return true;
		}
		return false;
	}

	public boolean ProveraIndeksa(String index) {
		for (Student s : spisakStudenata) {
			if (s.getBrIndeksa().equals(index)) {
				return false;
			}
		}
		return true;
	}

	public void DodavanjeObjecta(Student s) {
		brStudenata++;
		spisakStudenata.add(s);
	}
	
	public void saveStudenti() {
		try { ObjectOutputStream out = new ObjectOutputStream(
		          new FileOutputStream("./data/studentiFile.txt")); 
		      out.writeObject(this.getSpisakStudenata());
		      out.close();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void loadStudent() throws IOException {

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("./data/studentiFile.txt")); 
			this.setSpisakStudenata((ArrayList<Student>) in.readObject()); // cita
			BazaStudent.setBrStudenata(BazaStudent.getInstance().getSpisakStudenata().size());

			
			in.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void pretraziStudente(String input) {
		if (input.trim().length() == 0) {
			rezultatPretrage.clear();
			setBrojStudenataUPretrazi(0);
			return;
		}

		rezultatPretrage.clear();
		setBrojStudenataUPretrazi(0);

		String[] podjelaUnosa = input.split(";");
		String s = podjelaUnosa[0];
		String[] both = s.trim().split(":");
		if (both.length != 2 || both[1].trim().length() == 0) {
			// PROVJERAVAM DA LI JE UNIJETO TO STO SE TRAZI
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Pretraga nije dobro napisana", "Greska",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (both[0].toUpperCase().equals("BROJ INDEKSA")) {
			for (Student student : spisakStudenata) {
				if (student.getBrIndeksa().toUpperCase().equals(both[1].trim().toUpperCase())) {
					rezultatPretrage.add(student);
				}
			}
		} else if (both[0].toUpperCase().equals("IME")) {
			for (Student student : spisakStudenata) {
				if (student.getIme().toUpperCase().equals(both[1].trim().toUpperCase())) {
					rezultatPretrage.add(student);
				}
			}
		} else if (both[0].toUpperCase().equals("PREZIME")) {
			for (Student student : spisakStudenata) {
				if (student.getPrezime().toUpperCase().equals(both[1].trim().toUpperCase())) {
					rezultatPretrage.add(student);

				}
			}
		} else if (both[0].toUpperCase().equals("GODINA STUDIJA")) {
			for (Student student : spisakStudenata) {
				if (student.getPrezime().toUpperCase().equals(both[1].trim().toUpperCase())) {
					rezultatPretrage.add(student);
				}
			}
		} else if (both[0].toUpperCase().equals("STATUS")) {
			for (Student student : spisakStudenata) {
				if (student.getStatusS().toUpperCase().equals(both[1].trim().toUpperCase())) {
					rezultatPretrage.add(student);
				}
			}

		} else if (both[0].toUpperCase().equals("EMAIL")) {
			for (Student student : spisakStudenata) {
				if (student.getEmail().toUpperCase().equals(both[1].trim().toUpperCase())) {
					rezultatPretrage.add(student);
				}
			}
		} else if (both[0].toUpperCase().equals("DATUM UPISA")) {
			for (Student student : spisakStudenata) {
				if (student.getDatumUpisa().toUpperCase().equals(both[1].trim().toUpperCase())) {
					rezultatPretrage.add(student);
				}
			}
		} else if (both[0].toUpperCase().equals("DATUM RODJENJA")) {
			for (Student student : spisakStudenata) {
				if (student.getDatumRodj().toUpperCase().equals(both[1].trim().toUpperCase())) {
					rezultatPretrage.add(student);
				}
			}
		} else if (both[0].toUpperCase().equals("ADRESA STANOVANJA")) {
			for (Student student : spisakStudenata) {
				if (student.getPrezime().toUpperCase().equals(both[1].trim().toUpperCase())) {
					rezultatPretrage.add(student);
				}
			}
		} else if (both[0].toUpperCase().equals("KONTAKT TELEFON")) {
			for (Student student : spisakStudenata) {
				if (student.getKontTelefon().toUpperCase().equals(both[1].trim().toUpperCase())) {
					rezultatPretrage.add(student);
				}
			}
		} else {
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Netacna pretraga!", "Greska",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (podjelaUnosa.length > 1) {
			for (int i = 1; i < podjelaUnosa.length; i++) {
				s = podjelaUnosa[i];
				both = s.trim().split(":");
				if (both.length != 2 || both[1].trim().length() == 0) {
					JOptionPane.showConfirmDialog(GlavniProzor.getInstance(), "Pretraga nije dobro napisana", "Greska",
							JOptionPane.ERROR_MESSAGE);
					return;

				}
				if (both[0].toUpperCase().equals("BROJ INDEKSA")) {
					for (Student student : spisakStudenata) {
						if (!student.getBrIndeksa().toUpperCase().equals(both[1].trim().toUpperCase())) {
							rezultatPretrage.remove(student);
						}
					}
				} else if (both[0].toUpperCase().equals("IME")) {
					for (Student student : spisakStudenata) {
						if (!student.getIme().toUpperCase().equals(both[1].trim().toUpperCase())) {
							rezultatPretrage.remove(student);
						}
					}
				} else if (both[0].toUpperCase().equals("PREZIME")) {
					for (Student student : spisakStudenata) {
						if (!student.getPrezime().toUpperCase().equals(both[1].trim().toUpperCase())) {
							rezultatPretrage.remove(student);
						}
					}
				} else if (both[0].toUpperCase().equals("GODINA STUDIJA")) {
					for (Student student : spisakStudenata) {
						if (!student.getGodinaS().toUpperCase().equals(both[1].trim().toUpperCase())) {
							rezultatPretrage.remove(student);
						}
					}
				} else if (both[0].toUpperCase().equals("STATUS")) {
					for (Student student : spisakStudenata) {
						if (!student.getStatusS().toUpperCase().equals(both[1].trim().toUpperCase())) {
							rezultatPretrage.remove(student);
						}
					}

				} else if (both[0].toUpperCase().equals("EMAIL")) {
					for (Student student : spisakStudenata) {
						if (!student.getEmail().toUpperCase().equals(both[1].trim().toUpperCase())) {
							rezultatPretrage.remove(student);
						}
					}
				} else if (both[0].toUpperCase().equals("DATUM UPISA")) {
					for (Student student : spisakStudenata) {
						if (!student.getDatumUpisa().toUpperCase().equals(both[1].trim().toUpperCase())) {
							rezultatPretrage.remove(student);
						}
					}
				} else if (both[0].toUpperCase().equals("DATUM RODJENJA")) {
					for (Student student : spisakStudenata) {
						if (!student.getDatumRodj().toUpperCase().equals(both[1].trim().toUpperCase())) {
							rezultatPretrage.remove(student);
						}
					}
				} else if (both[0].toUpperCase().equals("ADRESA STANOVANJA")) {
					for (Student student : spisakStudenata) {
						if (!student.getAdresaStanovanja().toUpperCase().equals(both[1].trim().toUpperCase())) {
							rezultatPretrage.remove(student);
						}
					}
				} else if (both[0].toUpperCase().equals("KONTAKT TELEFON")) {
					for (Student student : spisakStudenata) {
						if (!student.getKontTelefon().toUpperCase().equals(both[1].trim().toUpperCase())) {
							rezultatPretrage.remove(student);
						}
					}
				} else {
					JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Pretraga nije dobro napisana!", "Greska",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			}

		}

		setBrojStudenataUPretrazi(rezultatPretrage.size());
		if (rezultatPretrage.size() == 0) {
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Neuspijasna pretraga", "Greska",
					JOptionPane.ERROR_MESSAGE);

		}

	}

	public static int getBrojStudenataUPretrazi() {
		return brojStudenataUPretrazi;
	}

	public void setBrojStudenataUPretrazi(int brojStudenataUPretrazi) {
		BazaStudent.brojStudenataUPretrazi = brojStudenataUPretrazi;
	}

	public void brisanjePoKljuci(String key) {
		int i = 0;
		for (; i < spisakStudenata.size(); i++) {
			if (key.equals(spisakStudenata.get(i).getBrIndeksa())) {
				break;
			}
		}
		spisakStudenata.remove(i);
	}

	public Student getStudent(String p) {
		Student student = null;
		for (Student s : spisakStudenata) {
			if (s.getBrIndeksa().equals(p)) {
				student = s;
			}
		}
		return student;
	}

	public void dodajPredmetStudentu(Predmet predmet, String index) {
		for (int i = 0; i < spisakStudenata.size(); i++) {
			if (spisakStudenata.get(i).getBrIndeksa().equals(index)) {
				spisakStudenata.get(i).getSpisakPredmeta().add(predmet);
				setBrPredmeta(getBrPredmeta() + 1);
			}
		}

	}

	public void izbrisiPredmetStudentu(String sifraPredmeta, String brIndeksa) {
		for (int i = 0; i < spisakStudenata.size(); i++) {
			if (spisakStudenata.get(i).getBrIndeksa().equals(brIndeksa)) {
				for (int j = 0; j < spisakStudenata.get(i).getSpisakPredmeta().size(); j++) {
					if (spisakStudenata.get(i).getSpisakPredmeta().get(j).getSifraPredmeta().equals(sifraPredmeta)) {
						spisakStudenata.get(i).getSpisakPredmeta().remove(j);
					}
				}

			}
		}

	}

	public ArrayList<Student> getRezultatPretrage() {
		return rezultatPretrage;
	}

	public void brisanjePoIndeksu(String brIndeksa) {
		int temp = -1;
		for (int i = 0; i < spisakStudenata.size(); i++) {
			if (spisakStudenata.get(i).getBrIndeksa().equals(brIndeksa)) {
				temp = i;
			}
		}
		if (temp != -1) {
			spisakStudenata.remove(temp);
			brStudenata--;
		}

	}

	public void smanjiBrojPretrage() {
		brojStudenataUPretrazi--;

	}

	public static int getBrPredmeta() {
		return brPredmeta;
	}

	public static void setBrPredmeta(int brPredmeta) {
		BazaStudent.brPredmeta = brPredmeta;
	}

}
