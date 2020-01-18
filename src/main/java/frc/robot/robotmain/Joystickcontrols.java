package frc.robot.robotmain;
import frc.robot.Globalvariables;
import frc.robot.OI;
import frc.robot.Robot; 
import frc.robot.Robotmap;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public final class Joystickcontrols {
    public Joystickcontrols(){

    }
    public void Joystickcontrols(){
        if(Robot.oi.rjoystick.getRawButton(Robot.robotmap.JoyBotFT) && !Robot.globalvariables.SwitchFlag){ 
            Robot.oi.drive.arcadeDrive(Robot.oi.rjoystick.getRawAxis(Robot.robotmap.joyY), Robot.oi.rjoystick.getRawAxis(Robot.robotmap.joyX));
            Robot.globalvariables.SwitchFlag = true;
        }
        else{
            Robot.oi.drive.tankDrive(Robot.oi.ljoystick.getRawAxis(Robot.robotmap.joyY),Robot.oi.rjoystick.getRawAxis(Robot.robotmap.joyY));
            Robot.globalvariables.SwitchFlag = false;
        }
       
    }
    

}