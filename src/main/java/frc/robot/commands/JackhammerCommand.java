package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PistonSubsystem;

public class JackhammerCommand extends CommandBase {
    
    private final PistonSubsystem pistonSubsystem;

    private boolean extended = false;

    public JackhammerCommand(PistonSubsystem pistonSubsystem) {
        this.pistonSubsystem = pistonSubsystem;

        addRequirements(pistonSubsystem);
    }

    @Override
    public void initialize() {
        pistonSubsystem.retract();
    }

    @Override
    public void execute() {
        if (extended) {
            pistonSubsystem.retract();
        } else {
            pistonSubsystem.extend();
        }
        extended = !extended;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
