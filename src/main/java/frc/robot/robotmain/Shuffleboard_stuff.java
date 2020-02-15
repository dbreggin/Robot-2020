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
    //public Void ballCount(){

   // }
    public void Shuffleboard_stuff1(){
        SmartDashboard.putNumber("sA", Robot.oi.temp1);
        SmartDashboard.putNumber("dA", Robot.oi.temp2);
        SmartDashboard.putNumber("Ball Num", Globalvariables.ball_counter);
        SmartDashboard.putNumber("lencoder", Robot.oi.lmotor1.getSelectedSensorPosition());
        SmartDashboard.putNumber("rencoder", Robot.oi.rmotor1.getSelectedSensorPosition());
        SmartDashboard.putNumber("Max Speed", getMaxSpeed());
        // SmartDashboard.putBoolean("Automode 1",Globalvariables.automode_1flag);
        // SmartDashboard.putBoolean("Automode 2",Globalvariables.automode_2flag);
        // SmartDashboard.putBoolean("Automode 3",Globalvariables.automode_3flag);
        // SmartDashboard.putBoolean("Automode 4",Globalvariables.automode_4flag);
        // SmartDashboard.putNumber("AUTOMODE", Globalvariables.automode);
      //  Robot.oi.ballcount.addOption("name", ballCount());
       }
    public double getMaxSpeed(){
        return Robot.oi.maxSpeed.getDouble(1.0);
    }
    public double getballNumber(){
        return Robot.oi.ballNumber.getDouble(1.0);
    }
}