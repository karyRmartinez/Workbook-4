package com.pluralsight;

public abstract class Contract {

    private String contractDate;
    private String customerName;
    private String customerEmail;
    private String vehicleSold;

    public Contract(String contractDate, String customerName, String customerEmail, String vehicleSold) {
        this.contractDate = contractDate;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }

    //   private double getTotalPrice(){
//        return 0;
//    }
    private double totalPrice;
    private double monthlyPayment;

    //double getMonthlyPayment();
    public abstract void calculateTotalPrice();

    public abstract void calculateMonthlyPayment();

    // Getters and setters
    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(String vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    protected void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

}
