package com.omargtdev.alurabytebank.helper;

import com.omargtdev.alurabytebank.entity.workers.Worker;

public class BonusControl {
    private double amount;

    public void registerBonus(Worker servant){
        this.amount += servant.getBonus();
        System.out.println(String.format(
                "Registered amount: %.2f",
                servant.getBonus()
        ));
    }

    public void registerBonus(Worker... servants){
        for (Worker servant :
                servants) {
            this.amount += servant.getBonus();
            System.out.println(String.format(
                    "Registered amount: %.2f",
                    servant.getBonus()
            ));
        }
    }

    public double getAmount() {
        return this.amount;
    }
}
