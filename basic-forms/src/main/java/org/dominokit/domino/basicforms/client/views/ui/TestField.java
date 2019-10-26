package org.dominokit.domino.basicforms.client.views.ui;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.DominoElement;

import static java.util.Objects.isNull;
import static org.jboss.gwt.elemento.core.Elements.input;

public class TestField extends TempValueBox<TestField, HTMLInputElement, String> {

    private HTMLInputElement input;

    public TestField(String type, String label) {
        super(type, label);
    }

    @Override
    protected HTMLInputElement createInputElement(String type) {
        input = input("text").asElement();
        return input;
    }

    @Override
    protected void clearValue() {

    }

    @Override
    protected void doSetValue(String value) {

    }

    @Override
    public String getValue() {
        String value = getInputElement().asElement().value;
        if (value.isEmpty() && isEmptyAsNull()) {
            return null;
        }
        return value;
    }

    private boolean isEmptyAsNull() {
        return true;
    }

    @Override
    public boolean isEmpty() {
        String stringValue = getStringValue();
        return isNull(stringValue) || stringValue.isEmpty();
    }

    @Override
    public String getStringValue() {
        DominoElement<HTMLInputElement> inputElement = getInputElement();
        return inputElement.asElement().value;
    }

    @Override
    protected FlexItem createMandatoryAddOn() {
        return FlexItem.create().appendChild(Icons.ALL.chevron_down_mdi().clickable());
    }
}
