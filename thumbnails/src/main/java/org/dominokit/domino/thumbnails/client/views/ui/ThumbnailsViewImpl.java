package org.dominokit.domino.thumbnails.client.views.ui;

import com.google.gwt.core.client.GWT;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.thumbnails.client.views.CodeResource;
import org.dominokit.domino.thumbnails.client.views.ThumbnailsView;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.thumbnails.client.presenters.ThumbnailsPresenter;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.thumbnails.Thumbnail;
import elemental2.dom.HTMLDivElement;

import static org.jboss.gwt.elemento.core.Elements.*;

@UiView(presentable = ThumbnailsPresenter.class)
public class ThumbnailsViewImpl extends ComponentView<HTMLDivElement> implements ThumbnailsView {

    private static final String SAMPLE_TEXT = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s";
    private final HTMLDivElement element = div().asElement();

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("THUMBNAILS").asElement());

        basicSample();

        withExtraContentSample();
    }

    private void basicSample() {
        element.appendChild(Card.create("DEFAULT EXAMPLE", "By default, thumbnails are designed to showcase linked images with minimal required markup")
                .appendChild(Row.create()
                        .addColumn(Column.span3().appendChild(Thumbnail.create()
                                .setContent(img(GWT.getModuleBaseURL() + "/images/image-gallery/5.jpg")
                                                .css(Styles.img_responsive))))
                        .addColumn(Column.span3().appendChild(Thumbnail.create()
                                .setContent(img(GWT.getModuleBaseURL() + "/images/image-gallery/6.jpg")
                                                .css(Styles.img_responsive))))
                        .addColumn(Column.span3().appendChild(Thumbnail.create()
                                .setContent(img(GWT.getModuleBaseURL() + "/images/image-gallery/7.jpg")
                                                .css(Styles.img_responsive))))
                        .addColumn(Column.span3().appendChild(Thumbnail.create()
                                .setContent(img(GWT.getModuleBaseURL() + "/images/image-gallery/8.jpg")
                                                .css(Styles.img_responsive)))))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.basicSample()).asElement());
    }

    private void withExtraContentSample() {
        element.appendChild(Card.create("CUSTOM CONTENT", "With a bit of extra markup, it's possible to add any kind of HTML content like headings, paragraphs, or buttons into thumbnails.")
                .appendChild(Row.create()
                        .addColumn(Column.span3()
                                .appendChild(Thumbnail.create()
                                        .setContent(a().add(img(GWT.getModuleBaseURL() + "/images/image-gallery/1.jpg")
                                                .css(Styles.img_responsive)))
                                        .appendCaptionChild(h(3).textContent("Thumbnail label"))
                                        .appendCaptionChild(Paragraph.create(SAMPLE_TEXT))
                                        .appendCaptionChild(Button.createPrimary("BUTTON"))))
                        .addColumn(Column.span3()
                                .appendChild(Thumbnail.create()
                                        .setContent(a().add(img(GWT.getModuleBaseURL() + "/images/image-gallery/2.jpg")
                                                .css(Styles.img_responsive)))
                                        .appendCaptionChild(h(3).textContent("Thumbnail label"))
                                        .appendCaptionChild(Paragraph.create(SAMPLE_TEXT))
                                        .appendCaptionChild(Button.createPrimary("BUTTON"))))
                        .addColumn(Column.span3()
                                .appendChild(Thumbnail.create()
                                        .setContent(a().add(img(GWT.getModuleBaseURL() + "/images/image-gallery/3.jpg")
                                                .css(Styles.img_responsive)))
                                        .appendCaptionChild(h(3).textContent("Thumbnail label"))
                                        .appendCaptionChild(Paragraph.create(SAMPLE_TEXT))
                                        .appendCaptionChild(Button.createPrimary("BUTTON"))))
                        .addColumn(Column.span3()
                                .appendChild(Thumbnail.create()
                                        .setContent(a().add(img(GWT.getModuleBaseURL() + "/images/image-gallery/4.jpg")
                                                .css(Styles.img_responsive)))
                                        .appendCaptionChild(h(3).textContent("Thumbnail label"))
                                        .appendCaptionChild(Paragraph.create(SAMPLE_TEXT))
                                        .appendCaptionChild(Button.createPrimary("BUTTON")))))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.withExtraContentSample()).asElement());

    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}