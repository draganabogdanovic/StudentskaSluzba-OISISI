package rs.ac.uns.ftn.oisisi.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import rs.ac.uns.ftn.oisisi.controller.BrisanjeListener;
import rs.ac.uns.ftn.oisisi.controller.IzmjenaListener;
import rs.ac.uns.ftn.oisisi.controller.MenuElementListenerDodavanje;
import rs.ac.uns.ftn.oisisi.controller.PredmetiController;
import rs.ac.uns.ftn.oisisi.controller.ProfesoriController;
import rs.ac.uns.ftn.oisisi.controller.StudentiController;

public class MenuBar extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3018214033399995664L;
	private static MenuBar instance = null;
	

	
	private JMenu file;
	private JMenu edit1;
	private JMenu help;
	
	
	
	
	private JMenu new1; 
	private JMenu edit2; 
	private JMenu delete;
	private JMenuItem close;
	private JMenuItem about;
	private JMenuItem help1;
	
	// DODAVANJE
	private JMenuItem dodajStudenta;
	private JMenuItem dodajProfesora;
	private JMenuItem dodajPredmet;
	//IZMJENA
	private JMenuItem izmenaStudenta;
	private JMenuItem izmenaProfesora;
	private JMenuItem izmenaPredmeta;
	//BRISANJE
	private JMenuItem brisanjeStudenta;
	private JMenuItem brisanjeProfesora;
	private JMenuItem brisanjePredmeta;
	
	//DUGMAD ZA DODAVANJE NA PREDMET
	private JMenu dodajStudProf;
	private JMenuItem dodajStud;
	private JMenuItem dodajProf;
	
	
	
	public static MenuBar getInstance(){
		if(instance == null){
			instance = new MenuBar();
		}
		return instance;
	}

	private MenuBar(){
		file = new JMenu("File");
	    edit1 = new JMenu("Edit");
	    help = new JMenu("Help");
	  
	    
	
	    
	    
	    new1 = new JMenu("New");
	    close = new JMenuItem("Close");
	    edit2 = new JMenu("Edit");
	    delete = new JMenu("Delete");
	    help1 = new JMenuItem("Help");
	    about = new JMenuItem("About");
	    dodajStudenta = new JMenuItem("Dodaj Studenta");
	    dodajPredmet = new JMenuItem("Dodaj Predmet");
	    dodajProfesora = new JMenuItem("Dodaj Profesora");
	    izmenaStudenta = new JMenuItem("Izmijeni Studenta");
	    izmenaProfesora =  new JMenuItem("Izmijeni Profesora");
	    izmenaPredmeta = new JMenuItem("Izmijeni Predmet");
	    brisanjePredmeta =  new JMenuItem("Obrisi Predmet");
	    brisanjeStudenta = new JMenuItem("Obrisi Studenta");
	    brisanjeProfesora = new JMenuItem("Obrisi Profesora");
	    
	    dodajStudProf = new JMenu("Dodavanje stud/prof na pred");
	    dodajStud = new JMenuItem("Dodaj studenta na predmet");
	    dodajProf = new JMenuItem("Dodaj profesora na predmet");
	  //****************************************************************************************** 
	    
	    //DODAVANJE
	       new1.setMnemonic(KeyEvent.VK_N);
		   new1.setIcon(new ImageIcon("ikonice/plus.png"));   
		   
		   dodajStudenta.setMnemonic(KeyEvent.VK_S);
		   dodajPredmet.setMnemonic(KeyEvent.VK_P);
		   dodajProfesora.setMnemonic(KeyEvent.VK_Z);
		   
		   
		   dodajStudenta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.SHIFT_MASK));
		   dodajProfesora.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,ActionEvent.SHIFT_MASK));
		   dodajPredmet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,ActionEvent.SHIFT_MASK));
		   

		    dodajStudenta.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					DodavanjeStudentaDijalog dialog = new DodavanjeStudentaDijalog(GlavniProzor.getInstance(), "Dodavanje studenta", true);
					dialog.setVisible(true);
					
				}
			});
		    dodajProfesora.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					DodavanjePredmetaDijalog dijalog = new DodavanjePredmetaDijalog(GlavniProzor.getInstance(), "Dodavanje predmeta", true);
					dijalog.setVisible(true);
					ToolBar.getInstance().setSelectedButton();
					
				}
			});
		    dodajPredmet.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					DodavanjeProfesoraDijalog dijalog = new DodavanjeProfesoraDijalog(GlavniProzor.getInstance(), "Dodavanje profesora", true);
					dijalog.setVisible(true);
					ToolBar.getInstance().setSelectedButton();
				}
			});

		   
		   
		    new1.add(dodajStudenta);
		    new1.add(dodajProfesora);
		    new1.add(dodajPredmet);
		    
		  //DODAVANJE NA PREDMET STDENTA ILI PROFESORA
			   
			   dodajStudProf.setMnemonic(KeyEvent.VK_T);
			   dodajStudProf.setEnabled(false);
			   new1.add(dodajStudProf);
			   
			   
			   dodajStud.setMnemonic(KeyEvent.VK_U);
			   dodajStud.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
			   dodajStud.addActionListener(new MenuElementListenerDodavanje());
			    
			   dodajStudProf.add(dodajStud);
			   dodajStudProf.addSeparator();
			   
			   
			   dodajProf.setMnemonic(KeyEvent.VK_V);
			   dodajProf.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
			   dodajProf.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (PredmetiTablePane.getSelectedRow() > -1) {
						DodavanjeProfesoraNaPredmetDialog dialog = new DodavanjeProfesoraNaPredmetDialog(
								GlavniProzor.getInstance(), "Dodavanje profesora na predmet", true);
						dialog.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Predmet nije selektovan!", "Greska",
								JOptionPane.ERROR_MESSAGE);
						ToolBar.getInstance().setSelectedButton();
					}
					
				}
			});
			 
			   dodajStudProf.add(dodajProf);
			   dodajStudProf.setEnabled(false);
			   dodajStud.setEnabled(false);
			   dodajProf.setEnabled(false);
			   
		    
		    
		  
		  
		   file.add(new1);
	       file.addSeparator();
	       //ZATVARANJE
	    	close.setMnemonic(KeyEvent.VK_C);
	    	close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		    close.setIcon(new ImageIcon("ikonice/exit.png"));
		    
		    
		    
		    file.add(close);
	    //****************************************************************************************************
		    //IZMJENA
	    	edit2.setMnemonic(KeyEvent.VK_E);
	    	edit2.setIcon(new ImageIcon("ikonice/pencil.png"));
	    	
	    	izmenaStudenta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.CTRL_MASK));
	    	izmenaProfesora.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,ActionEvent.CTRL_MASK));
	    	izmenaPredmeta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,ActionEvent.CTRL_MASK));
	    	
		    edit2.add(izmenaStudenta);
		    edit2.add(izmenaProfesora);
		    edit2.add(izmenaPredmeta);
		    
		    edit1.add(edit2);
		    edit1.addSeparator();
		    
		    //BRISANJE
	       delete.setMnemonic(KeyEvent.VK_D);
		   delete.setIcon(new ImageIcon("ikonice/cancel.png"));
		   
		   brisanjeStudenta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.ALT_MASK));
		   brisanjeProfesora.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,ActionEvent.ALT_MASK));
	       brisanjePredmeta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,ActionEvent.ALT_MASK));
		   
		   delete.add(brisanjeStudenta);
		   delete.add(brisanjeProfesora);
		   delete.add(brisanjePredmeta);
		   
		   edit1.add(delete);
	    
	 //*********************************************************************************************** 
		   //HELP I ABOUT
		   help1.setMnemonic(KeyEvent.VK_5);
		   help1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5,ActionEvent.SHIFT_MASK));
		   help1.setIcon(new ImageIcon("ikonice/question.png"));
	    help.add(help1);
	    help.addSeparator();
	    
		   about.setMnemonic(KeyEvent.VK_6);
		   about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6,ActionEvent.SHIFT_MASK));
		   about.setIcon(new ImageIcon("ikonice/businessman-talking-about-data-analysis.png"));
	    help.add(about);
	   
	    about.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProzorAbout dialog = new ProzorAbout();
				dialog.setVisible(true);
			}
		});
	    
	    help1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProzorHelp dijalog = new ProzorHelp();
				dijalog.setVisible(true);
			}
		});
	   
	    
	    
	    
	    
	    
	    izmenaStudenta.addActionListener(new IzmjenaListener());
	    izmenaProfesora.addActionListener(new IzmjenaListener());
	    izmenaPredmeta.addActionListener(new IzmjenaListener());
	    
	    brisanjeStudenta.addActionListener(new BrisanjeListener());
	    brisanjeProfesora.addActionListener(new BrisanjeListener());
	    brisanjePredmeta.addActionListener(new BrisanjeListener());
	    
	    
	   
	   
	   
	    
	   file.setMnemonic(KeyEvent.VK_F);
	   edit1.setMnemonic(KeyEvent.VK_E);
	   help.setMnemonic(KeyEvent.VK_H);
	   
	    
	    add(file);
	    add(edit1);
	    add(help);
	    
	    brisanjeIzmjenaProvjera(TabbedPane.aktivanTab);
	    
	    
	    close.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					int opcija = JOptionPane.showConfirmDialog(GlavniProzor.getInstance(),"Da li sigurno zelite da zatvorite aplikaciju?","Zatvaranje aplikacije",JOptionPane.YES_NO_OPTION);
					if(opcija  == JOptionPane.YES_OPTION){
						try{
							StudentiController.getInstance().saveData();
							ProfesoriController.getInstance().saveData();
							PredmetiController.getInstance().saveData();
							System.exit(0);
						
						}catch(IOException ex){
							ex.printStackTrace();
						}
					}
					
					
				}
			});
		    
	}
		public void brisanjeIzmjenaProvjera(int aktivnaKartica){
			if(aktivnaKartica == 0){
				izmenaStudenta.setEnabled(true);
				izmenaPredmeta.setEnabled(false);
				izmenaProfesora.setEnabled(false);
				
				brisanjeStudenta.setEnabled(true);
				brisanjeProfesora.setEnabled(false);
				brisanjePredmeta.setEnabled(false);
				
				
				
				
			}
			if(aktivnaKartica == 1){
				izmenaStudenta.setEnabled(false);
				izmenaPredmeta.setEnabled(true);
				izmenaProfesora.setEnabled(false);
				
				brisanjeStudenta.setEnabled(false);
				brisanjeProfesora.setEnabled(false);
				brisanjePredmeta.setEnabled(true);
				dodajStudProf.setEnabled(true);
				dodajStud.setEnabled(true);
				dodajProf.setEnabled(true);
				
			}
			if(aktivnaKartica == 2){
				izmenaStudenta.setEnabled(false);
				izmenaPredmeta.setEnabled(false);
				izmenaProfesora.setEnabled(true);
				
				brisanjeStudenta.setEnabled(false);
				brisanjeProfesora.setEnabled(true);
				brisanjePredmeta.setEnabled(false);
				
			}
			
			
		}
	    
	

}