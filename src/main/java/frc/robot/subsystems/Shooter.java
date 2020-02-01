package frc.robot.subsystems;
import frc.robot.Robot;
import frc.robot.Robotmap;
import frc.robot.OI;
import frc.robot.Globalvariables;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.ControlType;
public final class Shooter{ 
    public Shooter() {
    if(Robot.globalvariables.ball_counter>0 && Robot.globalvariables.ball_counter<6){
        Robot.oi.outake_motor.set(ControlMode.PercentOutput, (1));
        Robot.oi.intake_motor.set(ControlMode.PercentOutput, (1));
        //Robot.oi.shooter_motor.set(ControlMode.PercentOutput, (1));
        //Robot.oi.shooter_motor2.set(ControlMode.PercentOutput, (1));
        } 
    }
}

  