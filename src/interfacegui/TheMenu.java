package interfacegui;
/**
 * @author Zhenzhong Zhou
 * zhz028
 * 11195696
 */

import commandStatus.SystemState;
import containers.DoctorAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TheMenu extends JFrame{

    final int frameWidth = 1400;
    final int frameHeight = 1000;
    JPanel panel = new JPanel();
    static int counter = 0;

    public TheMenu() {
        setTitle("Main Menu");
        setLayout(null);
        setSize(frameWidth, frameHeight);
        setVisible(true);

        setLayout(new BorderLayout(200, 300));
        JLabel author = new JLabel("Zhenzhong Zhoun \n zhz028\n 11195696");
        author.setFont(new Font("AppleMyungjo", Font.BOLD + Font.ITALIC, 15));
        author.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add("South", author);
        getContentPane().add("East", new JLabel());
        getContentPane().add("West", new JLabel());
        getContentPane().add("Center", panel);
        panel.setLayout(new GridLayout(5,1));

        JLabel header = new JLabel("Main Menu");
        header.setFont(new Font("Helvetica", Font.BOLD, 50));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(new JLabel(), new JLabel());
        panel.add(header);
        panel.add(new JLabel());

        JLabel options = new JLabel("Operation Options:");
        options.setFont(new Font("AppleMyungjo", Font.PLAIN, 25));
        options.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(options);
        panel.add(new JLabel());
        panel.add(new JLabel(), new JLabel());

        JButton quit = new JButton("1. QUIT");
        quit.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 20));
        quit.setHorizontalAlignment(SwingConstants.CENTER);
        class quitListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null,
                        "Do you want to continue?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    String message =  SystemState.systemInformation();
                    JOptionPane.showMessageDialog(null, message,
                            "System State", JOptionPane.PLAIN_MESSAGE);
                    try {
                        SystemState.output(SystemState.systemInformation(),
                                JOptionPane.showInputDialog(null,
                                        "Do you want to save output data?",
                                        "Save", JOptionPane.YES_NO_OPTION));
                    }
                    catch (IOException e1) {
                        e1.printStackTrace();
                    }
//                    new HomePage().setVisible(true);
                    dispose();
                    System.out.println("Yes button clicked! " + counter);
                    counter++;
                }
                else if (response == JOptionPane.NO_OPTION) {
                    System.out.println("No button clicked! " + counter);
                    counter++;
                    new TheMenu().setVisible(true);
                    dispose();
                }
                else if (response == JOptionPane.CLOSED_OPTION) {
                    System.out.println("JOptionPane closed! " + counter);
                    counter++;
                }
//                new HomePage().setVisible(true);
                System.out.println("The Menu: Option 1 Clicked! " + counter);
                counter++;
            }
        }
        quit.addActionListener(new quitListener());
        panel.add(quit);

        JButton addPatient = new JButton("2. Add a New Patient");
        addPatient.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 18));
        addPatient.setHorizontalAlignment(SwingConstants.CENTER);
        class addPatientListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddPatient().setVisible(true);
                System.out.println("The Menu: Option 2 Clicked! " + counter);
                counter++;
                dispose();
            }
        }
        addPatient.addActionListener(new addPatientListener());
        panel.add(addPatient);

        JButton addDoctor = new JButton("3. Add a New Doctor");
        addDoctor.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 18));
        addDoctor.setHorizontalAlignment(SwingConstants.CENTER);
        class addDoctorListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDoctor().setVisible(true);
                System.out.println("The Menu: Option 3 Clicked! " + counter);
                counter++;
                dispose();
            }
        }
        addDoctor.addActionListener(new addDoctorListener());
        panel.add(addDoctor);

        JButton assignDoctorToPatient = new JButton("4. Assign Doctor To Patient");
        assignDoctorToPatient.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 18));
        assignDoctorToPatient.setHorizontalAlignment(SwingConstants.CENTER);
        class assignDoctorsListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AssignDoctorsToPatient().setVisible(true);
                System.out.println("The Menu: Option 4 Clicked! " + counter);
                counter++;
                dispose();
            }
        }
        assignDoctorToPatient.addActionListener(new assignDoctorsListener());
        panel.add(assignDoctorToPatient);

        JButton displayEmptyBed = new JButton("5. Display Empty Beds");
        displayEmptyBed.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 18));
        displayEmptyBed.setHorizontalAlignment(SwingConstants.CENTER);
        class displayListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayBedsStatus().setVisible(true);
                System.out.println("The Menu: Option 5 Clicked! " + counter);
                counter++;
                dispose();
            }
        }
        displayEmptyBed.addActionListener(new displayListener());
        panel.add(displayEmptyBed);

        JButton assignPatientToBed = new JButton("6. Assign Patient To Bed");
        assignPatientToBed.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 18));
        assignPatientToBed.setHorizontalAlignment(SwingConstants.CENTER);
        class assignPatientsToBedsListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AssignPatientsToBeds().setVisible(true);
                System.out.println("The Menu: Option 6 Clicked! " + counter);
                counter++;
                dispose();
            }
        }
        assignPatientToBed.addActionListener(new assignPatientsToBedsListener());
        panel.add(assignPatientToBed);

        JButton releasePatient = new JButton("7. Release Patient");
        releasePatient.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 18));
        releasePatient.setHorizontalAlignment(SwingConstants.CENTER);
        class releasePatientListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReleasePatient().setVisible(true);
                System.out.println("The Menu: Option 7 Clicked! " + counter);
                counter++;
                dispose();
            }
        }
        releasePatient.addActionListener(new releasePatientListener());
        panel.add(releasePatient);

        JButton dropDoctorPatientAssociation = new JButton("8. Drop Doctor-Patient Association");
        dropDoctorPatientAssociation.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 18));
        dropDoctorPatientAssociation.setHorizontalAlignment(SwingConstants.CENTER);
        class dropDoctorListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DropDoctorPatient().setVisible(true);
                System.out.println("The Menu: Option 8 Clicked! " + counter);
                counter++;
                dispose();
            }
        }
        dropDoctorPatientAssociation.addActionListener(new dropDoctorListener());
        panel.add(dropDoctorPatientAssociation);

        JButton displaySystemState = new JButton("9. Display Current System State");
        displaySystemState.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 18));
        displaySystemState.setHorizontalAlignment(SwingConstants.CENTER);
        class displayStateListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = SystemState.systemInformation();
                JOptionPane.showMessageDialog(null, message, "Display Current System State",
                        JOptionPane.PLAIN_MESSAGE);
                new TheMenu().setVisible(true);
                System.out.println("The Menu: Option 9 Clicked! " + counter);
                counter++;
                dispose();
            }
        }
        displaySystemState.addActionListener(new displayStateListener());
        panel.add(displaySystemState);

        System.out.println("The Menu: Total Clicked! " + counter);

        revalidate();
        repaint();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}