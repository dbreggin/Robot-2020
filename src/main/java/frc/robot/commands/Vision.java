package frc.robot.commands;
import frc.robot.*;
import edu.wpi.first.networktables.NetworkTableInstance;

public final class Vision {
    double dA;
    double sA; 
    public Vision(double distance, int pipeline, double scaler) {
        Robot.oi.table = NetworkTableInstance.getDefault().getTable("limelight");
        Robot.oi.tx = Robot.oi.table.getEntry("tx");
        Robot.oi.ty = Robot.oi.table.getEntry("ty");
        Robot.oi.ta = Robot.oi.table.getEntry("ta");
        Robot.oi.tv = Robot.oi.table.getEntry("tv");
        Robot.oi.lx = Robot.oi.tx.getDouble(0.0);
        Robot.oi.ly = Robot.oi.ty.getDouble(0.0);
        Robot.oi.la = Robot.oi.ta.getDouble(0.0);
        Robot.oi.lv = Robot.oi.tv.getDouble(0.0);
        if(Robot.oi.lv != 0.0){
            if((Robot.oi.la-distance)*.2 < distance){
                dA = (Robot.oi.la-distance)*.2;
            } else if((distance-Robot.oi.la)*-.2 > distance){
                dA = (distance-Robot.oi.la)*-.2;
            } else {
                dA = 1;
            }
            dA *= -scaler;
            sA = Robot.oi.lx / 20;
            sA *= -scaler;
            if(dA>1){
                dA = 1;
            } else if (dA<-1){
                dA = -1;
            }
            if(sA>1){
                sA = 1;
            } else if (sA<-1){
                sA = -1;
            }
            dA *= -scaler;
            sA *= -scaler;
            Robot.oi.temp1 = sA;
            Robot.oi.temp2 = dA;
            Robot.oi.drive.arcadeDrive(dA,sA);
        } else{
            Robot.oi.drive.tankDrive(0,0);
        }
    }
}

