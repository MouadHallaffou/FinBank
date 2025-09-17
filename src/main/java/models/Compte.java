package main.java.models;

import main.java.enums.CompteEnums;

import java.util.HashSet;

public class Compte {
    private int clientID;
    private String accountNumber;
    private double solde;
    private CompteEnums typeTransaction;
    private HashSet<Transaction> historiqueTransactions = new HashSet<>();
    private CompteEnums typeCompte;

    public Compte(int clientID, String accountNumber, double solde, CompteEnums typeTransaction,
            HashSet<Transaction> historiqueTransactions, CompteEnums typeCompte) {
        this.clientID = clientID;
        this.accountNumber = accountNumber;
        this.solde = solde;
        this.typeTransaction = typeTransaction;
        this.historiqueTransactions = historiqueTransactions;
        this.typeCompte = typeCompte;
    }
    public Compte() {
    }

    public int getClientID() {
        return clientID;
    }
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public double getSolde() {
        return solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }
    public CompteEnums getTypeTransaction() {
        return typeTransaction;
    }
    public void setTypeTransaction(CompteEnums typeTransaction) {
        this.typeTransaction = typeTransaction;
    }
    public HashSet<Transaction> getHistoriqueTransactions() {
        return historiqueTransactions;
    }
    public void setHistoriqueTransactions(HashSet<Transaction> historiqueTransactions) {
        this.historiqueTransactions = historiqueTransactions;
    }
    public CompteEnums getTypeCompte() {
        return typeCompte;
    }
    public void setTypeCompte(CompteEnums typeCompte) {
        this.typeCompte = typeCompte;
    }


}
