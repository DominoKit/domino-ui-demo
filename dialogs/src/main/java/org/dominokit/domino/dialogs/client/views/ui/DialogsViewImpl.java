package org.dominokit.domino.dialogs.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.dialogs.client.presenters.DialogsProxy;
import org.dominokit.domino.dialogs.client.views.DialogsView;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.dialogs.MessageDialog;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.lists.SimpleListGroup;
import org.dominokit.domino.ui.lists.SimpleListItem;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;

import static org.jboss.elemento.Elements.div;

@UiView(presentable = DialogsProxy.class)
@SampleClass
public class DialogsViewImpl extends BaseDemoView<HTMLDivElement> implements DialogsView {

    private HTMLDivElement element = div().element();

    @Override
    protected HTMLDivElement init() {
        element.appendChild(LinkToSourceCode.create("dialogs", this.getClass()).element());
        element.appendChild(BlockHeader.create("DIALOGS").element());

        sample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.sample()).element());

        return element;
    }

    @SampleMethod
    private void sample() {
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
                .setIconColor(Color.GREY, Color.WHITE);

        MessageDialog warningMessage = MessageDialog.createMessage("Warning",
                "Warning! Better check yourself, you're not looking too good.",
                () -> Notification.create("Dialog closed").show())
                .warning();

        Icon heart = Icons.ALL.favorite()
                .style().add(Styles.font_72, Styles.m_b_15, Color.RED.getStyle()).get();

        MessageDialog customHeaderContent = MessageDialog.createMessage("Custom header",
                "You can customize the header content",
                () -> Notification.create("Dialog closed").show())
                .onOpen(() -> Animation.create(heart)
                        .duration(400)
                        .infinite()
                        .transition(Transition.PULSE)
                        .animate())
                .appendHeaderChild(heart);

        MessageDialog customContent = MessageDialog.createMessage("Custom content",
                "You can customize the dialog content",
                () -> Notification.create("Dialog closed").show())
                .appendChild(SimpleListGroup.create()
                        .appendChild(SimpleListItem.create("Cras justo odio")
                                .appendChild(Badge.create("14 new").setBackground(Color.PINK)))

                        .appendChild(SimpleListItem.create("Dapibus ac facilisis in")
                                .appendChild(Badge.create("99 unread").setBackground(Color.CYAN)))

                        .appendChild(SimpleListItem.create("Morbi leo risus")
                                .appendChild(Badge.create("99+").setBackground(Color.TEAL)))

                        .appendChild(SimpleListItem.create("Porta ac consectetur ac")
                                .appendChild(Badge.create("21").setBackground(Color.ORANGE)))

                        .appendChild(SimpleListItem.create("Vestibulum at eros")
                                .appendChild(Badge.create("Pending").setBackground(Color.PURPLE)))
                        .style()
                        .setTextAlign("left"));


        element.appendChild(Card.create("EXAMPLES")
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .appendChild(basicMessage)
                                .appendChild(Paragraph.create("A basic message"))
                                .appendChild(createDemoButton(basicMessage)))
                        .addColumn(Column.span6()
                                .appendChild(headerAndMessage)
                                .appendChild(Paragraph.create("Message with header"))
                                .appendChild(createDemoButton(headerAndMessage)))
                )
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .appendChild(successMessage)
                                .appendChild(Paragraph.create("Success message"))
                                .appendChild(createDemoButton(successMessage)))
                        .addColumn(Column.span6()
                                .appendChild(errorMessage)
                                .appendChild(Paragraph.create("Error message"))
                                .appendChild(createDemoButton(errorMessage)))
                )
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .appendChild(warningMessage)
                                .appendChild(Paragraph.create("Warning message"))
                                .appendChild(createDemoButton(warningMessage)))
                        .addColumn(Column.span6()
                                .appendChild(customColors)
                                .appendChild(Paragraph.create("Custom colors"))
                                .appendChild(createDemoButton(customColors)))
                )
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .appendChild(customHeaderContent)
                                .appendChild(Paragraph.create("Custom header content"))
                                .appendChild(createDemoButton(customHeaderContent)))
                        .addColumn(Column.span6()
                                .appendChild(customContent)
                                .appendChild(Paragraph.create("Custom content"))
                                .appendChild(createDemoButton(customContent)))
                )
                .element());
    }

    private Button createDemoButton(MessageDialog dialog) {
        return Button.createPrimary("CLICK ME")
                .style().setMinWidth("120px")
                .get()
                .addClickListener(evt -> dialog.open());
    }
}