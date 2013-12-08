import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class HC_GuiStrings {

        /**
         * @param args
         */

        public static void main(String[] args) {
                final JFrame frame = new JFrame();
                frame.setBounds(450, 200, 350, 230);
                frame.getContentPane().setLayout(null);
                frame.setTitle("Hunter's Strings Lab");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                final Calendar calendar = Calendar.getInstance();

                JLabel label1 = new JLabel("Input #1:");
                label1.setBounds(20,20,60,15);
                label1.setFont((new Font(null, Font.BOLD, 14)));
                frame.add(label1);

                final JTextField field1 = new JTextField();
                field1.setBounds(90,20,100,20);
                frame.add(field1);

                JLabel label2 = new JLabel("Input #2:");
                label2.setBounds(20,50, 60, 15);
                label2.setFont((new Font(null, Font.BOLD, 14)));
                frame.add(label2);

                final JTextField field2 = new JTextField();
                field2.setBounds(90,49,100,20);
                frame.add(field2);

                JLabel label3 = new JLabel("Output:");
                label3.setBounds(28,79, 60, 15);
                label3.setFont((new Font(null, Font.BOLD, 14)));
                frame.add(label3);
                
                final JLabel since = new JLabel("");
                since.setBounds(20,110, 170, 20);
                since.setFont((new Font(null, Font.BOLD, 12)));
                frame.add(since);
                since.setVisible(false);
                since.setBorder(BorderFactory.createLoweredBevelBorder());

                final JLabel output = new JLabel("");
                output.setBounds(89,79, 60, 15);
                output.setFont((new Font(null, Font.BOLD, 14)));
                frame.add(output);        

                final JButton init = new JButton("Initials");
                init.setBounds(210,20,110,19);
                frame.add(init);

                init.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                                if (field1.getText().equals("") && field2.getText().equals(""))
                                        JOptionPane.showMessageDialog(null, "Please enter text into the input fields","Input Error",JOptionPane.ERROR_MESSAGE);
                                else if (field1.getText().equals("") || field2.getText().equals(""))
                                        JOptionPane.showMessageDialog(null, "Please enter text into the empty field","Input Error",JOptionPane.ERROR_MESSAGE);
                                String i1 = field1.getText();
                                String i2 = field2.getText();
                                char first = i1.charAt(0);
                                char last = i2.charAt(0);
                                String initials = (Character.toString(first) + "." + Character.toString(last) + ".").toUpperCase();
                                output.setText(initials);
                        }
                });

                final JButton ana = new JButton("Anagram");
                ana.setBounds(210,50,110,19);
                frame.add(ana);

                ana.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                                if (field1.getText().equals("") && field2.getText().equals(""))
                                        JOptionPane.showMessageDialog(null, "Please enter text into the input fields","Input Error",JOptionPane.ERROR_MESSAGE);
                                else if (field1.getText().equals("") || field2.getText().equals(""))
                                        JOptionPane.showMessageDialog(null, "Please enter text into the empty field","Input Error",JOptionPane.ERROR_MESSAGE);
                                String one = field1.getText().replaceAll("\\s+","").toLowerCase();
                                String two = field2.getText().replaceAll("\\s+","").toLowerCase();
                                int Lone = one.length();
                                int Ltwo = two.length();
                                char[] Aone = one.toCharArray();
                                char[] Atwo = two.toCharArray();
                                int counter = 0;
                                boolean isAnagram = false;
                                if (Lone == Ltwo)        {
                                        for (int x = 0; x < Lone; x++)        {
                                                for (int y = 0; y < Lone; y++)        {
                                                        if (Arrays.asList(Atwo[y]).contains(Aone[x]))        {
                                                                counter++;
                                                        }
                                                }
                                                if (counter >= 1)        {
                                                        isAnagram = true;
                                                        counter = 0;
                                                }
                                                else        {
                                                        isAnagram = false;
                                                        break;
                                                }

                                        }
                                }
                                else
                                        isAnagram = false;
                                output.setText(String.valueOf(isAnagram));
                        }
                });

                final JButton word = new JButton("Word Search");
                word.setBounds(210,79,110,19);
                frame.add(word);

                final JButton clear = new JButton("Clear All");
                clear.setBounds(210,110,110,19);
                frame.add(clear);

                clear.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                                field1.setText("");
                                field2.setText("");
                        }
                });

                final JButton party = new JButton("PARTY", (new ImageIcon(((new ImageIcon("src/partyhat.png").getImage().getScaledInstance(20, 25,java.awt.Image.SCALE_SMOOTH))))));
                party.setBounds(18,145, 303, 32);
                party.setFont((new Font(null, Font.BOLD, 14)));
                frame.add(party);

                party.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                                if (party.getText().equals("PARTY"))        {
                                        init.setBackground(Color.red);
                                        init.setForeground(Color.white);
                                        ana.setBackground(Color.blue);
                                        ana.setForeground(Color.white);
                                        word.setBackground(Color.magenta);
                                        word.setForeground(Color.white);
                                        clear.setBackground(Color.green);
                                        clear.setForeground(Color.DARK_GRAY);
                                        party.setBackground(Color.orange);
                                        field1.setBackground(Color.yellow);
                                        field2.setBackground(Color.CYAN);
                                        frame.getContentPane().setBackground(Color.PINK);
                                        party.setText("STOP PARTYING");
                                        String time;
                                        if (calendar.get(Calendar.AM_PM) == 0)
                                                time = "am";
                                        else
                                                time = "pm";
                                        since.setText(" BEEN PARYTING SINCE " + calendar.get(Calendar.HOUR)+ time);
                                        since.setVisible(true);
                                }
                                else        {
                                        since.setVisible(false);
                                        init.setBackground(null);
                                        init.setForeground(null);
                                        ana.setBackground(null);
                                        ana.setForeground(null);
                                        word.setBackground(null);
                                        word.setForeground(null);
                                        clear.setBackground(null);
                                        clear.setForeground(null);
                                        party.setBackground(null);
                                        field1.setBackground(Color.white);
                                        field2.setBackground(Color.white);
                                        frame.getContentPane().setBackground(null);
                                        party.setText("PARTY");
                                }
                        }
                });

                frame.setVisible(true);
        }

}
