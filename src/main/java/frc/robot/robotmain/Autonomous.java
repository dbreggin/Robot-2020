package frc.robot.robotmain;
import frc.robot.commands.Drivestraight;
import frc.robot.Robot;
import frc.robot.commands.Identifyballs;
import frc.robot.commands.VisionRange;
import frc.robot.Globalvariables;
import frc.robot.commands.Vision;
import com.revrobotics.ControlType;
//import frc.robot.commands.Angleturn;
public final class Autonomous {
    double sA; 
    public VisionRange visionRangeFunction;
    public Vision visionFunction;
    public Autonomous(){
    if(Globalvariables.stage_counter == 0){
        switch(Globalvariables.autonomous_stage){
            case 0:
                //1 foot = 9464.56 on left
                if(Robot.oi.motor1.getSelectedSensorPosition(0) > -9464.7*5){
                    Robot.oi.drive.arcadeDrive(-.5, sA);
                    Robot.oi.ta = Robot.oi.table.getEntry("ta");
                    Robot.oi.la = Robot.oi.ta.getDouble(0.0);
                    sA = Robot.oi.navx.getAngle()*.09;
                    if(Robot.oi.navx.getAngle()<1.75 && Robot.oi.navx.getAngle()>-1.75){
                        sA*=4.20;
                        Globalvariables.LEDmode=10;
                    } else {
                        Globalvariables.LEDmode=2;
                    }
        
                    if(sA>1){
                        sA = 1;
                    } else if (sA<-1){
                        sA = -1;   
                    } 
                }else {

                    visionFunction = new Vision(.975,0,1.0, -3);
                    Robot.oi.shooterPIDcontroller1.setReference(2800, ControlType.kVelocity);
                    Robot.oi.shooterPIDcontroller2.setReference(-2800, ControlType.kVelocity);
                    if(Robot.oi.shooter_encoder1.getVelocity() + 500 > 2800 && Robot.oi.shooter_encoder1.getVelocity() - 500 < 2800){
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
                                    Robot.oi.revolver.set(.3);
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
            }
        }
        
            if(Globalvariables.ball_counter ==0){
                Robot.oi.shooterPIDcontroller1.setReference(0, ControlType.kVelocity);
                Robot.oi.shooterPIDcontroller2.setReference(0, ControlType.kVelocity);
                Robot.oi.shooter_intake.set(0);
                Robot.oi.revolver.set(0);
                Robot.oi.auto_hopper_tTimer.start();
                //TEMPP 
                Robot.oi.swivle.setAngle(175);
                visionFunction = new Vision(.6,3,1,0);
                if(Robot.globalvariables.shooter_lineup){
                    Robot.oi.drive.tankDrive(.6,.6);
                    Robot.oi.hopper.set(.75);
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
                            Robot.globalvariables.ball_intheintake = false;
                            Robot.globalvariables.revolver_delay_flag = false;
                            Robot.oi.revolver_timer_delay.stop();
                            Robot.oi.revolver_timer_delay.reset();
                            Robot.oi.revolver_timer.stop();
                            Robot.oi.revolver_timer.reset();
                        } else {
                            Robot.oi.revolver.set(.33);
                        }
                    }
                }
            
                Globalvariables.autonomous_stage ++;
            }
            
            break;
        case 1:
            Robot.oi.drive.tankDrive(0, 0);
            Globalvariables.autonomous_stage++;
            break;
        // case 2:
        //     sA = 140-Robot.oi.navx.getAngle()*.09;
        //     if(Robot.oi.navx.getAngle()<-20-2){
        //         Robot.oi.drive.arcadeDrive(0, -.6);
        //         Globalvariables.LEDmode=2;
        //     } else if(Robot.oi.navx.getAngle()>-20+2){
        //         Robot.oi.drive.arcadeDrive(0, .6);
        //         Globalvariables.LEDmode=2;
        //     } else {
        //         Robot.oi.drive.tankDrive(0, 0);
        //         Globalvariables.LEDmode=10;
        //         Globalvariables.autonomous_stage++;
        //     }
        //         break;
        // case 3:
        //         ball_cycle=new ball cycle;        
        default:
            Robot.oi.drive.tankDrive(0, 0);
        }
    }
    if(Globalvariables.stage_counter == 1){
        switch(Globalvariables.autonomous_stage){
            case 0:
                Robot.oi.auto_timer.start();
                //1 foot = 9464.56 on left
                if(Robot.oi.motor1.getSelectedSensorPosition(0) > -9464.7*5){
                    Robot.oi.drive.arcadeDrive(-.5, sA);
                    Robot.oi.ta = Robot.oi.table.getEntry("ta");
                    Robot.oi.la = Robot.oi.ta.getDouble(0.0);
                    sA = Robot.oi.navx.getAngle()*.09;
                    if(Robot.oi.navx.getAngle()<1.75 && Robot.oi.navx.getAngle()>-1.75){
                        sA*=4.20;
                        Globalvariables.LEDmode=10;
                    } else {
                        Globalvariables.LEDmode=2;
                    }
        
                    if(sA>1){
                        sA = 1;
                    } else if (sA<-1){
                        sA = -1;   
                    } 
                }else {
                    visionFunction = new Vision(.975,0,1.0, -3);
                    Robot.oi.shooterPIDcontroller1.setReference(2425, ControlType.kVelocity);
                    Robot.oi.shooterPIDcontroller2.setReference(-2425, ControlType.kVelocity);
                    if(Robot.oi.shooter_encoder1.getVelocity() + 500 > 2425 && Robot.oi.shooter_encoder1.getVelocity() - 500 < 2425){
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
                                    Robot.oi.revolver.set(.3);
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
            }
        }
        if(Robot.oi.auto_timer.get() > 9){
            Robot.oi.shooterPIDcontroller1.setReference(0, ControlType.kVelocity);
            Robot.oi.shooterPIDcontroller2.setReference(0, ControlType.kVelocity);
            Robot.oi.shooter_intake.set(0);
            Robot.oi.revolver.set(0);
            Globalvariables.autonomous_stage ++;
        }
            
            break;
        case 1:
            if(Robot.globalvariables.ball_stage_count == 0){
                Robot.oi.swivle.setAngle(165);
                if(!Robot.globalvariables.ball_intheintake){
                    visionFunction = new Vision(.6,3,1,0);
                }
                if(Robot.globalvariables.shooter_lineup){
                    Robot.globalvariables.ball_stage_count ++; 
                }
            }else if(Robot.globalvariables.ball_stage_count == 1){
                Robot.oi.hopper.set(.75);
                Robot.oi.drive.tankDrive(.6,.6);
                if(!Robot.oi.lineSensor.get()){
                    if(!Robot.globalvariables.ball_intheintake){
                        Robot.oi.revolver_timer_delay.start();
                        Robot.oi.revolver_timer_delay.reset();
                        Robot.globalvariables.ball_intheintake = true;
                        Robot.oi.drive.tankDrive(0,0);
                    }
                }
                if(Robot.oi.revolver_timer_delay.get() > .5){
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
            break;      
        default:
            Robot.oi.drive.tankDrive(0, 0);
        }
    }        
    ////////MOVE BACK, TURN TO BALL, TURN TO TARGET, SHOOT AT TARGET/////////////
    /*
    if(Globalvariables.automode == 0){
            switch(Globalvariables.autonomous_stage){
                case 0: 
                    Robot.oi.ta = Robot.oi.table.getEntry("ta");
                    Robot.oi.la = Robot.oi.ta.getDouble(0.0);
                    sA = Robot.oi.navx.getAngle()*.09;
                    if(Robot.oi.navx.getAngle()<1.75 && Robot.oi.navx.getAngle()>-1.75){
                        sA*=4.20;
                        Globalvariables.LEDmode=10;
                    } else {
                        Globalvariables.LEDmode=2;
                    }
        
                    if(sA>1){
                        sA = 1;
                    } else if (sA<-1){
                        sA = -1;   
                    }                
                    //2430 = 5 feet
                    Robot.oi.drive.arcadeDrive(-.75, sA);
                    // if(Robot.oi.la != 0.0){
                    //     Globalvariables.autonomous_stage++;
                    // }
                    if(Robot.oi.motor1.getSelectedSensorPosition()<- 1){
                        Globalvariables.autonomous_stage++;
                    }
                    break;
                case 1:
                    Robot.oi.drive.tankDrive(0, 0);
                    Globalvariables.autonomous_stage++;    
                    break;
                case 2:
                    visionRangeFunction = new VisionRange(0.4, 0.4,0,1);
                    if(Globalvariables.ball_counter <=0 ){
                        Globalvariables.ball_counter = 0;
                        Globalvariables.autonomous_stage++;
                    }
                    break;
                case 3:
                    sA = 140-Robot.oi.navx.getAngle()*.09;
                    if(Robot.oi.navx.getAngle()<100-2){
                        Robot.oi.drive.arcadeDrive(0, -.6);
                        Globalvariables.LEDmode=2;
                    } else if(Robot.oi.navx.getAngle()>100+2){
                        Robot.oi.drive.arcadeDrive(0, .6);
                        Globalvariables.LEDmode=2;
                    } else {
                        Robot.oi.drive.tankDrive(0, 0);
                        Globalvariables.LEDmode=10;
                        Globalvariables.autonomous_stage++;
                    }
                    break;
                case 4:
                    visionFunction = new Vision(.7,3,.9,0);
                    break;
                case 5:
                    Robot.oi.drive.tankDrive(0, 0);
                    Globalvariables.autonomous_stage++;
                    break;
                case 6:
                    if(Robot.oi.navx.getAngle()<0-2){
                        Robot.oi.drive.arcadeDrive(0, -.6);
                        Globalvariables.LEDmode=2;
                    } else if(Robot.oi.navx.getAngle()>0+2){
                        Robot.oi.drive.arcadeDrive(0, .6);
                        Globalvariables.LEDmode=2;
                    } else {
                        Robot.oi.drive.tankDrive(0, 0);
                        Globalvariables.LEDmode=10;
                        Globalvariables.autonomous_stage++;
                    }
                    break;
                case 7:
                    visionRangeFunction = new VisionRange(0.4, 0.4,0,1);
                    if(Globalvariables.ball_counter<=0){
                        Globalvariables.ball_counter=0;
                        Globalvariables.autonomous_stage++;
                    }
                    break;
                case 8:
                    Robot.oi.drive.tankDrive(0, 0);
                    Globalvariables.autonomous_stage++;
                    break;
                default:
                    Robot.oi.drive.tankDrive(0, 0);
                    break;
            }
        }
        //MOVE ALLIENCE PARTNER OFF LINE, SHOOT, COLLECT NEW BALLS 
        if(Globalvariables.automode == 1){
            switch(Globalvariables.autonomous_stage){
                case 0: 
                     //2430 = 5 feet
                    if(Robot.oi.motor1.getSelectedSensorPosition()<-2430*1){
                        Robot.oi.drive.arcadeDrive(-.75, -.75);
                    }else{
                        Globalvariables.autonomous_stage++;
                    }
                    break;
                case 1:
                    Robot.oi.ta = Robot.oi.table.getEntry("ta");
                    Robot.oi.la = Robot.oi.ta.getDouble(0.0);
                    sA = Robot.oi.navx.getAngle()*.09;
                    if(Robot.oi.navx.getAngle()<1.75 && Robot.oi.navx.getAngle()>-1.75){
                        sA*=4.20;
                        Globalvariables.LEDmode=10;
                    } else {
                        Globalvariables.LEDmode=2;
                    }
                    if(sA>1){
                        sA = 1;
                    } else if (sA<-1){
                        sA = -1;   
                    }                
                    Robot.oi.drive.arcadeDrive(0, sA);
                    Globalvariables.autonomous_stage++;
                    break;
                case 2:
                    Robot.oi.drive.tankDrive(0, 0);
                    Globalvariables.autonomous_stage++;
                    break;
                case 3:
                    visionRangeFunction = new VisionRange(0.4, 0.4,0,1);
                    if(Globalvariables.ball_counter <=0 ){
                        Globalvariables.ball_counter = 0;
                        Globalvariables.autonomous_stage++;
                    }
                    break;
                case 4:
                    if(Robot.oi.navx.getAngle()<0-2){
                        Robot.oi.drive.arcadeDrive(0, -.6);
                        Globalvariables.LEDmode=2;
                    } else if(Robot.oi.navx.getAngle()>0+2){
                        Robot.oi.drive.arcadeDrive(0, .6);
                        Globalvariables.LEDmode=2;
                    } else {
                        Robot.oi.drive.tankDrive(0, 0);
                        Globalvariables.LEDmode=10;
                        Globalvariables.autonomous_stage++;
                    }
                    break;
                case 5:
                    visionRangeFunction = new VisionRange(0.4, 0.4,0,1);
                    if(Globalvariables.ball_counter<=0){
                        Globalvariables.ball_counter=0;
                        Globalvariables.autonomous_stage++;
                    }
                    break;
                case 6:
                    Robot.oi.drive.tankDrive(0, 0);
                    Globalvariables.autonomous_stage++;
                    break;
                default:
                    Robot.oi.drive.tankDrive(0, 0);
                    break;
            }
        }
        //GO OFF LINE,COLLECT BALLS 2 ,SHOOT CYCLE
        if(Globalvariables.automode == 2){
            switch(Globalvariables.autonomous_stage){
                case 0: 
                    if(Robot.oi.motor1.getSelectedSensorPosition()<-2430*1){
                        Robot.oi.drive.arcadeDrive(-.75, -.75);
                    }else{
                        Globalvariables.autonomous_stage++;
                    }
                    break;
                case 1:
                    Robot.oi.drive.tankDrive(0, 0);
                    Globalvariables.autonomous_stage++;
                    break;
                case 2:
                    if(Robot.oi.navx.getAngle()<0-2){
                        Robot.oi.drive.arcadeDrive(0, -.6);
                        Globalvariables.LEDmode=2;
                    } else if(Robot.oi.navx.getAngle()>0+2){
                        Robot.oi.drive.arcadeDrive(0, .6);
                        Globalvariables.LEDmode=2;
                    } else {
                        Robot.oi.drive.tankDrive(0, 0);
                        Globalvariables.LEDmode=10;
                        Globalvariables.autonomous_stage++;
                    }
                    break;
                case 3:
                    visionFunction = new Vision(.7,3,.9,0);
                    if(Globalvariables.ball_counter >=5){
                        Globalvariables.ball_counter = 5;
                        Globalvariables.autonomous_stage++;
                    }
                    break;
                case 4:
                    visionRangeFunction = new VisionRange(0.4, 0.4,0,1);
                    if(Globalvariables.ball_counter<=0){
                        Globalvariables.ball_counter=0;
                        Globalvariables.autonomous_stage++;
                    }
                    break;
               case 5:
                    Robot.oi.drive.tankDrive(0, 0);
                    Globalvariables.autonomous_stage++;
                    break; 
                default:
                    Robot.oi.drive.tankDrive(0, 0);
                    break;
            }
        }
        //MOVE OFF LINE AND END IT ALL ummmm you ok bud?
        if(Globalvariables.automode == 3){
            switch(Globalvariables.autonomous_stage){
                case 0: 
                    if(Robot.oi.drive_encoder1.getPosition()<-2430*1){
                        Robot.oi.drive.arcadeDrive(-.75, -.75);
                    }else{
                        Globalvariables.autonomous_stage++;
                    }
                    break;
                default:
                Robot.oi.drive.tankDrive(0, 0);
                break;
            }
            //WHATEVER WE NEED
        if(Globalvariables.automode == 4){
            switch(Globalvariables.autonomous_stage){
                case 0:
                }
            }
        }
    }
    }
    //1 foot = 9464.56 on left, -9366.14 on right 
    void headingStraight(double speed, double distance, double angle){
        Robot.oi.ta = Robot.oi.table.getEntry("ta");
        Robot.oi.la = Robot.oi.ta.getDouble(0.0);
        sA = Robot.oi.navx.getAngle()*.09;
        if(Robot.oi.navx.getAngle()<angle && Robot.oi.navx.getAngle()>-angle){
            sA*=4.20;
            Globalvariables.LEDmode=10;
        } else {
            Globalvariables.LEDmode=2;
        }

        if(sA>1){
            sA = 1;
        } else if (sA<-1){
            sA = -1;   
        }                
        //2430 = 5 feet
        Robot.oi.drive.arcadeDrive(speed, sA);
        // if(Robot.oi.la != 0.0){
        //     Globalvariables.autonomous_stage++;
        // }
        if(Robot.oi.motor1.getSelectedSensorPosition()<- 1){
            Globalvariables.autonomous_stage++;
        }
    }
    void turnAngle(double angle){
        sA = 140-Robot.oi.navx.getAngle()*.09;
        if(Robot.oi.navx.getAngle()<angle-2){
            Robot.oi.drive.arcadeDrive(0, -.6);
            Globalvariables.LEDmode=2;
        } else if(Robot.oi.navx.getAngle()>angle+2){
            Robot.oi.drive.arcadeDrive(0, .6);
            Globalvariables.LEDmode=2;
        } else {
            Robot.oi.drive.tankDrive(0, 0);
            Globalvariables.LEDmode=10;
            Globalvariables.autonomous_stage++;
        }
    }
    void swivle(double angle){
        if (Robot.oi.swivle.getAngle() < angle){
            Robot.oi.swivle.set(.3);
        }else if(Robot.oi.swivle.getAngle() > angle){
            Robot.oi.swivle.set(-.3);
        }
    }
    */
      
        
    } 
} 




