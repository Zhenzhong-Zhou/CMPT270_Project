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

public class AddDoctor extends JFrame{

    final int frameWidth = 900;
    final int frameHeight = 400;
    JPanel panel = new JPanel();
    static int counter = 0;

    public AddDoctor() {
        setTitle("Add a New Doctor");
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
        getContentPane().add("North", new JLabel());
        getContentPane().add("Center", panel);
        panel.setLayout(new GridLayout(4 ,2));

        JLabel header = new JLabel("Doctor Information");
        header.setFont(new Font("AppleMyungjo", Font.PLAIN, 25));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(new JLabel(), new JLabel());
        panel.add(header);
        panel.add(new JLabel(), new JLabel());

        JLabel pName = new JLabel("Doctor Name: ");
        pName.setFont(new Font("AppleMyungjo", Font.PLAIN, 20));
        pName.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(pName);

        JTextField field_Name = new JTextField();
        field_Name.setFont(new Font("AppleMyungjo", Font.PLAIN, 25));
        panel.add(field_Name);

        JRadioButton doctor = new JRadioButton("Doctor");
        JRadioButton surgeon = new JRadioButton("Surgeon");
        doctor.setFont(new Font("AppleMyungjo", Font.PLAIN, 20));
        doctor.setHorizontalAlignment(SwingConstants.CENTER);
        surgeon.setFont(new Font("AppleMyungjo", Font.PLAIN, 20));
        surgeon.setHorizontalAlignment(SwingConstants.CENTER);
        ButtonGroup group = new ButtonGroup();
        group.add(doctor);
        group.add(surgeon);
        class doctorListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("\nDoctor Clicked! " + counter);
                counter++;
            }
        }
        doctor.addActionListener(new doctorListener());
        class surgeonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Surgeon Clicked! " + counter);
                counter++;
            }
        }
        surgeon.addActionListener(new surgeonListener());
        panel.add(doctor);
        panel.add(new JLabel(), new JLabel());
        panel.add(new JLabel());
        panel.add(surgeon);

        JButton save = new JButton("Save");
        save.setFont(new Font("AppleMyungjo", Font.PLAIN, 20));
        StringBuilder stringBuilder = new StringBuilder("\nDoctor Information\n");
        class saveListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dName = " Name: " + field_Name.getText();
                String selections = "";

                try {
                    if ("".equals(field_Name.getText()) || !field_Name.getText().matches("[A-Za-z]\\w+")) {
                        JOptionPane.showMessageDialog(null,
                                "Input Name at least two letters! \n"
                                        + "Name cannot be empty or numeric number or any symbol!");
                    }
                    else {
                        if (!doctor.isSelected() && !surgeon.isSelected()){
                            JOptionPane.showMessageDialog(null,
                                    "Please Select One Doctor Type!\n");
                        }
                        else {
                            commandStatus.AddDoctor.addDoctor(selections + dName, surgeon.isSelected());
                            if (!commandStatus.AddDoctor.wasSuccessful()) {
                                JOptionPane.showMessageDialog(null,
                                        commandStatus.AddDoctor.getErrorMessage());
                            }
                            else {
                                JOptionPane.showMessageDialog(null,
                                        "Add Doctor Successfully!");
                            }
                        }
                    }
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "unexpected error");
                }


                stringBuilder.append("Doctor Name : " + dName + " " + "\n" + "Doctor Type: " + selections + " ");
                stringBuilder.append(System.getProperty("line.separator"));
                field_Name.setText("");
                System.out.println(stringBuilder);
                new AddDoctor().setVisible(true);
                System.out.println("Option 3: Save Clicked! " + counter);
                counter++;
                dispose();
            }
        }
        save.addActionListener(new saveListener());
        panel.add(save);

        JButton cancel = new JButton("Cancel");
        cancel.setFont(new Font("AppleMyungjo", Font.PLAIN, 20));
        class cancelListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TheMenu().setVisible(true);
                System.out.println("Option 3: Cancel Clicked! " + counter);
               counter++;
               dispose();
            }
        }
        cancel.addActionListener(new cancelListener());
        panel.add(new JLabel());
        panel.add(cancel);

        System.out.println("Option 3: Total Clicked! " + counter + "\n");
        revalidate();
        repaint();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}