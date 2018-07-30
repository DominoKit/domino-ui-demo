package org.dominokit.domino.steppers.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.steppers.client.presenters.SteppersPresenter;
import org.dominokit.domino.steppers.client.steppers.Step;
import org.dominokit.domino.steppers.client.steppers.Stepper;
import org.dominokit.domino.steppers.client.views.SteppersView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.header.BlockHeader;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = SteppersPresenter.class)
public class SteppersViewImpl extends ComponentView<HTMLDivElement> implements SteppersView {

    private final HTMLDivElement element = div().asElement();

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("STEPPERS").asElement());
        element.appendChild(Card.create()
                .appendChild(Stepper.create()
                        .addStep(Step.create("First step", "first step description")
                                .appendContent(Card.create("Sample card"))
                        .activate())
                        .addStep(Step.create("First step", "first step description")
                                .appendContent(Card.create("Sample card"))
                                )
                )
                .asElement());


        element.appendChild(Card.create()
                .appendChild(div().innerHtml(new SafeHtmlBuilder().appendHtmlConstant("<ul class=\"stepper linear\">\n" +
                        "                                 <li class=\"step active\">\n" +
                        "                                    <div data-step-label=\"There's labels too!\" class=\"step-title waves-effect waves-dark\">Step 1</div>\n" +
                        "                                    <div class=\"step-content\" style=\"display: block;\">\n" +
                        "                                       <div class=\"row\">\n" +
                        "                                          <div class=\"input-field col s12\">\n" +
                        "                                             <input name=\"email\" type=\"email\" class=\"validate\" required=\"\">\n" +
                        "                                             <label for=\"email\">Your e-mail</label>\n" +
                        "                                          </div>\n" +
                        "                                       </div>\n" +
                        "                                       <div class=\"step-actions\">\n" +
                        "                                          <button class=\"waves-effect waves-dark btn blue next-step\">CONTINUE</button>\n" +
                        "                                       </div>\n" +
                        "                                    </div>\n" +
                        "                                 </li>\n" +
                        "                                 <li class=\"step\">\n" +
                        "                                    <div class=\"step-title waves-effect waves-dark\">Step 2</div>\n" +
                        "                                    <div class=\"step-content\">\n" +
                        "                                       <div class=\"row\">\n" +
                        "                                          <div class=\"input-field col s12\">\n" +
                        "                                             <input id=\"\" name=\"password\" type=\"password\" class=\"validate\" required=\"\">\n" +
                        "                                             <label for=\"password\">Your password</label>\n" +
                        "                                          </div>\n" +
                        "                                       </div>\n" +
                        "                                       <div class=\"step-actions\">\n" +
                        "                                          <button class=\"waves-effect waves-dark btn blue next-step\">CONTINUE</button>\n" +
                        "                                          <button class=\"waves-effect waves-dark btn-flat previous-step\">BACK</button>\n" +
                        "                                       </div>\n" +
                        "                                    </div>\n" +
                        "                                 </li>\n" +
                        "                                 <li class=\"step\" data-last=\"true\">\n" +
                        "                                    <div class=\"step-title waves-effect waves-dark\">Step 3</div>\n" +
                        "                                    <div class=\"step-content\">\n" +
                        "                                       Finish!\n" +
                        "                                       <div class=\"step-actions\">\n" +
                        "                                          <button class=\"waves-effect waves-dark btn blue\" type=\"submit\">SUBMIT</button>\n" +
                        "                                       </div>\n" +
                        "                                    </div>\n" +
                        "                                 </li>\n" +
                        "                              </ul>").toSafeHtml())).asElement());

    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}