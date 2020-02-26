package userInterfaces;
/**
 * @author Zhenzhong Zhou
 * 111956966
 * zhz028
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class AbstractConsoleIO implements InputOutputInterface {

    private static Scanner reader = new Scanner(System.in);

    public String readString(String message) {
        System.out.print(message);
        return reader.nextLine();
    }

    public int readInt(String prompt) {
        int result = 0;
        boolean successful;
        System.out.print(prompt);
        do {
            successful = true;
            try {
                result = reader.nextInt();
            }
            catch (InputMismatchException e) {
                successful = false;
                String invalid = reader.nextLine();
                System.out.print("Your typing is " + invalid + " that is not an integer value."
                        + "\nPlease try it again! ");
            }
        } while (!successful);
        reader.nextLine();
        return result;
    }

    public int readChoice(String message, String[] options) {
        if (message == null)
            message = "Please select an option to do: \n";
        else
            message += "\n";
        for (String option : options)
            message += "\t" + option + "\n";
        message += "Type your numeric selection: ";
        return readInt(message);
    }

    public void outputString(String outString) {
        System.out.println(outString);
    }
}
