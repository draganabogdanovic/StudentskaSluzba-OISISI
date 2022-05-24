package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel implements Runnable{

	
	private static final long serialVersionUID = -5069844936339906003L;
	
	private JLabel vrijeme;
	private Thread th;
	
	
	@Override
	public void run() {
		try{
			do{
				DateFormat data = new SimpleDateFormat("HH:mm dd.MM.yyyy.");
				Calendar kalendar = Calendar.getInstance();
				vrijeme.setText(data.format(kalendar.getTime()));
				Thread.sleep(1000);
				
			}while(th.isAlive());
			
		}catch(Exception e){
		
		}
		
	}


	StatusBar(){
		setPreferredSize(new Dimension(100,20));
		setLayout(new BorderLayout());
		JLabel left= new JLabel(" Studenstka sluzba");
		add(left, BorderLayout.WEST);
		
		vrijeme= new JLabel();
		setOpaque(true);
		setBackground(new Color(210,210,210));

		add(vrijeme, BorderLayout.EAST);
		th = new Thread(this);
		th.start();
		
		
		
		
		
	}

}
