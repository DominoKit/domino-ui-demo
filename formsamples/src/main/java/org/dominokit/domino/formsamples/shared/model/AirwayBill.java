package org.dominokit.domino.formsamples.shared.model;

public class AirwayBill {
    private String description;
    private int numberOfCopies;
    private boolean required;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isRequired() {
        return required;
    }

    @Override
    public String toString() {
        return
                "AirwayBill{" +
                        "description = '" + description + '\'' +
                        ",numberOfCopies = '" + numberOfCopies + '\'' +
                        ",required = '" + required + '\'' +
                        "}";
    }
}
