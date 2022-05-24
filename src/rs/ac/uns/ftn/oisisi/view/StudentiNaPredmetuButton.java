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

public class StudentiNaPredmetuButton extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2945825974133860645L;
	
	private JButton renderButton;
	private JButton editorButton;

	private JTable table;

	private boolean isEditorActive = false;

	public StudentiNaPredmetuButton(JTable table, int column) {

		this.table = table;
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		this.table.getColumnModel().getColumn(column).setCellEditor(this);

		this.renderButton = new JButton("Studenti");
		this.editorButton = new JButton("Studenti");
		this.table.addMouseListener(this);

		this.editorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				DialogListaStudenataNaPredmetu d = new DialogListaStudenataNaPredmetu(GlavniProzor.getInstance(), "Lista studenata", true);
				d.setVisible(true);

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
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub

		return editorButton;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		return renderButton;
	}

	public JButton getRenderButton() {
		return renderButton;
	}

	public void setRenderButton(JButton renderButton) {
		this.renderButton = renderButton;
	}

	public JButton getEditorButton() {
		return editorButton;
	}

	public void setEditorButton(JButton editorButton) {
		this.editorButton = editorButton;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public boolean isEditorActive() {
		return isEditorActive;
	}

	public void setEditorActive(boolean isEditorActive) {
		this.isEditorActive = isEditorActive;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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

	

}
