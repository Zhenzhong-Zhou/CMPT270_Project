package userInterfaces;
/**
 * @author Zhenzhong Zhou
 * 111956966
 * zhz028
 */

import javax.swing.JOptionPane;

public class AbstractDialogIO implements InputOutputInterface {

	public String readString(String message) {
		String input;
		String error = "\nInvalid Input: Input cannot be empty or start with a number.";
		boolean information = true;
		while (true) {
			if (information)
				input = JOptionPane.showInputDialog(message);
			else
				input = JOptionPane.showInputDialog(message + error);
			if ("".equals(input) || !input.matches("[A-Za-z]\\w+"))
				information = false;
			else
				break;
		}
		return input;
	}

	public int readInt(String message) {
		int input;
		String error = "\nInvalid Input: Input cannot be empty or non-numeric.";
		boolean information = true;
		while (true) {
			try {
				if (information)
					input = Integer.parseInt(JOptionPane.showInputDialog(message));
				else
					input = Integer.parseInt(JOptionPane.showInputDialog(message + error));
			}
			catch (NumberFormatException e) {
				information = false;
				continue;
			}
			break;
		}
		return input;
	}

	public int readChoice(String message, String[] options) {
		if (message == null)
			message = "Please select an option ";
		String selection = (String) JOptionPane.showInputDialog(
                null,                            // parent component
                message,      // prompt
                "Choice Selection",              // window title
                JOptionPane.QUESTION_MESSAGE,    // type of message
                null,                            // icon displayed
                options,                         // choices for the Combo box
                options[0]);                     // initial selection
		for (int i = 0; i < options.length; i++)
			if (selection.equals(options[i]))
				return i;
		JOptionPane.showMessageDialog(null, "Illegal choice: " + selection + "\n");
		return readChoice(message, options);
	}

	public void outputString(String outString) {
		JOptionPane.showMessageDialog(
				null, outString);
	}
}
