package com.omargtdev.alura.bytebank.helper;

import com.omargtdev.alura.bytebank.entity.workers.Worker;

public class BonusControl {
    private double amount;

    public void registerBonus(Worker worker){
        this.amount += worker.getBonus();
        System.out.println(String.format(
                "Registered amount: %.2f",
                worker.getBonus()
        ));
    }

    public void registerBonus(Worker... workers){
        for (Worker worker :
                workers) {
            this.amount += worker.getBonus();
            System.out.println(String.format(
                    "Registered amount: %.2f",
                    worker.getBonus()
            ));
        }
    }

    public double getAmount() {
        return this.amount;
    }
}
