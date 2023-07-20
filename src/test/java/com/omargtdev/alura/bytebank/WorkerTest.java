package com.omargtdev.alura.bytebank;

import com.omargtdev.alura.bytebank.entity.workers.Designer;
import com.omargtdev.alura.bytebank.entity.workers.Manager;
import com.omargtdev.alura.bytebank.entity.workers.VideoEditor;
import com.omargtdev.alura.bytebank.entity.workers.Worker;
import com.omargtdev.alura.bytebank.helper.BonusControl;

public class WorkerTest {

    public static void main(String[] args) {
        Worker manager = new Manager();
        manager.setSalary(6000.50);

        Worker videoEditor = new VideoEditor();
        videoEditor.setSalary(3500.50);

        Worker designer = new Designer();
        videoEditor.setSalary(2800);

        BonusControl bonusControl = new BonusControl();
        bonusControl.registerBonus(manager, videoEditor, designer);

        System.out.println(bonusControl.getAmount());
    }

}
