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
 * Command to access related to a bed
 * so that its relationship can be accessed and/or set.
 */
public class AssignBedToPatient extends CommandStatus {

    /**
     * Assign the particular patient to the particular bed label
     * @param hNum patient health number
     * @param bedLabel the particular patient to the particular bed label
     */
    public static void assignBedToPatient(int hNum, int bedLabel) {
        Patient patient = PatientAccess.patientTreeMap().get(hNum);
        if (patient == null) {
            successful = false;
            errorMessage = "Health Number: " + hNum + " cannot match any patient.";
            return;
        }

        if (patient.getBedLabel() != -1) {
            successful = false;
            errorMessage = "The health number " + patient.getHealthNumber() +
                    " with patient cannot be assigned a new bed since " +
                    "the health number " + patient.getHealthNumber() + " with patient has a bed.";
            return;
        }

        int minLabel = WardAccess.ward().getMinBedLabel();
        int maxLabel = WardAccess.ward().getMaxBedLabel();
        if (bedLabel < minLabel || bedLabel > maxLabel) {
            successful = false;
            errorMessage = "The number of beds are invalid. The number of beds must be between "
                    + minLabel + " and " + maxLabel + " .";
            return;
        }

        if(WardAccess.ward().isOccupied(bedLabel)){
            throw new RuntimeException("The patient has a bed but the patient assign to a bed again.");
        }
        successful = true;
        patient.setBedLabel(bedLabel);
        WardAccess.ward().assignPatientToBed(patient, bedLabel);
    }
}
