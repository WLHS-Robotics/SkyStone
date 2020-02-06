/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.hardware.Hardware1920;
// public Ethan

@TeleOp(name="Manual", group="")
public class Manual extends Hardware1920 {

    boolean fastMode = false;
    boolean gripPress = false;
    boolean gripping = false;

    public final double suckPower = 1;
    public final double negativeSuckPower = -1;
    public final float SLOW_POWER = 0.75f;
    public final float FAST_POWER = 1;

    // Declare OpMode members.

    @Override
    public void loop() {
        super.loop();

        if (gamepad1.left_trigger > 0) {
            omniDrive.rotateLeft(gamepad1.left_trigger);
        } else if (gamepad1.right_trigger > 0) {
            omniDrive.rotateRight(gamepad1.right_trigger);
        } else {
            omniDrive.dpadMove(gamepad1, fastMode ? FAST_POWER : SLOW_POWER, false, true);
        }


        if (gamepad1.a) {
            leftSuck.setPower(suckPower);
            rightSuck.setPower(suckPower);
            backLeftSuck.setPower(suckPower);
            backRightSuck.setPower(suckPower);
        } else {
            leftSuck.setPower(0);
            rightSuck.setPower(0);
            backLeftSuck.setPower(0);
            backRightSuck.setPower(0);
        }

        if (gamepad1.x){
            leftSuck.setPower(negativeSuckPower);
            rightSuck.setPower(negativeSuckPower);
            backLeftSuck.setPower(negativeSuckPower);
            backRightSuck.setPower(negativeSuckPower);
        } else {
            leftSuck.setPower(0);
            rightSuck.setPower(0);
            backLeftSuck.setPower(0);
            backRightSuck.setPower(0);
        }

        if (gamepad1.b && !fastMode) {
            fastMode = true;
        } else {
            fastMode = false;
        }


       /* double lift = gamepad2.right_stick_y;
        double armMotion = gamepad2.left_stick_x;
        double liftPower = Range.clip(lift, -.5, .5);
        double armPower = Range.clip(armMotion, -.5, .5);
        //liftMotor.setPower(liftPower);
        armMotor.setPower(armPower);



        if (gamepad2.left_bumper && !gripPress) {
            leftGripServo.setPosition(gripping ? 0 : 0.5);
            rightGripServo.setPosition(gripping ? 0 : 0.5);
            gripPress = true;
            gripping = !gripping;
        }  else {
            gripPress = false;
        }


        */
    }
}
