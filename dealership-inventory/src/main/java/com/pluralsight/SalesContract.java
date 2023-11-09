package com.pluralsight;

public abstract class SalesContract extends Contract{
    private double salePrice;

    public SalesContract(String contractDate, String customerName, String customerEmail, String vehicleSold, double salePrice) {
        super(contractDate, customerName, customerEmail, vehicleSold);
        this.salePrice = salePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }
}
