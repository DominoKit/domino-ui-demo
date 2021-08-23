package org.dominokit.domino.formsamples.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.formsamples.client.views.FormSamplesView;
import org.dominokit.domino.formsamples.client.views.ui.section.ApplicantSection;
import org.dominokit.domino.formsamples.client.views.ui.section.AuthorizationSection;
import org.dominokit.domino.formsamples.client.views.ui.section.BeneficiarySection;
import org.dominokit.domino.formsamples.client.views.ui.section.ConfirmationInstructionsSection;
import org.dominokit.domino.formsamples.client.views.ui.section.CorrespondentChargesInstructionsSection;
import org.dominokit.domino.formsamples.client.views.ui.section.CreditAmountAndToleranceSection;
import org.dominokit.domino.formsamples.client.views.ui.section.DocumentsRequiredSection;
import org.dominokit.domino.formsamples.client.views.ui.section.GeneralSection;
import org.dominokit.domino.formsamples.client.views.ui.section.GoodsDescriptionSection;
import org.dominokit.domino.formsamples.client.views.ui.section.IssuerBankSection;
import org.dominokit.domino.formsamples.client.views.ui.section.PaymentScheduleSection;
import org.dominokit.domino.formsamples.client.views.ui.section.ShipmentDetailsSection;
import org.dominokit.domino.formsamples.client.views.ui.section.ValiditySection;
import org.dominokit.domino.formsamples.shared.model.Bank;
import org.dominokit.domino.formsamples.shared.model.Beneficiary;
import org.dominokit.domino.formsamples.shared.model.CorporateProfile;
import org.dominokit.domino.formsamples.shared.model.Country;
import org.dominokit.domino.formsamples.shared.model.CurrencyData;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.jboss.elemento.IsElement;

import java.util.List;

import static org.jboss.elemento.Elements.div;

public class AddLCImportComponent implements IsElement<HTMLDivElement> {

    private HTMLDivElement element = div().css("content-margin").element();

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

        element.appendChild(generalSection.element());
        element.appendChild(issuerBankSection.element());
        element.appendChild(authorizationSection.element());
        element.appendChild(applicantSection.element());
        element.appendChild(beneficiarySection.element());
        element.appendChild(creditAmountAndToleranceSection.element());
        element.appendChild(paymentScheduleSection.element());
        element.appendChild(validitySection.element());
        element.appendChild(shipmentDetailsSection.element());
        element.appendChild(documentsRequiredSection.element());
        element.appendChild(goodsDescriptionSection.element());
        element.appendChild(BlockHeader.create("Instructions").element());
        element.appendChild(confirmationInstructionsSection.element());
        element.appendChild(correspondentChargesInstructionsSection.element());

        element.appendChild(Row.create()
                .style()
                .setMarginBottom("50px")
                .get()
                .addColumn(Column.span6()
                        .appendChild(Button.createPrimary("Submit")
                                .addClickListener(evt -> {
                                    if (isFormValid()) {
                                        uiHandlers.onCreate(createLetterOfCredit());
                                    }
                                })
                                .style()
                                .setMinWidth("120px").get()))
                .element());
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
    public HTMLDivElement element() {
        return element;
    }
}
