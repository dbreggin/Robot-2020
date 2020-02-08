package frc.robot.robotmain;
import frc.robot.*;
import frc.robot.commands.*;
import frc.robot.subsystems.Shooter;

public final class Buttoncontrols {
    public static Vision vision;
    public static AngleCall angleCall;
    public Shooter shooter;
    public Buttoncontrols() {
        if(Robot.oi.gamepad.getRawButton(Robotmap.Abutton)){
            shooter = new Shooter();
        }
        if(Robot.oi.ljoystick.getRawButton(Robotmap.JoyTrigger)){
            vision = new Vision(1.28,0,1); //1.28=15feet 
        } else if(Globalvariables.Shootflag){
            shooter = new Shooter();
        }
    }     
}