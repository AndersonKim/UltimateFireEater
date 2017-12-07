package com.gamev2.report;

import java.text.NumberFormat;

/**
 * edited by AndersonKim
 * at 2017/12/7
 */
public class OrderLine {
    String itemName;
    int units;
    double unitPrice;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getSubtotal(){
        return unitPrice*units;
    }

    public String formatCurrency(double amnt){
        return NumberFormat.getCurrencyInstance().format(amnt);
    }

    public void printLine(){
        System.out.println(
                itemName+"\t"+units+
                "\t"+formatCurrency(unitPrice)+
                "\t"+formatCurrency(getSubtotal())
        );
    }
}
