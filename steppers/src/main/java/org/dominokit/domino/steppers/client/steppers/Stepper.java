package org.dominokit.domino.steppers.client.steppers;

import elemental2.dom.HTMLUListElement;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.ul;

public class Stepper implements IsElement<HTMLUListElement> {

    private final HTMLUListElement element = ul().css("stepper").asElement();
    private Step activeStep;
    private List<Step> steps = new ArrayList<>();
    private StepperCompletionHandler stepperCompletionHandler = () -> {
    };

    public static Stepper create() {
        return new Stepper();
    }

    public Stepper addStep(Step step) {
        element.appendChild(step.asElement());
        if (isNull(activeStep)) {
            step.activate();
            this.activeStep = step;
        }
        steps.add(step);
        step.getStepHeader().asElement().addEventListener("click", evt -> onStepHeaderClicked(step));

        return this;
    }

    private void onStepHeaderClicked(Step step) {
        int activeStepIndex = steps.indexOf(this.activeStep);
        int stepIndex = steps.indexOf(step);
        if (this.activeStep.isValid() && (activeStepIndex == stepIndex - 1)) {
            next();
        } else if (stepIndex < activeStepIndex) {
            activateStep(step);
        } else {
            if (!this.activeStep.isValid() && activeStepIndex != stepIndex) {
                this.activeStep.invalidate();
            }
        }
    }

    @Override
    public HTMLUListElement asElement() {
        return element;
    }

    public Stepper activateStep(Step step) {
        if (steps.contains(step)) {
            this.activeStep.deActivate();
            step.activate();
            step.setDone(false);
            this.activeStep = step;
        }

        return this;
    }

    public Stepper invalidate() {
        if (nonNull(activeStep)) {
            activeStep.invalidate();
        }
        return this;
    }

    public Stepper next() {
        int activeStepIndex = steps.indexOf(activeStep);
        if (steps.size() > 1 && activeStepIndex < steps.size() - 1) {
            if (this.activeStep.isValid()) {
                this.activeStep.setDone(true);
                activateStep(steps.get(activeStepIndex + 1));
            } else {
                this.activeStep.invalidate();
            }
        }
        return this;
    }

    public Stepper back() {
        int activeStepIndex = steps.indexOf(activeStep);
        if (steps.size() > 1 && activeStepIndex <= steps.size() - 1 && activeStepIndex > 0) {
            activateStep(steps.get(activeStepIndex - 1));
        }
        return this;
    }

    public Stepper finish() {
        if (this.activeStep.isValid()) {
            stepperCompletionHandler.onFinish();
        } else {
            this.activeStep.invalidate();
        }

        return this;
    }

    public Stepper setCompletionHandler(StepperCompletionHandler completionHandler) {
        if (nonNull(completionHandler)) {
            this.stepperCompletionHandler = completionHandler;
        }

        return this;
    }

    @FunctionalInterface
    public interface StepperCompletionHandler {
        void onFinish();
    }
}
