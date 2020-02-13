package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.vuforia.Vuforia;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
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
    public static final double COUNTS_PER_LAT_INCH = COUNTS_PER_INCH * (24.0/17.5);
    public static final double LENGTH = 17;
    public static final double WIDTH = 16;
    public static final double ROBOT_DIAGONAL_LENGTH = Math.sqrt(Math.pow(LENGTH, 2) + Math.pow(WIDTH, 2));
    public static final double ROBOT_CIRCUMFRENCE = (Math.PI * ROBOT_DIAGONAL_LENGTH);

    public VuforiaLocalizer vuforia;
    public TFObjectDetector tfod;

    public DcMotor leftSuck;
    public DcMotor rightSuck;
    public DcMotor backLeftSuck;
    public DcMotor backRightSuck;
    public DcMotor liftMotor;
    //public DcMotor liftMotor;
    public DcMotor armMotor;
    public DcMotor leftLiftMotor;
    public DcMotor rightLiftMotor;

    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    public OmniDrive omniDrive;
    public Servo leftGripServo;
    public Servo rightGripServo;

    public ColorSensor sensorColor;
    public DistanceSensor sensorDistance;

    public int armMotorStartingPosition;

    /*

    HUB A

    Front Left - FL
    Front Right - FR
    Back Left - BL
    Back Right - BR

    HUB B

    Lift Motor - LM
    Arm Motor - AM
    Left Suck - LS
    Right Suck - RS

    Left Grip Servo - LG
    Right Grip Servo - RG

     */

    @Override
    public void init() {
        leftSuck = hardwareMap.dcMotor.get("LS");
        rightSuck = hardwareMap.dcMotor.get("RS");
        backLeftSuck = hardwareMap.dcMotor.get("BLS");
        backRightSuck = hardwareMap.dcMotor.get("BRS");
        leftSuck.setDirection(DcMotor.Direction.FORWARD);
        rightSuck.setDirection(DcMotor.Direction.FORWARD);
        backLeftSuck.setDirection(DcMotor.Direction.FORWARD);
        backRightSuck.setDirection(DcMotor.Direction.FORWARD);

        frontLeft = hardwareMap.dcMotor.get("FL");
        frontRight = hardwareMap.dcMotor.get("FR");
        backLeft = hardwareMap.dcMotor.get("BL");
        backRight = hardwareMap.dcMotor.get("BR");
        omniDrive = new OmniDrive(frontLeft, frontRight, backLeft, backRight);

        sensorColor = hardwareMap.colorSensor.get("CS");

        //liftMotor = hardwareMap.dcMotor.get("LM");

        //leftGripServo = hardwareMap.servo.get("LG");
        //rightGripServo = hardwareMap.servo.get("RG");
    }

    @Override
    public void loop() {

        telemetry.addData("FL", frontLeft.getCurrentPosition());
        telemetry.addData("FR" ,frontRight.getCurrentPosition());
        telemetry.addData("BL", backLeft.getCurrentPosition());
        telemetry.addData("BR", backRight.getCurrentPosition());

        telemetry.addData("FL POW", frontLeft.getPower());
        telemetry.addData("FR POW", frontRight.getPower());
        telemetry.addData("BL POW", backLeft.getPower());
        telemetry.addData("BR POW", backRight.getPower());

    }

}
