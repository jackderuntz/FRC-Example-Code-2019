/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  //Motor Controllers
  //Start motor controllers at CAN ID 11 so that the CAN values are organized

  //DriveTrain (All use CAN)
  public static int leftMaster = 11;
  public static int leftSlave = 12;
  public static int rightMaster = 13;
  public static int rightSlave = 14;
  //For Prototyping purposes (All use CAN)
  public static int spareOne = 15;
  public static int spareTwo = 16;
  //Pneumatics Controller
  public static int PCM = 3;
  //Solenoids (Fill them in as you go)
  public static int leftShifter = 1;
  public static int rightShifter = 2;

  


}
