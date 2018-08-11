package org.dominokit.domino.formsamples.shared.model;

public class ConfirmationInstructions{
	private boolean confirmationRequired;
	private String confirmationChargesOn;

	public void setConfirmationRequired(boolean confirmationRequired){
		this.confirmationRequired = confirmationRequired;
	}

	public boolean isConfirmationRequired(){
		return confirmationRequired;
	}

	public void setConfirmationChargesOn(String confirmationChargesOn){
		this.confirmationChargesOn = confirmationChargesOn;
	}

	public String getConfirmationChargesOn(){
		return confirmationChargesOn;
	}

	@Override
 	public String toString(){
		return 
			"ConfirmationInstructions{" + 
			"confirmationRequired = '" + confirmationRequired + '\'' + 
			",confirmationChargesOn = '" + confirmationChargesOn + '\'' + 
			"}";
		}
}
