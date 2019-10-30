package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;




import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

// Created by Andrew
@TeleOp(name="Basic: Linear OpMode", group="Linear Opmode")

public class TestHardware extends LinearOpMode {

    private DcMotor leftMotor;
    private DcMotor rightMotor;
	private DcMotor leftSuck;
	private DcMotor rightSuck;
	private DcMotor leftRise;
	private DcMotor rightRise;

    @Override
    public void runOpMode() {
        
            leftMotor = hardwareMap.dcMotor.get("leftMotor");
            rightMotor = hardwareMap.dcMotor.get("rightMotor");
       
          //  telemetry.addData("MOTORS defined"));
			
			leftMotor.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightMotor.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors

        // Set all motors to zero power
        leftMotor.setPower(0);
        rightMotor.setPower(0);
		leftSuck.setPower(0);
		rightSuck.setPower(0);
        }
    }
