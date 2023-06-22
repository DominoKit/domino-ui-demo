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
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.DisplayCss;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.typography.BlockHeader;

@UiView(presentable = AnimationProxy.class)
@SampleClass
public class AnimationViewImpl extends BaseDemoView<HTMLDivElement> implements AnimationView {

    CreateAnimationAggregator createAnimationAggregator;
    private DivElement element = div();
    private CodeCard createAnimationCard= new CodeCard();

    @Override
    protected HTMLDivElement init() {

        createAnimationAggregator = new CreateAnimationAggregator().init(this);

        element.appendChild(LinkToSourceCode.createLink("animation", this.getClass()));
        element.appendChild(BlockHeader.create("CSS ANIMATIONS")
                .appendChild("Pure css animations - ")
                .appendChild(a("https://daneden.github.io/animate.css/", "_blank")
                        .textContent("daneden.github.io/animate.css"))

        );


        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FLASH)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.PULSE)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.RUBBER_BAND)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.SHAKE)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.SWING)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.TADA)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.WOBBLE)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.JELLO)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_IN)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_IN_DOWN)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_IN_LEFT)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_IN_RIGHT)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_IN_UP)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_OUT)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_OUT_DOWN)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_OUT_LEFT)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_OUT_RIGHT)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_OUT_UP)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_DOWN)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_DOWN_BIG)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_LEFT)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_LEFT_BIG)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_RIGHT)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_RIGHT_BIG)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_UP)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_UP_BIG)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_DOWN)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_DOWN_BIG)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_LEFT)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_LEFT_BIG)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_RIGHT)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_RIGHT_BIG)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_UP)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_UP_BIG)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FLIP)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FLIP_IN_X)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FLIP_IN_Y)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FLIP_OUT_X)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.FLIP_OUT_Y)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.LIGHT_SPEED_IN)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.LIGHT_SPEED_OUT)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_IN)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_IN_DOWN_LEFT)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_IN_DOWN_RIGHT)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_IN_UP_LEFT)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_IN_UP_RIGHT)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_OUT)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_OUT_DOWN_LEFT)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_OUT_DOWN_RIGHT)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_OUT_UP_LEFT)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_OUT_UP_RIGHT)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_IN_UP)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_IN_DOWN)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_IN_LEFT)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_IN_RIGHT)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_OUT_UP)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_OUT_DOWN)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_OUT_LEFT)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_OUT_RIGHT)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_IN)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_IN_DOWN)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_IN_LEFT)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_IN_RIGHT)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_IN_UP)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_OUT)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_OUT_DOWN)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_OUT_LEFT)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_OUT_RIGHT)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_OUT_UP)
                        ))

        );
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.HINGE)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ROLL_IN)
                        ))
                .appendChild(Column.span4()
                        .appendChild(createCard(Transition.ROLL_OUT)
                        ))

        );

        CodeCard.completeFetchCode(CodeResource.INSTANCE.transitionType(), value -> createAnimationAggregator.completeTransitionType(value));
        CodeCard.completeFetchCode(CodeResource.INSTANCE.delay(), value -> createAnimationAggregator.completeDelay(value));
        CodeCard.completeFetchCode(CodeResource.INSTANCE.onBeforeStart(), value -> createAnimationAggregator.completeBeforeStart(value));
        CodeCard.completeFetchCode(CodeResource.INSTANCE.infinite(), value -> createAnimationAggregator.completeInfinite(value));
        CodeCard.completeFetchCode(CodeResource.INSTANCE.stop(), value -> createAnimationAggregator.completeStop(value));

        element.appendChild(createAnimationCard);

        return element.element();
    }

    private Card createCard(Transition transition) {

        Card animationCard = Card.create().addCss(dui_blue_grey)
                .appendChild(img(GWT.getModuleBaseURL() + "/images/animation-bg.jpg").addCss(dui_image_responsive));

        Card card = Card.create(transition.getName(), transition.getStyle() + " animation.")
                .withBody((parent, body) -> body.addCss(dui_light_blue))
                .withHeader((parent, header) -> header.addCss(dui_blue));

        Button animate = Button.create(transition.getName()).addCss(dui_large);
        animate.getClickableElement().addEventListener("click", e ->
                Animation.create(animationCard)
                        .beforeStart(element -> {/*do something here*/})
                        .transition(transition)
                        .duration(1000)
                        .animate());

        Button infiniteAnimate = Button.create("INFINITE")
                .addCss(dui_large);
        infiniteAnimate.getClickableElement().addEventListener("click", e -> {

            Animation animation = Animation.create(animationCard)
                    .transition(transition)
                    .infinite()
                    .duration(1000);
            if (Style.of(animationCard).containsCss("animated")) {
                animation.stop();
                Style.of(animate).setDisplay("inline-block");
                infiniteAnimate.setText("INFINITE");
            } else {
                animation.animate();
                Style.of(animate).setDisplay("none");
                infiniteAnimate.setText("STOP");
            }
        });

        card.appendChild(animationCard)
                .appendChild(div().addCss(dui_flex, dui_justify_center, dui_gap_1)
                        .appendChild(animate)
                        .appendChild(infiniteAnimate)
                );

        return card;
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