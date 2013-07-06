import java.awt.AWTException;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
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
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.smartcardio.CommandAPDU;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Popup;
import javax.swing.UIManager;
import javax.xml.bind.ParseConversionEvent;


public class Showarm extends JFrame{
  
	MyTime mt = new MyTime();
	int min0 = mt.run0();
	int min1 = mt.run1();
	int min2 = mt.run2();
	
	JLabel lbhelp,lbhelp2;
	TrayIcon trayIcon;
    SystemTray tray;
	
	public Showarm(){
		
		super("twenty twenty");
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(500, 300);
		//componenets
		lbhelp = new JLabel();
		lbhelp2 = new JLabel();
		lbhelp2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		lbhelp.setText("هر ۲۰ دقیقه به مدت ۲۰ ثانیه به ۲۰ قدمی خود نگاه کنید!");
		String s = "<html>"+ "برای بخاطر سپاری بهتر و رفع خستگی چشمها، عده ای قانون 20-20-20 را پیشنهاد می کنند یعنی، هر 20 دقیقه، 20 ثانیه به جایی در 20 قدمی خود نگاه کنید (این 20 قدم چیزی حدود 6-7 متر می شود) اما من ترجیح می دهم این قانون را به این صورت اصلاح کنم: هر 20 دقیقه 20 ثانیه به فاصله دور نگاه کنید و 20 قدم هم راه بروید. اینطوری هم از خستگی چشمها در امان خواهید بود و هم درد کمر و کتف و شانه ها کمتر به سراغتان می آید. چون توصیه شده است که بعد از مدتی نشستن، بهتر است چند قدم راه بروید. ‏" + "</html>";
		lbhelp2.setText(s);
		lbhelp2.setPreferredSize(new Dimension(450, 275));
		add(lbhelp);
		add(lbhelp2);
		
		
		
		final Timer t = new Timer();
		MyTimerTask task = new MyTimerTask();
		t.schedule(task, 1000l * 60 * 20);
		
		
		
		//tray icon
	        //System.out.println("creating instance");
	        try{
	            //System.out.println("setting look and feel");
	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        }catch(Exception e){
	            //System.out.println("Unable to set LookAndFeel");
	        }
	        if(SystemTray.isSupported()){
	            //System.out.println("system tray supported");
	            tray=SystemTray.getSystemTray();

	            Image image = Toolkit.getDefaultToolkit().getImage("tray.png");
	            ActionListener exitListener=new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    //System.out.println("Exiting....");
	                    System.exit(0);
	                }
	            };
	            PopupMenu popup=new PopupMenu();
	            MenuItem defaultItem=new MenuItem("خروج");
	            defaultItem.addActionListener(exitListener);
	            popup.add(defaultItem);
	            defaultItem=new MenuItem("پنجره اصلی");
	            defaultItem.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    setVisible(true);
	                    setExtendedState(JFrame.NORMAL);
	                }
	            });
	            popup.add(defaultItem);
	            final MenuItem pauseItem=new MenuItem("مکث");
	            popup.add(pauseItem);
	            //final String name = pauseItem.getLabel();
	            pauseItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						
						if (pauseItem.getLabel() == "مکث") {
							t.cancel();
							pauseItem.setLabel("ادامه");
						}
						else if (pauseItem.getLabel() == "ادامه") {
							Timer t = new Timer();
							MyTimerTask task = new MyTimerTask();
							t.schedule(task, 1000l * 60 * 20);
							pauseItem.setLabel("مکث");
						}
					}
					
				});
	            
	            trayIcon=new TrayIcon(image, "twenty-twenty", popup);
	            trayIcon.setImageAutoSize(true);
	            trayIcon.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(true);
	                    setExtendedState(JFrame.NORMAL);
					}
				});
	        }else{
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
