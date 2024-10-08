// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
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
 //public final IntakeSubsystem intake = new IntakeSubsystem();

  //shooter Subsystem
  public final ShooterSubsystem shooter = new ShooterSubsystem();

  //Feeder Subsystem
  public final FeederSubsystem feeder = new FeederSubsystem();

  //pivot Subsystem
  //public final PivotSubsystem pivot = new PivotSubsystem();
  //public final PivotwithSpeed pivotup = new PivotwithSpeed(pivot,.1);
  //public final PivotwithSpeed pivotdown = new PivotwithSpeed(pivot,-.1);

  //ELEVATOR
  //public final ElevatorSubsystem elevator = new ElevatorSubsystem();

  //Climber
  //public final ClimberSubsystem climber = new ClimberSubsystem();

  //LED
  private final LEDSubsystem led = new LEDSubsystem(1);

  //Complex Commands
  TELEShootCommand  teleShootCommand = new TELEShootCommand(shooter,feeder,led);

  
  public RobotContainer() {    
    configureBindings();
  }

  private void configureBindings() {

    //Swerve Stuff


    //Default Commands
    shooter.setDefaultCommand(shooter.withDisable());
    feeder.setDefaultCommand(feeder.withDisable());
    //intake.setDefaultCommand(intake.withDisable());
    //pivot.setDefaultCommand(pivot.holdPosition());
    //elevator.setDefaultCommand(elevator.holdPosition());
    //climber.setDefaultCommand(climber.stop());



    //Drive Controls
    xbox.rightTrigger().onTrue(teleShootCommand); //Shoot
    //Intake
    //Outtake
    //AmpOuttake
    //Pivot Up
    //Pivot Down
    //Positions
    //Lock Wheels?
    //Set Field Orientation

    //Operator Controls
    //Climb Set Up
    //Climb All the way
    //Elevator Up
    //Elevator Down
    //Elevator Manual up
    //Elevator Manual Down

    

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
