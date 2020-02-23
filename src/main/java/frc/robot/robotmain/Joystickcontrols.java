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
    public AngleCall angleFunction;
    public Joystickcontrols(){
    Joystickcontrol();
    }
    public void Joystickcontrol(){
        // Robot.oi.shooter_motor1.set(Robot.oi.gamepad.getRawAxis(Robotmap.LeftY));
        // Robot.oi.shooter_motor2.set(-Robot.oi.gamepad.getRawAxis(Robotmap.LeftY));
        // Robot.oi.shooter_intake.set(-Robot.oi.gamepad.getRawAxis(Robotmap.LeftY));
        Robot.oi.revolver.set(Robot.oi.gamepad.getRawAxis(Robotmap.LeftY));
        Robot.oi.hopper.set(Robot.oi.gamepad.getRawAxis(Robotmap.RightY));
        if(Robot.oi.gamepad.getRawButton(1)){
            Robot.oi.shooter_motor1.set(.9);
            Robot.oi.shooter_motor2.set(-.9);
            Robot.oi.shooter_intake.set(-.75);
            // Robot.oi.shooterPIDcontroller1.setReference(3000.0, ControlType.kVelocity);
            // Robot.oi.shooterPIDcontroller2.setReference(-3000.0, ControlType.kVelocity);
           // Robot.oi.shooterintakePID.setReference(-3000, ControlType.kVelocity);
        }else if(Robot.oi.gamepad.getRawButton(4)){
            Robot.oi.shooter_intake.set(.25);
        }else{
            Robot.oi.shooter_motor1.set(0);
            Robot.oi.shooter_motor2.set(0);
            Robot.oi.shooter_intake.set(0);
        }
        

        //FALCON TEST CODE 
        //Robot.oi.drmotor1.set(ControlMode.PercentOutput, (1));


        // if(Robot.oi.rjoystick.getRawButton(Robotmap.JoyTrigger) && !Globalvariables.buttonDone[0]){
        //     Globalvariables.vision = !Globalvariables.vision;
        //     Globalvariables.buttonDone[0] = true;
        // }
        // else if(!Robot.oi.rjoystick.getRawButton(Robotmap.JoyTrigger) && Globalvariables.buttonDone[0]){
        //     Globalvariables.buttonDone[0] = false;
        // }
        // if(Robot.oi.rjoystick.getRawButton(Robotmap.JoyBotFT) && !Globalvariables.buttonDone[1]){
        //     Globalvariables.driveType = !Globalvariables.driveType;
        //     Globalvariables.buttonDone[1] = true;
        // }
        // else if(!Robot.oi.rjoystick.getRawButton(Robotmap.JoyBotFT) && Globalvariables.buttonDone[1]){
        //     Globalvariables.buttonDone[1] = false;
        // }
        // if(Robot.oi.rjoystick.getRawButton(Robotmap.JoyBotBB) && !Globalvariables.buttonDone[2]){
        //     Globalvariables.angle = true;
        //     Globalvariables.buttonDone[2] = true;
        // }
        // else if(!Robot.oi.rjoystick.getRawButton(Robotmap.JoyBotBB) && Globalvariables.buttonDone[2]){
        //     Globalvariables.buttonDone[2] = false;
        // }
        // if(Globalvariables.angle){
        //     angleFunction = new AngleCall(90.0,0.0);
        // }
        // if(Globalvariables.vision){
        //     Globalvariables.UserControl = false;
        //     visionFunction = new VisionRange(0.75, 0.4,0,1);
        // }
        // else{
        //     Globalvariables.UserControl = true;
        // }
        if(Robot.oi.ljoystick.getRawButton(Robotmap.JoyTrigger)){
            Robot.oi.drive.tankDrive(Robot.oi.ljoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0),Robot.oi.rjoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0));   
        }else{
           Robot.oi.drive.tankDrive(-(Robot.oi.ljoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0)),-(Robot.oi.rjoystick.getRawAxis(Robotmap.joyY)*Robot.oi.maxSpeed.getDouble(1.0)));
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