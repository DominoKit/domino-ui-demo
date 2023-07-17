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
import org.dominokit.domino.ui.dnd.Draggable;
import org.dominokit.domino.ui.dnd.DropZone;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.typography.BlockHeader;

@UiView(presentable = DndProxy.class)
@SampleClass
public class DndViewImpl extends BaseDemoView<HTMLDivElement> implements DndView {

    private final DivElement element = div();

    @Override
    protected HTMLDivElement init() {

        element.appendChild(LinkToSourceCode.createLink("dnd", DndViewImpl.class));
        element.appendChild(BlockHeader.create("Drag and Drop"));

        dragAndDrop();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.dragAndDrop()));

        return element.element();
    }

    @SampleMethod
    private void dragAndDrop() {
        DivElement dropArea = div().addCss(dui_flex, dui_items_center, dui_justify_center, dui_h_72, dui_w_72, dui_red);
        DivElement dragArea = div().addCss(dui_flex, dui_items_center, dui_justify_center, dui_h_72, dui_w_72, dui_yellow);
        ;

        DivElement draggableElement = div().addCss(dui_flex, dui_items_center, dui_justify_center, dui_blue, dui_h_24, dui_w_24, dui_m_1)
                .setTextContent("BOX-A");

        DivElement draggableElement1 = div().addCss(dui_flex, dui_items_center, dui_justify_center, dui_blue, dui_h_24, dui_w_24, dui_m_1)
                .setTextContent("BOX-B");

        dragArea
                .appendChild(draggableElement)
                .appendChild(draggableElement1);

        DropZone dropZone = new DropZone();
        dropZone.addDropTarget(dropArea, draggableId -> {
            if (draggableElement.getDominoId().equals(draggableId)) {
                draggableElement.remove();
                dropArea.appendChild(draggableElement);
            } else if (draggableElement1.getDominoId().equals(draggableId)) {
                draggableElement1.remove();
                dropArea.appendChild(draggableElement1);
            }
        });

        DropZone dropZone1 = new DropZone();
        dropZone1.addDropTarget(dragArea, draggableId -> {
            if (draggableElement.getDominoId().equals(draggableId)) {
                draggableElement.remove();
                dragArea.appendChild(draggableElement);
            } else if (draggableElement1.getDominoId().equals(draggableId)) {
                draggableElement1.remove();
                dragArea.appendChild(draggableElement1);
            }
        });

        DragSource dragSource = new DragSource();
        dragSource.addDraggable(Draggable.of(draggableElement));
        dragSource.addDraggable(Draggable.of(draggableElement1));


        element.appendChild(Card
                .create("BASIC USAGE", "")
                .appendChild(div().addCss(dui_flex, dui_justify_evenly)
                        .appendChild(div()
                                .appendChild(div().addCss(dui_flex, dui_flex_col)
                                        .appendChild(div().addCss(dui_font_size_4)
                                                .appendChild(text("Drag zone")))
                                        .appendChild(div().appendChild(dragArea))))
                        .appendChild(div()
                                .appendChild(div().addCss(dui_flex, dui_flex_col)
                                        .appendChild(div().addCss(dui_font_size_4)
                                                .appendChild(text("Drop zone")))
                                        .appendChild(div().appendChild(dropArea)))))
        );
    }
}
