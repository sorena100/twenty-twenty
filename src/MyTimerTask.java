import java.util.TimerTask;

import javax.swing.JOptionPane;


public class MyTimerTask extends TimerTask {
	public void run(){
		Showarm sa = new Showarm();
		JOptionPane.showMessageDialog(sa, "look at somewhere 20 steps far","",JOptionPane.INFORMATION_MESSAGE);
		
	}
}
