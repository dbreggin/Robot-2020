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
NetworkTableEntry tx = table.getEntry("tx");
NetworkTableEntry ty = table.getEntry("ty");
NetworkTableEntry ta = table.getEntry("ta");
//read values periodically
double xoffset = tx.getDouble(0.0);
double yoffset = ty.getDouble(0.0);
double limelightarea = ta.getDouble(0.0);
}