package org.dominokit.domino.login.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.login.client.presenters.LoginPresenter;
import org.dominokit.domino.login.client.views.CodeResource;
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
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;

import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.img;

@UiView(presentable = LoginPresenter.class)
public class LoginViewImpl extends ComponentView<HTMLDivElement> implements LoginView {

    private HTMLDivElement element = div().asElement();

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("LOGIN", "Sample login dialogs").asElement());
        initSimpleLogin();
    }

    private void initSimpleLogin() {
        element.appendChild(LinkToSourceCode.create("alerts", LoginViewImpl.class).asElement());

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
                .asElement());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.login_1()).asElement());

        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .offset4()
                        .appendChild(Card.create("LOGIN")
                                .setHeaderBackground(Color.THEME)
                                .appendChild(TextBox.create("User name")
                                        .setLeftAddon(Icons.ALL.person())
                                        .setRequired(true)
                                        .setAutoValidation(true))
                                .appendChild(TextBox.password("Password")
                                        .setLeftAddon(Icons.ALL.security())
                                        .setRequired(true)
                                        .setAutoValidation(true))
                                .appendChild(CheckBox.create("Remember me")
                                        .style().add(Styles.m_l_15))
                                .appendChild(Button.create(Icons.ALL.lock_open())
                                        .setBackground(Color.THEME)
                                        .setContent("Login")
                                        .block())
                        ))
                .asElement());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.login_2()).asElement());

        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .offset4()
                        .appendChild(Card.create("LOGIN")
                                .setHeaderBackground(Color.THEME)
                                .appendChild(TextBox.create("User name")
                                        .setLeftAddon(Icons.ALL.person())
                                        .setRequired(true)
                                        .setAutoValidation(true))
                                .appendChild(TextBox.password("Password")
                                        .setLeftAddon(Icons.ALL.security())
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
                .asElement());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.login_3()).asElement());

        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .offset4()
                        .appendChild(Card.create()
                                .condenseBody()
                                .appendChild(img("./images/login/login-bg-1.jpg")
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
                .asElement());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.login_4()).asElement());

        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .offset4()
                        .appendChild(Card.create()
                                .condenseBody()
                                .appendChild(div()
                                        .css(Styles.align_center)
                                        .css(Styles.padding_30)
                                        .css("avatar-container")
                                        .add(img("./images/login/login-bg-2.png")
                                                .css(Styles.img_responsive)
                                                .css(Styles.default_shadow)
                                                .css("login-avatar")))
                                .appendChild(DominoElement.of(div().css(Styles.padding_30))
                                        .appendChild(TextBox.create("User name")
                                                .setLeftAddon(Icons.ALL.person())
                                                .floating()
                                                .setRequired(true)
                                                .setAutoValidation(true))
                                        .appendChild(TextBox.password("Password")
                                                .setLeftAddon(Icons.ALL.security())
                                                .floating()
                                                .setRequired(true)
                                                .setAutoValidation(true))
                                        .appendChild(Button.create(Icons.ALL.lock_open())
                                                .setBackground(Color.CYAN)
                                                .setContent("Login")
                                                .block())
                                )

                        ))
                .asElement());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.login_5()).asElement());


        element.appendChild(Row.create()
                .appendChild(Column.span6()
                        .offset3()
                        .appendChild(Card.create()
                                .condenseBody()
                                .appendChild(Row.create()
                                        .styler(style -> style.setPadding("0px"))
                                        .condenced()
                                        .appendChild(Column.span6()
                                                .condenced()
                                                .appendChild(div()
                                                        .css("avatar-container")
                                                        .add(img("./images/greyscale-1.jpg")
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
                                                                .setLeftAddon(Icons.ALL.person())
                                                                .floating()
                                                                .setRequired(true)
                                                                .setAutoValidation(true))
                                                        .appendChild(TextBox.password("Password")
                                                                .setLeftAddon(Icons.ALL.security())
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
                .asElement());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.login_6()).asElement());
    }


    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}