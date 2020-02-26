package interfacegui;
/**
 * @author Zhenzhong Zhou
 * zhz028
 * 11195696
 */

import javax.management.RuntimeErrorException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import commandStatus.*;

public class AddPatient extends JFrame{

    final int frameWidth = 750;
    final int frameHeight = 400;
    JPanel panel = new JPanel();
    static int counter = 0;

    public AddPatient() {
        setTitle("Add a New Patient");
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
        panel.setLayout(new GridLayout(6,2));

        JLabel header = new JLabel("\nPatient Information");
        header.setFont(new Font("AppleMyungjo", Font.PLAIN, 18));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(new JLabel());
        panel.add(header);
        panel.add(new JLabel());
        panel.add(new JLabel(), new JLabel());
        panel.add(new JLabel(), new JLabel());
        panel.add(new JLabel());

        JLabel pName = new JLabel("Patient Name: ");
        pName.setFont(new Font("AppleMyungjo", Font.PLAIN, 15));
        pName.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(pName);

        JTextField field_Name = new JTextField();
        field_Name.setFont(new Font("AppleMyungjo", Font.PLAIN, 20));
        panel.add(new JLabel());
        panel.add(field_Name);

        JLabel hNum = new JLabel("Health Number: ");
        hNum.setFont(new Font("AppleMyungjo", Font.PLAIN, 15));
        hNum.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(hNum);

        JTextField field_Num = new JTextField();
        field_Num.setFont(new Font("AppleMyungjo", Font.PLAIN, 20));
        panel.add(new JLabel());
        panel.add(field_Num);

        JButton save = new JButton("Save");
        save.setFont(new Font("AppleMyungjo", Font.PLAIN, 15));
        StringBuilder stringBuilder = new StringBuilder("Patient Information\n");
        class saveListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pName = field_Name.getText();
                int healthNum = Integer.parseInt(field_Num.getText());

                try {
                    if ("".equals(field_Name.getText()) || !field_Name.getText().matches("^[A-Za-z]\\w+$")) {
                            JOptionPane.showMessageDialog(null,
                                    "Input Name at least two letters! \n"
                                            + "Name cannot be empty or numeric number or any symbol!");
                        }
                        else if ("".equals(field_Num.getText()) && "".equals(field_Name.getText())) {
                        JOptionPane.showMessageDialog(null,
                                "Please Fill Information Completely!");
                    }
                    else {
                        AddPatients.addPatients(pName, healthNum);
                        if (AddPatients.wasSuccessful()) {
                            JOptionPane.showMessageDialog(null,
                                    "Add Patient Successfully!");
                        }
                        else
                            JOptionPane.showMessageDialog(null,
                                    AddPatients.getErrorMessage());
                    }
                }
                catch (Exception ex){
                    throw new RuntimeErrorException( null,"unexpected error");
                }

                stringBuilder.append("Patient Name: " + pName + " " + "\n" + "Health Number:" + healthNum);
                stringBuilder.append(System.getProperty("line.separator"));
                field_Name.setText("");
                field_Num.setText("");
                System.out.println(stringBuilder);
                System.out.println("Option 2: Save Clicked! " + counter);
                new AddPatient().setVisible(true);
                counter++;
                dispose();
            }
        }
        save.addActionListener(new saveListener());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(save);

        JButton cancel = new JButton("Cancel");
        cancel.setFont(new Font("AppleMyungjo", Font.PLAIN, 15));
        class cancelListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TheMenu().setVisible(true);
                System.out.println("Option 2: Cancel Clicked! " + counter);
                counter++;
                dispose();
            }
        }
        cancel.addActionListener(new cancelListener());
        panel.add(new JLabel());
        panel.add(cancel);

        System.out.println("Option 2: Total Clicked! " + counter + "\n");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        revalidate();
        repaint();
    }
}
