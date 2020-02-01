package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.DigitalInput;

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
public TalonSRX intake_motor;
public TalonSRX cp_motor;
public TalonSRX hopper_motor;
public TalonSRX outake_motor;

//Motors 
private TalonSRX motor1;
private TalonSRX motor2;
private TalonSRX motor3;
private TalonSRX motor4;
private TalonSRX motor5;
private TalonSRX motor6;

//private neo shootermotor;
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

public DigitalInput lineSensor;
public DigitalInput lineSensor2;
//read values periodically
public OI() {
    //2019 robot stuffffffff
    gamepad = new Joystick(Robotmap.gamepad);
    ljoystick = new Joystick(0);
    rjoystick = new Joystick(1);
    rmotor1 = new WPI_TalonSRX(4);
    rmotor2 = new VictorSPX(5);
    rmotor3 = new VictorSPX(7);
    lmotor1 = new WPI_TalonSRX(2);
    lmotor2 = new VictorSPX(0);
    lmotor3 = new VictorSPX(8);
    intake_motor = new TalonSRX(1);
    cp_motor = new TalonSRX(3);
    hopper_motor = new TalonSRX(6);
    outake_motor = new TalonSRX(9);
    //Shootermotor = new Neomotor(?);
    //Shootermotor2 = new Neomotor(?);

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

    lineSensor = new DigitalInput(0);
    lineSensor2 = new DigitalInput(1);

    }
}