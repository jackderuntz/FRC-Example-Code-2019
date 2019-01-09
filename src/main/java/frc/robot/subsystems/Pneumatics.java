/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 This is the pneumatics class. if you do not change the PCM CAN ID,
 then you do not need to configure it at all.
 */
public class Pneumatics extends Subsystem {
  //Create the solenoids for the shifter
  public DoubleSolenoid leftShifter = new DoubleSolenoid(1,2);
  public DoubleSolenoid rightShifter = new DoubleSolenoid(3,4);
  //Create solenoids for prototypes
  public DoubleSolenoid protoOne = new DoubleSolenoid(5, 6);
  public DoubleSolenoid protoTwo = new DoubleSolenoid(7, 8);

  public boolean shift = true;

  public void shiftDriveTrain(){

    if(shift = true){
      leftShifter.set(DoubleSolenoid.Value.kForward);
      rightShifter.set(DoubleSolenoid.Value.kForward);
      shift = false;
    }
    else{
      leftShifter.set(DoubleSolenoid.Value.kReverse);
      rightShifter.set(DoubleSolenoid.Value.kReverse);
      shift = true;
    }

  }





  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
