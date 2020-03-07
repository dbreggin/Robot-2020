/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;
import frc.robot.Robot;
import frc.robot.OI;
import java.lang.Math;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Globalvariables {
    public static boolean driveDirection;
    public static int ball_counter;
    public static double LEDoffset=-.06;
    public static int LEDmode = 22;
    public static boolean[] lineloopflag ={
        false,
        false
    };
    public static boolean Seetarget;
    public static boolean SwitchFlag;
    public static boolean VisionFlag;
    public static boolean UserControl;
    public static boolean[] buttonDone = {
        false,
        false,
        false
    };
    public static boolean vision;
    public static boolean driveType;
    public static double revolverintakevarible;
    public static boolean angle;
    public static boolean check_flag;
    public static boolean angle_turn;
    public static boolean angle_flag;
    public static double speed;
    public static boolean tA_flag;
    public static double tA;
    public static boolean reverse;
    public static boolean Shootflag;
    public static double linecounter;
    public static boolean turn2angle;
    public static double turn1angle;
    public static int autonomous_stage;
    public static double automode;
    public boolean intake_flag;
    public boolean intaketimer_flag;
    public boolean anticlog_flag;
    public boolean anticlogtimer_flag;
    public boolean shooter_lineup;
    public boolean RPM_good;
    public boolean flip_flag;
    public boolean ball_pickedup;
    public double origonal_ball;
    public int ball_stage_count;
    public boolean ball_reset;
    public double Vilocity3;
    public boolean target_covered;
    public boolean ball_intheintake;
    public boolean revolver_delay_flag;
    public boolean reset_ball_cycle;
    public boolean Ball_down;
    public boolean Ball_up;
    public boolean antianti_flag;
    public Globalvariables(){
        antianti_flag = false;
        reset_ball_cycle = false;
        revolver_delay_flag = false;
        ball_intheintake = false;
        target_covered = false;
        Vilocity3 = 0;
        ball_reset = false;
        origonal_ball = 0;
        ball_stage_count = 0;
        RPM_good = false;
        driveDirection = false;
        shooter_lineup= false;
        anticlogtimer_flag = false;
        anticlog_flag = false;
        revolverintakevarible = 0;
        intaketimer_flag = false;
        intake_flag = false;
        check_flag = false;
        Shootflag = false;
        angle = false;
        speed = 0.0;
        tA = 0.0;
        tA_flag = false;
        angle_turn = false;
        turn2angle = false;
        turn1angle = (0.0);
        Seetarget = false;
        SwitchFlag = false;
        VisionFlag = false;
        UserControl = true;
        vision = false;
        driveType = false;
        reverse = false;
        angle_flag = false;
        automode = 0;        
        flip_flag = false;
        Ball_down = false;
        Ball_up = false;
        ball_counter = 4;
        autonomous_stage = 0; //use slider to change

    }    

}
