package com.gamev2.report;

/**
 * edited by AndersonKim
 * at 2017/12/7
 */
public class HeaderDecorator extends OrderDecorator{
    public HeaderDecorator(Order anOrder) {
        super(anOrder);
    }

    @Override
    public void print() {
        this.printHeader();
        super.order.print();
    }

    private void printHeader() {
        System.out.println("\t***\tI N O V I C E\t***");
        System.out.println("\tDate of Sale: ");
        System.out.println(order.getSalesDate());
        System.out.println("=========================");
        System.out.println("Item\t\tUnits\tUnit Price\tSubtotal");
    }
}
