package org.dominokit.domino.home.client.views.ui;

import elemental2.dom.HTMLDivElement;
import jsinterop.base.Js;
import org.dominokit.domino.api.client.ClientApp;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.history.AppHistory;
import org.dominokit.domino.history.HistoryToken;
import org.dominokit.domino.history.StateToken;
import org.dominokit.domino.home.client.presenters.HomeProxy;
import org.dominokit.domino.home.client.views.HomeView;
import org.dominokit.domino.ui.button.LinkButton;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.spin.HSpinSelect;
import org.dominokit.domino.ui.spin.SpinItem;
import org.dominokit.domino.ui.style.ColorsCss;
import org.dominokit.domino.ui.style.CompositeCssClass;
import org.dominokit.domino.ui.style.SpacingCss;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.gwtproject.timer.client.Timer;

import static elemental2.dom.DomGlobal.window;

@UiView(presentable = HomeProxy.class)
public class HomeViewImpl extends BaseDemoView<HTMLDivElement> implements HomeView {

    private DivElement element;
    private int direction = 1;
    private Timer timer;
    private HSpinSelect<String> spinSelect;
    private CompositeCssClass roundedCss;

    @Override
    protected HTMLDivElement init() {
        roundedCss = CompositeCssClass.of(dui_rounded_tl_sm, dui_rounded_tr_sm);

        element = div();

        element.appendChild(BlockHeader.create("DOMINO-UI"));
        element.appendChild(p().textContent("Java based lightweight UI library that in addition to performance and functionality brings elegance to enterprise web applications.")
                .addCss(ColorsCss.dui_fg_color_1));
        initCards();

        quickInsight();

        initAuthors();

        initSponsors();

        initHelpAndSupport();
        initWhatOthersSay();
        initFollowUs();
        initPoweredBy();

        return element.element();
    }

    private void initPoweredBy() {

        element.appendChild(div().addCss(dui_text_center, dui_m_t_3, dui_m_l_3)
                .appendChild(p().setTextContent("Powered by GWT"))
                .appendChild(a("http://www.gwtproject.org/", "_blank")
                        .appendChild(img("images/home/gwt-logo.png").addCss(dui_w_16))
                )
                .element()
        );
    }

    private void initFollowUs() {
        element.appendChild(div().addCss(dui_flex, dui_justify_center, dui_gap_4, dui_items_center)
                .appendChild(a("https://twitter.com/dominokit", "_blank")
                        .appendChild(img("images/home/Twitter-Logo.png").addCss(dui_w_16)))
                .appendChild(a("https://www.facebook.com/orgdomino", "_blank")
                        .appendChild(img("images/home/facebook_circle-512.png").addCss(dui_w_12)))
                .element());
    }

    private void initHelpAndSupport() {
        element.appendChild(BlockHeader.create("HELP & SUPPORT").element());
        element.appendChild(Card.create()
                .appendChild(div().addCss(dui_text_center)
                        .appendChild(p().setTextContent("We will help you learn domino-ui and will support you when use domino-ui through"))
                        .appendChild(p().setTextContent("If you need to asking a question ,troubleshoot an issue or fix a bug reach us at our gitter channel or open an issue at github "))
                )
                .appendChild(div()
                        .addCss(dui_text_center)
                        .appendChild(a("https://github.com/DominoKit/domino-ui/issues", "_blank")
                                .appendChild(img("images/home/github-circle.png")
                                        .addCss(dui_image_responsive, dui_w_32, dui_inline_block, dui_m_r_1)
                                        .setTooltip("Github Issues")
                                )
                        )
                        .appendChild(a("https://gitter.im/domino-gwt/domino-ui", "_blank")
                                .appendChild(img("images/home/gitter.png")
                                        .addCss(dui_image_responsive, dui_w_32, dui_inline_block, dui_rounded_full, dui_m_l_1)
                                        .setTooltip("Gitter chat"))
                        )

                )
                .appendChild(hr().addCss(roundedCss))
                .appendChild(div()
                        .addCss(dui_text_center)
                        .appendChild(h(6).textContent("COMMERCIAL SERVICES"))
                        .appendChild(h(4).textContent("Official Developer Support"))
                        .appendChild(p().setTextContent("Need help troubleshooting or improving your code? Work directly with the engineers behind the Domino-ui."))
                        .appendChild(p().setTextContent("Or you want custom components or new features?"))
                        .appendChild(a("https://www.vertispan.com/services", "_blank")
                                .appendChild(h(5).textContent("Get paid support")
                                        .addCss(dui_underline)
                                )
                        )
                        .appendChild(div()
                                .addCss(dui_text_center)
                                .appendChild(img("images/sponsors/vertispan.png")
                                        .addCss(dui_w_32)
                                        .setTooltip("Vertispan")
                                )
                                .appendChild(img("images/sponsors/domino-logo-256.png")
                                        .addCss(dui_w_12)
                                        .setTooltip("Dominokit")
                                )
                        ))
                .element());
    }

    private void initWhatOthersSay() {
        element.appendChild(BlockHeader.create("WHAT OTHERS SAY").element());
        spinSelect = HSpinSelect.<String>create().addCss(dui_h_48);
        element.appendChild(Card.create()
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(spinSelect
                                        .appendChild(SpinItem.create("")
                                                .appendChild(div().addCss(dui_text_center)
                                                        .appendChild(img("https://secure.gravatar.com/avatar/7ec73ac46e7215d35633a18d134f44e7")
                                                                .addCss(dui_image_responsive, () -> "person-pic", () -> "quote-pic", dui_elevation_1, dui_m_x_auto))
                                                        .appendChild(h(3).textContent("Flavio Castro"))
                                                        .appendChild(p().setTextContent("After years working with GWT, Domino-ui came to the rescue, making the developers lives easier while providing a better and faster experience to the users."))
                                                        .appendChild(p().setTextContent("- Tech Leader / Architect @ Ardan1")
                                                                .addCss(dui_font_size_4, dui_italic, dui_fg_grey)
                                                        )
                                                )
                                        )
                                        .appendChild(SpinItem.create("")
                                                .appendChild(div().addCss(dui_text_center)
                                                        .appendChild(img("images/sponsors/raul.jpg")
                                                                .addCss(dui_image_responsive, () -> "person-pic", () -> "quote-pic", dui_elevation_1, dui_m_x_auto))
                                                        .appendChild(h(3).textContent("Raúl Pampliega Mayoral"))
                                                        .appendChild(p().setTextContent("After trying out several ways to modernize our UI layer, Domino-ui make us really fast and it looks and feel amazing."))
                                                        .appendChild(p().setTextContent("- Software Engineer @ Babcock MCS Spain")
                                                                .addCss(dui_font_size_4, dui_italic, dui_fg_grey)
                                                        )
                                                )
                                        )
                                        .appendChild(SpinItem.create("")
                                                .appendChild(div().addCss(dui_text_center)
                                                        .appendChild(img("images/sponsors/anas-zahran.jpg")
                                                                .addCss(dui_image_responsive, () -> "person-pic", () -> "quote-pic", dui_elevation_1, dui_m_x_auto))
                                                        .appendChild(h(3).textContent("Anas Zahran"))
                                                        .appendChild(p().setTextContent("Domino-ui can smoothly reduce the lines of code required to create a cross browser web application."))
                                                        .appendChild(p().setTextContent("- Technologist @ Progressoft")
                                                                .addCss(dui_font_size_4, dui_italic, dui_fg_grey)
                                                        )
                                                )
                                        )
                                        .appendChild(SpinItem.create("")
                                                .appendChild(div().addCss(dui_text_center)
                                                        .appendChild(img("images/sponsors/saif-badran.jpg")
                                                                .addCss(dui_image_responsive, () -> "person-pic", () -> "quote-pic", dui_elevation_1, dui_m_x_auto))
                                                        .appendChild(h(3).textContent("Saif Badran"))
                                                        .appendChild(p().setTextContent("Domino-ui made it so simple. It's a real pleasure working on it, the way it generates professional, user-friendly interfaces is impressive!."))
                                                        .appendChild(p().setTextContent("- Software Engineer @ Progressoft")
                                                                .addCss(dui_font_size_4, dui_italic, dui_fg_grey)
                                                        )
                                                )
                                        )
                                )
                        )

                )
                .element());

        timer = new Timer() {
            @Override
            public void run() {
                SpinItem<String> activeItem = spinSelect.getActiveItem();
                if (spinSelect.isLastItem(activeItem)) {
                    direction = 2;
                } else if (spinSelect.isFirstItem(activeItem)) {
                    direction = 1;
                }

                if (direction == 1) {
                    spinSelect.moveForward();
                } else {
                    spinSelect.moveBack();
                }
            }
        };

        spinSelect.addChangeListener((oldValue, newValue) -> {
            if (timer.isRunning()) {
                timer.cancel();
                timer.scheduleRepeating(10000);
            }
        });

        timer.scheduleRepeating(10000);

    }

    private void initSponsors() {
        element.appendChild(BlockHeader.create("SPONSORS & SUPPORTERS").element());

        element.appendChild(Card.create()
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .addCss(dui_text_center)
                                .appendChild(a("https://www.vertispan.com/", "_blank")
                                        .appendChild(img("images/sponsors/vertispan.png")
                                                .addCss(dui_w_24, dui_m_x_auto, dui_image_responsive, dui_cursor_pointer)
                                        )
                                )
                        )
                        .appendChild(Column.span6()
                                .addCss(dui_text_center)
                                .appendChild(a("https://www.ej-technologies.com/products/install4j/overview.html", "_blank")
                                        .appendChild(img("images/sponsors/install4j_large.png")
                                                .addCss(dui_top_5, dui_m_x_auto, dui_image_responsive, dui_cursor_pointer)
                                        )
                                )
                        )
                )
                .element());
    }

    private void initAuthors() {
        element.appendChild(BlockHeader.create("AUTHORS").element());
        element.appendChild(Card.create()
                .addCss(dui_bg_black)

                .appendChild(Row.create()
                        .appendChild(Column.span5()
                                .offset1()
                                .addCss(SpacingCss.dui_text_center, dui_fg_white)
                                .appendChild(img("images/authors/Ahmad.Bawaneh.jpg")
                                        .addCss(dui_image_responsive, () -> "person-pic", dui_m_auto))
                                .appendChild(h(3).textContent("Ahmad Bawaneh"))
                                .appendChild(p().setTextContent("Java developer with 11 years experience in building enterprise web application, works on both frontend and backend, and is big fan of GWT"))
                                .appendChild(div()
                                        .appendChild(a()
                                                .setAttribute("href", "https://www.linkedin.com/in/ahmad-bawaneh")
                                                .setAttribute("target", "_blank")
                                                .appendChild(img("images/authors/linkedin.png")
                                                        .addCss(dui_cursor_pointer)))
                                        .appendChild(a()
                                                .setAttribute("href", "https://github.com/vegegoku")
                                                .setAttribute("target", "_blank")
                                                .appendChild(img("images/authors/github.png")
                                                        .addCss(dui_cursor_pointer))))
                        )
                        .appendChild(Column.span5()
                                .addCss(SpacingCss.dui_text_center, dui_fg_white)
                                .appendChild(img("images/authors/Rafat.albarouki.jpg")
                                        .addCss(dui_image_responsive, () -> "person-pic", dui_m_auto))
                                .appendChild(h(3).textContent("Rafat Al-Barouki"))
                                .appendChild(p().setTextContent("Java developer with 5 years experience in building enterprise web application, works on both frontend and backend, and is big fan of GWT"))
                                .appendChild(div()
                                        .appendChild(a()
                                                .setAttribute("href", "https://www.linkedin.com/in/rafat-al-barouki")
                                                .setAttribute("target", "_blank")
                                                .appendChild(img("images/authors/linkedin.png")
                                                        .addCss(dui_cursor_pointer)))
                                        .appendChild(a()
                                                .setAttribute("href", "https://github.com/rjeeb")
                                                .setAttribute("target", "_blank")
                                                .appendChild(img("images/authors/github.png")
                                                        .addCss(dui_cursor_pointer))))
                        )

                ).appendChild(div().addCss("bg-classy"))
                .element());

    }

    private void initCards() {


        element.appendChild(div()
                .appendChild(Row.create()
                        .addCss(dui_gap_4)
                        .appendChild(Column.span3()
                                .appendChild(Card.create()
                                        .addCss("demo-nav-card")
                                        .withBody((card, body) -> body.addCss(dui_p_0, roundedCss))
                                        .appendChild(div()
                                                .addCss("gs-background", "demo-getting-started")
                                                .addCss(roundedCss)
                                                .setCssProperty("background-image", "linear-gradient(to left bottom, #d54b57, #a73763, #712f61, #3c264f, #111832)")
                                                .appendChild(img("images/home/rocket.png")
                                                        .addCss(dui_m_auto, dui_w_48, dui_image_responsive))
                                        )
                                        .appendChild(div()
                                                .addCss(dui_p_5)
                                                .appendChild(BlockHeader.create("GETTING STARTED", "A guid to create and setup a new project"))
                                                .appendChild(Row.create()
                                                        .span12(div()
                                                                .addCss(dui_text_center, dui_m_t_5)
                                                                .appendChild(LinkButton.create("GO").addCss(dui_min_w_32)
                                                                        .addClickListener(evt -> window.open("https://github.com/DominoKit/domino-ui/wiki/Getting-started", "_blank"))
                                                                ))
                                                ))
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Card.create()
                                        .addCss("demo-nav-card")
                                        .withBody((card, body) -> body.addCss(dui_p_0, roundedCss))
                                        .appendChild(div()
                                                .addCss("gs-background", "demo-docs")
                                                .addCss(roundedCss)
                                                .setCssProperty("background-image", "linear-gradient(to left bottom, #52b46b, #009a8d, #007a8e, #425a70, #414045)")
                                                .appendChild(img("images/home/documents.png")
                                                        .addCss(dui_m_auto, dui_w_48, dui_image_responsive))
                                        )
                                        .appendChild(div()
                                                .addCss(dui_p_5)
                                                .appendChild(BlockHeader.create("DOCUMENTATION", "Detailed guide for every component"))
                                                .appendChild(Row.create()
                                                        .span12(div()
                                                                .addCss(dui_text_center, dui_m_t_5)
                                                                .appendChild(LinkButton.create("GO").addCss(dui_min_w_32)
                                                                        .addClickListener(evt -> Notification.create("Coming soon ...").addCss(dui_info).show())
                                                                ))
                                                ))
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Card.create()
                                        .addCss("demo-nav-card")
                                        .withBody((card, body) -> body.addCss(dui_p_0, roundedCss))
                                        .appendChild(div()
                                                .addCss("gs-background", "demo-sample-apps")
                                                .addCss(roundedCss)
                                                .setCssProperty("background-image", "linear-gradient(to left bottom, #dff5fe, #a8c2d1, #7492a6, #45637d, #183856)")
                                                .appendChild(img("images/home/apps-2.png")
                                                        .addCss(dui_m_auto, dui_w_48, dui_image_responsive))
                                        )
                                        .appendChild(div()
                                                .addCss(dui_p_5)
                                                .appendChild(BlockHeader.create("SAMPLE APPS", "Built with Domino-ui apps"))
                                                .appendChild(Row.create()
                                                        .span12(div()
                                                                .addCss(dui_text_center, dui_m_t_5)
                                                                .appendChild(LinkButton.create("GO").addCss(dui_min_w_32)
                                                                        .addClickListener(evt -> {
                                                                            AppHistory history = Js.uncheckedCast(ClientApp.make().getHistory());
                                                                            HistoryToken samples = history
                                                                                    .currentToken()
                                                                                    .replaceLastPath("samples");
                                                                            history.pushState(StateToken.of(samples.value()));
                                                                            history.fireCurrentStateHistory();
                                                                        })
                                                                ))
                                                ))
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Card.create()
                                        .addCss("demo-nav-card")
                                        .withBody((card, body) -> body.addCss(dui_p_0, roundedCss))
                                        .appendChild(div()
                                                .addCss("gs-background", "demo-github")
                                                .addCss(roundedCss)
                                                .setCssProperty("background-image", "linear-gradient(to left bottom, #f4cab1, #bc9a8c, #856d67, #504442, #201f1f)")
                                                .appendChild(img("images/home/github.png")
                                                        .addCss(dui_m_auto, dui_h_48, dui_image_responsive))
                                        )
                                        .appendChild(div()
                                                .addCss(dui_p_5)
                                                .appendChild(BlockHeader.create("GITHUB PROJECT", "Star us on Github."))
                                                .appendChild(Row.create()
                                                        .span12(div()
                                                                .addCss(dui_text_center, dui_m_t_5)
                                                                .appendChild(LinkButton.create("GO").addCss(dui_min_w_32)
                                                                        .addClickListener(evt -> window.open("https://github.com/DominoKit/domino-ui", "_blank"))

                                                                ))
                                                ))
                                )
                        )
                )
                .element()

        );
    }

    private void quickInsight() {
        element.appendChild(BlockHeader.create("QUICK INSIGHT").element());
        element.appendChild(Card.create()
                .addCss("home-sections", "gs-background", "demo-docs")
                .withBody((card, body) -> body.addCss(dui_p_0))
                .appendChild(div()
                        .addCss("home-section", "slide-1")
                        .addCss(dui_bg_dominant)
                        .appendChild(Row.create()
                                .appendChild(Column.span4()
                                        .appendChild(img("images/insight/domino-ui-slide-1.png")
                                                .addCss(dui_image_responsive, dui_elevation_1)))
                                .appendChild(Column.span8().addCss(dui_p_x_8)
                                        .appendChild(BlockHeader.create("Type safe"))
                                        .appendChild(p().setTextContent("Domino-ui is Java based compiled to JavaScript, which means during development of the application you have the power to refactor and keep your app maintainable all the time, but also you develop your application with the mature set of all tool chain java can provide, this include extremely powerful IDEs and mature build tools like maven and gradle, use domino-ui and bring your java team to the frontend world."))
                                ))

                ).appendChild(div()
                        .addCss("home-section", "slide-2")
                        .addCss(dui_bg_dominant_l_2)
                        .appendChild(Row.create()
                                .appendChild(Column.span8().addCss(dui_p_x_8)
                                        .appendChild(BlockHeader.create("Elegant"))
                                        .appendChild(p().setTextContent("Domino-ui cares about performance and functionality, but also cares about elegance, enterprise applications could be rich and crowded but when you use domino-ui rich components you will also have neat smooth friendly screens, with proper spacing, consistent color palette and just the right amount of effects and animations you bring the users of the application to love it."))
                                )
                                .appendChild(Column.span4()
                                        .appendChild(img("images/insight/domino-ui-slide-2.png")
                                                .addCss(dui_image_responsive, dui_elevation_1))))
                )
                .appendChild(div()
                        .addCss("home-section", "slide-3")
                        .addCss(dui_bg_dominant)
                        .appendChild(Row.create()
                                .appendChild(Column.span4()
                                        .appendChild(img("images/insight/domino-ui-slide-3.png")
                                                .addCss(dui_image_responsive, dui_elevation_1)
                                        )
                                )
                                .appendChild(Column.span8().addCss(dui_p_x_8)
                                        .appendChild(BlockHeader.create("Rich data table"))
                                        .appendChild(p().setTextContent("Almost every enterprise application uses data tables, domino-ui realise this fact and provides a rich, functional and elegant data table which is extendable with a rich set of ready to use plugins like selection plugin, marker plugin, record details plugin, search plugin and more, but this is not limited since the user can write his own plugins, and even better we are continuously adding more plugins."))
                                ))

                ).appendChild(div().addCss("home-section", "slide-4")
                        .addCss(dui_bg_dominant_l_2)
                        .appendChild(Row.create()
                                .appendChild(Column.span8().addCss(dui_p_x_8)
                                        .appendChild(BlockHeader.create("Rich Forms"))
                                        .appendChild(p().setTextContent("Having rich interactive forms is essential for enterprise applications, domino-ui has a rich set of form controls that enables the developer to easily implement both simple and complex form, with the smooth easy to use API making the forms interactive is an easy task, validating user input is a simple call, and of course with a proper data binding mechanism to read and fill form from data objects."))
                                )
                                .appendChild(Column.span4()
                                        .appendChild(img("images/insight/domino-ui-slide-4.png")
                                                .addCss(dui_image_responsive, dui_elevation_1)
                                        )
                                )
                        )
                )
                .appendChild(div().addCss("home-section", "slide-5")
                        .addCss(dui_bg_dominant)
                        .appendChild(Row.create()
                                .appendChild(Column.span4()
                                        .appendChild(img("images/insight/domino-ui-slide-5.png")
                                                .addCss(dui_image_responsive, dui_elevation_1)
                                        )
                                )
                                .appendChild(Column.span8().addCss(dui_p_x_8)
                                        .appendChild(BlockHeader.create("Typography & Font icons"))
                                        .appendChild(p().setTextContent("Icons and Typography can enhance the user experience of the application, domino-ui has a very good of font icons that can bring forms and other elements in the page into life, and this not only applies for enterprise applications but also for simple application like blogs, in domino-ui creating typography elements is very easy and stylish."))
                                ))
                )
                .element());
    }
}