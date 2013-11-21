package mrMarco_gui;
//Benjamin's Tester ProgramsÂ©

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.*;

public class emptyframe {
	private static JFrame frame;
	public emptyframe(){
		frame = new JFrame();
		frame.setBounds(400, 150, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel title = new JLabel("Chicken Chicken Chicken Chicken");
		title.setFont(new Font("Dialog", Font.BOLD, 20));
		title.setBounds(28, 12, 392, 46);
		frame.add(title);
		
		JLabel heading = new JLabel("Beef Beef Beef Beef");
		heading.setFont(new Font(null, Font.BOLD, 12));
		heading.setBounds(30, 60, 392, 46);
		frame.add(heading);
		
		final JLabel output = new JLabel("");
		output.setFont(new Font(null, Font.BOLD, 14));
		output.setBounds(30, 120, 392, 46);
		frame.add(output);
		
		String[] months = new java.text.DateFormatSymbols().getMonths();
        SpinnerModel monthModel = new SpinnerListModel(months);
        final JSpinner monthspin = addSpinner(frame,monthModel);
        monthspin.setBounds(30, 100, 90, 20);
        
        final SpinnerModel yearModel = new SpinnerNumberModel(1990, 2013 - 100, 2013, 1);
        final JSpinner yearspin = addSpinner(frame,yearModel);
        yearspin.setBounds(130, 100, 90, 20);
        yearspin.setEditor(new JSpinner.NumberEditor(yearspin, "#"));
        
        SpinnerModel daymodel = new SpinnerNumberModel(1, 1, 31, 1);
        final JSpinner dayspin = addSpinner(frame,daymodel);
        dayspin.setBounds(230, 100, 90, 20);
        
        JButton confirmbtn = new JButton("Confirm");
        frame.add(confirmbtn);
        confirmbtn.setFont(new Font(null, Font.BOLD, 12));
        confirmbtn.setBounds(330, 100, 90, 20);
		confirmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int y = (Integer) yearspin.getValue();
				String m = (String) monthspin.getValue();
				int d = (Integer) dayspin.getValue();
				if (y != 1996)	{
					if (y > 1996)	{
						int year = y - 1996;
					output.setText("Hunter is " + year + " years older than you");
					}
					else	{
						int year = 1996 - y;
					output.setText("You are " + year + " years older than Hunter");
					}
				}		
			}
		});
		
	}
	static JSpinner addSpinner(Container c, SpinnerModel model) {
        JSpinner spinner = new JSpinner(model);
        c.add(spinner);

        return spinner;
}
}
