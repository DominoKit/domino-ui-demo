package org.dominokit.domino.dnd.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.dnd.client.presenters.DndProxy;
import org.dominokit.domino.dnd.client.views.DndView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.dnd.DragSource;
import org.dominokit.domino.ui.dnd.DropZone;
import org.dominokit.domino.ui.grid.flex.*;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.elemento.Elements;

@UiView(presentable = DndProxy.class)
@SampleClass
public class DndViewImpl extends BaseDemoView<HTMLDivElement> implements DndView {

    private final HTMLDivElement element = Elements.div().element();

    @Override
    protected HTMLDivElement init() {

        element.appendChild(LinkToSourceCode.create("dnd", DndViewImpl.class).element());
        element.appendChild(BlockHeader.create("Drag and Drop").element());

        dragAndDrop();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.dragAndDrop()).element());

        return element;
    }

    @SampleMethod
    private void dragAndDrop() {
        FlexLayout dropArea = FlexLayout
                .create()
                .setAlignItems(FlexAlign.CENTER)
                .setHeight("300px")
                .setWidth("300px")
                .setBackgroundColor("red");
        FlexLayout dragArea = FlexLayout
                .create()
                .setAlignItems(FlexAlign.CENTER)
                .setHeight("300px")
                .setWidth("300px")
                .setBackgroundColor("yellow");

        DominoElement<HTMLDivElement> draggableElement = DominoElement
                .div()
                .setColor("white")
                .setTextContent("draggable")
                .setHeight("100px")
                .setWidth("100px")
                .setBackgroundColor("blue")
                .setMargin("5px");

        DominoElement<HTMLDivElement> draggableElement1 = DominoElement
                .div()
                .setColor("white")
                .setTextContent("draggable")
                .setHeight("100px")
                .setWidth("100px")
                .setBackgroundColor("blue")
                .setMargin("5px");

        dragArea
                .appendChild(draggableElement)
                .appendChild(draggableElement1);

        DropZone dropZone = new DropZone();
        dropZone.addDropTarget(dropArea, draggableId -> {
            if(draggableElement.getDominoId().equals(draggableId)){
                draggableElement.remove();
                dropArea.appendChild(draggableElement);
            } else if(draggableElement1.getDominoId().equals(draggableId)){
                draggableElement1.remove();
                dropArea.appendChild(draggableElement1);
            }
        });

        DropZone dropZone1 = new DropZone();
        dropZone1.addDropTarget(dragArea, draggableId -> {
            if(draggableElement.getDominoId().equals(draggableId)){
                draggableElement.remove();
                dragArea.appendChild(draggableElement);
            } else if(draggableElement1.getDominoId().equals(draggableId)){
                draggableElement1.remove();
                dragArea.appendChild(draggableElement1);
            }
        });

        DragSource dragSource = new DragSource();
        dragSource.addDraggable(draggableElement);
        dragSource.addDraggable(draggableElement1);


        element.appendChild(Card
                .create("BASIC USAGE", "")
                .appendChild(FlexLayout
                        .create()
                        .setJustifyContent(FlexJustifyContent.SPACE_EVENLY)
                        .appendChild(FlexItem
                                .create()
                                .appendChild(FlexLayout
                                        .create()
                                        .setDirection(FlexDirection.TOP_TO_BOTTOM)
                                        .appendChild(FlexItem
                                                .create()
                                                .setFontSize("17px")
                                                .appendChild(TextNode.of("Drag zone")))
                                        .appendChild(FlexItem.create().appendChild(dragArea))))
                        .appendChild(FlexItem
                                .create()
                                .appendChild(FlexLayout
                                        .create()
                                        .setDirection(FlexDirection.TOP_TO_BOTTOM)
                                        .appendChild(FlexItem
                                                .create()
                                                .setFontSize("17px")
                                                .appendChild(TextNode.of("Drop zone")))
                                        .appendChild(FlexItem.create().appendChild(dropArea)))))
                .element());
    }
}
