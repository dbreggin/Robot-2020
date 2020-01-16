package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.OI;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  @Override public void robotInit() {
    //called when robot first initializes
   // OI = new OI();
  }
  @Override public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }
  @Override public void disabledInit() {
    //called when robot gets disabled
  }
  @Override public void disabledPeriodic() {
    //called when robot is disabled
  }
  @Override public void autonomousInit() {
    //called when autonomous first initializes
    //m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }
  @Override public void autonomousPeriodic() {
    //called during autonomous
  }
  @Override public void teleopInit() {
    //called when teleop first initializes
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }
  @Override public void teleopPeriodic() {
    //called during teleop - main function
  }
  @Override public void testInit() {
    //called when test mode first initializes
    CommandScheduler.getInstance().cancelAll();
  }
  @Override public void testPeriodic() {
    //called during test mode
  }
}
