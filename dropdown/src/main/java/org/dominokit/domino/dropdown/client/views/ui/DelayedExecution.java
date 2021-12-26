package org.dominokit.domino.dropdown.client.views.ui;

import org.dominokit.domino.ui.utils.DelayedTextInput;
import org.gwtproject.timer.client.Timer;

public class DelayedExecution {

    public static void execute(DelayedAction delayedAction, int delay) {
        new Timer(){
            @Override
            public void run() {
                delayedAction.doAction();
            }
        }.schedule(delay);
    }

    /**
     * A function to implement the action to be taken for {@link DelayedTextInput}
     */
    @FunctionalInterface
    public interface DelayedAction {
        /**
         *
         */
        void doAction();
    }

}
