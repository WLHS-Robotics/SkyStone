package org.firstinspires.ftc.teamcode.action;

import org.firstinspires.ftc.teamcode.autonomous.Action;
import org.firstinspires.ftc.teamcode.hardware.Hardware1920;

public class SuckAction implements Action {

    public double power;
    public double endtime;
    public double time;

    public SuckAction(double power, double time){
        this.power = power;
        this.time = time;
    }

    @Override
    public void prepareAction(Hardware1920 hardware) {
        endtime = System.currentTimeMillis() + time;

    }

    @Override
    public boolean doAction(Hardware1920 hardware) {

        if (System.currentTimeMillis() >= endtime) {
            hardware.leftSuck.setPower(0);
            hardware.rightSuck.setPower(0);
            return true;
        } else {
            hardware.leftSuck.setPower(power);
            hardware.rightSuck.setPower(power);
            return false;
        }
    }


}
