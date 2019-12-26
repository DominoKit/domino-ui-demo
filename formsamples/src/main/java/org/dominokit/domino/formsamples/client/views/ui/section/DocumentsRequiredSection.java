package org.dominokit.domino.formsamples.client.views.ui.section;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.client.views.ui.section.documents.*;
import org.dominokit.domino.formsamples.shared.model.Bank;
import org.dominokit.domino.formsamples.shared.model.Country;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;
import org.dominokit.domino.ui.header.BlockHeader;

import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.div;

public class DocumentsRequiredSection implements ImportSection {

    private final DraftsPart draftsPart;
    private final SignedCommercialInvoicePart signedCommercialInvoicePart;
    private final CertificateOfOriginPart certificateOfOriginPart;
    private final PackingListPart packingListPart;
    private final ShippingDocumentsPart shippingDocumentsPart;
    private final InsurancePolicyPart insurancePolicyPart;
    private final OtherDocumentsPart otherDocumentsPart;

    private HTMLDivElement element = div().element();

    public DocumentsRequiredSection(List<Bank> banks, List<Country> countries) {
        element.appendChild(BlockHeader.create("Documents Required").element());

        draftsPart = new DraftsPart();
        signedCommercialInvoicePart = new SignedCommercialInvoicePart(countries);
        certificateOfOriginPart = new CertificateOfOriginPart(countries);
        packingListPart = new PackingListPart();
        shippingDocumentsPart = new ShippingDocumentsPart(banks);
        insurancePolicyPart = new InsurancePolicyPart();
        otherDocumentsPart = new OtherDocumentsPart();

        element.appendChild(draftsPart.element());
        element.appendChild(signedCommercialInvoicePart.element());
        element.appendChild(certificateOfOriginPart.element());
        element.appendChild(packingListPart.element());
        element.appendChild(shippingDocumentsPart.element());
        element.appendChild(insurancePolicyPart.element());
        element.appendChild(otherDocumentsPart.element());
    }

    @Override
    public void collect(LetterOfCredit letterOfCredit) {

        shippingDocumentsPart.collect(letterOfCredit);
        draftsPart.collect(letterOfCredit);
        signedCommercialInvoicePart.collect(letterOfCredit);
        packingListPart.collect(letterOfCredit);
        insurancePolicyPart.collect(letterOfCredit);
        otherDocumentsPart.collect(letterOfCredit);
    }

    @Override
    public boolean validate() {
        return draftsPart.validate() &
                signedCommercialInvoicePart.validate() &
                certificateOfOriginPart.validate() &
                packingListPart.validate() &
                shippingDocumentsPart.validate() &
                insurancePolicyPart.validate();
    }

    @Override
    public HTMLElement element() {
        return element;
    }
}
