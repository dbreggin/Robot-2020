package frc.robot.robotmain;
import frc.robot.*;
import frc.robot.commands.*;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Shooter;
import com.ctre.phoenix.motorcontrol.ControlMode;

public final class Buttoncontrols {
    public static Vision vision;
    public static AngleCall angleCall;
    public Shooter shooter;
    public Buttoncontrols() {

        //if(Robot.oi.gamepad.getRawButton(6)){
          //  Robot.oi.swivle.setAngle(175);
        //}

        // if(R obot.oi.gamepad.getRawButton(5)){
        //     Robot.oi.swivle.setAngle(5);
        // }
        if(Robot.oi.gamepad.getRawAxis(2)>0){
            Robot.oi.cl_upL.set(ControlMode.PercentOutput,(-(Robot.oi.gamepad.getRawAxis(2)*.65)+ -.45));
        }else if((Robot.oi.gamepad.getRawAxis(2)==0) && !Robot.oi.ljoystick.getRawButton(12) && !Robot.oi.rjoystick.getRawButton(12)){
            Robot.oi.cl_upL.set(ControlMode.PercentOutput,0);
        }
        if(Robot.oi.gamepad.getRawAxis(3) > 0){
            Robot.oi.cl_upR.set(ControlMode.PercentOutput,((Robot.oi.gamepad.getRawAxis(3)*.65))+.45);
        }else if((Robot.oi.gamepad.getRawAxis(3)==0) && !Robot.oi.ljoystick.getRawButton(12) && !Robot.oi.rjoystick.getRawButton(12)){
            Robot.oi.cl_upR.set(ControlMode.PercentOutput,0);
        }
        // if(Robot.oi.gamepad.getRawButton(5) &&!Robot.oi.rjoystick.getRawButton(12) && !Robot.oi.ljoystick.getRawButton(12)){
        //     Robot.oi.cl_upL.set(ControlMode.PercentOutput, -.65);
        // }else if(!Robot.oi.gamepad.getRawButton(5) &&!Robot.oi.rjoystick.getRawButton(12) && !Robot.oi.ljoystick.getRawButton(12)){
        //     Robot.oi.cl_upL.set(ControlMode.PercentOutput, 0);
        // }
        // if(Robot.oi.gamepad.getRawButton(6) && !Robot.oi.rjoystick.getRawButton(12) && !Robot.oi.ljoystick.getRawButton(12)){
        //     Robot.oi.cl_upR.set(ControlMode.PercentOutput, .65);
        // }else if(!Robot.oi.gamepad.getRawButton(6) && !Robot.oi.rjoystick.getRawButton(12) && !Robot.oi.ljoystick.getRawButton(12)){
        //     Robot.oi.cl_upR.set(ControlMode.PercentOutput, 0);
        // }  
        
        if(Robot.oi.ljoystick.getRawButton(12) && (Robot.oi.gamepad.getRawAxis(3)==0) &&(Robot.oi.gamepad.getRawAxis(2)==0)){
            Robot.oi.cl_upL.set(ControlMode.PercentOutput, .10);
        }else if(!Robot.oi.ljoystick.getRawButton(12) && (Robot.oi.gamepad.getRawAxis(3)==0) &&(Robot.oi.gamepad.getRawAxis(2)==0)){
            Robot.oi.cl_upL.set(ControlMode.PercentOutput, 0);
        }
        if(Robot.oi.rjoystick.getRawButton(12) && (Robot.oi.gamepad.getRawAxis(3)==0) &&(Robot.oi.gamepad.getRawAxis(2)==0)){
            Robot.oi.cl_upR.set(ControlMode.PercentOutput, -.10);
        }else if(!Robot.oi.rjoystick.getRawButton(12) && (Robot.oi.gamepad.getRawAxis(3)==0) &&(Robot.oi.gamepad.getRawAxis(2)==0)){
            Robot.oi.cl_upR.set(ControlMode.PercentOutput, 0);
        }
        if(Robot.oi.gamepad.getRawButton(Robotmap.Start) && !Robot.globalvariables.Ball_up){
            Robot.globalvariables.Ball_up = true;
            Globalvariables.ball_counter--;
        }
        else if(!Robot.oi.gamepad.getRawButton(Robotmap.Start) && Robot.globalvariables.Ball_up){
            Robot.globalvariables.Ball_up = false;
        }
        if(Robot.oi.gamepad.getRawButton(Robotmap.Select) && !Robot.globalvariables.Ball_down){
            Robot.globalvariables.Ball_down = true;
            Globalvariables.ball_counter++;
        } else if(!Robot.oi.gamepad.getRawButton(Robotmap.Select)){
            Robot.globalvariables.Ball_down = false;
        }
        // if(Robot.oi.gamepad.getRawButton(Robotmap.Lbumper)){
        //     Robot.oi.cl_move.set(ControlMode.PercentOutput, -.5);
        // } else if(Robot.oi.gamepad.getRawButton(Robotmap.Rbumper)){
        //     Robot.oi.cl_move.set(ControlMode.PercentOutput, .5);
        // }
            // if(Robot.oi.gamepad.getRawButton(Robotmap.Xbutton)){
            //     climber =new Climber();
            // }


        
        // if(Robot.oi.gamepad.getRawButton(Robotmap.Abutton)){
        //     shooter = new Shooter();
        // }
        // if(Robot.oi.ljoystick.getRawButton(Robotmap.JoyTrigger)){
        //     vision = new Vision(1.28,0,1); //1.28=15feet 
        // } else if(Globalvariables.Shootflag){
        //     shooter = new Shooter();
        // }
        // if(Robot.oi.gamepad.getRawButton(Robotmap.Abutton)){
        //     Robot.oi.testmotor.set(ControlMode.PercentOutput, (1));
        // } else if(Robot.oi.gamepad.getRawButton(Robotmap.Bbutton)){
        //     Robot.oi.testmotor.set(ControlMode.PercentOutput, (-1));
        // }
    }     
}