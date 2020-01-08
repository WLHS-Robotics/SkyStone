package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.autonomous.sequences.TestSequence;
import org.firstinspires.ftc.teamcode.hardware.Hardware1920;

@Autonomous(name="Test Sequence")
public class TestSequenceExecutor extends Hardware1920 {
    ActionExecutor executor;

    @Override
    public void init() {
        super.init();
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
