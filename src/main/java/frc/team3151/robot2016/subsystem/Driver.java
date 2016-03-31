package frc.team3151.robot2016.subsystem;

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

}