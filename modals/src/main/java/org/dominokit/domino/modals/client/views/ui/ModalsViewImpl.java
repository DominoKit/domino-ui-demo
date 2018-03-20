package org.dominokit.domino.modals.client.views.ui;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase.ComponentRemoveHandler;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.modals.client.presenters.ModalsPresenter;
import org.dominokit.domino.modals.client.views.CodeResource;
import org.dominokit.domino.modals.client.views.ModalsView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.modals.ModalDialog;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Background;
import org.dominokit.domino.ui.style.Color;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.Text;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = ModalsPresenter.class)
public class ModalsViewImpl extends ComponentView<HTMLDivElement> implements ModalsView {

    private static final String SAMPLE_CONTENT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.";
    private HTMLDivElement element = div().asElement();
    private ModalDialog openedDialog;

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    private ComponentRemoveHandler closeHandler = () -> {
        if(nonNull(openedDialog))
                openedDialog.close();
    };

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("MODALS").asElement());
        initModalsSize();
        initModalColor();
    }

    private void openDialog(ModalDialog dialog){
        dialog.open();
        this.openedDialog=dialog;
    }

    private void initModalsSize() {
        Row row = Row.create();
        Column column = Column.create()
                .onLarge(Column.OnLarge.four)
                .onMedium(Column.OnMedium.four)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        // ------------ Default size -------------

        ModalDialog defaultSizeModal = createModalDialog();

        Button defaultSizeButton = Button.createDefault("MODAL - DEFAULT SIZE");
        defaultSizeButton.getClickableElement().addEventListener("click", e -> openDialog(defaultSizeModal));

        element.appendChild(defaultSizeModal.asElement());

        row.addColumn(column.addElement(defaultSizeButton.asElement()));

        // ------------ Large size -------------

        ModalDialog largeSizeModal = createModalDialog().large();

        Button largeSizeButton = Button.createDefault("MODAL - LARGE SIZE");
        largeSizeButton.getClickableElement().addEventListener("click", e -> openDialog(largeSizeModal));


        element.appendChild(largeSizeModal.asElement());

        row.addColumn(column.copy().addElement(largeSizeButton.asElement()));

        // ------------ Small size -------------

        ModalDialog smallSizeModal = createModalDialog().small();

        Button smallSizeButton = Button.createDefault("MODAL - LARGE SIZE");
        smallSizeButton.getClickableElement().addEventListener("click", e -> openDialog(smallSizeModal));


        element.appendChild(smallSizeModal.asElement());

        row.addColumn(column.copy().addElement(smallSizeButton.asElement()));

        element.appendChild(Card.create("MODAL SIZE EXAMPLE", "Modals are streamlined, but flexible, dialog prompts with the minimum required functionality and smart defaults.")
                .appendContent(row.asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.initModalsSize())
                .asElement());
    }

    private void initModalColor() {
        Card card = Card.create("WITH MATERIAL DESIGN COLORS", "You can use material design colors.");

        HTMLDivElement buttonsContainer = div().css("button-demo").asElement();
        card.appendContent(buttonsContainer);

        //------------ Red ------------
        ModalDialog modalDialogRed=createModalDialog().setModalColor(Color.RED);
        Button redButton=Button.create("RED").setBackground(Background.RED);
        redButton.getClickableElement().addEventListener("click", e-> openDialog(modalDialogRed));

        buttonsContainer.appendChild(redButton.asElement());
        element.appendChild(modalDialogRed.asElement());

        //------------ Pink ------------
        ModalDialog modalDialogPink=createModalDialog().setModalColor(Color.PINK);
        Button pinkButton=Button.create("PINK").setBackground(Background.PINK);
        pinkButton.getClickableElement().addEventListener("click", e-> openDialog(modalDialogPink));

        buttonsContainer.appendChild(pinkButton.asElement());
        element.appendChild(modalDialogPink.asElement());

        //------------ Purple ------------
        ModalDialog modalDialogPurple=createModalDialog().setModalColor(Color.PURPLE);
        Button purpleButton=Button.create("PURPLE").setBackground(Background.PURPLE);
        purpleButton.getClickableElement().addEventListener("click", e-> openDialog(modalDialogPurple));

        buttonsContainer.appendChild(purpleButton.asElement());
        element.appendChild(modalDialogPurple.asElement());

        //------------ Deep Purple ------------
        ModalDialog modalDialogDeepPurple=createModalDialog().setModalColor(Color.DEEP_PURPLE);
        Button deepPurpleButton=Button.create("DEEP PURPLE").setBackground(Background.DEEP_PURPLE);
        deepPurpleButton.getClickableElement().addEventListener("click", e-> openDialog(modalDialogDeepPurple));

        buttonsContainer.appendChild(deepPurpleButton.asElement());
        element.appendChild(modalDialogDeepPurple.asElement());

        //------------ Indigo ------------
        ModalDialog modalDialogIndigo=createModalDialog().setModalColor(Color.INDIGO);
        Button indigoButton=Button.create("INDIGO").setBackground(Background.INDIGO);
        indigoButton.getClickableElement().addEventListener("click", e-> openDialog(modalDialogIndigo));

        buttonsContainer.appendChild(indigoButton.asElement());
        element.appendChild(modalDialogIndigo.asElement());

        //------------ Blue ------------
        ModalDialog modalDialogBlue=createModalDialog().setModalColor(Color.BLUE);
        Button blueButton=Button.create("BLUE").setBackground(Background.BLUE);
        blueButton.getClickableElement().addEventListener("click", e-> openDialog(modalDialogBlue));

        buttonsContainer.appendChild(blueButton.asElement());
        element.appendChild(modalDialogBlue.asElement());

        //------------ Orange ------------
        ModalDialog modalDialogOrange=createModalDialog().setModalColor(Color.ORANGE);
        Button orangeButton=Button.create("ORANGE").setBackground(Background.ORANGE);
        orangeButton.getClickableElement().addEventListener("click", e-> openDialog(modalDialogOrange));

        buttonsContainer.appendChild(orangeButton.asElement());
        element.appendChild(modalDialogOrange.asElement());


        //------------ Green ------------
        ModalDialog modalDialogGreen=createModalDialog().setModalColor(Color.GREEN);
        Button greenButton=Button.create("GREEN").setBackground(Background.GREEN);
        greenButton.getClickableElement().addEventListener("click", e-> openDialog(modalDialogGreen));

        buttonsContainer.appendChild(greenButton.asElement());
        element.appendChild(modalDialogGreen.asElement());


        //------------ Teal ------------
        ModalDialog modalDialogTeal=createModalDialog().setModalColor(Color.TEAL);
        Button tealButton=Button.create("TEAL").setBackground(Background.TEAL);
        tealButton.getClickableElement().addEventListener("click", e-> openDialog(modalDialogTeal));

        buttonsContainer.appendChild(tealButton.asElement());
        element.appendChild(modalDialogTeal.asElement());

        element.appendChild(card.asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.initModalColor()).asElement());

    }

    private ModalDialog createModalDialog() {
        ModalDialog modal = ModalDialog.create("Modal title");
        modal.appendContent(new Text(SAMPLE_CONTENT));
        Button closeButton = Button.create("CLOSE").linkify();
        Button saveButton = Button.create("SAVE CHANGES").linkify();

        EventListener closeModalListener = evt -> modal.close();

        closeButton.getClickableElement().addEventListener("click", closeModalListener);
        saveButton.getClickableElement().addEventListener("click", closeModalListener);
        modal.appendFooterContent(saveButton.asElement());
        modal.appendFooterContent(closeButton.asElement());
        return modal;
    }

    @Override
    public ComponentRemoveHandler cleanup() {
        return closeHandler;
    }
}