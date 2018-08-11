package org.dominokit.domino.formsamples.shared.model;

public class PaymentScheduleItem{
	private String afterIncident;
	private int percentage;
	private int numberOfDays;
	private String type;

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

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"PaymentScheduleItem{" + 
			"afterIncident = '" + afterIncident + '\'' + 
			",percentage = '" + percentage + '\'' + 
			",numberOfDays = '" + numberOfDays + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}
