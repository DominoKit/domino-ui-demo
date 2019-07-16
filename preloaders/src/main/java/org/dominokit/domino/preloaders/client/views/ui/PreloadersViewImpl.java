package org.dominokit.domino.preloaders.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.preloaders.client.presenters.PreloadersProxy;
import org.dominokit.domino.preloaders.client.views.CodeResource;
import org.dominokit.domino.preloaders.client.views.PreloadersView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.preloaders.Preloader;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = PreloadersProxy.class)
@SampleClass
public class PreloadersViewImpl extends BaseDemoView<HTMLDivElement> implements PreloadersView {

    private HTMLDivElement element;

    @Override
    protected void init(HTMLDivElement root) {
        element.appendChild(LinkToSourceCode.create("preloaders", this.getClass()).asElement());
        element.appendChild(BlockHeader.create("PRELOADERS").asElement());

        sizesSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.sizesSample()).asElement());
        colorsSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.colorsSample()).asElement());
    }

    @Override
    public HTMLDivElement createRoot() {
        element = div().asElement();
        return element;
    }

    @SampleMethod
    private void sizesSample() {
        element.appendChild(Card.create("PRELOADERS - DIFFERENT SIZES")
                .appendChild(div().css("demo-preloader")
                        .add(Preloader.create()
                                .setSize(Preloader.Size.xLarge))
                        .add(Preloader.create()
                                .setSize(Preloader.Size.large))
                        .add(Preloader.create()
                                .setSize(Preloader.Size.medium))
                        .add(Preloader.create()
                                .setSize(Preloader.Size.small))
                        .add(Preloader.create()
                                .setSize(Preloader.Size.xSmall)))
                .asElement());

    }

    @SampleMethod
    private void colorsSample() {


        element.appendChild(Card.create("WITH MATERIAL DESIGN COLORS","You can use the material design colors.")
                .appendChild(div().css("demo-preloader")
                        .add(Preloader.create()
                                .setColor(Color.RED))
                        .add(Preloader.create()
                                .setColor(Color.BLACK))
                        .add(Preloader.create()
                                .setColor(Color.BLUE_GREY))
                        .add(Preloader.create()
                                .setColor(Color.BLUE))
                        .add(Preloader.create()
                                .setColor(Color.GREY))
                        .add(Preloader.create()
                                .setColor(Color.BROWN))
                        .add(Preloader.create()
                                .setColor(Color.DEEP_ORANGE))
                        .add(Preloader.create()
                                .setColor(Color.ORANGE))
                        .add(Preloader.create()
                                .setColor(Color.LIME))
                        .add(Preloader.create()
                                .setColor(Color.LIGHT_GREEN))
                        .add(Preloader.create()
                                .setColor(Color.TEAL))
                        .add(Preloader.create()
                                .setColor(Color.INDIGO)))
                .asElement());



    }
}