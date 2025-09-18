package main.java.controllers;

import java.util.Scanner;
import main.java.models.Client;

public class ClientController {

    public static boolean authenticationClient() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Authentification Client requise...\n");
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║                 LOGIN                   ║");
        System.out.println("╚═════════════════════════════════════════╝");
        System.out.print("Entrez votre adresse email : ");
        String email = sc.nextLine().trim();
        System.out.print("Entrez votre mot de passe : ");
        String password = sc.nextLine().trim();

        Client authenticatedClient = authenticateClient(email, password);
        if (authenticatedClient == null) {
            System.out.println("⚠️ Authentification échouée. Retour au menu principal.");
            return false;
        } else {
            System.out.println("✅ Authentification réussie. Bienvenue, " + authenticatedClient.getFirstName() + "!");
            return true;
        }
    }

    private static Client authenticateClient(String email, String password) {
        Client client = new Client();
        if (email.equals(client.getEmail()) &&
                password.equals(client.getPassword())) {
            return client;
        }
        return null;
    }

    public static void Deposit() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║            DEPOT D'ARGENT               ║");
        System.out.println("╚═════════════════════════════════════════╝");
    }

    public static void Withdraw() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║           RETRAIT D'ARGENT              ║");
        System.out.println("╚═════════════════════════════════════════╝");
    }

    public static void Transfer() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║                VIREMENT                 ║");
        System.out.println("╚═════════════════════════════════════════╝");
    }

}
