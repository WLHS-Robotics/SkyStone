package org.firstinspires.ftc.teamcode.action;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.autonomous.Action;
import org.firstinspires.ftc.teamcode.hardware.Hardware1920;

public class RotateAction implements Action {

    public double COUNTS_IN_360 = 0;
    public double COUNTS_PER_DEGREE = COUNTS_IN_360/360.0;
    public double degrees;

    public RotateAction(double degrees){
        this.degrees = degrees;
    }

    @Override
    public void prepareAction(Hardware1920 hardware) {
        hardware.leftDrive.setTargetPosition((int) (hardware.leftDrive.getCurrentPosition() + degrees * COUNTS_IN_360));
        hardware.rightDrive.setTargetPosition((int) -(hardware.rightDrive.getCurrentPosition() + degrees * COUNTS_IN_360));
        hardware.leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        hardware.rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public boolean doAction(Hardware1920 hardware) {
        if (!hardware.leftDrive.isBusy() && !hardware.rightDrive.isBusy()) {
            hardware.leftDrive.setPower(0);
            hardware.rightDrive.setPower(0);
            hardware.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            hardware.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            return true;
        } else {
            hardware.leftDrive.setPower(0.25);
            hardware.rightDrive.setPower(0.25);
            return false;
        }
    }
}
