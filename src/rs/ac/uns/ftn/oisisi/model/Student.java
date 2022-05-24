package rs.ac.uns.ftn.oisisi.model;


import java.io.Serializable;
import java.util.ArrayList;

enum GodinaStudija {I , II, III, IV}
	enum Status {B,S}

public class Student extends Osoba implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 318047792292681327L;
	private String brIndeksa;
	private String datumUpisa;
	//private double prosek;
	private GodinaStudija godStudija;
	private Status statusStudenta;
	private ArrayList<Predmet> spisakPredmeta;
	
	
	public Student(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String brIndeksa, String datumUpisa, GodinaStudija godStudija,
			Status statusStudenta) {
		super(ime, prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, email);
		this.brIndeksa = brIndeksa;
		this.datumUpisa = datumUpisa;
		//this.prosek = prosek;
		this.godStudija = godStudija;
		this.statusStudenta = statusStudenta;
		this.spisakPredmeta= new ArrayList<Predmet>();
	}


	public String getBrIndeksa() {
		return brIndeksa;
	}


	public void setBrIndeksa(String brIndeksa) {
		this.brIndeksa = brIndeksa;
	}


	public String getDatumUpisa() {
		return datumUpisa;
	}


	public void setDatumUpisa(String datumUpisa) {
		this.datumUpisa = datumUpisa;
	}


	/*public double getProsek() {
		return prosek;
	}


	public void setProsek(double prosek) {
		this.prosek = prosek;
	}*/
	public GodinaStudija getGodStudija() {
		return godStudija;
	}


	public void setGodStudija(GodinaStudija godStudija) {
		this.godStudija = godStudija;
	}


	public Status getStatusStudenta() {
		return statusStudenta;
	}


	public void setStatusStudenta(Status statusStudenta) {
		this.statusStudenta = statusStudenta;
	}


	public ArrayList<Predmet> getSpisakPredmeta() {
		return spisakPredmeta;
	}


	public void setSpisakPredmeta(ArrayList<Predmet> spisakPredmeta) {
		this.spisakPredmeta = spisakPredmeta;
	}
	
	public String getStatusS() {
		switch (statusStudenta) {
		case B:
			return "B";
		case S:
			return "S";
		default:
			return null;
		}
	}
		
	public String getGodinaS() {
		switch (godStudija) {
		case I:
			return "I";
		case II:
			return "II";
		case III:
			return "III";
		case IV:
			return "IV";
		default:
			return null;
		}
	}
	
	
	/*public String getProsekS() {
		String a= Double.toString(prosek);
		return a;
	}
	*/
	public void setGodinaS(String s){
		switch (s) {
		case "I":
			godStudija = GodinaStudija.I;
			break;
		case "II":
			godStudija = GodinaStudija.II;
			break;
		case "III":
			godStudija = GodinaStudija.III;
			break;
		case "IV":
			godStudija = GodinaStudija.IV;
			break;
		
		default:
			break;
		}
	}
	
	public void setStatus(String s){
		switch (s) {
		case "B":
			statusStudenta = Status.B;
			break;
		case "S":
			statusStudenta = Status.S;
		default:
			break;
		}
	}


	@Override
	public String toString() {
		return ime +"--" +prezime+ "--"+datumRodj+"--"+adresaStanovanja+"--"+kontTelefon+"--"+email+"--"+brIndeksa+"--" +datumUpisa+ "--" +godStudija+"--"+ statusStudenta + "\n";
	}



	
	
	
	
	

}