package frc.team3151.robot2016.util;

import edu.wpi.first.wpilibj.SpeedController;
import frc.team3151.robot2016.Constants;
import jaci.openrio.toast.lib.registry.Registrar;

public final class TalonUtil {

    public static SpeedController talon(int id) {
        return Constants.CAN_ROBOT ? Registrar.canTalon(id) : Registrar.talon(id);
    }

}