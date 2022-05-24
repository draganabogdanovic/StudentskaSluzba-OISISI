package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ProfesorDijalog  extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5685931757450861979L;

	protected JTextField txtIme; 
	protected JTextField txtPrezime; 
	protected JTextField txtDatRodj; 
	protected JTextField txtAdresa;
	protected JTextField txtBrTel;
	protected JTextField txtEmail;
	protected JTextField txtAdresaKanc;
	protected JTextField txtBrLicne;
	protected JTextField txtTitula;
	protected JTextField txtZvanje;
	
	
	protected JButton odustaniButton;
	protected JButton potvrdaButton;
	
	public ProfesorDijalog(Frame parent, String title, boolean modal) {
	
		super(parent, title, modal);
		setLayout(new BorderLayout());
		setSize(400,500);
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		JPanel panelCenter = new JPanel();
		
		panelCenter.setBackground(Color.white);
		panelCenter.setLayout(new GridBagLayout());
		panelCenter.setBackground(new Color(140, 255, 150));
		add(panelCenter, BorderLayout.CENTER);

		

		JLabel lblIme = new JLabel("Ime:");
		txtIme = new JTextField(20);
		txtIme.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (isValideInput()) {
					potvrdaButton.setEnabled(true);
				} else {
					potvrdaButton.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblPrezime = new JLabel("Prezime:");
		txtPrezime = new JTextField(20);
		txtPrezime.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (isValideInput()) {
					potvrdaButton.setEnabled(true);
				} else {
					potvrdaButton.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblDatumRodj = new JLabel("Datum rodjenja:");
		txtDatRodj = new JTextField(20);
		txtDatRodj.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (isValideInput()) {
					potvrdaButton.setEnabled(true);
				} else {
					potvrdaButton.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblAdresa = new JLabel("Adresa Stanovanja:");
		txtAdresa = new JTextField(20);
		txtAdresa.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (isValideInput()) {
					potvrdaButton.setEnabled(true);
				} else {
					potvrdaButton.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		JLabel lblBrojTel = new JLabel("Broj telefona:");
		txtBrTel = new JTextField(20);
		txtBrTel.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (isValideInput()) {
					potvrdaButton.setEnabled(true);
				} else {
					potvrdaButton.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblEmail = new JLabel("Email:");
		txtEmail = new JTextField(20);
		txtEmail.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (isValideInput()) {
					potvrdaButton.setEnabled(true);
				} else {
					potvrdaButton.setEnabled(false);
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		
		
		
		
		
		JLabel lblAdresaKanc = new JLabel("Adresa kancelarije:");
		JLabel lblBrLicne = new JLabel("Broj licne karte:");
		JLabel lblTitula = new JLabel("Titula:");
		JLabel lblZvanje = new JLabel("Zvanje:");
		
		
		
		
		
		txtAdresaKanc = new JTextField();
		txtBrLicne = new JTextField();
		txtTitula =  new JTextField();
		txtZvanje = new JTextField();
		
		
		
		
		txtAdresaKanc.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(isValideInput()) {
					potvrdaButton.setEnabled(true);
				} else {
					potvrdaButton.setEnabled(false);
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		txtBrLicne.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(isValideInput()) {
					potvrdaButton.setEnabled(true);
				} else {
					potvrdaButton.setEnabled(false);
				}
			
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
		txtTitula.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(isValideInput()) {
					potvrdaButton.setEnabled(true);
				} else {
					potvrdaButton.setEnabled(false);
				}
			
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		txtTitula.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(isValideInput()) {
					potvrdaButton.setEnabled(true);
				} else {
					potvrdaButton.setEnabled(false);
				}
			
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		txtZvanje.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(isValideInput()) {
					potvrdaButton.setEnabled(true);
				} else {
					potvrdaButton.setEnabled(false);
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		

		GridBagConstraints gbcIme = new GridBagConstraints();
		gbcIme.gridx = 0;
		gbcIme.gridy = 0;
		gbcIme.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(lblIme, gbcIme);

		GridBagConstraints gbcPrezime = new GridBagConstraints();
		gbcPrezime.gridx = 0;
		gbcPrezime.gridy = 1;
		gbcPrezime.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(lblPrezime, gbcPrezime);
		
		GridBagConstraints gbcDatRodj = new GridBagConstraints();
		gbcDatRodj.gridx = 0;
		gbcDatRodj.gridy = 2;
		gbcDatRodj.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(lblDatumRodj, gbcDatRodj);
		
		GridBagConstraints gbcAdresa = new GridBagConstraints();
		gbcAdresa.gridx = 0;
		gbcAdresa.gridy = 3;
		gbcAdresa.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(lblAdresa, gbcAdresa);
		
		
		GridBagConstraints gbcBrTel = new GridBagConstraints();
		gbcBrTel.gridx = 0;
		gbcBrTel.gridy = 4;
		gbcBrTel.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(lblBrojTel, gbcBrTel);
		
		GridBagConstraints gbcEmail = new GridBagConstraints();
		gbcEmail.gridx = 0;
		gbcEmail.gridy = 5;
		gbcEmail.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(lblEmail, gbcEmail);
		
		GridBagConstraints gbcAdresaKanc = new GridBagConstraints();
		gbcAdresaKanc.gridx = 0;
		gbcAdresaKanc.gridy = 6;
		gbcAdresaKanc.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(lblAdresaKanc, gbcAdresaKanc);

		GridBagConstraints gbcBrLicne = new GridBagConstraints();
		gbcBrLicne.gridx = 0;
		gbcBrLicne.gridy = 7;
		gbcBrLicne.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(lblBrLicne, gbcBrLicne);
		
		GridBagConstraints gbcTitula = new GridBagConstraints();
		gbcTitula.gridx = 0;
		gbcTitula.gridy = 8;
		gbcTitula.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(lblTitula, gbcTitula);
		
		GridBagConstraints gbcZvanje = new GridBagConstraints();
		gbcZvanje.gridx = 0;
		gbcZvanje.gridy = 9;
		gbcZvanje.insets = new Insets(20, 20, 20, 0);
		panelCenter.add(lblZvanje, gbcZvanje);
		
		
		
		GridBagConstraints gbcTxtIme = new GridBagConstraints();
		gbcTxtIme.gridx = 1;
		gbcTxtIme.gridy = 0;
		gbcTxtIme.weightx = 200;
		gbcTxtIme.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtIme.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtIme, gbcTxtIme);

		GridBagConstraints gbcTxtPrezime = new GridBagConstraints();
		gbcTxtPrezime.gridx = 1;
		gbcTxtPrezime.gridy = 1;
		gbcTxtPrezime.weightx = 200;
		gbcTxtPrezime.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtPrezime.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtPrezime, gbcTxtPrezime);
		
		GridBagConstraints gbcTxtDatumRodj = new GridBagConstraints();
		gbcTxtDatumRodj.gridx = 1;
		gbcTxtDatumRodj.gridy = 2;
		gbcTxtDatumRodj.weightx = 300;
		gbcTxtDatumRodj.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtDatumRodj.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtDatRodj, gbcTxtDatumRodj);
		
		GridBagConstraints gbcTxtAdresa = new GridBagConstraints();
		gbcTxtAdresa.gridx = 1;
		gbcTxtAdresa.gridy = 3;
		gbcTxtAdresa.weightx = 400;
		gbcTxtAdresa.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtAdresa.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtAdresa, gbcTxtAdresa);
		
		
		GridBagConstraints gbcTxtBrTel = new GridBagConstraints();
		gbcTxtBrTel.gridx = 1;
		gbcTxtBrTel.gridy = 4;
		gbcTxtBrTel.weightx = 500;
		gbcTxtBrTel.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtBrTel.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtBrTel, gbcTxtBrTel);
		
		
		
		GridBagConstraints gbcTxtEmail = new GridBagConstraints();
		gbcTxtEmail.gridx = 1;
		gbcTxtEmail.gridy = 5;
		gbcTxtEmail.weightx = 700;
		gbcTxtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtEmail.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtEmail, gbcTxtEmail);

		GridBagConstraints gbcTxtAdresaKanc = new GridBagConstraints();
		gbcTxtAdresaKanc.gridx = 1;
		gbcTxtAdresaKanc.gridy = 6;
		gbcTxtAdresaKanc.weightx = 100;
		gbcTxtAdresaKanc.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtAdresaKanc.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtAdresaKanc, gbcTxtAdresaKanc);

		GridBagConstraints gbcTxtBrLicne = new GridBagConstraints();
		gbcTxtBrLicne.gridx = 1;
		gbcTxtBrLicne.gridy = 7;
		gbcTxtBrLicne.weightx = 200;
		gbcTxtBrLicne.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtBrLicne.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtBrLicne, gbcTxtBrLicne);

		
		GridBagConstraints gbcTxtTitula = new GridBagConstraints();
		gbcTxtTitula.gridx = 1;
		gbcTxtTitula.gridy = 8;
		gbcTxtTitula.weightx = 300;
		gbcTxtTitula.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtTitula.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtTitula, gbcTxtTitula);
		
		GridBagConstraints gbcTxtZvanje = new GridBagConstraints();
		gbcTxtZvanje.gridx = 1;
		gbcTxtZvanje.gridy = 9;
		gbcTxtZvanje.weightx = 200;
		gbcTxtZvanje.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtZvanje.insets = new Insets(20, 20, 20, 20);
		panelCenter.add(txtZvanje, gbcTxtZvanje);
		
		JPanel panelBottom = new JPanel(new FlowLayout());
		panelBottom.add(Box.createHorizontalStrut(180));
		odustaniButton = new JButton("Odustani");
		
		potvrdaButton = new JButton("Potvrda");
		potvrdaButton.setEnabled(false);
		

		panelBottom.add(odustaniButton);
		panelBottom.add(potvrdaButton);
		panelBottom.setBackground(new Color(210, 210, 210));
		
		add(panelBottom, BorderLayout.SOUTH);
		setResizable(false);
		
		
		
		
		
		
		
		
		
		
		
		
		
}
	
	
	public String[] unosPodataka() {
		String unesi[] = new String[10];
		for (int i = 0; i < unesi.length; i++) {
			unesi[i] = new String();
		}
		unesi[0] = txtIme.getText().toString(); // ime
		unesi[1] = txtPrezime.getText().toString(); // prezime
		unesi[2] = txtDatRodj.getText().toString(); // datum rodejna
		unesi[3] = txtAdresa.getText().toString(); // adresa stanovanja
		unesi[4] = txtBrTel.getText().toString(); // br telefona
		unesi[5] = txtEmail.getText().toString();
		unesi[6] = txtAdresaKanc.getText().toString();
		unesi[7] = txtBrLicne.getText().toString();
		unesi[8] = txtTitula.getText().toString();
		unesi[9] = txtZvanje.getText().toString();
		
		return unesi;
	}
	
	
	
	protected boolean isValideInput() {
		String unesi [] = unosPodataka();
		boolean rez = true;
		
		
		if (!Pattern.matches("[A-Za-z_ ]*", unesi[0])) { // Ime
			txtIme.setBackground(Color.RED);
			return false;
		} else {
			txtIme.setBackground(Color.WHITE);
		}
		if (!Pattern.matches("[A-Za-z_ ]*", unesi[1])) { // Prezime
			txtPrezime.setBackground(Color.RED);
			return false;
		} else {
			txtPrezime.setBackground(Color.WHITE);
		}
		
		if (unesi[2].length() != 0) { // datum rodjenja
			if (!Pattern.matches("^(3[01]|[12][0-9]|0[1-9]).(1[0-2]|0[1-9]).[0-9]{4}.$", unesi[2])) {
				txtDatRodj.setBackground(Color.RED);
				return false;
			}
		}
		if (unesi[3].length() != 0) { // adresa stanovanja
			if (!Pattern.matches("^(.+),(.+)$*", unesi[3])) {
				txtAdresa.setBackground(Color.RED);
				return false;
			}
		}
		if (unesi[4].length() != 0) {// broj telefona

			if (!Pattern.matches("[0-9]{3}/[0-9]{3,4}-[0-9]{3}", unesi[4])) {
				txtBrTel.setBackground(Color.RED);
				return false;
			} else if (unesi[4].length() > 16) {
				txtBrTel.setBackground(Color.RED);
				return false;
			}
		}

		if (unesi[5].length() != 0) { // email
			if (!Pattern.matches("^(.+)@(.+)$", unesi[5])) {
				txtEmail.setBackground(Color.RED);
				return false;
			}
		}
		
		
		if (!Pattern.matches("^(.+),(.+)$", unesi[6])) {
			txtAdresaKanc.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("[0-9\"]*", unesi[7])) {
			txtBrLicne.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("[A-Za-z_ .]*", unesi[8])) {
			txtTitula.setBackground(Color.RED);
			return false;
		}
		
		if (!Pattern.matches("[A-Za-z_ ]*", unesi[9])) {
			txtZvanje.setBackground(Color.RED);
			return false;
		}
		
		for(String s: unesi) {
			if((s = s.trim()).length() == 0) {
				txtIme.setBackground(Color.WHITE);
				txtPrezime.setBackground(Color.WHITE);
				txtDatRodj.setBackground(Color.WHITE);
				txtAdresa.setBackground(Color.WHITE);
				txtBrTel.setBackground(Color.WHITE);
				txtEmail.setBackground(Color.WHITE);
				txtAdresaKanc.setBackground(Color.WHITE);
				txtBrLicne.setBackground(Color.WHITE);
				txtTitula.setBackground(Color.WHITE);
				txtZvanje.setBackground(Color.WHITE);
				rez = false;
			}
		} 
		txtIme.setBackground(Color.WHITE);
		txtPrezime.setBackground(Color.WHITE);
		txtDatRodj.setBackground(Color.WHITE);
		txtAdresa.setBackground(Color.WHITE);
		txtBrTel.setBackground(Color.WHITE);
		txtEmail.setBackground(Color.WHITE);
		txtAdresaKanc.setBackground(Color.WHITE);
		txtBrLicne.setBackground(Color.WHITE);
		txtTitula.setBackground(Color.WHITE);
		txtZvanje.setBackground(Color.WHITE);
		return rez;
	}
}



