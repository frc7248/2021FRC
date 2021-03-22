// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  private final CANSparkMax leftMaster = new CANSparkMax(0, MotorType.kBrushless);
  private final CANSparkMax rightSlave = new CANSparkMax(1, MotorType.kBrushless);
  private final CANSparkMax leftSlave = new CANSparkMax(2, MotorType.kBrushless);
  private final CANSparkMax rightMaster = new CANSparkMax(3, MotorType.kBrushless);
  private final DifferentialDrive drivetrain = new DifferentialDrive(leftMaster, rightMaster);



  // drive train speed, set to 0.x for X% speed
  private final double drivetrainMultiplier = 1.0;


  /** Creates a new DriveTrain. */
  public DriveTrain() {
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void manualControl(double rawAxis, double rawAxis2) {
    drivetrain.tankDrive(rawAxis * drivetrainMultiplier, rawAxis2 * drivetrainMultiplier);

  }
}
