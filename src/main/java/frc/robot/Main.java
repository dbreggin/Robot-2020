//DONT MESS WITH THIS FILE
package frc.robot;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.Joystick;

public final class Main {
  public static Joystick joystick;
  private Main() {
    
  }
  public static void main(String... args) {
    RobotBase.startRobot(Robot::new);
  }
}
