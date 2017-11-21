package org.usfirst.frc.team2169.robot.auto;

import org.usfirst.frc.team2169.robot.auto.modes.BlueCenterAuto;
import org.usfirst.frc.team2169.robot.auto.modes.BlueLeftAuto;
import org.usfirst.frc.team2169.robot.auto.modes.BlueRightAuto;
import org.usfirst.frc.team2169.robot.auto.modes.RedCenterAuto;
import org.usfirst.frc.team2169.robot.auto.modes.RedLeftAuto;
import org.usfirst.frc.team2169.robot.auto.modes.RedRightAuto;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class AutoManager {
	
	//Command Declarations
		Command bLAuto;
		Command bCAuto;
		Command bRAuto;
		Command rLAuto;
		Command rCAuto;
		Command rRAuto;
	
	public AutoManager(SendableChooser<Integer> allianceChooser, SendableChooser<Integer> positionChooser) {
		
		bLAuto = new BlueLeftAuto();
		bCAuto = new BlueCenterAuto();
		bRAuto = new BlueRightAuto();
		rLAuto = new RedLeftAuto();
		rCAuto = new RedCenterAuto();
		rRAuto = new RedRightAuto();
		
		//Alliance Choosers
		allianceChooser.addDefault("Self-Test", 0);
		allianceChooser.addObject("Blue Alliance", 1);
		allianceChooser.addObject("Red Alliance", 2);
		
		//Position Choosers
		positionChooser.addDefault("Left", -1);
		positionChooser.addObject("Center", 0);
		positionChooser.addObject("Right", 1);
		
		runAuto(allianceChooser.getSelected(),positionChooser.getSelected());
	
	}
	
	public void runAuto(int alliance, int position) {
		
		if(alliance == 0) {
			//Self-Test Code
		}
		
		else if(alliance == 1) {
			
			if(position == -1) {
			
				//Blue Left Auto
				System.out.println("Running Blue Left Auto");
				bLAuto.start();
				System.out.println("Auto Complete");
			
			}
			
			else if(position == 0) {
				
				//Blue Center Auto
				System.out.println("Running Blue Center Auto");
				bCAuto.start();
				System.out.println("Auto Complete");
				
			}
			
			else if(position == 1) {
			
				//Blue Right Auto
				System.out.println("Running Blue Right Auto");
				bRAuto.start();
				System.out.println("Auto Complete");
			
			}
			else {
				
				//Failure
				System.out.println("ERROR: Sendable Chooser has failed to select position");
				
			}
			
		}
		
		else if(alliance == 2) {

			if(position == -1) {
				
				//Red Left Auto
				System.out.println("Running Red Left Auto");
				rLAuto.start();
				System.out.println("Auto Complete");
			
			}
			
			else if(position == 0) {
				
				//Red Center Auto
				System.out.println("Running Red Center Auto");
				rCAuto.start();
				System.out.println("Auto Complete");
				
				
			}
			
			else if(position == 1) {
			
				//Red Right Auto
				System.out.println("Running Red Right Auto");
				rRAuto.start();
				System.out.println("Auto Complete");
			}
			else {
				
				//Failure
				System.out.println("ERROR: Sendable Chooser has failed to select position");
				
			}
			
		}
		else {
			
			//Failure
			System.out.println("ERROR: Sendable Chooser has failed to select alliance");
			
		}
		
		
		
	}
	
	
}
