package commandStatus;
/**
 * @author Zhenzhong Zhou
 * 111956966
 * zhz028
 */

import containers.PatientAccess;
import entities.Patient;

/**
 * Command to access related to a patient
 * so that its relationship can be accessed and/or set.
 */
public class AddPatients extends CommandStatus {

    /**
     * Add Patient to the patients container
     * @param pName patient name
     * @param hNum patient health number
     */
    public static void addPatients(String pName, int hNum) {

        if (PatientAccess.patientTreeMap().containsKey(hNum)) {
            successful = false;
            errorMessage = "The health number " + hNum + " is already existent, " +
                            "but the " + pName + " is new.";
        }

        else {
            Patient patient = new Patient(pName, hNum);
            PatientAccess.patientTreeMap().put(hNum, patient);
            successful = true;
        }
    }
}
