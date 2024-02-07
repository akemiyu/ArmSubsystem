package frc.robot;

public final class Constants {
    public static class Ports {
    public static final class Secondary {
      public static final int PORT = 1;
      public static final int SHOOT = 1;
    }
  }

  public static class Ids {
    public static final int SHOOTER_ARM = 0;
  }

  public static class ArmConstants {
    public static final double kP = 0;
    public static final double kI = 0;
    public static final double kD = 0;

    public static final double kSVolts = 0;
    public static final double kGVolts = 0;
    public static final double kVVoltSecondPerRad = 0;
    public static final double kAVoltSecondSquaredPerRad = 0;

    public static final double kMaxVelocityRadPerSecond = 0;
    public static final double kMaxAccelerationRadPerSecSquared = 0;

    // The offset of the arm from the horizontal in its neutral position,
    // measured from the horizontal
    public static final double kArmOffsetRads = 0;
  }
}
