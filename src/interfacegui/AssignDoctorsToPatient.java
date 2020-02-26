package interfacegui;
/**
 * @author Zhenzhong Zhou
 * zhz028
 * 11195696
 */

import commandStatus.AssignBedToPatient;
import commandStatus.AssignDoctors;
import containers.DoctorAccess;
import entities.Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AssignDoctorsToPatient extends JFrame {

    final int frameWidth = 1200;
    final int frameHeight = 600;
    JPanel panel = new JPanel();
    static int counter = 0;

    public AssignDoctorsToPatient(){
        setTitle("Assign Doctors To Patient");
        setLayout(null);
        setSize(frameWidth, frameHeight);
        setVisible(true);

        setLayout(new BorderLayout(50, 50));
        JLabel author = new JLabel("Zhenzhong Zhoun \n zhz028\n 11195696");
        author.setFont(new Font("AppleMyungjo", Font.BOLD + Font.ITALIC, 15));
        author.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add("North", new JLabel());
        getContentPane().add("East", new JLabel());
        getContentPane().add("West",new JLabel());
        getContentPane().add("South", author);
        getContentPane().add("Center", panel);
        panel.setLayout(new GridLayout(8,3));

        JLabel header = new JLabel("Assign Doctors");
        header.setFont(new Font("AppleMyungjo", Font.PLAIN, 40));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(new JLabel());
        panel.add(header);
        panel.add(new JLabel());

        JLabel pInformation = new JLabel("Patient Information");
        pInformation.setFont(new Font("AppleMyungjo", Font.BOLD, 30));
        panel.add(pInformation);
        panel.add(new JLabel());
        panel.add(new JLabel());

        JLabel pHNum = new JLabel("Patient Health Number: ");
        pHNum.setFont(new Font("AppleMyungjo", Font.PLAIN, 20));
        panel.add(new JLabel());
        panel.add(pHNum);

        JTextField field_Num = new JTextField();
        field_Num.setFont(new Font("AppleMyungjo", Font.PLAIN, 30));
        panel.add(field_Num);

        JLabel dInformation = new JLabel("Doctor Information");
        dInformation.setFont(new Font("AppleMyungjo", Font.BOLD, 30));
        panel.add(dInformation);
        panel.add(new JLabel());
        panel.add(new JLabel());

        JLabel dName = new JLabel("Doctor(s) Name: ");
        dName.setFont(new Font("AppleMyungjo", Font.PLAIN, 20));
        panel.add(new JLabel());
        panel.add(dName);

        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("AppleMyungjo", Font.PLAIN, 25));

//            File[] files = new File(".").listFiles();
//            String myPath = "writeYourPathHere...";
            File folder = new File("/Users/bobzhou/IdeaProjects/CMPT270/Assignment_4/src/SystemOutput");
            File[] listOfFiles = folder.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                comboBox.addItem(listOfFiles[i].getName());
            }

        for (String save : DoctorAccess.doctorTreeMap().keySet()) {
            Doctor doctor = DoctorAccess.doctorTreeMap().get(save);
            comboBox.addItem(doctor.getName());
        }
        panel.add(comboBox);

        JButton assign = new JButton("Assign");
        assign.setFont(new Font("AppleMyungjo", Font.ITALIC, 20));
        class assignListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event) {
                String doctorName = (String) comboBox.getSelectedItem();
                String healthNum = field_Num.getText();
                Object dName = comboBox.getSelectedItem();
                int health_num = Integer.valueOf(healthNum).intValue();

                try {
                    AssignDoctors.assignDoctors(health_num, doctorName);
                    if (AssignDoctors.wasSuccessful() == true) {
                        AssignDoctors.assignDoctors(health_num, doctorName);
                        JOptionPane.showMessageDialog(null,
                                "Assign Doctor To Patient Successfully!");
                        return;
                    }
                    else
                        JOptionPane.showMessageDialog(null,
                                AssignDoctors.getErrorMessage());
                    return;
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,
                            "Please invalid numeric digits!");
                }

                StringBuilder stringBuilder = new StringBuilder("Patients Information\n");
                stringBuilder.append(dName + " " + "\n" + healthNum + " " + "\n");
                stringBuilder.append(System.getProperty("line.separator"));
                field_Num.setText("");
                System.out.println(stringBuilder);
                new AssignDoctorsToPatient().setVisible(true);
                System.out.println("Option 4: Save Clicked! " + counter);
                counter++;
                dispose();
            }
        }
        assign.addActionListener(new assignListener());
        panel.add(assign);
        panel.add(new JLabel());

        JButton cancel = new JButton("Cancel");
        cancel.setFont(new Font("AppleMyungjo", Font.ITALIC, 20));
        class cancelListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TheMenu().setVisible(true);
                System.out.println("Option 4: Cancel Clicked! " + counter);
                counter++;
                dispose();
            }
        }
        cancel.addActionListener(new cancelListener());
        panel.add(cancel);

        revalidate();
        repaint();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        AssignDoctorsToPatient assignDoctorsToPatient = new AssignDoctorsToPatient();
        assignDoctorsToPatient.setVisible(true);
    }
}
