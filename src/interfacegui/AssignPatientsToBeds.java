package interfacegui;
/**
 * @author Zhenzhong Zhou
 * 11195696
 * zhz028
 */
import commandStatus.AssignBedToPatient;
import containers.PatientAccess;
import containers.WardAccess;
import entities.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignPatientsToBeds extends JFrame {

    final int frameWidth = 750;
    final int frameHeight = 1000;
    JPanel panel = new JPanel();
    static int counter = 0;

    public AssignPatientsToBeds(){
        setTitle("Assign Patients to the Beds");
        setLayout(null);
        setSize(frameWidth, frameHeight);
        setVisible(true);

        setLayout(new BorderLayout(100, 100));
        JLabel author = new JLabel("Zhenzhong Zhoun \n zhz028\n 11195696");
        author.setFont(new Font("AppleMyungjo", Font.BOLD + Font.ITALIC, 15));
        author.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add("South", author);
        getContentPane().add("North", new JLabel());
        getContentPane().add("East", new JLabel());
        getContentPane().add("West", new JLabel());
        getContentPane().add("Center", panel);
        panel.setLayout(new GridLayout(15,2));

        JLabel header = new JLabel("\nAssign Patients to the Beds");
        header.setFont(new Font("AppleMyungjo", Font.PLAIN + Font.BOLD, 40));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(header);

        JLabel label1 = new JLabel("Patient Information");
        label1.setFont(new Font("AppleMyungjo", Font.PLAIN + Font.BOLD, 40));
        panel.add(new JLabel());
        panel.add(label1);

        JLabel label3 = new JLabel("Health Number: ");
        label3.setFont(new Font("AppleMyungjo", Font.PLAIN, 30));
        panel.add(label3);

        JTextField field_Num = new JTextField();
        field_Num.setFont(new Font("AppleMyungjo", Font.PLAIN, 30));
        panel.add(field_Num);

        JLabel label5 = new JLabel("Ward Information");
        label5.setFont(new Font("AppleMyungjo", Font.PLAIN + Font.BOLD, 40));
        panel.add(new JLabel());
        panel.add(label5);

        String wardName = WardAccess.ward().getName();
        JLabel label6 = new JLabel(wardName);
        label6.setFont(new Font("AppleMyungjo", Font.PLAIN, 30));
        panel.add(label6);

        int max = WardAccess.ward().getMaxBedLabel();
        int min = WardAccess.ward().getMinBedLabel();
        String bedInformation = "Bed Label (Start " + min + " To " + max + "): ";
        JLabel label7 = new JLabel(bedInformation);
        label7.setFont(new Font("AppleMyungjo", Font.PLAIN, 30));
        panel.add(label7);

        JTextField field_label = new JTextField();
        field_label.setFont(new Font("AppleMyungjo", Font.PLAIN, 30));
        panel.add(field_label);
        panel.add(new JLabel());

        JButton button = new JButton("Assign");
        class assignListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent event) {
                String bedLabel = field_label.getText();
                String healthNum = field_Num.getText();
                int health_num = Integer.valueOf(healthNum).intValue();
                int bed_Num = Integer.valueOf(bedLabel).intValue();
                try {
                        AssignBedToPatient.assignBedToPatient(health_num, bed_Num);
                        if (AssignBedToPatient.wasSuccessful() == true)
                            JOptionPane.showMessageDialog(null,
                                    "Assign Patient To Bed Successfully!");
                        else
                            JOptionPane.showMessageDialog(null,
                                    AssignBedToPatient.getErrorMessage());
                        return;
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,
                            "Please invalid numeric digits!");
                }
                catch (RuntimeException e){
                    JOptionPane.showMessageDialog(null, AssignBedToPatient.getErrorMessage());
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, AssignBedToPatient.getErrorMessage());
                }

                StringBuilder stringBuilder = new StringBuilder("Patients Information\n");
                stringBuilder.append(healthNum + " " + bedLabel + "\n");
                stringBuilder.append(System.getProperty("line.separator"));
                field_Num.setText("");
                System.out.println(stringBuilder);
                System.out.println("Option 6: Assign Clicked! " + counter);
                counter++;
                new AssignPatientsToBeds().setVisible(true);
                dispose();
            }
        }
        button.addActionListener(new assignListener());
        button.setFont(new Font("Times Roman", Font.ITALIC, 30));
        panel.add(button);

        JButton button1 = new JButton("Cancel");
        class cancelListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Option 6: Cancel Clicked! " + counter);
                counter++;
                new TheMenu().setVisible(true);
                dispose();
            }
        }
        button1.addActionListener(new cancelListener());
        button1.setFont(new Font("Times Roman", Font.ITALIC, 30));
        panel.add(button1);

        System.out.println("Option 6: Total Clicked! " + counter);
        revalidate();
        repaint();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
