package org.dominokit.domino.basicforms.client.views.ui;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.grid.flex.FlexDirection;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.gwt.elemento.core.InputType;

import static org.jboss.gwt.elemento.core.Elements.input;
//public abstract class AbstractValueBox<T extends AbstractValueBox<T, E, V>, E extends HTMLElement, V>
//        extends ValueBox<T, E, V> implements HasLength<T> {
public abstract class TempField<T extends TempField<T, E, V>, E extends HTMLElement, V> extends BaseDominoElement<E, TempField<T, E, V>> {

    private FlexLayout fieldGroup = FlexLayout.create();
    private FlexItem fieldContainer = FlexItem.create();
    private FlexItem inputContainer = FlexItem.create();
    private FlexItem notesContainer = FlexItem.create();

    private FlexLayout leftAddOns = FlexLayout.create();
    private FlexLayout rightAddOns = FlexLayout.create();

    private FlexItem helpItem = FlexItem.create();
    private FlexItem countItem = FlexItem.create();
    private FlexItem errorItem = FlexItem.create();

    private FlexItem mandatoryAddon = FlexItem.create();
    private FlexItem prefixItem = FlexItem.create();
    private FlexItem postFixItem = FlexItem.create();

    private String prefixText = "$";

    private String postFixText = "@gmail.com";


    public TempField() {
        init(this);
        fieldGroup.css("field-group");
        fieldGroup.setDirection(FlexDirection.TOP_TO_BOTTOM);
        fieldContainer
                .setFlexGrow(1)
                .css("field-flx");
        notesContainer
                .setFlexGrow(1)
                .css("notes-flx");

        leftAddOns
                .css("field-lft-addons");
        rightAddOns
                .css("field-rgt-addons");

        fieldGroup
                .appendChild(fieldContainer
                        .appendChild(FlexLayout.create()
                                .appendChild(leftAddOns
                                        .appendChild(Icons.ALL.heart_mdi())
                                )
                                .appendChild(prefixItem
                                        .appendChild(TextNode.of(prefixText))
                                )
                                .appendChild(inputContainer
                                        .setFlexGrow(1)
                                        .appendChild(input(InputType.text).style("width:100%"))
                                )
                                .appendChild(postFixItem
                                        .appendChild(TextNode.of(postFixText))
                                )
                                .appendChild(mandatoryAddon)
                                .appendChild(rightAddOns
                                        .appendChild(Icons.ALL.eye_mdi())
                                )
                        )
                )
                .appendChild(notesContainer
                        .appendChild(FlexLayout.create()
                                .appendChild(helpItem.setFlexGrow(1)
                                        .appendChild(TextNode.of("This is a help text"))
                                )
                                .appendChild(errorItem.setFlexGrow(1)
                                        .appendChild(TextNode.of("This is an error message"))
                                )
                                .appendChild(countItem
                                        .appendChild(TextNode.of("3 / 4"))
                                )
                        )
                );
    }

}
