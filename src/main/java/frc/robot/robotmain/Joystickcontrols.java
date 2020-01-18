package frc.robot.robotmain;
import frc.robot.Globalvariables;
import frc.robot.OI;
import frc.robot.Robot; 
import frc.robot.Robotmap;
import frc.robot.commands.Vision;


public final class Joystickcontrols {
    public boolean driveType = false;
    public Vision vision;
    public Joystickcontrols(){

    }
    public void Joystickcontrols(){
         if(!Robot.globalvariables.DriveMode){
            if(Robot.oi.rjoystick.getRawButton(Robot.robotmap.JoyBotFT) && !Robot.globalvariables.SwitchFlag){ 
                driveType=!driveType;
                Robot.globalvariables.SwitchFlag = true;
            }
            else{
                Robot.globalvariables.SwitchFlag = false;
            }

            if(!driveType){
                Robot.oi.drive.tankDrive(Robot.oi.ljoystick.getRawAxis(Robot.robotmap.joyY),Robot.oi.rjoystick.getRawAxis(Robot.robotmap.joyY));
             } else {
                Robot.oi.drive.arcadeDrive(Robot.oi.rjoystick.getRawAxis(Robot.robotmap.joyY), Robot.oi.rjoystick.getRawAxis(Robot.robotmap.joyX));
                }
        }
        if (!Robot.globalvariables.VisionFlag && Robot.oi.rjoystick.getRawButton(Robot.robotmap.JoyTrigger)){
            Robot.globalvariables.DriveMode = true;
            Robot.globalvariables.VisionFlag = true;
            vision = new Vision(5, 0, 0.6);
        }else{
            Robot.globalvariables.DriveMode = false;
            Robot.globalvariables.VisionFlag = false;
        }
       

    } 
    

}