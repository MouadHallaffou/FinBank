package main.java.services;

import java.util.Scanner;
import main.java.models.Client;

public class ClientService {

    public boolean authenticationClient() {
        Scanner sc = new Scanner(System.in);
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║               LOGIN                ║");
        System.out.println("╚════════════════════════════════════╝");
        System.err.print("Entre votre adresse email : ");
        String email = sc.next().trim();
        System.out.print("Entre votre mot de passe : ");
        String password = sc.next().trim();

        Client authenticatedClient = GestionnaireService.authenticateClient(email, password);
        if (authenticatedClient == null) {
            System.err.println("Authentification échouée. Veuillez réessayer.");
            return authenticationClient(); 
        } else {
            return true;
        }
    }

    public void defaultClient() {
        // insert static cleint
    }

}
