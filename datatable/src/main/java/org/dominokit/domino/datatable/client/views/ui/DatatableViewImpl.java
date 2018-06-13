package org.dominokit.domino.datatable.client.views.ui;

import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.datatable.client.presenters.DatatablePresenter;
import org.dominokit.domino.datatable.client.views.CodeResource;
import org.dominokit.domino.datatable.client.views.DatatableView;
import org.dominokit.domino.datatable.client.views.datatable.*;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.media.MediaObject;
import org.dominokit.domino.ui.progress.Progress;
import org.dominokit.domino.ui.progress.ProgressBar;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.jacksonapt.ObjectMapper;
import org.dominokit.jacksonapt.annotation.JSONMapper;

import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.*;

@UiView(presentable = DatatablePresenter.class)
public class DatatableViewImpl extends ComponentView<HTMLDivElement> implements DatatableView {

    private HTMLDivElement element = div().asElement();

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("DATA TABLES").asElement());


        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellElement(tableRow -> new Text(tableRow.getRecord().getIndex() + "")))
                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                .setCellElement(tableRow -> {

                    if(tableRow.getRecord().isActive()) {
                        return Style.of(Icons.ALL.check_circle().asElement()).setColor(Color.GREEN_DARKEN_3.getHex()).asElement();
                    }else{
                       return Style.of(Icons.ALL.highlight_off().asElement()).setColor(Color.RED_DARKEN_3.getHex()).asElement();
                    }
                }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellElement(tableRow -> new Text(tableRow.getRecord().getName())))
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellElement(this::getGenderElement).textAlign("center")
                        .maxWidth("60px"))
                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellElement(this::getEyeColorElement).textAlign("center")
                        .maxWidth("120px"))
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellElement(this::getBalanceElement
                        ))
                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellElement(tableRow -> new Text(tableRow.getRecord().getEmail())))
                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellElement(tableRow -> new Text(tableRow.getRecord().getPhone())))
                .addPlugin(new RecordDetailsPlugin<>(this::makeDetails))
                .addPlugin(new SelectionPlugin<>());

        DataTable<Contact> dataTable = new DataTable<>(tableConfig);
        dataTable
                .hovered()
                .striped();

        try {
            CodeResource.INSTANCE.generatedJson().getText(new ResourceCallback<TextResource>() {
                @Override
                public void onError(ResourceException e) {
                    DomGlobal.console.error("could not load json", e);
                }

                @Override
                public void onSuccess(TextResource resource) {
                    ContactList contactList = ContactMapper.INSTANCE.read(resource.getText());
                    dataTable.setData(contactList.getContacts().subList(0, 10));
                }
            });
        } catch (ResourceException e) {
            DomGlobal.console.error("could not load json", e);
        }


        Column column = Column.create()
                .onLarge(Column.OnLarge.three)
                .onMedium(Column.OnMedium.three)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);


        SwitchButton bordered = SwitchButton.create("Bordered").addCheckHandler(checked -> {
            if (checked) {
                dataTable.bordered();
            } else {
                dataTable.noBorder();
            }
        });

        SwitchButton hovered = SwitchButton.create("Hovered").addCheckHandler(checked -> {
            if (checked) {
                dataTable.hovered();
            } else {
                dataTable.noHover();
            }
        }).check();

        SwitchButton striped = SwitchButton.create("Striped").addCheckHandler(checked -> {
            if (checked) {
                dataTable.striped();
            } else {
                dataTable.noStripes();
            }
        }).check();

        SwitchButton condensed = SwitchButton.create("Condensed").addCheckHandler(checked -> {
            if (checked) {
                dataTable.condense();
            } else {
                dataTable.expand();
            }
        });
        element.appendChild(Card.create("SIMPLE TABLE")
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(bordered.asElement()))
                        .addColumn(column.copy().addElement(hovered.asElement()))
                        .addColumn(column.copy().addElement(striped.asElement()))
                        .addColumn(column.copy().addElement(condensed.asElement()))
                        .asElement())
                .appendContent(dataTable.asElement())
                .asElement());

    }

    private HTMLElement getBalanceElement(TableRow<Contact> row) {
        HTMLDivElement progress = Progress.create().addBar(ProgressBar.create(4000)
                .setValue(Double.parseDouble(row.getRecord().getBalance().replace(",", "").replace("$", "")))).asElement();
        Style.of(progress).setMargin("0px");
        return progress;
    }

    private HTMLElement getGenderElement(TableRow<Contact> row) {
        if (Gender.male.equals(row.getRecord().getGender())) {
            return i().css("fas fa-male fa-lg").asElement();
        } else {
            return i().css("fas fa-female fa-lg").asElement();
        }
    }

    private HTMLElement getEyeColorElement(TableRow<Contact> row) {
        HTMLElement element = i().css("fas fa-eye fa-lg").asElement();

        if (EyeColor.blue.equals(row.getRecord().getEyeColor())) {
            return Style.of(element).setColor(Color.BLUE.getHex()).asElement();
        } else if (EyeColor.green.equals(row.getRecord().getEyeColor())) {
            return Style.of(element).setColor(Color.GREEN.getHex()).asElement();
        } else if (EyeColor.brown.equals(row.getRecord().getEyeColor())) {
            return Style.of(element).setColor(Color.BROWN.getHex()).asElement();
        }

        return element;
    }

    private HTMLElement makeDetails(TableRow<Contact> row) {

        Column column = Column.create()
                .onLarge(Column.OnLarge.four)
                .onMedium(Column.OnMedium.four)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        Column column2 = Column.create()
                .onLarge(Column.OnLarge.four)
                .onMedium(Column.OnMedium.four)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        Column column3 = Column.create()
                .onLarge(Column.OnLarge.four)
                .onMedium(Column.OnMedium.four)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        SwitchButton active = SwitchButton.create()
                .setColor(Color.BLUE);
        active.setValue(row.getRecord().isActive());

        active.addCheckHandler(checked -> {
            row.getRecord().setActive(checked);
            row.getCell("status").updateCell();
        });
        Row rowElement = Row.create()
                .addColumn(column.copy()
                        .addElement(MediaObject.create()
                                .setHeader(row.getRecord().name)
                                .setLeftMedia(a().add(img(row.getRecord().getPicture().replace("gender", getGender(row)).replace("index", getIndex(row)))
                                        .attr("width", "64")
                                        .attr("height", "64"))
                                        .asElement())
                                .appendContent(new Text(row.getRecord().getAbout()))
                                .asElement()))
                .addColumn(column2.copy()
                        .addElement(Style.of(getEyeColorElement(row)).setPadding("5px").asElement())
                        .addElement(Style.of(getGenderElement(row)).setPadding("5px").asElement())
                        .addElement(Style.of(BlockHeader.create(row.getRecord().getBalance()+"", "BALANCE").invert())
                                .setMarginTop("30px")
                                .asElement())
                        .addElement(Style.of(getBalanceElement(row)).setMarginTop("5px").asElement())
                        .addElement(Style.of(BlockHeader.create("ACTIVE").appendContent(active.asElement()))
                                .setMarginTop("30px").asElement())
                )

                .addColumn(column3.copy()

                        .addElement(Style.of(BlockHeader.create(row.getRecord().getCompany()+"", "COMPANY").invert())
                                .setMarginTop("5px")
                                .asElement())
                        .addElement(Style.of(BlockHeader.create(row.getRecord().getAddress()+"", "ADDRESS").invert())
                                .setMarginTop("10px")
                                .asElement())
                        .addElement(Style.of(BlockHeader.create(row.getRecord().getAge()+"", "AGE").invert())
                                .setMargin("5px")
                                .setMarginTop("30px")
                                .asElement())
                );

        Style.of(rowElement).addClass(Styles.margin_0);
        return rowElement.asElement();
    }

    private Color getColor(TableRow<Contact> row) {
        if(EyeColor.brown.equals(row.getRecord().getEyeColor()))
            return Color.BROWN;
        if(EyeColor.blue.equals(row.getRecord().getEyeColor()))
            return Color.BLUE;
        if(EyeColor.green.equals(row.getRecord().getEyeColor()))
            return Color.GREEN;
        return Color.BROWN;
    }

    private String getIndex(TableRow<Contact> row) {
        return (row.getIndex() % 99) + "";
    }

    private String getGender(TableRow<Contact> tableRow) {
        if (Gender.male.equals(tableRow.getRecord().gender))
            return "men";
        return "women";
    }

    @JSONMapper
    public interface ContactMapper extends ObjectMapper<ContactList> {
        ContactMapper INSTANCE = new DatatableViewImpl_ContactMapperImpl();
    }

    public enum EyeColor {
        blue, brown, green;
    }

    public enum Gender {
        female, male;
    }

    public static class ContactList {
        private List<Contact> contacts;

        public ContactList() {
        }

        public List<Contact> getContacts() {
            return contacts;
        }

        public void setContacts(List<Contact> contacts) {
            this.contacts = contacts;
        }
    }

    public static class Contact {

        private int index;
        private boolean active;
        private String balance;
        private String picture;
        private short age;
        private EyeColor eyeColor;
        private String name;
        private Gender gender;
        private String company;
        private String email;
        private String phone;
        private String address;
        private String about;

        public Contact() {
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public short getAge() {
            return age;
        }

        public void setAge(short age) {
            this.age = age;
        }

        public EyeColor getEyeColor() {
            return eyeColor;
        }

        public void setEyeColor(EyeColor eyeColor) {
            this.eyeColor = eyeColor;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAbout() {
            return about;
        }

        public void setAbout(String about) {
            this.about = about;
        }

        @Override
        public String toString() {
            return "Contact{" +
                    "index=" + index +
                    ", active=" + active +
                    ", balance='" + balance + '\'' +
                    ", picture='" + picture + '\'' +
                    ", age=" + age +
                    ", eyeColor=" + eyeColor +
                    ", name='" + name + '\'' +
                    ", gender=" + gender +
                    ", company='" + company + '\'' +
                    ", email='" + email + '\'' +
                    ", phone='" + phone + '\'' +
                    ", address='" + address + '\'' +
                    ", about='" + about + '\'' +
                    '}';
        }
    }


    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}