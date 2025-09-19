package main.java.views;

import java.util.Scanner;

import main.java.services.GestionnaireService;

public class GestionnaireMenu {
    private static Scanner scanner = Console.getScanner();

    public static void afficherMenuGestionnaire() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║       Welcome to Gestionnaire Menu      ║");
        System.out.println("╚═════════════════════════════════════════╝");

        System.out.println("Please enter your authentication credentials: ");
        System.err.print(" entre votre adress Email: ");
        String email = scanner.nextLine();
        System.err.print(" entre votre Password: ");
        String password = scanner.nextLine();
        while (true) {
            if (GestionnaireService.authenticateGestionnaire(email, password)) {
            break; 
            } else {
            System.err.println("⚠ Authentication failed.");
            System.out.println("1. Try again");
            System.out.println("2. Exit to main menu");
            System.out.print("✦ Enter your choice: ");
            
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                System.out.print(" Email: ");
                email = scanner.nextLine();
                System.out.print(" Password: ");
                password = scanner.nextLine();
            } else {
                System.out.println("✦ Returning to main menu.");
                return;
            }
            }
        }
        while (true) {
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║       Welcome MOUAD HALLAFFOU to FinBanck      ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.println("1. ➤ Ajoute un client");
            System.out.println("2. ➤ Mettre a jour les informations");
            System.out.println("3. ➤ Fermer un compte");
            System.out.println("4. ➤ Consulter les releves");
            System.out.println("5. ➤ Exit");
            System.out.print("✦ Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    GestionnaireService.createClient();
                    break;
                case 2:
                    GestionnaireService.updateInfo();
                    break;
                case 3:
                    GestionnaireService.closeCompte();
                    break;
                case 4:
                    GestionnaireService.consulteReleves();
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
