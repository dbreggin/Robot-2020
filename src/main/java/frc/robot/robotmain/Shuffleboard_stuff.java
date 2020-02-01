package frc.robot.robotmain;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardComponent;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardContainer;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Globalvariables;
import frc.robot.Robot;

public final class Shuffleboard_stuff {
    public Shuffleboard_stuff(){
    Shuffleboard_stuff1();
    if(Robot.oi.lv == 0){
        Robot.globalvariables.Seetarget = false;
    }else {
        Robot.globalvariables.Seetarget = true;
        }
    }
    public void Shuffleboard_stuff1(){
        SmartDashboard.putNumber("sA", Robot.oi.temp1);
        SmartDashboard.putNumber("dA", Robot.oi.temp2);
        SmartDashboard.putNumber("Ball Num", Globalvariables.ball_counter);
        SmartDashboard.putNumber("shooter velocity", Robot.oi.shooter_motor1.getEncoder().getVelocity());
        // SmartDashboard.putNumber("NAVX", Robot.oi.navx.getAngle());
        // SmartDashboard.putNumber("ALITUDE", Robot.oi.navx.getAltitude());
        // SmartDashboard.putNumber("BAR PRESSURE", Robot.oi.navx.getBarometricPressure());


    }
}