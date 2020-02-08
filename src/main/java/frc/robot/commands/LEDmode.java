package frc.robot.commands;
import frc.robot.*;

public final class LEDmode {
    public LEDmode(){
        switch(Globalvariables.LEDmode){
            case 0://Aqua
            Robot.oi.e_boy.set(.73);
            break;
            case 1://Limegreen
            Robot.oi.e_boy.set(.73+Globalvariables.LEDoffset);
            break;
            case 2://Dark red
            Robot.oi.e_boy.set(.59-.04);
            break;
            case 3://Red
            Robot.oi.e_boy.set(.61+Globalvariables.LEDoffset);
            break;
            case 4://Hot Pink
            Robot.oi.e_boy.set(.57-.04);
            break;
            case 5://Red Orange
            Robot.oi.e_boy.set(.63+Globalvariables.LEDoffset);
            break;
            case 6://Orange
            Robot.oi.e_boy.set(.65+Globalvariables.LEDoffset);
            break;
            case 7://Gold
            Robot.oi.e_boy.set(.67+Globalvariables.LEDoffset);
            break;
            case 8://Yellow
            Robot.oi.e_boy.set(.69+Globalvariables.LEDoffset);
            break;
            case 9://Lawn Green
            Robot.oi.e_boy.set(.71+Globalvariables.LEDoffset);
            break;
            case 10://Dark Green
            Robot.oi.e_boy.set(.75+Globalvariables.LEDoffset);
            break;
            case 11://Green
            Robot.oi.e_boy.set(.77+Globalvariables.LEDoffset);
            break;
            case 12://Blue Green
            Robot.oi.e_boy.set(.79-.04);
            break;
            case 13://Sky Blue
            Robot.oi.e_boy.set(.83+Globalvariables.LEDoffset);
            break;
            case 14://Dark Blue
            Robot.oi.e_boy.set(.85+Globalvariables.LEDoffset);
            break;
            case 15://Blue
            Robot.oi.e_boy.set(.87+Globalvariables.LEDoffset);
            break;
            case 16://Purple
            Robot.oi.e_boy.set(.89+Globalvariables.LEDoffset);
            break;
            case 17://Violet
            Robot.oi.e_boy.set(.91+Globalvariables.LEDoffset);
            break;
            case 18://White
            Robot.oi.e_boy.set(.93+Globalvariables.LEDoffset);
            break;
            case 19://Gray
            Robot.oi.e_boy.set(.95+Globalvariables.LEDoffset);
            break;
            case 20://Dark Gray
            Robot.oi.e_boy.set(.97+Globalvariables.LEDoffset);
            break;
            case 21://Black
            Robot.oi.e_boy.set(.99+Globalvariables.LEDoffset);
            break;
        }

    }

}