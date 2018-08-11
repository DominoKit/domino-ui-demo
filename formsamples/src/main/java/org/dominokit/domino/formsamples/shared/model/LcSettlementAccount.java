package org.dominokit.domino.formsamples.shared.model;

public class LcSettlementAccount{
	private String accountAlias;
	private String iban;
	private String accountNumber;

	public void setAccountAlias(String accountAlias){
		this.accountAlias = accountAlias;
	}

	public String getAccountAlias(){
		return accountAlias;
	}

	public void setIban(String iban){
		this.iban = iban;
	}

	public String getIban(){
		return iban;
	}

	public void setAccountNumber(String accountNumber){
		this.accountNumber = accountNumber;
	}

	public String getAccountNumber(){
		return accountNumber;
	}

	@Override
 	public String toString(){
		return 
			"LcSettlementAccount{" + 
			"accountAlias = '" + accountAlias + '\'' + 
			",iban = '" + iban + '\'' + 
			",accountNumber = '" + accountNumber + '\'' + 
			"}";
		}
}
