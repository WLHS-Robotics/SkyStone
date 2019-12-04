package org.firstinspires.ftc.teamcode.action;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.autonomous.Action;
import org.firstinspires.ftc.teamcode.hardware.Hardware1920;

public class MoveAction implements Action {

    enum Direction{
        forwards, backwards
    }

    double distance;
    Direction direction;
    double timeout;

    public MoveAction(double distance, Direction direction, double timeout) {

        this.distance = distance;
        this.direction = direction;
        this.timeout = timeout;
    }


    public void init(Hardware1920 hardware){


    }

    public boolean doAction(Hardware1920 hardware){





    }

}
