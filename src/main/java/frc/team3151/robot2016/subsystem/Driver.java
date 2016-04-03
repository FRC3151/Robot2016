package frc.team3151.robot2016.subsystem;

import edu.wpi.first.wpilibj.Joystick;
import frc.team3151.robot2016.Constants;
import jaci.openrio.toast.lib.device.XboxController;

public final class Driver {

    private final XboxController controller;
    private final double leftOffset;
    private final double rightOffset;

    public Driver() {
        this.controller = new XboxController(Constants.DRIVER_XBOX_ID);
        this.leftOffset = controller.leftY();
        this.rightOffset = controller.rightY();
    }

    public double leftSide() {
        return -(controller.leftY() - leftOffset);
    }

    public double rightSide() {
        return -(controller.rightY() - rightOffset);
    }

    public void setVibration(double vibration) {
        controller.getUnderlyingJoystick().setRumble(Joystick.RumbleType.kLeftRumble, (float) vibration);
        controller.getUnderlyingJoystick().setRumble(Joystick.RumbleType.kRightRumble, (float) vibration);
    }

}