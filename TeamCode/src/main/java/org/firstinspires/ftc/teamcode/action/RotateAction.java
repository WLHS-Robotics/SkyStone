package org.firstinspires.ftc.teamcode.action;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.autonomous.Action;
import org.firstinspires.ftc.teamcode.hardware.Hardware1920;

public class RotateAction implements Action {

    public double degrees;
    public final double TURN_POWER = 0.4;

    public RotateAction(double degrees){
        this.degrees = degrees;
    }

    @Override
    public void prepareAction(Hardware1920 hardware) {
        hardware.leftDrive.setTargetPosition((int) (hardware.leftDrive.getCurrentPosition() + (degrees/360D*hardware.ROBOT_CIRCUMFRENCE)));
        hardware.rightDrive.setTargetPosition((int) -(hardware.rightDrive.getCurrentPosition() + (degrees/360D*hardware.ROBOT_CIRCUMFRENCE)));
        hardware.leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        hardware.rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public boolean doAction(Hardware1920 hardware) {
        hardware.telemetry.addData("Current Left", hardware.leftDrive.getCurrentPosition());
        hardware.telemetry.addData("Current Right", hardware.rightDrive.getCurrentPosition());
        hardware.telemetry.addData("Left Power", hardware.leftDrive.getPower());
        hardware.telemetry.addData("Right Power", hardware.rightDrive.getPower());
        hardware.telemetry.addData("Left Target", hardware.leftDrive.getTargetPosition());
        hardware.telemetry.addData("Right Target", hardware.rightDrive.getTargetPosition());


        if (!hardware.leftDrive.isBusy() && !hardware.rightDrive.isBusy()) {
            hardware.leftDrive.setPower(0);
            hardware.rightDrive.setPower(0);
            hardware.leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            hardware.rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            return true;
        } else {
            hardware.leftDrive.setPower(hardware.leftDrive.getCurrentPosition() < hardware.leftDrive.getTargetPosition() ? TURN_POWER : -TURN_POWER);
            hardware.rightDrive.setPower(hardware.rightDrive.getCurrentPosition() < hardware.rightDrive.getTargetPosition() ? TURN_POWER : -TURN_POWER);
            return false;
        }
    }
}
