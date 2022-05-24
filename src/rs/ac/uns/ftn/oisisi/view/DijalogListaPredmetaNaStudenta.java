package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class DijalogListaPredmetaNaStudenta extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7128438369496269090L;
		
	

	private JPanel donjiPanel;
	protected JButton odustani;
	private JTable listaSifriPredmeta;
  
	
	public DijalogListaPredmetaNaStudenta(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setLayout(new BorderLayout());
		setSize(300,400);
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		donjiPanel = new JPanel();
		donjiPanel.setLayout(new BorderLayout());
		
		odustani = new JButton("Zatvori");
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		donjiPanel.add(odustani, BorderLayout.CENTER);
		PrikazTabele();
		add(donjiPanel, BorderLayout.SOUTH);
		setResizable(false);
	}
	
	private void PrikazTabele() {
		listaSifriPredmeta =  TabelaSifriPredmeta.getInstance();
		
		JScrollPane scrol =  new JScrollPane(listaSifriPredmeta);
		add(scrol, BorderLayout.CENTER);
		TabelaIndeksa.getInstance().refreshTable();
	}

	
	
}
