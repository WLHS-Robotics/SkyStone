package org.firstinspires.ftc.teamcode.action;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.autonomous.Action;
import org.firstinspires.ftc.teamcode.hardware.Hardware1920;

public class GripArmAction implements Action {
  public final int extendedDistance = 100;

    boolean extended;
    double power;

    public GripArmAction(boolean extended, double power){
        this.extended = extended;
        this.power = power;
    }

    @Override
    public void prepareAction(Hardware1920 hardware) {
        hardware.armMotor.setTargetPosition(extended ? hardware.armMotorStartingPosition + extendedDistance : hardware.armMotorStartingPosition);
        hardware.armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public boolean doAction(Hardware1920 hardware) {
        if (!hardware.armMotor.isBusy()){
            hardware.armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            hardware.armMotor.setPower(0);
            return true;
        } else {
            hardware.armMotor.setPower(hardware.armMotor.getCurrentPosition() < hardware.armMotor.getTargetPosition() ? power : -power);
            return false;
        }
    }

}
