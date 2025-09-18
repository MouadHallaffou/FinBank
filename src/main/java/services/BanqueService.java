package main.java.services;

import main.java.enums.CompteEnums;
import main.java.models.Client;
import main.java.models.Compte;

public class BanqueService {

    public Compte createCompteForClient(Client client) {
        Compte compte = new Compte();

        String numeroCompte = generateAccountNumberForClient(client.getUserID());
        compte.setAccountNumber(numeroCompte);

        compte.setClientID(client.getUserID());


        compte.setSolde(0.0);
        compte.setTypeCompte(CompteEnums.TypeCompte.CURRENT);
        return compte;
    }

    private static String generateAccountNumberForClient(int clientID) {
        return "ACC" + System.currentTimeMillis();
    }

}
