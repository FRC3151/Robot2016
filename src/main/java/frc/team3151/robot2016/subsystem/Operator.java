package frc.team3151.robot2016.subsystem;

import edu.wpi.first.wpilibj.Joystick;
import frc.team3151.robot2016.Constants;
import jaci.openrio.toast.lib.device.XboxController;

public final class Operator {

    private final XboxController controller;

    public Operator() {
        this.controller = new XboxController(Constants.OPERATOR_XBOX_ID);
    }

    public Hopper.State hopperState() {
        if (controller.a()) {
            return Hopper.State.FORWARD;
        } else if (controller.b()) {
            return Hopper.State.REVERSE;
        } else {
            return Hopper.State.NEUTRAL;
        }
    }

    public void setVibration(double vibration) {
        controller.getUnderlyingJoystick().setRumble(Joystick.RumbleType.kLeftRumble, (float) vibration);
        controller.getUnderlyingJoystick().setRumble(Joystick.RumbleType.kRightRumble, (float) vibration);
    }

}