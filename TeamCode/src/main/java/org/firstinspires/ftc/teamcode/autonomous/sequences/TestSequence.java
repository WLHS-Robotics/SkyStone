package org.firstinspires.ftc.teamcode.autonomous.sequences;

import org.firstinspires.ftc.teamcode.action.MoveAction;
import org.firstinspires.ftc.teamcode.action.RotateAction;
import org.firstinspires.ftc.teamcode.autonomous.ActionSequence;

public class TestSequence extends ActionSequence {

    public TestSequence() {
        addAction(new MoveAction(0.4, 12, MoveAction.Direction.forwards, 3000));
        addAction(new RotateAction(360));
    }
}
