package org.dominokit.domino.animation.client.views.ui;

import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.animation.client.presenters.AnimationProxy;
import org.dominokit.domino.animation.client.views.AnimationView;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.api.shared.extension.Aggregate;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.jboss.elemento.Elements;

import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.img;

@UiView(presentable = AnimationProxy.class)
@SampleClass
public class AnimationViewImpl extends BaseDemoView<HTMLDivElement> implements AnimationView {

    private HTMLDivElement element = div().element();
    private CodeCard createAnimationCard= new CodeCard();
    CreateAnimationAggregator createAnimationAggregator;

    @Override
    protected HTMLDivElement init() {

        createAnimationAggregator = new CreateAnimationAggregator().init(this);

        element.appendChild(LinkToSourceCode.create("animation", this.getClass()).element());
        element.appendChild(BlockHeader.create("CSS ANIMATIONS")
                .appendText("Pure css animations - ")
                .appendChild(a().attr("href", "https://daneden.github.io/animate.css/")
                        .attr("target", "_blank").textContent("daneden.github.io/animate.css"))
                .element()
        );


        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FLASH)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.PULSE)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.RUBBER_BAND)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.SHAKE)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.SWING)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.TADA)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.WOBBLE)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.JELLO)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_IN)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_IN_DOWN)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_IN_LEFT)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_IN_RIGHT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_IN_UP)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_OUT)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_OUT_DOWN)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_OUT_LEFT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_OUT_RIGHT)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_OUT_UP)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_DOWN)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_DOWN_BIG)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_LEFT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_LEFT_BIG)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_RIGHT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_RIGHT_BIG)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_UP)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_UP_BIG)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_DOWN)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_DOWN_BIG)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_LEFT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_LEFT_BIG)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_RIGHT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_RIGHT_BIG)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_UP)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_UP_BIG)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FLIP)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FLIP_IN_X)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FLIP_IN_Y)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FLIP_OUT_X)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FLIP_OUT_Y)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.LIGHT_SPEED_IN)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.LIGHT_SPEED_OUT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_IN)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_IN_DOWN_LEFT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_IN_DOWN_RIGHT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_IN_UP_LEFT)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_IN_UP_RIGHT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_OUT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_OUT_DOWN_LEFT)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_OUT_DOWN_RIGHT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_OUT_UP_LEFT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_OUT_UP_RIGHT)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_IN_UP)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_IN_DOWN)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_IN_LEFT)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_IN_RIGHT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_OUT_UP)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_OUT_DOWN)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_OUT_LEFT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_OUT_RIGHT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_IN)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_IN_DOWN)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_IN_LEFT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_IN_RIGHT)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_IN_UP)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_OUT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_OUT_DOWN)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_OUT_LEFT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_OUT_RIGHT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_OUT_UP)
                        ))
                .element()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.HINGE)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROLL_IN)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROLL_OUT)
                        ))
                .element()
        );

        CodeCard.completeFetchCode(CodeResource.INSTANCE.transitionType(), value -> createAnimationAggregator.completeTransitionType(value));
        CodeCard.completeFetchCode(CodeResource.INSTANCE.delay(), value -> createAnimationAggregator.completeDelay(value));
        CodeCard.completeFetchCode(CodeResource.INSTANCE.onBeforeStart(), value -> createAnimationAggregator.completeBeforeStart(value));
        CodeCard.completeFetchCode(CodeResource.INSTANCE.infinite(), value -> createAnimationAggregator.completeInfinite(value));
        CodeCard.completeFetchCode(CodeResource.INSTANCE.stop(), value -> createAnimationAggregator.completeStop(value));

        element.appendChild(createAnimationCard.element());

        return element;
    }


    @Aggregate(name="CreateAnimationAggregator")
    public void onCodeLoaded(String transitionType, String delay, String beforeStart, String infinite, String stop){
        createAnimationCard.setCode("// Create an animation for the element and pass the transition type and other parameters\n" +
                        transitionType +
                        "\n\n// Delay animation start\n" +
                        delay +
                        "\n\n// Do something before animation start\n" +
                        beforeStart +
                        "\n\n// Make the animation infinite\n" +
                        infinite +
                        "\n\n// Stop the infinite animation\n" +
                        stop);
    }


    private Card createCard(Transition transition) {

        Card animationCard = Card.create().setBackground(Color.BLUE_GREY)
                .appendChild(img(GWT.getModuleBaseURL() + "/images/animation-bg.jpg").css(Styles.img_responsive));

        Card card = Card.create(transition.getName(), transition.getStyle() + " animation.")
                .setBodyBackground(Color.LIGHT_BLUE)
                .setHeaderBackground(Color.BLUE);

        Button animate = Button.createDefault(transition.getName())
                .large();
        animate.getClickableElement().addEventListener("click", e ->
                Animation.create(animationCard)
                        .beforeStart(element -> {/*do something here*/})
                        .transition(transition)
                        .duration(1000)
                        .animate());

        Button infiniteAnimate = Button.createDefault("INFINITE")
                .large();
        infiniteAnimate.getClickableElement().addEventListener("click", e -> {

            Animation animation = Animation.create(animationCard)
                    .transition(transition)
                    .infinite()
                    .duration(1000);
            if (Style.of(animationCard).contains("animated")) {
                animation.stop();
                Style.of(animate).setDisplay("inline-block");
                infiniteAnimate.setContent("INFINITE");
            } else {
                animation.animate();
                Style.of(animate).setDisplay("none");
                infiniteAnimate.setContent("STOP");
            }
        });

        card.appendChild(animationCard)
                .appendChild(Elements.div().css("button-demo").attr("style", "text-align: center")
                        .add(animate)
                        .add(infiniteAnimate)
                );

        return card;
    }

    @SampleMethod
    private void transitionType() {

        Animation.create(element)
                .transition(Transition.BOUNCE)
                .duration(1000)
                .animate();
    }

    @SampleMethod
    private void delay() {

        Animation.create(element)
                .transition(Transition.FLASH)
                .duration(1000)
                .delay(1000)
                .animate();
    }

    @SampleMethod
    private void onBeforeStart() {

        Animation.create(element)
                .transition(Transition.FLASH)
                .duration(1000)
                .beforeStart(element -> {/*do something here*/})
                .animate();
    }

    @SampleMethod
    private void infinite() {

        Animation.create(element)
                .transition(Transition.FLIP)
                .duration(1000)
                .infinite()
                .animate();
    }

    @SampleMethod
    private void stop() {

        Animation animation = Animation.create(element)
                .transition(Transition.TADA)
                .duration(1000)
                .infinite()
                .animate();

        animation.stop();
    }
}