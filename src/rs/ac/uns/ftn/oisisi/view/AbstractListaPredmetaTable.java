package rs.ac.uns.ftn.oisisi.view;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import rs.ac.uns.ftn.oisisi.model.BazaStudent;
import rs.ac.uns.ftn.oisisi.model.Student;

public class AbstractListaPredmetaTable extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7779021532998057607L;

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getRowCount() {
		int selektovan = StudentiTablePane.getSelectedRow();
		Student s;
		BazaStudent.getInstance();
		if (BazaStudent.getBrojStudenataUPretrazi() == 0) {
			s = BazaStudent.getInstance().getSpisakStudenata().get(selektovan);

		} else {
			s = BazaStudent.getInstance().getRezultatPretrage().get(selektovan);
		}
		return s.getSpisakPredmeta().size();
	}

	@Override
	public Object getValueAt(int indeksVrste, int indeksKolone) {
		int selektovan = StudentiTablePane.getSelectedRow();
		if (selektovan > -1) {
			Student s;
			BazaStudent.getInstance();
			if (BazaStudent.getBrojStudenataUPretrazi() == 0) {
				s = BazaStudent.getInstance().getSpisakStudenata().get(selektovan);
				return s.getSpisakPredmeta().get(indeksVrste).getSifraPredmeta();
			} else {
				s = BazaStudent.getInstance().getRezultatPretrage().get(selektovan);
				return s.getSpisakPredmeta().get(indeksVrste).getSifraPredmeta();
			}
		}

		return null;
	}

	
	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return "Sifra predmeta za studenta:";
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}
}
