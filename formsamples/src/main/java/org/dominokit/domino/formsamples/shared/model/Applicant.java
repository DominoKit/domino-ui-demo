package org.dominokit.domino.formsamples.shared.model;

public class Applicant {
    private LcSettlementAccount lcSettlementAccount;
    private FeesAndChargesSettlementAccount feesAndChargesSettlementAccount;
    private String value;
    private CollateralSettlementAccount collateralSettlementAccount;

    public void setLcSettlementAccount(LcSettlementAccount lcSettlementAccount) {
        this.lcSettlementAccount = lcSettlementAccount;
    }

    public LcSettlementAccount getLcSettlementAccount() {
        return lcSettlementAccount;
    }

    public void setFeesAndChargesSettlementAccount(FeesAndChargesSettlementAccount feesAndChargesSettlementAccount) {
        this.feesAndChargesSettlementAccount = feesAndChargesSettlementAccount;
    }

    public FeesAndChargesSettlementAccount getFeesAndChargesSettlementAccount() {
        return feesAndChargesSettlementAccount;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setCollateralSettlementAccount(CollateralSettlementAccount collateralSettlementAccount) {
        this.collateralSettlementAccount = collateralSettlementAccount;
    }

    public CollateralSettlementAccount getCollateralSettlementAccount() {
        return collateralSettlementAccount;
    }

    @Override
    public String toString() {
        return
                "Applicant{" +
                        "lcSettlementAccount = '" + lcSettlementAccount + '\'' +
                        ",feesAndChargesSettlementAccount = '" + feesAndChargesSettlementAccount + '\'' +
                        ",value = '" + value + '\'' +
                        ",collateralSettlementAccount = '" + collateralSettlementAccount + '\'' +
                        "}";
    }
}
