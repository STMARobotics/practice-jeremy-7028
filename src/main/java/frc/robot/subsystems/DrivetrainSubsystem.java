package frc.robot.subsystems;

import static frc.robot.Constants.DrivetrainConstants.DEVICE_ID_LEFT_FOLLOWER;
import static frc.robot.Constants.DrivetrainConstants.DEVICE_ID_LEFT_LEADER;
import static frc.robot.Constants.DrivetrainConstants.DEVICE_ID_RIGHT_FOLLOWER;
import static frc.robot.Constants.DrivetrainConstants.DEVICE_ID_RIGHT_LEADER;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
    
    private final DifferentialDrive diffDrive;

    public DrivetrainSubsystem() {
        WPI_VictorSPX rightLeader = new WPI_VictorSPX(DEVICE_ID_RIGHT_LEADER);
        WPI_VictorSPX rightFollower = new WPI_VictorSPX(DEVICE_ID_RIGHT_FOLLOWER);
        WPI_VictorSPX leftLeader = new WPI_VictorSPX(DEVICE_ID_LEFT_LEADER);
        WPI_VictorSPX leftFollower = new WPI_VictorSPX(DEVICE_ID_LEFT_FOLLOWER);

        rightLeader.configFactoryDefault();
        rightFollower.configFactoryDefault();
        leftLeader.configFactoryDefault();
        leftFollower.configFactoryDefault();

        rightLeader.setNeutralMode(NeutralMode.Brake);
        rightFollower.setNeutralMode(NeutralMode.Brake);
        leftLeader.setNeutralMode(NeutralMode.Brake);
        leftFollower.setNeutralMode(NeutralMode.Brake);

        rightFollower.follow(rightLeader);
        leftFollower.follow(leftLeader);

        diffDrive = new DifferentialDrive(leftLeader, rightLeader);
    }

    public void drive(double speed, double rotation, boolean squareInputs) {
        diffDrive.arcadeDrive(speed, rotation, squareInputs);
    }
    
    public void drive(double speed, double rotation) {
        drive(speed, rotation, true);
    }

}
