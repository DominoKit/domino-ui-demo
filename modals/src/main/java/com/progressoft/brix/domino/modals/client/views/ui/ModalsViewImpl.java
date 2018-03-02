package com.progressoft.brix.domino.modals.client.views.ui;

import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.modals.client.presenters.ModalsPresenter;
import com.progressoft.brix.domino.modals.client.views.CodeResource;
import com.progressoft.brix.domino.modals.client.views.ModalsView;
import com.progressoft.brix.domino.ui.button.Button;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.code.Code;
import com.progressoft.brix.domino.ui.column.Column;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import com.progressoft.brix.domino.ui.modals.ModalDialog;
import com.progressoft.brix.domino.ui.row.Row;
import com.progressoft.brix.domino.ui.style.Background;
import com.progressoft.brix.domino.ui.style.Color;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import jsinterop.base.Js;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = ModalsPresenter.class)
public class ModalsViewImpl implements ModalsView {

    private static final String SAMPLE_CONTENT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.";
    private HTMLElement element = Elements.div().asElement();

    public ModalsViewImpl() {
        element.appendChild(BlockHeader.create("MODALS").asElement());
        initModalsSize();
        initModalColor();
    }

    private void initModalColor() {
        Card card = Card.create("WITH MATERIAL DESIGN COLORS", "You can use material design colors.");

        HTMLDivElement buttonsContainer = Elements.div().css("button-demo").asElement();
        card.appendContent(buttonsContainer);

        //------------ Red ------------
        ModalDialog modalDialogRed=createModalDialog().setModalColor(Color.RED);
        Button redButton=Button.create("RED").setBackground(Background.RED);
        redButton.getClickableElement().addEventListener("click", e-> modalDialogRed.open());

        buttonsContainer.appendChild(redButton.asElement());
        element.appendChild(modalDialogRed.asElement());

        //------------ Pink ------------
        ModalDialog modalDialogPink=createModalDialog().setModalColor(Color.PINK);
        Button pinkButton=Button.create("PINK").setBackground(Background.PINK);
        pinkButton.getClickableElement().addEventListener("click", e-> modalDialogPink.open());

        buttonsContainer.appendChild(pinkButton.asElement());
        element.appendChild(modalDialogPink.asElement());

        //------------ Purple ------------
        ModalDialog modalDialogPurple=createModalDialog().setModalColor(Color.PURPLE);
        Button purpleButton=Button.create("PURPLE").setBackground(Background.PURPLE);
        purpleButton.getClickableElement().addEventListener("click", e-> modalDialogPurple.open());

        buttonsContainer.appendChild(purpleButton.asElement());
        element.appendChild(modalDialogPurple.asElement());

        //------------ Deep Purple ------------
        ModalDialog modalDialogDeepPurple=createModalDialog().setModalColor(Color.DEEP_PURPLE);
        Button deepPurpleButton=Button.create("DEEP PURPLE").setBackground(Background.DEEP_PURPLE);
        deepPurpleButton.getClickableElement().addEventListener("click", e-> modalDialogDeepPurple.open());

        buttonsContainer.appendChild(deepPurpleButton.asElement());
        element.appendChild(modalDialogDeepPurple.asElement());

        //------------ Indigo ------------
        ModalDialog modalDialogIndigo=createModalDialog().setModalColor(Color.INDIGO);
        Button indigoButton=Button.create("INDIGO").setBackground(Background.INDIGO);
        indigoButton.getClickableElement().addEventListener("click", e-> modalDialogIndigo.open());

        buttonsContainer.appendChild(indigoButton.asElement());
        element.appendChild(modalDialogIndigo.asElement());

        //------------ Blue ------------
        ModalDialog modalDialogBlue=createModalDialog().setModalColor(Color.BLUE);
        Button blueButton=Button.create("BLUE").setBackground(Background.BLUE);
        blueButton.getClickableElement().addEventListener("click", e-> modalDialogBlue.open());

        buttonsContainer.appendChild(blueButton.asElement());
        element.appendChild(modalDialogBlue.asElement());

        //------------ Orange ------------
        ModalDialog modalDialogOrange=createModalDialog().setModalColor(Color.ORANGE);
        Button orangeButton=Button.create("ORANGE").setBackground(Background.ORANGE);
        orangeButton.getClickableElement().addEventListener("click", e-> modalDialogOrange.open());

        buttonsContainer.appendChild(orangeButton.asElement());
        element.appendChild(modalDialogOrange.asElement());


        //------------ Green ------------
        ModalDialog modalDialogGreen=createModalDialog().setModalColor(Color.GREEN);
        Button greenButton=Button.create("GREEN").setBackground(Background.GREEN);
        greenButton.getClickableElement().addEventListener("click", e-> modalDialogGreen.open());

        buttonsContainer.appendChild(greenButton.asElement());
        element.appendChild(modalDialogGreen.asElement());


        //------------ Teal ------------
        ModalDialog modalDialogTeal=createModalDialog().setModalColor(Color.TEAL);
        Button tealButton=Button.create("TEAL").setBackground(Background.TEAL);
        tealButton.getClickableElement().addEventListener("click", e-> modalDialogTeal.open());

        buttonsContainer.appendChild(tealButton.asElement());
        element.appendChild(modalDialogTeal.asElement());

        element.appendChild(card.asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.initModalColor()).asElement());

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
        defaultSizeButton.getClickableElement().addEventListener("click", e -> defaultSizeModal.open());

        element.appendChild(defaultSizeModal.asElement());

        row.addColumn(column.addElement(defaultSizeButton.asElement()));

        // ------------ Large size -------------

        ModalDialog largeSizeModal = createModalDialog().large();

        Button largeSizeButton = Button.createDefault("MODAL - LARGE SIZE");
        largeSizeButton.getClickableElement().addEventListener("click", e -> largeSizeModal.open());


        element.appendChild(largeSizeModal.asElement());

        row.addColumn(column.copy().addElement(largeSizeButton.asElement()));

        // ------------ Small size -------------

        ModalDialog smallSizeModal = createModalDialog().small();

        Button smallSizeButton = Button.createDefault("MODAL - LARGE SIZE");
        smallSizeButton.getClickableElement().addEventListener("click", e -> smallSizeModal.open());


        element.appendChild(smallSizeModal.asElement());

        row.addColumn(column.copy().addElement(smallSizeButton.asElement()));

        element.appendChild(Card.create("MODAL SIZE EXAMPLE", "Modals are streamlined, but flexible, dialog prompts with the minimum required functionality and smart defaults.")
                .appendContent(row.asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.initModalsSize())
                .asElement());
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
    public void showIn(Content content) {
        HTMLElement contentElement = Js.cast(content.get());
        contentElement.appendChild(element);
    }
}