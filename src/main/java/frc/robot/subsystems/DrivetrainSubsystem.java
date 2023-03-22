package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
    
    private final DifferentialDrive diffDrive;

    public DrivetrainSubsystem() {
        WPI_VictorSPX rightLeader = new WPI_VictorSPX(0);
        WPI_VictorSPX rightFollower = new WPI_VictorSPX(1);
        WPI_VictorSPX leftLeader = new WPI_VictorSPX(2);
        WPI_VictorSPX leftFollower = new WPI_VictorSPX(3);

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

    public void drive(double speed, double rotation) {
        diffDrive.arcadeDrive(speed, rotation, true);
    }

}
