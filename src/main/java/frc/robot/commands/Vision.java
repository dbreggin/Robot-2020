package frc.robot.commands;
import frc.robot.*;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.ControlMode;

public final class Vision {
    double dA;
    double sA; 
    public Vision(double distance,  int pipeline, double scaler,float offset) {
        Robot.oi.table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(pipeline);
        Robot.oi.tx = Robot.oi.table.getEntry("tx");
        Robot.oi.ty = Robot.oi.table.getEntry("ty");
        Robot.oi.ta = Robot.oi.table.getEntry("ta");
        Robot.oi.tv = Robot.oi.table.getEntry("tv");
        Robot.oi.lx = Robot.oi.tx.getDouble(0.0);
        Robot.oi.ly = Robot.oi.ty.getDouble(0.0);
        Robot.oi.la = Robot.oi.ta.getDouble(0.0);
        Robot.oi.lv = Robot.oi.tv.getDouble(0.0);
        
        if(Robot.oi.lv != 0.0){
            dA=(Robot.oi.la-distance)*1.05;
            //sA = (Robot.oi.lx - offset) / 24;
        
            if(dA>-.1 && dA<.1 && sA>-.05 && sA<.05){
                // Globalvariables.Shootflag = true;
                Globalvariables.LEDmode = 10;
            } else{
                // Globalvariables.Shootflag = false;
                Globalvariables.LEDmode = 6;
            }
            //sA*=-1.5;
            if(Robot.oi.lx < -4 ){
                Robot.globalvariables.shooter_lineup = false;
                sA = .3;
            }else if(Robot.oi.lx > 4){
                Robot.globalvariables.shooter_lineup = false;
                sA = -.3;
            }else if(Robot.oi.lx < -.5 && Robot.oi.lx > -4){
                Robot.globalvariables.shooter_lineup = false;
                sA = .29;
            }else if(Robot.oi.lx > .5 && Robot.oi.lx < 4){
                Robot.globalvariables.shooter_lineup = false;
                sA = -.29;
            }else if(Robot.oi.lx < .5 && Robot.oi.lx > -.5 ){
                Robot.globalvariables.shooter_lineup = true;
                sA = 0;
            }
            Robot.oi.drive.tankDrive(0,0);

            Robot.oi.motor1.set(ControlMode.Velocity,3);
            Robot.oi.motor3.set(ControlMode.Velocity,-3);
            




            // if(dA < .3 && sA <.3 && sA > -.3 && dA > -.3){
            //     Robot.globalvariables.shooter_lineup = true;
                
            // }else{
            //     Robot.globalvariables.shooter_lineup = false;
            // }
            // if(Robot.oi.lx > 10){
            //     sA=-.4;
            // }else if(Robot.oi.lx < -10){
            //     sA=.4;
            // }else if(Robot.oi.lx < 4 && Robot.oi.lx > -4 ){
            //     sA = .2;
        
            // }else if(Robot.oi.lx < 3 && Robot.oi.lx > -3 ){
            //     sA = .2;
            // }else if(Robot.oi.lx < 1 && Robot.oi.lx > -1 ){
            //     sA = 0;
            // }else if((Robot.oi.lx < 7 && Robot.oi.lx > 5 )||(Robot.oi.lx > -7 && Robot.oi.lx < -5)){
            //     sA*= 1.2;
            // }else if((Robot.oi.lx > 5 && Robot.oi.lx < 4 )||(Robot.oi.lx > -5 && Robot.oi.lx < -7)){
            //     sA = .3;
            // }

            if(sA > .5){
                sA = .5;
            }else if (sA < -.5){
                sA = -.5;
            }
            dA*= -1.5;
            dA*=scaler;
            
            if(Robot.oi.Limelight_timer.get() < .5){
                dA = 0;
            }
            Robot.oi.drive.arcadeDrive(dA,sA);
            SmartDashboard.putNumber("sAAAA", sA);
        }else{
            Robot.oi.drive.tankDrive(0,0);
            Globalvariables.LEDmode = 2;
        }
    }

    // private void steerAdjust(double sA, double dA)
    // {
    //     if(dA>=0.1||dA<=-0.1)
    //     {
    //         return; 
    //     }
    //     else{
    //         double sA2=Robot.oi.lx/5.0;
    //         if(sA2>=0.5)
    //         {
    //             sA2=0.5;
    //         }
    //         else{
    //             sA2=-0.5;
    //         }
    //         Robot.oi.drive.arcadeDrive(0, sA2);
    //     }
    // }
}

