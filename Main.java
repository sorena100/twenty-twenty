import javax.swing.JOptionPane;


public class Main {

  public static void main(String[] args) {
		Showarm sa = new Showarm();
		JOptionPane.showMessageDialog(sa,"هر ۲۰ دقیقه به مدت ۲۰ ثانیه به ۲۰ متری خود نگاه کنید!","راهنما",JOptionPane.INFORMATION_MESSAGE);
		sa.setVisible(true);
	}

}
