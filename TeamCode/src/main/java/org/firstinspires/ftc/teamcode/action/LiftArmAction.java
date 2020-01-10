package org.firstinspires.ftc.teamcode.action;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.autonomous.Action;
import org.firstinspires.ftc.teamcode.hardware.Hardware1920;

public class LiftArmAction implements Action {

    int height;
    double power;
   public LiftArmAction(int height, double power) {

       this.height = height;
       this.power = power;
   }

    @Override
    public void prepareAction(Hardware1920 hardware) {
      hardware.leftLiftMotor.setTargetPosition(hardware.leftLiftStartingPosition + height);
      hardware.rightLiftMotor.setTargetPosition(hardware.rightLiftStartingPosition + height);
      hardware.leftLiftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
      hardware.rightLiftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    @Override
    public boolean doAction(Hardware1920 hardware) {

       if (!hardware.leftLiftMotor.isBusy() || !hardware.rightLiftMotor.isBusy()){
           hardware.leftLiftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
           hardware.rightLiftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
           hardware.leftLiftMotor.setPower(0);
           hardware.rightLiftMotor.setPower(0);
           return true;
       } else {
           hardware.leftLiftMotor.setPower(hardware.leftLiftMotor.getCurrentPosition() < hardware.leftLiftMotor.getTargetPosition() ? power : -power);
           hardware.rightLiftMotor.setPower(hardware.rightLiftMotor.getCurrentPosition() < hardware.rightLiftMotor.getTargetPosition() ? power : -power);
           return false;
       }
    }
}
