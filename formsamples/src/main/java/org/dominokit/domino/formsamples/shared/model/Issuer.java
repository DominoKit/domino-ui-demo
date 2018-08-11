package org.dominokit.domino.formsamples.shared.model;

public class Issuer{
	private String bank;
	private String branch;

	public void setBank(String bank){
		this.bank = bank;
	}

	public String getBank(){
		return bank;
	}

	public void setBranch(String branch){
		this.branch = branch;
	}

	public String getBranch(){
		return branch;
	}

	@Override
 	public String toString(){
		return 
			"Issuer{" + 
			"bank = '" + bank + '\'' + 
			",branch = '" + branch + '\'' + 
			"}";
		}
}
