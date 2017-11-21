package org.usfirst.frc.team2169.robot;

import org.usfirst.frc.team2169.robot.Subsystems.Superstructure;
import org.usfirst.frc.team2169.robot.auto.modes.SampleAuto;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;


public class Robot extends IterativeRobot {
	
	ControlMap controls;
	Superstructure superStructure;
	
	@Override
	public void robotInit() {
	
		try{
			
			superStructure = new Superstructure();
			controls = new ControlMap();

		}
		catch(Exception e){
			DriverStation.reportError(e.toString(), true);
		}
	
	}

	@Override
	public void autonomousInit() {
		
		
	}

	@Override
	public void autonomousPeriodic() {
	
		
	}

	@Override
	public void teleopPeriodic() {
		
		

		try{
		
		}
		catch(Exception e){
			DriverStation.reportError(e.toString(), true);
		}
		
		
		
	}

	@Override
	public void testPeriodic() {
	}
}

