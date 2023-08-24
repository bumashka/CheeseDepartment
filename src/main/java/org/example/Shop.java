package org.example;

public class Shop {

    public static void main(String[] args) throws InterruptedException {
        CheeseDepartment cheeseDepartment = new CheeseDepartment();

        for(int i = 0; i < 4; i++){
            cheeseDepartment.callNewCustomer(CustomerType.values()[i % 2], i+1);
        }
    }
}
