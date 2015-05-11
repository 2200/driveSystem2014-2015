package org.usfirst.frc.team2200.robot;

import edu.wpi.first.wpilibj.Timer;


public class DriveForwardAutoDotpy {
	DriveClass drive;
	Claw claw;
	BinLift bin;
	ToteLift tote;
	MagazineLimitDotexeDotpyDotpng mag;
	IntakeArms iarmLeft;
	IntakeArms iarmRight;
	double middleR;
	double middleL;
	double leftL;
	double rightR;
	
	
	public DriveForwardAutoDotpy(DriveClass drive, Claw claw, BinLift bin, ToteLift tote, MagazineLimitDotexeDotpyDotpng mag,
			IntakeArms iarmLeft, IntakeArms iarmRight, double middlePointLeft,double middlePointRight, double leftPointLeft,double rightPointRight){
		this.drive = drive;
		this.claw = claw;
		this.bin = bin;
		this.tote = tote;
		this.mag = mag;
		this.iarmLeft = iarmLeft;
		this.iarmRight = iarmRight;
		this.middleL = middlePointLeft;
		this.middleR = middlePointRight;
		this.leftL = leftPointLeft;
		this.rightR = rightPointRight;
		
	}
	
	public void driveForwardOverhump(){
		drive.driveTime(1, 0.75);
		//drive.driveLinear(0.75, 0, 2.5, 19/20); //slope of lin fn, start motor val (b), time for accel & decel combined
	}
	public void driveForward(){
		drive.driveLinear(0.75, 0, 2.3, 19/20);
		}
	
	public void driveBackwardOverhump(){
		drive.driveLinear(-0.75, 0, 2.5, 19/20);	
		}
	public void driveBackward(){
		drive.driveLinear(-0.75, 0, 2.3, 19/20);	
	}
	
	public void drivePickupTote(){
		iarmLeft.enablePID();
		iarmRight.enablePID();
//		while(!tote.infra.get()){
//			iarmLeft.setSpeed(-1);
//			iarmRight.setSpeed(-1);
//			iarmLeft.setSetpoint(3.0);
//			iarmRight.setSetpoint(3.0);
//			Timer.delay(0.05);
//		}
//		iarmLeft.setSpeed(0);
//		iarmRight.setSpeed(0);
//		iarmLeft.setSetpoint(1.3);
//		iarmRight.setSetpoint(4.3);
//		tote.gotoExpMiddle(); // move totelift up to catch tote
//		while (!tote.isPIDDone()){
//			Timer.delay(0.05); //dont execute other things until done
//		}
		iarmLeft.setSetpoint(middleL);
		iarmRight.setSetpoint(middleR);
		Timer.delay(0.3);
		drive.turnTime(-1, 0.9);
		Timer.delay(1);
		drive.driveTime(1, 0.9); //drive forwards
//		mag.Down(); //drop tote
//		tote.gotoExpGround();
		iarmLeft.setSetpoint(leftL);
		iarmRight.setSetpoint(rightR);
		Timer.delay(1);
		drive.driveTime(-1, 0.3); //backup after tote dropped


	}
	
	public void doNothing(){
		
	}
	
	public void drivePickupBin(){
		iarmLeft.enablePID();
		iarmRight.enablePID();
		iarmLeft.setSetpoint(3.0); 
		iarmRight.setSetpoint(1.2); 
		Timer.delay(0.5);
		iarmRight.setSpeed(-1);
		iarmLeft.setSpeed(-1);
		drive.driveTime(-0.75, 0.5);
		drive.driveTime(1, 0.4);
		iarmLeft.setSetpoint(1.6);
		iarmRight.setSetpoint(2.9);
		Timer.delay(0.3);
		iarmLeft.setSetpoint(3.0); 
		iarmRight.setSetpoint(1.2); 
		Timer.delay(0.3);
		iarmRight.setSpeed(-1);
		iarmLeft.setSpeed(-1);
		Timer.delay(1.3);
		iarmLeft.setSpeed(0);
		iarmRight.setSpeed(0);
		iarmLeft.setSetpoint(1.6);
		iarmRight.setSetpoint(2.9); 
		drive.turnTime(-1, 0.3);
		iarmRight.setSpeed(-1);
		iarmLeft.setSpeed(-1);
		iarmLeft.setSetpoint(3.0); 
		iarmRight.setSetpoint(1.2);
		Timer.delay(0.6);
		iarmLeft.setSetpoint(1.6);
		iarmRight.setSetpoint(2.9); 
		iarmLeft.setSpeed(0);
		iarmRight.setSpeed(0);
		//bin.setSetPoint(1.4);
		
		
		
		
//		claw.middle(); //claw needs to be open
//		while (!claw.isPIDDone()){
//			Timer.delay(0.05);
//		}
////		knock bin over
////		iarmLeft.setSpeed(1);
////		pick bin up
//		
//		claw.close();
//		while (!claw.isPIDDone()){
//			Timer.delay(0.05);
//		}
//bin.setPosition(2);
		
	}

}
