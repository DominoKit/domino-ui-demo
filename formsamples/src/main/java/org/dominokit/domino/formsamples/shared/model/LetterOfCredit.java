package org.dominokit.domino.formsamples.shared.model;

import org.dominokit.jackson.annotation.JSONMapper;

import java.util.ArrayList;
import java.util.List;


@JSONMapper
public class LetterOfCredit {

    public static final LetterOfCredit_MapperImpl MAPPER = new LetterOfCredit_MapperImpl();

    private DocumentsRequired documentsRequired = new DocumentsRequired();
    private String descriptionOfGoods;
    private ShipmentDetails shipmentDetails = new ShipmentDetails();
    private SellerBeneficiary beneficiary = new SellerBeneficiary();
    private ConfirmationInstructions confirmationInstructions = new ConfirmationInstructions();
    private List<PaymentScheduleItem> paymentSchedule = new ArrayList<>();
    private ChargesInstructions chargesInstructions = new ChargesInstructions();
    private Validity validity = new Validity();
    private CreditAmount creditAmount = new CreditAmount();
    private Issuer issuer = new Issuer();
    private Applicant applicant = new Applicant();
    private String termsAndConditions;

    public void setDocumentsRequired(DocumentsRequired documentsRequired) {
        this.documentsRequired = documentsRequired;
    }

    public DocumentsRequired getDocumentsRequired() {
        return documentsRequired;
    }

    public void setDescriptionOfGoods(String descriptionOfGoods) {
        this.descriptionOfGoods = descriptionOfGoods;
    }

    public String getDescriptionOfGoods() {
        return descriptionOfGoods;
    }

    public void setShipmentDetails(ShipmentDetails shipmentDetails) {
        this.shipmentDetails = shipmentDetails;
    }

    public ShipmentDetails getShipmentDetails() {
        return shipmentDetails;
    }

    public void setBeneficiary(SellerBeneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    public SellerBeneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setConfirmationInstructions(ConfirmationInstructions confirmationInstructions) {
        this.confirmationInstructions = confirmationInstructions;
    }

    public ConfirmationInstructions getConfirmationInstructions() {
        return confirmationInstructions;
    }

    public void setPaymentSchedule(List<PaymentScheduleItem> paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public List<PaymentScheduleItem> getPaymentSchedule() {
        return paymentSchedule;
    }

    public void setChargesInstructions(ChargesInstructions chargesInstructions) {
        this.chargesInstructions = chargesInstructions;
    }

    public ChargesInstructions getChargesInstructions() {
        return chargesInstructions;
    }

    public void setValidity(Validity validity) {
        this.validity = validity;
    }

    public Validity getValidity() {
        return validity;
    }

    public void setCreditAmount(CreditAmount creditAmount) {
        this.creditAmount = creditAmount;
    }

    public CreditAmount getCreditAmount() {
        return creditAmount;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setTermsAndConditions(String termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    public String getTermsAndConditions() {
        return termsAndConditions;
    }

    @Override
    public String toString() {
        return
                "LetterOfCredit{" +
                        "documentsRequired = '" + documentsRequired + '\'' +
                        ",descriptionOfGoods = '" + descriptionOfGoods + '\'' +
                        ",shipmentDetails = '" + shipmentDetails + '\'' +
                        ",beneficiary = '" + beneficiary + '\'' +
                        ",confirmationInstructions = '" + confirmationInstructions + '\'' +
                        ",paymentSchedule = '" + paymentSchedule + '\'' +
                        ",chargesInstructions = '" + chargesInstructions + '\'' +
                        ",validity = '" + validity + '\'' +
                        ",creditAmount = '" + creditAmount + '\'' +
                        ",issuer = '" + issuer + '\'' +
                        ",applicant = '" + applicant + '\'' +
                        ",termsAndConditions = '" + termsAndConditions + '\'' +
                        "}";
    }
}