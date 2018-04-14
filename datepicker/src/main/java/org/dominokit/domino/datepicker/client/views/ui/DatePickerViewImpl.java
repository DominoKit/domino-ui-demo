package org.dominokit.domino.datepicker.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.datepicker.client.views.DatePickerView;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.datepicker.client.presenters.DatePickerPresenter;
import org.dominokit.domino.ui.header.BlockHeader;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = DatePickerPresenter.class)
public class DatePickerViewImpl extends ComponentView<HTMLDivElement> implements DatePickerView{

    private HTMLDivElement element=div().asElement();

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("DATE PICKERS").asElement());
    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}