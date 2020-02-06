package frc.robot;
import frc.robot.OI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Globalvariables;

public final class AngleCall{
    public AngleCall(double tA, double speed){
        /*
        if(!Globalvariables.tA_flag){
            Globalvariables.angle_turn = !Globalvariables.angle_turn;
            Globalvariables.tA_flag = true;
        }
        */
        Globalvariables.angle_turn = true;
    }
}
    
    

