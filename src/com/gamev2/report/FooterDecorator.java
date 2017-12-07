package com.gamev2.report;

/**
 * edited by AndersonKim
 * at 2017/12/7
 */
public class FooterDecorator extends OrderDecorator{
    public FooterDecorator(Order order) {
        super(order);
    }

    @Override
    public void print() {
        super.order.print();
        printFooter();
    }

    public void printFooter(){
        System.out.println("=========================");
        System.out.println("Total\t\t\t\t"+formatCurrency(super.order.getGrandTotal()));
    }
}
