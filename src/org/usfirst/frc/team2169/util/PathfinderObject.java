package org.usfirst.frc.team2169.util;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;
import org.usfirst.frc.team2169.robot.Constants;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.interfaces.Gyro;

public class PathfinderObject {
	
	//Waypoints go here
	Waypoint[] points;
	
	public boolean isFinished = false;
	
	public PathfinderObject(Waypoint[] importedPoints){
		points = importedPoints;
	}
	
	EncoderFollower leftFollower;
	EncoderFollower rightFollower;
	
	public void calculatePath(int leftTalon, int rightTalon) {
	Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH,
			Constants.timeStep, Constants.maxVelocity, Constants.maxAcceleration, Constants.maxJerk);
 
	// Generate the trajectory
	Trajectory trajectory = Pathfinder.generate(points, config);

	// Create the Modifier Object
	TankModifier modifier = new TankModifier(trajectory);

	// Generate the Left and Right trajectories using the original trajectory
	// as the centre
	modifier.modify(Constants.wheelBaseWidth);
	Trajectory left  = modifier.getLeftTrajectory();
	Trajectory right = modifier.getRightTrajectory();
	
	
	//Make Encoder Followers
	leftFollower = new EncoderFollower(left);
	rightFollower = new EncoderFollower(right);
	
	leftFollower.configureEncoder(leftTalon, Constants.ticksPerRotation, Constants.wheelDiameter);
	rightFollower.configureEncoder(rightTalon, Constants.ticksPerRotation, Constants.wheelDiameter);
	
	//Configure Pathfinder PID
	leftFollower.configurePIDVA(Constants.pathfinderP, Constants.pathfinderI, Constants.pathfinderD, Constants.pathfinderVR / Constants.maxVelocity, Constants.accelerationGain);
	
	
	}
	
	public void pathfinderLooper(CANTalon leftTalon, CANTalon rightTalon, Gyro gyro) {
		double l = leftFollower.calculate(leftTalon.getEncPosition());
		double r = rightFollower.calculate(rightTalon.getEncPosition());

		double gyro_heading = gyro.getAngle();    // Assuming the gyro is giving a value in degrees
		double desired_heading = Pathfinder.r2d(leftFollower.getHeading());  // Should also be in degrees

		double angleDifference = Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
		double turn = 0.8 * (-1.0/80.0) * angleDifference;

		//If left wheel trajectory isn't finished, set new power.
		if(!leftFollower.isFinished()) {
			leftTalon.set(l + turn);
		}

		//If right wheel trajectory isn't finished, set new power.
		if(!rightFollower.isFinished()) {
			rightTalon.set(r - turn);
		}
		
		//Return if trajectories are both finished
		if(leftFollower.isFinished() && rightFollower.isFinished()) {
			
			isFinished = true;
		
		}
		
		
		//
		else {
		
			isFinished = false;
		
		}
		
	}
		public void pathfinderLooper(int leftEnc, int rightEnc, CANTalon leftTalon, CANTalon rightTalon, Gyro gyro) {
			double l = leftFollower.calculate(leftEnc);
			double r = rightFollower.calculate(rightEnc);

			double gyro_heading = gyro.getAngle();    // Assuming the gyro is giving a value in degrees
			double desired_heading = Pathfinder.r2d(leftFollower.getHeading());  // Should also be in degrees

			double angleDifference = Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
			double turn = 0.8 * (-1.0/80.0) * angleDifference;

			//If left wheel trajectory isn't finished, set new power.
			if(!leftFollower.isFinished()) {
				leftTalon.set(l + turn);
			}

			//If right wheel trajectory isn't finished, set new power.
			if(!rightFollower.isFinished()) {
				rightTalon.set(r - turn);
			}
			
			//Return if trajectories are both finished
			if(leftFollower.isFinished() && rightFollower.isFinished()) {
				
				isFinished = true;
			
			}
	}
	
	
}

