package frc.robot.robotmain;
import frc.robot.Globalvariables;
import frc.robot.OI;
import frc.robot.Robot; 
import frc.robot.Robotmap;

public final class Joystickcontrols {
    public boolean driveType = false;
    public Joystickcontrols(){

    }
    public void Joystickcontrols(){
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
    

}