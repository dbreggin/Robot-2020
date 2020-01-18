package frc.robot.robotmain;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardComponent;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardContainer;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Robot;

public final class Shuffleboard_stuff {
    public Shuffleboard_stuff(){
    if(Robot.oi.limelightTarget == 0){
        Robot.globalvariables.Seetarget = false;
    }else if (Robot.oi.limelightTarget == 1){
        Robot.globalvariables.Seetarget = true;
    }

    }
    public void Shuffleboard_stuff(){
        SmartDashboard.getNumber("Joystick Axises", Robot.oi.ljoystick.getRawAxis(Robot.robotmap.joyY));
        SmartDashboard.getBoolean("See Target", Robot.globalvariables.Seetarget);
    }
}