package startUp;
/**
 * @author Zhenzhong Zhou
 * 111956966
 * zhz028
 */

import commandStatus.*;
import interfacegui.GraphicOrDialogOrConsole;
import userInterfaces.*;

import javax.swing.*;
import java.io.IOException;

public class StartUpDialogIO {
    private static InputOutputInterface IO;

    /**
     * Get options GUI or Console
     * @return  GUI or Console
     */
    private InputOutputInterface displayGUI() {
        AbstractDialogIO dialog = new AbstractDialogIO();
        String message = "Dialog GUI";
        String[] options = {"Dialog GUI"};
        int choice = dialog.readChoice(message, options);
        return choice == 1 ? new AbstractConsoleIO() : new AbstractDialogIO();
    }

    private void initialize() {
        CreateNewWard.createWard(
                IO.readString("Enter the name of the ward: "),
                IO.readInt("Enter the integer label of the first bed: "),
                IO.readInt("Enter the integer label of the last bed: ")
        );
        if (CreateNewWard.wasSuccessful() == false) {
            IO.outputString(CreateNewWard.getErrorMessage());
            initialize();
        }
    }

    public void run() {
        final String[] operations = {
                "0: quit",
                "1: add a new patient",
                "2. add a new doctor",
                "3. assign a doctor to a patient",
                "4. display the empty beds of the ward",
                "5. assign a patient a bed",
                "6. release a patient",
                "7. drop doctor-patient association",
                "8. display current system state"
        };
        IO = displayGUI();
        IO.outputString("Welcome to the Hospital System!");
        initialize();

    int options;
    while ((options = IO.readChoice(null, operations)) != 0) {
        switch (options) {
            case 1:
                AddPatients.addPatients(
                        IO.readString("Enter the name of the patient: "),
                        IO.readInt("Enter the health number of the patient: ")
                );
                if (AddPatients.wasSuccessful() == false)
                    IO.outputString(AddPatients.getErrorMessage());
                break;
            case 2:
                String[] yesOrNo = {"0: yes", "1: no"};
                AddDoctor.addDoctor(
                        IO.readString("Enter the name of the doctor: "),
                        IO.readChoice("Is the doctor a surgeon?", yesOrNo) == 0 ? true : false
                );
                if (AddDoctor.wasSuccessful() == false)
                    IO.outputString(AddDoctor.getErrorMessage());
                break;
            case 3:
                AssignDoctors.assignDoctors(
                        IO.readInt("Enter health number of the patient: "),
                        IO.readString("Enter name of the doctor: ")
                );
                if (AssignDoctors.wasSuccessful() == false)
                    IO.outputString(AssignDoctors.getErrorMessage());
                break;
            case 4:
                IO.outputString(DisplayBedsStatus.bedsInformation());
                break;
            case 5:
                AssignBedToPatient.assignBedToPatient(
                        IO.readInt("Enter the health number of the patient: "),
                        IO.readInt("Enter the bed number for the patient: ")
                );
                if (AssignBedToPatient.wasSuccessful() == false)
                    IO.outputString(AssignBedToPatient.getErrorMessage());
                break;
            case 6:
                ReleasePatient.releasePatients(
                        IO.readInt("Enter the health number of the patient: ")
                );
                if (AddPatients.wasSuccessful() == false)
                    IO.outputString(AddPatients.getErrorMessage());
                break;
            case 7:
                DropDoctorPatient.dropDoctorPatient(
                        IO.readInt("Enter the health number of the patient: "),
                        IO.readString("Enter the name of the doctor: ")
                );
                if (DropDoctorPatient.wasSuccessful() == false)
                    IO.outputString(DropDoctorPatient.getErrorMessage());
                break;
            case 8:
                IO.outputString(
                        "The system is as follows: \n" + SystemState.systemInformation()
                );
                break;
            default:
                System.out.println("Invalid task specification; try again.\n");
        }
    }
    IO.outputString("The system at shutdown is as follows: "
            + SystemState.systemInformation());
        try {
            SystemState.output(SystemState.systemInformation(),
                    JOptionPane.showInputDialog(null,
                    "Do you want to save output data?",
                    "Save", JOptionPane.YES_NO_OPTION));
        }
        catch (IOException e1) {
                e1.printStackTrace();
        }
        new GraphicOrDialogOrConsole().setVisible(true);
    }

    public static void main(String[] args) {
        StartUpDialogIO startUpDialogIO = new StartUpDialogIO();
        startUpDialogIO.run();
    }
}


