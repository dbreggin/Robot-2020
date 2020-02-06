package frc.robot.robotmain;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardComponent;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardContainer;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Globalvariables;
import frc.robot.Robot;
import frc.robot.Robotmap;

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
        SmartDashboard.putBoolean("tA Flag", Globalvariables.angle_turn);
        SmartDashboard.putBoolean("User control", Globalvariables.UserControl);
        SmartDashboard.putBoolean("Check", Globalvariables.check_flag
        );
        


    }
}