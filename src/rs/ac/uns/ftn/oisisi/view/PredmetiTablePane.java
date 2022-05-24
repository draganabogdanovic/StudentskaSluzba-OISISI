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

import rs.ac.uns.ftn.oisisi.controller.PredmetiController;

public class PredmetiTablePane extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5636642190720334125L;
	private PredmetiTable predmTabele;
	private JScrollPane scrollPane;

	public static int selectedRow = -1;

	public PredmetiTablePane() {

		setLayout(new BorderLayout());
		setOpaque(true);
		setBackground(new Color(140, 255, 150));
		createPredmetiTable();

	}

	private void createPredmetiTable() {

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
			PredmetiController.getInstance().loadData();
		} catch (IOException e) {
			e.printStackTrace();
		}

		predmTabele = PredmetiTable.getInstance();
		scrollPane = new JScrollPane(predmTabele);

		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(predmTabele.getModel());
		predmTabele.setRowSorter(sorter);

		predmTabele.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				JTable jt = (JTable) e.getComponent();
				selectedRow = jt.convertRowIndexToModel(jt.getSelectedRow());
				// System.out.println(selectedRow);

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

	public static int getSelectedRow() {
		return selectedRow;
	}

	public static void setSelectedRow(int i) {
		selectedRow = i;
		
	}


}