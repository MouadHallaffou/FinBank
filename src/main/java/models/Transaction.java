package main.java.models;

import java.util.Date;

public class Transaction {
    private int idTranction;
    private String type;
    private float montant;
    private Date dateTransaction;
    private Compte compteSource;
    private Compte compteDestination;

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

    public String getType() {
        return type;
    }

    public void setIdTranction(int idTranction) {
        this.idTranction = idTranction;
    }

    public void setType(String type) {
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

}
