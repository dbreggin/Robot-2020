package frc.robot.robotmain;
import frc.robot.*;
import frc.robot.commands.*;

public final class Buttoncontrols {
    public static Vision vision;
    public static AngleCall angleCall;
    public Buttoncontrols() {
<<<<<<< HEAD
        if(Robot.oi.rjoystick.getRawButton(Robotmap.JoyTrigger)){
            vision = new Vision(5,0,.6);
=======
        if(Robot.oi.gamepad.getRawButton(Robotmap.Abutton)){
            shooter = new Shooter();
        }
        if(Robot.oi.ljoystick.getRawButton(Robotmap.JoyTrigger)){
            vision = new Vision(1.28,0,1);
        } else if(Globalvariables.Shootflag){
            shooter = new Shooter();
>>>>>>> c68eea07b7f2624606c931efb04ed74e36044489
        }
        if(Robot.oi.rjoystick.getRawButton(Robotmap.JoyBotBB)){
            angleCall = new AngleCall(90, 0);
        } else {
            Globalvariables.tA_flag = false;
        }
    }
}