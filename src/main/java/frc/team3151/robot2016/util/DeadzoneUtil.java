package frc.team3151.robot2016.util;

import frc.team3151.robot2016.Constants;

public final class DeadzoneUtil {

    public static double applyDeadzone(double original) {
        if (original < Constants.DRIVE_TRAIN_DEADZONE_AMOUNT && original > 0) {
            return 0;
        } else if (original > -Constants.DRIVE_TRAIN_DEADZONE_AMOUNT && original < 0) {
            return 0;
        } else {
            return original;
        }
    }

}