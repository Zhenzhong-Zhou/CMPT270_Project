package interfacegui;
/**
 * @author Zhenzhong Zhou
 * zhz028
 * 11195696
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReleasePatient extends JFrame{

    final int frameWidth = 800;
    final int frameHeight = 1000;
    JPanel panel = new JPanel();
    static int counter = 0;

    public ReleasePatient(){
        setTitle("Release a Patient");
        setLayout(null);
        setSize(frameWidth, frameHeight);
        setVisible(true);

        setLayout(new BorderLayout(100, 100));
        JLabel author = new JLabel("Zhenzhong Zhoun \n zhz028\n 11195696");
        author.setFont(new Font("AppleMyungjo", Font.BOLD + Font.ITALIC, 15));
        author.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add("South", author);
        getContentPane().add("East", new JLabel());
        getContentPane().add("West", new JLabel());
        getContentPane().add("Center", panel);
        panel.setLayout(new GridLayout(9,1));

        JLabel header = new JLabel("\nRelease a Patient");
        header.setFont(new Font("AppleMyungjo", Font.PLAIN + Font.BOLD, 40));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(new JLabel());
        panel.add(header);

        JLabel label = new JLabel("Patient Health Number: ");
        label.setBounds(480,80,550,60);
        label.setFont(new Font("Times Roman", Font.PLAIN, 30));
        panel.add(new JLabel());
        panel.add(label);

        JTextField field_Num = new JTextField();
        field_Num.setBounds(420, 382, 250, 40);
        field_Num.setFont(new Font("Times Roman", Font.PLAIN, 40));
        panel.add(field_Num);

        JButton release = new JButton("Release");
        class releaseListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent event) {
                String healthNum = field_Num.getText();
                int health_num = Integer.valueOf(healthNum).intValue();
                commandStatus.ReleasePatient.releasePatients(health_num);
                try {
                    if (commandStatus.ReleasePatient.wasSuccessful() == true) {
                        JOptionPane.showMessageDialog(null,
                                 "Release Patient Successfully!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,
                                commandStatus.ReleasePatient.getErrorMessage());
                    }
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,
                            "Please Enter Positive integer number!");
                }

                StringBuilder stringBuilder = new StringBuilder("Patients Information\n");
                stringBuilder.append(healthNum + " " + "\n");
                stringBuilder.append(System.getProperty("line.separator"));
                field_Num.setText("");
                System.out.println(stringBuilder);
                new ReleasePatient().setVisible(true);
                System.out.println("Option 7: Release Clicked! " + counter);
                counter++;
                dispose();
            }
        }
        release.setFont(new Font("Times Roman", Font.ITALIC, 20));
        release.addActionListener(new releaseListener());
        panel.add(new JLabel());
        panel.add(release);

        JButton cancel = new JButton("Cancel");
        class cancelListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TheMenu().setVisible(true);
                System.out.println("Option 7: Cancel Clicked! " + counter);
                counter++;
                dispose();
            }
        }
        cancel.addActionListener(new cancelListener());
        cancel.setFont(new Font("Times Roman", Font.ITALIC, 20));
        panel.add(cancel);

        System.out.println("Option 7: Total Clicked! " + counter);

        revalidate();
        repaint();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
