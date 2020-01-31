package org.dominokit.domino.thumbnails.client.views.ui;

import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.thumbnails.client.presenters.ThumbnailsProxy;
import org.dominokit.domino.thumbnails.client.views.ThumbnailsView;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.thumbnails.Thumbnail;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;

import static org.jboss.elemento.Elements.*;

@UiView(presentable = ThumbnailsProxy.class)
@SampleClass
public class ThumbnailsViewImpl extends BaseDemoView<HTMLDivElement> implements ThumbnailsView {

    private static final String SAMPLE_TEXT = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s";
    private HTMLDivElement element = div().element();

    @Override
    protected HTMLDivElement init() {
        element.appendChild(LinkToSourceCode.create("thumbnails", this.getClass()).element());
        element.appendChild(BlockHeader.create("THUMBNAILS").element());

        basicSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.basicSample()).element());

        withExtraContentSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.withExtraContentSample()).element());

        return element;
    }

    @SampleMethod
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
                .element());


    }

    @SampleMethod
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
                .element());
    }
}