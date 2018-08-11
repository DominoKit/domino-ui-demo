package org.dominokit.domino.formsamples.shared.model;

public class ChargesInstructions {
    private String outsideCountryChargesOn;

    public void setOutsideCountryChargesOn(String outsideCountryChargesOn) {
        this.outsideCountryChargesOn = outsideCountryChargesOn;
    }

    public String getOutsideCountryChargesOn() {
        return outsideCountryChargesOn;
    }

    @Override
    public String toString() {
        return
                "ChargesInstructions{" +
                        "outsideCountryChargesOn = '" + outsideCountryChargesOn + '\'' +
                        "}";
    }
}
