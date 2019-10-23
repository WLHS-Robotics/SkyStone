@@ -0,0 +1,27 @@
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

// Created by Andrew

public class TestHardware extends LinearOpMode {

    public DcMotor leftMotor;
    public DcMotor rightMotor;

    @Override
    public void init(){
        try {
            leftMotor = hardwareMap.dcMotor.get("leftMotor");
            rightMotor = hardwareMap.dcMotor.get("rightMotor");
        } catch (Exception e) {
            telemetry.addData("Not Found:", e.getMessage());
        }
    }

    @Override
    public void loop() {

    }
}