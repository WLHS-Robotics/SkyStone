package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.vuforia.Vuforia;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

// Created by AW5178
public class Hardware1920 extends OpMode {

    public final static String VUFORIA_KEY = "Ac365Jf/////AAABmRokomfFjktoqkyov6AzOzstMw6SLzW0/fHjEcvYmidT0/Yg3UKB6xhti//46FF3ENwt9ZHEb410v1vAzy7w7Jr4iGntG8SjtGZAH33dGeKhKRhKNiLVB5Qyz6UayxzV6eKC8Gj9AJOYjc3XfJpRx/A3Cctf8rzgPII3SpLqvnhUbzozdnhGYA8sRsFnmGRAhpPRU6XuEbJtIkUYups7yCdhi9pL/ku9/MgKT4mjWlkqJS0bFbF2Ytv7nGKIqXHmlHlQgqO2Ee2FHeDhTkO9OhTsPC0WB/aAozoHW5UswBSYW7BOSTnBq1cXMNuzuqGs75ThmBGglENlVyujY6L5ffzl0AlKVr/1lkJkK8AwvAiO";
    public static final double     COUNTS_PER_MOTOR_REV    = 4;    // eg: TETRIX Motor Encoder
    public static final double     DRIVE_GEAR_REDUCTION    = 72;     // This is < 1.0 if geared UP
    public static final double     WHEEL_DIAMETER_INCHES   = 4;     // For figuring circumference
    public static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * Math.PI);
    public static final double LENGTH = 12.5;
    public static final double WIDTH = 17.25;
    public static final double ROBOT_DIAGONAL_LENGTH = Math.sqrt(Math.pow(LENGTH, 2) + Math.pow(WIDTH, 2));
    public static final double ROBOT_CIRCUMFRENCE = (Math.PI * ROBOT_DIAGONAL_LENGTH);

    public VuforiaLocalizer vuforia;
    public TFObjectDetector tfod;

    public DcMotor leftSuck;
    public DcMotor rightSuck;
    public DcMotor liftMotor;
    public DcMotor leftLiftMotor;
    public DcMotor rightLiftMotor;
    public DcMotor armMotor;

    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    public OmniDrive omniDrive;
    public Servo leftGripServo;
    public Servo rightGripServo;

    public int armMotorStartingPosition;


    @Override
    public void init() {
        leftSuck = hardwareMap.dcMotor.get("LS");
        rightSuck = hardwareMap.dcMotor.get("RS");
        leftSuck.setDirection(DcMotor.Direction.FORWARD);
        rightSuck.setDirection(DcMotor.Direction.REVERSE);

        frontLeft = hardwareMap.dcMotor.get("FL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backLeft = hardwareMap.dcMotor.get("BL");
        backRight = hardwareMap.dcMotor.get("BR");
        omniDrive = new OmniDrive(frontLeft, frontRight, backLeft, backRight);

        liftMotor = hardwareMap.dcMotor.get("LM");

        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    @Override
    public void loop() {


    }

}
