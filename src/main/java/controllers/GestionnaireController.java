package main.java.controllers;

import java.util.Scanner;

import main.java.models.Client;
import main.java.models.Compte;
import main.java.models.Gestionnaire;
import main.java.services.BanqueService;
import main.java.utils.Validation;

public class GestionnaireController {
    private static Scanner scanner = new Scanner(System.in);
    private static int nextUserID = 1;

    public static Gestionnaire createDefaultGestionnaire() {
        Gestionnaire defaultGestionnaire = new Gestionnaire();
        defaultGestionnaire.setUserID(nextUserID++);
        defaultGestionnaire.setFirstName("MOUAD");
        defaultGestionnaire.setLastName("HALLAFFOU");
        defaultGestionnaire.setEmail("mouad@gmail.com");
        defaultGestionnaire.setPassword("1234");
        return defaultGestionnaire;
    }

    public Gestionnaire createNewGestionnaire() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║       CREATION NOUVEAU GESTIONNAIRE     ║");
        System.out.println("╚═════════════════════════════════════════╝");
        System.out.println();

        Gestionnaire gestionnaire = new Gestionnaire();

        gestionnaire.setUserID(nextUserID++);
        System.out.println("ID Gestionnaire assigne : " + gestionnaire.getUserID());
        System.out.println();

        System.out.print("Prenom du gestionnaire : ");
        String firstName = scanner.nextLine().trim();
        while (Validation.isValidFirstName(firstName) == false) {
            System.out.print("Le prenom ne peut pas être vide. Prenom : ");
            firstName = scanner.nextLine().trim();
        }
        gestionnaire.setFirstName(firstName);

        System.out.print("Nom du gestionnaire : ");
        String lastName = scanner.nextLine().trim().toUpperCase();
        while (Validation.isValidLastName(lastName) == false) {
            System.out.print("Le nom ne peut pas être vide. Nom : ");
            lastName = scanner.nextLine().trim().toUpperCase();
        }
        gestionnaire.setLastName(lastName);

        System.out.print("Email du gestionnaire : ");
        String email = scanner.nextLine().trim();
        while (Validation.isValidEmail(email) == false) {
            System.out.print("Email invalide. Email : ");
            email = scanner.nextLine().trim();
        }
        gestionnaire.setEmail(email);

        String password = generatePassword(gestionnaire.getFirstName());
        gestionnaire.setPassword(password);

        System.out.println();
        System.out.println("  Gestionnaire cree avec succès !");
        System.out.println("    Mot de passe   : " + password);

        return gestionnaire;
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
        System.out.println("║         CREATION NOUVEAU CLIENT         ║");
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

        // CREATION AUTOMATIQUE DU COMPTE
        System.out.println("\nCréation du compte bancaire...");
        BanqueService banqueService = new BanqueService();
        Compte compteClient = banqueService.createCompteForClient(client);

        // Ajouter le compte au client
        client.getComptes().put(compteClient.getAccountNumber(), compteClient);

        System.out.println();
        System.out.println("Client cree avec succes !");
        System.out.println("Mot de passe : " + password);
        System.out.println("Numero de compte : " + compteClient.getAccountNumber());
        System.out.println("Solde initial : " + compteClient.getSolde() + " MAD");
        System.out.println("Type de compte : " + compteClient.getTypeCompte());

        return client;
    }

    public static void updateInfo() {
        System.out.println("Mise à jour des informations...");

    }

    public static void closeCompte() {
        System.out.println("Fermeture de compte...");

    }

    public static void consulteReleves() {
        System.out.println("Consultation des releves...");

    }

}
