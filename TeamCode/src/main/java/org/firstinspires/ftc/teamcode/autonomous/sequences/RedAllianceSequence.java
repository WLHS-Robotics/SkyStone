package org.firstinspires.ftc.teamcode.autonomous.sequences;

import org.firstinspires.ftc.teamcode.action.MoveAction;
import org.firstinspires.ftc.teamcode.action.RotateAction;
import org.firstinspires.ftc.teamcode.action.SuckAction;
import org.firstinspires.ftc.teamcode.autonomous.ActionSequence;

public class RedAllianceSequence extends ActionSequence {

    public RedAllianceSequence() {
        addAction(new MoveAction(.5, 24, MoveAction.Direction.forwards, 5000));
        addAction(new RotateAction(-45));
        addAction(new MoveAction(.5, 5, MoveAction.Direction.forwards, 5000 ));
        addAction(new SuckAction(1, 2000));
        addAction(new MoveAction(.5, 5, MoveAction.Direction.backwards, 5000));
        addAction(new RotateAction(-225));
        addAction(new MoveAction(1, 36, MoveAction.Direction.forwards, 5000));
        addAction(new RotateAction(-90));
        addAction(new MoveAction(.25, 4, MoveAction.Direction.forwards, 3000));
        // to do: drop the block
        addAction(new MoveAction(.25, 4, MoveAction.Direction.forwards, 3000));
        addAction(new RotateAction(-90));
        addAction(new MoveAction(1, 20, MoveAction.Direction.forwards, 5000));
    }
}
