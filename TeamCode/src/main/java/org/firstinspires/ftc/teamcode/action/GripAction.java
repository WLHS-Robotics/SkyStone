package org.firstinspires.ftc.teamcode.action;

import org.firstinspires.ftc.teamcode.autonomous.Action;
import org.firstinspires.ftc.teamcode.hardware.Hardware1920;

public class GripAction implements Action {
    public final double waitTime = 500;


    boolean grip;
    double endtime;

    public GripAction (boolean grip){
        this.grip = grip;
    }


    @Override
    public void prepareAction(Hardware1920 hardware) {
        endtime = System.currentTimeMillis() + waitTime;
    }

    @Override
    public boolean doAction(Hardware1920 hardware) {
        hardware.leftGripServo.setPosition(grip ? 1 : 0);
        hardware.rightGripServo.setPosition(grip ? 1 : 0);
        return (System.currentTimeMillis() >= endtime);
    }
}
