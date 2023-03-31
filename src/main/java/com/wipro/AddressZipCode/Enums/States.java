package com.wipro.AddressZipCode.Enums;

public enum States {
    AC(Regions.NORTE),
    AL(Regions.NORDESTE),
    AM(Regions.NORTE),
    AP(Regions.NORTE),
    BA(Regions.NORDESTE),
    CE(Regions.NORDESTE),
    DF(Regions.CENTROOESTE),
    ES(Regions.SUDESTE),
    GO(Regions.CENTROOESTE),
    MA(Regions.NORDESTE),
    MG(Regions.SUDESTE),
    MS(Regions.CENTROOESTE),
    MT(Regions.CENTROOESTE),
    PA(Regions.NORTE),
    PB(Regions.NORDESTE),
    PE(Regions.NORDESTE),
    PI(Regions.NORDESTE),
    PR(Regions.SUL),
    RJ(Regions.SUDESTE),
    RN(Regions.NORDESTE),
    RO(Regions.NORTE),
    RR(Regions.NORTE),
    RS(Regions.SUL),
    SC(Regions.SUL),
    SE(Regions.NORDESTE),
    SP(Regions.SUDESTE),
    TO(Regions.NORTE);

    private final double region;

    States(Regions region) {
        this.region = region.getShipping();
    }

    public double getRegion() {
        return region;
    }
}
