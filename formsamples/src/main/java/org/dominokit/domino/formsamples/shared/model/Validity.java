package org.dominokit.domino.formsamples.shared.model;

public class Validity{
	private String expiryDateOfCredit;
	private String country;
	private String city;
	private int daysForPresentingDocuments;

	public void setExpiryDateOfCredit(String expiryDateOfCredit){
		this.expiryDateOfCredit = expiryDateOfCredit;
	}

	public String getExpiryDateOfCredit(){
		return expiryDateOfCredit;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setDaysForPresentingDocuments(int daysForPresentingDocuments){
		this.daysForPresentingDocuments = daysForPresentingDocuments;
	}

	public int getDaysForPresentingDocuments(){
		return daysForPresentingDocuments;
	}

	@Override
 	public String toString(){
		return 
			"Validity{" + 
			"expiryDateOfCredit = '" + expiryDateOfCredit + '\'' + 
			",country = '" + country + '\'' + 
			",city = '" + city + '\'' + 
			",daysForPresentingDocuments = '" + daysForPresentingDocuments + '\'' + 
			"}";
		}
}
