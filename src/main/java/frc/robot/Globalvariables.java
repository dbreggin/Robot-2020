/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;
import frc.robot.Robot;
import frc.robot.OI;
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Globalvariables {
    public static int ball_counter;
    public static double LEDoffset=-.06;
    public static int LEDmode = 12;
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
    public static boolean angle;
    public static boolean check_flag;
    public static boolean angle_turn;
    public static double speed;
    public static boolean tA_flag;
    public static double tA;
    public static boolean reverse;
    public static boolean Shootflag;
    public static double linecounter;
    public Globalvariables(){
        check_flag = false;
        Shootflag = false;
        angle = false;
        speed = 0.0;
        tA = 0.0;
        tA_flag = false;
        angle_turn = false;
        Seetarget = false;
        SwitchFlag = false;
        VisionFlag = false;
        UserControl = true;
        vision = false;
        driveType = false;
        reverse = false;
        ball_counter = 3; //use slider to change
    }    

}
