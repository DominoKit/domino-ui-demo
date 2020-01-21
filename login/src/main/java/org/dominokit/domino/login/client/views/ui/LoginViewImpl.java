package org.dominokit.domino.login.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.login.client.presenters.LoginProxy;
import org.dominokit.domino.login.client.views.LoginView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;

import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.img;

@UiView(presentable = LoginProxy.class)
@SampleClass
public class LoginViewImpl extends BaseDemoView<HTMLDivElement> implements LoginView {

    private HTMLDivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div().element();

        element.appendChild(BlockHeader.create("LOGIN", "Sample login dialogs").element());
        element.appendChild(LinkToSourceCode.create("login", LoginViewImpl.class).element());

        sample1();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.sample1()).element());

        sample2();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.sample2()).element());

        sample3();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.sample3()).element());

        sample4();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.sample4()).element());

        sample5();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.sample5()).element());

        sample6();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.sample6()).element());

        return element;
    }

    @SampleMethod
    private void sample1() {
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .offset4()
                        .appendChild(Card.create("LOGIN")
                                .appendChild(TextBox.create("User name")
                                        .setRequired(true)
                                        .setAutoValidation(true))
                                .appendChild(TextBox.password("Password")
                                        .setRequired(true)
                                        .setAutoValidation(true))
                                .appendChild(Button.create(Icons.ALL.lock_open())
                                        .setBackground(Color.THEME)
                                        .setContent("Login")
                                        .block())
                        ))
                .element());
    }

    @SampleMethod
    private void sample2() {
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .offset4()
                        .appendChild(Card.create("LOGIN")
                                .setHeaderBackground(Color.THEME)
                                .appendChild(TextBox.create("User name")
                                        .addLeftAddOn(Icons.ALL.person())
                                        .setRequired(true)
                                        .setAutoValidation(true))
                                .appendChild(TextBox.password("Password")
                                        .addLeftAddOn(Icons.ALL.security())
                                        .setRequired(true)
                                        .setAutoValidation(true))
                                .appendChild(CheckBox.create("Remember me")
                                        .style().add(Styles.m_l_15))
                                .appendChild(Button.create(Icons.ALL.lock_open())
                                        .setBackground(Color.THEME)
                                        .setContent("Login")
                                        .block())
                        ))
                .element());
    }

    @SampleMethod
    private void sample3() {
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .offset4()
                        .appendChild(Card.create("LOGIN")
                                .setHeaderBackground(Color.THEME)
                                .appendChild(TextBox.create("User name")
                                        .addLeftAddOn(Icons.ALL.person())
                                        .setRequired(true)
                                        .setAutoValidation(true))
                                .appendChild(TextBox.password("Password")
                                        .addLeftAddOn(Icons.ALL.security())
                                        .setRequired(true)
                                        .setAutoValidation(true))
                                .appendChild(CheckBox.create("Remember me")
                                        .style().add(Styles.m_l_15))
                                .appendChild(div()
                                        .add(Button.create(Icons.ALL.lock_open())
                                                .setBackground(Color.THEME)
                                                .setContent("Login")
                                                .styler(style -> style.setMinWidth("120px")))
                                        .add(Button.create("Forget password")
                                                .linkify()
                                                .style()
                                                .add(Styles.pull_right)))
                        ))
                .element());
    }

    @SampleMethod
    private void sample4() {
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .offset4()
                        .appendChild(Card.create()
                                .fitContent()
                                .appendChild(img("/images/login/login-bg-1.jpg")
                                        .css(Styles.img_responsive))
                                .appendChild(DominoElement.of(div().css(Styles.padding_20))
                                        .appendChild(TextBox.create("User name")
                                                .setRequired(true)
                                                .setAutoValidation(true))
                                        .appendChild(TextBox.password("Password")
                                                .setRequired(true)
                                                .setAutoValidation(true))
                                        .appendChild(Button.createSuccess(Icons.ALL.lock_open())
                                                .setContent("Login")
                                                .block())
                                )

                        ))
                .element());
    }

    @SampleMethod
    private void sample5() {
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .offset4()
                        .appendChild(Card.create()
                                .fitContent()
                                .appendChild(div()
                                        .css(Styles.align_center)
                                        .css(Styles.padding_30)
                                        .css("avatar-container")
                                        .add(img("/images/login/login-bg-2.png")
                                                .css(Styles.img_responsive)
                                                .css(Elevation.LEVEL_1.getStyle())
                                                .css("login-avatar")))
                                .appendChild(DominoElement.of(div().css(Styles.padding_30))
                                        .appendChild(TextBox.create("User name")
                                                .addLeftAddOn(Icons.ALL.person())
                                                .floating()
                                                .setRequired(true)
                                                .setAutoValidation(true))
                                        .appendChild(TextBox.password("Password")
                                                .addLeftAddOn(Icons.ALL.security())
                                                .floating()
                                                .setRequired(true)
                                                .setAutoValidation(true))
                                        .appendChild(Button.create(Icons.ALL.lock_open())
                                                .setBackground(Color.CYAN)
                                                .setContent("Login")
                                                .block())
                                )

                        ))
                .element());
    }

    @SampleMethod
    private void sample6() {
        element.appendChild(Row.create()
                .appendChild(Column.span6()
                        .offset3()
                        .appendChild(Card.create()
                                .fitContent()
                                .appendChild(Row.create()
                                        .styler(style -> style.setPadding("0px"))
                                        .condenced()
                                        .appendChild(Column.span6()
                                                .condenced()
                                                .appendChild(div()
                                                        .css("avatar-container")
                                                        .add(img("/images/greyscale-1.jpg")
                                                                .css(Styles.img_responsive))))
                                        .appendChild(Column.span6()
                                                .condenced()
                                                .appendChild(DominoElement.of(div()
                                                        .css(Styles.p_l_30)
                                                        .css(Styles.p_r_30)
                                                        .css(Styles.p_b_30)
                                                        .css(Styles.p_t_60)
                                                        .style("height: 100%;"))
                                                        .appendChild(TextBox.create("User name")
                                                                .addLeftAddOn(Icons.ALL.person())
                                                                .floating()
                                                                .setRequired(true)
                                                                .setAutoValidation(true))
                                                        .appendChild(TextBox.password("Password")
                                                                .addLeftAddOn(Icons.ALL.security())
                                                                .floating()
                                                                .setRequired(true)
                                                                .setAutoValidation(true))
                                                        .appendChild(Button.create(Icons.ALL.lock_open())
                                                                .setBackground(Color.THEME)
                                                                .setContent("Login")
                                                                .style()
                                                                .add(Styles.pull_right)
                                                                .add("side-login-btn"))
                                                ))
                                )
                        ))
                .element());
    }
}