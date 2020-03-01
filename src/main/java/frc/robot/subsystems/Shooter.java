package frc.robot.subsystems;
import frc.robot.Robot;
import frc.robot.OI;
import frc.robot.Globalvariables;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.ControlType;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTableEntry;

import java.lang.Math;
public final class Shooter{ 
    private double shooter_height;
    private double shooter_angle;
   /// private double distance;
    public double Vilocity1;
    public double Vilocity2;
    public double k;
    public double distance;
    public Shooter() {
        Robot.oi.table = NetworkTableInstance.getDefault().getTable("limelight");
        Robot.oi.tx = Robot.oi.table.getEntry("tx");
        Robot.oi.ty = Robot.oi.table.getEntry("ty");
        Robot.oi.ta = Robot.oi.table.getEntry("ta");
        Robot.oi.tv = Robot.oi.table.getEntry("tv");
        Robot.oi.lx = Robot.oi.tx.getDouble(0.0);
        Robot.oi.ly = Robot.oi.ty.getDouble(0.0);
        Robot.oi.la = Robot.oi.ta.getDouble(0.0);
        Robot.oi.lv = Robot.oi.tv.getDouble(0.0);

        k = 9*Math.sqrt(2.91);
        distance = k/Math.sqrt(Robot.oi.la); 
        shooter_height = 1.166;
        shooter_angle = 49;
        Vilocity1 = Math.sqrt((19.6*(8.1875 - shooter_height))/(Math.sin(shooter_angle)));
        Vilocity2 = Math.sqrt(4.9*(Math.pow((distance),2))/(Math.pow(Math.cos(shooter_angle),2))*(distance*Math.tan(shooter_angle)-8.1875));
       // Vilocity2 = (())
    }   

}

