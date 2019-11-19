package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;




import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

// Created by AW5178
@TeleOp(name="Basic: Linear OpMode", group="Linear Opmode")

public class Hardware1920 extends OpMode {

    public DcMotor leftDrive;
    public DcMotor rightDrive;
    public DcMotor leftSuck;
    public DcMotor rightSuck;

    @Override
    public void init() {

        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");
        leftSuck = hardwareMap.dcMotor.get("leftSuck");
        rightSuck = hardwareMap.dcMotor.get("rightSuck");

        leftDrive.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightDrive.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        leftSuck.setDirection(DcMotor.Direction.REVERSE);
        rightSuck.setDirection(DcMotor.Direction.REVERSE);



    }

    @Override
    public void loop() {


    }

}
