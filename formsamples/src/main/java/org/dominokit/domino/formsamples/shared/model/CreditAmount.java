package org.dominokit.domino.formsamples.shared.model;

public class CreditAmount {
    private LcAmount lcAmount;
    private boolean maximum;
    private double tolerance;

    public void setLcAmount(LcAmount lcAmount) {
        this.lcAmount = lcAmount;
    }

    public LcAmount getLcAmount() {
        return lcAmount;
    }

    public void setMaximum(boolean maximum) {
        this.maximum = maximum;
    }

    public boolean isMaximum() {
        return maximum;
    }

    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }

    public double getTolerance() {
        return tolerance;
    }

    @Override
    public String toString() {
        return
                "CreditAmount{" +
                        "lcAmount = '" + lcAmount + '\'' +
                        ",maximum = '" + maximum + '\'' +
                        ",tolerance = '" + tolerance + '\'' +
                        "}";
    }
}
