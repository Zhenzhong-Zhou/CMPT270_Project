package interfacegui;

//import entities.Floor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ExistentWard {

    public static int existentWard(String[] options) {

        String selection = (String) JOptionPane.showInputDialog(
                null,                            // parent component
                "Select a Ward",      // prompt
                "Existent Word",              // window title
                JOptionPane.QUESTION_MESSAGE,    // type of message
                null,                            // icon displayed
                options,                         // choices for the Combo box
                options[0]);                     // initial selection
        for (int i = 0; i < options.length; i++)
            if (selection.equals(options[i]))
                return i;
        JOptionPane.showMessageDialog(null, "Illegal choice: " + selection + "\n");
        return existentWard(options);
    }

    public static File folder = new File(
            "/Users/bobzhou/IdeaProjects/CMPT270/Assignment_4/src/SystemOutput");
    static String temp = "";

    public static void listFilesForFolder(final File folder) {

        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                // System.out.println("Reading files under the folder "+folder.getAbsolutePath());
                listFilesForFolder(fileEntry);
            } else {
                if (fileEntry.isFile()) {
                    temp = fileEntry.getName();
                    if ((temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equals("txt"))
                        System.out.println("File= " + folder.getAbsolutePath()+ "\\" + fileEntry.getName());
                }

            }
        }
    }

    public static void readers() throws IOException {
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            File folder = new File("/Users/bobzhou/IdeaProjects/CMPT270/Assignment_4/src/SystemOutput");
            if (folder.isDirectory()) {
//                for (File file : folder.listFiles())
                for (int i = 0; i < folder.listFiles().length; i++)
                {
//                    fileReader = new FileReader(file);
                    fileReader = new FileReader(folder.listFiles()[i]);
                    bufferedReader = new BufferedReader(fileReader);
                    String line;
                    int lineCount = 0;
                    while (null != (line = bufferedReader.readLine())) {
                        lineCount++;
                        if (-1 != lineCount) {
                            System.out.println(line+"$$$$$$$");
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bufferedReader)
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }


    public static void reader() throws IOException {

    FileReader fileReader = new FileReader(
            "/Users/bobzhou/IdeaProjects/CMPT270/Assignment_4/src/SystemOutput/"
            + folder.getName()
                     );

    BufferedReader bufferedReader = new BufferedReader(fileReader);

    String text = "";
    String line = bufferedReader.readLine();
        while (line!=null) {
        text += line  + "\n";
        line = bufferedReader.readLine();
    }
        bufferedReader.close();
        System.out.println(text);
    }


}
