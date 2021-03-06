package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import rs.ac.uns.ftn.oisisi.controller.PredmetiController;
import rs.ac.uns.ftn.oisisi.controller.StudentiController;
import rs.ac.uns.ftn.oisisi.model.Predmet;
import rs.ac.uns.ftn.oisisi.model.Student;

public class DijalogStudentNaPredmet extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1414795227660148857L;

	protected JTextField indeks;
	protected JButton odustani;
	protected JButton potvrdi;
	protected JPanel top;
	protected JPanel down;
	
	public DijalogStudentNaPredmet(Frame parent,String title, boolean modal){
		super(parent,title,modal);
		
		setLayout(new BorderLayout());
		setSize(400,150);
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		top = new JPanel();
		top.setLayout(new FlowLayout());
		down = new JPanel();
		down.setLayout(new FlowLayout());
		
		JLabel labela = new JLabel("Indeks:");
		indeks = new JTextField(20);
		indeks.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(Provjera()){
					potvrdi.setEnabled(true);
				}else{
					potvrdi.setEnabled(false);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		potvrdi = new JButton("Potvrdi");
		potvrdi.setEnabled(false);
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String index = brIndeksa();
				
				int row = PredmetiTable.getInstance().getSelectedRow();
				Predmet predmet = PredmetiController.getInstance().getPredmetPoIndeksu(row);
				Student s = StudentiController.getInstance().getStudentPoIndeksu(index);
				
				boolean IndeksPostoji = StudentiController.getInstance().indeksPostoji(index);
				
				boolean PostojiStudentNaPredmetu = PredmetiController.getInstance().postojiStudentSaIndeksom(index,row);
				
				boolean odgovarajucaGodina = false;
				if(s != null){
					if(predmet.getGodinaKadSeIzvodi().equals(s.getGodinaS())){
						odgovarajucaGodina = true;
		
				}				
				}
			
			boolean DodajStudentaNaPredmet = false;
			
			if(IndeksPostoji == false && PostojiStudentNaPredmetu == true && odgovarajucaGodina == true){
				DodajStudentaNaPredmet = true;
			}
			if(DodajStudentaNaPredmet){
				dispose();
				
				PredmetiController.getInstance().dodavanjeStudetaNaPredmet1(s,row,predmet);
				StudentiController.getInstance().dodavanjePredmetaStudenta(predmet,index);
				JOptionPane.showMessageDialog((Component) e.getSource(), "Uspesno ste dodali studenta na predmet");
				return;
			}else{
				
				if(IndeksPostoji){
					setVisible(false);
					JOptionPane.showMessageDialog((Component) e.getSource(), "Student sa unijetim ideksom ne postoji u bazi studenta","Greska",JOptionPane.ERROR_MESSAGE);
					setVisible(true);
					return;
				}else if(!PostojiStudentNaPredmetu){
					setVisible(false);
					JOptionPane.showMessageDialog( (Component)e.getSource(),"Ovaj student vec postoji na predmetu","Greska",JOptionPane.ERROR_MESSAGE );
					setVisible(true);
					return;
					
				}else if(!DodajStudentaNaPredmet){
					setVisible(false);
					JOptionPane.showMessageDialog((Component) e.getSource(), "Student nije odgovarajuca godina da bi pohadjao predmet","Greska",JOptionPane.ERROR_MESSAGE);
					setVisible(true);
					return;
					
				}
			}
			}
	
		});
		
		odustani = new JButton("Odustani");
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		top.add(labela);
		top.add(indeks);
		down.add(odustani);
		down.add(potvrdi);
		
		add(top,BorderLayout.NORTH);
		add(down,BorderLayout.SOUTH);
		
		
	}

	
	
	
	protected String brIndeksa() {
		String br = new String();
		br = indeks.getText().toString();
		return br;
	}




	protected boolean Provjera() {
		boolean ret = true;
		String brIndeksa = brIndeksa();
		
		if(brIndeksa.length() != 0){
			if(!Pattern.matches("[A-Z]{2,3} [0-9]{1,3}/[0-9]{4}", brIndeksa)){
				indeks.setBackground(Color.RED);
				return false;
			}
		}
		if((brIndeksa = brIndeksa.trim()).length() == 0){
			indeks.setBackground(Color.WHITE);
			return false;
		}
		
		indeks.setBackground(Color.WHITE);
		return ret;
		
	}
}
