package org.dominokit.domino.thumbnails.client.views.ui;

import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.thumbnails.client.presenters.ThumbnailsProxy;
import org.dominokit.domino.thumbnails.client.views.ThumbnailsView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.thumbnails.Thumbnail;
import org.dominokit.domino.ui.thumbnails.ThumbnailDirection;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.FooterContent;
import org.dominokit.domino.ui.utils.HeaderContent;

@UiView(presentable = ThumbnailsProxy.class)
@SampleClass
public class ThumbnailsViewImpl extends BaseDemoView<HTMLDivElement> implements ThumbnailsView {

    private static final String SAMPLE_TEXT = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s";
    private DivElement element = div();

    @Override
    protected HTMLDivElement init() {
        element.appendChild(LinkToSourceCode.createLink("thumbnails", this.getClass()));
        element.appendChild(BlockHeader.create("THUMBNAILS"));

        basicSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.basicSample()));

        withExtraContentSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.withExtraContentSample()));

        withTitle();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.withTitle()));

        differentDirections();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.differentDirections()));

        return element.element();
    }

    @SampleMethod
    private void basicSample() {
        element.appendChild(Card.create("DEFAULT EXAMPLE", "By default, thumbnails are designed to showcase linked images with minimal required markup")
                .appendChild(Row.create()
                        .appendChild(Column.span3().appendChild(Thumbnail.create()
                                .appendChild(img(GWT.getModuleBaseURL() + "/images/image-gallery/5.jpg")
                                                .addCss(dui_image_responsive))))
                        .appendChild(Column.span3().appendChild(Thumbnail.create()
                                .appendChild(img(GWT.getModuleBaseURL() + "/images/image-gallery/6.jpg")
                                                .addCss(dui_image_responsive))))
                        .appendChild(Column.span3().appendChild(Thumbnail.create()
                                .appendChild(img(GWT.getModuleBaseURL() + "/images/image-gallery/7.jpg")
                                                .addCss(dui_image_responsive))))
                        .appendChild(Column.span3().appendChild(Thumbnail.create()
                                .appendChild(img(GWT.getModuleBaseURL() + "/images/image-gallery/8.jpg")
                                                .addCss(dui_image_responsive)))))
                );


    }

    @SampleMethod
    private void withExtraContentSample() {
        element.appendChild(Card.create("CUSTOM CONTENT", "With a bit of extra markup, it's possible to add any kind of HTML content like headings, paragraphs, or buttons into thumbnails.")
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(Thumbnail.create()
                                        .appendChild(a().appendChild(img(GWT.getModuleBaseURL() + "/images/image-gallery/1.jpg")
                                                .addCss(dui_image_responsive)))
                                        .appendChild(FooterContent.of(h(4).textContent("Thumbnail label")))
                                        .appendChild(FooterContent.of(p(SAMPLE_TEXT)))
                                        .appendChild(FooterContent.of(Button.create("BUTTON").addCss(dui_primary)))
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Thumbnail.create()
                                        .appendChild(a().appendChild(img(GWT.getModuleBaseURL() + "/images/image-gallery/2.jpg")
                                                .addCss(dui_image_responsive)))
                                        .appendChild(FooterContent.of(h(4).textContent("Thumbnail label")))
                                        .appendChild(FooterContent.of(p(SAMPLE_TEXT)))
                                        .appendChild(FooterContent.of(Button.create("BUTTON").addCss(dui_primary)))
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Thumbnail.create()
                                        .appendChild(a().appendChild(img(GWT.getModuleBaseURL() + "/images/image-gallery/3.jpg")
                                                .addCss(dui_image_responsive)))
                                        .appendChild(FooterContent.of(h(4).textContent("Thumbnail label")))
                                        .appendChild(FooterContent.of(p(SAMPLE_TEXT)))
                                        .appendChild(FooterContent.of(Button.create("BUTTON").addCss(dui_primary)))
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Thumbnail.create()
                                        .appendChild(a().appendChild(img(GWT.getModuleBaseURL() + "/images/image-gallery/4.jpg")
                                                .addCss(dui_image_responsive)))
                                        .appendChild(FooterContent.of(h(4).textContent("Thumbnail label")))
                                        .appendChild(FooterContent.of(p(SAMPLE_TEXT)))
                                        .appendChild(FooterContent.of(Button.create("BUTTON").addCss(dui_primary)))
                                )
                        )
                )
        );
    }

    @SampleMethod
    private void withTitle() {
        element.appendChild(Card.create("WITH TITLE")
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(Thumbnail.create()
                                        .appendChild(HeaderContent.of(h(5).textContent("Thumbnail title")))
                                        .appendChild(a().appendChild(img(GWT.getModuleBaseURL() + "/images/image-gallery/1.jpg")
                                                .addCss(dui_image_responsive)))
                                        .appendChild(FooterContent.of(h(4).textContent("Thumbnail label")))
                                        .appendChild(FooterContent.of(p(SAMPLE_TEXT)))
                                        .appendChild(FooterContent.of(Button.create("BUTTON").addCss(dui_primary)))
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Thumbnail.create()
                                        .appendChild(HeaderContent.of(h(5).textContent("Thumbnail title")))
                                        .appendChild(a().appendChild(img(GWT.getModuleBaseURL() + "/images/image-gallery/2.jpg")
                                                .addCss(dui_image_responsive)))
                                        .appendChild(FooterContent.of(h(4).textContent("Thumbnail label")))
                                        .appendChild(FooterContent.of(p(SAMPLE_TEXT)))
                                        .appendChild(FooterContent.of(Button.create("BUTTON").addCss(dui_primary)))
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Thumbnail.create()
                                        .appendChild(HeaderContent.of(h(5).textContent("Thumbnail title")))
                                        .appendChild(a().appendChild(img(GWT.getModuleBaseURL() + "/images/image-gallery/3.jpg")
                                                .addCss(dui_image_responsive)))
                                        .appendChild(FooterContent.of(h(4).textContent("Thumbnail label")))
                                        .appendChild(FooterContent.of(p(SAMPLE_TEXT)))
                                        .appendChild(FooterContent.of(Button.create("BUTTON").addCss(dui_primary)))
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Thumbnail.create()
                                        .appendChild(HeaderContent.of(h(5).textContent("Thumbnail title")))
                                        .appendChild(a().appendChild(img(GWT.getModuleBaseURL() + "/images/image-gallery/4.jpg")
                                                .addCss(dui_image_responsive)))
                                        .appendChild(FooterContent.of(h(4).textContent("Thumbnail label")))
                                        .appendChild(FooterContent.of(p(SAMPLE_TEXT)))
                                        .appendChild(FooterContent.of(Button.create("BUTTON").addCss(dui_primary)))
                                )
                        )
                )
        );
    }

    @SampleMethod
    private void differentDirections() {
        element.appendChild(Card.create("WITH TITLE")
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(Thumbnail.create()
                                        .setDirection(ThumbnailDirection.COLUMN)
                                        .appendChild(HeaderContent.of(h(5).textContent("Thumbnail title")))
                                        .appendChild(a().appendChild(img(GWT.getModuleBaseURL() + "/images/image-gallery/1.jpg")
                                                .addCss(dui_image_responsive)))
                                        .appendChild(FooterContent.of(h(4).textContent("Thumbnail label")))
                                        .appendChild(FooterContent.of(p(SAMPLE_TEXT)))
                                        .appendChild(FooterContent.of(Button.create("BUTTON").addCss(dui_primary)))
                                )
                        )
                        .appendChild(Column.span6()
                                .appendChild(Thumbnail.create()
                                        .setDirection(ThumbnailDirection.COLUMN_REVERSE)
                                        .appendChild(HeaderContent.of(h(5).textContent("Thumbnail title")))
                                        .appendChild(a().appendChild(img(GWT.getModuleBaseURL() + "/images/image-gallery/2.jpg")
                                                .addCss(dui_image_responsive)))
                                        .appendChild(FooterContent.of(h(4).textContent("Thumbnail label")))
                                        .appendChild(FooterContent.of(p(SAMPLE_TEXT)))
                                        .appendChild(FooterContent.of(Button.create("BUTTON").addCss(dui_primary)))
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(Thumbnail.create()
                                        .setDirection(ThumbnailDirection.ROW)
                                        .appendChild(HeaderContent.of(h(5).textContent("Thumbnail title")))
                                        .appendChild(a().appendChild(img(GWT.getModuleBaseURL() + "/images/image-gallery/3.jpg")
                                                .addCss(dui_image_responsive)))
                                        .appendChild(FooterContent.of(h(4).textContent("Thumbnail label")))
                                        .appendChild(FooterContent.of(p(SAMPLE_TEXT)))
                                        .appendChild(FooterContent.of(Button.create("BUTTON").addCss(dui_primary)))
                                )
                        )
                        .appendChild(Column.span6()
                                .appendChild(Thumbnail.create()
                                        .setDirection(ThumbnailDirection.ROW_REVERSE)
                                        .appendChild(HeaderContent.of(h(5).textContent("Thumbnail title")))
                                        .appendChild(a().appendChild(img(GWT.getModuleBaseURL() + "/images/image-gallery/4.jpg")
                                                .addCss(dui_image_responsive)))
                                        .appendChild(FooterContent.of(h(4).textContent("Thumbnail label")))
                                        .appendChild(FooterContent.of(p(SAMPLE_TEXT)))
                                        .appendChild(FooterContent.of(Button.create("BUTTON").addCss(dui_primary)))
                                )
                        )
                )
        );
    }
}