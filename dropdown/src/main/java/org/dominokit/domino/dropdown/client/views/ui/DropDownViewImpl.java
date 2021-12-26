package org.dominokit.domino.dropdown.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.dropdown.client.presenters.DropDownProxy;
import org.dominokit.domino.dropdown.client.views.DropDownView;
import org.dominokit.domino.dropdown.client.views.ui.position.BestFitSideDropDirection;
import org.dominokit.domino.dropdown.client.views.ui.position.BottomLeftDropDirection;
import org.dominokit.domino.dropdown.client.views.ui.position.BottomMiddleDropDirection;
import org.dominokit.domino.dropdown.client.views.ui.position.BottomRightDropDirection;
import org.dominokit.domino.dropdown.client.views.ui.position.LeftDownDropDirection;
import org.dominokit.domino.dropdown.client.views.ui.position.LeftMiddleDropDirection;
import org.dominokit.domino.dropdown.client.views.ui.position.LeftUpDropDirection;
import org.dominokit.domino.dropdown.client.views.ui.position.MiddleOfScreenDropDirection;
import org.dominokit.domino.dropdown.client.views.ui.position.RightDownDropDirection;
import org.dominokit.domino.dropdown.client.views.ui.position.RightMiddleDropDirection;
import org.dominokit.domino.dropdown.client.views.ui.position.RightUpDropDirection;
import org.dominokit.domino.dropdown.client.views.ui.position.TopLeftDropDirection;
import org.dominokit.domino.dropdown.client.views.ui.position.TopMiddleDropDirection;
import org.dominokit.domino.dropdown.client.views.ui.position.TopRightDropDirection;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexJustifyContent;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.Elements;

@UiView(presentable = DropDownProxy.class)
@SampleClass
public class DropDownViewImpl extends BaseDemoView<HTMLDivElement> implements DropDownView {

    private HTMLDivElement element = Elements.div().element();

    @Override
    protected HTMLDivElement init() {

        element.appendChild(LinkToSourceCode.create("dropdown", DropDownViewImpl.class).element());
        element.appendChild(BlockHeader.create("Drop down")
                .element());

        basicDropDown();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.basicDropDown()).element());


        return element;
    }

    @SampleMethod
    private void basicDropDown() {


        element
                .appendChild(Card.create("BASIC DROPDOWN", "Basic dropdown for building simple menu with simple text items")
                        .apply(self -> self.getBody().setCssProperty("text-align", "center"))
                        .appendChild(createDropDown(new TopLeftDropDirection(), "TOP-LEFT"))
                        .appendChild(createDropDown(new TopRightDropDirection(), "TOP-RIGHT"))
                        .appendChild(createDropDown(new BottomLeftDropDirection(), "BOTTOM-LEFT"))
                        .appendChild(createDropDown(new BottomRightDropDirection(), "BOTTOM-RIGHT"))
                        .appendChild(createDropDown(new RightUpDropDirection(), "RIGHT-UP"))
                        .appendChild(createDropDown(new RightDownDropDirection(), "RIGHT-DOWN"))
                        .appendChild(createDropDown(new LeftUpDropDirection(), "LEFT-UP"))
                        .appendChild(createDropDown(new LeftDownDropDirection(), "LEFT-DOWN"))
                        .appendChild(createDropDown(new TopMiddleDropDirection(), "TOP-MIDDLE"))
                        .appendChild(createDropDown(new BottomMiddleDropDirection(), "BOTTOM-MIDDLE"))
                        .appendChild(createDropDown(new LeftMiddleDropDirection(), "LEFT-MIDDLE"))
                        .appendChild(createDropDown(new RightMiddleDropDirection(), "RIGHT-MIDDLE"))
                        .appendChild(createDropDown(new BestFitSideDropDirection(), "BEST-FIT"))
                        .appendChild(createDropDown(new MiddleOfScreenDropDirection(), "MiddleOfScreen"))
                        .element());

        element.appendChild(Card.create("BASIC DROPDOWN", "Basic dropdown for building simple menu with simple text items")
                .apply(self -> self.getBody().setCssProperty("text-align", "center"))
                .appendChild(FlexLayout.create()
                        .setGap("20px")
                        .setJustifyContent(FlexJustifyContent.SPACE_BETWEEN)
                        .appendChild(FlexItem.create().appendChild(createDropDown(new BestFitSideDropDirection(), "BEST-FIT")))
                        .appendChild(FlexItem.create().appendChild(createDropDown(new BestFitSideDropDirection(), "BEST-FIT")))
                        .appendChild(FlexItem.create().appendChild(createDropDown(new BestFitSideDropDirection(), "BEST-FIT")))
                        .appendChild(FlexItem.create().appendChild(createDropDown(new BestFitSideDropDirection(), "BEST-FIT")))
                        .appendChild(FlexItem.create().appendChild(createDropDown(new BestFitSideDropDirection(), "BEST-FIT")))
                        .appendChild(FlexItem.create().appendChild(createDropDown(new BestFitSideDropDirection(), "BEST-FIT")))
                        .appendChild(FlexItem.create().appendChild(createDropDown(new BestFitSideDropDirection(), "BEST-FIT")))
                        .appendChild(FlexItem.create().appendChild(createDropDown(new BestFitSideDropDirection(), "BEST-FIT")))
                        .appendChild(FlexItem.create().appendChild(createDropDown(new BestFitSideDropDirection(), "BEST-FIT")))
                        .appendChild(FlexItem.create().appendChild(createDropDown(new BestFitSideDropDirection(), "BEST-FIT")))
                        .appendChild(FlexItem.create().appendChild(createDropDown(new BestFitSideDropDirection(), "BEST-FIT")))
                        .appendChild(FlexItem.create().appendChild(createDropDown(new BestFitSideDropDirection(), "BEST-FIT")))
                )
                .element())
        ;
    }

    private Button createDropDown(DropDown.ElementPosition position, String text) {
        Button button = Button.create(text)
                .css(Styles.m_r_10, Styles.m_l_10);
        DropDown dropDown = new DropDown()
                .setTargetElement(button);
        dropDown.setPosition(position);
        DominoElement.body().addClickListener(evt -> dropDown.close());

        dropDown
                .setIcon(Icons.ALL.menu_mdi())
                .setTitle("Dropdown menu sample")
                .appendAction(Icons.ALL.link_variant_mdi().size18().clickable())
                .appendAction(Icons.ALL.forward_mdi().size18().clickable())
                .appendAction(Icons.ALL.star_mdi().size18().clickable())
                .appendSunHeaderChild(SearchBox.create()
                        .apply(self -> {
                            dropDown.addCloseHandler(self::clearSearch);
                            dropDown.setFocusElement(self.getTextBox().getInputElement());
                        })
                        .addSearchListener(dropDown::onSearch)

                )
                .appendChild(SimpleDropDownItem.create("Sample item")
                        .addClickListener(evt -> {
                            Notification.create("Hello").show();
                        })
                )
                .appendChild(SimpleDropDownItem.create("Sample item", "Item with some description"))
                .appendSeparator()
                .appendChild(SimpleDropDownItem.create("Sample item")
                        .setLeftAddOn(Icons.ALL.headset_mdi().size18())
                        .setRightAddOn(Icons.ALL.more_mdi().size18())
                        .addClickListener(evt -> {
                            Notification.create("Hello").show();
                        })
                )
                .appendChild(SimpleDropDownItem.create("Sample item", "Item with some description")
                        .setLeftAddOn(Icons.ALL.headset_mdi().size18())
                        .setRightAddOn(Icons.ALL.more_mdi().size18())
                )
                .appendSeparator()
                .appendChild(CustomDropDownItem.create()
                        .appendChild(FlexLayout.create()
                                .setJustifyContent(FlexJustifyContent.CENTER)
                                .setGap("10px")
                                .appendChild(FlexItem.create().appendChild(Icons.ALL.content_cut_mdi().clickable()))
                                .appendChild(FlexItem.create().appendChild(Icons.ALL.content_copy_mdi().clickable()))
                                .appendChild(FlexItem.create().appendChild(Icons.ALL.content_paste_mdi().clickable()))
                        )
                )
                .appendSeparator()
                .appendChild(SimpleDropDownItem.create("Sample item")
                        .setLeftAddOn(Icons.ALL.headset_mdi().size18())
                        .setRightAddOn(Icons.ALL.more_mdi().size18())
                        .setDropDown(new DropDown()
                                .setTitle("Drop down 1"))
                )
                .appendChild(SimpleDropDownItem.create("Sample item", "Item with some description")
                        .setLeftAddOn(Icons.ALL.headset_mdi().size18())
                        .setRightAddOn(Icons.ALL.more_mdi().size18())
                        .setDropDown(new DropDown()
                                .setTitle("Drop 2")
                                .appendChild(SimpleDropDownItem.create("Sample item", "Item with some description")
                                        .setLeftAddOn(Icons.ALL.headset_mdi().size18())
                                        .setRightAddOn(Icons.ALL.more_mdi().size18()))
                                .appendChild(SimpleDropDownItem.create("Sample item", "Item with some description")
                                        .setLeftAddOn(Icons.ALL.headset_mdi().size18())
                                        .setRightAddOn(Icons.ALL.more_mdi().size18())
                                        .setDropDown(new DropDown()
                                                .setTitle("Drop 3")
                                                .appendChild(SimpleDropDownItem.create("Sample item", "Item with some description")
                                                        .setLeftAddOn(Icons.ALL.headset_mdi().size18())
                                                        .setRightAddOn(Icons.ALL.more_mdi().size18()))
                                                .appendChild(SimpleDropDownItem.create("Sample item", "Item with some description")
                                                        .setLeftAddOn(Icons.ALL.headset_mdi().size18())
                                                        .setRightAddOn(Icons.ALL.more_mdi().size18())
                                                        .setDropDown(new DropDown()
                                                                .setTitle("Drop 4")
                                                                .appendChild(SimpleDropDownItem.create("Sample item", "Item with some description")
                                                                        .setLeftAddOn(Icons.ALL.headset_mdi().size18())
                                                                        .setRightAddOn(Icons.ALL.more_mdi().size18()))
                                                                .appendChild(SimpleDropDownItem.create("Sample item", "Item with some description")
                                                                        .setLeftAddOn(Icons.ALL.headset_mdi().size18())
                                                                        .setRightAddOn(Icons.ALL.more_mdi().size18()))
                                                                .appendChild(SimpleDropDownItem.create("Sample item", "Item with some description")
                                                                        .setLeftAddOn(Icons.ALL.headset_mdi().size18())
                                                                        .setRightAddOn(Icons.ALL.more_mdi().size18()))
                                                                .appendChild(SimpleDropDownItem.create("Sample item", "Item with some description")
                                                                        .setLeftAddOn(Icons.ALL.headset_mdi().size18())
                                                                        .setRightAddOn(Icons.ALL.more_mdi().size18()))
                                                                .appendChild(SimpleDropDownItem.create("Sample item", "Item with some description")
                                                                        .setLeftAddOn(Icons.ALL.headset_mdi().size18())
                                                                        .setRightAddOn(Icons.ALL.more_mdi().size18()))
                                                                .appendChild(SimpleDropDownItem.create("Sample item", "Item with some description")
                                                                        .setLeftAddOn(Icons.ALL.headset_mdi().size18())
                                                                        .setRightAddOn(Icons.ALL.more_mdi().size18()))
                                                                .appendChild(SimpleDropDownItem.create("Sample item", "Item with some description")
                                                                        .setLeftAddOn(Icons.ALL.headset_mdi().size18())
                                                                        .setRightAddOn(Icons.ALL.more_mdi().size18()))
                                                                .appendChild(SimpleDropDownItem.create("Sample item", "Item with some description")
                                                                        .setLeftAddOn(Icons.ALL.headset_mdi().size18())
                                                                        .setRightAddOn(Icons.ALL.more_mdi().size18()))
                                                                .appendChild(SimpleDropDownItem.create("Sample item", "Item with some description")
                                                                        .setLeftAddOn(Icons.ALL.headset_mdi().size18())
                                                                        .setRightAddOn(Icons.ALL.more_mdi().size18()))
                                                        )
                                                )

                                        )
                                )
                                .appendChild(SimpleDropDownItem.create("Sample item", "Item with some description")
                                        .setLeftAddOn(Icons.ALL.headset_mdi().size18())
                                        .setRightAddOn(Icons.ALL.more_mdi().size18()))

                        )
                )
                .appendChild(SimpleDropDownItem.create("Sample item")
                        .setDropDown(new DropDown()
                                .setTitle("Drop down 5"))
                )
                .appendChild(SimpleDropDownItem.create("Sample item", "Item with some description")
                        .setDropDown(new DropDown()
                                .setTitle("Drop down 6"))
                )
        ;
        return button;
    }

}