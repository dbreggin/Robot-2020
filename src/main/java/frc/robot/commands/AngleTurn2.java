package frc.robot.commands;
import frc.robot.robotmain.Joystickcontrols;
import frc.robot.Globalvariables;
import frc.robot.robotmain.Buttoncontrols;
import frc.robot.Robot;

public final class AngleTurn2 {
    double sA;
    public AngleTurn2(){
        sA=Globalvariables.turn1angle-Robot.oi.navx.getAngle();
        sA*=-.015;
        if(sA>1){
            sA = 1;
        } else if (sA<-1){
            sA = -1;
        }
        Robot.oi.drive.arcadeDrive(Globalvariables.speed, sA);
        if(Globalvariables.turn1angle-Robot.oi.navx.getAngle()<2 && Globalvariables.turn1angle-Robot.oi.navx.getAngle()>-1){
            Globalvariables.turn2angle = false;
        }
    }
}