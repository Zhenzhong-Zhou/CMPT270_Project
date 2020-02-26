package commandStatus;
/**
 * @author Zhenzhong Zhou
 * 111956966
 * zhz028
 */

import containers.PatientAccess;
import containers.WardAccess;
import entities.Patient;

/**
 * Release the Patient from the bed
 */
public class ReleasePatient extends CommandStatus{

    /**
     * Release the Patient from the bed
     * @param hNum patient health number
     */
    public static void releasePatients(int hNum) {
        Patient patient = PatientAccess.patientTreeMap().get(hNum);
        if (patient == null) {
            successful = false;
            errorMessage = "Health number " + hNum + " is invalid. No one can match in the system.";
            return;
        }
        int bedLabel = patient.getBedLabel();
        if (bedLabel == -1) {
            successful = false;
            errorMessage = "Patient " + patient.getName() + " is not assigned to any bed.";
            return;
        }
        if (WardAccess.ward().getPatient(bedLabel) != patient) {
            successful = false;
            errorMessage =  "Bed: " + bedLabel + " is not stored with any patient.";
            return;
        }
        successful = true;
        WardAccess.ward().freeBed(patient.getBedLabel());
        patient.release();
    }
}
