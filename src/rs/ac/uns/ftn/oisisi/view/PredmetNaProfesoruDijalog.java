package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class PredmetNaProfesoruDijalog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7268697252906421104L;
	private static PredmetiNaProfesoriTable table;
	private JPanel down = null;
	private JButton close = null;

	public PredmetNaProfesoruDijalog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		setLayout(new BorderLayout());
		
		setSize(450, 250);
		setLocationRelativeTo(GlavniProzor.getInstance());
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		table = PredmetiNaProfesoriTable.getInstance();
		table.setBackground(new Color(140, 255, 150));
		table.setVisible(true);
		down = new JPanel();
		down.setLayout(new BorderLayout());
		close = new JButton("Zatvori");
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				
			}
		});
		down.add(close, BorderLayout.CENTER);
		add(new JScrollPane(table), BorderLayout.CENTER);
		add(down, BorderLayout.SOUTH);

	}
	
}
