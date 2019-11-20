package org.firstinspires.ftc.teamcode.action;

import org.firstinspires.ftc.teamcode.autonomous.Action;
import org.firstinspires.ftc.teamcode.hardware.Hardware1920;

public class WaitAction implements Action {

    double time;
    double endTime;

    public double I_AM_PUBLIC = 100;
    private double I_AM_PRIVATE = 100;

    public WaitAction(double time) {
        this.time = time;
    }

    public void init(Hardware1920 hardware) {

        System.currentTimeMillis();
        endTime = System.currentTimeMillis() + time;
    }

    public boolean doAction(Hardware1920 hardware){

        return System.currentTimeMillis() >= endTime;
    }

}
