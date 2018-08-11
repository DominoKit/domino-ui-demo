package org.dominokit.domino.formsamples.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.formsamples.client.views.FormSamplesView;
import org.dominokit.domino.formsamples.client.views.ui.section.*;
import org.dominokit.domino.formsamples.shared.model.*;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.dialogs.MessageDialog;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.div;

public class AddLCImportComponent implements IsElement<HTMLDivElement> {

    private HTMLDivElement element = div().css("content-margin").asElement();

    private CorporateProfile corporateProfile;
    private List<Country> countries;
    private List<Beneficiary> beneficiaries;
    private List<Bank> banks;
    private List<CurrencyData> currencies;

    private GeneralSection generalSection;
    private IssuerBankSection issuerBankSection;
    private AuthorizationSection authorizationSection;
    private ApplicantSection applicantSection;
    private BeneficiarySection beneficiarySection;
    private CreditAmountAndToleranceSection creditAmountAndToleranceSection;
    private PaymentScheduleSection paymentScheduleSection;
    private ValiditySection validitySection;
    private ShipmentDetailsSection shipmentDetailsSection;
    private DocumentsRequiredSection documentsRequiredSection;
    private GoodsDescriptionSection goodsDescriptionSection;
    private ConfirmationInstructionsSection confirmationInstructionsSection;
    private CorrespondentChargesInstructionsSection correspondentChargesInstructionsSection;
    private FormSamplesView.FormSamplesUIHandlers uiHandlers;

    public AddLCImportComponent(CorporateProfile corporateProfile, List<Country> countries, List<Beneficiary> beneficiaries, List<Bank> banks, List<CurrencyData> currencies) {
        this.corporateProfile = corporateProfile;
        this.countries = countries;
        this.beneficiaries = beneficiaries;
        this.banks = banks;
        this.currencies = currencies;
        generalSection = new GeneralSection(this.corporateProfile);
        issuerBankSection = new IssuerBankSection(this.corporateProfile);
        authorizationSection = new AuthorizationSection();
        applicantSection = new ApplicantSection(this.corporateProfile);
        beneficiarySection = new BeneficiarySection(this.beneficiaries);
        creditAmountAndToleranceSection = new CreditAmountAndToleranceSection(this.currencies);
        paymentScheduleSection = new PaymentScheduleSection();
        validitySection = new ValiditySection(this.countries);
        shipmentDetailsSection = new ShipmentDetailsSection();
        documentsRequiredSection = new DocumentsRequiredSection(this.banks, this.countries);
        goodsDescriptionSection = new GoodsDescriptionSection();
        confirmationInstructionsSection = new ConfirmationInstructionsSection(this.corporateProfile);
        correspondentChargesInstructionsSection = new CorrespondentChargesInstructionsSection(this.corporateProfile);

        element.appendChild(generalSection.asElement());
        element.appendChild(issuerBankSection.asElement());
        element.appendChild(authorizationSection.asElement());
        element.appendChild(applicantSection.asElement());
        element.appendChild(beneficiarySection.asElement());
        element.appendChild(creditAmountAndToleranceSection.asElement());
        element.appendChild(paymentScheduleSection.asElement());
        element.appendChild(validitySection.asElement());
        element.appendChild(shipmentDetailsSection.asElement());
        element.appendChild(documentsRequiredSection.asElement());
        element.appendChild(goodsDescriptionSection.asElement());
        element.appendChild(BlockHeader.create("Instructions").asElement());
        element.appendChild(confirmationInstructionsSection.asElement());
        element.appendChild(correspondentChargesInstructionsSection.asElement());

        element.appendChild(Style.of(Row.create())
                .setMarginBottom("50px")
                .get()
                .addColumn(Column.span6()
                        .addElement(Style.of(Button.createPrimary("Submit")
                                .addClickListener(evt -> {
                                    if (isFormValid()) {
                                        uiHandlers.onCreate(createLetterOfCredit());
                                    } else {
//                                        MessageDialog.createMessage("Some input are not valid")
//                                                .warning()
////                                                .onClose(ElementUtil::scrollTop)
//                                                .open();
                                    }
                                }))
                                .setMinWidth("120px")))
                .asElement());
    }

    public boolean isFormValid() {
        return correspondentChargesInstructionsSection.validate() &
                confirmationInstructionsSection.validate() &
                goodsDescriptionSection.validate() &
                documentsRequiredSection.validate() &
                shipmentDetailsSection.validate() &
                validitySection.validate() &
                paymentScheduleSection.validate() &
                creditAmountAndToleranceSection.validate() &
                beneficiarySection.validate() &
                applicantSection.validate() &
                authorizationSection.validate() &
                issuerBankSection.validate() &
                generalSection.validate();
    }

    public void setUiHandlers(FormSamplesView.FormSamplesUIHandlers uiHandlers) {
        this.uiHandlers = uiHandlers;
    }

    private LetterOfCredit createLetterOfCredit() {
        LetterOfCredit letterOfCredit = new LetterOfCredit();
        generalSection.collect(letterOfCredit);
        issuerBankSection.collect(letterOfCredit);
        authorizationSection.collect(letterOfCredit);
        applicantSection.collect(letterOfCredit);
        beneficiarySection.collect(letterOfCredit);
        creditAmountAndToleranceSection.collect(letterOfCredit);
        paymentScheduleSection.collect(letterOfCredit);
        validitySection.collect(letterOfCredit);
        shipmentDetailsSection.collect(letterOfCredit);
        documentsRequiredSection.collect(letterOfCredit);
        goodsDescriptionSection.collect(letterOfCredit);
        confirmationInstructionsSection.collect(letterOfCredit);
        correspondentChargesInstructionsSection.collect(letterOfCredit);
        return letterOfCredit;
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }
}
