package org.dominokit.domino.mdiicons.client.views.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import elemental2.dom.ClipboardEvent;
import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import jsinterop.base.Js;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.mdiicons.client.presenters.MdiIconsProxy;
import org.dominokit.domino.mdiicons.client.views.CodeResource;
import org.dominokit.domino.mdiicons.client.views.MdiIconsView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.grid.Row_12;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiByTagFactory;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.icons.MdiTags;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.DominoDom;
import org.jboss.elemento.HtmlContentBuilder;
import org.jboss.elemento.InputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Supplier;

import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.h;
import static org.jboss.elemento.Elements.input;
import static org.jboss.elemento.Elements.span;

@UiView(presentable = MdiIconsProxy.class)
public class MdiIconsViewImpl extends BaseDemoView<HTMLDivElement> implements MdiIconsView {

    private static final Logger LOGGER = LoggerFactory.getLogger(MdiIconsViewImpl.class);
    private HTMLDivElement element;
    private HTMLInputElement copyInput = input(InputType.textarea).style("visibility:hidden; width: 0px; height: 0px;").element();

    @Override
    protected HTMLDivElement init() {
        element = div().element();

        uiHandlers.startLoading();
        GWT.runAsync(new RunAsyncCallback() {
            @Override
            public void onFailure(Throwable reason) {
                LOGGER.error("failed to run async icons view");
            }

            @Override
            public void onSuccess() {
                element.appendChild(copyInput);
                element.appendChild(LinkToSourceCode.create("mdiicons", MdiIconsViewImpl.this.getClass()).element());
                element.appendChild(BlockHeader.create("MDI Icons", "Find more about MDI icons at ")
                        .appendChild(a().attr("href", "https://materialdesignicons.com/")
                                .attr("target", "_blank")
                                .textContent("https://materialdesignicons.com/"))
                        .element());
                MdiTags.TAGS.forEach(tag -> addIconsByTag(tag));
                addIconsByTag(MdiTags.UNTAGGED);
                mdiEffects();
                uiHandlers.stopLoading();
            }
        });

        return element;
    }

    private void addIconsByTag(String tag) {
        Card card = Card.create(tag.isEmpty() ? "Untagged" : tag)
                .setCollapsible();
        element.appendChild(card.element());
        List<Supplier<MdiIcon>> suppliers = MdiByTagFactory.get(tag);
        int rows = (suppliers.size() / 4) + ((suppliers.size() % 4) > 0 ? 1 : 0);
        for (int i = 0; i < rows; i++) {
            Row_12 row = Row.create().css("demo-icon-container");
            card.appendChild(row);
            for (int j = i * 4; j < (i * 4 + 4) && j < suppliers.size(); j++) {
                row.appendChild(Column.span3().appendChild(createMdiDemoIcon(suppliers.get(j).get())));
            }
        }
    }

    private void mdiEffects() {
        element.appendChild(Card.create("Icons advanced features")
                .appendChild(BlockHeader.create("Sizes"))
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Size 18px"))
                                .appendChild(Icons.MDI_ICONS.account_mdi().size18()))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Size 24px"))
                                .appendChild(Icons.MDI_ICONS.account_mdi().size24()))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Size 36px"))
                                .appendChild(Icons.MDI_ICONS.account_mdi().size36()))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Size 48px"))
                                .appendChild(Icons.MDI_ICONS.account_mdi().size48()))
                )
                .appendChild(BlockHeader.create("Rotate"))
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("No rotate"))
                                .appendChild(Icons.MDI_ICONS.account_mdi()))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Rotate 45"))
                                .appendChild(Icons.MDI_ICONS.account_mdi().rotate45()))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Rotate 90"))
                                .appendChild(Icons.MDI_ICONS.account_mdi().rotate90()))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Rotate 135"))
                                .appendChild(Icons.MDI_ICONS.account_mdi().rotate135()))
                )
                .appendChild(Row.create()

                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Rotate 180"))
                                .appendChild(Icons.MDI_ICONS.account_mdi().rotate180()))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Rotate 255"))
                                .appendChild(Icons.MDI_ICONS.account_mdi().rotate225()))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Rotate 270"))
                                .appendChild(Icons.MDI_ICONS.account_mdi().rotate270()))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Rotate 315"))
                                .appendChild(Icons.MDI_ICONS.account_mdi().rotate315()))
                )
                .appendChild(BlockHeader.create("Flip"))
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(h(6).textContent("No flip"))
                                .appendChild(Icons.MDI_ICONS.account_alert_mdi()))
                        .appendChild(Column.span4()
                                .appendChild(h(6).textContent("Flip horizontal"))
                                .appendChild(Icons.MDI_ICONS.account_alert_mdi().flipH()))
                        .appendChild(Column.span4()
                                .appendChild(h(6).textContent("Flip vertical"))
                                .appendChild(Icons.MDI_ICONS.account_alert_mdi().flipV()))
                )
                .appendChild(BlockHeader.create("Spin"))
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(Icons.MDI_ICONS.loading_mdi().spin()))
                        .appendChild(Column.span6()
                                .appendChild(Icons.MDI_ICONS.star_mdi().spin()))
                )
                .appendChild(BlockHeader.create("Contrast"))
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Light"))
                                .appendChild(div().style("width: 40px; height:40px")
                                        .css(Color.BLACK.getBackground())
                                        .add(Icons.MDI_ICONS.account_mdi()
                                                .size36()
                                                .light())))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Light inactive"))
                                .appendChild(div().style("width: 40px; height:40px")
                                        .css(Color.BLACK.getBackground())
                                        .add(Icons.MDI_ICONS.account_mdi()
                                                .size36()
                                                .light()
                                                .inactive())))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Dark"))
                                .appendChild(Icons.MDI_ICONS.account_mdi()
                                        .dark()))
                        .appendChild(Column.span3()
                                .appendChild(h(6).textContent("Dark inactive"))
                                .appendChild(Icons.MDI_ICONS.account_mdi()
                                        .dark()
                                        .inactive()))
                )
                .setCollapsible()
                .element());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.advancedFeatures()).element());
    }

    private HtmlContentBuilder<HTMLDivElement> createMdiDemoIcon(BaseIcon icon) {
        return createDemoIcon(icon, "demo-mdi-icon-name");
    }

    private HtmlContentBuilder<HTMLDivElement> createDemoIcon(BaseIcon icon, String... moreClasses) {
        HtmlContentBuilder<HTMLElement> element = span().css("icon-name").textContent(icon.getName());

        if (moreClasses.length > 0) {
            element.css(moreClasses);
        }
        HtmlContentBuilder<HTMLDivElement> iconContainer = div().css("demo-google-material-icon")
                .add(icon)
                .add(element);
        String iconName = icon.getName();
        iconContainer.element().addEventListener("click", evt -> {
            String name = (iconName.replace("mdi-", "").replace("-", "_")) + (iconName.contains("mdi") ? "_mdi" : "");
            copyInput.value = "Icons.ALL." + name + "()";
            copyInput.select();
            EventListener copyListener = e -> {
                ClipboardEvent clipboardEvent = Js.uncheckedCast(e);
                clipboardEvent.clipboardData.setData("text/plain", copyInput.value);
                e.preventDefault();
            };
            DomGlobal.document.addEventListener("copy", copyListener);
            DominoDom.document.execCommand("copy");
            DomGlobal.document.removeEventListener("copy", copyListener);
            Notification.createInfo("Copied to clipboard").show();
        });
        return iconContainer;
    }
}