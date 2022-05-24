package rs.ac.uns.ftn.oisisi.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;


public class PredmetiTable extends JTable {

	private static PredmetiTable instance;

	public static PredmetiTable getInstance() {
		if (instance == null) {
			instance = new PredmetiTable();
		}
		return instance;
	}

	private static final long serialVersionUID = 6156577909785005774L;

	private PredmetiTable() {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractPredmetiTable());
		this.setRowHeight(20);

		new StudentiNaPredmetuButton(this, 5);

		new ProfesoriNaPredmetuDugmic(this, 4);

		

	}

	public void refreshTable() {
		AbstractPredmetiTable apt = (AbstractPredmetiTable) this.getModel();
		apt.fireTableDataChanged();
		validate();

	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component com = super.prepareRenderer(renderer, row, column);

		if (isRowSelected(row)) {
			setOpaque(true);
			com.setBackground(Color.GRAY);
		} else {

			if (row % 2 == 0) {
				com.setBackground(new Color (140, 255, 150));
			} else {
				com.setBackground(Color.white);
			}
		}
		return com;
	}

}