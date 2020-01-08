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
public class Hardware1920 extends OpMode {

    public final static int LIFT_RANGE = 500;

    public int leftLiftStartingPosition;
    public int rightLiftStartingPosition;
    public int armMotorStartingPosition;

    public static final double     COUNTS_PER_MOTOR_REV    = 24;    // eg: TETRIX Motor Encoder
    public static final double     DRIVE_GEAR_REDUCTION    = 60;     // This is < 1.0 if geared UP
    public static final double     WHEEL_DIAMETER_INCHES   = 4.3;     // For figuring circumference
    public static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * Math.PI);
    public static final double ROBOT_WIDTH = 18;
    public static final double ROBOT_CIRCUMFRENCE = 2 * Math.PI * ROBOT_WIDTH;


    public final static String VUFORIA_KEY = "Ac365Jf/////AAABmRokomfFjktoqkyov6AzOzstMw6SLzW0/fHjEcvYmidT0/Yg3UKB6xhti//46FF3ENwt9ZHEb410v1vAzy7w7Jr4iGntG8SjtGZAH33dGeKhKRhKNiLVB5Qyz6UayxzV6eKC8Gj9AJOYjc3XfJpRx/A3Cctf8rzgPII3SpLqvnhUbzozdnhGYA8sRsFnmGRAhpPRU6XuEbJtIkUYups7yCdhi9pL/ku9/MgKT4mjWlkqJS0bFbF2Ytv7nGKIqXHmlHlQgqO2Ee2FHeDhTkO9OhTsPC0WB/aAozoHW5UswBSYW7BOSTnBq1cXMNuzuqGs75ThmBGglENlVyujY6L5ffzl0AlKVr/1lkJkK8AwvAiO";
    public TFObjectDetector tfod;
    public DcMotor leftDrive;
    public DcMotor rightDrive;
    public DcMotor leftSuck;
    public DcMotor rightSuck;
    public DcMotor leftLiftMotor;
    public DcMotor rightLiftMotor;
    public Servo leftGripServo;
    public Servo rightGripServo;
    public DcMotor armMotor;


    @Override
    public void init() {

        try {
            leftDrive = hardwareMap.dcMotor.get("leftDrive");
            rightDrive = hardwareMap.dcMotor.get("rightDrive");
            leftSuck = hardwareMap.dcMotor.get("leftSuck");
            rightSuck = hardwareMap.dcMotor.get("rightSuck");
            leftLiftMotor = hardwareMap.dcMotor.get("leftLiftMotor");
            rightLiftMotor = hardwareMap.dcMotor.get("rightLiftMotor");
            leftGripServo = hardwareMap.servo.get("leftGripServo");
            rightGripServo = hardwareMap.servo.get("rightGripServo");
            armMotor = hardwareMap.dcMotor.get("armMotor");
        } catch (Exception e) {
            telemetry.addData("ERROR IN INIT", e.getMessage());
        }

        leftDrive.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightDrive.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        leftSuck.setDirection(DcMotor.Direction.FORWARD);
        rightSuck.setDirection(DcMotor.Direction.REVERSE);
        leftLiftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightLiftMotor.setDirection(DcMotor.Direction.FORWARD);
        armMotor.setDirection(DcMotor.Direction.FORWARD);

        leftLiftStartingPosition = leftLiftMotor.getCurrentPosition();
        rightLiftStartingPosition = rightLiftMotor.getCurrentPosition();
        armMotorStartingPosition = armMotor.getCurrentPosition();
    }

    @Override
    public void loop() {


    }

}
