package org.firstinspires.ftc.teamcode.action;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.teamcode.autonomous.Action;
import org.firstinspires.ftc.teamcode.hardware.Hardware1920;

import java.util.List;

public class SenseAction implements Action {


    @Override
    public void prepareAction(Hardware1920 hardware) {

    }

    @Override
    public boolean doAction(Hardware1920 hardware) {

        // getUpdatedRecognitions() will return null if no new information is available since
        // the last time that call was made.
        List<Recognition> updatedRecognitions = hardware.tfod.getUpdatedRecognitions();
        if (updatedRecognitions != null) {
            // step through the list of recognitions and display boundary info.
            int i = 0;
            for (Recognition recognition : updatedRecognitions) {

            }



        }

        return false;
    }
}
