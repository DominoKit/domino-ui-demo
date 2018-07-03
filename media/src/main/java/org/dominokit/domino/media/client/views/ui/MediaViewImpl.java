package org.dominokit.domino.media.client.views.ui;

import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.media.client.views.CodeResource;
import org.dominokit.domino.media.client.views.MediaView;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.media.client.presenters.MediaPresenter;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.media.MediaObject;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.Text;

import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.img;

@UiView(presentable = MediaPresenter.class)
public class MediaViewImpl extends ComponentView<HTMLDivElement> implements MediaView {

    private static final String SAMPLE_TEXT = "Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.";
    private HTMLDivElement element = div().asElement();

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {

        element.appendChild(BlockHeader.create("MEDIA OBJECT").asElement());

        defaultMedia();
        mediaAlignment();
    }

    private void defaultMedia() {
        element.appendChild(Card.create("DEFAULT MEDIA", "The default media displays a media object (images, video, audio) to the left or right of a content block.")
                .appendContent(MediaObject.create()
                        .setHeader("Media heading")
                        .setLeftMedia(a().add(img("http://placehold.it/64x64")
                                .attr("width", "64")
                                .attr("height", "64"))
                                .asElement())
                        .appendContent(new Text(SAMPLE_TEXT))
                        .asElement())
                .appendContent(MediaObject.create()
                        .setHeader("Media heading")
                        .setLeftMedia(a().add(img("http://placehold.it/64x64")
                                .attr("width", "64")
                                .attr("height", "64"))
                                .asElement())
                        .appendContent(new Text(SAMPLE_TEXT))
                        .appendContent(MediaObject.create()
                                .setHeader("Media heading")
                                .setLeftMedia(a().add(img("http://placehold.it/64x64")
                                        .attr("width", "64")
                                        .attr("height", "64"))
                                        .asElement())
                                .appendContent(new Text(SAMPLE_TEXT))
                                .asElement())
                        .asElement())
                .appendContent(MediaObject.create()
                        .setHeader("Media heading")
                        .setRightMedia(a().add(img("http://placehold.it/64x64")
                                .attr("width", "64")
                                .attr("height", "64"))
                                .asElement())
                        .appendContent(new Text(SAMPLE_TEXT))
                        .asElement())
                .appendContent(MediaObject.create()
                        .setHeader("Media heading")
                        .setRightMedia(a().add(img("http://placehold.it/64x64")
                                .attr("width", "64")
                                .attr("height", "64"))
                                .asElement())
                        .setLeftMedia(a().add(img("http://placehold.it/64x64")
                                .attr("width", "64")
                                .attr("height", "64"))
                                .asElement())
                        .appendContent(new Text(SAMPLE_TEXT))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.defaultMedia()).asElement());
    }

    private void mediaAlignment() {

        element.appendChild(Card.create("MEDIA ALIGNMENT","The images or other media can be aligned top, middle, or bottom. The default is top aligned.")
                .appendContent(MediaObject.create()
                        .setHeader("Media heading")
                        .setLeftMedia(a().add(img("http://placehold.it/64x64")
                                .attr("width", "64")
                                .attr("height", "64"))
                                .asElement())
                        .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())
                        .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())
                        .asElement())
                .appendContent(MediaObject.create()
                        .setHeader("Media heading")
                        .setLeftMedia(a().add(img("http://placehold.it/64x64")
                                .attr("width", "64")
                                .attr("height", "64"))
                                .asElement())
                        .alignLeftMedia(MediaObject.MediaAlign.MIDDLE)
                        .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())
                        .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())
                        .asElement())
                .appendContent(MediaObject.create()
                        .setHeader("Media heading")
                        .setLeftMedia(a().add(img("http://placehold.it/64x64")
                                .attr("width", "64")
                                .attr("height", "64"))
                                .asElement())
                        .alignLeftMedia(MediaObject.MediaAlign.BOTTOM)
                        .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())
                        .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.mediaAlignment()).asElement());
    }
}