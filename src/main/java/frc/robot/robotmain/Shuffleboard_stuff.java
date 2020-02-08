package frc.robot.robotmain;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardComponent;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardContainer;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Globalvariables;
import frc.robot.Robot;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import java.util.Map;

public final class Shuffleboard_stuff {
    public Shuffleboard_stuff(){
    Shuffleboard_stuff1();
    if(Robot.oi.lv == 0){
        Globalvariables.Seetarget = false;
    }else {
        Globalvariables.Seetarget = true;
        }
    }
    public void Shuffleboard_stuff1(){
        SmartDashboard.putNumber("sA", Robot.oi.temp1);
        SmartDashboard.putNumber("dA", Robot.oi.temp2);
        SmartDashboard.putNumber("Ball Num", Globalvariables.ball_counter);
        // SmartDashboard.putNumber("NAVX", Robot.oi.navx.getAngle());
        // SmartDashboard.putNumber("ALITUDE", Robot.oi.navx.getAltitude());
        // SmartDashboard.putNumber("BAR PRESSURE", Robot.oi.navx.getBarometricPressure());
        SmartDashboard.putNumber("lencoder", Robot.oi.lmotor1.getSelectedSensorPosition());
        SmartDashboard.putNumber("rencoder", Robot.oi.rmotor1.getSelectedSensorPosition());
        SmartDashboard.putNumber("sliderTest", getMaxSpeed());
    }
    public double getMaxSpeed(){
        return Robot.oi.maxSpeed.getDouble(1.0);
    }
}