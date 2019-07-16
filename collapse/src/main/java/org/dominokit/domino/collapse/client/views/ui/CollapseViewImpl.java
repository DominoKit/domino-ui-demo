package org.dominokit.domino.collapse.client.views.ui;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.collapse.client.presenters.CollapseProxy;
import org.dominokit.domino.collapse.client.views.CollapseView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.collapsible.Accordion;
import org.dominokit.domino.ui.collapsible.AccordionPanel;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.TextNode;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;

import static org.jboss.gwt.elemento.core.Elements.b;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = CollapseProxy.class)
@SampleClass
public class CollapseViewImpl extends BaseDemoView<HTMLDivElement> implements CollapseView {

    private static final String SAMPLE_CONTENT = "Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.";

    private HTMLDivElement element = div().asElement();

    @Override
    protected void init(HTMLDivElement root) {
        element.appendChild(LinkToSourceCode.create("collapse", this.getClass()).asElement());

        example();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.example())
                .asElement());

        accordionSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.accordionSample())
                .asElement());

        colorFullWithIcons();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.colorFullWithIcons())
                .asElement());

        multiOpenItems();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.multiOpenItems())
                .asElement());
    }

    @Override
    public HTMLDivElement createRoot() {
        element = div().asElement();
        return element;
    }

    @SampleMethod
    private void example() {

        element.appendChild(BlockHeader.create("COLLAPSE").asElement());
        HTMLDivElement well = div()
                .add(div()
                        .css("well")
                        .textContent(SAMPLE_CONTENT)
                        .asElement())
                .asElement();

        Collapsible collapsible = Collapsible.create(well);
        EventListener collapsibleListener = evt -> collapsible.toggleDisplay();

        Button anchorButton = Button.create("LINK WITH HREF");
        anchorButton.getClickableElement().addEventListener("click", collapsibleListener);

        Button button = Button.create("BUTTON");
        button.getClickableElement().addEventListener("click", collapsibleListener);

        element.appendChild(Row.create()
                .addColumn(Column.span12()
                        .appendChild(Card.create("EXAMPLE", "click the buttons below to show and hide another element via class changes.")
                                .appendChild(anchorButton.builder()
                                        .css(Styles.m_b_15).build().setBackground(Color.PINK))
                                .appendChild(TextNode.of("\n"))
                                .appendChild(button.builder()
                                        .css(Styles.m_b_15).build()
                                        .setBackground(Color.CYAN)
                                        .asElement())
                                .appendChild(collapsible)))
                .asElement());


    }

    @SampleMethod
    private void accordionSample() {
        element.appendChild(BlockHeader.create("ACCORDION").asElement());
        element.appendChild(Row.create()
                .addColumn(Column.span6()
                        .appendChild(Card.create("BASIC EXAMPLES", "Extend the default collapse behavior to create an accordion with the panel component.")
                                .setCollapsible()
                                .appendChild(b().textContent("Panel Primary"))
                                .appendChild(Accordion.create()
                                        .appendChild(AccordionPanel.create("Collapsible item 1", TextNode.of(SAMPLE_CONTENT)).show())
                                        .appendChild(AccordionPanel.create("Collapsible item 2", TextNode.of(SAMPLE_CONTENT)))
                                        .appendChild(AccordionPanel.create("Collapsible item 3", TextNode.of(SAMPLE_CONTENT)))
                                        .primary())
                                .appendChild(b().textContent("Panel Success"))
                                .appendChild(Accordion.create()
                                        .appendChild(AccordionPanel.create("Collapsible item 1", TextNode.of(SAMPLE_CONTENT)).show())
                                        .appendChild(AccordionPanel.create("Collapsible item 2", TextNode.of(SAMPLE_CONTENT)))
                                        .appendChild(AccordionPanel.create("Collapsible item 3", TextNode.of(SAMPLE_CONTENT)))
                                        .success())
                                .appendChild(b().textContent("Panel Warning"))
                                .appendChild(Accordion.create()
                                        .appendChild(AccordionPanel.create("Collapsible item 1", TextNode.of(SAMPLE_CONTENT)).show())
                                        .appendChild(AccordionPanel.create("Collapsible item 2", TextNode.of(SAMPLE_CONTENT)))
                                        .appendChild(AccordionPanel.create("Collapsible item 3", TextNode.of(SAMPLE_CONTENT)))
                                        .warning())
                                .appendChild(b().textContent("Panel Danger").asElement())
                                .appendChild(Accordion.create()
                                        .appendChild(AccordionPanel.create("Collapsible item 1", TextNode.of(SAMPLE_CONTENT)).show())
                                        .appendChild(AccordionPanel.create("Collapsible item 2", TextNode.of(SAMPLE_CONTENT)))
                                        .appendChild(AccordionPanel.create("Collapsible item 3", TextNode.of(SAMPLE_CONTENT)))
                                        .danger())))
                .addColumn(Column.span6()
                        .appendChild(Card.create("FULL BODY EXAMPLES", "If you want to also colorful body, you need to use fullBody method.")
                                .setCollapsible()
                                .appendChild(b().textContent("Panel Primary"))
                                .appendChild(Accordion.create()
                                        .appendChild(AccordionPanel.create("Collapsible item 1", TextNode.of(SAMPLE_CONTENT)).show())
                                        .appendChild(AccordionPanel.create("Collapsible item 2", TextNode.of(SAMPLE_CONTENT)))
                                        .appendChild(AccordionPanel.create("Collapsible item 3", TextNode.of(SAMPLE_CONTENT)))
                                        .primaryFull())
                                .appendChild(b().textContent("Panel Success"))
                                .appendChild(Accordion.create()
                                        .appendChild(AccordionPanel.create("Collapsible item 1", TextNode.of(SAMPLE_CONTENT)).show())
                                        .appendChild(AccordionPanel.create("Collapsible item 2", TextNode.of(SAMPLE_CONTENT)))
                                        .appendChild(AccordionPanel.create("Collapsible item 3", TextNode.of(SAMPLE_CONTENT)))
                                        .successFull())
                                .appendChild(b().textContent("Panel Warning"))
                                .appendChild(Accordion.create()
                                        .appendChild(AccordionPanel.create("Collapsible item 1", TextNode.of(SAMPLE_CONTENT)).show())
                                        .appendChild(AccordionPanel.create("Collapsible item 2", TextNode.of(SAMPLE_CONTENT)))
                                        .appendChild(AccordionPanel.create("Collapsible item 3", TextNode.of(SAMPLE_CONTENT)))
                                        .warningFull())
                                .appendChild(b().textContent("Panel Danger"))
                                .appendChild(Accordion.create()
                                        .appendChild(AccordionPanel.create("Collapsible item 1", TextNode.of(SAMPLE_CONTENT)).show())
                                        .appendChild(AccordionPanel.create("Collapsible item 2", TextNode.of(SAMPLE_CONTENT)))
                                        .appendChild(AccordionPanel.create("Collapsible item 3", TextNode.of(SAMPLE_CONTENT)))
                                        .dangerFull())))
                .asElement());


    }

    @SampleMethod
    private void colorFullWithIcons() {

        element.appendChild(Row.create()
                .addColumn(Column.span6()
                        .appendChild(Card.create("COLORFUL PANEL ITEMS WITH ICON")
                                .setCollapsible()
                                .appendChild(b().textContent("Panel Primary"))
                                .appendChild(Accordion.create()
                                        .appendChild(AccordionPanel.create("Collapsible item 1", TextNode.of(SAMPLE_CONTENT)).show()
                                                .setIcon(Icons.ALL.perm_contact_calendar())
                                                .setHeaderBackground(Color.PINK)
                                                .show())
                                        .appendChild(AccordionPanel.create("Collapsible item 2", TextNode.of(SAMPLE_CONTENT))
                                                .setIcon(Icons.ALL.cloud_download())
                                                .setHeaderBackground(Color.CYAN))
                                        .appendChild(AccordionPanel.create("Collapsible item 3", TextNode.of(SAMPLE_CONTENT))
                                                .setIcon(Icons.ALL.contact_phone())
                                                .setHeaderBackground(Color.TEAL))
                                        .appendChild(AccordionPanel.create("Collapsible item 4", TextNode.of(SAMPLE_CONTENT))
                                                .setIcon(Icons.ALL.folder_shared())
                                                .setHeaderBackground(Color.ORANGE)))))
                .addColumn(Column.span6()
                        .appendChild(Card.create("FULL BODY COLORFUL PANEL ITEMS WITH ICON")
                                .setCollapsible()
                                .appendChild(b().textContent("Panel Primary"))
                                .appendChild(Accordion.create()
                                        .appendChild(AccordionPanel.create("Collapsible item 1", TextNode.of(SAMPLE_CONTENT)).show()
                                                .setIcon(Icons.ALL.perm_contact_calendar())
                                                .setHeaderBackground(Color.PINK)
                                                .setBodyBackground(Color.PINK)
                                                .show())
                                        .appendChild(AccordionPanel.create("Collapsible item 2", TextNode.of(SAMPLE_CONTENT))
                                                .setIcon(Icons.ALL.cloud_download())
                                                .setHeaderBackground(Color.CYAN)
                                                .setBodyBackground(Color.CYAN))
                                        .appendChild(AccordionPanel.create("Collapsible item 3", TextNode.of(SAMPLE_CONTENT))
                                                .setIcon(Icons.ALL.contact_phone())
                                                .setHeaderBackground(Color.TEAL)
                                                .setBodyBackground(Color.TEAL))
                                        .appendChild(AccordionPanel.create("Collapsible item 4", TextNode.of(SAMPLE_CONTENT))
                                                .setIcon(Icons.ALL.folder_shared())
                                                .setHeaderBackground(Color.ORANGE)
                                                .setBodyBackground(Color.ORANGE)
                                        ))))
                .asElement());



    }

    @SampleMethod
    private void multiOpenItems() {

        element.appendChild(Row.create()
                .addColumn(Column.span12()
                        .appendChild(Card.create("MULTIPLE ITEMS TO BE OPEN")
                                .setCollapsible()
                                .appendChild(Accordion.create()
                                        .multiOpen()
                                        .appendChild(AccordionPanel.create("Collapsible item 1", TextNode.of(SAMPLE_CONTENT)).show()
                                                .setIcon(Icons.ALL.perm_contact_calendar())
                                                .setHeaderBackground(Color.PINK)
                                                .setBodyBackground(Color.PINK)
                                                .show())
                                        .appendChild(AccordionPanel.create("Collapsible item 2", TextNode.of(SAMPLE_CONTENT))
                                                .setIcon(Icons.ALL.cloud_download())
                                                .setHeaderBackground(Color.CYAN)
                                                .setBodyBackground(Color.CYAN)
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 3", TextNode.of(SAMPLE_CONTENT)).show()
                                                .setIcon(Icons.ALL.contact_phone())
                                                .setHeaderBackground(Color.TEAL)
                                                .setBodyBackground(Color.TEAL)
                                                .show())
                                        .appendChild(AccordionPanel.create("Collapsible item 4", TextNode.of(SAMPLE_CONTENT))
                                                .setIcon(Icons.ALL.folder_shared())
                                                .setHeaderBackground(Color.ORANGE)
                                                .setBodyBackground(Color.ORANGE)
                                        ))))
                .asElement());



    }
}