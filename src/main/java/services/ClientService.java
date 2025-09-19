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

}
