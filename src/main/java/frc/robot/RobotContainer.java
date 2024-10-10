// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.ElevatorWithSpeed;
import frc.robot.Commands.IntakeCommand;
import frc.robot.Commands.PivotwithSpeed;
import frc.robot.Commands.TELEShootCommand;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.FeederSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LEDSubsystem;
import frc.robot.subsystems.PivotSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class RobotContainer {

  //Controls
  private final CommandXboxController xbox = new CommandXboxController(0); 
  private final CommandJoystick joystick = new CommandJoystick(1);

 //intake Subsystem
 public final IntakeSubsystem intake = new IntakeSubsystem();

  //Shooter Subsystem
  public final ShooterSubsystem shooter = new ShooterSubsystem();

  //Feeder Subsystem
  public final FeederSubsystem feeder = new FeederSubsystem();
  //Elevator Subsystem
  public final ElevatorSubsystem elevator = new ElevatorSubsystem();
  public final ElevatorWithSpeed elevatorUp = new ElevatorWithSpeed(elevator, .1);
  public final ElevatorWithSpeed elevatorDown = new ElevatorWithSpeed(elevator, -.1);

  //pivot Subsystem
  public final PivotSubsystem pivot = new PivotSubsystem();
  public final PivotwithSpeed pivotUp = new PivotwithSpeed(pivot,.1);
  public final PivotwithSpeed pivotDown = new PivotwithSpeed(pivot,-.1);

  //Climber SUBSYSTEM
  public final ClimberSubsystem climber = new ClimberSubsystem();

  //LED SUBSYSTEM
  private final LEDSubsystem led = new LEDSubsystem(1);

  //Complex Commands
  TELEShootCommand  teleShootCommand = new TELEShootCommand(shooter,feeder,led);
  IntakeCommand intakeCommand = new IntakeCommand(intake, feeder, led, pivot, elevator);


  
  public RobotContainer() {    
    configureBindings();
  }

  private void configureBindings() {

    //Swerve Stuff


    //Default Commands
   // shooter.setDefaultCommand(shooter.withDisable());
    feeder.setDefaultCommand(feeder.withDisable());
    intake.setDefaultCommand(intake.withDisable());
    pivot.setDefaultCommand(pivot.holdPosition());
    elevator.setDefaultCommand(elevator.holdPosition());
    //climber.setDefaultCommand(climber.stop());



    //Drive Controls
    
    //Shoot
    xbox.rightTrigger().onTrue(teleShootCommand); 
    //Intake
    xbox.rightBumper().onTrue(intakeCommand);
    //Outtake
    xbox.leftBumper().whileTrue(new ParallelCommandGroup(intake.outtakeCommand(),feeder.outtakeCommand(),pivot.intakePositionCommand()));
    //AmpOuttake
    //Pivot Up
    xbox.pov(0).whileTrue(pivotUp);
    //Pivot Down
    xbox.pov(180).whileTrue(pivotDown);
    //Positions
    xbox.y().onTrue(pivot.intakePositionCommand());
    xbox.a().onTrue(pivot.subwooferPositionCommand());
    //Lock Wheels?
    //Set Field Orientation

    //Operator Controls
    // //Climb Set Up
    // joystick.button(5).onTrue(climber.setUpPosition());
    // //Climb All the way
    // //Elevator Position Up
    // joystick.button(3).onTrue(elevator.setUpPosition());
    // //Elevator Position Down
    // joystick.button(4).onTrue(elevator.setHomePosition());
    // //Elevator Manual Up
    // joystick.pov(0).whileTrue(elevatorUp);
    // //Elevator Manual Down
    // joystick.pov(180).whileTrue(elevatorDown); 
    // ** !!HAS TO BE TESTED!! ** //

    

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
