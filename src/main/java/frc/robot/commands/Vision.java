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
            dA=(Robot.oi.la-distance)*1.05;
            dA *= -1;
            sA = Robot.oi.lx / 20;
            if(dA>1){  
                dA = 1;
            } else if (dA<-1){
                dA = -1;
            } else if (dA<.5 && dA>.1){
                dA=.5; 
            } else if (dA>-.5 && dA<-.06){
                dA=-.5;
            } else if (dA>-.1 && dA<.1){
                dA=0;
                sA*=1.25;
            }
            if(sA>1){
                sA = 1;
            } else if (sA<-1){
                sA = -1;
            } else if (sA<.5 && sA>.016){
                sA=.5;
            } else if (sA<-.5 && sA>-.016){
                sA=-.5;
            } else if (sA>-.035 && sA<.035){
                sA=0;

            }
            if(dA>-.3 && dA<.3 && sA>-.1 && sA<.1){
                // Globalvariables.Shootflag = true;
                Globalvariables.LEDmode = 1;
            } else{
                // Globalvariables.Shootflag = false;
                Globalvariables.LEDmode = 6;
            }
            sA*=-1;
            


            Robot.oi.temp1 = sA;
            Robot.oi.temp2 = dA;
            Robot.oi.drive.arcadeDrive(dA,sA);
        } else{
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

