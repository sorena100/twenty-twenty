import java.awt.AWTException;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.net.URL;
import java.util.Timer;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Showarm extends JFrame{
	
	
	
	
	JLabel lbhelp,lbhelp2;
	TrayIcon trayIcon;
    SystemTray tray;
	
	public Showarm(){
		super("Twenty twenty");

		URL iconURL = getClass().getResource("icon.png");
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(670, 300);
		setResizable(false);
		setLocationRelativeTo(getRootPane());
		
		//componenets
		URL iconURL2 = getClass().getResource("original.jpg");
		ImageIcon pic = new ImageIcon(iconURL2);
		JLabel pn = new JLabel(pic);
		lbhelp = new JLabel();
		lbhelp2 = new JLabel();
		lbhelp.setText("Each 20 min look at somewhere 20 steps far for 20 sec!");
		String s = "<html>"+ "Observe the 20-20-20 Rule. Looking into the distance to let your eyes relax is called the 20-20-20 rule, and is an easy trick to remember to reduce eyestrain. The rule says that for every 20 minutes you spend staring at the computer, you should spend 20 seconds looking at objects 20 feet away – or at least far enough away that your eyes aren't working to focus.‏" + "</html>";
		lbhelp2.setText(s);
		lbhelp2.setPreferredSize(new Dimension(300, 175));
		
		JPanel belowpan = new JPanel();
		belowpan.setLayout(new BoxLayout(belowpan, BoxLayout.X_AXIS));
		belowpan.add(lbhelp2);
		belowpan.add(pn);
		
		JPanel mainpan = new JPanel();
		mainpan.setPreferredSize(new Dimension(660, 300));
		mainpan.setLayout(new BoxLayout(mainpan, BoxLayout.Y_AXIS));
		mainpan.add(lbhelp);
		lbhelp.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainpan.add(new JLabel("  "));
		mainpan.add(new JLabel("  "));
		mainpan.add(belowpan);
		
		add(mainpan);
		
		//Timer
		final Timer t = new Timer();
		MyTimerTask task = new MyTimerTask();
		t.schedule(task, 1000l * 60 * 20); //set 20 min loop
		
		
		
		//tray icon
	        if(SystemTray.isSupported()){
	            tray=SystemTray.getSystemTray();
	            ActionListener exitListener=new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    System.exit(0);
	                }
	            };
	            PopupMenu popup=new PopupMenu();
	            MenuItem defaultItem=new MenuItem("Exit");
	            defaultItem.addActionListener(exitListener);
	            popup.add(defaultItem);
	            defaultItem=new MenuItem("Home");
	            defaultItem.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    setVisible(true);
	                    setExtendedState(JFrame.NORMAL);
	                }
	            });
	            popup.add(defaultItem);
	            final MenuItem pauseItem=new MenuItem("pause");
	            popup.add(pauseItem);
	            pauseItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						
						if (pauseItem.getLabel() == "pause") {
							t.cancel();
							pauseItem.setLabel("resume");
						}
						else if (pauseItem.getLabel() == "resume") {
							Timer t = new Timer();
							MyTimerTask task = new MyTimerTask();
							t.schedule(task, 1000l * 60 * 20);
							pauseItem.setLabel("pause");
						}
					}
					
				});
	            Image image = Toolkit.getDefaultToolkit().getImage("tray.png");
	            trayIcon=new TrayIcon(image, "twenty-twenty", popup);
	            trayIcon.setImageAutoSize(true);
	            trayIcon.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(true);
	                    setExtendedState(JFrame.NORMAL);
					}
				});
	        }else{
	        	System.out.println("Warning: System Tray is not suported!");
	        }
	        addWindowStateListener(new WindowStateListener() {
	            public void windowStateChanged(WindowEvent e) {
	                if(e.getNewState()==ICONIFIED){
	                    try {
	                        tray.add(trayIcon);
	                        setVisible(false);
	                    } catch (AWTException ex) {
	                    }
	                }
	        if(e.getNewState()==7){
	                    try{
	            tray.add(trayIcon);
	            setVisible(false);
	            }catch(AWTException ex){
	        }
	            }
	        if(e.getNewState()==MAXIMIZED_BOTH){
	                    tray.remove(trayIcon);
	                    setVisible(true);
	                }
	                if(e.getNewState()==NORMAL){
	                    tray.remove(trayIcon);
	                    setVisible(true);
	                }
	            }
	        });
	       
		
		
	}
}

