# 3882 Beach Blitz
Code for Beach Blitz

# Subsytems
- Example
    - Motors (Type, MotorController, ID's) (Link)
    - Type
 - Shooter
    - Falcon 500 (2) - w/ TalonFX (https://store.ctr-electronics.com/falcon-500-powered-by-talon-fx/?srsltid=AfmBOopew5SBg2EtIwf_ElOSiSPYgvw4FTArOXobZYlTW48P1Q2gk_Og)
 - Intake
    - Falcon 500 (1) - w/ TalonFX (https://store.ctr-electronics.com/falcon-500-powered-by-talon-fx/?srsltid=AfmBOopew5SBg2EtIwf_ElOSiSPYgvw4FTArOXobZYlTW48P1Q2gk_Og)
 - Climber
    - NEO Motor Brushless (2) (https://www.revrobotics.com/rev-21-1650/)
        - w/ CAN Spark MAX (2) (https://www.revrobotics.com/rev-11-2158/)
 - Pivot
    - NEO Motor Brushless (1) (https://www.revrobotics.com/rev-21-1650/)
        -w/ CAN Spark Max (1) (https://www.revrobotics.com/rev-11-2158/)
 - Elevator
    - NEO Vortex (1) (https://www.revrobotics.com/rev-21-1652/)
        - w/ Spark FLEX (1) (https://www.revrobotics.com/rev-11-2159/)
 - Feeder
    - 775 Pro (1) (https://www.vexrobotics.com/775pro.html)
        - w/ TalonSRX (1) (https://store.ctr-electronics.com/talon-srx/)
    - Linebreak Sensor(https://www.adafruit.com/product/2168)
 - Swerve
    - - Kraken X60 (4) - w/TalonFX (https://store.ctr-electronics.com/kraken-x60/?srsltid=AfmBOor8gJLXZfNRQd3FQh5aWSDHC9i9Dy31JsVEJrCqMMtga1vjYfOE) 
    - - Falcon 500 (4) - w/ TalonFX (https://store.ctr-electronics.com/falcon-500-powered-by-talon-fx/?srsltid=AfmBOopew5SBg2EtIwf_ElOSiSPYgvw4FTArOXobZYlTW48P1Q2gk_Og)

Sensors
- Line Break (https://www.adafruit.com/product/2168)
- Pidgeon (https://store.ctr-electronics.com/pigeon-2/)

Other Devices
- Canivore (https://store.ctr-electronics.com/canivore/?srsltid=AfmBOoqX8jT-_6fvp3mNwteccb0lJ9VdAZm49JndbMDarxtyyLFkmpIo)

## Complex Commands
Intake (Intake,Feeder,Pivot,Elevator)
    - Intake / Feeder on till Linebreak
    - Pivot and Elevator to set position

Outtake
    Outtake (intake,Feeder)


Shoot Command(Shooter, Feeder, Pivot, Elevator)
    Basic - (Feeder,shooter,Pivot)
    LL 


Controls

Driver
    - Swerve
    - Intake
    - Outtake
    - Shoot
    - AMP Score
    - Pivot Positions
    - Pivot Manual

Operator
    - Climber
    - Elevator Positions
        - Bottom Shot
        - Upper Shot
    - Elevator Manual

Xbox
    - Swerve : Left Joystick
    - A : Position
    - B : Position
    - X : Position
    - Y : Position
    - RB : Intake
    - RT : Shoot
    - LB : Outtake
    - LT : Outtake Amp
    - DPad - Up/Down Pivot

Joystick



Testing Procedure
    Get Limits
        Phoenix Tuner / Rev
        1. Set Motors to Coast mode
        2. Figure out Home(0) Position
        3. Set Encoder to 0
        4. Move Pivot / Elevator to Max Position
        5. Check if it is going Positive or Negative
        5. Record Encoder Count
        6. Repeat 3x take the *lowest value
        7 Set Max Limit Variable

Assumptions
    - Pivot goes positive to max
    - Elevator goes Negative to max


What we gotta do

Set Motor ID'S / Update Motors
Get Limits
Test Each Subsystem
Test Complex Commands
    - Shoot
    Test LED
        BEFORE YOU DO THIS get the Encoder value for Pivot and ELEVATOR
    - Intake
    - AMP Position
Calibrate Swerve
Merge new SWERVE with this code
Create a setField Orientation command
//NamedCommands.registerCommand("setFieldRelative",drivetrain.runOnce(() ->  drivetrain.seedFieldRelative()));

CHASE
Drive around make sure Swerve works
Intake
    - Intake normal
    - Intake agaisnt a wall
    - Shoot Agaisnt the subwoofer
    - Scoring the AMP
    - Shooting with the Elevator up
    - Climbing
Auto
    - 1 Note
    - 4 note
    - Outside
    - Defence

Other Things
    - Get backup motors ready
    - get backup Radio / Roborio ready