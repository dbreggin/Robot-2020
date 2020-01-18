package frc.robot.robotmain;
import frc.robot.*;
import frc.robot.commands.*;

public final class Buttoncontrols {
    public static Vision vision;
    public Buttoncontrols() {
        if(Robot.oi.rjoystick.getRawButton(Robot.robotmap.JoyTrigger)){
            vision = new Vision(5,0,.6);
        }
    }
}