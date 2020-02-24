package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.robotmain.Autonomous;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.robotmain.Joystickcontrols;
import frc.robot.robotmain.Buttoncontrols;
import frc.robot.commands.*;
import frc.robot.robotmain.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.robotmain.Recursivecode;
// import jdk.nashorn.internal.objects.Global;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends TimedRobot {
  public static OI oi;
  public static Globalvariables globalvariables;
  public static Recursivecode recursivecode;
  public static Autonomous autonomous;
  public static Robotmap robotmap;
  public static Joystickcontrols joysticks;
  public static Buttoncontrols buttoncontrols;
  public static Vision vision;
  public static AngleTurn angleTurn;
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
    //autonomous = new Autonomous();
    Robot.oi.rmotor1.setSelectedSensorPosition(0, 0, 30);
    Robot.oi.lmotor1.setSelectedSensorPosition(0, 0, 30);
    Robot.oi.navx.reset();
    angleTurn = new AngleTurn(90, 0.5);
    Globalvariables.turn2angle = true;
    Globalvariables.turn1angle = 90;
    Globalvariables.speed = .6;
    Globalvariables.automode = Robot.oi.automode.getSelected();
  }
  @Override public void autonomousPeriodic() {
    // if(Globalvariables.turn2angle){
    //   AngleTurn2 angleturn2 = new AngleTurn2();
    // } else {
    //   oi.drive.arcadeDrive(0, 0);
    // }
    //called during autonomous
    autonomous = new Autonomous();
    SmartDashboard.putNumber("Automode", Globalvariables.automode);
    SmartDashboard.putBoolean("CHEKC FLAG", Globalvariables.check_flag);
    SmartDashboard.putNumber("Encoder 1", Robot.oi.rmotor1.getSelectedSensorPosition());
    SmartDashboard.putNumber("Encoder 2", Robot.oi.lmotor1.getSelectedSensorPosition());
    recursivecode = new Recursivecode();
  }
  @Override public void teleopInit() {
    recursivecode = new Recursivecode();
    //called when teleop first initializes    
  }
  @Override public void teleopPeriodic() {
    //called during teleop - main function
    joysticks = new Joystickcontrols();
    recursivecode = new Recursivecode();
    buttoncontrols = new Buttoncontrols();
   shuffleboard = new Shuffleboard_stuff();

  }
  @Override public void testInit() {
    //called when test mode first initializes
  }
  @Override public void testPeriodic() {
    //called during test mode
  }
}
