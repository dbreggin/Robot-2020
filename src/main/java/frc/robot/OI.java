package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//2019 robot stuffffffff
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
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
//Motors 
private TalonSRX motor1;
private TalonSRX motor2;
private TalonSRX motor3;
private TalonSRX motor4;
private TalonSRX motor5;
private TalonSRX motor6;
//limelight
public NetworkTable table;
public NetworkTableEntry tx;
public NetworkTableEntry ty;
public NetworkTableEntry ta;
public NetworkTableEntry tv;
public double lx;
public double ly;
public double la;
public double lv;
//misc
public double temp1;
public double temp2;
//read values periodically
public OI() {
    //2019 robot stuffffffff
    gamepad = new Joystick(Robotmap.gamepad);
    ljoystick = new Joystick(Robotmap.lJoystickPort);
    rjoystick = new Joystick(Robotmap.rJoystickPort);
    rmotor1 = new WPI_TalonSRX(4);
    rmotor2 = new VictorSPX(Robotmap.rMotor2Port);
    rmotor3 = new VictorSPX(Robotmap.rMotor3Port);
    lmotor1 = new WPI_TalonSRX(2);
    lmotor2 = new VictorSPX(Robotmap.lMotor2Port);
    lmotor3 = new VictorSPX(Robotmap.lMotor3Port);
    rmotor2.follow(rmotor1);
    rmotor3.follow(rmotor1);
    lmotor2.follow(lmotor1);
    lmotor3.follow(lmotor1);

    rmotor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,30);
    lmotor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,30);

    drive = new DifferentialDrive(rmotor1, lmotor1);
    table = NetworkTableInstance.getDefault().getTable("limelight");
    tx = table.getEntry("tx");
    ty = table.getEntry("ty");
    ta = table.getEntry("ta");
    tv = table.getEntry("tv");
    lx = tx.getDouble(0.0);
    ly = ty.getDouble(0.0);
    la = ta.getDouble(0.0);
    lv = tv.getDouble(0.0);
    }
}