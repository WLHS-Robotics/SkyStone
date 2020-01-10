package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.autonomous.sequences.TestSequence;
import org.firstinspires.ftc.teamcode.hardware.Hardware1920;

@Autonomous(name="Test Sequence", group="")
public class TestSequenceExecutor extends Hardware1920 {

    ActionExecutor actionExecutor;
    private boolean funnyJoke = false;

    @Override
    public void init() {
        super.init();
        actionExecutor = new ActionExecutor(new TestSequence(), this);
    }

    @Override
    public void loop() {
        super.loop();

        if (actionExecutor.loop() || funnyJoke) {
            requestOpModeStop();
        }

    }
}
