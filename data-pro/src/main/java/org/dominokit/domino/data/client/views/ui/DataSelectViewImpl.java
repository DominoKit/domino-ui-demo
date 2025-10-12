package org.dominokit.domino.data.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.data.client.presenters.DataSelectProxy;
import org.dominokit.domino.data.client.views.DataView;
import org.dominokit.domino.data.client.views.model.ContactGenerator;
import org.dominokit.domino.data.client.views.model.DemoContact;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.IntegerBox;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.pro.domino.ui.data.DataList;
import org.dominokit.pro.domino.ui.data.DataListItem;
import org.dominokit.pro.domino.ui.data.DataSelect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.dominokit.domino.ui.utils.Domino.a;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_border_0;
import static org.dominokit.domino.ui.utils.Domino.dui_border_b;
import static org.dominokit.domino.ui.utils.Domino.dui_border_b_grey_l_2;
import static org.dominokit.domino.ui.utils.Domino.dui_border_solid;
import static org.dominokit.domino.ui.utils.Domino.dui_max_w_64;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

@UiView(presentable = DataSelectProxy.class)
@SampleClass(includeClassName = true)
public class DataSelectViewImpl extends BaseDemoView<HTMLDivElement> implements DataView {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSelectViewImpl.class);
    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div();

        element.appendChild(LinkToSourceCode.createLink("datalist", this.getClass()));
        element.appendChild(BlockHeader.create("DATA VIEWS", "For detailed demo code please visit: ")
                .appendChild(a()
                        .setAttribute("href", "https://github.com/DominoKit/domino-ui-demo/tree/master/data")
                        .setAttribute("target", "_blank")
                        .textContent("Data views demo source code"))
        );

        basicDataSelect();
        element.appendChild(CodeCard.createLazyCodeCard(DataSelectViewImpl_CodeResource.INSTANCE.basicDataSelect()));
        LOGGER.info("This is a test info log message");
        return element.element();
    }

    @SampleMethod
    private void basicDataSelect() {

        DataList<DemoContact, DataListItem<DemoContact>> dataList = DataList.<DemoContact, DataListItem<DemoContact>>create(record ->
                        DataListItem.create(record.getFirstName(), record)
                                .addCss(dui_p_2, dui_border_b_grey_l_2, dui_border_b, dui_border_0, dui_border_solid)

                )
                .setMaxHeight("300px")
                .setMinWidth("500px");
        element.appendChild(Card.create("BASIC DATA LIST")
                .appendChild(IntegerBox.create("Items count")
                        .addCss(dui_max_w_64)
                        .withValue(250000)
                        .apply(box -> {
                            box
                                    .appendChild(PostfixAddOn.of(Button.create("Load")
                                            .addClickListener(evt -> {
                                                int count = box.getValue();
                                                dataList.setItems(ContactGenerator.generateContacts(count));
                                            })
                                    ));
                        }))
                .appendChild(
                        Button.create("DROP LIST")
                                .setDropMenu(dataList)
                )
                .appendChild(DataSelect.<DemoContact>create(record -> DataListItem.create(record.getFirstName(), record)
                                .addCss(dui_p_2, dui_border_b_grey_l_2, dui_border_b, dui_border_0, dui_border_solid)

                        , DemoContact::getFirstName)
                        .setOptions(ContactGenerator.generateContacts(250000))
                )
        );

    }

}
