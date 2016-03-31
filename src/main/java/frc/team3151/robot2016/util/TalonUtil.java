package frc.team3151.robot2016.util;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;
import frc.team3151.robot2016.Constants;
import jaci.openrio.toast.lib.registry.Registrar;

public final class TalonUtil {

    public static SpeedController talon(int id) {
        if (Constants.CAN_ROBOT) {
            CANTalon canTalon = Registrar.canTalon(id);

            canTalon.setVoltageRampRate(24);

            return canTalon;
        } else {
            return Registrar.talon(id);
        }
    }

}