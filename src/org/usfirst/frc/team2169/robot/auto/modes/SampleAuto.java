package org.usfirst.frc.team2169.robot.auto.modes;

import org.usfirst.frc.team2169.robot.auto.tasks.SampleTask;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SampleAuto extends CommandGroup {

    public SampleAuto() {

    		addSequential(new SampleTask());
    		addParallel(new SampleTask());
    	
    }
}
