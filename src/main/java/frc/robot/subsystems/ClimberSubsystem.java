// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimberConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubsystem extends SubsystemBase { 
  private CANSparkMax m_climber;
  private CANSparkMax m_climber2;
  private SparkPIDController c_pidController;
  private SparkPIDController c_pidController2;

  private RelativeEncoder c_encoder;
  private RelativeEncoder c_encoder2;

  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput, maxRPM;

  /** Creates a new ClimberSubsystem. */
  public ClimberSubsystem() {
    m_climber = new CANSparkMax(ClimberConstants.climberID, MotorType.kBrushless);
    m_climber2 = new CANSparkMax(ClimberConstants.climber2, MotorType.kBrushless);


    m_climber.restoreFactoryDefaults();
    m_climber.setIdleMode(IdleMode.kBrake);

    m_climber2.restoreFactoryDefaults();
    m_climber2.setIdleMode(IdleMode.kBrake);


    /**
       * In order to use PID functionality for a controller, a SparkPIDController object
       * is constructed by calling the getPIDController() method on an existing
       * CANSparkMax object
       */
    c_pidController = m_climber.getPIDController();
    c_pidController2 = m_climber2.getPIDController();
  
     // Encoder object created to display position values
     c_encoder = m_climber.getEncoder();
     c_encoder2 = m_climber2.getEncoder();

  
     // PID coefficients
     kP = 0.03; 
     kI = 0;
     kD = 0; 
     kIz = 0; 
     kFF = 0.000015; 
     kMaxOutput = 1; 
     kMinOutput = -1;
     maxRPM = 5700;
  
 // Setting PID coefficients
     c_pidController.setP(kP);
     c_pidController.setI(kI);
     c_pidController.setD(kD);
     c_pidController.setIZone(kIz);
     c_pidController.setFF(kFF);
     c_pidController.setOutputRange(kMinOutput, kMaxOutput);

     c_pidController2.setP(kP);
     c_pidController2.setI(kI);
     c_pidController2.setD(kD);
     c_pidController2.setIZone(kIz);
     c_pidController2.setFF(kFF);
     c_pidController2.setOutputRange(kMinOutput, kMaxOutput);
  
  }
  private void resetEnc()
  {
    c_encoder.setPosition(0);
    c_encoder2.setPosition(0);

  }
  
  private void setVelocity(double setPoint)
  {
    m_climber.set(-setPoint);
    m_climber2.set(-setPoint);
   SmartDashboard.putNumber("Right Drive Encoder", c_encoder.getPosition());
   SmartDashboard.putNumber("Left Drive Encoder", c_encoder2.getPosition());

  }
  
  private void setPosition(double setPoint)
  {
    c_pidController.setReference(setPoint, CANSparkMax.ControlType.kPosition);
    c_pidController2.setReference(setPoint, CANSparkMax.ControlType.kPosition);

  }
  
  public Command withVelocity(double setPoint)
  {
    return runOnce(() -> this.setVelocity(setPoint));
  }
  
  public Command slowUp()
  {
    return run(() -> this.setVelocity(.8));
  }
  
  public Command slowDown()
  {
    return run(() -> this.setVelocity(-.1));
  }
  
  public Command stop()
  {
    return run(() -> this.setVelocity(0));
  }
  
  public Command withPosition(double setPoint)
  {
    return run(() -> this.setPosition(setPoint));
  }
  
  public Command setHomePosition()
  {
    return run(() -> this.setPosition(ClimberConstants.cHomePos)); 
  }
  
  public Command setUpPosition()
  {
    return run(() -> this.setPosition(-ClimberConstants.cUpPose)); 
  }
  
  public Command ClimbedPosition()
  {
    return run(() -> this.setPosition(-ClimberConstants.cClimbPos)); 
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  SmartDashboard.putNumber("Climber1 Pivot Encoder", c_encoder.getPosition());
  SmartDashboard.putNumber("Climber2 Pivot Encoder", c_encoder2.getPosition());
  }
  
  }

