package org.dominokit.domino.home.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.home.client.presenters.HomePresenter;
import org.dominokit.domino.home.client.views.HomeView;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.spin.HSpinSelect;
import org.dominokit.domino.ui.spin.SpinItem;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.gwtproject.timer.client.Timer;

import static elemental2.dom.DomGlobal.window;
import static org.jboss.gwt.elemento.core.Elements.*;

@UiView(presentable = HomePresenter.class)
public class HomeViewImpl extends ComponentView<HTMLDivElement> implements HomeView {


    private HTMLDivElement element = div().asElement();
    private int direction = 1;
    private Timer timer;
    private HSpinSelect<String> spinSelect;

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {

        element.appendChild(BlockHeader.create("DOMINO-UI")
                .asElement());
        element.appendChild(Paragraph.create("Java based lightweight UI library that in addition to performance and functionality brings elegance to enterprise web applications.")
                .styler(style -> style.setColor("#666")
                        .setMarginBottom("30px"))
                .asElement());
        initCards();

        quickInsight();

        initAuthors();

        initSponsors();

        initHelpAndSupport();
        initWhatOthersSay();
        initFollowUs();
        initPoweredBy();

    }

    private void initPoweredBy() {

        element.appendChild(div()
                .css(Styles.align_center)
                .style("margin-top: 10px; margin-left: 13px;")
                .add(Paragraph.create("Powered by GWT"))
                .add(a()
                        .attr("href", "http://www.gwtproject.org/")
                        .attr("target", "_blank")
                        .add(img("./images/home/gwt-logo.png")
                                .style("width: 64px;")))
                .asElement());
    }

    private void initFollowUs() {
        element.appendChild(div().css(Styles.align_center)
                .add(a()
                        .attr("href", "https://twitter.com/dominokit")
                        .attr("target", "_blank")
                        .add(img("./images/home/Twitter-Logo.png")
                                .style("width: 64px;")))
                .add(a()
                        .attr("href", "https://www.facebook.com/orgdomino")
                        .attr("target", "_blank")
                        .add(img("./images/home/facebook_circle-512.png")
                                .style("width: 50px;")))
                .asElement());
    }

    private void initHelpAndSupport() {
        element.appendChild(BlockHeader.create("HELP & SUPPORT").asElement());
        element.appendChild(Card.create()
                .styler(style -> style
                        .add("authors-card"))
                .appendChild(div().css(Styles.align_center)
                        .add(Paragraph.create("We will help you learn domino-ui and will support you when use domino-ui through"))
                        .add(Paragraph.create("If you need to asking a question ,troubleshoot an issue or fix a bug reach us at our gitter channel or open an issue at github "))
                )
                .appendChild(div()
                        .css(Styles.align_center)
                        .add(a()
                                .attr("href", "https://github.com/DominoKit/domino-ui/issues")
                                .attr("target", "_blank")
                                .add(DominoElement.of(img("./images/home/github-circle.png")
                                        .css(Styles.img_responsive)
                                        .style("width: 128px; display: inline-block; margin-right: 5px;")
                                ).setTooltip("Github Issues"))
                        )
                        .add(a()
                                .attr("href", "https://gitter.im/domino-gwt/domino-ui")
                                .attr("target", "_blank")
                                .add(DominoElement.of(img("./images/home/gitter.png")
                                        .css(Styles.img_responsive)
                                        .style("width: 116px; display: inline-block;border-radius: 50%; margin-left: 5px;")
                                ).setTooltip("Gitter chat"))
                        )

                )
                .appendChild(hr())
                .appendChild(div()
                        .css(Styles.align_center)
                        .add(h(6).textContent("COMMERCIAL SERVICES").css(Styles.font_under_line))
                        .add(h(4).textContent("Official Developer Support"))
                        .add(Paragraph.create("Need help troubleshooting or improving your code? Work directly with the engineers behind the Domino-UI."))
                        .add(Paragraph.create("Or you want custom components or new features?"))
                        .add(a().add(h(5).textContent("Get paid support")))
                        .add(div().css(Styles.align_center)
                                .add(DominoElement.of(img("./images/sponsors/vertispan.png")
                                        .style("width: 128px;"))
                                        .setTooltip("Vertispan"))
                                .add(DominoElement.of(img("./images/sponsors/domino-ui-trans-bg.png")
                                        .style("width: 50px;"))
                                        .setTooltip("Dominokit"))
                        ))
                .appendChild(div().css("bg-authors"))
                .asElement());

    }

    private void initWhatOthersSay() {
        element.appendChild(BlockHeader.create("WHAT OTHERS SAY").asElement());
        spinSelect = HSpinSelect.create();
        element.appendChild(Card.create()
                .styler(style -> style
                        .add("authors-card"))
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .condenced()
                                .appendChild(spinSelect
                                        .appendChild(SpinItem.create("", DominoElement.of(div().css(Styles.align_center))
                                                .appendChild(img("https://secure.gravatar.com/avatar/7ec73ac46e7215d35633a18d134f44e7")
                                                        .css(Styles.img_responsive, "person-pic", "quote-pic", Styles.default_shadow))
                                                .appendChild(h(3).textContent("Flavio Castro"))
                                                .appendChild(Paragraph.create("After years working with GWT, Domino-UI came to the rescue, making the developers lives easier while providing a better and faster experience to the users."))
                                                .appendChild(Paragraph.create("- Tech Leader / Architect @ Ardan1")
                                                        .styler(style -> style.add(Styles.font_12)
                                                                .add(ColorScheme.GREY.darker_3().getStyle()))
                                                        .italic())))
                                        .appendChild(SpinItem.create("", DominoElement.of(div().css(Styles.align_center))
                                                .appendChild(img("./images/sponsors/raul.jpg")
                                                        .css(Styles.img_responsive, "person-pic", "quote-pic", Styles.default_shadow))
                                                .appendChild(h(3).textContent("Raúl Pampliega Mayoral"))
                                                .appendChild(Paragraph.create("After trying out several ways to modernize our UI layer, Domino UI make us really fast and it looks and feel amazing."))
                                                .appendChild(Paragraph.create("- Software Engineer @ Babcock MCS Spain")
                                                        .styler(style -> style.add(Styles.font_12)
                                                                .add(ColorScheme.GREY.darker_3().getStyle()))
                                                        .italic())))
                                        .appendChild(SpinItem.create("", DominoElement.of(div().css(Styles.align_center))
                                                .appendChild(img("./images/sponsors/anas.jpg")
                                                        .css(Styles.img_responsive, "person-pic", "quote-pic", Styles.default_shadow))
                                                .appendChild(h(3).textContent("Anas Zahran"))
                                                .appendChild(Paragraph.create("Domino UI can smoothly reduce the lines of code required to create a cross browser web application."))
                                                .appendChild(Paragraph.create("- Software Engineer @ Progressoft")
                                                        .styler(style -> style.add(Styles.font_12)
                                                                .add(ColorScheme.GREY.darker_3().getStyle()))
                                                        .italic())))
                                        .appendChild(SpinItem.create("", DominoElement.of(div().css(Styles.align_center))
                                                .appendChild(img("./images/sponsors/saif-badran.jpg")
                                                        .css(Styles.img_responsive, "person-pic", "quote-pic", Styles.default_shadow))
                                                .appendChild(h(3).textContent("Saif Badran"))
                                                .appendChild(Paragraph.create("Domino-ui made it so simple. It's a real pleasure working on it, the way it generates professional, user-friendly interfaces is impressive!."))
                                                .appendChild(Paragraph.create("- Software Engineer @ Progressoft")
                                                        .styler(style -> style.add(Styles.font_12)
                                                                .add(ColorScheme.GREY.darker_3().getStyle()))
                                                        .italic())))
                                )
                        )

                ).appendChild(div().css("bg-authors"))
                .asElement());

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
        spinSelect.onNavigate(direction -> {
            if (timer.isRunning()) {
                timer.cancel();
                timer.scheduleRepeating(10000);
            }
        });

        timer.scheduleRepeating(10000);

    }

    private void initSponsors() {
        element.appendChild(BlockHeader.create("SPONSORS").asElement());

        element.appendChild(Card.create()
                .styler(style -> style
                        .add("authors-card"))
                .appendChild(Row.create()
                        .appendChild(Column.span5()
                                .offset1()
                                .styler(style -> style.add(Styles.align_center))
                                .appendChild(a()
                                        .attr("href", "https://www.vertispan.com/")
                                        .attr("target", "_blank")
                                        .add(img("./images/sponsors/vertispan.png").css(Styles.img_responsive, Styles.cursor_pointer)))

                        )
                        .appendChild(Column.span5()
                                .styler(style -> style.add(Styles.align_center))
                                .appendChild(a()
                                        .attr("href", "https://www.progressoft.com/")
                                        .attr("target", "_blank")
                                        .add(img("./images/sponsors/ProgressSoft.png").css(Styles.img_responsive, Styles.cursor_pointer)))
                        )

                ).appendChild(div().css("bg-authors"))
                .asElement());
    }

    private void initAuthors() {
        element.appendChild(BlockHeader.create("AUTHORS").asElement());
        element.appendChild(Card.create()
                .styler(style -> style
                        .add(Color.BLACK.getBackground())
                        .add("authors-card"))
                .appendChild(Row.create()
                        .appendChild(Column.span5()
                                .offset1()
                                .styler(style -> style.add(Styles.align_center))
                                .appendChild(img("./images/authors/Ahmad.Bawaneh.jpg").css(Styles.img_responsive, "person-pic"))
                                .appendChild(h(3).textContent("Ahmad Bawaneh"))
                                .appendChild(Paragraph.create("Java developer with 11 years experience in building enterprise web application, works on both frontend and backend, and is big fan of GWT"))
                                .appendChild(div()
                                        .add(a()
                                                .attr("href", "https://www.linkedin.com/in/ahmad-bawaneh")
                                                .attr("target", "_blank")
                                                .add(img("./images/authors/linkedin.png")
                                                        .css(Styles.cursor_pointer)))
                                        .add(a()
                                                .attr("href", "https://github.com/vegegoku")
                                                .attr("target", "_blank")
                                                .add(img("./images/authors/github.png")
                                                        .css(Styles.cursor_pointer))))
                        )
                        .appendChild(Column.span5()
                                .styler(style -> style.add(Styles.align_center))
                                .appendChild(img("./images/authors/Rafat.albarouki.jpg").css(Styles.img_responsive, "person-pic"))
                                .appendChild(h(3).textContent("Rafat Al-Barouki"))
                                .appendChild(Paragraph.create("Java developer with 5 years experience in building enterprise web application, works on both frontend and backend, and is big fan of GWT"))
                                .appendChild(div()
                                        .add(a()
                                                .attr("href", "https://www.linkedin.com/in/rafat-al-barouki")
                                                .attr("target", "_blank")
                                                .add(img("./images/authors/linkedin.png")
                                                        .css(Styles.cursor_pointer)))
                                        .add(a()
                                                .attr("href", "https://github.com/rjeeb")
                                                .attr("target", "_blank")
                                                .add(img("./images/authors/github.png")
                                                        .css(Styles.cursor_pointer))))
                        )

                ).appendChild(div().css("bg-authors"))
                .asElement());

    }

    private void initCards() {
        element.appendChild(div().add(Row.create()
                .appendChild(Column.span3()
                        .appendChild(Card.create()
                                .styler(style -> style.add("demo-nav-card"))
                                .setBodyPadding("0px")
                                .appendChild(div().css("gs-background", "demo-getting-started").style("border-bottom:1px solid #dae7f8; background-image: linear-gradient(to left bottom, #d54b57, #a73763, #712f61, #3c264f, #111832);")
                                        .add(img("./images/home/rocket.png")
                                                .style("margin: auto; width: 200px;")
                                                .css(Styles.img_responsive)))
                                .appendChild(div()
                                        .style("padding: 20px;")
                                        .add(BlockHeader.create("GETTING STARTED", "A guid to create and setup a new project"))
                                        .add(Row.create()
                                                .fullSpan(column -> column
                                                        .styler(style -> style.add(Styles.align_center))
                                                        .condenced()
                                                        .styler(style -> style.setMarginTop("20px"))
                                                        .appendChild(Button.create("GO")
                                                                .linkify()
                                                                .styler(style -> style.setMinWidth("120px"))
                                                                .addClickListener(evt -> window.open("https://github.com/DominoKit/domino-ui/wiki/Getting-started", "_blank"))
                                                        ))
                                        ))
                        ))
                .appendChild(Column.span3().appendChild(Card.create()
                        .styler(style -> style.add("demo-nav-card"))
                        .setBodyPadding("0px")
                        .appendChild(div().css("gs-background", "demo-docs").style("border-bottom:1px solid #dae7f8; background-image: linear-gradient(to left bottom, #52b46b, #009a8d, #007a8e, #425a70, #414045);")
                                .add(img("./images/home/documents.png")
                                        .style("margin: auto; width: 200px;")
                                        .css(Styles.img_responsive)))
                        .appendChild(div()
                                .style("padding: 20px;")
                                .add(BlockHeader.create("DOCUMENTATION", "Detailed guid for every component.. coming soon"))
                                .add(Row.create()
                                        .fullSpan(column -> column
                                                .styler(style -> style.add(Styles.align_center))
                                                .condenced()
                                                .styler(style -> style.setMarginTop("20px"))
                                                .appendChild(Button.create("GO")
                                                        .linkify()
                                                        .styler(style -> style.setMinWidth("120px"))
                                                ))
                                ))
                ))
                .appendChild(Column.span3().appendChild(Card.create()
                        .styler(style -> style.add("demo-nav-card"))
                        .setBodyPadding("0px")
                        .appendChild(div().css("gs-background", "demo-sample-apps").style("border-bottom:1px solid #dae7f8; background-image: linear-gradient(to left bottom, #dff5fe, #a8c2d1, #7492a6, #45637d, #183856);")
                                .add(img("./images/home/apps-2.png")
                                        .style("margin: auto; width: 200px;")
                                        .css(Styles.img_responsive)))
                        .appendChild(div()
                                .style("padding: 20px;")
                                .add(BlockHeader.create("SAMPLE APPS", "List of sample application built with domino-ui"))
                                .add(Row.create()
                                        .fullSpan(column -> column
                                                .styler(style -> style.add(Styles.align_center))
                                                .condenced()
                                                .styler(style -> style.setMarginTop("20px"))
                                                .appendChild(Button.create("GO")
                                                        .linkify()
                                                        .styler(style -> style.setMinWidth("120px"))
                                                ))
                                ))
                ))
                .appendChild(Column.span3().appendChild(Card.create()
                        .styler(style -> style.add("demo-nav-card"))
                        .setBodyPadding("0px")
                        .appendChild(div().css("gs-background", "demo-github").style("border-bottom:1px solid #dae7f8;     background-image: linear-gradient(to left bottom, #f4cab1, #bc9a8c, #856d67, #504442, #201f1f);")
                                .add(img("./images/home/github.png")
                                        .style("margin: auto; height: 200px;")
                                        .css(Styles.img_responsive)))
                        .appendChild(div()
                                .style("padding: 20px;")
                                .add(BlockHeader.create("GITHUB PROJECT", "Our project at github"))
                                .add(Row.create()
                                        .fullSpan(column -> column
                                                .styler(style -> style.add(Styles.align_center))
                                                .condenced()
                                                .styler(style -> style.setMarginTop("20px"))
                                                .appendChild(Button.create("GO")
                                                        .linkify()
                                                        .styler(style -> style.setMinWidth("120px"))
                                                        .addClickListener(evt -> window.open("https://github.com/DominoKit/domino-ui", "_blank"))
                                                ))
                                ))
                )))
                .asElement());
    }

    private void quickInsight() {
        element.appendChild(BlockHeader.create("QUICK INSIGHT").asElement());
        element.appendChild(Card.create()
                .styler(style -> style.add("home-sections", "gs-background", "demo-docs"))
                .setBodyPadding("0px")
                .appendChild(div().css("home-section").css("slide-1").add(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(img("./images/insight/domino-ui-slide-1.png")
                                        .css(Styles.img_responsive).css(Styles.default_shadow)))
                        .appendChild(Column.span8()
                                .appendChild(BlockHeader.create("Type safe"))
                                .appendChild(Paragraph.create("Domino-ui is Java based compiled to JavaScript, which means during development of the application you have the power to refactor and keep your app maintainable all the time, but also you develop your application with the mature set of all tool chain java can provide, this include extremely powerful IDEs and mature build tools like maven and gradle, use domino-ui and bring your java team to the frontend world."))
                        ))
                        .add(div().css("breaker"))

                ).appendChild(div().css("home-section").css("slide-2").css("odd").add(Row.create()
                        .appendChild(Column.span8()
                                .appendChild(BlockHeader.create("Elegant"))
                                .appendChild(Paragraph.create("Domino-ui cares about performance and functionality, but also cares about elegance, enterprise applications could be rich and crowded but when you use domino-ui rich components you will also have neat smooth friendly screens, with proper spacing, consistent color palette and just the right amount of effects and animations you bring the users of the application to love it."))
                        )
                        .appendChild(Column.span4()
                                .appendChild(img("./images/insight/domino-ui-slide-2.png")
                                        .css(Styles.img_responsive).css(Styles.default_shadow))))
                        .add(div().css("breaker"))
                )
                .appendChild(div().css("home-section").css("slide-3").add(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(img("./images/insight/domino-ui-slide-3.png")
                                        .css(Styles.img_responsive).css(Styles.default_shadow)))
                        .appendChild(Column.span8()
                                .appendChild(BlockHeader.create("Rich data table"))
                                .appendChild(Paragraph.create("Almost every enterprise application uses data tables, domino-ui realise this fact and provides a rich, functional and elegant data table which is extendable with a rich set of ready to use plugins like selection plugin, marker plugin, record details plugin, search plugin and more, but this is not limited since the user can write his own plugins, and even better we are continuously adding more plugins."))
                        ))
                        .add(div().css("breaker"))

                ).appendChild(div().css("home-section").css("slide-4").css("odd").add(Row.create()
                        .appendChild(Column.span8()
                                .appendChild(BlockHeader.create("Rich Forms"))
                                .appendChild(Paragraph.create("Having rich interactive forms is essential for enterprise applications, domino-ui has a rich set of form controls that enables the developer to easily implement both simple and complex form, with the smooth easy to use API making the forms interactive is an easy task, validating user input is a simple call, and of course with a proper data binding mechanism to read and fill form from data objects."))
                        )
                        .appendChild(Column.span4()
                                .appendChild(img("./images/insight/domino-ui-slide-4.png")
                                        .css(Styles.img_responsive).css(Styles.default_shadow))))
                        .add(div().css("breaker"))
                )
                .appendChild(div().css("home-section").css("slide-5").add(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(img("./images/insight/domino-ui-slide-5.png")
                                        .css(Styles.img_responsive).css(Styles.default_shadow)))
                        .appendChild(Column.span8()
                                .appendChild(BlockHeader.create("Typography & Font icons"))
                                .appendChild(Paragraph.create("Icons and Typography can enhance the user experience of the application, domino-ui has a very good of font icons that can bring forms and other elements in the page into life, and this not only applies for enterprise applications but also for simple application like blogs, in domino-ui creating typography elements is very easy and stylish."))
                        ))

                )
                .asElement());

    }
}