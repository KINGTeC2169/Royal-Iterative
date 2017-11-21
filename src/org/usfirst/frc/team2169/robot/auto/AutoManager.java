package org.usfirst.frc.team2169.robot.auto;

import org.usfirst.frc.team2169.robot.auto.modes.SampleAuto;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class AutoManager<V> {

	Command sampleAuto;
	
	public AutoManager(SendableChooser<V> chooser) {
		
		sampleAuto = new SampleAuto();
		chooser.getSelected();
	
	}
	
	
}
