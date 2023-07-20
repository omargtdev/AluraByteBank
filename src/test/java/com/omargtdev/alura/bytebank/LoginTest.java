package com.omargtdev.alura.bytebank;

import com.omargtdev.alura.bytebank.entity.Client;
import com.omargtdev.alura.bytebank.entity.workers.Administrator;
import com.omargtdev.alura.bytebank.entity.workers.Manager;
import com.omargtdev.alura.bytebank.security.Authentication;
import com.omargtdev.alura.bytebank.security.InternalSystem;

public class LoginTest {

    public static void main(String[] args) {
        Authentication client = new Client();
        client.setPassword("mySecretPassword");

        Authentication admin = new Administrator();
        admin.setPassword("holi123");

        Authentication manager = new Manager();
        manager.setPassword("pass123");

        InternalSystem internalSystem = new InternalSystem();

        internalSystem.authenticate(client);
        internalSystem.authenticate(admin);
        internalSystem.authenticate(manager);
    }

}
