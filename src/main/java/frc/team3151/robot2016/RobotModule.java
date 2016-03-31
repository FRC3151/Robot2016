package frc.team3151.robot2016;

import frc.team3151.robot2016.subsystem.DriveTrain;
import frc.team3151.robot2016.subsystem.Driver;
import frc.team3151.robot2016.subsystem.Hopper;
import frc.team3151.robot2016.subsystem.Operator;
import jaci.openrio.toast.lib.module.IterativeModule;

public final class RobotModule extends IterativeModule {

    private Driver driver;
    private Operator operator;
    private DriveTrain driveTrain;
    private Hopper hopper;

    private long autoStarted = 0;

    @Override
    public void robotInit() {
        driver = new Driver();
        operator = new Operator();
        driveTrain = new DriveTrain();
        hopper = new Hopper();
    }

    @Override
    public void teleopPeriodic() {
        driveTrain.driveTeleop(driver.leftSide(), driver.rightSide());
        hopper.setPickupActive(operator.pickupActive());
        hopper.setHopperState(operator.hopperState());
    }

    @Override
    public void autonomousInit() {
        autoStarted = System.currentTimeMillis();
    }

    @Override
    public void autonomousPeriodic() {
        long autoDuration = System.currentTimeMillis() - autoStarted;

        if (autoDuration < Constants.AUTO_DRIVE_TIME_MS) {
            driveTrain.driveAuto(Constants.AUTO_DRIVE_SPEED, Constants.AUTO_DRIVE_SPEED);
        } else {
            driveTrain.driveAuto(0, 0);
        }
    }

    @Override
    public String getModuleName() {
        return "Robot2016";
    }

    @Override
    public String getModuleVersion() {
        return "0.0.1";
    }

}