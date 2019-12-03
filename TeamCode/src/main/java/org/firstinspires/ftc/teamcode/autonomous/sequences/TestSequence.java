package org.firstinspires.ftc.teamcode.autonomous.sequences;

import org.firstinspires.ftc.teamcode.action.WaitAction;
import org.firstinspires.ftc.teamcode.autonomous.ActionSequence;

public class TestSequence extends ActionSequence {


    public TestSequence() {
        addAction(new WaitAction(5000));
    }


}
