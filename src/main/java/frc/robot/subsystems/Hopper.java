package frc.robot.subsystems;

import frc.robot.Robot;

public final class Hopper {
    public int ball_counter;
    public Hopper(){
        if(!Robot.oi.lineSensor.get()){ball_counter += 1;}
        if(!Robot.oi.lineSensor2.get()){ball_counter -= 1;}
        if(ball_counter < 5){

        }else{

        }


    }
}