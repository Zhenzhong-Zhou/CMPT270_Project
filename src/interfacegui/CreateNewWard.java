package interfacegui;
/**
 * @author Zhenzhong Zhou
 * 111956966
 * zhz028
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateNewWard extends JFrame {

    final int frameWidth = 800;
    final int frameHeight = 1400;
    JPanel panel = new JPanel();
    static int counter = 0;

    public CreateNewWard() {
        setTitle("Hospital System App");
        setLayout(null);
        setSize(frameWidth, frameHeight);
        setVisible(true);

        setLayout(new BorderLayout(50, 50));
        JLabel author = new JLabel("Zhenzhong Zhoun \n zhz028\n 11195696");
        author.setFont(new Font("AppleMyungjo", Font.BOLD + Font.ITALIC, 15));
        author.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add("South", author);
        getContentPane().add("East", new JLabel());
        getContentPane().add("West", new JLabel());
        getContentPane().add("Center", panel);
        panel.setLayout(new GridLayout(12,1));

        JLabel header = new JLabel("Welcome to the Hospital System App!");
        header.setFont(new Font("Helvetica", Font.BOLD, 10));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(header);

        JLabel homePage = new JLabel("Create a New Ward");
        homePage.setFont(new Font("AppleMyungjo", Font.PLAIN, 40));
        homePage.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(homePage);

        JLabel wardName = new JLabel("Ward Name");
        wardName.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 30));
        wardName.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(wardName);

        JTextField field_Name = new JTextField();
        field_Name.setFont(new Font("AppleMyungjo", Font.PLAIN, 50));
        panel.add(field_Name);

        JLabel minBedLabel = new JLabel("The Minimum Bed Label in the Ward" );
        minBedLabel.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 30));
        minBedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(minBedLabel);

        JTextField field_Min = new JTextField();
        field_Min.setFont(new Font("AppleMyungjo", Font.PLAIN, 50));
        panel.add(field_Min);

        JLabel maxBedLabel = new JLabel("The Maximum Bed Label in the Ward");
        maxBedLabel.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 30));
        maxBedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(maxBedLabel);

        JTextField field_Max = new JTextField();
        field_Max.setFont(new Font("AppleMyungjo", Font.PLAIN, 50));
        panel.add(field_Max);

        JButton done = new JButton("DONE");
        done.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 30));
        done.setHorizontalAlignment(SwingConstants.CENTER);
        StringBuilder stringBuilder = new StringBuilder("Ward Information\n");
        class doneListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wName = field_Name.getText();
                String fieldMin = "";
                String fieldMax = "";
                int minBedLabel = Integer.parseInt(field_Min.getText());
                int maxBedLabel = Integer.parseInt(field_Max.getText());

                try {
                    wName = "Ward Name : " + field_Name.getText();
                    maxBedLabel = Integer.parseInt(field_Max.getText());
                    minBedLabel = Integer.parseInt(field_Min.getText());
                    while (true) {
                        if ("".equals(field_Name.getText()) || !field_Name.getText().matches("[A-Za-z]\\w+")) {
                            JOptionPane.showMessageDialog(null,
                                    "Input Name at least two letters! \n" +
                                            "Name cannot be empty or numeric number or any symbol!");
                            return;
                        }
                        if (minBedLabel >= 0 && maxBedLabel > minBedLabel && maxBedLabel - minBedLabel > 2) {
                            fieldMin = "The Minimum Bed Number of Label: " + minBedLabel;
                            fieldMax = "The Maximum Bed Number of Label: " + maxBedLabel;
                            JOptionPane.showMessageDialog(null,
                                    "Create a New Ward Successfully!");
                        }
                        else if ("".equals(Integer.parseInt(field_Max.getText())) &&
                                "".equals(Integer.parseInt(field_Min.getText()))) {
                            JOptionPane.showMessageDialog(null,
                                    "Please Type It!");
                            return;
                        }
                        else {
                            JOptionPane.showMessageDialog(null,
                                    "Try it again! Please Create the Maximum Capacity is Greater Than Two!");
                            return;
                        } break;
                    }
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,
                            "Type error! Please enter valid input!");
                }

                stringBuilder.append(wName + " " + "\n" + fieldMin + "\n" + fieldMax);
                stringBuilder.append(System.getProperty("line.separator"));
                field_Name.setText("");
                System.out.println(stringBuilder);
                System.out.println("Ward Information: DONE Clicked! " + counter);
                counter++;
                commandStatus.CreateNewWard.createWard(wName, minBedLabel, maxBedLabel);
                new TheMenu().setVisible(true);
                dispose();
            }
        }
        done.addActionListener(new doneListener());
        panel.add(new JLabel());
        panel.add(done);

        JButton back = new JButton("BACK");
        back.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 30));
        back.setHorizontalAlignment(SwingConstants.CENTER);
        class backListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomePage().setVisible(true);
                System.out.println("Ward Information: BACK Clicked! " + counter);
                counter++;
                dispose();
            }
        }
        back.addActionListener(new backListener());
        panel.add(back);

        revalidate();
        repaint();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
