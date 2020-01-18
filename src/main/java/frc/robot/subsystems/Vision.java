package frc.robot.subsystems;
import frc.robot.*; 

public final class Vision {
    public Vision(double distance, int pipeline, double area, double scaler) {
        double dA;
        double sA; 
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
            dA *= scaler;
            sA = Robot.oi.lx / 20;
            sA *= scaler;
            Robot.oi.drive.arcadeDrive(dA,sA);
        } else{
            Robot.oi.drive.tankDrive(0,0);
        }
    }
}

