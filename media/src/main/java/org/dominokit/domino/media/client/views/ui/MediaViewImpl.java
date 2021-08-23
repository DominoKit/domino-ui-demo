package org.dominokit.domino.media.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.media.client.presenters.MediaProxy;
import org.dominokit.domino.media.client.views.MediaView;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.media.MediaObject;
import org.dominokit.domino.ui.utils.TextNode;

import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.img;

@UiView(presentable = MediaProxy.class)
@SampleClass
public class MediaViewImpl extends BaseDemoView<HTMLDivElement> implements MediaView {

    private static final String SAMPLE_TEXT = "Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.";
    private HTMLDivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div().element();

        element.appendChild(LinkToSourceCode.create("media", this.getClass()).element());
        element.appendChild(BlockHeader.create("MEDIA OBJECT").element());

        defaultMedia();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.defaultMedia()).element());

        mediaAlignment();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.mediaAlignment()).element());

        return element;
    }

    @SampleMethod
    private void defaultMedia() {
        element.appendChild(Card.create("DEFAULT MEDIA", "The default media displays a media object (images, video, audio) to the left or right of a content block.")
                .appendChild(MediaObject.create()
                        .setHeader("Media heading")
                        .setLeftMedia(a().add(img("http://placehold.it/64x64")
                                .attr("width", "64")
                                .attr("height", "64")))
                        .appendChild(TextNode.of(SAMPLE_TEXT)))
                .appendChild(MediaObject.create()
                        .setHeader("Media heading")
                        .setLeftMedia(a().add(img("http://placehold.it/64x64")
                                .attr("width", "64")
                                .attr("height", "64")))
                        .appendChild(TextNode.of(SAMPLE_TEXT))
                        .appendChild(MediaObject.create()
                                .setHeader("Media heading")
                                .setLeftMedia(a().add(img("http://placehold.it/64x64")
                                        .attr("width", "64")
                                        .attr("height", "64")))
                                .appendChild(TextNode.of(SAMPLE_TEXT))))
                .appendChild(MediaObject.create()
                        .setHeader("Media heading")
                        .setRightMedia(a().add(img("http://placehold.it/64x64")
                                .attr("width", "64")
                                .attr("height", "64")))
                        .appendChild(TextNode.of(SAMPLE_TEXT)))
                .appendChild(MediaObject.create()
                        .setHeader("Media heading")
                        .setRightMedia(a().add(img("http://placehold.it/64x64")
                                .attr("width", "64")
                                .attr("height", "64")))
                        .setLeftMedia(a().add(img("http://placehold.it/64x64")
                                .attr("width", "64")
                                .attr("height", "64")))
                        .appendChild(TextNode.of(SAMPLE_TEXT)))
                .element());


    }

    @SampleMethod
    private void mediaAlignment() {

        element.appendChild(Card.create("MEDIA ALIGNMENT","The images or other media can be aligned top, middle, or bottom. The default is top aligned.")
                .appendChild(MediaObject.create()
                        .setHeader("Media heading")
                        .setLeftMedia(a().add(img("http://placehold.it/64x64")
                                .attr("width", "64")
                                .attr("height", "64")))
                        .appendChild(Paragraph.create(SAMPLE_TEXT))
                        .appendChild(Paragraph.create(SAMPLE_TEXT)))
                .appendChild(MediaObject.create()
                        .setHeader("Media heading")
                        .setLeftMedia(a().add(img("http://placehold.it/64x64")
                                .attr("width", "64")
                                .attr("height", "64")))
                        .alignLeftMedia(MediaObject.MediaAlign.MIDDLE)
                        .appendChild(Paragraph.create(SAMPLE_TEXT))
                        .appendChild(Paragraph.create(SAMPLE_TEXT)))
                .appendChild(MediaObject.create()
                        .setHeader("Media heading")
                        .setLeftMedia(a().add(img("http://placehold.it/64x64")
                                .attr("width", "64")
                                .attr("height", "64")))
                        .alignLeftMedia(MediaObject.MediaAlign.BOTTOM)
                        .appendChild(Paragraph.create(SAMPLE_TEXT))
                        .appendChild(Paragraph.create(SAMPLE_TEXT)))
                .element());

    }
}