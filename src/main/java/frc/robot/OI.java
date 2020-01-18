package frc.robot;
import edu.wpi.first.wpilibj.Joystick; 
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

//limelight
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public final class OI {
//Motors 
private TalonSRX motor1;
private TalonSRX motor2;
private TalonSRX motor3;
private TalonSRX motor4;
private TalonSRX motor5;
private TalonSRX motor6;
//limelight
public  NetworkTable  table;
public NetworkTableEntry tx;
public NetworkTableEntry ty;
public NetworkTableEntry ta;
public NetworkTableEntry tv;




}