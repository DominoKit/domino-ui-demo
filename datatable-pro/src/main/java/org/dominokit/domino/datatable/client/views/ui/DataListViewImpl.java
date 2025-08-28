package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.datatable.client.presenters.DataListProxy;
import org.dominokit.domino.datatable.client.views.DatatableView;
import org.dominokit.domino.datatable.client.views.model.ContactGenerator;
import org.dominokit.domino.datatable.client.views.model.DemoContact;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.IntegerBox;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;
import org.dominokit.pro.domino.ui.data.CheckableDataListItem;
import org.dominokit.pro.domino.ui.data.DataList;
import org.dominokit.pro.domino.ui.data.DataListItem;

import static org.dominokit.domino.ui.utils.Domino.*;

@UiView(presentable = DataListProxy.class)
@SampleClass(includeClassName = true)
public class DataListViewImpl extends BaseDemoView<HTMLDivElement> implements DatatableView {

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

        basicDataList();
        element.appendChild(CodeCard.createLazyCodeCard(DataListViewImpl_CodeResource.INSTANCE.basicDataList()));

        dataList();
        element.appendChild(CodeCard.createLazyCodeCard(DataListViewImpl_CodeResource.INSTANCE.dataList()));

        return element.element();
    }

    @SampleMethod
    private void basicDataList() {
        DataList<DemoContact> scrollPanel = DataList.<DemoContact>create(record ->
                        DataListItem.create(record.getFirstName(), record)
                                .addCss(dui_p_2, dui_border_b_grey_l_2, dui_border_b, dui_border_0, dui_border_solid)

                );
        element.appendChild(Card.create("BASIC DATA LIST")
                .appendChild(IntegerBox.create("Items count")
                        .addCss(dui_max_w_64)
                        .withValue(250000)
                        .apply(box -> {
                            box
                                    .appendChild(PostfixAddOn.of(Button.create("Load")
                                            .addClickListener(evt -> {
                                                int count = box.getValue();
                                                scrollPanel.setItems(ContactGenerator.generateContacts(count));
                                            })
                                    ));
                        }))
                .appendChild(div().setHeight("500px")
                        .appendChild(scrollPanel.setWidth("500px"))
                )
        );

    }

    @SampleMethod
    private void dataList() {
        DataList<DemoContact> scrollPanel = new DataList<DemoContact>(record ->
                CheckableDataListItem.create(record.getFirstName(), record)
                        .appendChild(small().textContent(record.getEmail()))
                        .appendChild(PrefixAddOn.of(Icons.drag_vertical()))
                        .appendChild(PostfixAddOn.of(Icons.information_outline()))
                        .addCss(dui_p_2, dui_border_b_grey_l_2, dui_border_b, dui_border_0, dui_border_solid)
        )

                .setIcon(Icons.file())
                .setTitle("Files")
                .setMultiSelect(true)
                .withHeader((menu, header) -> header
                        .appendChild(PostfixAddOn.of(Icons.folder_key_outline()
                                        .addCss(dui_font_size_5)
                                        .clickable()
                                        .addClickListener(evt -> {
                                            Notification.create("Action clicked").show();
                                        })
                                )
                        )
                        .appendChild(PostfixAddOn.of(Icons.folder_heart_outline()
                                        .addCss(dui_font_size_5)
                                        .clickable()
                                        .addClickListener(evt -> {
                                            Notification.create("Action clicked").show();
                                        })
                                )
                        )
                        .appendChild(PostfixAddOn.of(ToggleMdiIcon.create(Icons.checkbox_multiple_outline()
                                                                .addCss(dui_font_size_5)
                                                                .clickable(),
                                                        Icons.close_box_multiple_outline()
                                                                .addCss(dui_font_size_5)
                                                                .clickable()
                                                )
                                                .toggleOnClick(true)
                                                .onToggle(icon -> {
                                                    boolean toggled = icon.isToggled();
                                                    DomGlobal.setTimeout(p0 -> {
                                                        if (toggled) {
                                                            menu.deselectAll();
                                                        } else {
                                                            menu.selectAll();
                                                        }
                                                    });
                                                })
                                )
                        )
                )
                .setSearchable((record, token, caseSensitive) -> {
                    if (caseSensitive) {
                        return (record.getFirstName()).contains(token);
                    }
                    return (record.getFirstName()).toLowerCase().contains(token.toLowerCase());
                });
        element.appendChild(Card.create("MULTI SELECT DATA LIST")
                .appendChild(IntegerBox.create("Items count")
                        .addCss(dui_max_w_64)
                        .withValue(250000)
                        .apply(box -> {
                            box
                                    .appendChild(PostfixAddOn.of(Button.create("Load")
                                            .addClickListener(evt -> {
                                                int count = box.getValue();
                                                scrollPanel.setItems(ContactGenerator.generateContacts(count));
                                            })
                                    ));
                        }))
                .appendChild(div().setHeight("500px")
                        .appendChild(scrollPanel.setWidth("500px"))
                )
        );

    }


}
