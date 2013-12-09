import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
         * Strings Assignment 11d
         */

        public static void main(String[] args) {
                //creating frame
                final JFrame frame = new JFrame();
                frame.setBounds(450, 200, 600, 106);
                frame.getContentPane().setLayout(null);
                frame.setTitle("Hunter & Sherif's Profanity Cleaner and Pattern Maker");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //output window
                final JFrame output = new JFrame();
                output.setBounds(450, 200, 400, 300);
                output.getContentPane().setLayout(null);
                output.setTitle("Output");
                output.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //output text field
                final JTextArea print = new JTextArea();
                print.setSize(output.getSize());
                print.setEditable(false);
                print.setFont((new Font(null, Font.BOLD, 14)));
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
                            //easily expandable profanity cleaner
                            if (field.getText().equals(""))
                                    JOptionPane.showMessageDialog(null, "Please enter text into the field","Input Error",JOptionPane.ERROR_MESSAGE);
                            //string array for bad words that can be easily added to
                            //last word in array will not be read
                            String[] bad = {"fuck", "penis", "cunt", "bitch", "whore", "twat", "nigger", "nigga", "chink", "wigger", "ass", "shit", "slut", "faggot", "dick", null};
                            //array list for each version after a word is taken out
                            ArrayList<String> versions = new ArrayList<String>();
                            versions.add(field.getText());
                            //loop that removes one bad word from current string using the cleaner method and assigns it to a new string, then repeats
                            //loop runs once per bad word
                            for (int i = 1; i < bad.length;i++ )        {
                                    versions.add(cleaner(versions.get(i-1), bad[i-1]));
                            }
                            //gets last version of string that is fully cleaned
                            print.setText(versions.get(versions.size()-1));
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
                                }
                                for(int line=x.length()-2;line>=0;line--){
                                    
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
                                            c--;
                                    
                                    diamond.append("\n");
                          }
                                print.setText(diamond.toString());
                                output.setVisible(true);
                        }
                });

                //adds clear button
                final JButton clear = new JButton("Clear Field");
                clear.setBounds(325,40,120,19);
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
            if (output.equals(str))
                JOptionPane.showMessageDialog(null, "You will be sent to the office","Profanity Detected",JOptionPane.ERROR_MESSAGE);
            return output;
    }

}
