 package org.usfirst.frc.team2169.robot.auto;

import org.usfirst.frc.team2169.robot.Constants;
import org.usfirst.frc.team2169.robot.auto.modes.BlueCenterAuto;
import org.usfirst.frc.team2169.robot.auto.modes.BlueLeftAuto;
import org.usfirst.frc.team2169.robot.auto.modes.BlueRightAuto;
import org.usfirst.frc.team2169.robot.auto.modes.RedCenterAuto;
import org.usfirst.frc.team2169.robot.auto.modes.RedLeftAuto;
import org.usfirst.frc.team2169.robot.auto.modes.RedRightAuto;
import org.usfirst.frc.team2169.robot.auto.modes.SelfTest;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;


//End users shouldn't need to touch this.


public class AutoManager {
	
	//Alliance IDs
	
		int alliance;
		int position;
		int mode;
		
	//Sendable Chooser Declarations
		
		SendableChooser<Integer> allianceChooser;
		SendableChooser<Integer> positionChooser;
		SendableChooser<Integer> modeChooser;
		
	//Command Declarations
		
		BlueLeftAuto bLAuto;
		BlueCenterAuto bCAuto;
		BlueRightAuto bRAuto;
		RedLeftAuto rLAuto;
		RedCenterAuto rCAuto;
		RedRightAuto rRAuto;
		SelfTest selfTest;
	
	public AutoManager(SendableChooser<Integer> allianceChooserParam, SendableChooser<Integer> positionChooserParam,SendableChooser<Integer> modeParam) {
		
		allianceChooser = allianceChooserParam;
		positionChooser = positionChooserParam;
		modeChooser = modeParam;
		
		bLAuto = new BlueLeftAuto();
		bCAuto = new BlueCenterAuto();
		bRAuto = new BlueRightAuto();
		rLAuto = new RedLeftAuto();
		rCAuto = new RedCenterAuto();
		rRAuto = new RedRightAuto();
		selfTest = new SelfTest();
		
		//Alliance Choosers
		allianceChooser.addDefault("Self-Test", 0);
		allianceChooser.addObject("Blue Alliance", 1);
		allianceChooser.addObject("Red Alliance", 2);
		
		//Position Choosers
		positionChooser.addDefault("Left", -1);
		positionChooser.addObject("Center", 0);
		positionChooser.addObject("Right", 1);
		
		//Mode Choosers
		modeChooser.addDefault(Constants.defaultAutoName, 0);
		modeChooser.addObject(Constants.secondAutoName, 0);
		modeChooser.addObject(Constants.thirdAutoName, 0);
		
	
	}
	
	public void runAuto() {
		alliance = allianceChooser.getSelected().intValue();
		position = positionChooser.getSelected().intValue();
		mode = modeChooser.getSelected().intValue();
		
		if(alliance == 0) {
			System.out.println("Running Self Test");
			selfTest.start();
			System.out.println("Auto Complete");
		}
		
		else if(alliance == 1) {
			
			if(position == -1) {
			
				//Blue Left Auto
				bLAuto.selectMode(mode);
				System.out.println(modeChooser.getSelected() + " auto selected");
				System.out.println("Running Blue Left Auto");
				bLAuto.start();
				System.out.println("Auto Complete");
			
			}
			
			else if(position == 0) {
				
				//Blue Center Auto
				bCAuto.selectMode(mode);
				System.out.println(modeChooser.getSelected() + " auto selected");
				System.out.println("Running Blue Center Auto");
				bCAuto.start();
				System.out.println("Auto Complete");
				
			}
			
			else if(position == 1) {
			
				//Blue Right Auto
				bRAuto.selectMode(mode);
				System.out.println(modeChooser.getSelected() + " auto selected");
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
				rLAuto.selectMode(mode);
				System.out.println(modeChooser.getSelected() + " auto selected");
				System.out.println("Running Red Left Auto");
				rLAuto.start();
				System.out.println("Auto Complete");
			
			}
			
			else if(position == 0) {
				
				//Red Center Auto
				rCAuto.selectMode(mode);
				System.out.println(modeChooser.getSelected() + " auto selected");
				System.out.println("Running Red Center Auto");
				rCAuto.start();
				System.out.println("Auto Complete");
				
				
			}
			
			else if(position == 1) {
			
				//Red Right Auto
				rRAuto.selectMode(mode);
				System.out.println(modeChooser.getSelected() + " auto selected");
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
	
	public void autoLooping() {
		
		if(alliance == 0) {
			selfTest.looper();
		}
		
		else if(alliance == 1) {
			
			if(position == -1) {
			
				//Blue Left Auto Looper
				bLAuto.looper();
			
			}
			
			else if(position == 0) {
				
				//Blue Center Auto Looper
				bCAuto.looper();
				
			}
			
			else if(position == 1) {
			
				//Blue Right Auto Looper
				bRAuto.looper();
			
			}
			else {
				
				//Failure
				
			}
			
		}
		
		else if(alliance == 2) {

			if(position == -1) {
				
				//Red Left Auto Looper
				rLAuto.looper();
			
			}
			
			else if(position == 0) {
				
				//Red Center Auto Looper
				rCAuto.looper();
				
				
			}
			
			else if(position == 1) {
			
				//Red Right Auto Looper
				rRAuto.looper();
			}	
			else {
				
				//Failure
				
			}
			
		}
		else {
			
			//Failure
			
		}
		
		
	}

}
