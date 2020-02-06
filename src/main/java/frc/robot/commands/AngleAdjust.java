package frc.robot.commands;
import frc.robot.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public final class AngleAdjust{
    private double steering;
    public AngleAdjust(){
       // steering = ((Robot.oi.navx.getAngle() + Globalvariables.tA)* .1);
        if(steering > 1){
            steering = 1;
        }
        if(steering < -1){
            steering = -1;
        }
        Robot.oi.drive.arcadeDrive(Globalvariables.speed, steering);
       // SmartDashboard.putNumber("steering", Robot.oi.navx.getAngle());
    }
}
