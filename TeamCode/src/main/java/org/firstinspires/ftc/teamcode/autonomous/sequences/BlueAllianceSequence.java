package org.firstinspires.ftc.teamcode.autonomous.sequences;

import org.firstinspires.ftc.teamcode.action.MoveAction;
import org.firstinspires.ftc.teamcode.action.RotateAction;
import org.firstinspires.ftc.teamcode.action.SuckAction;
import org.firstinspires.ftc.teamcode.action.WaitAction;
import org.firstinspires.ftc.teamcode.autonomous.ActionSequence;
import org.firstinspires.ftc.teamcode.hardware.OmniDrive;

public class BlueAllianceSequence extends ActionSequence {


    public BlueAllianceSequence() {
        /*addAction(new MoveAction(.5, 24, OmniDrive.Direction.forwards, 5000));
        addAction(new RotateAction(45));
        addAction(new MoveAction(.5, 5, OmniDrive.Direction.forwards, 5000 ));
        addAction(new SuckAction(1, 2000));
        addAction(new MoveAction(.5, 5, OmniDrive.Direction.backwards, 5000));
        addAction(new RotateAction(225));
        addAction(new MoveAction(1, 36, OmniDrive.Direction.forwards, 5000));
        addAction(new RotateAction(90));
        addAction(new MoveAction(.25, 4, OmniDrive.Direction.forwards, 3000));
        // to do: drop the block
        addAction(new MoveAction(.25, 4, MoveAction.Direction.forwards, 3000));
        addAction(new RotateAction(90));
        addAction(new MoveAction(1, 20, MoveAction.Direction.forwards, 5000));*/
    }


}
//Autonomous course of action

//move towards the block using MoveAction
//rotate to the systone picture using rotate action
//use tensor flow to find a skystone block using SenseAction (Go down the row and scan each block for a sktston eat a time)
//repeat scan,turn, move, turn until we find our skystone, then suck

//suck up said block using Suck action

//return to base, put block on base using Armaction (Does not exist yet)
//go back to block area, suck up the first available block

//autonomous will be over
