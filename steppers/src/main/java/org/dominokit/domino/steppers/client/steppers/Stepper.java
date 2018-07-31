package org.dominokit.domino.steppers.client.steppers;

import elemental2.dom.HTMLUListElement;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.isNull;
import static org.jboss.gwt.elemento.core.Elements.ul;

public class Stepper implements IsElement<HTMLUListElement> {

    private final HTMLUListElement element = ul().css("stepper").asElement();
    private Step activeStep;

    public static Stepper create() {
        return new Stepper();
    }

    public Stepper addStep(Step step) {
        element.appendChild(step.asElement());
        if (isNull(activeStep)) {
            step.activate();
            this.activeStep = step;
        }
        return this;
    }

    @Override
    public HTMLUListElement asElement() {
        return element;
    }
}
