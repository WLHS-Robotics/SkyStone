package org.firstinspires.ftc.teamcode.action;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.autonomous.Action;
import org.firstinspires.ftc.teamcode.hardware.Hardware1920;

public class MoveAction implements Action {

    public enum Direction{
        forwards, backwards
    }

    double distance;
    Direction direction;
    double timeout;
    public double COUNTS_PER_INCH = 0;
    public double power;

    public MoveAction(double power, double distance, Direction direction, double timeout) {

        this.distance = distance;
        this.direction = direction;
        this.timeout = timeout;
        this.power = power;
    }


    public void prepareAction(Hardware1920 hardware){
        hardware.leftDrive.setTargetPosition((int) (hardware.leftDrive.getCurrentPosition() + distance * COUNTS_PER_INCH));
        hardware.rightDrive.setTargetPosition((int) (hardware.rightDrive.getCurrentPosition() + distance * COUNTS_PER_INCH));
        hardware.leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        hardware.rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    public boolean doAction(Hardware1920 hardware){
        if (!hardware.leftDrive.isBusy() && !hardware.rightDrive.isBusy()) {
            hardware.leftDrive.setPower(0);
            hardware.rightDrive.setPower(0);
            hardware.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            hardware.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            return true;
        } else {
            hardware.leftDrive.setPower(power);
            hardware.rightDrive.setPower(power);
            return false;
        }
    }

}
