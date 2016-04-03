package frc.team3151.robot2016;

import edu.wpi.first.wpilibj.DriverStation;
import frc.team3151.robot2016.subsystem.DriveTrain;
import frc.team3151.robot2016.subsystem.Driver;
import frc.team3151.robot2016.subsystem.Hopper;
import frc.team3151.robot2016.subsystem.Operator;
import jaci.openrio.toast.lib.log.Logger;
import jaci.openrio.toast.lib.module.IterativeModule;

public final class RobotModule extends IterativeModule {

    private static Logger logger;
    private Driver driver;
    private Operator operator;
    private DriveTrain driveTrain;
    private Hopper hopper;

    private long autoStarted = 0;

    @Override
    public void robotInit() {
        logger = new Logger("Robot2016", Logger.ATTR_DEFAULT);
        driver = new Driver();
        operator = new Operator();
        driveTrain = new DriveTrain();
        hopper = new Hopper();
    }

    @Override
    public void teleopPeriodic() {
        driveTrain.driveTeleop(driver.leftSide(), driver.rightSide());
        hopper.setHopperState(operator.hopperState());

        double timeRemaining = DriverStation.getInstance().getMatchTime();

        if (timeRemaining >= 35 && timeRemaining <= 40) {
            driver.setVibration(0.5);
            operator.setVibration(0.5);
        } else {
            driver.setVibration(0);
            operator.setVibration(0);
        }
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