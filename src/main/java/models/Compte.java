package main.java.models;


import main.java.enums.TypeCompte;

import java.util.HashMap;
import java.util.HashSet;

public class Compte {
    private String accountNumber;
    private double solde;
    private TypeCompte typeTransaction;
    private HashSet<Transaction> historiqueTransactions = new HashSet<>();

    public HashMap<String, Transaction> getHistoriqueTransaction() {
        return historiqueTransaction;
    }

    public double getSolde() {
        return solde;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    private HashMap<String, Transaction> historiqueTransaction = new HashMap<>();

}
