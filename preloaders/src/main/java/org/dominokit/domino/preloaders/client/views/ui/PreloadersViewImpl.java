package org.dominokit.domino.preloaders.client.views.ui;

import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.preloaders.client.views.CodeResource;
import org.dominokit.domino.preloaders.client.views.PreloadersView;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.preloaders.client.presenters.PreloadersPresenter;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.preloaders.Preloader;
import org.dominokit.domino.ui.style.Color;
import elemental2.dom.HTMLDivElement;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = PreloadersPresenter.class)
public class PreloadersViewImpl extends ComponentView<HTMLDivElement> implements PreloadersView {

    private HTMLDivElement element = div().asElement();

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {

        element.appendChild(BlockHeader.create("PRELOADERS").asElement());

        sizesSample();
        colorsSample();
    }

    private void sizesSample() {
        element.appendChild(Card.create("PRELOADERS - DIFFERENT SIZES")
                .appendContent(div().css("demo-preloader")
                        .add(Preloader.create()
                                .setSize(Preloader.Size.xLarge)
                                .asElement())
                        .add(Preloader.create()
                                .setSize(Preloader.Size.large)
                                .asElement())
                        .add(Preloader.create()
                                .setSize(Preloader.Size.medium)
                                .asElement())
                        .add(Preloader.create()
                                .setSize(Preloader.Size.small)
                                .asElement())
                        .add(Preloader.create()
                                .setSize(Preloader.Size.xSmall)
                                .asElement())
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.sizesSample()).asElement());
    }

    private void colorsSample() {

        element.appendChild(Card.create("WITH MATERIAL DESIGN COLORS","You can use the material design colors.")
                .appendContent(div().css("demo-preloader")
                        .add(Preloader.create()
                                .setColor(Color.RED)
                                .asElement())
                        .add(Preloader.create()
                                .setColor(Color.BLACK)
                                .asElement())
                        .add(Preloader.create()
                                .setColor(Color.BLUE_GREY)
                                .asElement())
                        .add(Preloader.create()
                                .setColor(Color.BLUE)
                                .asElement())
                        .add(Preloader.create()
                                .setColor(Color.GREY)
                                .asElement())
                        .add(Preloader.create()
                                .setColor(Color.BROWN)
                                .asElement())
                        .add(Preloader.create()
                                .setColor(Color.DEEP_ORANGE)
                                .asElement())
                        .add(Preloader.create()
                                .setColor(Color.ORANGE)
                                .asElement())
                        .add(Preloader.create()
                                .setColor(Color.LIME)
                                .asElement())
                        .add(Preloader.create()
                                .setColor(Color.LIGHT_GREEN)
                                .asElement())
                        .add(Preloader.create()
                                .setColor(Color.TEAL)
                                .asElement())
                        .add(Preloader.create()
                                .setColor(Color.INDIGO)
                                .asElement())
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.colorsSample()).asElement());

    }
}