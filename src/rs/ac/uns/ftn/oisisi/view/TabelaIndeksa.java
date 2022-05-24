package rs.ac.uns.ftn.oisisi.view;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TabelaIndeksa extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3438825437891339121L;

	
private static TabelaIndeksa instance = null;
	
	
	public static TabelaIndeksa getInstance() {
			if(instance == null) {
				instance = new TabelaIndeksa();
			}
			
			return instance;
	}
	
	
	private TabelaIndeksa() {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractListaStudenataTable());
		
		this.setRowHeight(20);
		
	}
	
	public void refreshTable() {
		AbstractListaStudenataTable apt = (AbstractListaStudenataTable) this.getModel();
		apt.fireTableDataChanged();
		validate();
	}
	
	
}
