package frc.robot.robotmain;
import org.ejml.equation.Function;

import frc.robot.Globalvariables;
import frc.robot.OI;
import frc.robot.Robot; 
import frc.robot.Robotmap;
<<<<<<< HEAD
import frc.robot.commands.AngleAdjust;
import frc.robot.commands.Vision;;
=======
import frc.robot.commands.LEDmode;
import frc.robot.commands.Vision;
>>>>>>> c68eea07b7f2624606c931efb04ed74e36044489


public final class Recursivecode{
    public AngleAdjust angleadjust;
    public Recursivecode(){
        recursivecode();
    }
    LEDmode ledmode;
    public void recursivecode(){
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
<<<<<<< HEAD
        if(Globalvariables.angle_turn){
            Globalvariables.UserControl = false;
            angleadjust = new AngleAdjust();
        }else{
            Globalvariables.UserControl = true;
        }
=======
        ledmode = new LEDmode();
>>>>>>> c68eea07b7f2624606c931efb04ed74e36044489
    }
}
