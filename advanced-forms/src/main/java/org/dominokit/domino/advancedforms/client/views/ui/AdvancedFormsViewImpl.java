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
import org.dominokit.domino.ui.chips.Chip;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.forms.suggest.LocalSuggestionsStore;
import org.dominokit.domino.ui.forms.suggest.MultiSuggestBox;
import org.dominokit.domino.ui.forms.suggest.OrderedSuggestionsStore;
import org.dominokit.domino.ui.forms.suggest.SuggestBox;
import org.dominokit.domino.ui.forms.suggest.SuggestOption;
import org.dominokit.domino.ui.forms.suggest.SuggestionsStore;
import org.dominokit.domino.ui.forms.suggest.TagBox;
import org.dominokit.domino.ui.forms.suggest.TagOption;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.upload.DefaultFileUploadDecoration;
import org.dominokit.domino.ui.upload.FileUpload;
import org.dominokit.domino.ui.utils.PostfixAddOn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;


@UiView(presentable = AdvancedFormsProxy.class)
@SampleClass
public class AdvancedFormsViewImpl extends BaseDemoView<HTMLDivElement> implements AdvancedFormsView {

    private static final String IP_ADDRESS_REGEX = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div();
        element.appendChild(LinkToSourceCode.createLink("advanced-forms", AdvancedFormsViewImpl.class));
        element.appendChild(BlockHeader.create("ADVANCED FORM ELEMENTS"));

        initFileUploadExample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initFileUploadExample()));
        initTagsInputExample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initTagsInputExample()));
        initSuggestBoxExample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initSuggestBoxExample()));

        return element.element();
    }

    @SampleMethod
    private void initFileUploadExample() {
        element
                .appendChild(Card.create("FILE UPLOAD - DRAG & DROP OR WITH CLICK & CHOOSE")
                        .appendChild(BlockHeader.create("Manual upload"))
                        .appendChild(FileUpload.create()
                                .setDecoration(DefaultFileUploadDecoration.create()
                                        .setIcon(Icons.upload().addCss(dui_font_size_24, dui_fg_accent))
                                        .setTitle("Drop files here or click to upload.")
                                        .setDescription("(This is just a demo upload. Selected files are not actually uploaded)")
                                        .addCss(dui_m_b_4)
                                )
                                .setAutoUpload(false)
                                .onAddFile(fileItem -> {
                                    fileItem
                                            .addErrorHandler(request -> Notification.create("Failed to upload file").addCss(dui_error).show())
                                            .addRemoveHandler(file -> Notification.create("File removed").addCss(dui_warning).show())
                                            .addBeforeUploadHandler((request, formData) -> Notification.create("Starting file upload").addCss(dui_primary).show())
                                            .addCancelHandler(request -> Notification.create("Starting file upload").addCss(dui_primary).show())
                                            .withOptions((file, options) -> {
                                                options
                                                        .setUrl("http://localhost:8080/service/upload");
                                            })
                                    ;
                                })
                                .addCss(dui_min_h_32, dui_w_full, dui_m_b_4)
                        )
                        .appendChild(BlockHeader.create("Auto upload"))
                        .appendChild(FileUpload.create()
                                .setDecoration(DefaultFileUploadDecoration.create()
                                        .setIcon(Icons.upload().addCss(dui_font_size_24, dui_fg_accent))
                                        .setTitle("Drop files here or click to upload.")
                                        .setDescription("(This is just a demo upload. Selected files are not actually uploaded)")
                                        .addCss(dui_m_b_4)
                                )
                                .setAutoUpload(true)
                                .onAddFile(fileItem -> {
                                    fileItem
                                            .addErrorHandler(request -> Notification.create("Failed to upload file").addCss(dui_error).show())
                                            .addRemoveHandler(file -> Notification.create("File removed").addCss(dui_warning).show())
                                            .addBeforeUploadHandler((request, formData) -> Notification.create("Starting file upload").addCss(dui_primary).show())
                                            .addCancelHandler(request -> Notification.create("Starting file upload").addCss(dui_primary).show())
                                            .withOptions((file, options) -> {
                                                options
                                                        .setUrl("http://localhost:8080/service/upload");
                                            })
                                    ;
                                })
                                .addCss(dui_min_h_32, dui_w_full))
                );

    }

    @SampleMethod
    private void initTagsInputExample() {
        Card card = Card.create("TAGS INPUT");
        element
                .appendChild(card
                        .appendChild(BlockHeader.create("FREE TEXT TAGS", "Free text tags accept any text value"))
                        .appendChild(Row.create()
                                .span6(TagBox.create("Tag input", token -> token)
                                        .setPlaceholder("Type anything...")
                                        .setRemovable(true)
                                        .withValue(Arrays.asList("Tag A", "Tag B"))
                                        .addChangeListener((oldValue, newValue) -> {
                                            Notification.create("OLD[" + oldValue + "], NEW[" + newValue + "]").show();
                                        })
                                )
                                .span6(TagBox.create("Tag input", token -> {
                                                    try {
                                                        return Integer.parseInt(token);
                                                    } catch (Exception e) {
                                                        return null;
                                                    }
                                                })
                                                .setPlaceholder("Type numbers...")
                                                .setRemovable(true)
                                                .withValue(Arrays.asList(1, 20))
                                                .addChangeListener((oldValue, newValue) -> {
                                                    Notification.create("OLD[" + oldValue + "], NEW[" + newValue + "]").show();
                                                })
                                )
                        )
                );

        Person schroederColeman = new Person("Schroeder Coleman");
        OrderedSuggestionsStore<Person, Chip, TagOption<Person>> personsStore = OrderedSuggestionsStore.<Person, Chip, TagOption<Person>>create(person ->
                        Optional.of(TagOption.create(person.name, person, person.name))
                )
                .setMissingEntryProvider(inputValue -> Optional.of(TagOption.create(inputValue, new Person(inputValue), inputValue)))
                .setMissingValueProvider(person -> Optional.of(TagOption.create(person.name, person, person.name)))
                .addItem(schroederColeman)
                .addItem(new Person("Renee Mcintyre"))
                .addItem(new Person("Casey Garza"))
                .addItem(new Person("Ahmad Bawaneh"))
                .addItem(new Person("Ahmad Ali"))
                .addItem(new Person("Ali Naser"))
                .addItem(new Person("Sam Sam"))
                .addItem(new Person("Sir Sam"))
                .setSuggestionFilter((searchValue, suggestItem) -> suggestItem.getValue().getName().toLowerCase().contains(searchValue.toLowerCase()));

        card
                .appendChild(BlockHeader.create("SELECT TAGS", "Select tags have store of objects to be selected"))
                .appendChild(Row.create()
                        .span6(TagBox.create("Friends", personsStore)
                                .withValue(Collections.singletonList(schroederColeman))
                                .setPlaceholder("Friend's name...")
                                .addChangeListener((oldValue, newValue) -> {
                                    Notification.create("OLD[" + oldValue + "], NEW[" + newValue + "]").show();
                                })
                        )
                        .span6(TagBox.create("IP addresses", token -> token)
                                .setHelperText("Pattern: 000.000.000.000")
                                .setRemovable(true)
                                .addValidator((tagBox) -> {
                                    List<TagOption<String>> selectedOptions = tagBox.getSelectedOptions();
                                    for (TagOption<String> v : selectedOptions) {
                                        if (!new JsRegExp(IP_ADDRESS_REGEX).test(v.getValue())) {
                                            v.getComponent().addCss(dui_border, dui_border_red, dui_border_solid);
                                            return ValidationResult.invalid("Invalid IP address [ " + v + " ]");
                                        }
                                    }
                                    return ValidationResult.valid();
                                })
                                .withValue(Collections.singletonList("127.0.0.1"))
                                .setPlaceholder("Type invalid address...")
                                .setAutoValidation(true)
                                .addChangeListener((oldValue, newValue) -> {
                                    Notification.create("OLD[" + oldValue + "], NEW[" + newValue + "]").show();
                                })
                        )
                )
                .appendChild(BlockHeader.create("READONLY & DISABLED"))
                .appendChild(Row.create()
                        .span6(TagBox.create("Tag input: Readonly", token -> token)
                                .setPlaceholder("Type anything...")
                                .setRemovable(true)
                                .withValue(Arrays.asList("Tag A", "Tag B"))
                                .addChangeListener((oldValue, newValue) -> {
                                    Notification.create("OLD[" + oldValue + "], NEW[" + newValue + "]").show();
                                })
                                .setReadOnly(true)
                        )
                        .span6(TagBox.create("Tag input: Disabled", token -> token)
                                .setPlaceholder("Type anything...")
                                .setRemovable(true)
                                .withValue(Arrays.asList("Tag A", "Tag B"))
                                .addChangeListener((oldValue, newValue) -> {
                                    Notification.create("OLD[" + oldValue + "], NEW[" + newValue + "]").show();
                                })
                                .setDisabled(true)
                        )
                )
                .appendChild(BlockHeader.create("DIFFERENT COLORS"))
                .appendChild(Row.create()
                        .span6(TagBox.create("Tag input", token -> token)
                                .addCss(dui_accent_pink)
                                .setPlaceholder("Type anything...")
                                .setRemovable(true)
                                .withValue(Arrays.asList("Tag A", "Tag B"))
                                .addChangeListener((oldValue, newValue) -> {
                                    Notification.create("OLD[" + oldValue + "], NEW[" + newValue + "]").show();
                                })
                        )
                        .span6(TagBox.create("Tag input", token -> token)
                                .addCss(dui_accent_blue)
                                .setPlaceholder("Type anything...")
                                .setRemovable(true)
                                .withValue(Arrays.asList("Tag A", "Tag B"))
                                .addChangeListener((oldValue, newValue) -> {
                                    Notification.create("OLD[" + oldValue + "], NEW[" + newValue + "]").show();
                                })
                        )
                );
    }

    @SampleMethod
    private void initSuggestBoxExample() {
        LocalSuggestionsStore<String, SpanElement, SuggestOption<String>> localStore = LocalSuggestionsStore.<String, SpanElement, SuggestOption<String>>create()
                .addSuggestion(SuggestOption.create("Ahmad bawaneh"))
                .addSuggestion(SuggestOption.create("Ahmad Ali"))
                .addSuggestion(SuggestOption.create("Ali omar"))
                .addSuggestion(SuggestOption.create("Ali hasan"))
                .addSuggestion(SuggestOption.create("Schroeder Coleman"))
                .addSuggestion(SuggestOption.create("Renee Mcintyre"))
                .addSuggestion(SuggestOption.create("Casey Garza"))
                .setMissingEntryProvider(inputValue -> Optional.of(SuggestOption.create(inputValue)))
                .setMissingValueProvider(missingValue -> Optional.of(SuggestOption.create(missingValue)));

        TextBox friendNameBox = TextBox.create("Your friend name")
                .setHelperText("Add friend name as suggestion")
                .withInputElement((parent, input) -> {
                    input.onKeyDown(keyEvents -> {
                        keyEvents.onEnter(evt -> {
                            localStore.addSuggestion(SuggestOption.create(parent.getValue()));
                            parent.clear();
                        });
                    });
                })
                .apply(textBox -> {
                    textBox.appendChild(PostfixAddOn.of(Button.create("ADD FRIEND")
                            .addCss(dui_primary, dui_h_8, dui_leading_5)
                            .addClickListener(evt -> {
                                localStore.addSuggestion(SuggestOption.create(textBox.getValue()));
                                textBox.clear();
                            }))
                    );
                });

        Card card = Card.create("SUGGEST BOX");
        element
                .appendChild(card
                        .appendChild(BlockHeader.create("Local suggestions"))
                        .appendChild(Row.create()
                                .span6(friendNameBox)
                                .span6(SuggestBox.create(localStore)
                                        .setLabel("Suggested friend")
                                        .setHelperText("Type to see suggestions")
                                        .addChangeListener((oldValue, newValue) -> {
                                            Notification.create("OLD[" + oldValue + "], NEW[" + newValue + "]").show();
                                        })
                                )
                        )
                );

        SuggestionsStore<String, SpanElement, SuggestOption<String>> dynamicStore = new SuggestionsStore<String, SpanElement, SuggestOption<String>>() {

            @Override
            public void filter(String searchValue, SuggestionsHandler<String, SpanElement, SuggestOption<String>> suggestionsHandler) {
                DomGlobal.fetch("https://restcountries.com/v2/all?fields=name")
                        .then(Response::text)
                        .then(json -> {
                            List<SuggestOption<String>> suggestItems = new ArrayList<>();
                            JsArray<JsPropertyMap<String>> randomNames = Js.cast(Global.JSON.parse(json));
                            for (int i = 0; i < randomNames.length; i++) {
                                JsPropertyMap<String> nameProperties = randomNames.getAt(i);
                                if (nameProperties.get("name").toLowerCase().contains(searchValue.toLowerCase())) {
                                    SuggestOption<String> suggestItem = SuggestOption.create(nameProperties.get("name"));
                                    suggestItems.add(suggestItem);
                                }
                            }
                            suggestionsHandler.onSuggestionsReady(suggestItems);
                            return null;
                        });
            }

            @Override
            public void find(String searchValue, Consumer<SuggestOption<String>> handler) {
                DomGlobal.fetch("https://restcountries.com/v2/all?fields=name")
                        .then(Response::text)
                        .then(json -> {
                            JsArray<JsPropertyMap<String>> randomNames = Js.cast(Global.JSON.parse(json));
                            for (int i = 0; i < randomNames.length; i++) {
                                JsPropertyMap<String> nameProperties = randomNames.getAt(i);
                                if (nameProperties.get("name").equals(searchValue)) {
                                    SuggestOption<String> suggestItem = SuggestOption.create(nameProperties.get("name"));
                                    handler.accept(suggestItem);
                                    return null;
                                }
                            }
                            return null;
                        });
            }
        };

        card
                .appendChild(BlockHeader.create("Dynamic suggestions"))
                .appendChild(Row.create()
                        .span6(SuggestBox.create(dynamicStore)
                                .setLabel("Suggested country")
                                .setHelperText("Type to see suggestions")
                                .addChangeListener((oldValue, newValue) -> {
                                    Notification.create("OLD[" + oldValue + "], NEW[" + newValue + "]").show();
                                })
                        )
                        .span6(MultiSuggestBox.create(dynamicStore)
                                .setLabel("Suggested countries")
                                .setHelperText("Type to see suggestions")
                                .addChangeListener((oldValue, newValue) -> {
                                    Notification.create("OLD[" + oldValue + "], NEW[" + newValue + "]").show();
                                })
                        )
                );
    }

    public static class Person {

        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Person(String name) {
            this.id = 0;
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