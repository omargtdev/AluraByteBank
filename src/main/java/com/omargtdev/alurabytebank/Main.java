package com.omargtdev.alurabytebank;

import com.omargtdev.alurabytebank.entities.Designer;
import com.omargtdev.alurabytebank.entities.Manager;
import com.omargtdev.alurabytebank.entities.Servant;
import com.omargtdev.alurabytebank.entities.VideoEditor;
import com.omargtdev.alurabytebank.helper.BonusControl;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Employees
        Servant manager = new Manager();
        manager.setSalary(6000.50);

        Servant videoEditor = new VideoEditor();
        videoEditor.setSalary(3500.50);

        Servant designer = new Designer();
        videoEditor.setSalary(2800);

        BonusControl bonusControl = new BonusControl();
        bonusControl.registerBonus(manager, videoEditor, designer);

        System.out.println(bonusControl.getAmount());
    }
}