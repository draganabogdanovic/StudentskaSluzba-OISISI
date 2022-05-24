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

import rs.ac.uns.ftn.oisisi.controller.StudentiController;

public class StudentiTablePane extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 995651005024254656L;
	
	private StudentiTable studentiTable;
	private JScrollPane scrollPane;
	
	public static int selectedRow = -1;
	
	public StudentiTablePane(){
		setLayout(new BorderLayout());
		setOpaque(true);
		setBackground(new Color(140, 255, 150));
		createStudentiTable();
	}
	
	private void createStudentiTable(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int swidth = screenSize.width;
		int sHeight = screenSize.height;
		
		JPanel top = new JPanel();
		JPanel down = new JPanel();
		JPanel left = new JPanel();
		JPanel rigth = new JPanel();
		
		top.setOpaque(false);
		down.setOpaque(false);
		left.setOpaque(false);
		rigth.setOpaque(false);
		
		top.setPreferredSize(new Dimension(swidth,sHeight/10));
		down.setPreferredSize(new Dimension(swidth,sHeight/10));
		
		
		add(top,BorderLayout.NORTH);
		add(down,BorderLayout.SOUTH);
		add(left,BorderLayout.WEST);
		add(rigth,BorderLayout.EAST);
		
		studentiTable = StudentiTable.getInstance();
		scrollPane = new JScrollPane(studentiTable);
		
		
		try { 
			StudentiController.getInstance().loadData() ;
			
			StudentiTable.getInstance().refreshTable();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(studentiTable.getModel());
		studentiTable.setRowSorter(sorter);
		
		studentiTable.addMouseListener(new MouseListener() {
			
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

			
		
		
		
		
		
		
		
		add(scrollPane,BorderLayout.CENTER);
		
	}

	public static void setSelectedRow(int selektovanaVrsta) {
		StudentiTablePane.selectedRow =  selektovanaVrsta;
		
	}
	public static int getSelectedRow(){
		return selectedRow;
	}
		
		
	
}
