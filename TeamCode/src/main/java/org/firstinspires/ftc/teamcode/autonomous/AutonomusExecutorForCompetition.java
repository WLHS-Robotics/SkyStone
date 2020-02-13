package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.autonomous.sequences.BlueAllianceSequence;
import org.firstinspires.ftc.teamcode.hardware.Hardware1920;

@Autonomous(name="BlueAllianceSequence", group = "")
public class AutonomusExecutorForCompetition extends Hardware1920 {
    ActionExecutor executor;

    @Override
    public void init() {
        super.init();
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