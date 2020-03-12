package frc.robot.robotmain;
import frc.robot.AngleCall;
import frc.robot.Globalvariables;
import frc.robot.OI;
import frc.robot.Robot; 
import frc.robot.Robotmap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.robotmain.Shuffleboard_stuff;


import com.revrobotics.ControlType;


import frc.robot.commands.LEDmode;
import frc.robot.commands.Vision;
import frc.robot.commands.VisionRange;



public final class Joystickcontrols {
    // public Vision visionFunction;
    public VisionRange visionFunction;
    public Vision vision;
    public AngleCall angleFunction;

    
    public Joystickcontrols(){
    Joystickcontrol();
    }
    public void Joystickcontrol(){
        
        
        if(Robot.oi.gamepad.getRawButton(3)){
            /*
            if(!Robot.globalvariables.reset_ball_cycle){
                Robot.oi.revolver_timer_delay.reset();
                Robot.oi.revolver_timer.reset();
                Robot.globalvariables.reset_ball_cycle = true;
                Robot.globalvariables.revolver_delay_flag = false;
                Robot.globalvariables.ball_intheintake = true;
            }else{
                Robot.oi.hopper.set(ControlMode.PercentOutput, .75);
                if(!Robot.oi.lineSensor.get()){
                    if(!Robot.globalvariables.revolver_delay_flag){
                        Robot.oi.revolver_timer_delay.start();
                        Robot.oi.revolver_timer_delay.reset();
                        Robot.globalvariables.revolver_delay_flag = true;
                    }
                    if(!Robot.globalvariables.ball_intheintake){
                        if(Robot.oi.revolver_timer_delay.get() > 1){
                            Robot.oi.revolver.set(.4);
                            Robot.oi.revolver_timer.start();
                            Robot.oi.revolver_timer.reset();
                            Robot.globalvariables.ball_intheintake = true;
                            Robot.globalvariables.revolver_delay_flag = false;
                        }
                    }
                }
                if(Robot.oi.revolver_timer.get() > .87){
                    Robot.oi.revolver.set(0);
                    Robot.globalvariables.ball_intheintake = false;
                }
            }
            */
            Ball_intake2();
        }else if(!Robot.oi.gamepad.getRawButton(1) && !Robot.oi.gamepad.getRawButton(3)){
            //NEEDED TO BE BOUND FOR BALL CYCLE 
     
            Robot.oi.hopper.set(ControlMode.PercentOutput, 0);
            Robot.oi.revolver.set(0);
        }
        if(!Robot.oi.gamepad.getRawButton(1) && Robot.oi.gamepad.getRawButton(4)){
            Robot.oi.shooter_intake.set(.5);
        }else if(!Robot.oi.gamepad.getRawButton(1) && !Robot.oi.gamepad.getRawButton(4)){
            Robot.oi.shooter_intake.set(0);
        }
        if(!Robot.oi.gamepad.getRawButton(3)){
            Ball_intake2_reset();
        }
        // Robot.oi.shooter_motor1.set(Robot.oi.gamepad.getRawAxis(Robotmap.LeftY));
        // Robot.oi.shooter_motor2.set(-Robot.oi.gamepad.getRawAxis(Robotmap.LeftY));
        //Robot.oi.hopper.set(Robot.oi.gamepad.getRawAxis(RF));
        if(Robot.oi.gamepad.getRawButton(1)){
            
            Shooter_cycle();

        }else if(!Robot.oi.gamepad.getRawButton(1)){
            Shooter_reset();

        }else if(Robot.oi.gamepad.getRawButton(8)){
            Robot.oi.shooter_intake.set(-.25);
        }else if(!Robot.oi.gamepad.getRawButton(8) && !Robot.oi.gamepad.getRawButton(1) && !Robot.oi.gamepad.getRawButton(3)){
            /////NEED TO BE BOUND FOR SHOOTER
            Robot.oi.shooter_intake.set(0);
        }   

        //FALCON TEST CODE 
        if(Robot.oi.rjoystick.getRawButton(Robotmap.JoyBotFT) && !Globalvariables.buttonDone[1]){
            Globalvariables.driveType = !Globalvariables.driveType;
            Globalvariables.buttonDone[1] = true;
        }
        else if(!Robot.oi.rjoystick.getRawButton(Robotmap.JoyBotFT) && Globalvariables.buttonDone[1]){
            Globalvariables.buttonDone[1] = false;
        }
        if(Robot.oi.rjoystick.getRawButton(Robotmap.JoyBotBB) && !Globalvariables.buttonDone[2]){
            Globalvariables.angle = true;
            Globalvariables.buttonDone[2] = true;
        }
        else if(!Robot.oi.rjoystick.getRawButton(Robotmap.JoyBotBB) && Globalvariables.buttonDone[2]){
            Globalvariables.buttonDone[2] = false;
        }
        // if(Globalvariables.angle){
        //     angleFunction = new AngleCall(90.0,0.0);
        // }
        //     //visionFunction = new VisionRange(0.75, 0.4,0,1);
        if(Robot.oi.gamepad.getRawButton(2)&& !Robot.oi.gamepad.getRawButton(3) && !Robot.oi.gamepad.getRawButton(1)){
            Robot.oi.hopper.set(-.5);
            Robot.oi.revolver.set(.75);
        }else if(!Robot.oi.gamepad.getRawButton(2)&& !Robot.oi.gamepad.getRawButton(3) && !Robot.oi.gamepad.getRawButton(1)){
            Robot.oi.hopper.set(0);
            Robot.oi.revolver.set(0);
        }
        if(Robot.oi.rjoystick.getRawButton(Robotmap.JoyTrigger) && !Robot.globalvariables.flip_flag){
            Robot.globalvariables.flip_flag = true;
            Globalvariables.driveDirection = !Globalvariables.driveDirection;
        } else if(!Robot.oi.rjoystick.getRawButton(Robotmap.JoyTrigger) && Robot.globalvariables.flip_flag){
            Robot.globalvariables.flip_flag = false;
        }
        if(Globalvariables.UserControl){
            if(Globalvariables.driveDirection){
                Robot.oi.drive.tankDrive(-Robot.oi.rjoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0),-Robot.oi.ljoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0));   
            } else {
                Robot.oi.drive.tankDrive((Robot.oi.ljoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0)),(Robot.oi.rjoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0)));
            }
        }
        
    
    
        // if(Globalvariables.UserControl){
        //     Globalvariables.LEDmode = 22;
        //     if(Robot.oi.ljoystick.getRawButton(Robotmap.JoyTrigger)){
        //         if(Globalvariables.driveType){
        //             Robot.oi.drive.arcadeDrive(Robot.oi.rjoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0), -Robot.oi.rjoystick.getRawAxis(Robotmap.joyX)*Robot.oi.maxSpeed.getDouble(1.0));
        //         }
        //         else{
        //             Robot.oi.drive.tankDrive(Robot.oi.ljoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0), Robot.oi.rjoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0));
        //         }
        //     }
        //     else{
        //         if(Globalvariables.driveType){
        //             Robot.oi.drive.arcadeDrive(-Robot.oi.rjoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0), -Robot.oi.rjoystick.getRawAxis(Robotmap.joyX)*Robot.oi.maxSpeed.getDouble(1.0));
        //         }
        //         else{
        //             Robot.oi.drive.tankDrive(-Robot.oi.rjoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0), -Robot.oi.ljoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0));
        //         }   
        //     }
        // Robot.oi.intake_motor.set(ControlMode.PercentOutput, Robot.oi.gamepad.getRawAxis(1));
        //Robot.oi.drmotor1.set(ControlMode.PercentOutput, Robot.oi.gamepad.getRawAxis(1));
        //}
        /* LIft STUFFFFF */
        // if(Robot.oi.gamepad.getRawAxis(Robotmap.LeftY) > 0){
        //     Robot.oi.cl_lift.set(ControlMode.PercentOutput, (1));
        // }else if(Robot.oi.gamepad.getRawAxis(Robotmap.LeftY) < 0){
        //     Robot.oi.cl_lift.set(ControlMode.PercentOutput, (-1));
        // }else{
        //     Robot.oi.cl_lift.set(ControlMode.PercentOutput, (0));
        // }

        /******* CLIMB STUFF *********/
        // if(Robot.oi.gamepad.getRawAxis(Robotmap.LeftX) > 0){
        //     Robot.oi.cl_moveR.set(ControlMode.PercentOutput, (1));
        // }else if(Robot.oi.gamepad.getRawAxis(Robotmap.LeftX) < 0){
        //     Robot.oi.cl_moveR.set(ControlMode.PercentOutput, (-1));
        // }else{
        //     Robot.oi.cl_moveR.set(ControlMode.PercentOutput, (0));
        // }       
    
    }
    public void Ball_intake2(){
        Robot.oi.swivle.setAngle(165);
        Robot.oi.hopper.set(ControlMode.PercentOutput, .75);
        if(!Robot.oi.lineSensor.get()){
            if(!Robot.globalvariables.ball_intheintake){
                Robot.oi.revolver_timer_delay.start();
                Robot.oi.revolver_timer_delay.reset();
                Robot.globalvariables.ball_intheintake = true;
            }
        }
        if(Robot.oi.revolver_timer_delay.get() > .5) {
            if(!Robot.globalvariables.revolver_delay_flag){
                Robot.oi.revolver_timer.start();
                Robot.oi.revolver_timer.reset();
                Robot.globalvariables.revolver_delay_flag = true;
            }
            if(Robot.oi.revolver_timer.get() > 1.5) {
                Robot.oi.revolver.set(0);
                Ball_intake2_reset();
            } else {
                Robot.oi.revolver.set(.33);
            }
        }
    }
    public void Ball_intake2_reset(){
        Robot.globalvariables.ball_intheintake = false;
        Robot.globalvariables.revolver_delay_flag = false;
        Robot.oi.revolver_timer_delay.stop();
        Robot.oi.revolver_timer_delay.reset();
        Robot.oi.revolver_timer.stop();
        Robot.oi.revolver_timer.reset();
    }
    public void Ball_intake(){
       
        Globalvariables.UserControl = false;
        if(Robot.globalvariables.ball_stage_count == 0){
            vision = new Vision(.6,3,1,0);
        }else if(Robot.globalvariables.ball_stage_count == 1){

            Robot.oi.drive.tankDrive(.6,.6);

            Robot.oi.hopper.set(ControlMode.PercentOutput, .75);
            Robot.oi.drive.tankDrive(.6,.6);
            if(!Robot.oi.lineSensor.get()){
                if(!Robot.globalvariables.ball_intheintake){
                    vision = new Vision(.975,1,1.0, -3);///find which pipeline////FIX 
                    Robot.oi.revolver_timer_delay.start();
                    Robot.oi.revolver_timer_delay.reset();
                    Robot.globalvariables.ball_intheintake = true;
                    Robot.oi.drive.tankDrive(0,0);
                }
            }
            if(Robot.oi.revolver_timer_delay.get() > .5) {
                if(!Robot.globalvariables.revolver_delay_flag){
                    Robot.oi.revolver_timer.start();
                    Robot.oi.revolver_timer.reset();
                    Robot.globalvariables.revolver_delay_flag = true;
                }
                if(Robot.oi.revolver_timer.get() > 1.5) {
                    Robot.globalvariables.ball_stage_count ++;
                    Robot.oi.revolver.set(0);
                    Robot.globalvariables.ball_intheintake = false;
                    Robot.globalvariables.revolver_delay_flag = false;
                    Robot.oi.revolver_timer_delay.stop();
                    Robot.oi.revolver_timer_delay.reset();
                    Robot.oi.revolver_timer.stop();
                    Robot.oi.revolver_timer.reset();
                }else {
                    Robot.oi.revolver.set(.33);
                }
            }
            
        }else if(Robot.globalvariables.ball_stage_count == 2){
            Robot.oi.hopper.set(0);
            Robot.oi.revolver.set(0);
            Robot.oi.ball_timer.reset();
            Robot.globalvariables.ball_reset = true;
            Robot.globalvariables.ball_stage_count = 0;

        }
        
    }
    public void Shooter_cycle(){
       Robot.oi.swivle.setAngle(5);
       vision = new Vision(.975,0,1.0, -3);
       Globalvariables.UserControl = false;
       Robot.oi.shooterPIDcontroller1.setReference(Robot.globalvariables.Vilocity1,  ControlType.kVelocity);
       Robot.oi.shooterPIDcontroller2.setReference(-Robot.globalvariables.Vilocity1, ControlType.kVelocity);
       if(Robot.oi.shooter_encoder1.getVelocity() + 300 >= Robot.globalvariables.Vilocity1 && Robot.oi.shooter_encoder1.getVelocity() - 300 <= Robot.globalvariables.Vilocity1){
           if(!Robot.globalvariables.intake_flag){
               Robot.oi.Limelight_timer.start();
               Robot.oi.shotclock_timer.start();
               Robot.globalvariables.intake_flag = true;
           }
           if(Robot.oi.shotclock_timer.get() > 2){
               if(Robot.globalvariables.shooter_lineup){
                   Robot.globalvariables.anticlogtimer_flag = false;
                   Robot.oi.anitclog_timer.reset();
                   Robot.globalvariables.RPM_good = true;
                   Robot.globalvariables.target_covered = true;
                   if(!Robot.globalvariables.anticlogtimer_flag){
                        if(!Robot.globalvariables.antianti_flag){
                            Robot.oi.shooter_intake.set(.2);
                            Robot.oi.anitclog_timer.start();
                            Robot.globalvariables.antianti_flag = true;
                        }else{
                            Robot.oi.shooter_intake.set(-1);
                        }
                        
                    }
                   
                   if(!Robot.globalvariables.intaketimer_flag){
                       Robot.oi.intake_timer.start();
                       Robot.globalvariables.intaketimer_flag = true;
                   }
                   if(Robot.oi.intake_timer.get() > 1){
                       if(Robot.globalvariables.distance_to_target > 15){
                            Robot.oi.revolver.set(.7);
                       }else{
                            Robot.oi.revolver.set(1);
                       }   
                   }
               }   
           }else{
               Robot.globalvariables.RPM_good = false;
               Robot.oi.shooter_intake.set(0);
               Robot.globalvariables.anticlogtimer_flag = false;
               Robot.globalvariables.antianti_flag = false;
               Robot.oi.revolver.set(0);
           }
       }else{
           if(Robot.globalvariables.distance_to_target > 15){
            Robot.oi.shotclock_timer.reset();
           }
           if(!Robot.globalvariables.anticlogtimer_flag){
               Robot.oi.anitclog_timer.start();
               Robot.globalvariables.anticlogtimer_flag = true; 
           }
           if(Robot.oi.anitclog_timer.get() < .25){
            //    Robot.oi.shooter_intake.set(.25);
           }

       }
    }public void Shooter_reset(){
        // Robot.oi.revolver.set(0);
        Robot.oi.shotclock_timer.reset();
        Robot.oi.intake_timer.reset();
        Robot.globalvariables.intaketimer_flag = false;
        Robot.globalvariables.intake_flag = false;
        Robot.globalvariables.RPM_good = false;
        Robot.oi.Limelight_timer.reset();
        Robot.oi.anitclog_timer.reset();
        Globalvariables.UserControl = true; 
        Robot.oi.shooter_motor1.set(0);
        Robot.oi.shooter_motor2.set(0);
        Robot.globalvariables.antianti_flag = false;
        Robot.globalvariables.target_covered = false;
    }
}