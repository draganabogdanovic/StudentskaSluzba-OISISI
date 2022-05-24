package rs.ac.uns.ftn.oisisi.view;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;


public class PredmetiNaProfesoriTable extends JTable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 6573351902317827951L;
	private static PredmetiNaProfesoriTable instance = null;


	public static PredmetiNaProfesoriTable getInstance() {
		if (instance == null) {
			instance = new PredmetiNaProfesoriTable();
		}
		return instance;
	}

	public PredmetiNaProfesoriTable() {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractPredmetiNaProfesoruTable());
		this.setRowHeight(20);
	}
}
