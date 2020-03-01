package frc.robot.robotmain;
import org.ejml.equation.Function;

import frc.robot.Globalvariables;
import frc.robot.OI;
import frc.robot.Robot; 
import frc.robot.Robotmap;
import frc.robot.commands.LEDmode;
import frc.robot.commands.Vision;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public final class Recursivecode{
    public double distance;
    public double k;
    public double Vilocity3;
    public Recursivecode(){
        recursivecode();
    }
    LEDmode ledmode;
    public void recursivecode(){
        Robot.oi.table = NetworkTableInstance.getDefault().getTable("limelight");
        Robot.oi.tx = Robot.oi.table.getEntry("tx");
        Robot.oi.ty = Robot.oi.table.getEntry("ty");
        Robot.oi.ta = Robot.oi.table.getEntry("ta");
        Robot.oi.tv = Robot.oi.table.getEntry("tv");
        Robot.oi.lx = Robot.oi.tx.getDouble(0.0);
        Robot.oi.ly = Robot.oi.ty.getDouble(0.0);
        Robot.oi.la = Robot.oi.ta.getDouble(0.0);
        Robot.oi.lv = Robot.oi.tv.getDouble(0.0);
        k = 9*Math.sqrt(2.91);
        distance = k/Math.sqrt(Robot.oi.la); 
        Robot.globalvariables.Vilocity3 = 2545;
        // if(!Robot.globalvariables.target_covered){
        //     Robot.globalvariables.Vilocity3 = ((distance/2)*323.33);
        //     if(distance < 13.5){
        //         Robot.globalvariables.Vilocity3 = (distance/2)*430.40;
        //     }
        //     if(distance > 16){
        //         Robot.globalvariables.Vilocity3 = (distance/2)*280.40;
        //     }
        //     if(Robot.globalvariables.Vilocity3 > 5556){
        //         Robot.globalvariables.Vilocity3 = 5556;
        //     }else if(Robot.globalvariables.Vilocity3 < 2200){
        //         Robot.globalvariables.Vilocity3 = 2200;
        //     }
        //     Robot.globalvariables.Vilocity3 = 2425;
        // }
        // shooter_height = 1.166;
        // shooter_angle = 49;
        // Vilocity1 = Math.sqrt((19.6*(8.1875 - 1.166))/(Math.sin(49.0)));
        // Vilocity2 = Math.sqrt(4.9*(Math.pow((distance),2))/(Math.pow(Math.cos(shooter_angle),2))*(distance*Math.tan(shooter_angle)-8.1875));
       
        //ball counter code
        if(!Robot.oi.lineSensor.get() && !Globalvariables.lineloopflag[0]){
            Globalvariables.lineloopflag[0] = true;
            Globalvariables.ball_counter++;
          }
        if(Globalvariables.lineloopflag[0] && Robot.oi.lineSensor.get()){
            Globalvariables.lineloopflag[0] = false;
        }
        if(!Robot.oi.lineSensor2.get() && !Globalvariables.lineloopflag[1]){
            Globalvariables.lineloopflag[1] = true;
            Robot.oi.Limelight_timer.reset();
            Globalvariables.ball_counter--;
        }
        if(Globalvariables.lineloopflag[1] && Robot.oi.lineSensor2.get()){
            Globalvariables.lineloopflag[1] = false;
        }
        if(Globalvariables.ball_counter <= 0){
            Globalvariables.ball_counter = 0;
        } else if(Globalvariables.ball_counter >=5){
            Globalvariables.ball_counter = 5; 
        }
        if(Globalvariables.turn2angle){
            
        }
         ledmode = new LEDmode();
    }
}
