package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.hardware.Hardware1920;

//the mold of the program
public class ActionExecutor {

    private Action currentAction = null;



    public ActionSequence sequence;
    private Hardware1920 hardware;


    //fills the mold of the program
    public ActionExecutor(ActionSequence sequence, Hardware1920 hardware){

        this.sequence = sequence;
        this.hardware = hardware;

    }

    public void init(){

        sequence.initializeSequence();

    }

    boolean didInit = false;

    public boolean loop() {
        // Get the current action of the sequence.
        currentAction = sequence.getCurrentAction();

        // Make sure our action isn't null, because if it is, it means we've run out of
        // actions to complete and therefore we our done with our sequence.
        if (currentAction != null){

            // Test if we've initialized the action yet.
            if (!didInit){
                // Initialize the action, and set the didInit to true so that we don't end up
                // initializing the action every iteration of the loop.
                currentAction.prepareAction(hardware);
                didInit = true;
            }

            // Run one "loop" of our action, which will return true if the action is complete,
            // and false otherwise.
            if (currentAction.doAction(hardware)){
                // The action is done, so make sure we tell the sequence that the action is complete
                // and that we reset the didInit variable so that the next action can be initialized.

                sequence.currentActionComplete();
                didInit = false;

            }

            // Update telemetry with useful information.

            //  Display progress through sequence
            hardware.telemetry.addData("Sequence Progress", "%d/%d",
                    sequence.getCurrentPosition() + 1,
                    sequence.numberOfActions());

            //  Display current action that we're executing
            hardware.telemetry.addData("Current Action", currentAction.getClass().getSimpleName());

        }

        // Remember, this function returns true if it's complete. Therefore, if there is no further
        // action to work on, we are done with the sequence, the action therefore equals null, and
        // below will return true. Otherwise, it will not be null, therefore below will return false,
        // and indicate that we're still working.
        return currentAction == null;

    }







}
