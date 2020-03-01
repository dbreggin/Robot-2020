package frc.robot.robotmain;
import frc.robot.*;
import frc.robot.commands.*;
import frc.robot.subsystems.Shooter;
import com.ctre.phoenix.motorcontrol.ControlMode;

public final class Buttoncontrols {
    public static Vision vision;
    public static AngleCall angleCall;
    public Shooter shooter;
    public Buttoncontrols() {
        if(Robot.oi.gamepad.getRawButton(6)){
            Robot.oi.swivle.setAngle(175);
        }
        if(Robot.oi.gamepad.getRawButton(5)){
            Robot.oi.swivle.setAngle(5);
        }
        if(Robot.oi.gamepad.getRawButton(Robotmap.Xbutton)){
            Robot.oi.motor1.setSelectedSensorPosition(0, 0, 30);
            Robot.oi.motor3.setSelectedSensorPosition(0, 0, 30);
        }



        
        // if(Robot.oi.gamepad.getRawButton(Robotmap.Abutton)){
        //     shooter = new Shooter();
        // }
        // if(Robot.oi.ljoystick.getRawButton(Robotmap.JoyTrigger)){
        //     vision = new Vision(1.28,0,1); //1.28=15feet 
        // } else if(Globalvariables.Shootflag){
        //     shooter = new Shooter();
        // }
        // if(Robot.oi.gamepad.getRawButton(Robotmap.Abutton)){
        //     Robot.oi.testmotor.set(ControlMode.PercentOutput, (1));
        // } else if(Robot.oi.gamepad.getRawButton(Robotmap.Bbutton)){
        //     Robot.oi.testmotor.set(ControlMode.PercentOutput, (-1));
        // }
    }     
}