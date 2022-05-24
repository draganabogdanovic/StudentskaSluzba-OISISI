package rs.ac.uns.ftn.oisisi.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;


public class ProfesoriTable extends JTable {

	public static int selectedRow = -1;
	/**
	 * 
	 */

	private static final long serialVersionUID = 842515504975764579L;

	private static ProfesoriTable instance;

	public static ProfesoriTable getInstance() {
		if (instance == null) {
			instance = new ProfesoriTable();
		}
		return instance;
	}

	private ProfesoriTable() {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractProfesoriTable());
		this.setRowHeight(20);
		
		new PredmetNaProfesoruDugmic(this, 10);

	}

	public void resfreshTable() {
		AbstractProfesoriTable apt = (AbstractProfesoriTable) this.getModel();
		apt.fireTableDataChanged();
		validate();
		this.setModel(apt);

	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component com = super.prepareRenderer(renderer, row, column);

		if (isRowSelected(row)) {
			com.setBackground(Color.GRAY);
		} else {

			if (row % 2 == 0) {
				com.setBackground(new Color(140, 255, 150));
			} else {
				com.setBackground(Color.white);
			}
		}
		return com;
	}

}
