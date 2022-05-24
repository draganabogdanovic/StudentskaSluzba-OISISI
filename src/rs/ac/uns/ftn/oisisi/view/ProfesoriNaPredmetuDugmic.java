package rs.ac.uns.ftn.oisisi.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.Profesor;

public class ProfesoriNaPredmetuDugmic extends AbstractCellEditor implements
TableCellEditor, TableCellRenderer, MouseListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6617761671144302406L;
	private JButton renderButton;
	private JButton edirotButton;
	
	private JTable table;
	
	private boolean isEditorActive = false;
	
	public ProfesoriNaPredmetuDugmic(JTable table, int column) {
		this.table = table;
		this.table.getColumnModel().getColumn(column).setCellEditor(this);
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		
		this.renderButton = new JButton("Profesori");
		this.edirotButton = new JButton("Profesori");
		
		this.table.addMouseListener(this);
		
		this.edirotButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedPredmet = PredmetiTablePane.getSelectedRow();
				
				Profesor profesor;
				if(BazaPredmeta.getBrojPredmetaKojiSuUPretrazi() == 0) {
					profesor = BazaPredmeta.getInstance().getPredmeti().get(selectedPredmet).getProfesor();
				}else {
					profesor = BazaPredmeta.getInstance().getRezultat().get(selectedPredmet).getProfesor();
				}
				if(profesor == null) {
					JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Predmetu nije dodjeljen profesor", "Upozorenje!", JOptionPane.WARNING_MESSAGE);
				}else {
					ProfesoriNaPredmetuDijalog dijalog = new ProfesoriNaPredmetuDijalog(GlavniProzor.getInstance(), "Predmetni profesor", true, profesor);
					dijalog.setVisible(true);
				}
			}
		});
		this.isEditorActive = false;
	}

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(table.isEditing() && table.getCellEditor() == this) {
			this.isEditorActive = true;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if (isEditorActive && table.isEditing()) {
			table.getCellEditor().stopCellEditing();
		}
		isEditorActive = false;

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return renderButton;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return edirotButton;
	}

}
