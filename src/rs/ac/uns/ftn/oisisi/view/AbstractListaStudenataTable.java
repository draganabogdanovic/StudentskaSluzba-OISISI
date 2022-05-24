package rs.ac.uns.ftn.oisisi.view;

import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.Predmet;

public class AbstractListaStudenataTable extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1972957566641666667L;

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getRowCount() {
		int selected = PredmetiTablePane.getSelectedRow();
		Predmet p;

		if (BazaPredmeta.getBrojPredmetaKojiSuUPretrazi() == 0) {
			p = BazaPredmeta.getInstance().getPredmeti().get(selected);

		} else {
			p = BazaPredmeta.getInstance().getRezultat().get(selected);
		}

		return p.getStudenti().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int selected = PredmetiTablePane.getSelectedRow();
		if (selected != -1) {
			BazaPredmeta.getInstance();
			if (BazaPredmeta.getBrojPredmetaKojiSuUPretrazi() == 0) {
				Predmet p = BazaPredmeta.getInstance().getPredmeti().get(selected);
				if (rowIndex < p.getStudenti().size()) {
					switch (columnIndex) {
					case 0:
						return p.getStudenti().get(rowIndex).getBrIndeksa();
					case 1:
						return p.getStudenti().get(rowIndex).getIme();
					case 2:
						return p.getStudenti().get(rowIndex).getPrezime();
					default:
						break;
					}

				}

			} else {
				Predmet p = BazaPredmeta.getInstance().getRezultat().get(selected);
				if (rowIndex < p.getStudenti().size()) {
					switch (columnIndex) {
					case 0:
						return p.getStudenti().get(rowIndex).getBrIndeksa();
					case 1:
						return p.getStudenti().get(rowIndex).getIme();
					case 2:
						return p.getStudenti().get(rowIndex).getPrezime();
					default:
						break;
					}

				}
			}

		}
		return null;
	}

	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Broj indeksa";
		case 1:
			return "Ime";
		case 2:
			return "Prezime";
			default:
				return null;
		}
	}
}
