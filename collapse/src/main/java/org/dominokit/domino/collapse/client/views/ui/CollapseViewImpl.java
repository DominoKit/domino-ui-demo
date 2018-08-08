package org.dominokit.domino.collapse.client.views.ui;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.Text;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.collapse.client.presenters.CollapsePresenter;
import org.dominokit.domino.collapse.client.views.CodeResource;
import org.dominokit.domino.collapse.client.views.CollapseView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.collapsible.Accordion;
import org.dominokit.domino.ui.collapsible.AccordionPanel;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.CssStyles;

import static org.jboss.gwt.elemento.core.Elements.b;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = CollapsePresenter.class)
public class CollapseViewImpl extends ComponentView<HTMLDivElement> implements CollapseView {

    private static final String SAMPLE_CONTENT = "Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.";

    private HTMLDivElement element = div().asElement();

    private final Column column = Column.create()
            .onLarge(Column.OnLarge.twelve)
            .onMedium(Column.OnMedium.twelve)
            .onSmall(Column.OnSmall.twelve)
            .onXSmall(Column.OnXSmall.twelve);

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("COLLAPSE").asElement());
        example();
        element.appendChild(BlockHeader.create("ACCORDION").asElement());
        accordionSample();
        colorFullWithIcons();
        multiOpenItems();
    }

    private void example() {

        HTMLDivElement well = div().css("sample-div")
                .add(div()
                        .css("well")
                        .textContent(SAMPLE_CONTENT)
                        .asElement())
                .asElement();

        Collapsible collapsible = Collapsible.create(well);
        EventListener collapsibleListener = evt -> collapsible.toggle();

        Button anchorButton = Button.create("LINK WITH HREF");
        anchorButton.justify();
        anchorButton.getClickableElement().addEventListener("click", collapsibleListener);

        Button button = Button.create("BUTTON");
        button.getClickableElement().addEventListener("click", collapsibleListener);

        element.appendChild(Row.create()
                .addColumn(column.copy()
                        .addElement(Card.create("EXAMPLE", "click the buttons below to show and hide another element via class changes.")
                                .appendContent(anchorButton.htmlBuilder()
                                        .css(CssStyles.M_B_15).component().setBackground(Color.PINK)
                                        .asElement())
                                .appendContent(new Text("\n"))
                                .appendContent(button.htmlBuilder()
                                        .css(CssStyles.M_B_15).component()
                                        .setBackground(Color.CYAN)
                                        .asElement())
                                .appendContent(collapsible.asElement())
                                .asElement())).asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.example())
                .asElement());
    }

    private void accordionSample() {
        Row row = Row.create();
        Column column = Column.create()
                .onLarge(Column.OnLarge.six)
                .onMedium(Column.OnMedium.six)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        element.appendChild(row.addColumn(column.copy()
                .addElement(Card.create("BASIC EXAMPLES", "Extend the default collapse behavior to create an accordion with the panel component.")
                        .setCollapsible()
                        .appendContent(b().textContent("Panel Primary").asElement())
                        .appendContent(Accordion.create()
                                .addPanel(AccordionPanel.create("Collapsible item 1", new Text(SAMPLE_CONTENT)).expand())
                                .addPanel(AccordionPanel.create("Collapsible item 2", new Text(SAMPLE_CONTENT)))
                                .addPanel(AccordionPanel.create("Collapsible item 3", new Text(SAMPLE_CONTENT)))
                                .asElement())
                        .appendContent(b().textContent("Panel Success").asElement())
                        .appendContent(Accordion.create()
                                .addPanel(AccordionPanel.create("Collapsible item 1", new Text(SAMPLE_CONTENT)).expand())
                                .addPanel(AccordionPanel.create("Collapsible item 2", new Text(SAMPLE_CONTENT)))
                                .addPanel(AccordionPanel.create("Collapsible item 3", new Text(SAMPLE_CONTENT)))
                                .success()
                                .asElement())
                        .appendContent(b().textContent("Panel Warning").asElement())
                        .appendContent(Accordion.create()
                                .addPanel(AccordionPanel.create("Collapsible item 1", new Text(SAMPLE_CONTENT)).expand())
                                .addPanel(AccordionPanel.create("Collapsible item 2", new Text(SAMPLE_CONTENT)))
                                .addPanel(AccordionPanel.create("Collapsible item 3", new Text(SAMPLE_CONTENT)))
                                .warning()
                                .asElement())
                        .appendContent(b().textContent("Panel Danger").asElement())
                        .appendContent(Accordion.create()
                                .addPanel(AccordionPanel.create("Collapsible item 1", new Text(SAMPLE_CONTENT)).expand())
                                .addPanel(AccordionPanel.create("Collapsible item 2", new Text(SAMPLE_CONTENT)))
                                .addPanel(AccordionPanel.create("Collapsible item 3", new Text(SAMPLE_CONTENT)))
                                .danger()
                                .asElement())
                        .asElement()))
                .addColumn(column.copy().addElement(Card.create("FULL BODY EXAMPLES", "If you want to also colorful body, you need to use fullBody method.")
                        .setCollapsible()
                        .appendContent(b().textContent("Panel Primary").asElement())
                        .appendContent(Accordion.create()
                                .fullBody()
                                .addPanel(AccordionPanel.create("Collapsible item 1", new Text(SAMPLE_CONTENT)).expand())
                                .addPanel(AccordionPanel.create("Collapsible item 2", new Text(SAMPLE_CONTENT)))
                                .addPanel(AccordionPanel.create("Collapsible item 3", new Text(SAMPLE_CONTENT)))
                                .asElement())
                        .appendContent(b().textContent("Panel Success").asElement())
                        .appendContent(Accordion.create()
                                .fullBody()
                                .addPanel(AccordionPanel.create("Collapsible item 1", new Text(SAMPLE_CONTENT)).expand())
                                .addPanel(AccordionPanel.create("Collapsible item 2", new Text(SAMPLE_CONTENT)))
                                .addPanel(AccordionPanel.create("Collapsible item 3", new Text(SAMPLE_CONTENT)))
                                .success()
                                .asElement())
                        .appendContent(b().textContent("Panel Warning").asElement())
                        .appendContent(Accordion.create()
                                .fullBody()
                                .addPanel(AccordionPanel.create("Collapsible item 1", new Text(SAMPLE_CONTENT)).expand())
                                .addPanel(AccordionPanel.create("Collapsible item 2", new Text(SAMPLE_CONTENT)))
                                .addPanel(AccordionPanel.create("Collapsible item 3", new Text(SAMPLE_CONTENT)))
                                .warning()
                                .asElement())
                        .appendContent(b().textContent("Panel Danger").asElement())
                        .appendContent(Accordion.create()
                                .fullBody()
                                .addPanel(AccordionPanel.create("Collapsible item 1", new Text(SAMPLE_CONTENT)).expand())
                                .addPanel(AccordionPanel.create("Collapsible item 2", new Text(SAMPLE_CONTENT)))
                                .addPanel(AccordionPanel.create("Collapsible item 3", new Text(SAMPLE_CONTENT)))
                                .danger()
                                .asElement())
                        .asElement()))
                .asElement());


        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.accordionSample())
                .asElement());
    }

    private void colorFullWithIcons() {
        Row row = Row.create();
        Column column = Column.create()
                .onLarge(Column.OnLarge.six)
                .onMedium(Column.OnMedium.six)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        element.appendChild(row.addColumn(column.copy()
                .addElement(Card.create("COLORFUL PANEL ITEMS WITH ICON")
                        .setCollapsible()
                        .appendContent(b().textContent("Panel Primary").asElement())
                        .appendContent(Accordion.create()
                                .addPanel(AccordionPanel.create("Collapsible item 1", new Text(SAMPLE_CONTENT)).expand()
                                        .setIcon(Icons.ALL.perm_contact_calendar())
                                        .setColor(Color.PINK)
                                        .expand())
                                .addPanel(AccordionPanel.create("Collapsible item 2", new Text(SAMPLE_CONTENT))
                                        .setIcon(Icons.ALL.cloud_download())
                                        .setColor(Color.CYAN))
                                .addPanel(AccordionPanel.create("Collapsible item 3", new Text(SAMPLE_CONTENT))
                                        .setIcon(Icons.ALL.contact_phone())
                                        .setColor(Color.TEAL))
                                .addPanel(AccordionPanel.create("Collapsible item 4", new Text(SAMPLE_CONTENT))
                                        .setIcon(Icons.ALL.folder_shared())
                                        .setColor(Color.ORANGE))
                                .asElement())
                        .asElement()))
                .addColumn(column.copy().addElement(Card.create("FULL BODY COLORFUL PANEL ITEMS WITH ICON")
                        .setCollapsible()
                        .appendContent(b().textContent("Panel Primary").asElement())
                        .appendContent(Accordion.create()
                                .fullBody()
                                .addPanel(AccordionPanel.create("Collapsible item 1", new Text(SAMPLE_CONTENT)).expand()
                                        .setIcon(Icons.ALL.perm_contact_calendar())
                                        .setColor(Color.PINK)
                                        .expand())
                                .addPanel(AccordionPanel.create("Collapsible item 2", new Text(SAMPLE_CONTENT))
                                        .setIcon(Icons.ALL.cloud_download())
                                        .setColor(Color.CYAN))
                                .addPanel(AccordionPanel.create("Collapsible item 3", new Text(SAMPLE_CONTENT))
                                        .setIcon(Icons.ALL.contact_phone())
                                        .setColor(Color.TEAL))
                                .addPanel(AccordionPanel.create("Collapsible item 4", new Text(SAMPLE_CONTENT))
                                        .setIcon(Icons.ALL.folder_shared())
                                        .setColor(Color.ORANGE))
                                .asElement())
                        .asElement()))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.colorFullWithIcons())
                .asElement());

    }

    private void multiOpenItems() {
        Row row = Row.create();

        element.appendChild(row.addColumn(column.copy()
                .addElement(Card.create("MULTIPLE ITEMS TO BE OPEN")
                        .setCollapsible()
                        .appendContent(Accordion.create()
                                .multiOpen()
                                .fullBody()
                                .addPanel(AccordionPanel.create("Collapsible item 1", new Text(SAMPLE_CONTENT)).expand()
                                        .setIcon(Icons.ALL.perm_contact_calendar())
                                        .setColor(Color.PINK)
                                        .expand())
                                .addPanel(AccordionPanel.create("Collapsible item 2", new Text(SAMPLE_CONTENT))
                                        .setIcon(Icons.ALL.cloud_download())
                                        .setColor(Color.CYAN))
                                .addPanel(AccordionPanel.create("Collapsible item 3", new Text(SAMPLE_CONTENT)).expand()
                                        .setIcon(Icons.ALL.contact_phone())
                                        .setColor(Color.TEAL)
                                        .expand())
                                .addPanel(AccordionPanel.create("Collapsible item 4", new Text(SAMPLE_CONTENT))
                                        .setIcon(Icons.ALL.folder_shared())
                                        .setColor(Color.ORANGE))
                                .asElement())
                        .asElement()))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.multiOpenItems())
                .asElement());

    }
}