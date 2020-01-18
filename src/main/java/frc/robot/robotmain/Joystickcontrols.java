package frc.robot.robotmain;
import frc.robot.Globalvariables;
import frc.robot.OI;
import frc.robot.Robot; 
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public final class Joystickcontrols {
    public Joystickcontrols(){

    }
    public void Joystickcontrols(){
        Robot.oi.drive.tankDrive(Robot.oi.ljoystick.getRawAxis(Robot.robotmap.joyY),Robot.oi.rjoystick.getRawAxis(Robot.robotmap.joyY));
    }
    

}