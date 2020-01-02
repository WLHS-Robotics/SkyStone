package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.autonomous.sequences.BlueAllianceSequence;
import org.firstinspires.ftc.teamcode.hardware.Hardware1920;

@Autonomous(name="Autonomous", group = "Autonomous")

public class autonomous1920 extends Hardware1920 {
    ActionExecutor executor;

    @Override
    public void init() {
        //super.prepareAction();
        executor = new ActionExecutor(new BlueAllianceSequence(), this);
    }

    @Override
    public void loop() {
        super.loop();

        if (executor.loop()) {
            requestOpModeStop();
        }
    }
}