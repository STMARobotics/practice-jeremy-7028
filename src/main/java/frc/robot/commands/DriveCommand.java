package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveCommand extends CommandBase {
    
    private final DrivetrainSubsystem drivetrainSubsystem;
    private final DoubleSupplier xSupplier;
    private final DoubleSupplier ySupplier;
    private final BooleanSupplier useSquaresSupplier;

    public DriveCommand(DoubleSupplier xSupplier, DoubleSupplier ySupplier, BooleanSupplier useSquaresSupplier, DrivetrainSubsystem drivetrainSubsystem) {
        this.drivetrainSubsystem = drivetrainSubsystem;
        this.xSupplier = xSupplier;
        this.ySupplier = ySupplier;
        this.useSquaresSupplier = useSquaresSupplier;
        
        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void execute() {
        drivetrainSubsystem.drive(xSupplier.getAsDouble(), ySupplier.getAsDouble(), useSquaresSupplier.getAsBoolean());
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
