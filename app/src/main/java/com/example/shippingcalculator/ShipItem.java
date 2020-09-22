package com.example.shippingcalculator;

public class ShipItem {
    Double weight;
    static final Double BASE = 3.00;
    static final Double ADDED = 0.50;
    static final double EXTRA = 4.00;
    static final int BASE_WEIGHT;

    static {
        BASE_WEIGHT = 16;
    }
    
    static final double EXTRA_WEIGHT = 4.0;

    public ShipItem() {
        weight = 0.0;
    }
    public ShipItem(Double weight){
        this.weight = weight;
    }
    public Double getBaseCost(){
        //include implementation
        if(weight > EXTRA_WEIGHT) return EXTRA;
        return BASE;

    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getAddedCost(){
        //include implementation
        if(weight > BASE_WEIGHT) {
            double overage = (weight - BASE_WEIGHT);
            return Math.ceil(overage / 4 * ADDED);
        }
        return 0.0;
    }

    public Double getTotalCost(){
        return getBaseCost() + getAddedCost();
    }

}
