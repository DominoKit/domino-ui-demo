package org.dominokit.domino.formsamples.shared.model;

public class LcAmount{
	private String currency;
	private double value;

	public void setCurrency(String currency){
		this.currency = currency;
	}

	public String getCurrency(){
		return currency;
	}

	public void setValue(double value){
		this.value = value;
	}

	public double getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"LcAmount{" + 
			"currency = '" + currency + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}
