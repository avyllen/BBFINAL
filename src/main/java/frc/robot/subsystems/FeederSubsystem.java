// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix6.controls.NeutralOut;
import com.ctre.phoenix6.controls.VelocityVoltage;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FeederConstants;

public class FeederSubsystem  extends SubsystemBase{
 
private final WPI_TalonSRX  m_feeder;

private final VelocityVoltage m_voltageVelocity = new VelocityVoltage(0, 0, true, 0, 0, false, false, false);

private final DigitalInput intakeLine;
private final DigitalOutput outLine;

Encoder encoder;

private ShuffleboardTab tab = Shuffleboard.getTab("Feeder");
private GenericEntry feederSpeed =
      tab.add("Feeder Speed", 0)
         .getEntry();
private GenericEntry feederVoltage =
      tab.add("Feeder Voltage", 0)
         .getEntry();

    
public FeederSubsystem()
{
       m_feeder = new WPI_TalonSRX(FeederConstants.feederID);
       intakeLine = new DigitalInput(0);
       outLine = new DigitalOutput(1); 

}

public boolean noteCheck()
{
  return !intakeLine.get();
}

public void disable()
{
    m_feeder.set(0);
}

public void setVelocity(double desiredRotationsPerSecond)
{
    m_feeder.set(desiredRotationsPerSecond);
}

public void intake()
{
    m_feeder.set(FeederConstants.IntakeSPEED);
}

public void outtake()
{
    m_feeder.set(FeederConstants.OutakeSPEED);
}

public Command intakeCommand()
{
  return run(() -> this.intake());
}

public Command outtakeCommand()
{
  return run(() -> this.outtake());
}

public Command ampoOuttakeCommand()
{
  return run(() -> this.setVelocity(FeederConstants.ampOutakeSPEED));
}

public Command withVelocity(double desiredRotationsPerSecond)
{
  return run(() -> this.setVelocity(desiredRotationsPerSecond));
}

public Command withDisable()
{
    return run(() -> this.disable());
}

@Override
public void periodic() {
  // This method will be called once per scheduler run
SmartDashboard.putBoolean("FEEDER NOTE CHECK", intakeLine.get());
feederVoltage.setDouble(m_feeder.getMotorOutputVoltage());
feederSpeed.setDouble(m_feeder.getMotorOutputPercent());
outLine.set(true);
}
}
