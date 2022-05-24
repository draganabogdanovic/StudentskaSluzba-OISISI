package rs.ac.uns.ftn.oisisi.view;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class IndexiTable  extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1030133583258536704L;

	private static IndexiTable instance = null;

	public static IndexiTable getInstance() {
		if(instance == null){
			instance = new IndexiTable();
		}
		
		return instance;
	}

	
	private IndexiTable(){
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractListaStudenataTable());
		
		this.setRowHeight(22);
		
	}

	
	public void refreshTable(){
		AbstractListaStudenataTable a = (AbstractListaStudenataTable) this.getModel();
		a.fireTableDataChanged();
		validate();
	}
	

	
}
