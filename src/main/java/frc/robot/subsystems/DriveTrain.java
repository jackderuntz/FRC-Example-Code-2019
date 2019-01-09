/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Robot;

//CTRE usually imports these automatically in the new update
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
  This is the drivetrain subsystem, so that means that any code that deals with
  the motor controllers or the sensors gets put in here.
 */
public class DriveTrain extends Subsystem {
    //Create the motor controllers so we can tell them what to do.
    TalonSRX leftMaster = new TalonSRX(Robot.rm.leftMaster);
    TalonSRX leftSlave = new TalonSRX(Robot.rm.leftSlave);
    TalonSRX rightMaster = new TalonSRX(Robot.rm.rightMaster);
    TalonSRX rightSlave = new TalonSRX(Robot.rm.rightSlave);

    //Let's make the slaves follow the master. The talons will take care of everything else.
    


  static void Deadband(double value)
  {
      if (value < -0.10)
      {
          /* outside of deadband */
      }
      else if (value > +0.10)
      {
          /* outside of deadband */
      }
      else
      {
          /* within 10% so zero it */
          value = 0;
      }
  }
  public void ConfigSensors(){
    //Let's config the sensors so that the Talon's know what encoder it is using
    leftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    rightMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

  }

  //Lets the player drive the robot with a controller
  public void ArcadeDrive(Joystick throttle, int throttleAxis, Joystick turn, int turnAxis) {
    //Assign variables to the joysticks
    double throttleStick = throttle.getRawAxis(throttleAxis);
    double turnStick = turn.getRawAxis(turnAxis);

    //Create the deadband for the joysticks.
    //This is necessary becase the xbox controllers joysticks drift.
    Deadband(throttleStick);
    Deadband(turnStick);

    //Bind the slave motors to the master motors
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);
    
    //Calculate motor power
    double leftThrottle = throttleStick + turnStick;
    double rightThrottle = throttleStick - turnStick;

    //Assign the values to the motors
    leftMaster.set(ControlMode.PercentOutput, leftThrottle);
    rightMaster.set(ControlMode.PercentOutput, rightThrottle);

    return;
  }

  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
