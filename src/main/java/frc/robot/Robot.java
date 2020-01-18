package frc.robot;

import org.ietf.jgss.Oid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.OI;
import frc.robot.Globalvariables;
import frc.robot.robotmain.Autonomous;
import frc.robot.Robotmap;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.robotmain.Joystickcontrols;
import frc.robot.robotmain.Buttoncontrols;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  public static OI oi;
  public static Globalvariables globalvariables;
  public static Autonomous autonomous;
  public static Robotmap robotmap;
  public static Joystickcontrols joysticks;
  public static Buttoncontrols buttoncontrols;
  public double limelightX;
  public double limelightY;
  public double limelightArea;
  public double limelightTarget;
  public DifferentialDrive drive;

  @Override public void robotInit() {
    //called when robot first initializes
    oi = new OI();
    globalvariables = new Globalvariables();
    robotmap = new Robotmap();
    
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
    autonomous = new Autonomous();

  }
  @Override public void autonomousPeriodic() {
    //called during autonomous
  }
  @Override public void teleopInit() {
    //called when teleop first initializes
    joysticks = new Joystickcontrols();
    buttoncontrols = new Buttoncontrols();

    
  }
  @Override public void teleopPeriodic() {
    //called during teleop - main function
    joysticks = new Joystickcontrols();
  }
  @Override public void testInit() {
    //called when test mode first initializes
    CommandScheduler.getInstance().cancelAll();
  }
  @Override public void testPeriodic() {
    //called during test mode
  }
}
