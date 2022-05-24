package rs.ac.uns.ftn.oisisi.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Predmet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8043405206661376410L;
	private String sifraPredmeta;
	private String nazivPredmeta;
	private String semestar;
	private String godinaKadSeIzvodi;
	private Profesor profesor;
	private ArrayList<Student> studenti;

	public Predmet(String sifraPredmeta, String nazivPredmeta, String semestar, String godinaKadSeIzvodi) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaKadSeIzvodi = godinaKadSeIzvodi;
		this.profesor = null;
		this.setStudenti(new ArrayList<Student>());
	}

	public Predmet() {
		super();
	}

	public String getSifraPredmeta() {
		return sifraPredmeta;
	}

	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}

	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	public String getSemestar() {
		return semestar;
	}

	public void setSemestar(String semestar) {
		this.semestar = semestar;
	}

	public String getGodinaKadSeIzvodi() {
		return godinaKadSeIzvodi;
	}

	public void setGodinaKadSeIzvodi(String godinaKadSeIzvodi) {
		this.godinaKadSeIzvodi = godinaKadSeIzvodi;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	@Override
	public String toString() {
		return sifraPredmeta + " - " + nazivPredmeta + " - " + semestar + " - " + godinaKadSeIzvodi + " - " + profesor
				+ "\n";
	}

	public ArrayList<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}

	public boolean dodajProfesoraNaPredmet(Profesor prof) {

		if (this.profesor == null) {
			this.profesor = prof;
			return true;
		}

		return false;

	}

}
