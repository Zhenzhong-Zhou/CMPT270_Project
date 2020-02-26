package commandStatus;
/**
 * @author Zhenzhong Zhou
 * 111956966
 * zhz028
 */

import containers.DoctorAccess;
import containers.PatientAccess;
import entities.Doctor;
import entities.Patient;

/**
 * Drop Doctor and Patient Relationship
 */
public class DropDoctorPatient extends CommandStatus {

    /**
     * Drop the association between the specified patient and the doctor
     * @param hNum patient health number
     * @param dName doctor name
     */
    public static void dropDoctorPatient(int hNum, String dName) {
        Patient patient = PatientAccess.patientTreeMap().get(hNum);
        if (patient == null) {
            successful = false;
            errorMessage = "Health Number: " + hNum + " cannot match any patient.";
            return;
        }
        Doctor doctor = DoctorAccess.doctorTreeMap().get(dName);
        if (doctor == null) {
            successful = false;
            errorMessage = "Doctor Name: " + dName + " is non-existent in the System.";
            return;
        }
        if (!doctor.hasPatient(hNum)) {
            successful = false;
            errorMessage = "The " + dName + " is not associated with " + hNum + " .";
            return;
        }
        if (!patient.hasDoctor(dName)) {
            successful = false;
            errorMessage = "The " + dName + "and the health number " + hNum + " both are in the system.\n"
                            + "However, they were never associated";
            return;
        }
        successful = true;
        patient.removeDoctor(dName);
        doctor.removePatient(hNum);
    }
}
