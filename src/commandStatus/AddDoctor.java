package commandStatus;
/**
 * @author Zhenzhong Zhou
 * 111956966
 * zhz028
 */

import containers.DoctorAccess;
import entities.Doctor;
import entities.Surgeon;

/**
 * Command to access related to a doctor
 * so that its relationship can be accessed and/or set.
 */
public class AddDoctor extends CommandStatus {

    /**
     * Add new doctors to the container of doctors
     * @param dName doctor name
     * @param surgeon check doctor is surgeon or not
     */
    public static void addDoctor(String dName, boolean surgeon) {
        if (DoctorAccess.doctorTreeMap().containsKey(dName)) {
            successful = false;
            errorMessage = "The " + dName + " is already existent.";
        }

        else {
            successful = true;
            Doctor doctor = surgeon ? new Surgeon(dName) : new Doctor(dName);
            DoctorAccess.doctorTreeMap().put(dName, doctor);
        }
    }
}
