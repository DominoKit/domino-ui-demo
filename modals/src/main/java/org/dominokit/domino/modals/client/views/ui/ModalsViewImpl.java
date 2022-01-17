package org.dominokit.domino.modals.client.views.ui;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.api.shared.extension.Aggregate;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.modals.client.presenters.ModalsProxy;
import org.dominokit.domino.modals.client.views.ModalsView;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.modals.IsModalDialog;
import org.dominokit.domino.ui.modals.ModalDialog;
import org.dominokit.domino.ui.modals.Window;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.TextNode;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.div;

@UiView(presentable = ModalsProxy.class)
@SampleClass
public class ModalsViewImpl extends BaseDemoView<HTMLDivElement> implements ModalsView {

    private static final String SAMPLE_CONTENT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.";
    private HTMLDivElement element;
    private ModalDialog openedDialog;

    private CodeCard modalSizesCard = new CodeCard();
    private CodeCard modalColorsCard = new CodeCard();

    private ModalSizeAggregator modalSizeAggregator;
    private ModalColorAggregator modalColorAggregator;

    @Override
    protected HTMLDivElement init() {
        element = div().element();

        modalSizeAggregator = new ModalSizeAggregator().init(this);
        modalColorAggregator = new ModalColorAggregator().init(this);

        element.appendChild(LinkToSourceCode.create("modals", this.getClass()).element());
        element.appendChild(BlockHeader.create("MODALS").element());

        CodeCard.completeFetchCode(CodeResource.INSTANCE.initModalsSize(), value -> modalSizeAggregator.completeModalSizes(value));
        CodeCard.completeFetchCode(CodeResource.INSTANCE.initModalColor(), value -> modalColorAggregator.completeModalColor(value));
        CodeCard.completeFetchCode(CodeResource.INSTANCE.createModalDialog(), value -> {
            modalColorAggregator.completeCreateModal(value);
            modalSizeAggregator.completeCreateModal(value);
        });

        initModalsSize();
        element.appendChild(modalSizesCard.element());

        initSheets();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initSheets())
                .element());

        initModalColor();
        element.appendChild(modalColorsCard.element());

        initWindow();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initWindow())
                .element());

        return element;
    }

    @Aggregate(name = "ModalSizeAggregator")
    public void onModalSizesCodeLoaded(String modalSizes, String createModal) {
        modalSizesCard.setCode(
                modalSizes +
                        "\n\n//-------------------------------\n" +
                        "\n\nprivate ModalDialog createModalDialog() {\n\n" +
                        createModal + "\n" +
                        "\n}");
        modalSizesCard.getCard().collapse();
    }

    @Aggregate(name = "ModalColorAggregator")
    public void onModalColorCodeLoaded(String modalColor, String createModal) {
        modalColorsCard.setCode(
                modalColor +
                        "\n\n//-------------------------------\n" +
                        "\n\nprivate ModalDialog createModalDialog() {\n\n" +
                        createModal + "\n" +
                        "\n}");
        modalColorsCard.getCard().collapse();
    }

    @SampleMethod
    private void initWindow() {
        element.appendChild(Card.create("Window", "Use window to create modals that can be maximized and move.")
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(Button.createDefault("SIMPLE WINDOW")
                                        .addClickListener(evt -> {
                                            new Window("Simple window")
                                                    .setFixed()
                                                    .setSize(IsModalDialog.ModalSize.SMALL)
                                                    .setHeaderBackground(Color.PINK)
                                                    .apply(self -> self
                                                            .appendChild(Paragraph.create(SAMPLE_CONTENT))
                                                            .appendChild(Paragraph.create(SAMPLE_CONTENT))
                                                    )
                                                    .open();
                                        }))
                        )
                        .appendChild(Column.span3()
                                .appendChild(Button.createDefault("MODAL WINDOW")
                                        .addClickListener(evt -> {
                                            new Window("Modal window")
                                                    .setFixed()
                                                    .setSize(IsModalDialog.ModalSize.SMALL)
                                                    .setModal(true)
                                                    .apply(self -> self
                                                            .appendChild(Paragraph.create(SAMPLE_CONTENT))
                                                            .appendChild(Paragraph.create(SAMPLE_CONTENT))
                                                    )
                                                    .open();
                                        }))
                        )
                        .appendChild(Column.span3()
                                .appendChild(Button.createDefault("NO DRAG WINDOW")
                                        .addClickListener(evt -> {
                                            new Window("No drag window")
                                                    .setFixed()
                                                    .setSize(IsModalDialog.ModalSize.SMALL)
                                                    .setDraggable(false)
                                                    .apply(self -> self
                                                            .appendChild(Paragraph.create(SAMPLE_CONTENT))
                                                            .appendChild(Paragraph.create(SAMPLE_CONTENT))
                                                    )
                                                    .open();
                                        })))
                        .appendChild(Column.span3()
                                .appendChild(Button.createDefault("LARGE WINDOW")
                                        .addClickListener(evt -> {
                                            new Window("Large window")
                                                    .setSize(IsModalDialog.ModalSize.LARGE)
                                                    .setFixed()
                                                    .apply(self -> self
                                                            .appendChild(Paragraph.create(SAMPLE_CONTENT))
                                                            .appendChild(Paragraph.create(SAMPLE_CONTENT))
                                                    )
                                                    .open();
                                        })))

                )
                .element());
    }

    @SampleMethod
    private void initSheets() {

        element.appendChild(Card.create("SHEETS MODALS", "Sheets are modal that stick to screen edges.")
                .appendChild(Row.create()
                        .style().setMargin("10px")
                        .get()
                        .fullSpan(column -> {
                            column.appendChild(Row.create()
                                    .addColumn(Column.span(3, 3, 6, 12)
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createDefault("LEFT - LARGE")
                                                            .addClickListener(evt -> {
                                                                ModalDialog modal = ModalDialog.create("LEFT SHEET")
                                                                        .setType(IsModalDialog.ModalType.LEFT_SHEET)
                                                                        .setSize(IsModalDialog.ModalSize.LARGE)
                                                                        .appendChild(TextNode.of(SAMPLE_CONTENT));

                                                                openDialog(modal);

                                                            })
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px")))
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createDefault("LEFT - DEFAULT")
                                                            .addClickListener(evt -> {
                                                                ModalDialog modal = ModalDialog.create("LEFT SHEET")
                                                                        .setType(IsModalDialog.ModalType.LEFT_SHEET)
                                                                        .appendChild(TextNode.of(SAMPLE_CONTENT));

                                                                openDialog(modal);

                                                            })
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px")))
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createDefault("LEFT - SMALL")
                                                            .addClickListener(evt -> {
                                                                ModalDialog modal = ModalDialog.create("LEFT SHEET")
                                                                        .setType(IsModalDialog.ModalType.LEFT_SHEET)
                                                                        .setSize(IsModalDialog.ModalSize.SMALL)
                                                                        .appendChild(TextNode.of(SAMPLE_CONTENT));

                                                                openDialog(modal);

                                                            })
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px")))
                                    )
                                    .addColumn(Column.span(3, 3, 6, 12)
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createDefault("TOP")
                                                            .addClickListener(evt -> {
                                                                ModalDialog modal = ModalDialog.create("TOP SHEET")
                                                                        .setType(IsModalDialog.ModalType.TOP_SHEET)
                                                                        .setSize(IsModalDialog.ModalSize.LARGE)
                                                                        .appendChild(TextNode.of(SAMPLE_CONTENT));

                                                                openDialog(modal);
                                                            })
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px")))
                                    )
                                    .addColumn(Column.span(3, 3, 6, 12)
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createDefault("BOTTOM")
                                                            .addClickListener(evt -> {
                                                                ModalDialog modal = ModalDialog.create("TOP SHEET")
                                                                        .setType(IsModalDialog.ModalType.BOTTOM_SHEET)
                                                                        .appendChild(TextNode.of(SAMPLE_CONTENT));

                                                                openDialog(modal);
                                                            })
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px")))
                                    )
                                    .addColumn(Column.span(3, 3, 6, 12)
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createDefault("RIGHT - LARGE")
                                                            .addClickListener(evt -> {
                                                                ModalDialog modal = ModalDialog.create("TOP SHEET")
                                                                        .setType(IsModalDialog.ModalType.RIGHT_SHEET)
                                                                        .setSize(IsModalDialog.ModalSize.LARGE)
                                                                        .appendChild(TextNode.of(SAMPLE_CONTENT));

                                                                openDialog(modal);
                                                            })
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px")))
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createDefault("RIGHT - DEFAULT")
                                                            .addClickListener(evt -> {
                                                                ModalDialog modal = ModalDialog.create("TOP SHEET")
                                                                        .setType(IsModalDialog.ModalType.RIGHT_SHEET)
                                                                        .appendChild(TextNode.of(SAMPLE_CONTENT));

                                                                openDialog(modal);
                                                            })
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px")))
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createDefault("RIGHT - SMALL")
                                                            .addClickListener(evt -> {
                                                                ModalDialog modal = ModalDialog.create("TOP SHEET")
                                                                        .setType(IsModalDialog.ModalType.RIGHT_SHEET)
                                                                        .setSize(IsModalDialog.ModalSize.SMALL)
                                                                        .appendChild(TextNode.of(SAMPLE_CONTENT));

                                                                openDialog(modal);
                                                            })
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px")))
                                    ));
                        })
                ).element());


    }

    private void openDialog(ModalDialog dialog) {
        dialog.open();
        this.openedDialog = dialog;
    }

    @SampleMethod
    private void initModalsSize() {

        // ------------ Default size -------------

        ModalDialog defaultSizeModal = createModalDialog();
//        defaultSizeModal.appendChild(TextBox.create("sample"));
        defaultSizeModal.appendChild(CheckBox.create("sample"));


        Button defaultSizeButton = Button.createDefault("MODAL - DEFAULT SIZE");
        defaultSizeButton.addClickListener(e -> openDialog(defaultSizeModal));

        // ------------ Large size -------------

        ModalDialog largeSizeModal = createModalDialog().large();

        Button largeSizeButton = Button.createDefault("MODAL - LARGE SIZE");
        largeSizeButton.addClickListener(e -> openDialog(largeSizeModal));


        // ------------ Small size -------------

        ModalDialog smallSizeModal = createModalDialog().small();

        Button smallSizeButton = Button.createDefault("MODAL - SMALL SIZE");
        smallSizeButton.addClickListener(e -> openDialog(smallSizeModal));


        element.appendChild(Card.create("MODAL SIZE EXAMPLE", "Modals are streamlined, but flexible, dialog prompts with the minimum required functionality and smart defaults.")
                .appendChild(Row.create()
                        .span4(column -> column.appendChild(defaultSizeButton))
                        .span4(column -> column.appendChild(largeSizeButton))
                        .span4(column -> column.appendChild(smallSizeButton))
                )
                .element());


    }

    @SampleMethod
    private void initModalColor() {
        //------------ Red ------------
        ModalDialog modalDialogRed = createModalDialog().setModalColor(Color.RED);
        Button redButton = Button.create("RED").setBackground(Color.RED);
        redButton.addClickListener(e -> openDialog(modalDialogRed));

        //------------ Pink ------------
        ModalDialog modalDialogPink = createModalDialog().setModalColor(Color.PINK);
        Button pinkButton = Button.create("PINK").setBackground(Color.PINK);
        pinkButton.addClickListener(e -> openDialog(modalDialogPink));

        //------------ Purple ------------
        ModalDialog modalDialogPurple = createModalDialog().setModalColor(Color.PURPLE);
        Button purpleButton = Button.create("PURPLE").setBackground(Color.PURPLE);
        purpleButton.addClickListener(e -> openDialog(modalDialogPurple));

        //------------ Deep Purple ------------
        ModalDialog modalDialogDeepPurple = createModalDialog().setModalColor(Color.DEEP_PURPLE);
        Button deepPurpleButton = Button.create("DEEP PURPLE").setBackground(Color.DEEP_PURPLE);
        deepPurpleButton.addClickListener(e -> openDialog(modalDialogDeepPurple));

        //------------ Indigo ------------
        ModalDialog modalDialogIndigo = createModalDialog().setModalColor(Color.INDIGO);
        Button indigoButton = Button.create("INDIGO").setBackground(Color.INDIGO);
        indigoButton.addClickListener(e -> openDialog(modalDialogIndigo));

        //------------ Blue ------------
        ModalDialog modalDialogBlue = createModalDialog().setModalColor(Color.BLUE);
        Button blueButton = Button.create("BLUE").setBackground(Color.BLUE);
        blueButton.addClickListener(e -> openDialog(modalDialogBlue));

        //------------ Orange ------------
        ModalDialog modalDialogOrange = createModalDialog().setModalColor(Color.ORANGE);
        Button orangeButton = Button.create("ORANGE").setBackground(Color.ORANGE);
        orangeButton.addClickListener(e -> openDialog(modalDialogOrange));

        //------------ Green ------------
        ModalDialog modalDialogGreen = createModalDialog().setModalColor(Color.GREEN);
        Button greenButton = Button.create("GREEN").setBackground(Color.GREEN);
        greenButton.addClickListener(e -> openDialog(modalDialogGreen));

        //------------ Teal ------------
        ModalDialog modalDialogTeal = createModalDialog().setModalColor(Color.TEAL);
        Button tealButton = Button.create("TEAL").setBackground(Color.TEAL);
        tealButton.addClickListener(e -> openDialog(modalDialogTeal));


        element.appendChild(Card.create("WITH MATERIAL DESIGN COLORS", "You can use material design colors.")
                .appendChild(div().css("button-demo")
                        .add(redButton)
                        .add(pinkButton)
                        .add(purpleButton)
                        .add(deepPurpleButton)
                        .add(indigoButton)
                        .add(blueButton)
                        .add(orangeButton)
                        .add(greenButton)
                        .add(tealButton)
                ).element());
    }

    @SampleMethod
    private ModalDialog createModalDialog() {
        ModalDialog modal = ModalDialog.create("Modal title")
                .setAutoClose(true);

        modal.appendChild(TextNode.of(SAMPLE_CONTENT));
        Button closeButton = Button.create("CLOSE").linkify();
        Button saveButton = Button.create("SAVE CHANGES").linkify();

        EventListener closeModalListener = evt -> modal.close();

        closeButton.addClickListener(closeModalListener);
        saveButton.addClickListener(closeModalListener);
        modal.appendFooterChild(saveButton);
        modal.appendFooterChild(closeButton);
        return modal;
    }

    @Override
    public void cleanup() {
        if (nonNull(openedDialog))
            openedDialog.close();
    }
}