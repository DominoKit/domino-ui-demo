package org.dominokit.domino.advancedforms.client.views.ui;

import elemental2.core.JsRegExp;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.advancedforms.client.presenters.AdvancedFormsPresenter;
import org.dominokit.domino.advancedforms.client.views.AdvancedFormsView;
import org.dominokit.domino.advancedforms.client.views.CodeResource;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.tag.TagsInput;
import org.dominokit.domino.ui.tag.store.LocalTagsStore;
import org.dominokit.domino.ui.upload.FileUpload;
import org.dominokit.domino.ui.utils.ValidationResult;
import org.jboss.gwt.elemento.core.Elements;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.br;

@UiView(presentable = AdvancedFormsPresenter.class)
public class AdvancedFormsViewImpl extends ComponentView<HTMLDivElement> implements AdvancedFormsView {

    public static final String IP_ADDRESS_REGEX = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    private HTMLDivElement element = Elements.div().asElement();
    private Card uploadCard;
    private Card tagsInputCard;

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("ADVANCED FORM ELEMENTS").asElement());

        uploadCard = Card.create("FILE UPLOAD - DRAG & DROP OR WITH CLICK & CHOOSE");
        tagsInputCard = Card.create("TAGS INPUT");

        initFileUploadExample();
        initTagsInputExample();

        element.appendChild(uploadCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.uploadExample()).asElement());
        element.appendChild(tagsInputCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.tagsExample()).asElement());
    }

    private void initFileUploadExample() {
        FileUpload fileUpload = FileUpload.create()
                .setIcon(Icons.ALL.touch_app())
                .setUrl("http://localhost:8080/form")
                .multipleFiles()
                .accept("image/*")
                .appendChild(Elements.h(3).textContent("Drop files here or click to upload.").asElement())
                .appendChild(Elements.em().textContent("(This is just a demo upload. Selected files are not actually uploaded)").asElement())
                .onAddFile(fileItem -> {
                    fileItem.addErrorHandler(request -> {
                        Notification.createDanger("Error while uploading " + request.responseText).show();
                    });
                    fileItem.addSuccessUploadHandler(request -> {
                        Notification.createSuccess("File uploaded successfully").show();
                    });
                    fileItem.addRemoveHandler(file -> {
                        Notification.createInfo("File has been removed " + file.name).show();
                    });
                });

        uploadCard.appendContent(fileUpload.asElement());
    }

    private void initTagsInputExample() {
        tagsInputCard
                .appendChild(BlockHeader.create("FREE TEXT TAGS", "Free text tags accept any text value"))
                .appendChild(br())
                .appendChild(br())
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .addElement(TagsInput.create("Free tag")
                                        .setPlaceholder("Type anything...")
                                        .setValue(Collections.singletonList("Hey! how are you?"))))
                );

        Person schroeder_coleman = new Person(1, "Schroeder Coleman");
        LocalTagsStore<Person> personsStore = LocalTagsStore.<Person>create()
                .addItem("Schroeder Coleman", schroeder_coleman)
                .addItem("Renee Mcintyre", new Person(2, "Renee Mcintyre"))
                .addItem("Casey Garza", new Person(3, "Casey Garza"));

        TagsInput<Person> objectTags = TagsInput.create("Friends", personsStore);
        objectTags.setValue(Collections.singletonList(schroeder_coleman));
        tagsInputCard
                .appendChild(BlockHeader.create("SELECT TAGS", "Select tags have store of objects to be selected"))
                .appendChild(br())
                .appendChild(br())
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .addElement(objectTags
                                        .setPlaceholder("Friend's name...")))
                );

        TagsInput<String> ipAddresses = TagsInput.create("IP addresses");
        tagsInputCard
                .appendChild(BlockHeader.create("TAGS DECORATIONS", "Tags input has its own decorations"))
                .appendChild(br())
                .appendChild(br())
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .addElement(ipAddresses
                                        .setHelperText("Pattern: 000.000.000.000")
                                        .addValidator(() -> {
                                            List<String> ipAddressesValue = ipAddresses.getValue();
                                            for (String v : ipAddressesValue) {
                                                if (!new JsRegExp(IP_ADDRESS_REGEX).test(v)) {
                                                    return ValidationResult.invalid("Invalid IP address [ " + v + " ]");
                                                }
                                            }
                                            return ValidationResult.valid();
                                        })
                                        .setValue(Collections.singletonList("127.0.0.1"))
                                        .setPlaceholder("Type invalid address...")
                                        .setAutoValidation(true)
                                )
                        )
                )
                .appendChild(BlockHeader.create("READONLY"))
                .appendChild(br())
                .appendChild(br())
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .addElement(TagsInput.create("Hardware")
                                        .setValue(Arrays.asList("Keyboard", "Screen", "USB Driver", "Mouse"))
                                        .setReadOnly(true)))
                );


        tagsInputCard
                .appendChild(BlockHeader.create("TAGS WITH COLORS", "Tags can have colors!"))
                .appendChild(br())
                .appendChild(br())
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .addElement(TagsInput.create()
                                        .setPlaceholder("Type hardware name...")
                                        .setValue(Arrays.asList("Keyboard", "Screen", "USB Driver", "Mouse"))
                                        .setTagsColor(ColorScheme.RED)))
                        .addColumn(Column.span6()
                                .addElement(TagsInput.create()
                                        .setPlaceholder("Type hardware name...")
                                        .setValue(Arrays.asList("Keyboard", "Screen", "USB Driver", "Mouse"))
                                        .setTagsColor(ColorScheme.TEAL)))
                ).appendChild(Row.create()
                .addColumn(Column.span6()
                        .addElement(TagsInput.create()
                                .setPlaceholder("Type hardware name...")
                                .setValue(Arrays.asList("Keyboard", "Screen", "USB Driver", "Mouse"))
                                .setTagsColor(ColorScheme.CYAN)))
                .addColumn(Column.span6()
                        .addElement(TagsInput.create()
                                .setPlaceholder("Type hardware name...")
                                .setValue(Arrays.asList("Keyboard", "Screen", "USB Driver", "Mouse"))
                                .setTagsColor(ColorScheme.BROWN))))
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .addElement(TagsInput.create()
                                        .setPlaceholder("Type hardware name...")
                                        .setValue(Arrays.asList("Keyboard", "Screen", "USB Driver", "Mouse"))
                                        .setTagsColor(ColorScheme.AMBER)))
                        .addColumn(Column.span6()
                                .addElement(TagsInput.create()
                                        .setPlaceholder("Type hardware name...")
                                        .setValue(Arrays.asList("Keyboard", "Screen", "USB Driver", "Mouse"))
                                        .setTagsColor(ColorScheme.PINK))));
    }

    public static class Person {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}