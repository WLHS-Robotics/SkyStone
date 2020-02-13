package org.firstinspires.ftc.teamcode.action;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.autonomous.Action;
import org.firstinspires.ftc.teamcode.hardware.Hardware1920;
import org.firstinspires.ftc.teamcode.hardware.OmniDrive;

public class MoveAction implements Action {

    double distance;
    OmniDrive.Direction direction;
    double timeout;
    double endTime;
    public float power;
    float fl_speed = 0;
    float fr_speed = 0;
    float bl_speed = 0;
    float br_speed = 0;

    public MoveAction(float power, double distance, OmniDrive.Direction direction, double timeout) {

        this.distance = distance;
        this.direction = direction;
        this.timeout = timeout;
        this.power = power;
    }
    public MoveAction(float power, double distance, OmniDrive.Direction direction) {

        this.distance = distance;
        this.direction = direction;
        this.timeout = 30000;
        this.power = power;
    }


    public void prepareAction(Hardware1920 hardware){

        endTime = System.currentTimeMillis() + timeout;

        int pos;
        if (direction == OmniDrive.Direction.LEFT || direction == OmniDrive.Direction.RIGHT){
            pos = (int) (distance * hardware.COUNTS_PER_LAT_INCH);
        } else {
            pos = (int) (distance * hardware.COUNTS_PER_INCH);
        }

        int fl_pos = hardware.omniDrive.frontLeft.getCurrentPosition();
        int fr_pos = hardware.omniDrive.frontRight.getCurrentPosition();
        int bl_pos = hardware.omniDrive.backLeft.getCurrentPosition();
        int br_pos = hardware.omniDrive.backRight.getCurrentPosition();

        switch (direction) {

            case FORWARD:
                hardware.omniDrive.frontLeft.setTargetPosition(fl_pos + pos);
                hardware.omniDrive.frontRight.setTargetPosition(fr_pos + pos);
                hardware.omniDrive.backLeft.setTargetPosition(bl_pos + pos);
                hardware.omniDrive.backRight.setTargetPosition(br_pos + pos);
                fl_speed = power;
                fr_speed = power;
                bl_speed = power;
                br_speed = power;
                break;
            case LEFT:
                hardware.omniDrive.frontLeft.setTargetPosition(fl_pos - pos);
                hardware.omniDrive.frontRight.setTargetPosition(fr_pos + pos);
                hardware.omniDrive.backLeft.setTargetPosition(bl_pos + pos);
                hardware.omniDrive.backRight.setTargetPosition(br_pos - pos);
                fl_speed = -power;
                fr_speed = power;
                bl_speed = power;
                br_speed = -power;
                break;
            case RIGHT:
                hardware.omniDrive.frontLeft.setTargetPosition(fl_pos + pos);
                hardware.omniDrive.frontRight.setTargetPosition(fr_pos - pos);
                hardware.omniDrive.backLeft.setTargetPosition(bl_pos - pos);
                hardware.omniDrive.backRight.setTargetPosition(br_pos + pos);
                fl_speed = power;
                fr_speed = -power;
                bl_speed = -power;
                br_speed = power;
                break;
            case BACKWARD:
                hardware.omniDrive.frontLeft.setTargetPosition(fl_pos - pos);
                hardware.omniDrive.frontRight.setTargetPosition(fr_pos - pos);
                hardware.omniDrive.backLeft.setTargetPosition(bl_pos - pos);
                hardware.omniDrive.backRight.setTargetPosition(br_pos - pos);
                fl_speed = -power;
                fr_speed = -power;
                bl_speed = -power;
                br_speed = -power;
                break;
            case FORWARD_LEFT:
                hardware.omniDrive.frontRight.setTargetPosition(fr_pos + pos);
                hardware.omniDrive.backLeft.setTargetPosition(bl_pos + pos);
                fr_speed = power;
                bl_speed = power;
                break;
            case FORWARD_RIGHT:
                hardware.omniDrive.frontLeft.setTargetPosition(fl_pos + pos);
                hardware.omniDrive.backRight.setTargetPosition(br_pos + pos);
                fl_speed = power;
                br_speed = power;
                break;
            case BACKWARD_LEFT:
                hardware.omniDrive.frontLeft.setTargetPosition(fl_pos - pos);
                hardware.omniDrive.backRight.setTargetPosition(br_pos - pos);
                fl_speed = -power;
                br_speed = -power;
                break;
            case BACKWARD_RIGHT:
                hardware.omniDrive.frontRight.setTargetPosition(fr_pos - pos);
                hardware.omniDrive.backLeft.setTargetPosition(bl_pos - pos);
                fr_speed = -power;
                bl_speed = -power;
                break;
            case ROTATE_LEFT:
                break;
            case ROTATE_RIGHT:
                break;
        }

        hardware.omniDrive.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        hardware.omniDrive.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        hardware.omniDrive.backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        hardware.omniDrive.backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    public boolean doAction(Hardware1920 hardware){
        boolean busy = hardware.omniDrive.frontLeft.isBusy() && hardware.omniDrive.frontRight.isBusy() && hardware.backLeft.isBusy() && hardware.backRight.isBusy();
        if (busy) {
            hardware.omniDrive.frontLeft.setPower(fl_speed);
            hardware.omniDrive.frontRight.setPower(fr_speed);
            hardware.omniDrive.backLeft.setPower(bl_speed);
            hardware.omniDrive.backRight.setPower(br_speed);
        } else {
            hardware.omniDrive.stopDrive();
            hardware.omniDrive.frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            hardware.omniDrive.frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            hardware.omniDrive.backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            hardware.omniDrive.backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        hardware.telemetry.addData("FLT", hardware.omniDrive.frontLeft.getTargetPosition());
        hardware.telemetry.addData("FRT", hardware.omniDrive.frontRight.getTargetPosition());
        hardware.telemetry.addData("BLT", hardware.omniDrive.backLeft.getTargetPosition());
        hardware.telemetry.addData("BRT", hardware.omniDrive.backRight.getTargetPosition());
        return !busy || System.currentTimeMillis() > endTime;
    }

}
