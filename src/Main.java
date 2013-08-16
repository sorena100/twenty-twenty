import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			    if ("com.sun.java.swing.plaf.gtk.GTKLookAndFeel".equals(info.getClassName())) {   
			       javax.swing.UIManager.setLookAndFeel(info.getClassName());
			       break;
			     } 
			}
		} catch (Exception e) {
			System.out.println("Warning: Unable to set LookAndFeel");
		}
		Showarm sa = new Showarm();
		JOptionPane.showMessageDialog(sa,"Each 20 min look at anywhere 20 steps far for 20 sec!","Quick help",JOptionPane.INFORMATION_MESSAGE);
		sa.setVisible(true);
		
		
		//   add to autostart
//		String username = System.getProperty("user.name");
//		File f = new File("/home/"+ username + "/.config/autostart/twenty-twenty-0.1.3.jar");
//		
//		
//		
//	      if(f.exists()){
//	          // :)
//	      }else{
//	    	  try {
//	    		File  target = new File("/home/"+ username + "/.config/autostart/twenty-twenty.jar");
//	    		String strsource = new File(".").getCanonicalPath() + "/twenty-twenty-0.1.3.jar";
//				File source = new File(strsource);
//				
//				InputStream in = new FileInputStream(source);
//				OutputStream out = new FileOutputStream(target);
//				
//				byte[] buf = new byte[1024];
//				
//				int len;
//				while ((len = in.read(buf)) > 0) {
//					out.write(buf, 0, len);
//				}
//				
//				in.close();
//				out.close();
//				
//				File  target2 = new File("/home/"+ username + "/.config/autostart/twenty-twenty.sh.desktop");
//	    		String strsource2 = new File(".").getCanonicalPath() + "/twenty-twenty.sh.desktop";
//				File source2 = new File(strsource2);
//				
//				InputStream in2 = new FileInputStream(source2);
//				OutputStream out2 = new FileOutputStream(target2);
//				
//				byte[] buf2 = new byte[1024];
//				
//				int len2;
//				while ((len2 = in2.read(buf2)) > 0) {
//					out2.write(buf2, 0, len2);
//				}
//				
//				in2.close();
//				out2.close();
//				
//				File  target3 = new File("/home/"+ username + "/.config/autostart/twenty-twenty.sh");
//	    		String strsource3 = new File(".").getCanonicalPath() + "/twenty-twenty.sh";
//				File source3 = new File(strsource3);
//				
//				InputStream in3 = new FileInputStream(source3);
//				OutputStream out3 = new FileOutputStream(target3);
//				
//				byte[] buf3 = new byte[1024];
//				
//				int len3;
//				while ((len3 = in3.read(buf3)) > 0) {
//					out3.write(buf3, 0, len3);
//				}
//				
//				in3.close();
//				out3.close();
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	      }
	}
	

}
