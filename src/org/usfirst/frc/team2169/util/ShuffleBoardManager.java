package org.usfirst.frc.team2169.util;

import org.usfirst.frc.team2169.robot.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShuffleBoardManager {
	
	public void startCameraServer() {
     
		//TODO Camera Server
		
	}
	
	public void init() {
	
		connected();
		SmartDashboard.putNumber("Battery Voltage", Robot.fms.batteryVoltage());
		
	}
	
	public void auto() {
		
		batteryData();
		connected();
		SmartDashboard.putNumber("Match Time", Robot.fms.matchTime());
		
	}
	
	public void teleOp() {
		
		batteryData();
		connected();
		SmartDashboard.putNumber("Match Time", Robot.fms.matchTime());
				
	}
	
		//Local Methods
		void batteryData() {
			
			SmartDashboard.putNumber("Battery Voltage", Robot.fms.batteryVoltage());
			SmartDashboard.putBoolean("BrownOut Alert", !Robot.fms.browningOut());
			
			
		}
		
		void connected() {
		
			SmartDashboard.putBoolean("FMS Connected", Robot.fms.fmsActive());
			SmartDashboard.putBoolean("DS Connected", Robot.fms.isDriverStationAttached());
		
		}
	
}
