package main.java.services;

import java.util.Scanner;
import main.java.models.Client;
import main.java.views.Console;

public class ClientService {

    public boolean authenticationClient() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Authentification Client requise...\n");
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║                 LOGIN                   ║");
        System.out.println("╚═════════════════════════════════════════╝");
        System.out.print("Entre votre adresse email : ");
        String email = sc.next().trim();
        System.out.print("Entre votre mot de passe : ");
        String password = sc.next().trim();

        Client authenticatedClient = GestionnaireService.authenticateClient(email, password);
        if (authenticatedClient == null) {
            return false;
        } else {
            return true;
        }
    }

    public void Deposit() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║            DEPOT D'ARGENT               ║");
        System.out.println("╚═════════════════════════════════════════╝");

    }

    public void Withdraw() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║           RETRAIT D'ARGENT              ║");
        System.out.println("╚═════════════════════════════════════════╝");
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
        System.out.println("Vous avez deposer " + amount + " DH sur le compte " + accountNumber + " pour le motif suivant: " + motive);
    }

}
