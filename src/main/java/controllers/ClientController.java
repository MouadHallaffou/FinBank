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
        System.out.print("Entre votre adresse email : ");
        String email = sc.next().trim();
        System.out.print("Entre votre mot de passe : ");
        String password = sc.next().trim();

        Client authenticatedClient = GestionnaireController.authenticateClient(email, password);
        if (authenticatedClient == null) {
            //System.out.println("⚠ Authentification échouée. Retour au menu principal.");
            return false;
        } else {
            //System.out.println(" Authentification réussie. Bienvenue, " + authenticatedClient.getFirstName() + "!");
            return true;
        }
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
