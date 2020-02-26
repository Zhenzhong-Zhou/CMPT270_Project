package commandStatus;
/**
 * @author Zhenzhong Zhou
 * 111956966
 * zhz028
 */

import containers.WardAccess;

/**
 * Create a new ward
 */
public class CreateNewWard extends CommandStatus {

    /**
     * Create a ward with the a new name and numbers of beds
     * @param wName ward name
     * @param minBedLabel the number of first bed
     * @param maxBedLabel  the number of last bed
     */
    public static void createWard(String wName, int minBedLabel, int maxBedLabel) {
        if ("".equals(wName) || minBedLabel < 0 || maxBedLabel < minBedLabel) {
            successful = false;
            errorMessage = "The name of a ward cannot be null or empty, \n" +
                            "the minimum of bed label must be greater and equal to 0, \n" +
                            "and the maximum of bed label must be smaller " +
                            "and equal to the minimum of bed label.\n" +
                            "The error of the ward information:\n Ward Name: " + wName +
                            ", Minimum Bed Label: " + minBedLabel +
                            ", Maximum Bed Label: " + maxBedLabel + " .\n" +
                            "Try it again.\n";
            return;
        }
        successful = true;
        WardAccess.initialize(wName, minBedLabel, maxBedLabel);
    }
}
