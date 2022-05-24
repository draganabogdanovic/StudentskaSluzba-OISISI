package rs.ac.uns.ftn.oisisi.view;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.Predmet;

public class IzmjenaPredmetaDijalog extends PredmetDijalog {

	
	
	private static final long serialVersionUID = -2755796959889445848L;
	private Predmet p;
	private Predmet sviPredmeti = null ;
	
	public IzmjenaPredmetaDijalog(Frame f, String s, boolean m) {
		super(f,s,m);
		int selectedRow = PredmetiTable.getInstance().getSelectedRow();
		
		
		p = BazaPredmeta.getInstance().getPredmeti().get(selectedRow);
			
		
		textNazivPredmeta.setText(p.getNazivPredmeta());
		textSifrePredmeta.setText(p.getSifraPredmeta());
		semestar.setSelectedItem(p.getSemestar());
		godina.setSelectedItem(p.getGodinaKadSeIzvodi());
		
		potvrdaButton.addActionListener(new ActionListener() {
			
			@Override
		public void actionPerformed(ActionEvent e) {
				String unos[] = prikupiUnos();
				if(!p.getSifraPredmeta().equals(unos[0])) {
					if(!BazaPredmeta.getInstance().ovajNePostojiPredmet(unos[0])) {
						JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Predmet Vam vec postoji", "Greska", JOptionPane.ERROR_MESSAGE);
					return;
					
						
					}
				}
					if(sviPredmeti != null) {
						sviPredmeti.setSifraPredmeta(unos[0]);
						sviPredmeti.setNazivPredmeta(unos[1]);
						sviPredmeti.setSemestar(unos[2]);
						sviPredmeti.setGodinaKadSeIzvodi(unos[3]);
					}
					p.setSifraPredmeta(unos[0]);
					p.setNazivPredmeta(unos[1]);
					p.setSemestar(unos[2]);
					p.setGodinaKadSeIzvodi(unos[3]);
					
					dispose();
					PredmetiTable.getInstance().refreshTable();
					JOptionPane.showMessageDialog((Component) e.getSource(), "Uspjesno ste izmjenili predmet.");
					
					
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
