package com.pluralsight;

public abstract class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;


    // build constructor


    public LeaseContract(String contractDate, String customerName, String customerEmail, String vehicleSold, double expectedEndingValue, double leaseFee) {
        super(contractDate, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
        calculateTotalPrice();
        calculateMonthlyPayment();

    }

    public void calculateMonthlyPayment(){

    }
    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }
}
