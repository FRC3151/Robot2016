package frc.team3151.robot2016.subsystem;

import edu.wpi.first.wpilibj.RobotDrive;
import frc.team3151.robot2016.Constants;
import frc.team3151.robot2016.RobotModule;
import frc.team3151.robot2016.util.DeadzoneUtil;
import frc.team3151.robot2016.util.TalonUtil;

public final class DriveTrain {

    private final RobotDrive driveTrain;
    private double lastLeft = 0;
    private double lastRight = 0;

    public DriveTrain() {
        driveTrain = new RobotDrive(
                TalonUtil.talon(Constants.DRIVE_TRAIN_FL_CAN_ID),
                TalonUtil.talon(Constants.DRIVE_TRAIN_RL_CAN_ID),
                TalonUtil.talon(Constants.DRIVE_TRAIN_FR_CAN_ID),
                TalonUtil.talon(Constants.DRIVE_TRAIN_RR_CAN_ID)
        );
    }

    public void driveTeleop(double left, double right) {
        left = DeadzoneUtil.applyDeadzone(left);
        right = DeadzoneUtil.applyDeadzone(right);

        if (left > 0) {
            if (left - lastLeft > Constants.DRIVE_TRAIN_RAMPING_AMOUNT) {
                left = lastLeft + Constants.DRIVE_TRAIN_RAMPING_AMOUNT;
            }
        } else if (left < 0) {
            if (left - lastLeft < -Constants.DRIVE_TRAIN_RAMPING_AMOUNT) {
                left = lastLeft + -Constants.DRIVE_TRAIN_RAMPING_AMOUNT;
            }
        }

        if (right > 0) {
            if (right - lastRight > Constants.DRIVE_TRAIN_RAMPING_AMOUNT) {
                right = lastRight + Constants.DRIVE_TRAIN_RAMPING_AMOUNT;
            }
        } else if (right < 0) {
            if (right - lastRight < -Constants.DRIVE_TRAIN_RAMPING_AMOUNT) {
                right = lastRight + -Constants.DRIVE_TRAIN_RAMPING_AMOUNT;
            }
        }

        driveAuto(left, right);
    }

    public void driveAuto(double left, double right) {
        lastLeft = left;
        lastRight = right;

        // False = linear control, as opposed to squared inputs.
        driveTrain.tankDrive(left, right, false);
    }

}