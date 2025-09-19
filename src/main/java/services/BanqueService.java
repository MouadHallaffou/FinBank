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

        System.err.print("entre le montant a depose: ");
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

        Client senderClient = null;
        Compte senderCompte = null;
        
        for (Client client : GestionnaireService.getClients()) {
            if (client.getPassword().equals(password)) {
                for (Compte compte : client.getComptes().values()) {
                if (Validation.isPositifSolde(compte.getSolde()) && 
                Validation.CompareSolde(compte.getSolde(), amount)) {
                senderClient = client;
                senderCompte = compte;
                break;
                }
            }
            break;
            }
        }
        
        if (senderClient == null || senderCompte == null) {
            System.err.println("Erreur: mot de passe incorrect ou solde insuffisant.");
            return;
        }
        
        Compte receiverCompte = null;
        for (Client client : GestionnaireService.getClients()) {
            for (Compte compte : client.getComptes().values()) {
            if (compte.getAccountNumber().equals(accountNumber)) {
                receiverCompte = compte;
                break;
            }
            }
            if (receiverCompte != null) break;
        }
        
        if (receiverCompte == null) {
            System.err.println("Erreur: compte destinataire introuvable.");
            return;
        }
        
        if (senderCompte.equals(receiverCompte)) {
            System.err.println("Erreur: impossible de virer vers le même compte.");
            return;
        }
        
        if (Validation.isPositifSolde(amount)) {
            senderCompte.setSolde(senderCompte.getSolde() - amount);
            receiverCompte.setSolde(receiverCompte.getSolde() + amount);
            
            Transaction senderTransaction = new Transaction(CompteEnums.TypeTransaction.TRANSFER, senderCompte, (float) -amount);
            Transaction receiverTransaction = new Transaction(CompteEnums.TypeTransaction.TRANSFER, receiverCompte, (float) amount);
            
            senderCompte.getHistoriqueTransactions().add(senderTransaction);
            receiverCompte.getHistoriqueTransactions().add(receiverTransaction);
            
            System.out.println("Virement effectue avec succes de " + amount + " DH vers le compte " + accountNumber);
            System.out.println("Nouveau solde expediteur: " + senderCompte.getSolde());
            System.out.println("Motif: " + motive);
            return;
            } else {
                System.err.println("Erreur: montant de virement non valide.");
                return;
            }
        }

}
