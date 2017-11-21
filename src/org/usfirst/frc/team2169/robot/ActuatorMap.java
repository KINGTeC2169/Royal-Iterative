package org.usfirst.frc.team2169.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class ActuatorMap {

	public static final int driveLeftMasterPort = 3;
	public static final int driveLeftSlavePort = 4;
	public static final int driveRightMasterPort = 5;
	public static final int driveRightSlavePort = 6;
	public static final int flywheelMasterPort = 0;
	public static final int flywheelSlavePort = 1;
	public static final int intakeMasterPort = 9;
	public static final int intakeSlavePort = 10;
	

	//PCM Port
	public static final int PCMPort = 10;
	
	
	
	//Solenoid Ports
	public static final int driveShiftForwardPort = 0;
	public static final int driveShiftReversePort = 1;
	
	
	//Analog Inputs
	public static final int flywheelEncoderInputPort = 0;
	public static final int flywheelEncoderOutputPort = 1;
	
	//Solenoid States
	public static DoubleSolenoid.Value highGear = DoubleSolenoid.Value.kReverse;
	public static DoubleSolenoid.Value lowGear = DoubleSolenoid.Value.kForward;
}

