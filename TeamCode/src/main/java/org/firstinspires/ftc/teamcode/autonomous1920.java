package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Autonomous", group = "Autonomous")

public class autonomous1920 extends LinearOpMode{


               DcMotor leftDrive;
               DcMotor rightDrive;

@Override
public void runOpMode() throws InterruptedException{
	leftDrive = hardwareMap.dcMotor.get("leftDrive");
	rightDrive = hardwareMap.dcMotor.get("rightDrive");
	leftDrive.setDirection(DcMotor.Direction.FORWARD);
	rightDrive.setDirection(DcMotor.Direction.FORWARD);

	waitForStart();
	leftDrive.setPower(.5);
	rightDrive.setPower(0);

	sleep(200 );

	leftDrive.setPower(.25);
	rightDrive.setPower(.25);



	
}

}