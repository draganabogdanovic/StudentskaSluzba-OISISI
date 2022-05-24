package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ProzorHelp  extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6625621281604677885L;

public  ProzorHelp(){
		
		
		
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension ScreenSize=kit.getScreenSize();
		int sh=ScreenSize.height;
		setTitle("Help");
		setSize(1000,(int) (sh*0.8));
		setLocationRelativeTo(null);
		JPanel paneld=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		
		JTextArea helpdijalog=new JTextArea(20,20);
		helpdijalog.setEditable(false);
		helpdijalog.setFont(new Font(Font.SERIF, Font.ITALIC, 17));
		helpdijalog.setText(" Java aplikacija 'Studentska sluzba' omogucava rukovanje bazom podataka studenata,profesora i predemta.\n"
				+ " Sastoji se od tri  glavne tabele  a to su tabela profesora,studenata i predmeta.\n"
				+ "Odabirom odgovarajucih ikonica u  Meniju i Toolbar-u u aplikaciji\n"
				+"se moze vrsiti dodavanje,brisanje,izjmena ili  pretraga studenata,profesora ili predmeta.\n"
				+ " Takodje moguce je sortiranje kolona u tabelama kao i dodjeljivanje studentima i profesorima odgovovarajucih predmeta.\n\n"
				+ " Precica za olaksan rad:\n\n"
				+ "ALT+F   -   File\n"
				+ " ALT+N  -   Edit \n"
				+ " ALT+H   -   Help\n"
				+ " SHIFT +1    - Dodavanje novog studenta \n"
				+ " SHIFT +2   -   Dodavanje novog predmeta\n"
				+ " SHIFT +3   -   Dodavanje novog profesora\n"
				+ "CTRL +1     -   Izmjena postojeg studenta iz odgovarajuce karice\n"
				+ "CTRL +2      - Izmjena postojeceg predmeta iz odgivarajuce kartice\n"
				+ "CTRL +3      - Izmjena postojeceg profesora iz odgovarajuce kartice\n"
				+ "ALT +1    - Brisanje postojeceg studenta iz odgovarajuce kartice\n"
				+ "ALT + 2   - Brisanje postojeceg predmeta iz odgovarajuce kartice\n"
				+ "ALT +3  - Brisanje postojeceg predmeta iz odgovarajuce kartice\n"
				+ "SHIFT +5 - Help prozor\n"
				+ "SHIFT +6 -About prozor\n"
				+ "CTRL + C - Zatavranje aplikacije");
		getContentPane().add(helpdijalog);

		
		JButton ok = new JButton("OK"); 
		JPanel panelBottom = new JPanel();
		ok.addActionListener(this);
		panelBottom.add(ok);
		add(panelBottom, BorderLayout.SOUTH);
		
		paneld.add(ok);
		getContentPane().add(paneld,BorderLayout.SOUTH);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("OK"))
			setVisible(false);
	}

}
