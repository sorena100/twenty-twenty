import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class MyTime {
  
	public int run0(){
	DateFormat dateFormat = new SimpleDateFormat("mm");
	long min = System.currentTimeMillis();
	int min0 = Integer.parseInt(dateFormat.format(min));
	return min0;
	}
	
	public int run1(){
		int min0 = run0();
		int min1 = min0 + 20;
		if (min1 > 59) min1 = min1 - 60;
		return min1;
		}
	
	public int run2(){
		int min1 = run1();
		int min2 = min1 + 20;
		if (min2 > 59) min2 = min2 - 60;
		return min2;
		}
}
