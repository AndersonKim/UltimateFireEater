package com.gamev2.report;

/**
 * edited by AndersonKim
 * at 2017/12/7
 */
abstract class OrderDecorator extends Order {
    protected Order order;

    public OrderDecorator(Order order) {
        this.order = order;
        this.setSalesDate(order.getSalesDate());
        this.setCustomerName(order.getCustomerName());
    }

    @Override
    public void print() {
        super.print();
    }
}
