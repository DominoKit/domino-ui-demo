package org.dominokit.domino.advancedforms.client.views.ui;

import elemental2.core.Global;
import elemental2.core.JsArray;
import elemental2.core.JsRegExp;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.Response;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.advancedforms.client.presenters.AdvancedFormsProxy;
import org.dominokit.domino.advancedforms.client.views.AdvancedFormsView;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.LocalSuggestBoxStore;
import org.dominokit.domino.ui.forms.SuggestBox;
import org.dominokit.domino.ui.forms.SuggestBoxStore;
import org.dominokit.domino.ui.forms.SuggestItem;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.tag.TagsInput;
import org.dominokit.domino.ui.tag.store.LocalTagsStore;
import org.dominokit.domino.ui.tag.store.OrderedLocalTagsStore;
import org.dominokit.domino.ui.upload.FileUpload;
import org.jboss.elemento.Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import static org.jboss.elemento.Elements.br;

@UiView(presentable = AdvancedFormsProxy.class)
@SampleClass
public class AdvancedFormsViewImpl extends BaseDemoView<HTMLDivElement> implements AdvancedFormsView {

    private static final String IP_ADDRESS_REGEX = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    private HTMLDivElement element;
    private Card uploadCard;
    private Card tagsInputCard;
    private Card suggestBoxCard;

    @Override
    protected HTMLDivElement init() {
        element = Elements.div().element();
        element.appendChild(LinkToSourceCode.create("advanced-forms", AdvancedFormsViewImpl.class).element());
        element.appendChild(BlockHeader.create("ADVANCED FORM ELEMENTS").element());

        uploadCard = Card.create("FILE UPLOAD - DRAG & DROP OR WITH CLICK & CHOOSE");
        tagsInputCard = Card.create("TAGS INPUT");
        suggestBoxCard = Card.create("SUGGEST BOX");

        initFileUploadExample();
        initTagsInputExample();
        initSuggestBoxExample();

        element.appendChild(uploadCard.element());
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initFileUploadExample()).element());
        element.appendChild(suggestBoxCard.element());
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initSuggestBoxExample()).element());
        element.appendChild(tagsInputCard.element());
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initTagsInputExample()).element());

        return element;
    }

    @SampleMethod
    private void initFileUploadExample() {
        FileUpload fileUpload = FileUpload.create()
                .setIcon(Icons.ALL.apps_mdi())
                .setUrl("http://localhost:8080/form")
                .multipleFiles()
                .accept("image/*")
                .appendChild(Elements.h(3).textContent("Drop files here or click to upload."))
                .appendChild(Elements.em().textContent("(This is just a demo upload. Selected files are not actually uploaded)"))
                .onAddFile(fileItem -> {
                    Notification.createInfo("File added. "+fileItem.getFileName()).show();

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

        uploadCard.appendChild(fileUpload);

    }

    @SampleMethod
    private void initTagsInputExample() {
        tagsInputCard
                .appendChild(BlockHeader.create("FREE TEXT TAGS", "Free text tags accept any text value"))
                .appendChild(br())
                .appendChild(br())
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(TagsInput.create("Free tag")
                                        .setPlaceholder("Type anything...")
                                        .value(Collections.singletonList("Hey! how are you?"))))
                );

        Person schroeder_coleman = new Person(1, "Schroeder Coleman");
        OrderedLocalTagsStore<Person> personsStore = OrderedLocalTagsStore.<Person>create()
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
                                .appendChild(objectTags
                                        .setPlaceholder("Friend's name...")))
                );

        TagsInput<String> ipAddresses = TagsInput.create("IP addresses");
        tagsInputCard
                .appendChild(BlockHeader.create("TAGS DECORATIONS", "Tags input has its own decorations"))
                .appendChild(br())
                .appendChild(br())
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(ipAddresses
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
                                        .value(Collections.singletonList("127.0.0.1"))
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
                                .appendChild(TagsInput.create("Hardware")
                                        .value(Arrays.asList("Keyboard", "Screen", "USB Driver", "Mouse"))
                                        .setReadOnly(true)))
                );


        tagsInputCard
                .appendChild(BlockHeader.create("TAGS WITH COLORS", "Tags can have colors!"))
                .appendChild(br())
                .appendChild(br())
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .appendChild(TagsInput.create()
                                        .setPlaceholder("Type hardware name...")
                                        .value(Arrays.asList("Keyboard", "Screen", "USB Driver", "Mouse"))
                                        .setTagsColor(ColorScheme.RED)))
                        .addColumn(Column.span6()
                                .appendChild(TagsInput.create()
                                        .setPlaceholder("Type hardware name...")
                                        .value(Arrays.asList("Keyboard", "Screen", "USB Driver", "Mouse"))
                                        .setTagsColor(ColorScheme.TEAL)))
                ).appendChild(Row.create()
                .addColumn(Column.span6()
                        .appendChild(TagsInput.create()
                                .setPlaceholder("Type hardware name...")
                                .value(Arrays.asList("Keyboard", "Screen", "USB Driver", "Mouse"))
                                .setTagsColor(ColorScheme.CYAN)))
                .addColumn(Column.span6()
                        .appendChild(TagsInput.create()
                                .setPlaceholder("Type hardware name...")
                                .value(Arrays.asList("Keyboard", "Screen", "USB Driver", "Mouse"))
                                .setTagsColor(ColorScheme.BROWN))))
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .appendChild(TagsInput.create()
                                        .setPlaceholder("Type hardware name...")
                                        .value(Arrays.asList("Keyboard", "Screen", "USB Driver", "Mouse"))
                                        .setTagsColor(ColorScheme.AMBER)))
                        .addColumn(Column.span6()
                                .appendChild(TagsInput.create()
                                        .setPlaceholder("Type hardware name...")
                                        .value(Arrays.asList("Keyboard", "Screen", "USB Driver", "Mouse"))
                                        .setTagsColor(ColorScheme.PINK))));
    }

    @SampleMethod
    private void initSuggestBoxExample() {
        LocalSuggestBoxStore<String> localStore = LocalSuggestBoxStore.<String>create()
                .addSuggestion(SuggestItem.create("Schroeder Coleman"))
                .addSuggestion(SuggestItem.create("Renee Mcintyre"))
                .addSuggestion(SuggestItem.create("Casey Garza"));
        TextBox friendNameBox = TextBox.create("Your friend name")
                .setHelperText("Add friend name as suggestion");
        KeyboardEvents.listenOnKeyDown(friendNameBox)
                .onEnter(evt -> {
                    localStore.addSuggestion(SuggestItem.create(friendNameBox.getValue()));
                    friendNameBox.clear();
                });
        suggestBoxCard
                .setBodyPaddingTop("40px")
                .appendChild(
                        Row.create()
                                .appendChild(Column.span6().appendChild(BlockHeader.create("Local suggest store"))))
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(friendNameBox))
                        .appendChild(Column.span2()
                                .appendChild(Button.createPrimary(Icons.ALL.plus_mdi()).setContent("ADD FRIEND")
                                        .addClickListener(evt -> {
                                            localStore.addSuggestion(SuggestItem.create(friendNameBox.getValue()));
                                            friendNameBox.clear();
                                        })))
                )
                .appendChild(
                        Row.create()
                                .appendChild(Column.span12()
                                        .appendChild(SuggestBox.create("Your friends", localStore)
                                                .setHelperText("Type any letter and see suggestions")))
                );


        SuggestBoxStore<String> dynamicStore = new SuggestBoxStore<String>() {

            @Override
            public void filter(String searchValue, SuggestionsHandler<String> suggestionsHandler) {
                DomGlobal.fetch("https://restcountries.com/v2/all?fields=name")
                        .then(Response::text)
                        .then(json -> {
                            List<SuggestItem<String>> suggestItems = new ArrayList<>();
                            JsArray<JsPropertyMap<String>> randomNames = Js.cast(Global.JSON.parse(json));
                            for (int i = 0; i < randomNames.length; i++) {
                                JsPropertyMap<String> nameProperties = randomNames.getAt(i);
                                if (nameProperties.get("name").toLowerCase().contains(searchValue.toLowerCase())) {
                                    SuggestItem suggestItem = SuggestItem.create(nameProperties.get("name"));
                                    suggestItems.add(suggestItem);
                                }
                            }
                            suggestionsHandler.onSuggestionsReady(suggestItems);
                            return null;
                        });
            }

            @Override
            public void find(String searchValue, Consumer<SuggestItem<String>> handler) {
                DomGlobal.fetch("https://restcountries.com/v2/all?fields=name")
                        .then(Response::text)
                        .then(json -> {
                            JsArray<JsPropertyMap<String>> randomNames = Js.cast(Global.JSON.parse(json));
                            for (int i = 0; i < randomNames.length; i++) {
                                JsPropertyMap<String> nameProperties = randomNames.getAt(i);
                                if (nameProperties.get("name").equals(searchValue)) {
                                    SuggestItem suggestItem = SuggestItem.create(nameProperties.get("name"));
                                    handler.accept(suggestItem);
                                    return null;
                                }
                            }
                            return null;
                        });
            }
        };

        suggestBoxCard
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(BlockHeader.create("Dynamic suggest store"))))
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(SuggestBox.create("Country", dynamicStore))));
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

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}