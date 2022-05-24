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

public class ProzorAbout  extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -85002800989754402L;

	public ProzorAbout() {
		  
		  Toolkit kit=Toolkit.getDefaultToolkit();
			Dimension ScreenSize=kit.getScreenSize();
			int sh=ScreenSize.height;
			setSize(700,sh/2);
			setLocationRelativeTo(null);
			setTitle("About");
			JPanel paneld=new JPanel(new FlowLayout(FlowLayout.RIGHT));
			
			JTextArea helpdijalog=new JTextArea(20,20);
			helpdijalog.setEditable(false);
			helpdijalog.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 15));
			helpdijalog.setText(" Studentska sluzba\n\n"
					           +" Java aplikacija namijenjena za upravljanje studentskom sluzbom.\n"
							   + " Autori:\n"
							   + " Mladenka Kokanovic\n"
							   + "   Mesto rodjenja: Bijeljina\n"
							   + "   Datum rodjenja: 4.9.1998.\n"
							   + "   Srednja skola: Gimnazija Filip Visnjic\n"
							   + "   Fakultet: Fakulteta tehnickih nauka u Novom Sadu,smijer racunarstvo i automatika.\n\n"
							   + " Lidija Vukovic\n"
							   + "   Mesto rodjenja: Foca\n"
							   + "   Datum rodjenja: 23.10.1998.\n"
							   + "   Stednja skola: Gimnazija Foca\n"
							   + "   Fakultet: Fakulteta tehnickih nauka u Novom Sadu,smijer racunarstvo i automatika.\\n\\n\n\n\n\n\t\t\t\tDatum izrade: 12.01.2020.");
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
