package commandStatus;
/**
 * @author Zhenzhong Zhou
 * 111956966
 * zhz028
 */

import containers.DoctorAccess;
import containers.PatientAccess;
import containers.WardAccess;
import entities.Doctor;
import entities.Patient;

import javax.security.sasl.SaslClient;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SystemState {

    private static String result;

    public static void systemState() {
        Collection<Patient> patients = PatientAccess.patientTreeMap().values();
        if (patients.isEmpty()) {
            result = "There is no patient in the hospital system.\n";
        }
        else {
            result = "\n===== THE LIST OF PATIENTS =====\n";
            for (Patient patient : patients)
                result += patient;
        }
        Collection<Doctor> doctors = DoctorAccess.doctorTreeMap().values();
        if (doctors.isEmpty()) {
            result += "There is no doctor in the hospital system.\n";
        }
        else {
            result += "\n===== THE LIST OF DOCTORS =====\n";
            for (Doctor doctor : doctors)
                result += doctor;
        }
        try {
            result += "\nWard Information: " + WardAccess.ward();
        }
        catch (RuntimeException e) {
            System.out.println("Ward is invalid since there is no ward. Ward must be created!");
        }
    }

    public static String systemInformation() {
        systemState();
        return result;
    }

    public static void output(String writeIN, String title) throws IOException {
        File file = new File("/Users/bobzhou/IdeaProjects/CMPT270/Assignment_4/src/SystemOutput/"
                + title );
        try {
                if (file.exists()) {
                    JOptionPane.showMessageDialog(null,
                            "failed!");
                    System.out.println("\n***** file is existent ******\n");
                    return;
                }
                else {
                    System.out.println("successfully create a file" +
                            " and next message is going to br wrong");
                    return;
                }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
            try {
                file.createNewFile();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(writeIN);
            fileWriter.close();
            System.out.println("\n=== successful but overwrite ===\n");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(writeIN);
        fileWriter.close();
    }
    public static void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String name = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        result = "username: " + name + "\n" + "password: " + password;
        System.out.println("login() username: " + name + "\n" + "login() password: " + password);
    }
    public static String signIn(){
        login();
        return result + "\n";
    }

    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("match username: ");
        String findUsername = scanner.nextLine();
//        System.out.println("match password: ");
//        String findUserKey = scanner.nextLine();
        scanner.close();
        return findUsername;
    }


    public static void displayResults(String username, List<String> name) throws IOException{
        boolean inFileUser = name.stream().anyMatch(b->b.equals(username));
//        boolean inFileKey = name.stream().anyMatch(p->p.equals(password));
        try {
            if (inFileUser) {
                System.out.println("right flag\n" + username);
            } else {
                System.out.println("wrong " + username + " NOT Correct\n try it again");
//                Scanner scanner = new Scanner(System.in);
//                System.out.println("match username: ");
//                scanner.close();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("never show scanner again");
        }


      }

    final static String user = "bob";
    final static int password = 666;


    public static void main(String[] args) throws IOException {

        try{
            output(signIn(), JOptionPane.showInputDialog(null, "save"));
        }
        catch (IOException ex){
            ex.printStackTrace();
        }



        Path path = Paths.get(
                "/Users/bobzhou/IdeaProjects/CMPT270/Assignment_4/src/SystemOutput/right").toAbsolutePath();
        List<String> username = Files.lines(path).collect(Collectors.toList());
        String userName = getInput();
        displayResults(userName, username);


//        String uName, pass;
//        int passes;
//        Scanner input = new Scanner(System.in);
//        System.out.println("another match user: ");
//        uName = input.nextLine();
////        System.out.println("another match pass: ");
////        passes = input.nextInt();
//        if (userName.equals(user) && userName.equals(uName)) {
//            System.out.println("true");
//        }
//        else
//            System.out.println("wrong");
    }
}
