package com.omargtdev.alura.bytebank;

import com.omargtdev.alura.bytebank.entity.Client;
import com.omargtdev.alura.bytebank.entity.accounts.Account;
import com.omargtdev.alura.bytebank.entity.accounts.CheckingAccount;
import com.omargtdev.alura.bytebank.entity.accounts.SavingsAccount;
import com.omargtdev.alura.bytebank.exception.InvalidAmountException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class ConsumingDataTest {

    private static final int MAX_BYTES = 10000;
    private static final int LINES_TO_READ = 10;

    private static final String DATA_DIRECTORY =
            Paths.get(".", "data")
                    .toAbsolutePath().normalize().toString();

    public static void main(String[] args) {

        try {
            List<Client> clients = getClients(Integer.valueOf(14));
            List<Account> accounts = getAccounts(Integer.valueOf(15), clients);

            //accounts.iterator()

            System.out.println("Clients => " + clients.size());
            System.out.println("Accounts => " + accounts.size());

            // Sort by balance
            // accounts.sort((o1, o2) -> Double.compare(o1.getBalance(), o2.getBalance()));
            accounts.sort(Comparator.comparingDouble(Account::getBalance));
            //accounts.sort()
            //Collections.reverse(accounts);
            //Collections.shuffle(accounts);

            //Collections.swap(accounts, 0, 2);
            //Collections.rotate(accounts, 5);

            accounts.sort((o1, o2) -> {
                Client account1Client = o1.getClient();
                Client account2Client = o2.getClient();
                if(account1Client == null || account2Client == null) return 0;
                return account1Client.getName().compareTo(account2Client.getName());
            });
/*
            accounts.sort(new Comparator<Account>() {
                @Override
                public int compare(Account o1, Account o2) {
                    Client account1Client = o1.getClient();
                    Client account2Client = o2.getClient();
                    if(account1Client == null || account2Client == null) return 0;
                    return account1Client.getName().compareTo(account2Client.getName());
                }
            });
*/

            Collections.sort(accounts);

            // Printing
            for (Account account : accounts) {
                System.out.println(account);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static List<Account> getAccounts(Integer countToGet, List<Client> clientsToSet) throws IOException {
        int count = countToGet != null ? countToGet.intValue() : LINES_TO_READ;

        File accountsFile = new File(Paths.get(DATA_DIRECTORY, "accounts.csv").toString());
        if (accountsFile.length() > MAX_BYTES)
            throw new IOException("Cannot read the file " + accountsFile.getName() + ": Too big");

        // Reading accounts data
        List<Account> accounts = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(accountsFile))) {
            buffer.readLine(); // Escaping header
            for (int i = 0; i < count; i++) {
                String accountData = buffer.readLine();
                Client clientToSet = null;
                if (clientsToSet.size() > i)
                    clientToSet = clientsToSet.get(i);
                Account account = mapToAccount(accountData, clientToSet);
                accounts.add(account);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    static List<Client> getClients(Integer countToGet) throws IOException {
        int count = countToGet != null ? countToGet.intValue() : LINES_TO_READ;

        File clientsFile = new File(Paths.get(DATA_DIRECTORY, "clients.csv").toString());
        if (clientsFile.length() > MAX_BYTES)
            throw new IOException("Cannot read the file " + clientsFile.getName() + ": Too big");

        // Reading clients data
        List<Client> clients = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(clientsFile))) {
            buffer.readLine(); // Escaping header
            for (int i = 0; i < count; i++) {
                String clientData = buffer.readLine();
                clients.add(mapToClient(clientData));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clients;
    }

    static Client mapToClient(String clientData) {
        // Structure [ name | document | phoneNumber ]
        String[] fields = clientData.split(",");
        return new Client(
                fields[0].trim(),
                fields[1].trim(),
                fields[2].trim()
        );
    }

    enum AccountType {
        CHECKING,
        SAVINGS
    }

    static Account mapToAccount(String accountData, Client client) {
        // Structure [ number | agency | balance | type {0, 1} ]
        String[] fields = accountData.split(",");
        AccountType accountType = AccountType.values()[Integer.parseInt(fields[3])];

        if (accountType == AccountType.CHECKING) {
            Account account = new CheckingAccount(
                    Integer.parseInt(fields[0].trim()),
                    Account.Agency.values()[Integer.parseInt(fields[1])],
                    client
            );
            try {
                account.deposit(Double.parseDouble(fields[2]));
            } catch (InvalidAmountException ex) {
                ex.printStackTrace();
            }
            return account;
        }

        if (accountType == AccountType.SAVINGS) {
            Account account = new SavingsAccount(
                    Integer.parseInt(fields[0].trim()),
                    Account.Agency.values()[Integer.parseInt(fields[1])],
                    client
            );
            try {
                account.deposit(Double.parseDouble(fields[2]));
            } catch (InvalidAmountException ex) {
                ex.printStackTrace();
            }
            return account;
        }

        return null;
    }
}
