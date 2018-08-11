package org.dominokit.domino.formsamples.shared.model;

public class DraftsItem{
	private String afterIncident;
	private int percentage;
	private int numberOfDays;
	private String drawnOn;

	public DraftsItem() {
	}

	public DraftsItem(int numberOfDays, String drawnOn, String afterIncident, int percentage) {
		this.afterIncident = afterIncident;
		this.percentage = percentage;
		this.numberOfDays = numberOfDays;
		this.drawnOn = drawnOn;
	}

	public void setAfterIncident(String afterIncident){
		this.afterIncident = afterIncident;
	}

	public String getAfterIncident(){
		return afterIncident;
	}

	public void setPercentage(int percentage){
		this.percentage = percentage;
	}

	public int getPercentage(){
		return percentage;
	}

	public void setNumberOfDays(int numberOfDays){
		this.numberOfDays = numberOfDays;
	}

	public int getNumberOfDays(){
		return numberOfDays;
	}

	public void setDrawnOn(String drawnOn){
		this.drawnOn = drawnOn;
	}

	public String getDrawnOn(){
		return drawnOn;
	}

	public  String formatted(String afterIncidentDisplay, String draftOf){
		String result="Draft drawn on " + drawnOn + " at " +
				numberOfDays + " days from " + afterIncidentDisplay
				+ " for " + percentage + "% of " + draftOf;

		return result;
	}

	@Override
 	public String toString(){
		return 
			"DraftsItem{" + 
			"afterIncident = '" + afterIncident + '\'' + 
			",percentage = '" + percentage + '\'' + 
			",numberOfDays = '" + numberOfDays + '\'' + 
			",drawnOn = '" + drawnOn + '\'' + 
			"}";
		}
}
