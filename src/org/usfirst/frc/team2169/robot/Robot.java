package org.usfirst.frc.team2169.robot;

import org.usfirst.frc.team2169.robot.RobotStates.runningMode;
import org.usfirst.frc.team2169.robot.auto.AutoManager;
import org.usfirst.frc.team2169.robot.subsystems.Superstructure;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;


public class Robot extends IterativeRobot {
	
	SendableChooser<Integer> position;
	SendableChooser<Integer> alliance;
	SendableChooser<Integer> mode;
	AutoManager auto;
	ControlMap controls;
	Superstructure superStructure;
	
	@Override
	public void robotInit() {
		
		RobotStates.runningMode = runningMode.IDLE;
		
		try{
			auto = new AutoManager(alliance, position, mode);
			superStructure = new Superstructure();
			controls = new ControlMap();

		}
		catch(Exception e){
			DriverStation.reportError(e.toString(), true);
		}
	
	}

	@Override
	public void autonomousInit() {
		
		RobotStates.runningMode = runningMode.AUTO;
		auto.runAuto();
		
	}

	@Override
	public void autonomousPeriodic() {
	
		auto.autoLooping();
		
	}

	@Override
	public void teleopPeriodic() {
		
		RobotStates.runningMode = runningMode.TELEOP;
		
		try{
			
			//Put Tele-Op Methods here
		
		}
		catch(Exception e){
			DriverStation.reportError(e.toString(), true);
		}
		
	}

	@Override
	public void testPeriodic() {
	}
}

