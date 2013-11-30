import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class HC_GuiStrings {

        /**
         * @param args
         */
        
        public static void main(String[] args) {
                JFrame frame = new JFrame();
                frame.setBounds(450, 200, 350, 180);
                frame.getContentPane().setLayout(null);
                frame.setTitle("Hunter's Strings Lab");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                
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
                
                final JLabel output = new JLabel("");
                output.setBounds(89,79, 60, 15);
                output.setFont((new Font(null, Font.BOLD, 14)));
                frame.add(output);        
                
                JButton party = new JButton("PARTY", (new ImageIcon(((new ImageIcon("src/party-hat-icon-614x460.png").getImage().getScaledInstance(20, 25,java.awt.Image.SCALE_SMOOTH))))));
                party.setBounds(90,100, 110, 32);
                party.setFont((new Font(null, Font.BOLD, 14)));
                frame.add(party);
                
                
                JButton init = new JButton("Initials");
                init.setBounds(210,20,110,19);
                frame.add(init);
                
                init.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                                String i1 = field1.getText();
                                String i2 = field2.getText();
                                char first = i1.charAt(0);
                                char last = i2.charAt(0);
                                String initials = (Character.toString(first) + "." + Character.toString(last) + ".").toUpperCase();
                                output.setText(initials);
                        }
                });
                
                JButton ana = new JButton("Anagram");
                ana.setBounds(210,50,110,19);
                frame.add(ana);
                
                JButton word = new JButton("Word Search");
                word.setBounds(210,79,110,19);
                frame.add(word);

                JButton clear = new JButton("Clear All");
                clear.setBounds(210,110,110,19);
                frame.add(clear);
                
                clear.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                                field1.setText("");
                                field2.setText("");
                        }
                });
                
                frame.setVisible(true);
        }

}
