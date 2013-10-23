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
		Calendar cal=Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_WEEK);
		int d = 0;
		int x;
		int m = Integer.parseInt(JOptionPane.showInputDialog("Enter a month number"));
		int y = Integer.parseInt(JOptionPane.showInputDialog("Enter a year"));
		cal.set(y,(m+1), 1);
		DecimalFormat dual = new DecimalFormat("##");
		String[] months = new java.text.DateFormatSymbols().getMonths();

		System.out.print("    ");
		System.out.print(months[m-1]);
		System.out.print("  ");
		System.out.print(y);
		System.out.println();
		System.out.println("S  M  Tu  W  Th F  S");
		for (int line = 1; line <= 5; line++) {
			for (int num = 1; num <= (line); num++) {
				d = num;
			}
			for (int num = 1; num <= (cal.getFirstDayOfWeek()+7); num++) {
				if (Integer.toString(d).length() == 1)	{
					if (d > 1)
						System.out.print(" " + dual.format(d)+ " ");
					else
						System.out.print(" " + " " + " ");
				}
				else	{
					System.out.print(dual.format(d)+ " ");
					if (d > 1)
						System.out.print(" " + dual.format(d)+ " ");
					else
						System.out.print(" " + "  " + " ");
				}
			}
			System.out.println();
		}

	}

}
