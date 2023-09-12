package org.example;

public class CheeseDepartment {
    public CheeseDepartment() {
    }

    public void getCheese(Customer customer) throws InterruptedException {
        if(customer.getType().equals(CustomerType.HUMBLE)){
            synchronized (this){
                wait();
            }
        }
        Cheese(customer);
        if(customer.getType().equals(CustomerType.BRAVE)){
            synchronized (this){
                notify();
            }
        }
    }

    public void Cheese(Customer customer) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(customer.getType().toString() + " customer " + customer.getName() +
                " has left the Cheese Department with cheese.");
        callNewCustomer(customer.getType(), customer.getOrder());
    }

    public void callNewCustomer(CustomerType type, int order){
        Customer customer = new Customer(this, type, order);
        System.out.println(type.toString() + " customer " + customer.getName() +
                " has entered the Cheese Department.");
        customer.start();
    }
}
