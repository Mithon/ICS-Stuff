import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		frame.setTitle("Hunter's Profanity Cleaner and Pattern Maker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
				String input = field.getText();
				String output;
				output = cleaner(input,"fuck");
				System.out.print(output);
			}
		});
		
		final JButton diamond = new JButton("Make Diamond");
		diamond.setBounds(195,40,120,19);
		frame.add(diamond);

		diamond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String input = field.getText().replaceAll("\\W+","").toUpperCase();
				int len = input.length();
				char[] word = input.toCharArray();
				for (int line = 0; line < len; line++)	{
					for (int x = 0; x >= (len-1)*-2; x--)	{
						System.out.print(" ");
					}
					for (int i = 0; i < 1; i++)	{
						System.out.print(word[line]);				
					}
					for (int x = 0; x <= (len-1); x++)	{
						System.out.print(" ");
					}
					if (line != 0)	{
					for (int i = 0; i < 1; i++)	{
						System.out.print(word[line]);				
					}
					}
					System.out.println("");
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
	public static String cleaner(String str, String profanity)	{
		int len = profanity.length();
		StringBuffer bleep = new StringBuffer("");
		for (int i = 0; i < len; i++)
			bleep.append("*");
		String output = str.replaceAll(profanity, bleep.toString());
		return output;
	}

}
