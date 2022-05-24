package rs.ac.uns.ftn.oisisi.view;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


import rs.ac.uns.ftn.oisisi.model.BazaProfesora;
import rs.ac.uns.ftn.oisisi.model.Profesor;

public class IzmjenaProfesoraDijalog extends ProfesorDijalog {

	
	private static final long serialVersionUID = -2755796959889445848L;
	private Profesor p;
	//private Profesor sviProfesori = null ;
	
	public IzmjenaProfesoraDijalog(Frame f, String s, boolean m) {
		super(f,s,m);
		int selectedRow = ProfesoriTable.getInstance().getSelectedRow();
		
			p = BazaProfesora.getInstance().getProfesori().get(selectedRow);
			
			txtIme.setText(p.getIme());
			txtPrezime.setText(p.getPrezime());
			txtDatRodj.setText(p.getDatumRodj());
			txtAdresa.setText(p.getAdresaStanovanja());
			txtBrTel.setText(p.getKontTelefon());
			txtEmail.setText(p.getEmail());
			txtAdresaKanc.setText(p.getAdresaKancelarije());
			txtBrLicne.setText(p.getBrojLicneKarte());
			txtTitula.setText(p.getTitula());
			txtZvanje.setText(p.getZvanje());
			
		
		
		potvrdaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String unos[] = unosPodataka();
				if(!p.getBrojLicneKarte().equals(unos[7])) {
					if(!BazaProfesora.getInstance().provjeraPostojanjaProfesora(unos[7])) {
						JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Profesor vec postoji", "Greska", JOptionPane.ERROR_MESSAGE);
					return;
					
						
					}
				}
					
						p.setIme(unos[0]);
						p.setPrezime(unos[1]);
						p.setDatumRodj(unos[2]);
						p.setAdresaStanovanja(unos[3]);
					    p.setKontTelefon(unos[4]);
						p.setEmail(unos[5]);
						p.setAdresaKancelarije(unos[6]);
						p.setBrojLicneKarte(unos[7]);
						p.setTitula(unos[8]);
						p.setZvanje(unos[9]);
						
			
					
					
					
					dispose();
					ProfesoriTable.getInstance().resfreshTable();
					JOptionPane.showMessageDialog((Component) e.getSource(), "Uspijesna izmjena profesora!");
					
					
				}
			
			});
		
		odustaniButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				
			}
		});
	}

}