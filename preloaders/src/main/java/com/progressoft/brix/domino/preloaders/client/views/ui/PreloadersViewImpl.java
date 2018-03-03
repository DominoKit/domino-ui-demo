package com.progressoft.brix.domino.preloaders.client.views.ui;

import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.preloaders.client.views.CodeResource;
import com.progressoft.brix.domino.preloaders.client.views.PreloadersView;
import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.preloaders.client.presenters.PreloadersPresenter;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import com.progressoft.brix.domino.ui.preloaders.Preloader;
import com.progressoft.brix.domino.ui.style.Color;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import jsinterop.base.Js;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = PreloadersPresenter.class)
public class PreloadersViewImpl implements PreloadersView {

    private HTMLDivElement element = div().asElement();

    public PreloadersViewImpl() {

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

    @Override
    public void showIn(Content content) {
        HTMLElement contentElement = Js.cast(content.get());
        contentElement.appendChild(element);
    }
}