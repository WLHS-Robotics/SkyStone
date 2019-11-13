package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;




import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

// Created by AW5178
@TeleOp(name="Basic: Linear OpMode", group="Linear Opmode")

public class testHardware1920 extends LinearOpMode {

    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private DcMotor leftSuck;
    private DcMotor rightSuck;


    @Override
    public void runOpMode() {
        
            leftDrive = hardwareMap.dcMotor.get("leftDrive");
            rightDrive = hardwareMap.dcMotor.get("rightDrive");
            leftSuck = hardwareMap.dcMotor.get("leftSuck");
            rightSuck = hardwareMap.dcMotor.get("rightSuck");


       
          //  telemetry.addData("MOTORS defined"));
			
			leftDrive.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
			rightDrive.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
            leftSuck.setDirection(DcMotor.Direction.FORWARD);
            rightSuck.setDirection(DcMotor.Direction.FORWARD);


        // Set all motors to zero power
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        leftSuck.setPower(0);
        rightSuck.setPower(0);
        }
    }
