package org.usfirst.frc.team2169.robot;

import org.usfirst.frc.team2169.robot.RobotStates.runningMode;
import org.usfirst.frc.team2169.robot.auto.AutoManager;
import org.usfirst.frc.team2169.robot.subsystems.Superstructure;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;


public class Robot extends IterativeRobot {

	static AutoManager auto;
	ControlMap controls;
	Superstructure superStructure;
	
	

	
	@Override
	public void robotInit() {
		
		RobotStates.runningMode = runningMode.IDLE;

		
			auto = new AutoManager();
			superStructure = new Superstructure();
			controls = new ControlMap();
			
	
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

