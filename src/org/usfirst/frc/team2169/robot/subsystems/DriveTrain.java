package org.usfirst.frc.team2169.robot.subsystems;

import org.usfirst.frc.team2169.robot.ActuatorMap;
import org.usfirst.frc.team2169.robot.subsystems.Subsystem;
import com.ctre.CANTalon;

public class DriveTrain extends Subsystem{
	
	//Define null objects up here
	//Public because autonomous needs to access actuators
	//Static because there is only one of each subsystem
	public static CANTalon left;
	public static CANTalon right;
	
	public DriveTrain(){
		
		left = new CANTalon(ActuatorMap.leftDriveTalon);
		right = new CANTalon(ActuatorMap.rightDriveTalon);
		//Create the objects and set properties
		
	}
	
	@Override
	public void pushToDashboard() {
		
		//Put any SmartDash info here.
		
	}

	@Override
	public void zeroSensors() {
		
		//Zero sensors method
		
	}

	@Override
	public void stop() {
		
		//Code to make all moving parts halt goes here.
		
	}

}
