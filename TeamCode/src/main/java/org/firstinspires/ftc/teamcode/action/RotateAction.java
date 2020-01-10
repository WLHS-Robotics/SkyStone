package org.firstinspires.ftc.teamcode.action;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.autonomous.Action;
import org.firstinspires.ftc.teamcode.hardware.Hardware1920;

public class RotateAction implements Action {

    double degrees;
    int pos;
    static final float ROTATE_POWER = 0.7f;

    int fl_pos;
    int fr_pos;
    int bl_pos;
    int br_pos;
    boolean rotatingRight;

    public RotateAction(double degrees){
        this.degrees = degrees;
    }

    @Override
    public void prepareAction(Hardware1920 hardware) {
        pos = (int) ((degrees/360D) * hardware.ROBOT_CIRCUMFRENCE * hardware.COUNTS_PER_INCH);

        rotatingRight = degrees > 0;
        fl_pos = hardware.omniDrive.frontLeft.getCurrentPosition();
        fr_pos = hardware.omniDrive.frontRight.getCurrentPosition();
        bl_pos = hardware.omniDrive.backLeft.getCurrentPosition();
        br_pos = hardware.omniDrive.backRight.getCurrentPosition();

        hardware.frontLeft.setTargetPosition(rotatingRight ? (fl_pos + pos) : (fl_pos - pos));
        hardware.frontRight.setTargetPosition(rotatingRight ? (fr_pos - pos) : (fl_pos + pos));
        hardware.backLeft.setTargetPosition(rotatingRight ? (bl_pos + pos) : (fl_pos - pos));
        hardware.backRight.setTargetPosition(rotatingRight ? (br_pos - pos) : (fl_pos + pos));
        hardware.omniDrive.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        hardware.omniDrive.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        hardware.omniDrive.backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        hardware.omniDrive.backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public boolean doAction(Hardware1920 hardware) {
        boolean busy = hardware.omniDrive.frontLeft.isBusy() || hardware.omniDrive.frontRight.isBusy() || hardware.backLeft.isBusy() || hardware.backRight.isBusy();
        if (busy) {
            hardware.omniDrive.frontLeft.setPower(rotatingRight ? ROTATE_POWER : -ROTATE_POWER);
            hardware.omniDrive.frontRight.setPower(rotatingRight ? -ROTATE_POWER : ROTATE_POWER);
            hardware.omniDrive.backLeft.setPower(rotatingRight ? ROTATE_POWER : -ROTATE_POWER);
            hardware.omniDrive.backRight.setPower(rotatingRight ? -ROTATE_POWER : ROTATE_POWER);
        } else {
            hardware.omniDrive.stopDrive();
            hardware.omniDrive.frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            hardware.omniDrive.frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            hardware.omniDrive.backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            hardware.omniDrive.backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
        return !busy;
    }
}
