package main.java.models;

import java.util.Date;

import main.java.enums.CompteEnums;
import main.java.enums.CompteEnums.TypeTransaction;

public class Transaction {
    private int idTranction;
    private CompteEnums.TypeTransaction type;
    private float montant;
    private Date dateTransaction;
    private Compte compteSource;
    private Compte compteDestination;
    private static int nextTransactionId = 1;

    public Transaction(CompteEnums.TypeTransaction type, Compte compte, float montant) {
        this.idTranction = nextTransactionId++;
        this.type = type;
        this.montant = montant;
        this.dateTransaction = new Date();
        if (type == TypeTransaction.DEPOSIT || type == TypeTransaction.WITHDRAWAL) {
            this.compteSource = compte;
            this.compteDestination = null;
        } else {
            this.compteSource = compte;
        }
    }

    public Transaction() {
    }

    public int getIdTranction() {
        return idTranction;
    }

    public Compte getCompteDestination() {
        return compteDestination;
    }

    public Compte getCompteSource() {
        return compteSource;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public float getMontant() {
        return montant;
    }

    public CompteEnums.TypeTransaction getType() {
        return type;
    }

    public void setIdTranction(int idTranction) {
        this.idTranction = idTranction;
    }

    public void setType(CompteEnums.TypeTransaction type) {
        this.type = type;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public void setCompteDestination(Compte compteDestination) {
        this.compteDestination = compteDestination;
    }

    public void setCompteSource(Compte compteSource) {
        this.compteSource = compteSource;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "idTranction=" + idTranction +
                ", type=" + type +
                ", montant=" + montant +
                ", dateTransaction=" + dateTransaction +
                // ", compteSource=" + compteSource +
                // ", compteDestination=" + compteDestination +
                '}';
    }

}
