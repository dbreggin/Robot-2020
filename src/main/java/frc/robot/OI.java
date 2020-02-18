package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.DigitalInput;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMax;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import java.util.Map;
import com.kauailabs.navx.frc.AHRS;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//2019 robot stuffffffff
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

//import com.kauailabs.navx.frc.AHRS;
//limelight
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Talon;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMax;


public final class OI {
//2019 robot stuffffffff
public WPI_TalonSRX rmotor1;
public VictorSPX rmotor2;
public VictorSPX rmotor3;
public WPI_TalonSRX lmotor1;
public TalonFX testmotor;
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
public TalonSRX cl_lift;
public TalonSRX cl_moveR;
public TalonSRX cl_moveL;
//public CANSparkMax shooter_motor1;
//public CANSparkMax shooter_motor2;
//public CANPIDController shooterPIDcontroller1;
//public CANPIDController shooterPIDcontroller2;
//public CANEncoder shooter_encoder1;
//public CANEncoder shooter_encoder2;

//public TalonFX drmotor1; //FALCON TEST CODE

public Talon e_boy;

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
public SendableChooser<Integer> ballcount;
//misc
public double temp1;
public double temp2;
public ShuffleboardTab tab;
public NetworkTableEntry maxSpeed;
public NetworkTableEntry LeDtest;
public NetworkTableEntry ballNumber;
public DigitalInput lineSensor;
public DigitalInput lineSensor2;
public AHRS navx;
//public AHRS navx;

//read values periodically
public OI() {
    //2019 robot stuffffffff
    gamepad = new Joystick(Robotmap.gamepad);
    ljoystick = new Joystick(0);
    rjoystick = new Joystick(1);
    rmotor1 = new WPI_TalonSRX(4);  //4
    rmotor2 = new VictorSPX(5); //5
    rmotor3 = new VictorSPX(7); //7
    lmotor1 = new WPI_TalonSRX(2);  //2
    lmotor2 = new VictorSPX(0); //0
    lmotor3 = new VictorSPX(8); //8
    intake_motor = new TalonSRX(1);
    cp_motor = new TalonSRX(3);
    hopper_motor = new TalonSRX(6); 
    outake_motor = new TalonSRX(9);
    cl_moveL = new TalonSRX(11);
    cl_moveR = new TalonSRX(10);
    cl_lift = new TalonSRX(12);
    testmotor = new TalonFX(15);
    //shooter_motor1 = new CANSparkMax(11, MotorType.kBrushless);
    //shooter_motor2 = new CANSparkMax(10, MotorType.kBrushless);
    //shooterPIDcontroller1 = shooter_motor1.getPIDController();
    //shooterPIDcontroller2 = shooter_motor2.getPIDController();
    //drmotor1 = new TalonFX(15); //FALCON TEST CODE
    e_boy = new Talon(9);
    ballcount = new SendableChooser<Integer>();
    ballcount.addOption("1 Ball", 1);
    ballcount.addOption("2 Balls", 2);
    ballcount.setDefaultOption("3 Balls", 3);
    ballcount.addOption("4 Balls", 4);
    ballcount.addOption("5 Balls", 5);
    SmartDashboard.putData("Ball Counter", ballcount);
    /*
    shooterPIDcontroller1.setP(5e-5);
    shooterPIDcontroller1.setI(1e-6);
    shooterPIDcontroller1.setD(0);
    shooterPIDcontroller1.setIZone(0);
    shooterPIDcontroller1.setFF(0);
    shooterPIDcontroller1.setOutputRange(-1, 1);
    */
    /*
    shooterPIDcontroller2.setP(5e-5);
    shooterPIDcontroller2.setI(1e-6);
    shooterPIDcontroller2.setD(0);
    shooterPIDcontroller2.setIZone(0);
    shooterPIDcontroller2.setFF(0);
    shooterPIDcontroller2.setOutputRange(-1, 1);
    */
    //shooter_encoder1 = shooter_motor1.getEncoder();
    //shooter_encoder2 = shooter_motor2.getEncoder();
    rmotor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 30);
    lmotor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 30);

    rmotor2.follow(rmotor1);
    rmotor3.follow(rmotor1);
    lmotor2.follow(lmotor1);
    lmotor3.follow(lmotor1);
    cl_moveL.follow(cl_moveR);

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

    tab = Shuffleboard.getTab("SmartDashboard");
    maxSpeed = tab.add("Max Speed", 1).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min",0,"max",1)).getEntry();
    LeDtest = tab.add("HeavyMetalTest",1).withProperties(Map.of("min",-1,"max",1)).getEntry();

    navx = new AHRS();

    }
}