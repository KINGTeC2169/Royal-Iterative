package org.usfirst.frc.team2169.robot.auto.modes;

import org.usfirst.frc.team2169.robot.RobotStates;
import org.usfirst.frc.team2169.robot.RobotStates.runningMode;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BlueCenterAuto extends CommandGroup {

    public BlueCenterAuto() {

		//Put Sequentials and Parallels of Tasks here.
    	
    }
    
    public void looper() {
    	
    	//Put looping checks/code in here
    	
    	smartDashPush();
    	RobotStates.runningMode = runningMode.AUTO;
    }
    
    public void smartDashPush() {
    	//Put Smartdashboard output
    	SmartDashboard.putString("Running Auto:", "Blue Center");
    }
}
