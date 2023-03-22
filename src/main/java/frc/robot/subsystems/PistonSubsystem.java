package frc.robot.subsystems;

import static frc.robot.Constants.PistonConstants.CHANNEL_FORWARD;
import static frc.robot.Constants.PistonConstants.CHANNEL_REVERSE;
import static frc.robot.Constants.PistonConstants.MAX_PRESSURE;
import static frc.robot.Constants.PistonConstants.MIN_PRESSURE;
import static frc.robot.Constants.PistonConstants.PNEUMATICS_MODULE_TYPE;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PistonSubsystem extends SubsystemBase {
    
    private final Compressor compressor = new Compressor(PNEUMATICS_MODULE_TYPE);
    private final DoubleSolenoid solenoid = new DoubleSolenoid(PNEUMATICS_MODULE_TYPE, CHANNEL_FORWARD, CHANNEL_REVERSE);

    public PistonSubsystem() {
        compressor.enableAnalog(MIN_PRESSURE, MAX_PRESSURE);
    }

    public void extend() {
        solenoid.set(Value.kForward);
    }

    public void retract() {
        solenoid.set(Value.kReverse);
    }

}
