package main.java.services;

import main.java.enums.CompteEnums;
import main.java.models.Client;
import main.java.models.Compte;
import main.java.utils.Validation;
import main.java.views.Console;

import java.time.LocalDateTime;

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
        return "ACC" + LocalDateTime.now().toString().replaceAll("[-:.T]", "") + clientID;
    }

    public void Deposit() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║            DEPOT D'ARGENT               ║");
        System.out.println("╚═════════════════════════════════════════╝");
        System.out.println("entre le montant: ");
        Double solde = Console.getScanner().nextDouble();
        for (Client client : GestionnaireService.getClients()) {
            for (Compte compte : client.getComptes().values()) {
                if (Validation.isPositifSolde(compte.getSolde())
                        && Validation.CompareSolde(compte.getSolde(), solde)) {
                    System.err.println("entre le mot de passe de votre : ");
                    String passwordcheked = Console.getScanner().nextLine().trim();
                    if (client.getPassword().equals(passwordcheked)) {
                        compte.setSolde(compte.getSolde() + solde);
                        System.out.println("Depot effectue avec succes. Nouveau solde: " + compte.getSolde());
                        return;
                    } else {
                        System.err.println("Mot de passe incorrect.");
                        return;
                    }
                } else {
                    System.err.println("Depot non autorise.");
                    return;
                }
            }
        }
    }

    public void Withdraw() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║           RETRAIT D'ARGENT              ║");
        System.out.println("╚═════════════════════════════════════════╝");
        System.out.println("entre le montant a retirer: ");
        Double montant = Console.getScanner().nextDouble();
        
        for (Client client : GestionnaireService.getClients()) {
            for (Compte compte : client.getComptes().values()) {
                if (Validation.isPositifSolde(compte.getSolde()) 
                        && compte.getSolde() >= montant) {
                    System.err.println("entre le mot de passe: ");
                    String passwordcheked = Console.getScanner().nextLine().trim();
                    if (client.getPassword().equals(passwordcheked)) {
                        compte.setSolde(compte.getSolde() - montant);
                        System.out.println("Retrait effectue avec succes. Nouveau solde: " + compte.getSolde());
                        return;
                    } else {
                        System.err.println("Mot de passe incorrect.");
                        return;
                    }
                } else {
                    System.err.println("Solde insuffisant.");
                    return;
                }
            }
        }
    }

    public void Transfer() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║                VIREMENT                 ║");
        System.out.println("╚═════════════════════════════════════════╝");
        System.err.println("entre le nemero de compte recevoir: ");
        String accountNumber = Console.getScanner().nextLine().trim();
        System.err.println("entre le montant a deposer: ");
        double amount = Double.parseDouble(Console.getScanner().nextLine().trim());
        System.err.println("motif du depot: ");
        String motive = Console.getScanner().nextLine().trim();
        System.err.println("entre le mot de passe: ");
        String password = Console.getScanner().nextLine().trim();
        for (Client client : GestionnaireService.getClients()) {
            if (client.getPassword().equals(password)) {
                System.out.println("Authentification reussie.");
                break;
            } else {
                System.out.println("Erreur: mot de passe incorrect.");
                return;
            }
        }
        System.out.println("Vous avez deposer " + amount + " DH sur le compte " + accountNumber
                + " pour le motif suivant: " + motive);
    }

}
