package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.*;
import frc.robot.robotmain.Autonomous;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.robotmain.Joystickcontrols;
import frc.robot.robotmain.Buttoncontrols;
import frc.robot.commands.*;
import frc.robot.robotmain.*;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends TimedRobot {
  public static OI oi;
  public static Globalvariables globalvariables;
  public static Autonomous autonomous;
  public static Robotmap robotmap;
  public static Joystickcontrols joysticks;
  public static Buttoncontrols buttoncontrols;
  public static Vision vision;
  public static Shuffleboard_stuff shuffleboard;
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
  }
  @Override public void teleopPeriodic() {
    //called during teleop - main function
    joysticks = new Joystickcontrols();
    //buttoncontrols = new Buttoncontrols();
    //vision = new Vision(1.28,0,1); 
    //oi.drive.tankDrive(oi.ljoystick.getRawAxis(1),oi.rjoystick.getRawAxis(1));
    //oi.lmotor1.set(ControlMode.PercentOutput, oi.ljoystick.getRawAxis(1));
    // oi.lmotor2.set(ControlMode.PercentOutput, oi.rjoystick.getRawAxis(1));

   shuffleboard = new Shuffleboard_stuff();
  }
  @Override public void testInit() {
    //called when test mode first initializes
  }
  @Override public void testPeriodic() {
    //called during test mode
  }
}
