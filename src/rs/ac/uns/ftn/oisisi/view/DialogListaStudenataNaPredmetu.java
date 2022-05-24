package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import rs.ac.uns.ftn.oisisi.controller.PredmetiController;

public class DialogListaStudenataNaPredmetu extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2518712236091376126L;

	private JPanel donjiPanel;
	protected JButton odustani;
	protected JButton potvrdi;
	private JTable listaIndeksaStudenata;
  
	
	public DialogListaStudenataNaPredmetu(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setLayout(new BorderLayout());
		setSize(300,400);
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		donjiPanel = new JPanel();
		donjiPanel.setLayout(new GridLayout(1,2,100,50));
		
		odustani = new JButton("Odustani");
		potvrdi = new JButton("Obrisi");
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				PredmetiController.getInstance().IzbrisiStudentaSaPredmeta();
			}
		});
		
		
		donjiPanel.add(odustani);
		donjiPanel.add(potvrdi);
		PrikazTabele();
		add(donjiPanel, BorderLayout.SOUTH);
		setResizable(false);
	}
	
	private void PrikazTabele() {
		listaIndeksaStudenata =  TabelaIndeksa.getInstance();
		
		JScrollPane scrolovanje =  new JScrollPane(listaIndeksaStudenata);
		add(scrolovanje, BorderLayout.CENTER);
		TabelaIndeksa.getInstance().refreshTable();
	}

	
	
}
