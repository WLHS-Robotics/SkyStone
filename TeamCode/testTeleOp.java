package org.firstinspires.ftc.teamcode;

// Created by Andrew

public class TestOpMode extends TestHardware {

    boolean bPress = false;
    boolean aPress = false;

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void loop() {
        super.loop();


        if (gamepad1.b) {
            if (!bPress) {
                rightMotor.setPower(.51);
                telemetry.addLine("b is being pressed");
                bPress = true;
            }
        }  else {
            rightMotor.setPower(0);
            bPress = false;
        }

        if (gamepad1.a) {
            if (!aPress) {
                leftMotor.setPower(.51);
                telemetry.addLine("a is being pressed.");
                aPress = true;
            }
        } else {
            leftMotor.setPower(0);
            aPress = false;
        }


    }

}
