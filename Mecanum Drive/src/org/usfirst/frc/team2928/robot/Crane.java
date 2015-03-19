package org.usfirst.frc.team2928.robot;import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Timer;

public class Crane {
	
	CANTalon lift;
	JoystickButton up;
	JoystickButton down;
	public Crane(CANTalon lift)
	{
		this.lift = lift;
		
	}
	public void up(double someValue)
	{
		
		
		if(someValue>.5)
		{
			lift.set(.85);
			
		}
		else
		{
		
		lift.set(0);	
		}
		
		
	}
	public void down(double someValue)
	{
		lift.set(0);
		if(someValue<-.5)
		{
		lift.set(-.75);
			
			
		}
		else
		{
		
		lift.set(0);
		}
	}
	public void specialArmOpen(Solenoid s0, Solenoid s4)
	{
		s0.set(true);
		s4.set(false);
	}
	public void specialArmClosed(Solenoid s0, Solenoid s4)
	{
		s0.set(false);
		s4.set(true);
	
	}
	

}
