package interfacegui;

import commandStatus.SystemState;
import containers.*;
import entities.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HomePage extends JFrame {

    final int frameWidth = 600;
    final int frameHeight = 1000;
    JPanel panel = new JPanel();
    static int counter = 0;

    public HomePage() {
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
        panel.setLayout(new GridLayout(8,1));

        JLabel header = new JLabel("Welcome to the Hospital System App!");
        header.setFont(new Font("Helvetica", Font.BOLD, 10));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(header);

        JLabel homePage = new JLabel("Home Page");
        homePage.setFont(new Font("AppleMyungjo", Font.PLAIN, 40));
        homePage.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(homePage);

        JButton createWard = new JButton("Create a New Ward");
        createWard.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 30));
        createWard.setHorizontalAlignment(SwingConstants.CENTER);
        class createWardListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateNewWard().setVisible(true);
                System.out.println("Home Page: Create Ward Clicked! " + counter);
                counter++;
                dispose();
            }
        }
        createWard.addActionListener(new createWardListener());
        panel.add(createWard);

        JButton addWard = new JButton("Add a New Ward");
        addWard.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 30));
        addWard.setHorizontalAlignment(SwingConstants.CENTER);
        class addWardListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddWard().setVisible(true);
                System.out.println("Home Page: Add Ward Clicked! " + counter);
                counter++;
                dispose();
            }
        }
        addWard.addActionListener(new addWardListener());
        panel.add(addWard);

        JButton loadWard = new JButton("Load Existent Ward(s)");
        loadWard.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 30));
        loadWard.setHorizontalAlignment(SwingConstants.CENTER);
        class loadWardListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String[] options = new String[DoctorAccess.doctorTreeMap().size()];
                File folder = new File(
                        "/Users/bobzhou/IdeaProjects/CMPT270/Assignment_4/src/SystemOutput/"
                );
                File[] listOfFiles = folder.listFiles();
                String[] options = new String[listOfFiles.length];
                int count = 0;
                for (int i = 0; i < listOfFiles.length; i++) {
                    options[count] = listOfFiles[i].getName();
                    count++;
                }
                ExistentWard.existentWard(options);
                try {
//                    ExistentWard.reader();

                    ExistentWard.readers();
                    JOptionPane.showMessageDialog(null,
                            "failed!");
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
//                 catch (IOException e1) {
//                    e1.printStackTrace();
//                }

                System.out.println("Home Page: Load Existent Ward(s) Clicked! " + counter);
                counter++;
                dispose();
            }
        }
        loadWard.addActionListener(new loadWardListener());
        panel.add(loadWard);
        panel.add(new JLabel());

        JButton quit = new JButton("QUIT");
        quit.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 30));
        quit.setHorizontalAlignment(SwingConstants.CENTER);
        class quitListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null,
                        "Have a Wonderful Day!" + "\n\n\nDo you want to exit Hospital System?\n\n\n", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    dispose();
                    System.out.println("Yes button clicked! " + counter);
                    counter++;
                } else if (response == JOptionPane.NO_OPTION) {
                    System.out.println("No button clicked! " + counter);
                    counter++;
                    new HomePage().setVisible(true);
                    dispose();
                } else if (response == JOptionPane.CLOSED_OPTION) {
                    System.out.println("JOptionPane closed! " + counter);
                    counter++;
                }
                System.out.println("Home Page: QUIT Clicked! " + counter);
                counter++;
            }
        }
        quit.addActionListener(new quitListener());
        panel.add(quit);

        System.out.println("Home Page: Total Clicked! " + counter);

        revalidate();
        repaint();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
