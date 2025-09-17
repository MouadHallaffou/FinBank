package main.java.controllers;

import java.util.Scanner;

import main.java.models.Client;
import main.java.models.Gestionnaire;
import main.java.utils.Validation;

public class GestionnaireController {
    private static Scanner scanner = new Scanner(System.in);
    private static int nextUserID = 1; 

    public static Gestionnaire createDefaultGestionnaire() {
        Gestionnaire defaultGestionnaire = new Gestionnaire();
        defaultGestionnaire.setUserID(nextUserID++); 
        defaultGestionnaire.setFirstName("MOUAD");
        defaultGestionnaire.setLastName("HALLAFFOU");
        defaultGestionnaire.setEmail("mouadhallaffou@gmail.com");
        defaultGestionnaire.setPassword("mouad1234");
        return defaultGestionnaire;
    }

    public static boolean authenticateGestionnaire(String email, String password) {
        Gestionnaire defaultGestionnaire = createDefaultGestionnaire();
        return email.equals(defaultGestionnaire.getEmail()) &&
                password.equals(defaultGestionnaire.getPassword());
    }

    private static String generatePassword(String firstName) {
        return firstName.toLowerCase() + "1234"; 
    }

    public static Client createClient() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║         CRÉATION NOUVEAU CLIENT         ║");
        System.out.println("╚═════════════════════════════════════════╝");
        System.out.println();

        Client client = new Client();


        client.setUserID(nextUserID++);
        System.out.println("ID Client assigné : " + client.getUserID());
        System.out.println();


        System.out.print("Prénom du client : ");
        String firstName = scanner.nextLine().trim();
        while (firstName.isEmpty()) {
            System.out.print("Le prénom ne peut pas être vide. Prénom : ");
            firstName = scanner.nextLine().trim();
        }
        client.setFirstName(firstName);


        System.out.print("Nom du client : ");
        String lastName = scanner.nextLine().trim().toUpperCase();
        while (Validation.isValidLastName(lastName) == false) {
            System.out.print("Le nom ne peut pas être vide. Nom : ");
            lastName = scanner.nextLine().trim().toUpperCase();
        }
        client.setLastName(lastName);

        
        System.out.print("Email du client : ");
        String email = scanner.nextLine().trim();
        while (Validation.isValidEmail(email) == false) {
            System.out.print("Email invalide. Email : ");
            email = scanner.nextLine().trim();
        }
        client.setEmail(email);

        String password = generatePassword(client.getFirstName());
        client.setPassword(password);

        System.out.println();
        System.out.println("  Client créé avec succès !");
        System.out.println("    Mot de passe   : " + password);

        return client;
    }





    
    public static void updateInfo() {
        System.out.println("Mise à jour des informations...");
        // TODO: Implement update logic
    }

    public static void closeCompte() {
        System.out.println("Fermeture de compte...");
        // TODO: Implement account closure logic
    }

    public static void consulteReleves() {
        System.out.println("Consultation des relevés...");
        // TODO: Implement statement consultation logic
    }
}
