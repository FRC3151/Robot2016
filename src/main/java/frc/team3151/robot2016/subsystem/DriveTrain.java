package frc.team3151.robot2016.subsystem;

import edu.wpi.first.wpilibj.RobotDrive;
import frc.team3151.robot2016.Constants;
import frc.team3151.robot2016.util.TalonUtil;

public final class DriveTrain {

    private final RobotDrive driveTrain;

    public DriveTrain() {
        driveTrain = new RobotDrive(
                TalonUtil.talon(Constants.DRIVE_FL_CAN_ID),
                TalonUtil.talon(Constants.DRIVE_RL_CAN_ID),
                TalonUtil.talon(Constants.DRIVE_FR_CAN_ID),
                TalonUtil.talon(Constants.DRIVE_RR_CAN_ID)
        );
    }

    public void drive(double left, double right) {
        // False = linear control, as opposed to squared inputs.
        driveTrain.tankDrive(left * Constants.DRIVE_TRAIN_MOTOR_SPEED_MULTIPLIER, right * Constants.DRIVE_TRAIN_MOTOR_SPEED_MULTIPLIER, false);
    }

}