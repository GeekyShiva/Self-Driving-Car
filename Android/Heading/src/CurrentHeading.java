package Heading;

import java.util.*;

/**
 * Wrapper class to get correctional heading and direction.
 * @author Sudhanshu Gupta
 *
 */
public class CurrentHeading {

    /**
     * Provides correctional heading and direction to the car.
     * 
     * Computes the data using the difference latitude and longitude of current location
     * and destination location and the current heading.
     * 
     * Returns a List of String(s), where the first value is the correctional degree of heading, and
     * the second value is the correctional direction.
     * 
     * @param diffLng  Difference between destination longitude and current longitude.
     * @param diffLat  Difference between destination latitude and current latitude.
     * @param currentHeading  Current direction of heading of the car.
     * @return  List of String(s) of correctional data.
     */
    public static List<String> getHeading(float diffLng, float diffLat, float currentHeading) {
        // compute required direction of motion
        float requiredHeading = 0;

        // special handling for (near) perfect vertical motion
        if (Math.abs(diffLng) < 0.00001) {
            if (diffLat > 0) {
                requiredHeading = 0;
            } else {
                requiredHeading = 180;
            }
        }
        // special handling for (near) perfect horizontal motion
        else if (Math.abs(diffLat) < 0.00001) {
            if (diffLng > 0) {
                requiredHeading = 90;
            } else if (diffLng < 0) {
                requiredHeading = 270;
            }
        }
        else {
            requiredHeading = (float) Math.toDegrees(Math.atan2(diffLat, diffLng));

            if ((diffLat > 0) && (diffLng > 0)) {  // moving towards [1,89]
                requiredHeading = 90 - requiredHeading;
            }
            if ((diffLat < 0) && (diffLng > 0)) {  // moving towards [91,179]
                requiredHeading = 180 + requiredHeading;
            }
            if ((diffLat < 0) && (diffLng < 0)) {  // moving towards [181,269]
                requiredHeading = 390 + requiredHeading;
            }
            if ((diffLat > 0) && (diffLng < 0)) {  // moving towards [271,359]
                requiredHeading = 180 + requiredHeading;
            }
        }

        // compute correctional direction
        Float diffHeading = Math.abs(requiredHeading - currentHeading);

        if (diffHeading > 180) {
            diffHeading = 360 - diffHeading;
        }

        // compute correctional heading
        String turnDirection = "None";
        if (Math.abs(((currentHeading + diffHeading) % 360) - requiredHeading) < 0.00001) {
            turnDirection = "Right";
        }
        else {
            turnDirection = "Left";
        }

        /*
        // FOR DEBUGGING
        System.out.println(diffLng + " " + diffLat + " " + currentHeading + " " +
                requiredHeading + " " + Math.abs(((currentHeading + diffHeading) % 360) - requiredHeading));
        */

        return Arrays.asList(diffHeading.toString(), turnDirection);
    }

}
