package interfacegui;
/**
 * @author Zhenzhong Zhou
 * zhz028
 * 11195696
 */

import commandStatus.*;
import containers.*;
import entities.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropDoctorPatient extends JFrame{

    final int frameWidth = 800;
    final int frameHeight = 1000;
    JPanel panel = new JPanel();
    static int counter = 0;

    public DropDoctorPatient(){
        setTitle("Drop Doctor-Patient Association");
        setLayout(null);
        setSize(frameWidth, frameHeight);
        setVisible(true);

        setLayout(new BorderLayout(100, 100));
        JLabel author = new JLabel("Zhenzhong Zhoun \n zhz028\n 11195696");
        author.setFont(new Font("AppleMyungjo", Font.BOLD + Font.ITALIC, 15));
        author.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add("South", author);
        getContentPane().add("East", new JLabel());
        getContentPane().add("North", new JLabel());
        getContentPane().add("West", new JLabel());
        getContentPane().add("Center", panel);
        panel.setLayout(new GridLayout(15,1));


        JLabel header = new JLabel("Display Doctor-Patients Status");
        header.setFont(new Font("AppleMyungjo", Font.PLAIN + Font.BOLD, 40));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(header);
        panel.add(new JLabel());
        panel.add(new JLabel());

        JLabel label1 = new JLabel("Doctor Information");
        label1.setFont(new Font("Times Roman", Font.PLAIN, 40));
        panel.add(label1);

        JLabel label3 = new JLabel("Doctor Name: ");
        label3.setFont(new Font("Times Roman", Font.PLAIN, 30));
        panel.add(label3);

        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Times Roman", Font.PLAIN, 30));
        for (String save : DoctorAccess.doctorTreeMap().keySet()) {
            Doctor doctor = DoctorAccess.doctorTreeMap().get(save);
            comboBox.addItem(doctor.getName());
        }
        panel.add(comboBox);

        JLabel label = new JLabel("Patient Health Number: ");
        label.setFont(new Font("Times Roman", Font.PLAIN, 30));
        panel.add(new JLabel());
        panel.add(label);

        JTextField field_Num = new JTextField();
        field_Num.setFont(new Font("Times Roman", Font.PLAIN, 40));
        panel.add(field_Num);

        JComboBox comboBox1 = new JComboBox();
        comboBox1.setFont(new Font("Times Roman", Font.PLAIN, 30));
        for (int save : PatientAccess.patientTreeMap().keySet()) {
            Patient patient = PatientAccess.patientTreeMap().get(save);
            comboBox1.addItem("Patient Name: " + patient.getName() +
                    " Health Number: " + patient.getHealthNumber());
        }
        panel.add(comboBox1);

        JButton drop = new JButton("Drop");
        class dropListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent event) {
                String doctorType = (String) comboBox.getSelectedItem();
                String healthNum = field_Num.getText();
                Object p_name = comboBox.getSelectedItem();
                int health_num = Integer.valueOf(healthNum).intValue();
                commandStatus.DropDoctorPatient.dropDoctorPatient(health_num, doctorType);

                while(true) {
                    if (commandStatus.DropDoctorPatient.wasSuccessful() == false) {
                        JOptionPane.showMessageDialog(null,
                                AssignBedToPatient.getErrorMessage());
                        return;
                    }
                    break;
                }

                StringBuilder stringBuilder = new StringBuilder("Patients Information\n");
                stringBuilder.append(p_name + " " + "\n" + healthNum + " " + "\n");
                stringBuilder.append(System.getProperty("line.separator"));
                field_Num.setText("");
                System.out.println(stringBuilder);
                System.out.println("Option 8: Drop Clicked! " + counter);
                counter++;
                new DropDoctorPatient().setVisible(true);
                dispose();
            }
        }
        drop.addActionListener(new dropListener());
        drop.setFont(new Font("Times Roman", Font.PLAIN, 20));
        panel.add(new JLabel());
        panel.add(drop);

        JButton cancel = new JButton("Cancel");
        class cancelListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Option 8: Cancel Clicked! " + counter);
                counter++;
                new TheMenu().setVisible(true);
                dispose();
            }
        }
        cancel.addActionListener(new cancelListener());
        cancel.setFont(new Font("Times Roman", Font.PLAIN, 20));
        panel.add(cancel);

        revalidate();
        repaint();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
