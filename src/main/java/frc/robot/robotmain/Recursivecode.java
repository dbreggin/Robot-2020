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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public final class Recursivecode{
    public double shooter_angle;
    public double shooter_height;
    public double Vilocity1;
    public double distance;
    public double k;
    public double v;
    public double Vilocity3;
    public Recursivecode(){
        recursivecode();
    }
    LEDmode ledmode;
    public void recursivecode(){
        /*
        Robot.oi.shooterPIDcontroller1.setP(Robot.oi.P.getDouble(0.0));
        Robot.oi.shooterPIDcontroller1.setI(Robot.oi.I.getDouble(0.0));
        Robot.oi.shooterPIDcontroller1.setD(Robot.oi.D.getDouble(10.0));
        Robot.oi.shooterPIDcontroller1.setIZone(Robot.oi.IZone.getDouble(0.0));
        Robot.oi.shooterPIDcontroller1.setFF(Robot.oi.FF.getDouble(0.0));   
        Robot.oi.shooterPIDcontroller2.setP(Robot.oi.P.getDouble(0.0));
        Robot.oi.shooterPIDcontroller2.setI(Robot.oi.I.getDouble(0.0));
        Robot.oi.shooterPIDcontroller2.setD(Robot.oi.D.getDouble(0.0));
        Robot.oi.shooterPIDcontroller2.setIZone(Robot.oi.IZone.getDouble(0.0));
        Robot.oi.shooterPIDcontroller2.setFF(Robot.oi.FF.getDouble(0.0));   
        */

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
        shooter_height = 1.166;
        shooter_angle = 49;
        v = 11.307;
        if(!Robot.oi.gamepad.getRawButton(1)){
            Robot.globalvariables.distance_to_target = distance;
            Vilocity1 = ((60*(900+v*Robot.globalvariables.distance_to_target))/(8*(Math.PI)));
            Robot.globalvariables.Vilocity1 = Vilocity1 + 20 + Robot.oi.shooterSpeed.getDouble(0.0);
        
        }
           
        
        SmartDashboard.putNumber("Vilocity Calc", Robot.globalvariables.Vilocity1);
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
