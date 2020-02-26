package containers;
/**
 * @author Zhenzhong Zhou
 * 111956966
 * zhz028
 */

import entities.Doctor;

import javax.swing.*;
import java.util.TreeMap;

/**
 * A doctor container class
 */
public class DoctorAccess {

    /**
     * Private constructor to ensure that no instance this class is created.
     */
    private DoctorAccess() {}

    /**	The one instance of Doctor. */
    private static TreeMap<String, Doctor> doctorTreeMap;

    /**
     * Return the map containing all the doctors.
     * @return the doctors container
     */
    public static TreeMap<String, Doctor> doctorTreeMap() {
        if (doctorTreeMap == null)
            doctorTreeMap = new TreeMap<>();
            return doctorTreeMap;
    }

}
