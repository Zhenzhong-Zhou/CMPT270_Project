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

/**
 *  Assign doctors to a patient
 */
public class AssignDoctors extends CommandStatus {

    /**
     * Assign the specified doctor to the specified patient
     * @param hNum patient health number
     * @param dName doctor name
     */
    public static void assignDoctors(int hNum, String dName) {

        Patient patient = PatientAccess.patientTreeMap().get(hNum);

        if (patient == null) {
            successful = false;
            errorMessage = "The health number: " + hNum + " cannot match any patient.";
            return;
        }

        Doctor doctor = DoctorAccess.doctorTreeMap().get(dName);
        if (doctor == null) {
            successful = false;
            errorMessage = dName + " is non-existent in the System.";
            return;
        }
        if (patient.hasDoctor(dName)){
            successful = false;
            errorMessage = dName + " is already has patient.";
            return;
        }
        else {
            successful = true;
            patient.addDoctor(doctor);
            doctor.addPatient(patient);
        }
    }
}
