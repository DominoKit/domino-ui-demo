package org.dominokit.domino.formsamples.shared.model;

import java.util.List;

public class DocumentsRequired{
	private Insurance insurance;
	private boolean draftRequired;
	private AirwayBill airwayBill;
	private SignedCommercialInvoice signedCommercialInvoice;
	private OceanBillsOfLanding oceanBillsOfLanding;
	private List<DraftsItem> drafts;
	private List<OtherDocumentsItem> otherDocuments;
	private CertificateOfOrigin certificateOfOrigin;
	private PackingList packingList;
	private TruckConsignmentNote truckConsignmentNote;

	public void setInsurance(Insurance insurance){
		this.insurance = insurance;
	}

	public Insurance getInsurance(){
		return insurance;
	}

	public void setDraftRequired(boolean draftRequired){
		this.draftRequired = draftRequired;
	}

	public boolean isDraftRequired(){
		return draftRequired;
	}

	public void setAirwayBill(AirwayBill airwayBill){
		this.airwayBill = airwayBill;
	}

	public AirwayBill getAirwayBill(){
		return airwayBill;
	}

	public void setSignedCommercialInvoice(SignedCommercialInvoice signedCommercialInvoice){
		this.signedCommercialInvoice = signedCommercialInvoice;
	}

	public SignedCommercialInvoice getSignedCommercialInvoice(){
		return signedCommercialInvoice;
	}

	public void setOceanBillsOfLanding(OceanBillsOfLanding oceanBillsOfLanding){
		this.oceanBillsOfLanding = oceanBillsOfLanding;
	}

	public OceanBillsOfLanding getOceanBillsOfLanding(){
		return oceanBillsOfLanding;
	}

	public void setDrafts(List<DraftsItem> drafts){
		this.drafts = drafts;
	}

	public List<DraftsItem> getDrafts(){
		return drafts;
	}

	public void setOtherDocuments(List<OtherDocumentsItem> otherDocuments){
		this.otherDocuments = otherDocuments;
	}

	public List<OtherDocumentsItem> getOtherDocuments(){
		return otherDocuments;
	}

	public void setCertificateOfOrigin(CertificateOfOrigin certificateOfOrigin){
		this.certificateOfOrigin = certificateOfOrigin;
	}

	public CertificateOfOrigin getCertificateOfOrigin(){
		return certificateOfOrigin;
	}

	public void setPackingList(PackingList packingList){
		this.packingList = packingList;
	}

	public PackingList getPackingList(){
		return packingList;
	}

	public void setTruckConsignmentNote(TruckConsignmentNote truckConsignmentNote){
		this.truckConsignmentNote = truckConsignmentNote;
	}

	public TruckConsignmentNote getTruckConsignmentNote(){
		return truckConsignmentNote;
	}

	@Override
 	public String toString(){
		return 
			"DocumentsRequired{" + 
			"insurance = '" + insurance + '\'' + 
			",draftRequired = '" + draftRequired + '\'' + 
			",airwayBill = '" + airwayBill + '\'' + 
			",signedCommercialInvoice = '" + signedCommercialInvoice + '\'' + 
			",oceanBillsOfLanding = '" + oceanBillsOfLanding + '\'' + 
			",drafts = '" + drafts + '\'' + 
			",otherDocuments = '" + otherDocuments + '\'' + 
			",certificateOfOrigin = '" + certificateOfOrigin + '\'' + 
			",packingList = '" + packingList + '\'' + 
			",truckConsignmentNote = '" + truckConsignmentNote + '\'' + 
			"}";
		}
}