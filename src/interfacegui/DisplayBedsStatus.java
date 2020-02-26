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

public class DisplayBedsStatus extends JFrame {

    final int frameWidth = 600;
    final int frameHeight = 900;
    JPanel panel = new JPanel();
    static int counter = 0;

    public DisplayBedsStatus() {

        setTitle("Display Beds Status");
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

        JLabel header = new JLabel("Display Beds Status");
        header.setFont(new Font("AppleMyungjo", Font.PLAIN, 40));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(new JLabel());
        panel.add(header);
        panel.add(new JLabel());

        JButton displayEmptyBeds = new JButton("Display EMPTY Beds");
        displayEmptyBeds.setFont(new Font("AppleMyungjo", Font.PLAIN, 20));
        displayEmptyBeds.setHorizontalAlignment(SwingConstants.CENTER);
        class displayEmptyListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message =  commandStatus.DisplayBedsStatus.emptyBeds();
                JOptionPane.showMessageDialog(null, message,
                        "Empty Beds Details", JOptionPane.PLAIN_MESSAGE);
                new DisplayBedsStatus().setVisible(true);
                System.out.println("Option 5: Display EMPTY Beds Clicked! " + counter);
                counter++;
                dispose();
            }
        }
        displayEmptyBeds.addActionListener(new displayEmptyListener());
        panel.add(displayEmptyBeds);

        JButton displayUsedBeds = new JButton("Display USED Beds");
        displayUsedBeds.setFont(new Font("AppleMyungjo", Font.PLAIN, 20));
        displayUsedBeds.setHorizontalAlignment(SwingConstants.CENTER);
        class displayUsedListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = commandStatus.DisplayBedsStatus.usedBeds();
                JOptionPane.showMessageDialog(null, message, "Used Beds Details", JOptionPane.PLAIN_MESSAGE);
                new DisplayBedsStatus().setVisible(true);
                System.out.println("Option 5: Display USED Beds Clicked! " + counter);
                counter++;
                dispose();
            }
        }
        displayUsedBeds.addActionListener(new displayUsedListener());
        panel.add(displayUsedBeds);

        JButton back = new JButton("BACK");
        back.setFont(new Font("AppleMyungjo", Font.PLAIN, 20));
        back.setHorizontalAlignment(SwingConstants.CENTER);
        class backListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TheMenu().setVisible(true);
                System.out.println("Option 5: BACK Clicked! " + counter);
                counter++;
                dispose();
            }
        }
        back.addActionListener(new backListener());
        panel.add(new JLabel());
        panel.add(back);

        System.out.println("Option 5: Total Clicked! " + counter);

        revalidate();
        repaint();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
