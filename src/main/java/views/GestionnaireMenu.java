package main.java.views;

import java.util.Scanner;

import main.java.controllers.GestionnaireController;
import main.java.models.User;

public class GestionnaireMenu {
    private static Scanner scanner = Console.getScanner();

    public static void afficherMenuGestionnaire() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║       Welcome to Gestionnaire Menu      ║");
        System.out.println("╚═════════════════════════════════════════╝");

        System.out.println("Please enter your authentication credentials:");
        System.out.print(" Email: ");
        String email = scanner.nextLine();
        System.out.print(" Password: ");
        String password = scanner.nextLine();
        if (!GestionnaireController.authenticateGestionnaire(email, password)) {
            System.out.println("⚠ Authentication failed. Returning to main menu.");
            return;
        }
        while (true) {
            System.out.println("╔═════════════════════════════════════════╗");
            System.out.println("║         Welcome MOUAD HALLAFFOU         ║");
            System.out.println("╚═════════════════════════════════════════╝");
            System.out.println("1. ➤ Créer un client");
            System.out.println("2. ➤ Mettre à jour les informations");
            System.out.println("3. ➤ Fermer un compte");
            System.out.println("4. ➤ Consulter les relevés");
            System.out.println("5. ➤ Exit");
            System.out.print("✦ Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    GestionnaireController.createClient();
                    break;
                case 2:
                    GestionnaireController.updateInfo();
                    break;
                case 3:
                    GestionnaireController.closeCompte();
                    break;
                case 4:
                    GestionnaireController.consulteReleves();
                    break;
                case 5:
                    System.out.println("✦ Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("⚠ Invalid choice. Try again.");
            }
            Console.waitForUserInput();
        }
    }

}
