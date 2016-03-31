package frc.team3151.robot2016.subsystem;

import frc.team3151.robot2016.Constants;
import jaci.openrio.toast.lib.device.XboxController;

public final class Driver {

    private final XboxController controller;

    public Driver() {
        this.controller = new XboxController(Constants.DRIVER_XBOX_ID);
    }

    public double leftSide() {
        return -controller.leftY();
    }

    public double rightSide() {
        return -controller.rightY();
    }

}