package org.usfirst.frc.team2928.robot;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends SampleRobot {
	RobotDrive robotDrive;
	Joystick stick;
	Joystick otherStick;
	Joystick anotherStick; //kale's thing
	// Channels for the wheels
	//Compressor compressor = new Compressor();

	final CANTalon frontLeftChannel = new CANTalon(14);//Drive Talons
	final CANTalon rearLeftChannel	= new CANTalon (15);//Encoders 14 and 15 move backwards, 0 and 1 move forward
	final CANTalon frontRightChannel = new CANTalon (1);
	final CANTalon rearRightChannel = new CANTalon (0);
	final CANTalon leftLifter = new CANTalon(13);//Stacker Talons
	final CANTalon rightLifter = new CANTalon(2);
	final CANTalon craneTalon = new CANTalon(5);
	final CANTalon brentCrane = new CANTalon(10);
	final Talon talon1 = new Talon(0);//Intake Talons
	final Talon talon2 = new Talon(1);

	final Solenoid s0 = new Solenoid(0); //r intake open 
	final Solenoid s1 = new Solenoid(1); //r intake close
	final Solenoid s2 = new Solenoid(2); //r stacker open
	final Solenoid s3 = new Solenoid(3); //r stacker close
	final Solenoid s4 = new Solenoid(4); //l intake open
	final Solenoid s5 = new Solenoid(5); //l intake close
	final Solenoid s6 = new Solenoid(6); //l stacker open
	final Solenoid s7 = new Solenoid(7); //l stacker close
	
	

	
	
	JoystickButton down = new JoystickButton(otherStick,2);//Crane up
	JoystickButton up = new JoystickButton(otherStick,3);//Crane down

	final Intake i = new Intake(talon1, talon2);
	final Crane crane = new Crane(craneTalon);
	
	// The channel on tfhe driver station that the joystick is connected to
	final int joystickChannel	= 0;
	final int otherJoystickChannel = 1;
	final int anotherJoystickChannel = 3;
		
	double frontLeftVoltage;
	double rearLeftVoltage;
	double frontRightVoltage;
	double rearRightVoltage;
	public Robot() {
		//Button halfSpeed = new Button(7);
		robotDrive = new RobotDrive(frontLeftChannel, rearLeftChannel, frontRightChannel, rearRightChannel);
		// you may need to change or remove this to match your robot
		stick = new Joystick(joystickChannel);
		otherStick= new Joystick(otherJoystickChannel);
		anotherStick = new Joystick(anotherJoystickChannel);
		//	compressor.start();
}
	/*** Runs the motors with Mecanum drive.
	 */
	public void autonomous()
	{
		Timer timer = new Timer();
		timer.start();
		
		while(isAutonomous() && isEnabled())
		{	
			while(timer.get() < 3.5)
			{
			
			frontLeftChannel.set(-.5);
			frontRightChannel.set(-.5);
			rearLeftChannel.set(-.5);
			rearRightChannel.set(-.5);
			}
		
			frontLeftChannel.set(0);
			frontRightChannel.set(0);
			rearLeftChannel.set(0);
			rearRightChannel.set(0);
		}
		}

	
	public void operatorControl() {
		
		
		robotDrive.setSafetyEnabled(true);
		while (isOperatorControl() && isEnabled()) {
			
			System.out.println(leftLifter.getAnalogInPosition());
			System.out.println(rightLifter.getAnalogInPosition());
			
			double robotSpeedFL = stick.getY();
			double robotAngleFL = stick.getZ();
			double robotStrafeFL = stick.getX();
			frontLeftVoltage =robotSpeedFL*Math.sin(robotAngleFL+(Math.PI/4)+robotStrafeFL);
			rearLeftVoltage = robotSpeedFL*Math.cos(robotAngleFL+(Math.PI/4)+robotStrafeFL);
			frontRightVoltage = robotSpeedFL*Math.cos(robotAngleFL+(Math.PI/4)-robotStrafeFL);
			rearRightVoltage = robotSpeedFL*Math.sin(robotAngleFL+(Math.PI/4)-robotStrafeFL);


//solenoidSwitch(new Joystick(0), s1);

			Timer.delay(.05);
			i.takeInTote(otherStick, s0,s1, s4,s5);
			GetStackt stack = new GetStackt(leftLifter, rightLifter,s2,s3,s6,s7, leftLifter.getAnalogInPosition(), rightLifter.getAnalogInPosition());
			stack.Stack(otherStick, stick, 3,2,6,7, 8, 11);
			//TODO: brent device, bind fred arms to pot, button 4
			JoystickButton b1 = new JoystickButton(anotherStick, 5);//lifter up
			JoystickButton b2 = new JoystickButton(anotherStick, 10);//lifter down
			JoystickButton b3 = new JoystickButton(anotherStick, 11);//lvl 1
			JoystickButton b4 = new JoystickButton(anotherStick, 3);//lvl 2
		    JoystickButton b5 = new JoystickButton(anotherStick, 9);//toggle
			JoystickButton b6 = new JoystickButton(anotherStick, 2);//lvl 3
			JoystickButton b7 = new JoystickButton(anotherStick, 4);//???
			if(b5.get())
			{
				
				stack.unclamp();
			
			}
			else if(!b5.get())
			{
				stack.clamp();
				
			}
			if(b2.get())
			{
				stack.up();
			}
			else if(b1.get())
			{
				stack.down();
			}
			if(b3.get())
			{
				stack.Level1();
			}
			
			if(b4.get())
			{
				stack.Level2();
			}
			
			if(anotherStick.getTrigger())
			{
				stack.Level3();
			}
			
			if(b6.get())
			{
				stack.Level4();
			}


			if((stick.getX() > .2 || stick.getX()< -.2) || (stick.getY()>.2 || stick.getY() <-.2) || (stick.getZ()>.35 || stick.getZ() <-.35))
			{
				frontLeftChannel.set(frontLeftVoltage);
				rearLeftChannel.set(rearLeftVoltage);
				frontRightChannel.set(frontRightVoltage);
				rearLeftChannel.set(rearLeftVoltage);
				//if(stick.GetRawButton(halfSpeed) == true;)
				// Use the joystick X axis for lateral movement, Y axis for forward movement, and Z axis for rotation.
				// This sample does not use field-oriented drive, so the gyro input is set to zero.
				//Z and X are inverted because the joystick is stupid.
				double pt1 = Math.pow(stick.getZ() ,3);
				double pt1x = Math.pow(stick.getX(), 3);
				double pt1y = Math.pow(stick.getY(), 3);
				double pt2 = (3.25/5)*(pt1);
				double pt2y =(4.0/5)*(pt1y);
				double pt2x = (4.0/5)*(pt1x);
				double fixedX =0;
				double fixedY =0;
				double fixedZ = 0;
				if(stick.getZ()<-.35)
				{
					fixedZ =pt2-.35;
				}
				
				if(stick.getZ()>.35)
				{
					fixedZ =pt2 +.35;
				}
				
				if(stick.getX()>.3)
				{
					fixedX = pt2x+.2;
				}
				
				if(stick.getX()<-.2)
				{
					fixedX = pt2x-.2;
				}
				
				if(stick.getY()>.3)
				{
					fixedY = pt2y+.2;
				}
				
				if(stick.getY()<-.2)
				{
					fixedY= pt2y-.2;
				}
				
				//System.out.println(anotherStick.getY());
				//System.out.println(anotherStick.getX());
				

				robotDrive.mecanumDrive_Cartesian(-fixedX, -fixedY,-fixedZ , 0);
				
			}
			
			Timer.delay(0.005);	// wait 5ms to avoid hogging CPU cycles
		}	
	}
}	