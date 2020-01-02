package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.action.WaitAction;

import java.util.ArrayList;

public class ActionSequence {

    private int currentPosition = 0;


    public ArrayList<Action> actions = new ArrayList<Action>();

    public void addAction(Action action){

        actions.add(action);

    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public Action getCurrentAction() {

        if (currentPosition < actions.size()){
            return actions.get(currentPosition);
        }

        return null;
    }

    public void currentActionComplete(){

            currentPosition ++;
    }

    public int numberOfActions(){

            return actions.size();
    }

    public void initializeSequence() {

        currentPosition = 0;
    }




}

