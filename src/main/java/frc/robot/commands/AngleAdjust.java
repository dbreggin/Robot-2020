package frc.robot.commands;
import frc.robot.*;

public final class AngleAdjust{
    private double steering = ((Robot.oi.navx.getAngle() - Globalvariables.tA)* .01);
    public void angleAdjust(){
        if(Globalvariables.speed > 1){
            steering = 1;
        }
        if(Globalvariables.speed < -1){
            steering = -1;
        }
        Robot.oi.drive.arcadeDrive(Globalvariables.speed, steering);
        Globalvariables.angle = false;
        Globalvariables.check_flag = true;
    }
}
