package main.java.services;

import main.java.enums.CompteEnums;
import main.java.models.Client;
import main.java.models.Compte;
import main.java.models.Transaction;
import main.java.utils.Validation;
import java.time.LocalDateTime;
import java.util.Scanner;

public class BanqueService {
    private static Scanner scanner = new Scanner(System.in);

    public Compte createCompteForClient(Client client) {
        Compte compte = new Compte();
        String numeroCompte = generateAccountNumberForClient(client.getUserID());
        compte.setAccountNumber(numeroCompte);
        compte.setClientID(client.getUserID());
        compte.setSolde(0.0);
        compte.setTypeCompte(CompteEnums.TypeCompte.CURRENT);
        compte.setStatusCompte(CompteEnums.StatusCompte.ACTIVE);
        return compte;
    }

    private static String generateAccountNumberForClient(int clientID) {
        return "ACC" + LocalDateTime.now().toString().replaceAll("[-:.T]", "") + clientID;
    }

    public void Deposit() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║            DEPOT D'ARGENT               ║");
        System.out.println("╚═════════════════════════════════════════╝");

        System.err.print("entre le montant: ");
        Double soldeDepose = scanner.nextDouble();
        for (Client client : GestionnaireService.getClients()) {
            for (Compte compte : client.getComptes().values()) {
                if (Validation.isPositifSolde(soldeDepose)){
                    System.err.print("entre le mot de passe de votre compte: ");
                    String passwordcheked = scanner.next().trim();
                    if (client.getPassword().equals(passwordcheked)) {
                        compte.setSolde(compte.getSolde() + soldeDepose);

                        Transaction transaction = new Transaction(CompteEnums.TypeTransaction.DEPOSIT, compte,soldeDepose.floatValue());
                        compte.getHistoriqueTransactions().add(transaction);

                        System.out.println("Depot effectue avec succes. Nouveau solde: " + compte.getSolde());
                        System.out.println("Transaction enregistrée avec l'ID: " + transaction.getIdTranction());
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

    public void Withdraw() throws Exception {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║           RETRAIT D'ARGENT              ║");
        System.out.println("╚═════════════════════════════════════════╝");

        System.err.print("entre le montant a retirer: ");
        Double soldeRetir = scanner.nextDouble();

        for (Client client : GestionnaireService.getClients()) {
            for (Compte compte : client.getComptes().values()) {
                if (Validation.isPositifSolde(compte.getSolde())
                        && Validation.CompareSolde(compte.getSolde(), soldeRetir)) {
                    System.err.print("entre le mot de passe de votre compte: ");
                    String passwordcheked = scanner.next().trim();
                    if (client.getPassword().equals(passwordcheked)) {
                        compte.setSolde(compte.getSolde() - soldeRetir);

                        Transaction transaction = new Transaction(CompteEnums.TypeTransaction.WITHDRAWAL, compte,soldeRetir.floatValue());
                        compte.getHistoriqueTransactions().add(transaction);

                        System.out.println("Retrait effectue avec succes. Nouveau solde: " + compte.getSolde());
                        System.out.println("Transaction enregistrée avec l'ID: " + transaction.getIdTranction());
                        return;
                    } else {
                        System.err.println("Mot de passe incorrect.");
                        throw new Exception("Mot de passe incorrect pour le retrait");
                    }
                } else {
                    System.err.println("Solde insuffisant.");
                    throw new Exception("Solde insuffisant pour effectuer le retrait");
                }
            }
        }
        throw new Exception("Aucun compte trouvé pour effectuer le retrait");
    }

    public void Transfer() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║                VIREMENT                 ║");
        System.out.println("╚═════════════════════════════════════════╝");

        System.err.print("entre le nemero de compte recevoir: ");
        String accountNumber = scanner.next().trim();
        System.err.print("entre le montant a deposer: ");
        double amount = scanner.nextDouble();
        System.err.print("motif du depot: ");
        String motive = scanner.next().trim();
        System.err.print("entre le mot de passe: ");
        String password = scanner.next().trim();

        for (Client client : GestionnaireService.getClients()) {
            if (client.getPassword().equals(password)) {
                System.out.println("Authentification reussie.");
                break;
            } else {
                System.err.println("Erreur: mot de passe incorrect.");
                return;
            }
        }
        System.out.println("Vous avez deposer " + amount + " DH sur le compte " + accountNumber
                + " pour le motif suivant: " + motive);
    }

}
