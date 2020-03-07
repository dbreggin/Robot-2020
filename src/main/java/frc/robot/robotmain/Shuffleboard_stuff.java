package frc.robot.robotmain;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardComponent;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardContainer;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Globalvariables;
import frc.robot.Robot;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import java.util.Map;
import frc.robot.subsystems.Shooter;

public final class Shuffleboard_stuff {
    public Shuffleboard_stuff(){
    Shuffleboard_stuff1();
    if(Robot.oi.lv == 0){
        Globalvariables.Seetarget = false;
    }else {
        Globalvariables.Seetarget = true;
        }
    }
    public void Shuffleboard_stuff1(){
        SmartDashboard.putBoolean("RPM GOOD", Robot.globalvariables.RPM_good);
        SmartDashboard.putNumber("sA", Robot.oi.temp1);
        SmartDashboard.putNumber("dA", Robot.oi.temp2);
        SmartDashboard.putNumber("Ball Num", Globalvariables.ball_counter);
    //    SmartDashboard.putNumber("lencoder", Robot.oi.lmotor1.getSelectedSensorPosition());
      //  SmartDashboard.putNumber("rencoder", Robot.oi.rmotor1.getSelectedSensorPosition());
        SmartDashboard.putNumber("Max Speed", getMaxSpeed());
        SmartDashboard.putNumber("Intake Revolver", getrevolverintakeSpeed());
        SmartDashboard.putNumber("SPEEED RPM", getshooterSpeed());
        SmartDashboard.putNumber("key", getautomodeNumber());
        ///SmartDashboard.putNumber("Distance back", getEncoderDistance());
        //SmartDashboard.putNumber("Servo ANGLLEEE", Robot.oi.swivle.getAngle());
        SmartDashboard.putNumber("Gyro X",Robot.oi.navx.getYaw());
        SmartDashboard.putNumber("Gyro Y",Robot.oi.navx.getPitch());
        SmartDashboard.putNumber("Gyro Z",Robot.oi.navx.getRawGyroZ());
        SmartDashboard.putNumber("Gyro ROLLLL",Robot.oi.navx.getRoll());
        SmartDashboard.putBoolean("User Control", Globalvariables.UserControl);
        SmartDashboard.putNumber("SHOOOTER REALPLEAM ARJUN GOD MODE", Robot.oi.shooter_encoder1.getVelocity());
        SmartDashboard.putNumber("TIMER", Robot.oi.shotclock_timer.get());
        SmartDashboard.putNumber("FALCONencoder", Robot.oi.motor1.getSelectedSensorPosition(0));
        SmartDashboard.putNumber("FALCONencoder2", Robot.oi.motor3.getSelectedSensorPosition(0));
        //SmartDashboard.putNumber("swivlepos", Robot.oi.swivle.getAngle());
        //SmartDashboard.putNumber("swivlepos", Robot.oi.swivle.get());
        SmartDashboard.putNumber("distance", Robot.recursivecode.distance);
        SmartDashboard.putNumber("Vilocity3", Robot.globalvariables.Vilocity3);
        SmartDashboard.putBoolean("Chedck flag", Globalvariables.check_flag);
        SmartDashboard.putNumber("Delay timer", Robot.oi.revolver_timer_delay.get());

    }
    // public double getEncoderDistance(){
    //     return Robot.oi.distance_back.getSelected();
    // }
    public double getMaxSpeed(){
        return Robot.oi.maxSpeed.getDouble(1.0);
    }
    public double getrevolverintakeSpeed(){
        return Robot.oi.revolverintakeSpeed.getDouble(3000.0);
    }
    public double getshooterSpeed(){
        return Robot.oi.shooterSpeed.getDouble(3000.0);
    }
    public int getballNumber(){
        return Robot.oi.ballcount.getSelected();
    }
    public int getautomodeNumber(){
        return Robot.oi.automode.getSelected();
    }
}