package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveCommand extends CommandBase {
    
    private final DrivetrainSubsystem drivetrainSubsystem;
    private final XboxController controller;

    public DriveCommand(XboxController controller, DrivetrainSubsystem drivetrainSubsystem) {
        this.drivetrainSubsystem = drivetrainSubsystem;
        this.controller = controller;

        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void execute() {
        drivetrainSubsystem.drive(controller.getRightX(), controller.getLeftY() * .7);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
