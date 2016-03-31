package frc.team3151.robot2016.subsystem;

import edu.wpi.first.wpilibj.SpeedController;
import frc.team3151.robot2016.Constants;
import frc.team3151.robot2016.util.TalonUtil;

public final class Hopper {

    private final SpeedController hopperMotor;

    public Hopper() {
        hopperMotor = TalonUtil.talon(Constants.HOPPER_CAN_ID);
    }

    public void setHopperState(State state) {
        switch (state) {
            case FORWARD:
                hopperMotor.set(Constants.HOPPER_FWD_SPEED);
                break;
            case NEUTRAL:
                hopperMotor.set(0);
                break;
            case REVERSE:
                hopperMotor.set(Constants.HOPPER_REV_SPEED);
                break;
        }
    }

    public enum State {

        REVERSE, NEUTRAL, FORWARD

    }


}