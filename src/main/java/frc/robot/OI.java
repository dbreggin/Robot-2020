package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//2019 robot stuffffffff
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//limelight
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public final class OI {
//2019 robot stuffffffff
public WPI_TalonSRX rmotor1;
public VictorSPX rmotor2;
public VictorSPX rmotor3;
public WPI_TalonSRX lmotor1;
public VictorSPX lmotor2;
public VictorSPX lmotor3;
public Joystick gamepad;
public Joystick rjoystick;
public Joystick ljoystick;
public DifferentialDrive drive;
public double limelightX;
public double limelightY;
public double limelightArea;
public double limelightTarget;
//Motors 
private TalonSRX motor1;
private TalonSRX motor2;
private TalonSRX motor3;
private TalonSRX motor4;
private TalonSRX motor5;
private TalonSRX motor6;
//limelight
public  NetworkTable  table;
NetworkTableEntry tv = table.getEntry("tv");
NetworkTableEntry tx = table.getEntry("tx");
NetworkTableEntry ty = table.getEntry("ty");
NetworkTableEntry ta = table.getEntry("ta");
//read values periodically
double xoffset = tx.getDouble(0.0);
double yoffset = ty.getDouble(0.0);
double limelightarea = ta.getDouble(0.0);
public OI() {
    //2019 robot stuffffffff
    gamepad = new Joystick(Robotmap.gamepad);
    ljoystick = new Joystick(Robotmap.lJoystickPort);
    rjoystick = new Joystick(Robotmap.rJoystickPort);
    rmotor1 = new WPI_TalonSRX(Robotmap.rMotor1Port);
    rmotor2 = new VictorSPX(Robotmap.rMotor2Port);
    rmotor3 = new VictorSPX(Robotmap.rMotor3Port);
    lmotor1 = new WPI_TalonSRX(Robotmap.lMotor1Port);
    lmotor2 = new VictorSPX(Robotmap.lMotor2Port);
    lmotor3 = new VictorSPX(Robotmap.lMotor3Port);
    rmotor2.follow(rmotor1);
    rmotor3.follow(rmotor1);
    lmotor2.follow(lmotor1);
    lmotor3.follow(lmotor1);
    drive = new DifferentialDrive(rmotor1, lmotor1);

    table = NetworkTableInstance.getDefault().getTable("limelight");
    tx = table.getEntry("tx");
    ty = table.getEntry("ty");
    ta = table.getEntry("ta");
    tv = table.getEntry("tv");
      
    limelightX = tx.getDouble(0.0);
    limelightY = ty.getDouble(0.0);
    limelightArea = ta.getDouble(0.0);
    limelightTarget = tv.getDouble(0.0);
    }
}