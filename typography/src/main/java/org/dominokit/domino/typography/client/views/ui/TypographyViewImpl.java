package org.dominokit.domino.typography.client.views.ui;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.typography.client.presenters.TypographyPresenter;
import org.dominokit.domino.typography.client.views.CodeResource;
import org.dominokit.domino.typography.client.views.TypographyView;
import org.dominokit.domino.ui.Typography.Blockquote;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.Text;

import static org.jboss.gwt.elemento.core.Elements.*;

@UiView(presentable = TypographyPresenter.class)
public class TypographyViewImpl extends ComponentView<HTMLDivElement> implements TypographyView {

    private static final String LARGE_PARAGRAPH = "Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget";
    private static final String SMALL_PARAGRAPH = "Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc.";
    private static final String SMALLER_PARAGRAPH = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.";

    private static final String SAMPLE_TEXT = "In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.";

    private final HTMLDivElement element = div().asElement();

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("TYPOGRAPHY").asElement());

        bodyCopy();
        heading();
        textStyles();
        blockqoute();
        lists();
    }

    private void lists() {
        Row row = Row.create();
        Column column = Column.create()
                .onLarge(Column.OnLarge.four)
                .onMedium(Column.OnMedium.four)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        element.appendChild(row
                .addColumn(column.copy()
                        .addElement(Card.create("UNORDERED LIST")
                                .appendContent(ul()
                                        .add(li().textContent("Lorem ipsum dolor sit amet"))
                                        .add(li().textContent("Consectetur adipiscing elit"))
                                        .add(li().textContent("Integer molestie lorem at massa"))
                                        .add(li().textContent("Facilisis in pretium nisl aliquet"))
                                        .add(li().textContent("Nulla volutpat aliquam velit")
                                                .add(ul()
                                                        .add(li().textContent("Phasellus iaculis neque"))
                                                        .add(li().textContent("Purus sodales ultricies"))
                                                        .add(li().textContent("Vestibulum laoreet porttitor sem"))
                                                        .add(li().textContent("Ac tristique libero volutpat at"))
                                                )
                                        )
                                        .add(li().textContent("Faucibus porta lacus fringilla vel"))
                                        .add(li().textContent("Aenean sit amet erat nunc"))
                                        .add(li().textContent("Eget porttitor lorem"))
                                        .asElement())
                                .asElement()))
                .addColumn(column.copy()
                        .addElement(Card.create("ORDERED LIST")
                                .appendContent(ol()
                                        .add(li().textContent("Lorem ipsum dolor sit amet"))
                                        .add(li().textContent("Consectetur adipiscing elit"))
                                        .add(li().textContent("Integer molestie lorem at massa"))
                                        .add(li().textContent("Facilisis in pretium nisl aliquet"))
                                        .add(li().textContent("Nulla volutpat aliquam velit")
                                                .add(ol()
                                                        .add(li().textContent("Phasellus iaculis neque"))
                                                        .add(li().textContent("Purus sodales ultricies"))
                                                        .add(li().textContent("Vestibulum laoreet porttitor sem"))
                                                        .add(li().textContent("Ac tristique libero volutpat at"))
                                                )
                                        )
                                        .add(li().textContent("Faucibus porta lacus fringilla vel"))
                                        .add(li().textContent("Aenean sit amet erat nunc"))
                                        .add(li().textContent("Eget porttitor lorem"))
                                        .asElement())
                                .asElement()))
                .addColumn(column.copy()
                        .addElement(Card.create("UNSTYLED LIST")
                                .appendContent(ul().css(Styles.LIST_UNSTYLED)
                                        .add(li().textContent("Lorem ipsum dolor sit amet"))
                                        .add(li().textContent("Consectetur adipiscing elit"))
                                        .add(li().textContent("Integer molestie lorem at massa"))
                                        .add(li().textContent("Facilisis in pretium nisl aliquet"))
                                        .add(li().textContent("Nulla volutpat aliquam velit")
                                                .add(ul()
                                                        .add(li().textContent("Phasellus iaculis neque"))
                                                        .add(li().textContent("Purus sodales ultricies"))
                                                        .add(li().textContent("Vestibulum laoreet porttitor sem"))
                                                        .add(li().textContent("Ac tristique libero volutpat at"))
                                                )
                                        )
                                        .add(li().textContent("Faucibus porta lacus fringilla vel"))
                                        .add(li().textContent("Aenean sit amet erat nunc"))
                                        .add(li().textContent("Eget porttitor lorem"))
                                        .asElement())
                                .asElement()))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.lists())
        .asElement());
    }

    private void bodyCopy() {
        element.appendChild(Card.create("BODY COPY", "Use LEAD style make a paragraph with larger fonts on big screens.")
                .appendContent(p().css(Styles.LEAD).textContent(SMALLER_PARAGRAPH).asElement())
                .appendContent(p().textContent(LARGE_PARAGRAPH).asElement())
                .appendContent(p().textContent(SMALL_PARAGRAPH).asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.bodyCopy())
                .asElement());
    }

    private void heading() {
        element.appendChild(Card.create("HEADINGS")
                .appendContent(h(1).textContent("h1. Text Heading.").asElement())
                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())
                .appendContent(h(2).textContent("h2. Text Heading.").asElement())
                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())
                .appendContent(h(3).textContent("h3. Text Heading.").asElement())
                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())
                .appendContent(h(4).textContent("h4. Text Heading.").asElement())
                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())
                .appendContent(h(5).textContent("h5. Text Heading.").asElement())
                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())
                .appendContent(h(6).textContent("h6. Text Heading.").asElement())
                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.heading())
                .asElement());
    }

    private void textStyles() {
        Row row = Row.create();
        Column column = Column.create()
                .onLarge(Column.OnLarge.two)
                .onMedium(Column.OnMedium.two)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        element.appendChild(Card.create("TEXT STYLES", "Use ready classes to style your paragraphs.")
                .appendContent(row
                        .addColumn(column.copy()
                                .addElement(Paragraph.create().appendContent(b().textContent("Normal").asElement()).asElement())
                                .addElement(Paragraph.create("Default text").asElement())
                                .addElement(Paragraph.create("Text pink color").setColor(Color.PINK).asElement())
                                .addElement(Paragraph.create("Text cyan color").setColor(Color.CYAN).asElement())
                                .addElement(Paragraph.create("Text teal color").setColor(Color.TEAL).asElement())
                                .addElement(Paragraph.create("Text orange color").setColor(Color.ORANGE).asElement())
                                .addElement(Paragraph.create("Text blue grey color").setColor(Color.BLUE_GREY).asElement())
                        )

                        .addColumn(column.copy()
                                .addElement(Paragraph.create().appendContent(b().textContent("Bold").asElement()).asElement())
                                .addElement(Paragraph.create("Default text").bold().asElement())
                                .addElement(Paragraph.create("Text pink color").bold().setColor(Color.PINK).asElement())
                                .addElement(Paragraph.create("Text cyan color").bold().setColor(Color.CYAN).asElement())
                                .addElement(Paragraph.create("Text teal color").bold().setColor(Color.TEAL).asElement())
                                .addElement(Paragraph.create("Text orange color").bold().setColor(Color.ORANGE).asElement())
                                .addElement(Paragraph.create("Text blue grey color").bold().setColor(Color.BLUE_GREY).asElement())
                        )

                        .addColumn(column.copy()
                                .addElement(Paragraph.create().appendContent(b().textContent("Italic").asElement()).asElement())
                                .addElement(Paragraph.create("Default text").italic().asElement())
                                .addElement(Paragraph.create("Text pink color").italic().setColor(Color.PINK).asElement())
                                .addElement(Paragraph.create("Text cyan color").italic().setColor(Color.CYAN).asElement())
                                .addElement(Paragraph.create("Text teal color").italic().setColor(Color.TEAL).asElement())
                                .addElement(Paragraph.create("Text orange color").italic().setColor(Color.ORANGE).asElement())
                                .addElement(Paragraph.create("Text blue grey color").italic().setColor(Color.BLUE_GREY).asElement())
                        )

                        .addColumn(column.copy()
                                .addElement(Paragraph.create().appendContent(b().textContent("Under line").asElement()).asElement())
                                .addElement(Paragraph.create("Default text").underLine().asElement())
                                .addElement(Paragraph.create("Text pink color").underLine().setColor(Color.PINK).asElement())
                                .addElement(Paragraph.create("Text cyan color").underLine().setColor(Color.CYAN).asElement())
                                .addElement(Paragraph.create("Text teal color").underLine().setColor(Color.TEAL).asElement())
                                .addElement(Paragraph.create("Text orange color").underLine().setColor(Color.ORANGE).asElement())
                                .addElement(Paragraph.create("Text blue grey color").underLine().setColor(Color.BLUE_GREY).asElement())
                        )

                        .addColumn(column.copy()
                                .addElement(Paragraph.create().appendContent(b().textContent("Line through").asElement()).asElement())
                                .addElement(Paragraph.create("Default text").lineThrough().asElement())
                                .addElement(Paragraph.create("Text pink color").lineThrough().setColor(Color.PINK).asElement())
                                .addElement(Paragraph.create("Text cyan color").lineThrough().setColor(Color.CYAN).asElement())
                                .addElement(Paragraph.create("Text teal color").lineThrough().setColor(Color.TEAL).asElement())
                                .addElement(Paragraph.create("Text orange color").lineThrough().setColor(Color.ORANGE).asElement())
                                .addElement(Paragraph.create("Text blue grey color").lineThrough().setColor(Color.BLUE_GREY).asElement())
                        )

                        .addColumn(column.copy()
                                .addElement(Paragraph.create().appendContent(b().textContent("Over line").asElement()).asElement())
                                .addElement(Paragraph.create("Default text").overLine().asElement())
                                .addElement(Paragraph.create("Text pink color").overLine().setColor(Color.PINK).asElement())
                                .addElement(Paragraph.create("Text cyan color").overLine().setColor(Color.CYAN).asElement())
                                .addElement(Paragraph.create("Text teal color").overLine().setColor(Color.TEAL).asElement())
                                .addElement(Paragraph.create("Text orange color").overLine().setColor(Color.ORANGE).asElement())
                                .addElement(Paragraph.create("Text blue grey color").overLine().setColor(Color.BLUE_GREY).asElement())
                        )
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.textStyles())
                .asElement());
    }

    private void blockqoute() {
        element.appendChild(Card.create("BLOCKQUOTES")
                .appendContent(Blockquote.create("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.")
                        .asElement())
                .appendContent(Blockquote.create("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.")
                        .appendFooterContent(new Text("Someone famous in "))
                        .appendFooterContent(cite().textContent("source title.").asElement())
                        .asElement())
                .appendContent(Blockquote.create("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.")
                        .appendFooterContent(new Text("Someone famous in "))
                        .appendFooterContent(cite().textContent("source title.").asElement())
                        .reverse()
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.blockqoute())
                .asElement());
    }
}