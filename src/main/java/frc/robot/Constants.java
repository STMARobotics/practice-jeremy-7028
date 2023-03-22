// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PneumaticsModuleType;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class PistonConstants {
    public static final int CHANNEL_FORWARD = 0;
    public static final int CHANNEL_REVERSE = 15;

    public static final int MIN_PRESSURE = 80;
    public static final int MAX_PRESSURE = 100;

    public static final PneumaticsModuleType PNEUMATICS_MODULE_TYPE = PneumaticsModuleType.REVPH;
  }

  public static final class DrivetrainConstants {
    public static final int DEVICE_ID_RIGHT_LEADER = 0;
    public static final int DEVICE_ID_RIGHT_FOLLOWER = 1;
    public static final int DEVICE_ID_LEFT_LEADER = 2;
    public static final int DEVICE_ID_LEFT_FOLLOWER = 3;
  }
}
