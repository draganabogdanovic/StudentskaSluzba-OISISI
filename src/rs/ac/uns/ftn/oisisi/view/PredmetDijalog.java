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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class PredmetDijalog extends JDialog {
	

	private static final long serialVersionUID = -3053146304340424348L;
	protected JTextField textSifrePredmeta;
	protected JTextField textNazivPredmeta;
	protected JComboBox<String> semestar;
	protected JComboBox<String> godina;
	
	protected JButton odustaniButton;
	protected JButton potvrdaButton;
	
	
	public PredmetDijalog(Frame parent, String title, boolean modal) {
	
		super(parent, title, modal);
		setLayout(new BorderLayout());
		setSize(400, 250);
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		JPanel panelCenter = new JPanel();
		
		panelCenter.setBackground(Color.white);
		panelCenter.setLayout(new GridBagLayout());
		panelCenter.setBackground(new Color(140, 255, 150));
		add(panelCenter, BorderLayout.CENTER);

		JLabel sifraPredmetaLabel = new JLabel("Sifra predmeta:");
		JLabel nazivPredmetaLabel = new JLabel("Naziv predmeta:");
		JLabel semestarLabel = new JLabel("Semestar:");
		JLabel godinaLabel = new JLabel("Godina:");
		
		String Ssemestar[] = { "             ", "1", "2", "3", "4", "5", "6", "7","8" };
		semestar = new JComboBox<String>(Ssemestar);
		semestar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isValideInput()) {
					potvrdaButton.setEnabled(true);
				} else {
					potvrdaButton.setEnabled(false);
				}
				
			}
		});
		
		
		String godinaS[] = { "             ", "I", "II", "III", "IV", "V", "VI" };
		godina = new JComboBox<String>(godinaS);
		godina.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isValideInput()) {
					potvrdaButton.setEnabled(true);
				} else {
					potvrdaButton.setEnabled(false);
				}
				
			}
		});
		
		
		
		
		textSifrePredmeta = new JTextField();
		textNazivPredmeta = new JTextField();
		
		textNazivPredmeta.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(isValideInput()) {
					potvrdaButton.setEnabled(true);
				} else {
					potvrdaButton.setEnabled(false);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {}
		});
		
		textSifrePredmeta.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(isValideInput()) {
					potvrdaButton.setEnabled(true);
				} else {
					potvrdaButton.setEnabled(false);
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
		
		
		
		
		
		
		GridBagConstraints gbcSifraPredmeta = new GridBagConstraints();
		gbcSifraPredmeta.gridx = 0;
		gbcSifraPredmeta.gridy = 0;
		gbcSifraPredmeta.insets = new Insets(10, 20, 0, 0);
		panelCenter.add(sifraPredmetaLabel, gbcSifraPredmeta);

		GridBagConstraints gbcNazivPredmeta = new GridBagConstraints();
		gbcNazivPredmeta.gridx = 0;
		gbcNazivPredmeta.gridy = 1;
		gbcNazivPredmeta.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(nazivPredmetaLabel, gbcNazivPredmeta);

		GridBagConstraints gbcTextSifraPredmeta = new GridBagConstraints();
		gbcTextSifraPredmeta.gridx = 1;
		gbcTextSifraPredmeta.gridy = 0;
		gbcTextSifraPredmeta.weightx = 100;
		gbcTextSifraPredmeta.fill = GridBagConstraints.HORIZONTAL;
		gbcTextSifraPredmeta.insets = new Insets(10, 20, 0, 20);
		panelCenter.add(textSifrePredmeta, gbcTextSifraPredmeta);

		GridBagConstraints gbcTextNazivPredmeta = new GridBagConstraints();
		gbcTextNazivPredmeta.gridx = 1;
		gbcTextNazivPredmeta.gridy = 1;
		gbcTextNazivPredmeta.weightx = 200;
		gbcTextNazivPredmeta.fill = GridBagConstraints.HORIZONTAL;
		gbcTextNazivPredmeta.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(textNazivPredmeta, gbcTextNazivPredmeta);

		GridBagConstraints gbcSemestar = new GridBagConstraints();
		gbcSemestar.gridx = 0;
		gbcSemestar.gridy = 2;
		gbcSemestar.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(semestarLabel, gbcSemestar);

		GridBagConstraints gbcGodina = new GridBagConstraints();
		gbcGodina.gridx = 0;
		gbcGodina.gridy = 3;
		gbcGodina.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(godinaLabel, gbcGodina);

		GridBagConstraints gbcSsemestar = new GridBagConstraints();
		gbcSsemestar.gridx = 1;
		gbcSsemestar.gridy = 2;
		gbcSsemestar.weightx = 10;
		gbcSsemestar.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(semestar, gbcSsemestar);

		GridBagConstraints gbcGgodina = new GridBagConstraints();
		gbcGgodina.gridx = 1;
		gbcGgodina.gridy = 3;
		gbcGgodina.weightx = 10;
		gbcGgodina.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(godina, gbcGgodina);

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

	protected String[] prikupiUnos() {
		String unesi[] = new String[4];
		for (int i = 0; i < unesi.length; i++) {
			unesi[i] = new String();
		}
		unesi[0] = textSifrePredmeta.getText().toString();
		unesi[1] = textNazivPredmeta.getText().toString();
		unesi[2] = semestar.getSelectedItem().toString();
		unesi[3] = godina.getSelectedItem().toString();
		
		return unesi;
	}

	protected boolean isValideInput() {
		String unesi [] = prikupiUnos();
		boolean r = true;
		
		if (!Pattern.matches("[a-zA-Z0-9]*", unesi[0])) {
			textSifrePredmeta.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("[a-zA-Z0-9_ ]*", unesi[1])) {
			textNazivPredmeta.setBackground(Color.RED);
			return false;
		}
		for(String s: unesi) {
			if((s = s.trim()).length() == 0) {
				textSifrePredmeta.setBackground(Color.WHITE);
				textNazivPredmeta.setBackground(Color.WHITE);
				r = false;
			}
		}
		textSifrePredmeta.setBackground(Color.WHITE);
		textNazivPredmeta.setBackground(Color.WHITE);
		
		return r;
	}
}
