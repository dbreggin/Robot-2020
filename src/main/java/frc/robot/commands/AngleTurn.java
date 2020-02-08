package frc.robot.commands;
import frc.robot.robotmain.Joystickcontrols;
import frc.robot.Globalvariables;
import frc.robot.robotmain.Buttoncontrols;
import frc.robot.Robot;

public final class AngleTurn {
    public AngleTurn(double angle, double speed){
        Globalvariables.UserControl = false;
        Globalvariables.turn1angle = Robot.oi.navx.getAngle()+angle;
        Globalvariables.speed = speed;
        Globalvariables.turn2angle = true;
    }
}