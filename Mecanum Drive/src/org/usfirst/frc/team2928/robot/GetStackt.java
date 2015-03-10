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
	 int leftAnalPos;
	 int rightAnalPos;
	 CANTalon t1;
	 CANTalon t2;
	 boolean  toggled = false;
	 
	 int leftAnal1 =574;
	 int leftAnal2 = 555;
	 int leftAnal3 = 362;
	 int leftAnal4=473;
	 int rightAnal1 = 578;
	 int rightAnal2 = 555;
	 int rightAnal3 = 370;
	 int rightAnal4 = 478;
	 
	JoystickButton b1;
	JoystickButton b2;
		
	JoystickButton b3;
	JoystickButton b4;
	JoystickButton b5;
	JoystickButton b6;
	public GetStackt(CANTalon t1, CANTalon t2, Solenoid s2, Solenoid s3, Solenoid s6, Solenoid s7, int leftAnalPos, int rightAnalPos)
	{
		//t1.setFeedbackDevice(AnalogPot());
	
		this.s2 = s2;
		this.s3 = s3;
		this.s6 = s6;
		this.s7 = s7;
		this.leftAnalPos = leftAnalPos;
		this.rightAnalPos = rightAnalPos;
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

	
		public void Level1(){
	
		
			
		if(leftAnalPos < leftAnal1){
				while(leftAnalPos < leftAnal1)
				{
				while(leftAnalPos < leftAnal1){
					if(toggled){
						t2.set(-.5);
						t1.set(-.5);
						}
					else
					{
						t2.set(-.75);
						t1.set(-.75);
					}
						return;
					}
					
				return;
			}
		}
			
			if(leftAnalPos > leftAnal1){
				while(leftAnalPos > leftAnal1)
				{
					while(leftAnalPos > leftAnal1){
						t2.set(.75);
						t1.set(.75);
						return;
					} 
					return;
				}
				
			if(rightAnalPos < rightAnal1){
				while(rightAnalPos < rightAnal1)
				{
					while(rightAnalPos < rightAnal1){
						if(toggled){
							t2.set(-.5);
							t1.set(-.5);
							}
						else
						{
							t2.set(-.75);
							t1.set(-.75);
						}
						return;
					}
					return;
				}
					
			}
				
			
			
			if(rightAnalPos > rightAnal1){
					while(leftAnalPos > leftAnal1)
					{
						while(rightAnalPos > rightAnal1){
							t2.set(.75);
							t1.set(.75);
							return;
						}
						return;
					}
				
			}
		}
		}
			
		public void Level2(){
		
				if(leftAnalPos < leftAnal2){
					while(leftAnalPos < leftAnal2)
					{
						while(leftAnalPos < leftAnal2){
							if(toggled){
								t2.set(-.5);
								t1.set(-.5);
								}
							else
							{
								t2.set(-.75);
								t1.set(-.75);
							}
							return;
						}
						return;
					}
					
				}
				
				if(leftAnalPos > leftAnal2){
					while(leftAnalPos > leftAnal2)
					{
						while(leftAnalPos > leftAnal2){
							t2.set(.75);
							t1.set(.75);
							return;
						}
						return;
					}
					
				if(rightAnalPos < rightAnal2){
					while(rightAnalPos < rightAnal2)
					{
						while(leftAnalPos < leftAnal1){
							if(toggled){
								t2.set(-.5);
								t1.set(-.5);
								}
							else
							{
								t2.set(-.75);
								t1.set(-.75);
							}
							return;
						}
						return;
					}
						
				}
					
				if(rightAnalPos > rightAnal2){
						while(leftAnalPos > leftAnal2)
						{
							while(leftAnalPos > leftAnal1){
								t2.set(.75);
								t1.set(.75);
								return;
							}
							return;
						}
					}
				}
			}
		
		public void Level3(){
		
			if(leftAnalPos < leftAnal3){
				while(leftAnalPos < leftAnal3)
				{
					while(leftAnalPos < leftAnal3){
						if(toggled){
							t2.set(-.5);
							t1.set(-.5);
							}
						else
						{
							t2.set(-.75);
							t1.set(-.75);
						}
						return;
					}
					return;
				}
				
			}
			
			if(leftAnalPos > leftAnal3){
				while(leftAnalPos > leftAnal3)
				{
					while(leftAnalPos > leftAnal3){
						t2.set(.75);
						t1.set(.75);
						return;
					}
					return;
				}
				
			if(rightAnalPos < rightAnal3){
				while(rightAnalPos < rightAnal3)
				{
					while(leftAnalPos < leftAnal3){
						if(toggled){
							t2.set(-.5);
							t1.set(-.5);
							}
						else
						{
							t2.set(-.75);
							t1.set(-.75);
						}
						return;
					}
					return;
				}
					
			}
				
			if(rightAnalPos > rightAnal3){
					while(leftAnalPos > leftAnal3)
					{
						while(leftAnalPos > leftAnal3){
							t2.set(.75);
							t1.set(.75);
							return;
						}
						return;
					}
				}
			
			}
		}
		public void Level4()
		{
			if(leftAnalPos < leftAnal4){
				while(leftAnalPos < leftAnal4)
				{
					while(leftAnalPos < leftAnal4){
						if(toggled){
							t2.set(-.5);
							t1.set(-.5);
							}
						else
						{
							t2.set(-.75);
							t1.set(-.75);
						}
						return;
					}
					return;
				}
				
			}
			
			if(leftAnalPos > leftAnal4){
				while(leftAnalPos > leftAnal4)
				{
					while(leftAnalPos > leftAnal4){
						t2.set(.75);
						t1.set(.75);
						return;
					}
					return;
				}
				
			if(rightAnalPos < rightAnal4){
				while(rightAnalPos < rightAnal4)
				{
					while(leftAnalPos < leftAnal4){
						if(toggled){
							t2.set(-.5);
							t1.set(-.5);
							}
						else
						{
							t2.set(-.75);
							t1.set(-.75);
						}
						return;
					}
					return;
				}
					
			}
				
			if(rightAnalPos > rightAnal4){
					while(leftAnalPos > leftAnal4)
					{
						while(leftAnalPos > leftAnal4){
							t2.set(.75);
							t1.set(.75);
							return;
						}
						return;
					}
				}
			}			
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
			if(toggled){
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