package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class DialogStudent extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6847297048903882740L;
	protected JTextField txtIme; 
	protected JTextField txtPrezime; 
	protected JTextField txtDatRodj; 
	protected JTextField txtAdresa;
	protected JTextField txtBrTel;
	protected JTextField txtBrojIndeksa; 
	protected JTextField txtEmail;
	protected JTextField txtDatumUp; 

	protected JComboBox<String> godinaS;
	protected JRadioButton budzet;
	protected JRadioButton samofinansiranje;
	protected ButtonGroup dugme;
	protected JButton odustani;
	protected JButton potvrdi;

	// email
	// datum upisa

	public DialogStudent(Frame parent, String title, boolean modal) {
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
		

		JLabel lblIme = new JLabel("Ime");
		txtIme = new JTextField(20);
		txtIme.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Validacija_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblPrezime = new JLabel("Prezime");
		txtPrezime = new JTextField(20);
		txtPrezime.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Validacija_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblDatumRodj = new JLabel("Datum rodjenja");
		txtDatRodj = new JTextField(20);
		txtDatRodj.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Validacija_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblAdresa = new JLabel("Adresa Stanovanja");
		txtAdresa = new JTextField(20);
		txtAdresa.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Validacija_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		JLabel lblBrojTel = new JLabel("Broj telefona");
		txtBrTel = new JTextField(20);
		txtBrTel.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Validacija_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblEmail = new JLabel("Email");
		txtEmail = new JTextField(20);
		txtEmail.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Validacija_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblBrIndeksa = new JLabel("Broj indeksa");
		txtBrojIndeksa = new JTextField(20);
		txtBrojIndeksa.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Validacija_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblDatumUp = new JLabel("Datum Upisa");
		txtDatumUp = new JTextField(20);
		txtDatumUp.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Validacija_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		;

		JLabel lblGodStud = new JLabel("Trenutna godina Studija:");
		String[] godina = new String[] { "I", "II", "III", "IV" };
		godinaS = new JComboBox<String>(godina);
		godinaS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Validacija_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}
			}
		});

		dugme = new ButtonGroup();
		budzet = new JRadioButton("Budzet", true);
		samofinansiranje = new JRadioButton("Samofinansiranje");
		odustani = new JButton("Odustani");
		potvrdi = new JButton("Potvrdi");
		potvrdi.setEnabled(false);
		samofinansiranje.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Validacija_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}
			}
		});
		budzet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Validacija_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}
			}
		});

		
	
		
		dugme.add(budzet);
		dugme.add(samofinansiranje);

		GridBagConstraints gbcImeStudenta = new GridBagConstraints();
		gbcImeStudenta.gridx = 0;
		gbcImeStudenta.gridy = 0;
		gbcImeStudenta.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(lblIme, gbcImeStudenta);

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
		
		GridBagConstraints gbcBrIndexa = new GridBagConstraints();
		gbcBrIndexa.gridx = 0;
		gbcBrIndexa.gridy = 5;
		gbcBrIndexa.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(lblBrIndeksa, gbcBrIndexa);
		
		GridBagConstraints gbcEmail = new GridBagConstraints();
		gbcEmail.gridx = 0;
		gbcEmail.gridy = 6;
		gbcEmail.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(lblEmail, gbcEmail);
		
		GridBagConstraints gbcDatumUp = new GridBagConstraints();
		gbcDatumUp.gridx = 0;
		gbcDatumUp.gridy = 7;
		gbcDatumUp.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(lblDatumUp, gbcDatumUp);
		
	

		
		
		GridBagConstraints gbcTxtImeStudenta = new GridBagConstraints();
		gbcTxtImeStudenta.gridx = 1;
		gbcTxtImeStudenta.gridy = 0;
		gbcTxtImeStudenta.weightx = 200;
		gbcTxtImeStudenta.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtImeStudenta.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtIme, gbcTxtImeStudenta);

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
		gbcTxtDatumRodj.weightx = 200;
		gbcTxtDatumRodj.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtDatumRodj.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtDatRodj, gbcTxtDatumRodj);
		
		GridBagConstraints gbcTxtAdresa = new GridBagConstraints();
		gbcTxtAdresa.gridx = 1;
		gbcTxtAdresa.gridy = 3;
		gbcTxtAdresa.weightx = 200;
		gbcTxtAdresa.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtAdresa.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtAdresa, gbcTxtAdresa);
		
		
		GridBagConstraints gbcTxtBrTel = new GridBagConstraints();
		gbcTxtBrTel.gridx = 1;
		gbcTxtBrTel.gridy = 4;
		gbcTxtBrTel.weightx = 200;
		gbcTxtBrTel.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtBrTel.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtBrTel, gbcTxtBrTel);
		
		GridBagConstraints gbcTxtBrIndexa = new GridBagConstraints();
		gbcTxtBrIndexa.gridx = 1;
		gbcTxtBrIndexa.gridy = 5;
		gbcTxtBrIndexa.weightx = 200;
		gbcTxtBrIndexa.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtBrIndexa.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtBrojIndeksa, gbcTxtBrIndexa);
		
		
		GridBagConstraints gbcTxtEmail = new GridBagConstraints();
		gbcTxtEmail.gridx = 1;
		gbcTxtEmail.gridy = 6;
		gbcTxtEmail.weightx = 200;
		gbcTxtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtEmail.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtEmail, gbcTxtEmail);
		
		GridBagConstraints gbcTxtDatumUp = new GridBagConstraints();
		gbcTxtDatumUp.gridx = 1;
		gbcTxtDatumUp.gridy = 7;
		gbcTxtDatumUp.weightx = 200;
		gbcTxtDatumUp.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtDatumUp.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtDatumUp, gbcTxtDatumUp);		
	
		GridBagConstraints gbcGodina = new GridBagConstraints();
		gbcGodina.gridx = 0;
		gbcGodina.gridy = 8;
		gbcGodina.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(lblGodStud, gbcGodina);
		
		GridBagConstraints gbcTxtGodina = new GridBagConstraints();
		gbcTxtGodina.gridx = 1;
		gbcTxtGodina.gridy = 8;
		gbcTxtGodina.weightx = 10;
		gbcTxtGodina.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(godinaS, gbcTxtGodina);
		
		
		budzet.setOpaque(false);
		
		GridBagConstraints gbcButtonGroup = new GridBagConstraints();
		gbcButtonGroup.gridx = 0;
		gbcButtonGroup.gridy = 9;
		gbcButtonGroup.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(budzet, gbcButtonGroup);
		samofinansiranje.setOpaque(false);
		
		GridBagConstraints gbcButtonGroup1 = new GridBagConstraints();
		gbcButtonGroup1.gridx = 1;
		gbcButtonGroup1.gridy = 9;
		gbcButtonGroup1.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(samofinansiranje, gbcButtonGroup1);
		
		
		
		JPanel panelBottom = new JPanel(new FlowLayout());
		panelBottom.add(Box.createHorizontalStrut(180));
		odustani = new JButton("Odustani");
		
		potvrdi = new JButton("Potvrda");
		potvrdi.setEnabled(false);
		
		
		panelBottom.add(odustani);
		panelBottom.add(potvrdi);
		
		panelBottom.setBackground(new Color(210, 210, 210));
		
		add(panelBottom, BorderLayout.SOUTH);
	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		setResizable(false);

	}

	protected String[] podaci() {
		String[] p = new String[10];

		for (int i = 0; i < p.length; i++) {
			p[i] = new String();
		}

		p[0] = txtIme.getText().toString(); // ime
		p[1] = txtPrezime.getText().toString(); // prezime
		p[2] = txtDatRodj.getText().toString(); // datum rodejna
		p[3] = txtAdresa.getText().toString(); // adresa stanovanja
		p[4] = txtBrTel.getText().toString(); // br telefona
		p[5] = txtEmail.getText().toString(); // email
		p[6] = txtBrojIndeksa.getText().toString(); // br indeksa
		p[7] = txtDatumUp.getText().toString();//datum upisa
		p[8] = godinaS.getSelectedItem().toString(); // godina 
		 
		
		//DUGME ZA OTKACIVANJE BUDZET ILI SAMOFINANSIRANJE
		if (samofinansiranje.isSelected()) {
			p[9] = "S";
		} else {
			p[9] = "B";
		}
		
		return p;
	}

	private boolean Validacija_podataka() {
		boolean ret = true;
		String[] p = podaci();

		if (!Pattern.matches("[A-Za-z_ ]*", p[0])) { // Ime
			txtIme.setBackground(Color.RED);
			return false;
		} else {
			txtIme.setBackground(Color.WHITE);
		}
		if (!Pattern.matches("[A-Za-z_ ]*", p[1])) { // Prezime
			txtPrezime.setBackground(Color.RED);
			return false;
		} else {
			txtPrezime.setBackground(Color.WHITE);
		}

		if (p[2].length() != 0) { // datum rodjenja
			if (!Pattern.matches("^(3[01]|[12][0-9]|0[1-9]).(1[0-2]|0[1-9]).[0-9]{4}.$", p[2])) {
				txtDatRodj.setBackground(Color.RED);
				return false;
			}
		}
		if (p[3].length() != 0) { // adresa stanovanja
			if (!Pattern.matches("^(.+),(.+)$", p[3])) {
				txtAdresa.setBackground(Color.RED);
				return false;
			}
		}
		if (p[4].length() != 0) {// broj telefona
			if (!Pattern.matches("[0-9]{3}/[0-9]{3,4}-[0-9]{3}", p[4])) {
				txtBrTel.setBackground(Color.RED);
				return false;
			} else if (p[4].length() > 16) {
				txtBrTel.setBackground(Color.RED);
				return false;
			}
		}

		if (p[5].length() != 0) { // email
			if (!Pattern.matches("^(.+)@(.+)$", p[5])) {
				txtEmail.setBackground(Color.RED);
				return false;
			}
		}

		if (p[6].length() != 0) { // indeks
			if (!Pattern.matches("[A-Z]{2,3} [0-9]{1,3}/[0-9]{4}", p[6])) {
				txtBrojIndeksa.setBackground(Color.RED);
				return false;
			}
		}

		if (p[7].length() != 0) { // datum upisa
			if (!Pattern.matches("^(3[01]|[12][0-9]|0[1-9]).(1[0-2]|0[1-9]).[0-9]{4}.$", p[7])) {
				txtDatumUp.setBackground(Color.RED);
				return false;
			}
		}

		for (String string : p) {
			if ((string = string.trim()).length() == 0) {
				txtIme.setBackground(Color.WHITE);
				txtPrezime.setBackground(Color.WHITE);
				txtDatRodj.setBackground(Color.WHITE);
				txtAdresa.setBackground(Color.WHITE);
				txtBrTel.setBackground(Color.WHITE);
				txtBrojIndeksa.setBackground(Color.WHITE);
				txtEmail.setBackground(Color.WHITE);
				txtDatumUp.setBackground(Color.WHITE);
				return false;

			}
		}
		

		txtIme.setBackground(Color.WHITE);
		txtPrezime.setBackground(Color.WHITE);
		txtDatRodj.setBackground(Color.WHITE);
		txtAdresa.setBackground(Color.WHITE);
		txtBrTel.setBackground(Color.WHITE);
		txtBrojIndeksa.setBackground(Color.WHITE);
		txtEmail.setBackground(Color.WHITE);
		txtDatumUp.setBackground(Color.WHITE);
		return ret;
	}

}