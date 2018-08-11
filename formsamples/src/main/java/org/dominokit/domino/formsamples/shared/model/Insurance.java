package org.dominokit.domino.formsamples.shared.model;

public class Insurance{
	private String insurancePolicyNumber;
	private String description;
	private String insuranceCompany;

	public void setInsurancePolicyNumber(String insurancePolicyNumber){
		this.insurancePolicyNumber = insurancePolicyNumber;
	}

	public String getInsurancePolicyNumber(){
		return insurancePolicyNumber;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setInsuranceCompany(String insuranceCompany){
		this.insuranceCompany = insuranceCompany;
	}

	public String getInsuranceCompany(){
		return insuranceCompany;
	}

	@Override
 	public String toString(){
		return 
			"Insurance{" + 
			"insurancePolicyNumber = '" + insurancePolicyNumber + '\'' + 
			",description = '" + description + '\'' + 
			",insuranceCompany = '" + insuranceCompany + '\'' + 
			"}";
		}
}
