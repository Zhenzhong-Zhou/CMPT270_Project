package containers;
/**
 * @author Zhenzhong Zhou
 * 111956966
 * zhz028
 */

import entities.Patient;

import java.util.TreeMap;

public class PatientAccess {

    /**
     * Private constructor to ensure that no instance this class is created.
     */
    private PatientAccess() {}

    /**	The one instance of Patient. */
    private static TreeMap<Integer, Patient> patientTreeMap;

    /**
     * Return the map containing all the patients.
     * @return the patients container
     */
    public static TreeMap<Integer, Patient> patientTreeMap() {
        if (patientTreeMap == null)
            patientTreeMap = new TreeMap<>();
        return patientTreeMap;
    }
}
