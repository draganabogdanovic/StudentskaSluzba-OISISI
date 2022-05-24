package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import rs.ac.uns.ftn.oisisi.controller.BrisanjeListener;
import rs.ac.uns.ftn.oisisi.controller.DodavanjaProfesoraNaPredmetListener;
import rs.ac.uns.ftn.oisisi.controller.DodavanjeListener;
import rs.ac.uns.ftn.oisisi.controller.IzmjenaListener;
import rs.ac.uns.ftn.oisisi.controller.PredmetiController;
import rs.ac.uns.ftn.oisisi.controller.PretragaListener;
import rs.ac.uns.ftn.oisisi.controller.ProfesoriController;
import rs.ac.uns.ftn.oisisi.controller.StudentiController;

public class ToolBar extends JToolBar {

	enum Tip {
		STUDENT, PREDMET, PROFESOR;

		static Tip getTipEnum(int i) {

			Tip tip = null;
			if (i == 0)
				tip = Tip.STUDENT;
			else if (i == 2)
				tip = Tip.PROFESOR;
			else if (i == 1)
				tip = Tip.PREDMET;
			return tip;
		}

	};

	private static final long serialVersionUID = 9097210193208086653L;
	private JToggleButton dodajStudenta;
	private JToggleButton dodajPredmet;
	private JToggleButton dodajProfesora;

	private JToggleButton menjaj;
	private JToggleButton brisi;
	private JButton pretrazi;

	private JToggleButton dodajStudentaNaPredmet;
	private JToggleButton dodajProfesoraNaPredmet;
	private JTextField pretraga;

	private JPanel left;
	private JPanel right;

	private static ToolBar instance = null;

	public static ToolBar getInstance() {
		if (instance == null) {
			instance = new ToolBar(Tip.STUDENT);
		}
		return instance;

	}

	private ToolBar(Tip t) {
		super(SwingConstants.HORIZONTAL);
		setLayout(new BorderLayout());
		left = new JPanel();
		right = new JPanel();
		left.setLayout(new FlowLayout(FlowLayout.LEFT));
		left.setOpaque(false);
		right.setLayout(new FlowLayout(FlowLayout.RIGHT));
		right.setOpaque(false);

		dodajStudenta = new JToggleButton();
		dodajStudenta.setToolTipText("Dodaj studenta");
		dodajStudenta.setIcon(new ImageIcon("images/plus.png"));
		dodajStudenta.addActionListener(new DodavanjeListener());
		dodajStudenta.setMnemonic(KeyEvent.VK_A);
		
		dodajPredmet = new JToggleButton();
		dodajPredmet.setToolTipText("Dodaj predmet");
		dodajPredmet.setIcon(new ImageIcon("images/plus.png"));
		dodajPredmet.addActionListener(new DodavanjeListener());
		dodajPredmet.setMnemonic(KeyEvent.VK_A);
		
		dodajProfesora = new JToggleButton();
		dodajProfesora.setToolTipText("Dodaj profesora");
		dodajProfesora.setIcon(new ImageIcon("images/plus.png"));
		dodajProfesora.addActionListener(new DodavanjeListener());

		dodajProfesora.setMnemonic(KeyEvent.VK_A);


		menjaj = new JToggleButton();
		menjaj.setIcon(new ImageIcon("images/edit.png"));
		menjaj.addActionListener(new IzmjenaListener());
		menjaj.setMnemonic(KeyEvent.VK_I);

		brisi = new JToggleButton();
		brisi.setIcon(new ImageIcon("images/delete.png"));
		brisi.addActionListener(new BrisanjeListener());
		brisi.setMnemonic(KeyEvent.VK_D);
		

		dodajStudentaNaPredmet = new JToggleButton();
		dodajStudentaNaPredmet.setToolTipText("Dodaj studenta na predmet");
		
		dodajStudentaNaPredmet.setIcon(new ImageIcon("images/student.png"));

		dodajStudentaNaPredmet.setMnemonic(KeyEvent.VK_O);

		dodajStudentaNaPredmet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PredmetiController.getInstance().dodavanjeStudentaNaPredmet();
				PredmetiTable.getInstance().refreshTable();
			}
		});
		
		dodajProfesoraNaPredmet = new JToggleButton();
		dodajProfesoraNaPredmet.setToolTipText("Dodaj profesora na predmet");
		dodajProfesoraNaPredmet.setIcon(new ImageIcon("images/prof.png"));
		dodajProfesoraNaPredmet.setMnemonic(KeyEvent.VK_O);
		dodajProfesoraNaPredmet.addActionListener(new DodavanjaProfesoraNaPredmetListener());
		
		pretraga = new JTextField(20);
		Font font1 = new Font("SensSefir", Font.BOLD, 18);
		pretraga.setFont(font1);
		pretraga.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				if(txt.getText().length() == 0) {
					if(TabbedPane.aktivanTab == 0) {

						StudentiController.getInstance().pretragaStudenta();
					}else if(TabbedPane.aktivanTab == 1) {
						PredmetiController.getInstance().pretragaPredmeta();
					}else if(TabbedPane.aktivanTab == 2) {
						ProfesoriController.getInstance().pretragaProfesora();
						
					}
				}
				
				
			}
		});

		pretrazi = new JButton();
		pretrazi.setToolTipText("Pretrazi studente");
		pretrazi.setIcon(new ImageIcon("images/search.png"));
		pretrazi.addActionListener(new PretragaListener());
		pretrazi.setMnemonic(KeyEvent.VK_S);
		
		paintComponents(Tip.STUDENT);
		setFloatable(false);

	}

	public void paintComponents(Tip tip) {

		removeAll();
		left.removeAll();
		right.removeAll();

		if (tip == Tip.STUDENT) {
			left.add(dodajStudenta);

		} else if (tip == Tip.PROFESOR) {
			left.add(dodajProfesora);

		} else if (tip == Tip.PREDMET) {
			left.add(dodajPredmet);

		}
		addSeparator();

		if (tip == Tip.STUDENT) {
			menjaj.setToolTipText("Izjeni studenta(alt+i)");


		} else if (tip == Tip.PREDMET) {
			menjaj.setToolTipText("Izmjeni predmet(alt+i)");
		} else if (tip == Tip.PROFESOR) {
			menjaj.setToolTipText("Izmjeni profesor(alt+i)");
		}

		left.add(menjaj);

		if (tip == Tip.STUDENT) {
			brisi.setToolTipText("Brisi studenta(alt+d)");

		} else if (tip == Tip.PREDMET) {
			brisi.setToolTipText("Brisi predmet(alt+d)");
		} else if (tip == Tip.PROFESOR) {
			brisi.setToolTipText("Brisi profesora(alt+d)");
		}
		left.add(brisi);

		if (tip == Tip.PREDMET) {
			left.add(dodajStudentaNaPredmet);
			left.add(dodajProfesoraNaPredmet);

		}

		right.add(pretraga);

		right.add(pretrazi);

		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);

	}

	public Tip getTip(int i) {

		return Tip.getTipEnum(i);
	}

	public void setSelectedButton() {
		dodajPredmet.setSelected(false);
		dodajStudenta.setSelected(false);
		dodajProfesora.setSelected(false);
		dodajProfesoraNaPredmet.setSelected(false);
		menjaj.setSelected(false);
		brisi.setSelected(false);
		dodajStudentaNaPredmet.setSelected(false);

	}

	public JTextField getSearchField() {
		return pretraga;

	}

	public void setSearchField(JTextField pretraga) {
		this.pretraga = pretraga;

	}
		

}
