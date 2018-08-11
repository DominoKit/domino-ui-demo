package org.dominokit.domino.formsamples.shared.model;

public class ShipmentDetails{
	private String shipmentFrom;
	private String termsOfDelivery;
	private String shipmentBy;
	private String placeOfDestination;
	private String shipmentTo;
	private String latestDateOfShipment;
	private boolean partialShipmentsPermitted;
	private boolean transshipmentPermitted;

	public void setShipmentFrom(String shipmentFrom){
		this.shipmentFrom = shipmentFrom;
	}

	public String getShipmentFrom(){
		return shipmentFrom;
	}

	public void setTermsOfDelivery(String termsOfDelivery){
		this.termsOfDelivery = termsOfDelivery;
	}

	public String getTermsOfDelivery(){
		return termsOfDelivery;
	}

	public void setShipmentBy(String shipmentBy){
		this.shipmentBy = shipmentBy;
	}

	public String getShipmentBy(){
		return shipmentBy;
	}

	public void setPlaceOfDestination(String placeOfDestination){
		this.placeOfDestination = placeOfDestination;
	}

	public String getPlaceOfDestination(){
		return placeOfDestination;
	}

	public void setShipmentTo(String shipmentTo){
		this.shipmentTo = shipmentTo;
	}

	public String getShipmentTo(){
		return shipmentTo;
	}

	public void setLatestDateOfShipment(String latestDateOfShipment){
		this.latestDateOfShipment = latestDateOfShipment;
	}

	public String getLatestDateOfShipment(){
		return latestDateOfShipment;
	}

	public void setPartialShipmentsPermitted(boolean partialShipmentsPermitted){
		this.partialShipmentsPermitted = partialShipmentsPermitted;
	}

	public boolean isPartialShipmentsPermitted(){
		return partialShipmentsPermitted;
	}

	public void setTransshipmentPermitted(boolean transshipmentPermitted){
		this.transshipmentPermitted = transshipmentPermitted;
	}

	public boolean isTransshipmentPermitted(){
		return transshipmentPermitted;
	}

	@Override
 	public String toString(){
		return 
			"ShipmentDetails{" + 
			"shipmentFrom = '" + shipmentFrom + '\'' + 
			",termsOfDelivery = '" + termsOfDelivery + '\'' + 
			",shipmentBy = '" + shipmentBy + '\'' + 
			",placeOfDestination = '" + placeOfDestination + '\'' + 
			",shipmentTo = '" + shipmentTo + '\'' + 
			",latestDateOfShipment = '" + latestDateOfShipment + '\'' + 
			",partialShipmentsPermitted = '" + partialShipmentsPermitted + '\'' + 
			",transshipmentPermitted = '" + transshipmentPermitted + '\'' + 
			"}";
		}
}
