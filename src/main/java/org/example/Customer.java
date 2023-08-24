package org.example;

public class Customer extends Thread {

   final CheeseDepartment cheeseDepartment;

    public CustomerType getType() {
        return type;
    }

    public int getOrder() {
        return order;
    }

    final CustomerType type;

    final int order;

    public Customer(CheeseDepartment cheeseDepartment, CustomerType type, int order) {
        this.cheeseDepartment = cheeseDepartment;
        this.type = type;
        this.order = order;

    }

    @Override
    public void run() {
        try {
            cheeseDepartment.getCheese(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
