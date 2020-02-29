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
        if(Robot.oi.gamepad.getRawButtonPressed(5)){
            Robot.oi.swivle.setAngle(41);
        }
        if (Robot.oi.gamepad.getRawButtonPressed(6)) {
            Robot.oi.swivle.setAngle(180);
        }
        Robot.oi.revolver.set(Robot.oi.gamepad.getRawAxis(1));
        Robot.oi.shooter_intake.set(-Robot.oi.gamepad.getRawAxis(1));
        // Robot.oi.shooter_motor1.set(Robot.oi.gamepad.getRawAxis(Robotmap.LeftY));
        // Robot.oi.shooter_motor2.set(-Robot.oi.gamepad.getRawAxis(Robotmap.LeftY));
        // Robot.oi.shooter_intake.set(-Robot.oi.gamepad.getRawAxis(Robotmap.LeftY));
        Robot.oi.hopper.set(Robot.oi.gamepad.getRawAxis(1));
        if(Robot.oi.gamepad.getRawButton(1)){
            vision = new Vision(.975,0,1.0, -3);
            Globalvariables.UserControl = false;
            Robot.oi.shooterPIDcontroller1.setReference(Robot.shuffleboard.getshooterSpeed(), ControlType.kVelocity);
            Robot.oi.shooterPIDcontroller2.setReference(-Robot.shuffleboard.getshooterSpeed(), ControlType.kVelocity);
           if(Robot.oi.shooter_encoder1.getVelocity() + 500 > Robot.shuffleboard.getshooterSpeed() && Robot.oi.shooter_encoder1.getVelocity() - 500 < Robot.shuffleboard.getshooterSpeed()){
                if(!Robot.globalvariables.intake_flag){
                    Robot.oi.Limelight_timer.start();
                    Robot.oi.shotclock_timer.start();
                    Robot.globalvariables.intake_flag = true;
                }
                if(Robot.oi.shotclock_timer.get() > .5){
                    if(Robot.globalvariables.shooter_lineup){
                        Robot.globalvariables.anticlogtimer_flag = false;
                        Robot.oi.anitclog_timer.reset();
                        Robot.globalvariables.RPM_good = true;
                        Robot.oi.shooter_intake.set(-.9);
                        if(!Robot.globalvariables.intaketimer_flag){
                            Robot.oi.intake_timer.start();
                            Robot.globalvariables.intaketimer_flag = true;
                        }
                        if(Robot.oi.intake_timer.get() > .1){
                            Robot.oi.revolver.set(.4);
                        }
                    }   
                }else{
                    Robot.globalvariables.RPM_good = false;
                    Robot.oi.shooter_intake.set(0);
                    Robot.oi.revolver.set(0);
                }
           }else{
               if(!Robot.globalvariables.anticlogtimer_flag){
                    Robot.oi.anitclog_timer.start();
                    Robot.globalvariables.anticlogtimer_flag = true; 
               }
               if(Robot.oi.anitclog_timer.get() < .25){
                    Robot.oi.shooter_intake.set(.25);
                }
                Robot.oi.shotclock_timer.reset();
                Robot.oi.intake_timer.reset();
                Robot.globalvariables.intaketimer_flag = false;
                Robot.globalvariables.intake_flag = false;
           }
        }else if(Robot.oi.gamepad.getRawButton(4)){
            Robot.oi.shooter_intake.set(.5);
        }else{
            Robot.globalvariables.RPM_good = false;
            Robot.oi.Limelight_timer.reset();
            Globalvariables.UserControl = true; 
            Robot.oi.shooter_motor1.set(0);
            Robot.oi.shooter_motor2.set(0);
            //Robot.oi.shooter_intake.set(0);
            //Robot.oi.revolver.set(0);
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
        

        if(Globalvariables.UserControl){
            if(Robot.oi.ljoystick.getRawButton(Robotmap.JoyTrigger)){
                Robot.oi.drive.tankDrive(-Robot.oi.ljoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0),-Robot.oi.rjoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0));   
            }else{
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

}