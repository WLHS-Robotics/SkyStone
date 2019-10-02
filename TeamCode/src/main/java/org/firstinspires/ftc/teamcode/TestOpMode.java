package org.firstinspires.ftc.teamcode;

// Created by Andrew

public class TestOpMode extends TestHardware {

    boolean bPress = false;
    boolean aPress = true;

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void loop() {
        super.loop();

        // gamepad1.b = TRUE
        // bPress = FALSE
        if (gamepad1.b) {
            if (!bPress) {
                // do something
                bPress = true;
            }
        }  else {
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
