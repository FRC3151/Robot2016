package frc.team3151.robot2016.subsystem;

import edu.wpi.first.wpilibj.SpeedController;
import frc.team3151.robot2016.Constants;
import frc.team3151.robot2016.util.TalonUtil;

public final class Shooter {

    private final SpeedController hopperMotor;
    private final SpeedController pickUpMotor;

    public Shooter() {
        hopperMotor = TalonUtil.talon(Constants.HOPPER_CAN_ID);
        pickUpMotor = TalonUtil.talon(Constants.PICK_UP_CAN_ID);
    }

    public void setPickupActive(boolean active) {
        pickUpMotor.set(active ? Constants.SHOOTER_PICKUP_SPEED : 0);
    }

    // This is messy but it's match 67 and we compete 68?
    public void setHopperActive(int active) {
        switch (active) {
            case 1:
                hopperMotor.set(Constants.SHOOTER_HOPPER_FWD_SPEED);
                break;
            case -1:
                hopperMotor.set(Constants.SHOOTER_HOPPER_REV_SPEED);
                break;
            default:
                hopperMotor.set(0);
                break;
        }
    }

}