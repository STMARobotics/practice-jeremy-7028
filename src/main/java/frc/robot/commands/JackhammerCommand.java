package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PistonSubsystem;

public class JackhammerCommand extends CommandBase {
    
    private final PistonSubsystem pistonSubsystem;

    private boolean extended = false;
    private Timer timer = new Timer();

    public JackhammerCommand(PistonSubsystem pistonSubsystem) {
        this.pistonSubsystem = pistonSubsystem;

        addRequirements(pistonSubsystem);
    }

    @Override
    public void initialize() {
        pistonSubsystem.retract();
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        if (timer.advanceIfElapsed(.5)) {
            if (extended) {
                pistonSubsystem.retract();
            } else {
                pistonSubsystem.extend();
            }
            extended = !extended;
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
