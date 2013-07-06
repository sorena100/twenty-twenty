import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimerTask;

import javax.swing.JOptionPane;


public class MyTimerTask extends TimerTask {
  public void run(){
		Showarm sa = new Showarm();
		JOptionPane.showMessageDialog(sa, "۲۰ ثانیه به ۲۰ قدمی نگاه کن!","آلارم",JOptionPane.INFORMATION_MESSAGE);
			
		
	}
}
