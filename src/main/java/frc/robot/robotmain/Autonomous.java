package frc.robot.robotmain;
import frc.robot.commands.Drivestraight;
import frc.robot.Robot;
import frc.robot.commands.Identifyballs;
import frc.robot.commands.VisionRange;
import frc.robot.Globalvariables;



//import frc.robot.commands.Angleturn;


public final class Autonomous {
    double sA; 
    public VisionRange visionFunction;
  public Autonomous(){

    sA = Robot.oi.navx.getAngle()*.09;
    if(Robot.oi.navx.getAngle()<1.75 && Robot.oi.navx.getAngle()>-1.75){
        sA*=4.20;
        Globalvariables.LEDmode=10;
    } else {
        Globalvariables.LEDmode=2;
    }

    if(sA>1){
        sA = 1;
    } else if (sA<-1){
        sA = -1;
    }
    // sA*=-1;
    //2430 = 5 feet
    
    if(Robot.oi.rmotor1.getSelectedSensorPosition() < 2430*6){
        Robot.oi.drive.arcadeDrive(.6, sA);
    }else{
        visionFunction = new VisionRange(0.75, 0.4,0,1);
    }
  }
}