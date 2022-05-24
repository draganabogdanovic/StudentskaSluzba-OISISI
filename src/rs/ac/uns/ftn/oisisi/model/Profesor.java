package rs.ac.uns.ftn.oisisi.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Profesor extends Osoba implements Serializable {

	
		/**
	 * 
	 */
	private static final long serialVersionUID = -1717340517075419604L;
		private String adresaKancelarije;
		private String brojLicneKarte;
		//0private String adresaStanovanja;
		//private String telefon;
		private String titula;
		private String zvanje;
		private ArrayList<Predmet> predajeNaPredmetima;
		
		public Profesor() {
			super();
		
		}
		public Profesor(String ime, String prezime, String datumRodj, String adresaStanovanja, String kontTelefon,
				String email, String adresaKancelarije, String brojLicneKarte, String titula, String zvanje) {
			super(ime, prezime, datumRodj, adresaStanovanja, kontTelefon, email);
			predajeNaPredmetima = new ArrayList<Predmet>();
			this.adresaKancelarije = adresaKancelarije;
			this.brojLicneKarte = brojLicneKarte;
			this.titula = titula;
			this.zvanje = zvanje;
		}
		public String getAdresaKancelarije() {
			return adresaKancelarije;
		}
		public void setAdresaKancelarije(String adresaKancelarije) {
			this.adresaKancelarije = adresaKancelarije;
		}
		public String getBrojLicneKarte() {
			return brojLicneKarte;
		}
		public void setBrojLicneKarte(String brojLicneKarte) {
			this.brojLicneKarte = brojLicneKarte;
		}
		public String getTitula() {
			return titula;
		}
		public void setTitula(String titula) {
			this.titula = titula;
		}
		
		public String getZvanje() {
			return zvanje;
		}
		public void setZvanje(String zvanje) {
			this.zvanje = zvanje;
		}
		public ArrayList<Predmet> getPredajeNaPredmetima() {
			return predajeNaPredmetima;
		}
		public void setPredajeNaPredmetima(ArrayList<Predmet> predajeNaPredmetima) {
			this.predajeNaPredmetima = predajeNaPredmetima;
		}
		
		
		
		@Override
		public String toString() {
			return ime +"--" +prezime+ "--"+datumRodj+"--"+adresaStanovanja+"--"+kontTelefon+"--"+email+"--"+adresaKancelarije+"--"+brojLicneKarte+"--"+titula+"--"+zvanje;
		}

}
