import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.JOptionPane;

public class HC_SM_NestedLoops_3 {

	/**
	 * @author Sherif and Hunter
	 */
	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance(TimeZone.getDefault());
		int m = 8; //Integer.parseInt(JOptionPane.showInputDialog("Enter a month number"));
		int y = 2013;//Integer.parseInt(JOptionPane.showInputDialog("Enter a year"));
		cal.set(y,(m+1), 1);
		int begin = cal.get(Calendar.DAY_OF_WEEK);
		DecimalFormat dual = new DecimalFormat("##");
		String[] months = new java.text.DateFormatSymbols().getMonths();
		int d = begin*-1+2;
		//days in month
		int[] dim = {31,28,31,30,31,30,31,31,30,31,30,31};
		if (y%4 == 0)
			dim[1] = 29;
		int end = dim[m+1];
		
		System.out.print("    ");
		System.out.print(months[m-1]);
		System.out.print("  ");
		System.out.print(y);
		System.out.println();
		System.out.println(" S  M  Tu W  Th F  S");
		for (int line = 1; line <= 5; line++) {
			for (int day = 1; day <= 7; day++)	{
				if (d-1 == end)
					break;
				if (d > 0)	{
					if (d<=9)
						System.out.print(" ");
					System.out.print(dual.format(d)+ " ");
				}
				else
					System.out.print(" " + " " + " ");
				d++;
			}
			System.out.println();
		}
	}

}
