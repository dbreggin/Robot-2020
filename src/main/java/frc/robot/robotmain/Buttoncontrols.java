package frc.robot.robotmain;
import frc.robot.*;
import frc.robot.commands.*;

public final class Buttoncontrols {
    public static Vision vision;
    public static AngleCall angleCall;
    public Buttoncontrols() {
        if(Robot.oi.rjoystick.getRawButton(Robotmap.JoyTrigger)){
            vision = new Vision(5,0,.6);
        }
    }
}