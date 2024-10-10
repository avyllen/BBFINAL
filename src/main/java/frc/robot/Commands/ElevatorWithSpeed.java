// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorWithSpeed extends Command {
  /** Creates a new ElevatorWithSpeed. */
  private final ElevatorSubsystem elevator;
  private double speed;

  public ElevatorWithSpeed(ElevatorSubsystem elevator,double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.elevator = elevator;
    addRequirements(elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    elevator.setVelocity(speed);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return elevator.LimitChecks();
  }
   // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    elevator.setVelocity(0);
  }

}
