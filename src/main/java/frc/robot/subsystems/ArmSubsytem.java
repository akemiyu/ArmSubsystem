package frc.robot.subsystems;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkBase.ControlType;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.TrapezoidProfileSubsystem;
import frc.robot.Constants.ArmConstants;

public class ArmSubsytem extends TrapezoidProfileSubsystem {
    private CANSparkFlex m_motor;
    private ArmFeedforward m_feedforward = new ArmFeedforward(
        ArmConstants.kSVolts, 
        ArmConstants.kGVolts,
        ArmConstants.kVVoltSecondPerRad);
    
    public ArmSubsytem() {
        super(
            new TrapezoidProfile.Constraints(
                ArmConstants.kMaxVelocityRadPerSecond, ArmConstants.kMaxAccelerationRadPerSecSquared),
                ArmConstants.kArmOffsetRads);
       m_motor.getPIDController().setP(ArmConstants.kP, 0);
       m_motor.getPIDController().setI(ArmConstants.kI, 0);
       m_motor.getPIDController().setD(ArmConstants.kD, 0);
    }

    @Override
    public void useState(TrapezoidProfile.State setpoint) {
        // Calculate the feedforward from the sepoint
        double feedforward = m_feedforward.calculate(setpoint.position, setpoint.velocity);
        // Add the feedforward to the PID output to get the motor output
        m_motor.getPIDController().setReference(setpoint.position, ControlType.kPosition, 0, feedforward / 12.0);
    }

    public Command setArmGoalCommand(double kArmOffsetRads) {
        return Commands.runOnce(() -> setGoal(kArmOffsetRads), this);
    }
}
