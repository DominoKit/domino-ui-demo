package org.dominokit.domino.advancedforms.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.advancedforms.client.presenters.AdvancedFormsPresenter;
import org.dominokit.domino.advancedforms.client.views.AdvancedFormsView;
import org.dominokit.domino.advancedforms.client.views.CodeResource;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.upload.FileUpload;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = AdvancedFormsPresenter.class)
public class AdvancedFormsViewImpl extends ComponentView<HTMLDivElement> implements AdvancedFormsView {

    private HTMLDivElement element = Elements.div().asElement();
    private Card uploadCard;

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("ADVANCED FORM ELEMENTS").asElement());

        uploadCard = Card.create("FILE UPLOAD - DRAG & DROP OR WITH CLICK & CHOOSE");

        initFileUploadExample();

        element.appendChild(uploadCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.uploadExample()).asElement());
    }

    private void initFileUploadExample() {
        FileUpload fileUpload = FileUpload.create()
                .setIcon(Icons.ALL.touch_app())
                .setUrl("http://localhost:8080/form")
                .multipleFiles()
                .accept("image/*")
                .appendChild(Elements.h(3).textContent("Drop files here or click to upload.").asElement())
                .appendChild(Elements.em().textContent("(This is just a demo upload. Selected files are not actually uploaded)").asElement())
                .onAddFile(fileItem -> {
                    fileItem.addErrorHandler(request -> {
                        Notification.createDanger("Error while uploading " + request.responseText).show();
                    });
                    fileItem.addSuccessUploadHandler(request -> {
                        Notification.createSuccess("File uploaded successfully").show();
                    });
                    fileItem.addRemoveHandler(file -> {
                        Notification.createInfo("File has been removed " + file.name).show();
                    });
                });

        uploadCard.appendContent(fileUpload.asElement());
    }
}