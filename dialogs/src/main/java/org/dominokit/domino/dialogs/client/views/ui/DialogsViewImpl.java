package org.dominokit.domino.dialogs.client.views.ui;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.dialogs.client.presenters.DialogsPresenter;
import org.dominokit.domino.dialogs.client.views.CodeResource;
import org.dominokit.domino.dialogs.client.views.DialogsView;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.dialogs.MessageDialog;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.lists.SimpleListGroup;
import org.dominokit.domino.ui.lists.SimpleListItem;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLUListElement;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = DialogsPresenter.class)
public class DialogsViewImpl extends ComponentView<HTMLDivElement> implements DialogsView {

    private HTMLDivElement element = div().asElement();

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("DIALOGS").asElement());

        Column column = Column.create()
                .onLarge(Column.OnLarge.six)
                .onMedium(Column.OnMedium.six)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        MessageDialog basicMessage = MessageDialog.createMessage("Here's a message!",
                () -> Notification.create("Dialog closed").show());

        MessageDialog headerAndMessage = MessageDialog.createMessage("Message header",
                "Here's a message body!",
                () -> Notification.create("Dialog closed").show());

        MessageDialog successMessage = MessageDialog.createMessage("Success Operation",
                "Well done! You successfully read this important alert message.",
                () -> Notification.create("Dialog closed").show())
                .success();

        MessageDialog errorMessage = MessageDialog.createMessage("Failed operation",
                "Oh snap! Change a few things up and try submitting again.",
                () -> Notification.create("Dialog closed").show())
                .error();

        MessageDialog customColors = MessageDialog.createMessage("Failed operation",
                "Oh snap! Change a few things up and try submitting again.",
                () -> Notification.create("Dialog closed").show())
                .error()
                .setModalColor(Color.RED)
                .setIconColor(Color.WHITE);

        MessageDialog warningMessage = MessageDialog.createMessage("Warning",
                "Warning! Better check yourself, you're not looking too good.",
                () -> Notification.create("Dialog closed").show())
                .warning();

        HTMLElement heart = Icons.ALL.favorite().asElement();
        heart.classList.add(Styles.font_72, Styles.m_b_15, Color.RED.getStyle());

        MessageDialog customHeaderContent = MessageDialog.createMessage("Custom header",
                "You can customize the header content",
                () -> Notification.create("Dialog closed").show())
                .onOpen(() -> Animation.create(heart)
                        .duration(400)
                        .infinite()
                        .transition(Transition.PULSE)
                        .animate())
                .appendHeaderContent(heart);

        HTMLUListElement listGroup = SimpleListGroup.create()
                .appendItem(SimpleListItem.create("Cras justo odio")
                        .appendContent(Badge.create("14 new").setBackground(Color.PINK).asElement()))

                .appendItem(SimpleListItem.create("Dapibus ac facilisis in")
                        .appendContent(Badge.create("99 unread").setBackground(Color.CYAN).asElement()))

                .appendItem(SimpleListItem.create("Morbi leo risus")
                        .appendContent(Badge.create("99+").setBackground(Color.TEAL).asElement()))

                .appendItem(SimpleListItem.create("Porta ac consectetur ac")
                        .appendContent(Badge.create("21").setBackground(Color.ORANGE).asElement()))

                .appendItem(SimpleListItem.create("Vestibulum at eros")
                        .appendContent(Badge.create("Pending").setBackground(Color.PURPLE).asElement()))
                .asElement();

        listGroup.style.setProperty("text-align", "left");
        MessageDialog customContent = MessageDialog.createMessage("Custom content",
                "You can customize the dialog content",
                () -> Notification.create("Dialog closed").show())
                .appendContent(listGroup);


        this.element.appendChild(Card.create("EXAMPLES")
                .appendContent(Row.create()
                        .addColumn(column.copy()
                                .addElement(basicMessage.asElement())
                                .addElement(Paragraph.create("A basic message").asElement())
                                .addElement(createDemoButton(basicMessage)))
                        .addColumn(column.copy()
                                .addElement(headerAndMessage.asElement())
                                .addElement(Paragraph.create("Message with header").asElement())
                                .addElement(createDemoButton(headerAndMessage)))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy()
                                .addElement(successMessage.asElement())
                                .addElement(Paragraph.create("Success message").asElement())
                                .addElement(createDemoButton(successMessage)))
                        .addColumn(column.copy()
                                .addElement(errorMessage.asElement())
                                .addElement(Paragraph.create("Error message").asElement())
                                .addElement(createDemoButton(errorMessage)))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy()
                                .addElement(warningMessage.asElement())
                                .addElement(Paragraph.create("Warning message").asElement())
                                .addElement(createDemoButton(warningMessage)))
                        .addColumn(column.copy()
                                .addElement(customColors.asElement())
                                .addElement(Paragraph.create("Custom colors").asElement())
                                .addElement(createDemoButton(customColors)))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy()
                                .addElement(customHeaderContent.asElement())
                                .addElement(Paragraph.create("Custom header content").asElement())
                                .addElement(createDemoButton(customHeaderContent)))
                        .addColumn(column.copy()
                                .addElement(customContent.asElement())
                                .addElement(Paragraph.create("Custom content").asElement())
                                .addElement(createDemoButton(customContent)))
                        .asElement())
                .asElement());

        element.appendChild(createCodeCard(CodeResource.dialogs()).asElement());
    }

    private HTMLElement createDemoButton(MessageDialog dialog) {
        return Button.createPrimary("CLICK ME")
                .setStyleProperty("min-width", "120px")
                .addClickListener(evt -> dialog.open()).asElement();
    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}