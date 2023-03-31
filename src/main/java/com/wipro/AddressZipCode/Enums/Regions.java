package com.wipro.AddressZipCode.Enums;

public enum Regions {
    SUDESTE(7.85),
    CENTROOESTE(12.50),
    NORDESTE(15.98),
    SUL(17.30),
    NORTE(20.83);

    private final double shipping;

    Regions(double shipping) {
        this.shipping = shipping;
    }

    public double getShipping() {
        return shipping;
    }

}
