package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import rs.ac.uns.ftn.oisisi.controller.GlavniProzorListener;
import rs.ac.uns.ftn.oisisi.controller.TabbedPaneListener;

public class GlavniProzor extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7172980006787239595L;
	private static GlavniProzor instance = null;
	private MenuBar meniBar;
	private StatusBar statusbar;
	
	
	
	private GlavniProzor() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth*3/4, screenHeight*3/4);
		setTitle("Studentska sluzba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(210, 210, 210));
		setLayout(new BorderLayout());
		
		
		
		meniBar = MenuBar.getInstance();
		setJMenuBar(meniBar);
		meniBar.setVisible(true);
		
		//Dodavanje toolbara
		ToolBar tb = ToolBar.getInstance();
		add(tb, BorderLayout.NORTH);
		
		TabbedPane tp = new TabbedPane();
		tp.addChangeListener(new TabbedPaneListener());
		add(tp,BorderLayout.CENTER);
		
		statusbar = new StatusBar();
		add(statusbar,BorderLayout.SOUTH);
		
		addWindowListener(new GlavniProzorListener());

		
		//Ovo mora obavezno dole skroz iznad njega pisem
		setVisible(true);
		
	}
	
	public static GlavniProzor getInstance() {
		if(instance == null) {
			instance = new GlavniProzor();
		}
		return instance;
		
		
	}
	
	
	

}