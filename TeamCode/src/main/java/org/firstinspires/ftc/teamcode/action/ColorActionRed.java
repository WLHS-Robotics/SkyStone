package org.firstinspires.ftc.teamcode.action;

import org.firstinspires.ftc.teamcode.autonomous.Action;
import org.firstinspires.ftc.teamcode.hardware.Hardware1920;

public class ColorActionRed implements Action {

    public double Red;
    public double Hue;
    public double endTime;
    public double time;

    public ColorActionRed(double time){
        this.time = time;
    }

    public void prepareAction(Hardware1920 hardware){
        endTime = System.currentTimeMillis() + time;
    }

    public boolean doAction(Hardware1920 hardware){
        if (System.currentTimeMillis() >= endTime){
            return true;
        } else if (Hue < 180 || Hue > 220 || Red > 1 || Red < 0){
                Hue = hardware.sensorColor.argb();
                Red = hardware.sensorColor.red();
                return false;
        } else if (Hue > 180 && Hue < 220 && Red < 1 && Red > 0){
                hardware.frontLeft.setPower(0);
                hardware.frontRight.setPower(0);
                hardware.backLeft.setPower(0);
                hardware.backRight.setPower(0);
            return true;
        } else {
            return false;
        }
        }

    }

