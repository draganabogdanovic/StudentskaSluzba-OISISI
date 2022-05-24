package rs.ac.uns.ftn.oisisi.model;

import java.io.Serializable;


public abstract class Osoba implements Serializable {
	
	private static final long serialVersionUID = 8915565259055837762L;

	protected String ime;
	protected String prezime;
	protected String datumRodj;
	protected String adresaStanovanja;
	protected String kontTelefon;
	protected String email;
	
	
	public Osoba(String ime, String prezime, String datumRodj, String adresaStanovanja, String kontTelefon, String email) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodj = datumRodj;
		this.adresaStanovanja = adresaStanovanja;
		this.kontTelefon = kontTelefon;
		this.email = email;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}


	public String getDatumRodj() {
		return datumRodj;
	}


	public void setDatumRodj(String datumRodj) {
		this.datumRodj = datumRodj;
	}


	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}


	public void setAdresaStanovanja(String adresa) {
		this.adresaStanovanja = adresa;
	}


	public String getKontTelefon() {
		return kontTelefon;
	}


	public void setKontTelefon(String kontTelefon) {
		this.kontTelefon = kontTelefon;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Osoba() {
		super();
	}
	
	
	
	
	

}
