# 3882 Beach Blitz
Code for Beach Blitz

# Subsytems
- Intake
	- Motors (Type, MotorController, ID's) (Link)
- Shooter
	 - Motors
- Feeder
	- Motors
- Climber
	- Motors
- Pivot
	- Motors
- Elevator
	- Motors
- Swerve
	 - Motors

Sensors
- Line Break (Link to product)
- Pidgeon (Link to Product)

Other Devices
- Canivor (Link To Product)

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