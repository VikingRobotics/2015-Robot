package org.usfirst.frc.team2928.robot;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;

public class GetStackt {
	 int level=1;
	 Solenoid s2;
	 Solenoid s3;
	 Solenoid s6;
	 Solenoid s7;
	 CANTalon leftAnalog;
	 CANTalon rightAnalog;
	 CANTalon t1;
	 CANTalon t2;
	 boolean  toggled = false;
	 
	 private static final int LEFT_ANAL_1 =574;
	 private static final int LEFT_ANAL_2 = 555;
	 private static final int LEFT_ANAL_3 = 362;
	 private static final int LEFT_ANAL_4 = 473;
	 int RIGHT_ANAL_1 = 578;
	 int RIGHT_ANAL_2 = 555;
	 int RIGHT_ANAL_3 = 370;
	 int RIGHT_ANAL_4 = 478;
	 
	JoystickButton b1;
	JoystickButton b2;
		
	JoystickButton b3;
	JoystickButton b4;
	JoystickButton b5;
	JoystickButton b6;
	public GetStackt(CANTalon t1, CANTalon t2, Solenoid s2, Solenoid s3, Solenoid s6, Solenoid s7, CANTalon leftAnalog, CANTalon rightAnalog)
	{
		//t1.setFeedbackDevice(AnalogPot());
	
		this.s2 = s2;
		this.s3 = s3;
		this.s6 = s6;
		this.s7 = s7;
		this.leftAnalog = leftAnalog;
		this.rightAnalog = rightAnalog;
		this.t1=t1;
		this.t2=t2;
	}
	
	public void Stack(Joystick otherStick, Joystick stick, int num1, int num2, int num3, int num4, int num5, int num6)
	{
		this.b1 = new JoystickButton(otherStick,num1);
		this.b2 = new JoystickButton(otherStick,num2);
		
		this.b3 = new JoystickButton(otherStick, num3);
		this.b4 = new JoystickButton(otherStick, num4);
		this.b5 = new JoystickButton(otherStick, num5);
		this.b6 = new JoystickButton(otherStick, num6);
	
		while(b1.get())
		{
			t2.set(.25);
			t1.set(-.25);
			return;
		}
		t2.set(0);
		t1.set(0);
		
		while(b2.get())
		{
			t2.set(-.25);
			t1.set(.25);
			return;
		}
		t2.set(0);
		t1.set(0);
		
	}

	public void ComparePos(CANTalon t2, CANTalon t1, CANTalon pos, int presetPos)
	{
		int currentPos = pos.getAnalogInPosition();
		double speed;
		if(toggled)
		{
			speed = 0.5;
		}
		else
		{
			speed = 0.75;
		}
		if(currentPos <presetPos )
		{
			speed = -speed;
			
		}
		t2.set(speed);
		t1.set(speed);
	}
	
	public void Level1()
	{		
		this.ComparePos(t2, t1, this.leftAnalog, LEFT_ANAL_1);
		this.ComparePos(t2, t1, this.rightAnalog, RIGHT_ANAL_1);
		
	}
			
		public void Level2()
		{
			this.ComparePos(t2, t1, this.leftAnalog, LEFT_ANAL_2);
			this.ComparePos(t2, t1, this.rightAnalog, RIGHT_ANAL_2);
				
		}
		
		public void Level3()
		{
			this.ComparePos(t2, t1, this.leftAnalog, LEFT_ANAL_3);
			this.ComparePos(t2, t1, this.rightAnalog, RIGHT_ANAL_3);
		}
		
		
		public void Level4()
		{
			this.ComparePos(t2, t1, this.leftAnalog, LEFT_ANAL_4);
			this.ComparePos(t2, t1, this.rightAnalog, RIGHT_ANAL_4);
		}			

		
		public void clamp()
		{
			toggled = true;
			s3.set(true);
			s2.set(false);
			s6.set(false);
			s7.set(true);
			
		}
		
		
		public void unclamp()
		{ 
			toggled = false;
			s3.set(false);
			s2.set(true);
			s6.set(true);
			s7.set(false);	
		}
		
		
		public void up()
		{
			if(toggled)
			{
			t1.set(.5);
			t2.set(.5);
			}
			else{
			t1.set(.75);
			t2.set(.75);
			}
		}
		
		
		public void down()
		{
			if(toggled)
			{
				t1.set(-.5);
				t2.set(-.5);
			}
			else
			{
				t1.set(-.75);
				t2.set(-.75);
			}
		}

}
		
	
	

/*	
	while(level == 1 )
		{
			while(b5.get())
			{
				//Toggle
				s3.set(!s3.get());
				s2.set(!s2.get());
				s6.set(!s6.get());
				s7.set(!s7.get());
				return;
			}
			return;
		
			

		}
	while(level == 2)
	{
		s3.set(true);
		s2.set(false);
		s6.set(false);
		s7.set(true);
		return;
	}
		while(level == 3 || level == 4)
		{
			while(b5.get())
			{
				//Toggle 
				s3.set(!s3.get());
				s2.set(!s2.get());
				s6.set(!s6.get());
				s7.set(!s7.get());
				return;
			}
	
			return;
		
		}
		
		
		if(b1.get())
		{
			level = 1;
			
			s3.set(false);
			s2.set(true);
			s6.set(true);
			s7.set(false);
		}
		
		if(b2.get())
		{
			level = 2;
		}
		
		if(b3.get())
		{
			level =3;
			s3.set(true);
			s2.set(false);
			s6.set(false);
			s7.set(true);
		}
		
		if(b4.get())
		{
			level =4;
			s3.set(true);
			s2.set(false);
			s6.set(false);
			s7.set(true);
		}*/