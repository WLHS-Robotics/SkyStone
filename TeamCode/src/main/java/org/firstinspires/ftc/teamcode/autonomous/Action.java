package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.hardware.Hardware1920;

public interface Action {
    void prepareAction(Hardware1920 hardware);

    boolean doAction(Hardware1920 hardware);

}
