package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import rs.ac.uns.ftn.oisisi.controller.ProfesoriController;

public class ProfesoriTablePane extends JPanel {

	private static final long serialVersionUID = -8227539452514756431L;

	private ProfesoriTable profTabele;
	private JScrollPane scrollPane;

	public static int selectedRow = -1;

	public ProfesoriTablePane() {

		setLayout(new BorderLayout());
		setOpaque(true);
		setBackground(new Color(140, 255, 150));
		createProfesoriTable();

	}

	private void createProfesoriTable() {

		Toolkit tkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = tkit.getScreenSize();
		int sswidth = screenSize.width;
		int ssheight = screenSize.height;

		JPanel top = new JPanel();
		JPanel down = new JPanel();
		JPanel left = new JPanel();
		JPanel right = new JPanel();

		top.setOpaque(false);
		down.setOpaque(false);
		left.setOpaque(false);
		right.setOpaque(false);

		top.setPreferredSize(new Dimension(sswidth, ssheight / 10));
		down.setPreferredSize(new Dimension(sswidth, ssheight / 10));

		add(top, BorderLayout.NORTH);
		add(down, BorderLayout.SOUTH);
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);
		try {
			ProfesoriController.getInstance().loadData();
		} catch (IOException e) {
			e.printStackTrace();
		}

		profTabele = ProfesoriTable.getInstance();
		scrollPane = new JScrollPane(profTabele);

		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(profTabele.getModel());
		profTabele.setRowSorter(sorter);

		profTabele.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				JTable jt = (JTable) e.getComponent();
				selectedRow = jt.convertRowIndexToModel(jt.getSelectedRow());

			}

			@Override
			public void mousePressed(MouseEvent e) {
				JTable jt = (JTable) e.getComponent();
				selectedRow = jt.convertRowIndexToModel(jt.getSelectedRow());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		add(scrollPane, BorderLayout.CENTER);
	}

	public static void setSelectedRow(int selektovanaVrsta) {
		ProfesoriTablePane.selectedRow = selektovanaVrsta;

	}

	public static int getSelectedRow() {
		return selectedRow;
	}

}
