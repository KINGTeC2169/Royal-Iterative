package org.usfirst.frc.team2169.robot.auto.tasks;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TestTask extends Command {

    public TestTask() {
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	System.out.println("Initializing task");
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	System.out.println("Executing Task");
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Task Finished");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
