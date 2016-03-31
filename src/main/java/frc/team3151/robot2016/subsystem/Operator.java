package frc.team3151.robot2016.subsystem;

import frc.team3151.robot2016.Constants;
import jaci.openrio.toast.lib.device.XboxController;

public final class Operator {

    private final XboxController controller;

    public Operator() {
        this.controller = new XboxController(Constants.OPERATOR_XBOX_ID);
    }

    public boolean pickupActive() {
        return controller.x();
    }

    public boolean hopperActive() {
        return controller.a();
    }

    public boolean hopperReverse() {
        return controller.b();
    }

}