package interfacegui;

import containers.DoctorAccess;
import entities.Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWard extends JFrame {

    final int frameWidth = 800;
    final int frameHeight = 1400;
    JPanel panel = new JPanel();
    static int counter = 0;

    public AddWard() {
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

        JLabel homePage = new JLabel("Add a Ward");
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
//        StringBuilder stringBuilder = new StringBuilder("Ward Information\n");
        class doneListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TheMenu().setVisible(true);
                dispose();
                String[] options = new String[DoctorAccess.doctorTreeMap().size()];
                int count = 0;
                for (String save : DoctorAccess.doctorTreeMap().keySet()) {
                    Doctor doctor = DoctorAccess.doctorTreeMap().get(save);
                    options[count] = doctor.getName();
                    count++;
                }
                ExistentWard.existentWard(options);
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

    public static void main(String[] args) {
        AddWard wardList = new AddWard();
        wardList.setVisible(true);
        wardList.revalidate();
        wardList.repaint();
    }
}
