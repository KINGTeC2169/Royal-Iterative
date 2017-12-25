package org.usfirst.frc.team2169.robot.auto.tasks;

import org.usfirst.frc.team2169.util.PathfinderObject;
import jaci.pathfinder.Waypoint;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class FollowPath extends Command {

	PathfinderObject path;
	CANTalon left;
	CANTalon right;
	Gyro gyro;
	
    public FollowPath(Waypoint[] points, CANTalon left_, CANTalon right_, Gyro gyro_, int Left, int Right) {
    
    	path = new PathfinderObject(points);
    	left = left_;
    	right = right_;
    	gyro = gyro_;
    	
    	DriverStation.reportWarning("Path Created", false);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	path.calculatePath(left.getEncPosition(), right.getEncPosition());
    	DriverStation.reportWarning("Path Calculated", false);
    		
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	path.pathfinderLooper(left, right, gyro);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return path.isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Path Finished");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
