package org.firstinspires.ftc.teamcode.autonomous.sequences;

import org.firstinspires.ftc.teamcode.action.MoveAction;
import org.firstinspires.ftc.teamcode.action.RotateAction;
import org.firstinspires.ftc.teamcode.autonomous.ActionSequence;
import org.firstinspires.ftc.teamcode.hardware.OmniDrive;

public class TestSequence extends ActionSequence {

    public TestSequence() {
        addAction(new MoveAction(0.5f, 12, OmniDrive.Direction.FORWARD, 3000));
        addAction(new RotateAction(360));
    }
}
