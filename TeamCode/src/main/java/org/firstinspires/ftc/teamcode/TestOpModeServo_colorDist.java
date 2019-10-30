package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp(name="TestOpModeServo_colorDist", group="Linear Opmode")
//@Disabled

public class pTestOpModeServo_colorDist extends LinearOpMode {

        // Declare OpMode members.
        private ElapsedTime runtime = new ElapsedTime();
        private DcMotor leftDrive = null;
        private DcMotor rightDrive = null;
        private Gyroscope imu;
        private DigitalChannel digitalTouch;
        private DistanceSensor sensorColorRange;
        private Servo servoTest;

        @Override
        public void runOpMode() {
            telemetry.addData("Status", "Initialized");
            telemetry.update();

            // Initialize the hardware variables. Note that the strings used here as parameters
            // to 'get' must correspond to the names assigned during the robot configuration
            // step (using the FTC Robot Controller app on the phone).
            leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
            rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
            imu = hardwareMap.get(Gyroscope.class, "imu");
            digitalTouch = hardwareMap.get(DigitalChannel.class, "digitalTouch");
            sensorColorRange = hardwareMap.get(DistanceSensor.class, "sensorColorRange");
            servoTest = hardwareMap.get(Servo.class, "servoTest");

            // Most robots need the motor on one side to be reversed to drive forward
            // Reverse the motor that runs backwards when connected directly to the battery
            leftDrive.setDirection(DcMotor.Direction.REVERSE);
            rightDrive.setDirection(DcMotor.Direction.FORWARD);
            digitalTouch.setMode (DigitalChannel.Mode.INPUT);

            // Wait for the game to start (driver presses PLAY)
            waitForStart();
            runtime.reset();

            // run until the end of the match (driver presses STOP)
            while (opModeIsActive()) {

                // Setup a variable for each drive wheel to save power level for telemetry
                double leftPower;
                double rightPower;

                // Choose to drive using either Tank Mode, or POV Mode
                // Comment out the method that's not used.  The default below is POV.

                // POV Mode uses left stick to go forward, and right stick to turn.
                // - This uses basic math to combine motions and is easier to drive straight.
                double drive = -gamepad1.left_stick_y;
                double turn  =  0.25*gamepad1.right_stick_x;
                //show input from gamepad sticks
                telemetry.addData("Joy Stick", "Drive (%.2f), Turn (%.2f)", drive, turn);

                leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
                rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;


                // Send calculated power to wheels
                leftDrive.setPower(leftPower);
                rightDrive.setPower(rightPower);

                // check to see if need to mover servoTest
                if (gamepad1.y)  {
                    //move to 0 degrees
                    servoTest.setPosition (0);
                } else if (gamepad1.x  || gamepad1.b) {
                    //move to 90 degrees
                    servoTest.setPosition(0.5);
                }  else if (gamepad1.a)  {
                    // move to 180 degrees
                    servoTest.setPosition(1);
                }

                // is button pressed
                if (digitalTouch.getState() ==false) {
                    //button pressed
                    telemetry.addData ("Button", "PRESSED");
                } else {
                    //button not pressed
                    telemetry.addData ("Button", "NOT PRESSED");
                }

                // Show the elapsed game time and wheel power.
                telemetry.addData("Status", "Run Time: " + runtime.toString());
                telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
                telemetry.addData ("Servo Position", servoTest.getPosition () );
                telemetry.addData ("Distance (cm)", sensorColorRange.getDistance (DistanceUnit.CM));
                telemetry.update();
				idle();
            }
        }


    }







