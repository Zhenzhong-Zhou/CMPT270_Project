package commandStatus;
/**
 * @author Zhenzhong Zhou
 * 111956966
 * zhz028
 */

import containers.WardAccess;

/**
 * Display empty beds in the ward.
 */
public class DisplayBedsStatus {

    public static String bedsInformation() {
        return "Empty Beds are " + WardAccess.ward().availableBeds() +
                "in the " + WardAccess.ward().getName() + " ." ;
    }

    public static String emptyBeds() {
        return WardAccess.ward().displayEmptyBed();
    }

    public static String usedBeds() {
        return WardAccess.ward().displayUsedBed();
    }
}
