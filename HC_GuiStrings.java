import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Eleven_D_HC {

	/**
	 * @author Hunter Caron
	 * Mr.Marco
	 * Strings Assignment 11a
	 * part 2
	 */

	public static void main(String[] args) {
		//creating frame
		final JFrame frame = new JFrame();
		frame.setBounds(450, 200, 600, 106);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Hunter & Sherif's Profanity Cleaner and Pattern Maker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JFrame output = new JFrame();
		output.setBounds(450, 200, 400, 300);
		output.getContentPane().setLayout(null);
		output.setTitle("Output");
		output.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//output text field
		final JTextArea print = new JTextArea();
		print.setSize(output.getSize());
		print.setEditable(false);
		output.add(print);

		//input 1 label
		JLabel label1 = new JLabel("Input:");
		label1.setBounds(15,15,60,15);
		label1.setFont((new Font(null, Font.BOLD, 14)));
		frame.add(label1);

		//input box
		final JTextField field = new JTextField();
		field.setBounds(65,14,500,20);
		frame.add(field);

		//initials button
		final JButton profanity = new JButton("Clear Profanity");
		profanity.setBounds(65,40,120,19);
		frame.add(profanity);

		profanity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (field.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Please enter text into the field","Input Error",JOptionPane.ERROR_MESSAGE);
				String input = field.getText();
				String cleaned;
				String c1, c2, c3, c4, c5, c6, c7, c8;
				c1 = cleaner(input,"fuck");
				c2 = cleaner(c1,"python");
				c3 = cleaner(c2,"cunt");
				c4 = cleaner(c3,"stupid");
				c5 = cleaner(c4,"dick");
				c6 = cleaner(c5,"bitch");
				c7 = cleaner(c6,"c#");
				c8 = cleaner(c7,"whore");
				cleaned = cleaner(c8,"slut");
				print.setText(cleaned);
				output.setVisible(true);
			}
		});

		final JButton diamond = new JButton("Make Diamond");
		diamond.setBounds(195,40,120,19);
		frame.add(diamond);

		diamond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (field.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Please enter text into the field","Input Error",JOptionPane.ERROR_MESSAGE);
				StringBuffer diamond = new StringBuffer();
				String x = field.getText().replaceAll("\\W+","").toUpperCase();
				for(int line=0;line<=x.length()-1;line++){
					for(int space=x.length()-1;space>=line;space--){
						diamond.append(" ");
					}
					int c= line;
					diamond.append(x.charAt(c));
					for(int space=0;space<=2*line-2;space++){
						diamond.append(" ");
					}
					if(c!=0){
						diamond.append(x.charAt(c));
					}
					c++;

					diamond.append("\n");
					print.setText(diamond.toString());
					output.setVisible(true);
				}
			}
		});

		//adds clear button
		final JButton clear = new JButton("Clear All");
		clear.setBounds(210,145,110,32);
		frame.add(clear);

		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//sets the field to empty
				field.setText("");
			}
		});

		frame.setVisible(true);
	}
	public static String cleaner(String str, String profanity)        {
		int len = profanity.length();
		StringBuffer bleep = new StringBuffer("");
		for (int i = 0; i < len; i++)
			bleep.append("*");
		String output = str.replaceAll(profanity, bleep.toString());
		return output;
	}

}
