package main.java.enums;

public class CompteEnums {
    public enum TypeTransaction {
        DEPOSIT,
        WITHDRAWAL,
        TRANSFER,
    }

    public enum TypeCompte {
        CURRENT,
        EPARGNE
    }

    public enum StatusCompte {
        ACTIVE,
        CLOSED
    }
}
