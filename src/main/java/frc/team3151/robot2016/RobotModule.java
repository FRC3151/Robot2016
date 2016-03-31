package frc.team3151.robot2016;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import frc.team3151.robot2016.subsystem.DriveTrain;
import frc.team3151.robot2016.subsystem.Driver;
import frc.team3151.robot2016.subsystem.Operator;
import frc.team3151.robot2016.subsystem.Shooter;
import frc.team3151.robot2016.util.DeadzoneUtil;
import jaci.openrio.toast.lib.log.Logger;
import jaci.openrio.toast.lib.module.IterativeModule;

public final class RobotModule extends IterativeModule {

    private Logger logger;
    private PowerDistributionPanel pdp;
    private Driver driver;
    private Operator operator;
    private DriveTrain driveTrain;
    private Shooter shooter;

    @Override
    public void robotInit() {
        logger = new Logger("Robot2016", Logger.ATTR_DEFAULT);
        pdp = new PowerDistributionPanel(0);
        driver = new Driver();
        operator = new Operator();
        driveTrain = new DriveTrain();
        shooter = new Shooter();

        logger.info("Booted up!");
    }

    @Override
    public void teleopPeriodic() {
        driveTrain.drive(DeadzoneUtil.applyDeadzone(driver.leftSide()), DeadzoneUtil.applyDeadzone(driver.rightSide()));
        shooter.setPickupActive(operator.pickupActive());

        if (operator.hopperActive()) {
            shooter.setHopperActive(1);
        } else if (operator.hopperReverse()) {
            shooter.setHopperActive(-1);
        } else {
            shooter.setHopperActive(0);
        }

        logger.info("Current=" + pdp.getTotalCurrent());
        logger.info("Energy=" + pdp.getTotalEnergy());
        logger.info("Power=" + pdp.getTotalPower());
    }

    @Override
    public void autonomousPeriodic() {
        driveTrain.drive(0, 0);
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