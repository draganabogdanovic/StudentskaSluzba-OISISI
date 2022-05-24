package rs.ac.uns.ftn.oisisi.view;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane {
	
	
	private static final long serialVersionUID = 8993350662024258354L;
	private ProfesoriTablePane profesoriTabelePane = new ProfesoriTablePane();
	private StudentiTablePane studentiTabelePane = new StudentiTablePane();
	private PredmetiTablePane predmetiTabelePane = new PredmetiTablePane();
	
	public static int aktivanTab = 0;
	
	public TabbedPane() {
		//setOpaque(true);
		//setBackground(new Color(140, 255, 150));
		addTab("Studenti", new ImageIcon("images/learning.png"), studentiTabelePane, "Tabela studenata");
		addTab("Predmeti", new ImageIcon("images/homework.png"), predmetiTabelePane, "Tabela predmeta");
		addTab("Profesori", new ImageIcon("images/professor.png"), profesoriTabelePane, "Tabela profesora");
	}
}


