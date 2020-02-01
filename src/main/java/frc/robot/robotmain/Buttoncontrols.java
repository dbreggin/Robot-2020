package frc.robot.robotmain;
import frc.robot.*;
import frc.robot.commands.*;
import frc.robot.subsystems.Shooter;
import com.revrobotics.ControlType;

public final class Buttoncontrols {
    public static Vision vision;
    public static Shooter shooter;
    public Buttoncontrols() {
        if(Robot.oi.ljoystick.getRawButton(Robotmap.JoyTrigger)){
            vision = new Vision(1.28,0,1);
        }
        if(Robot.oi.gamepad.getRawButton(Robotmap.Abutton)){
            shooter = new Shooter();
        }
        if(Robot.oi.rjoystick.getRawButton(Robotmap.JoyTrigger)){
            vision = new Vision(1.28,0,1);
        } else if(Globalvariables.Shootflag){
            shooter = new Shooter();
        }
        if(Robot.oi.gamepad.getRawButton(Robotmap.Ybutton)){
            Robot.oi.shooterPIDcontroller1.setReference(5700, ControlType.kVelocity);
        } else {
            Robot.oi.shooterPIDcontroller1.setReference(0, ControlType.kVelocity);
        }
    }
}