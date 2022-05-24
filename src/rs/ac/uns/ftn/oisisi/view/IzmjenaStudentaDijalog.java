package rs.ac.uns.ftn.oisisi.view;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisisi.model.BazaStudent;
import rs.ac.uns.ftn.oisisi.model.Student;

public class IzmjenaStudentaDijalog extends DialogStudent{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7882066676577231634L;
	private Student s;
	
	public IzmjenaStudentaDijalog(Frame parent,String title,boolean modal){
		super(parent,title,modal);
		
		int row = StudentiTable.getInstance().getSelectedRow();
		s = BazaStudent.getInstance().getSpisakStudenata().get(row);
		
		txtIme.setText(s.getIme());
		txtPrezime.setText(s.getPrezime());
		txtDatRodj.setText(s.getDatumRodj());
		txtAdresa.setText(s.getAdresaStanovanja());
		txtBrTel.setText(s.getKontTelefon());
		txtEmail.setText(s.getEmail());
		txtBrojIndeksa.setText(s.getBrIndeksa());
		txtEmail.setText(s.getEmail());
		txtDatumUp.setText(s.getDatumUpisa());
		godinaS.setSelectedItem(s.getGodinaS());
		if(s.getStatusS() == "S")
			samofinansiranje.setSelected(true);
		else
			budzet.setSelected(true);
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pod[] = podaci();
				if(!s.getBrIndeksa().contentEquals(pod[6])){
					if(!BazaStudent.getInstance().ProveraIndeksa(pod[6])){
						
						JOptionPane.showMessageDialog(GlavniProzor.getInstance(),"Postoji student sa datim indeksom","Greska",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				s.setIme(pod[0]);
				s.setPrezime(pod[1]);
				s.setDatumRodj(pod[2]);
				s.setAdresaStanovanja(pod[3]);
				s.setKontTelefon(pod[4]);
				s.setEmail(pod[5]);
				s.setBrIndeksa(pod[6]);
				s.setDatumUpisa(pod[7]);
				s.setGodinaS(pod[8]);
				s.setStatus(pod[9]);
				
				dispose();
				StudentiTable.getInstance().refreshTable();
				JOptionPane.showMessageDialog((Component)e.getSource(), "Uspesijesna izmjena studenta!");
				
			}
		});
		
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
	}
	
}
