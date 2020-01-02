package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;




import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

// Created by AW5178
@TeleOp(name="Basic: Linear OpMode", group="Linear Opmode")

public class Hardware1920 extends OpMode {

    public final static String VUFORIA_KEY = "Ac365Jf/////AAABmRokomfFjktoqkyov6AzOzstMw6SLzW0/fHjEcvYmidT0/Yg3UKB6xhti//46FF3ENwt9ZHEb410v1vAzy7w7Jr4iGntG8SjtGZAH33dGeKhKRhKNiLVB5Qyz6UayxzV6eKC8Gj9AJOYjc3XfJpRx/A3Cctf8rzgPII3SpLqvnhUbzozdnhGYA8sRsFnmGRAhpPRU6XuEbJtIkUYups7yCdhi9pL/ku9/MgKT4mjWlkqJS0bFbF2Ytv7nGKIqXHmlHlQgqO2Ee2FHeDhTkO9OhTsPC0WB/aAozoHW5UswBSYW7BOSTnBq1cXMNuzuqGs75ThmBGglENlVyujY6L5ffzl0AlKVr/1lkJkK8AwvAiO";
    public TFObjectDetector tfod;
    public DcMotor leftDrive;
    public DcMotor rightDrive;
    public DcMotor leftSuck;
    public DcMotor rightSuck;
    public DcMotor leftLiftMotor;
    public DcMotor rightLiftMotor;
    public Servo gripServo;
    public Servo armServo;


    @Override
    public void init() {

        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");
        leftSuck = hardwareMap.dcMotor.get("leftSuck");
        rightSuck = hardwareMap.dcMotor.get("rightSuck");

        leftDrive.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightDrive.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        leftSuck.setDirection(DcMotor.Direction.FORWARD);
        rightSuck.setDirection(DcMotor.Direction.REVERSE);




    }

    @Override
    public void loop() {


    }

}
