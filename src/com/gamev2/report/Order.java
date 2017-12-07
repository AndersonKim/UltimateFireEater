package com.gamev2.report;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * edited by AndersonKim
 * at 2017/12/7
 */
abstract class Order {
    OrderLine lnkOrderLine;
    String customerName;
    Date salesDate;
    List<OrderLine> items = new ArrayList();

    public void print() {
        for (OrderLine obj : items) {
            obj.printLine();
        }
    }

    public double getGrandTotal() {
        double amnt = 0.0D;
        for (OrderLine item : items) {
            amnt += item.getSubtotal();
        }
        return amnt;
    }

    public String formatCurrency(double amnt) {
        return NumberFormat.getCurrencyInstance().format(amnt);
    }

    public void addItem(OrderLine item) {
        items.add(item);
    }

    public void removeItem(OrderLine item) {
        items.remove(item);
    }

    public OrderLine getLnkOrderLine() {
        return lnkOrderLine;
    }

    public void setLnkOrderLine(OrderLine lnkOrderLine) {
        this.lnkOrderLine = lnkOrderLine;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }
}
