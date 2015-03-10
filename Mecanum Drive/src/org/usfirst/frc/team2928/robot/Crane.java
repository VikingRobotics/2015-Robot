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

public class Crane 
{
	CANTalon lift;
	JoystickButton up;
	JoystickButton down;


	public Crane(CANTalon lift)
	{
		this.lift = lift;
	}
    

	public void lift(Joystick otherStick, int upPort, int downPort, int stopPort)
	{
		JoystickButton thing = new JoystickButton(otherStick, upPort);
		JoystickButton thing2 = new JoystickButton(otherStick, downPort);
		JoystickButton thing3 = new JoystickButton(otherStick, stopPort);
		
		this.up = thing;
		this.down = thing2;
			
		while(this.up.get())
		{
			lift.set(1);
			return;
		}
		
		lift.set(0);
		
		while(this.down.get())
		{
			lift.set(-1);
			return;
		}
		
		lift.set(0);
	}


	public void specialArm(Solenoid s1, Solenoid s2)
	{
		s1.set(!s1.get());
		s2.set(!s2.get());
	}


}
