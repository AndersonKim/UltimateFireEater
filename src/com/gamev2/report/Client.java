package com.gamev2.report;

import java.util.Date;

/**
 * edited by AndersonKim
 * at 2017/12/7
 */
public class Client {
    private static Order order;
    public static void main(String[] args){
        order=new SalesOrder();
        order.setSalesDate(new Date());
        order.setCustomerName("AnderSon's shop");
        OrderLine line1=new OrderLine();
        line1.setItemName("Heart");
        line1.setUnitPrice(123.5);
        line1.setUnits(4);
        order.addItem(line1);
        OrderLine line2=new OrderLine();
        line2.setItemName("Love");
        line2.setUnitPrice(13.5);
        line2.setUnits(2);
        order.addItem(line2);
        OrderLine line3=new OrderLine();
        line3.setItemName("Time");
        line3.setUnitPrice(999.9);
        line3.setUnits(1);
        order.addItem(line3);

        order=new HeaderDecorator(new FooterDecorator(order));
        order.print();
    }
}
