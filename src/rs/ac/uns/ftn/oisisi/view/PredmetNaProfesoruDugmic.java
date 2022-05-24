package rs.ac.uns.ftn.oisisi.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class PredmetNaProfesoruDugmic extends AbstractCellEditor implements TableCellEditor, TableCellRenderer, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3332179036784185167L;
	private JButton renderButton;
	private JButton edirotButton;

	private JTable table;

	private boolean isEditorActive = false;

	public PredmetNaProfesoruDugmic(JTable table, int column) {

		this.table = table;
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		this.table.getColumnModel().getColumn(column).setCellEditor(this);

		this.renderButton = new JButton("Profesori");
		this.edirotButton = new JButton("Profesori");
		
		this.table.addMouseListener(this);
		this.edirotButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				PredmetNaProfesoruDijalog dialog = new PredmetNaProfesoruDijalog(GlavniProzor.getInstance(),
						"Predmeti na kojima predaje profesor", true);
				dialog.setVisible(true);
			}
		});

		renderButton.setSelected(false);

		this.setEditorActive(false);
	}
	


	
	@Override
	public void mousePressed(MouseEvent e) {
		if (table.isEditing() && table.getCellEditor() == this) {
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
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return edirotButton;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return renderButton;
	}
	public boolean isEditorActive() {
		return isEditorActive;
	}

	public void setEditorActive(boolean isEditorActive) {
		this.isEditorActive = isEditorActive;
	}

	public JButton getRenderButton() {
		return renderButton;
	}

	public void setRenderButton(JButton renderButton) {
		this.renderButton = renderButton;
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

}
