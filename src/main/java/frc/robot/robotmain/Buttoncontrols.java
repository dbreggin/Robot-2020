package frc.robot.robotmain;
import frc.robot.*;
import frc.robot.commands.*;
import frc.robot.subsystems.Shooter;

public final class Buttoncontrols {
    public static Vision vision;
    public static Shooter shooter;
    public Buttoncontrols() {
        if(Robot.oi.rjoystick.getRawButton(Robot.robotmap.JoyTrigger)){
            vision = new Vision(5,0,.6);
        }
        if(Robot.oi.gamepad.getRawButton(Robot.robotmap.Abutton)){
            shooter = new Shooter();
        }
        
    }
}