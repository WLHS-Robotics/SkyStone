package org.firstinspires.ftc.teamcode.autonomous.sequences;

import org.firstinspires.ftc.teamcode.action.ColorActionBlue;
import org.firstinspires.ftc.teamcode.action.MoveAction;
import org.firstinspires.ftc.teamcode.action.RotateAction;
import org.firstinspires.ftc.teamcode.action.SuckAction;
import org.firstinspires.ftc.teamcode.autonomous.ActionSequence;
import org.firstinspires.ftc.teamcode.autonomous.DirectionalMoveAction;
import org.firstinspires.ftc.teamcode.hardware.OmniDrive;

public class BlueAllianceSequence extends ActionSequence {


    public BlueAllianceSequence() {
        addAction(new DirectionalMoveAction(OmniDrive.Direction.LEFT, 24, 0.7f));


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
