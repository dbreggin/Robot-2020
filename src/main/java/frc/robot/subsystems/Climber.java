package frc.robot.subsystems;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.Robotmap;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Globalvariables;
import com.ctre.phoenix.motorcontrol.ControlMode;

public final class Climber {
    public Climber(){
        if(Robot.oi.gamepad.getRawButton(Robotmap.Xbutton)){
            Robot.oi.cL_timer.start();
            Robot.oi.cl_upL.set(ControlMode.PercentOutput, .5);
        } else if(Robot.oi.cL_timer.get() > 1){
            Robot.oi.cl_upL.set(ControlMode.PercentOutput, 0);
        } 
        
    }
}

