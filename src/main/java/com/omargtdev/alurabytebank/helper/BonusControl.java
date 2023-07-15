package com.omargtdev.alurabytebank.helper;

import com.omargtdev.alurabytebank.entity.Servant;

public class BonusControl {
    private double amount;

    public void registerBonus(Servant servant){
        this.amount += servant.getBonus();
        System.out.println(String.format(
                "Registered amount: %.2f",
                servant.getBonus()
        ));
    }

    public void registerBonus(Servant... servants){
        for (Servant servant :
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
