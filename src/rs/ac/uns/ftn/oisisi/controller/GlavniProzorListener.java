package rs.ac.uns.ftn.oisisi.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class GlavniProzorListener implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		JFrame frame = (JFrame) e.getComponent();
		int biraj = JOptionPane.showConfirmDialog(frame, "Da li sigurno zatvarate aplikaciju?", "Zatvaranje aplikacije", JOptionPane.YES_NO_OPTION);
		if(biraj == JOptionPane.YES_OPTION) {
			try {
				PredmetiController.getInstance().saveData();
				StudentiController.getInstance().saveData();
				ProfesoriController.getInstance().saveData();
			}catch (IOException e1) {
				e1.printStackTrace();
			}
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}else {
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		}
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
