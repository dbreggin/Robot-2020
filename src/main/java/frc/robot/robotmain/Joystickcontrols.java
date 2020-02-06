package frc.robot.robotmain;
import frc.robot.AngleCall;
import frc.robot.Globalvariables;
import frc.robot.OI;
import frc.robot.Robot; 
import frc.robot.Robotmap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.robotmain.Shuffleboard_stuff;


import frc.robot.commands.LEDmode;
import frc.robot.commands.Vision;


public final class Joystickcontrols {
    public Vision visionFunction;
    public AngleCall angleFunction;
    public Joystickcontrols(){
    Joystickcontrol();
    }
    public void Joystickcontrol(){
        if(Robot.oi.rjoystick.getRawButton(Robotmap.JoyTrigger) && !Globalvariables.buttonDone[0]){
            Globalvariables.vision = !Globalvariables.vision;
            Globalvariables.buttonDone[0] = true;
        }
        else if(!Robot.oi.rjoystick.getRawButton(Robotmap.JoyTrigger) && Globalvariables.buttonDone[0]){
            Globalvariables.buttonDone[0] = false;
        }
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
        if(Globalvariables.angle){
            angleFunction = new AngleCall(90.0,0.0);
        }
        if(Globalvariables.vision){
            Globalvariables.UserControl = false;
            visionFunction = new Vision(2.11,0,1);
        }
        else{
            Globalvariables.UserControl = true;
        }
        if(Globalvariables.UserControl){
            Globalvariables.LEDmode = 0;
            if(Robot.oi.ljoystick.getRawButton(Robotmap.JoyTrigger)){
                if(Globalvariables.driveType){
                    Robot.oi.drive.arcadeDrive(Robot.oi.rjoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0), -Robot.oi.rjoystick.getRawAxis(Robotmap.joyX)*Robot.oi.maxSpeed.getDouble(1.0));
                }
                else{
                    Robot.oi.drive.tankDrive(Robot.oi.ljoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0), Robot.oi.rjoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0));
                }
            }
            else{
                if(Globalvariables.driveType){
                    Robot.oi.drive.arcadeDrive(-Robot.oi.rjoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0), -Robot.oi.rjoystick.getRawAxis(Robotmap.joyX)*Robot.oi.maxSpeed.getDouble(1.0));
                }
                else{
                    Robot.oi.drive.tankDrive(-Robot.oi.rjoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0), -Robot.oi.ljoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0));
                }   
            }
        // Robot.oi.intake_motor.set(ControlMode.PercentOutput, Robot.oi.gamepad.getRawAxis(1));
        //Robot.oi.drmotor1.set(ControlMode.PercentOutput, Robot.oi.gamepad.getRawAxis(1));
        }
    }

}