package com.epam.mikle.realestateagentassistant.model.entity;



public abstract class Meeting extends BaseEntity {
    protected String address;
    protected Double cost;
    protected Double square;
    protected Double squareMCost;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getCost() {
        return cost;
    }

    public Double getSquare() {
        return square;
    }

    public Double getSquareMCost() {
        return squareMCost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setSquare(Double square) {
        this.square = square;
    }

    public void setSquareMCost(Double squareMCost) {
        this.squareMCost = squareMCost;
    }
}
