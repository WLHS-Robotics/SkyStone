package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.autonomous.sequences.TestSequence;
import org.firstinspires.ftc.teamcode.hardware.Hardware1920;

@Autonomous(name="Autonomous", group = "Autonomous")

public class autonomous1920 extends Hardware1920 {
    ActionExecutor executor;

    @Override
    public void init() {
        //super.init();
        executor = new ActionExecutor(new TestSequence(), this);
    }

    @Override
    public void loop() {
        super.loop();

        if (executor.loop()) {
            requestOpModeStop();
        }
    }
}