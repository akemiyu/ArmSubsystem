package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.ArmSubsytem;

public class RobotContainer {
  private final Joystick m_secondary = new Joystick(Constants.Ports.Secondary.PORT);
  private final JoystickButton m_shoot = new JoystickButton(m_secondary, Constants.Ports.Secondary.SHOOT);

  private final ArmSubsytem m_arm = new ArmSubsytem();

  public RobotContainer() {
    configureBindings();
    m_shoot.onTrue(new InstantCommand(() ->  m_arm.setArmGoalCommand(Constants.ArmConstants.kArmOffsetRads)));
  }

  private void configureBindings() { 
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
