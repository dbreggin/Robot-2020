package frc.robot.subsystems;
import frc.robot.Robot;
import frc.robot.Robotmap;
import frc.robot.OI;
import frc.robot.Globalvariables;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.ControlType;
public final class Shooter{ 
    public Shooter() {
    if(Globalvariables.ball_counter>0 && Globalvariables.ball_counter<6){
        Robot.oi.outake_motor.set(ControlMode.PercentOutput, (1));
        Robot.oi.intake_motor.set(ControlMode.PercentOutput, (1));
        Robot.oi.shooterPIDcontroller1.setReference(5700, ControlType.kVelocity);
        // Robot.oi.shooterPIDcontroller2.setReference(5700, ControlType.kVelocity);
    } else{
        Robot.oi.outake_motor.set(ControlMode.PercentOutput, (0));
        Robot.oi.intake_motor.set(ControlMode.PercentOutput, (0));
        Robot.oi.shooterPIDcontroller1.setReference(0, ControlType.kVelocity);
        // Robot.oi.shooterPIDcontroller2.setReference(0, ControlType.kVelocity);
    }
    }
}

  