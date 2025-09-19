package main.java.models;

import main.java.enums.CompteEnums;

import java.util.HashSet;

public class Compte {
    private int clientID;
    private String accountNumber;
    private double solde;
    private CompteEnums.StatusCompte statusCompte;
    private CompteEnums.TypeTransaction typeTransaction;
    private HashSet<Transaction> historiqueTransactions = new HashSet<>();
    private CompteEnums.TypeCompte typeCompte;
    
    public Compte(int clientID, String accountNumber, double solde, CompteEnums.TypeTransaction typeTransaction,
    HashSet<Transaction> historiqueTransactions, CompteEnums.TypeCompte typeCompte, CompteEnums.StatusCompte statusCompte) {
        this.accountNumber = accountNumber;
        this.clientID = clientID;
        this.solde = solde;
        this.typeTransaction = typeTransaction;
        this.historiqueTransactions = historiqueTransactions;
        this.statusCompte = CompteEnums.StatusCompte.ACTIVE;
        this.typeCompte = typeCompte;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "clientID=" + clientID +
                ", accountNumber='" + accountNumber + '\'' +
                ", solde=" + solde +
                ", statusCompte=" + statusCompte +
                ", typeTransaction=" + typeTransaction +
                ", historiqueTransactions=" + historiqueTransactions +
                ", typeCompte=" + typeCompte +
                '}';
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
    
    public CompteEnums.TypeTransaction getTypeTransaction() {
        return typeTransaction;
    }
    
    public void setTypeTransaction(CompteEnums.TypeTransaction typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public HashSet<Transaction> getHistoriqueTransactions() {
        return historiqueTransactions;
    }
    
    public void setHistoriqueTransactions(HashSet<Transaction> historiqueTransactions) {
        this.historiqueTransactions = historiqueTransactions;
    }
    
    public CompteEnums.TypeCompte getTypeCompte() {
        return typeCompte;
    }
    
    public void setTypeCompte(CompteEnums.TypeCompte typeCompte) {
        this.typeCompte = typeCompte;
    }
    
    public CompteEnums.StatusCompte getStatusCompte() {
        return statusCompte;
    }
    
    public void setStatusCompte(CompteEnums.StatusCompte statusCompte) {
        this.statusCompte = statusCompte;
    }
}
