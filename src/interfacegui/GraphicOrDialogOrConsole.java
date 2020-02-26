package interfacegui;
/**
 * @author Zhenzhong Zhou
 * zhz028
 * 11195696
 */
import startUp.HospitalSystem;
import startUp.StartUpDialogIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicOrDialogOrConsole extends JFrame{

    final int frameWidth = 500;
    final int frameHeight = 500;
    JPanel panel = new JPanel();
    static int counter = 0;

    public GraphicOrDialogOrConsole() {
        setTitle("Graphic GUI or Dialog GUI or Console");
        setLayout(null);
        setSize(frameWidth, frameHeight);
        setVisible(true);

        setLayout(new BorderLayout(50, 50));
        JLabel author = new JLabel("Zhenzhong Zhoun \n zhz028\n 11195696");
        author.setFont(new Font("AppleMyungjo", Font.BOLD + Font.ITALIC, 15));
        author.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add("South", author);
        getContentPane().add("North", new JLabel());
        getContentPane().add("East", new JLabel());
        getContentPane().add("West", new JLabel());
        getContentPane().add("Center", panel);
        panel.setLayout(new GridLayout(5,3));

        JButton gui = new JButton("Graphic GUI");
        gui.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 20));
        gui.setHorizontalAlignment(SwingConstants.CENTER);
        class guiListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomePage().setVisible(true);
                dispose();
                System.out.println("Console or GUI: GUI Clicked! " + counter);
                counter++;
            }
        }
        gui.addActionListener(new guiListener());
        panel.add(new JLabel());
        panel.add(gui);

        JButton dialog = new JButton("Dialog GUI");
        dialog.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 20));
        dialog.setHorizontalAlignment(SwingConstants.CENTER);
        class dialogListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StartUpDialogIO().run();
                System.out.println("Console or GUI: Console Clicked! " + counter);
                counter++;
            }
        }
        dialog.addActionListener(new dialogListener());
        panel.add(dialog);

        JButton console = new JButton("Console");
        console.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 20));
        console.setHorizontalAlignment(SwingConstants.CENTER);
        class consoleListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HospitalSystem().run();
                System.out.println("Console or GUI: Console Clicked! " + counter);
                counter++;
            }
        }
        console.addActionListener(new consoleListener());
        panel.add(console);

        System.out.println("Console or GUI: Total Clicked! ");

        revalidate();
        repaint();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
