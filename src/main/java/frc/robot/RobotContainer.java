// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.JackhammerCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.PistonSubsystem;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
  private final PistonSubsystem pistonSubsystem = new PistonSubsystem();
  private final CommandXboxController controller = new CommandXboxController(0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    configureBindings();
    CameraServer.startAutomaticCapture();
    drivetrainSubsystem.setDefaultCommand(new DriveCommand(
        () -> MathUtil.applyDeadband(-controller.getLeftY(), 0.1),
        () -> MathUtil.applyDeadband(-controller.getRightX(), 0.1) * .7,
        drivetrainSubsystem));
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    controller.leftBumper().onTrue(Commands.runOnce(pistonSubsystem::extend, pistonSubsystem));
    controller.rightBumper().onTrue(Commands.runOnce(pistonSubsystem::retract, pistonSubsystem));
    controller.a().whileTrue(new JackhammerCommand(pistonSubsystem));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new RunCommand(() -> drivetrainSubsystem.drive(1, 0, false), drivetrainSubsystem).withTimeout(1.5)
        .andThen(new JackhammerCommand(pistonSubsystem));
  }
}
