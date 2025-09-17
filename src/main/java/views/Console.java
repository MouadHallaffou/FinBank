package main.java.views;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static void start() {
        System.out.println("Initialisation du système FinBank...\n");

        while (true) {
            displayMainMenu();

            try {
                int choice = getUserChoice();

                if (!processChoice(choice)) {
                    break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("⚠ Erreur : Veuillez entrer un numéro valide.");
                scanner.nextLine();
            }

        }

        closeResources();
    }

    private static void displayMainMenu() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║       Welcome to FinBank Company        ║");
        System.out.println("╚═════════════════════════════════════════╝");
        System.out.println();
        System.out.println("Vous êtes ?");
        System.out.println();
        System.out.println("1 ➤ Gestionnaire");
        System.out.println("2 ➤ Client");
        System.out.println(" "); 
        System.out.println("3 ➤ Quitter");
        System.out.println();
        System.out.print("✦ Entrez votre choix (1-3): ");
    }

    private static int getUserChoice() {
        String input = scanner.nextLine().trim();
        return Integer.parseInt(input);
    }

    private static boolean processChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Redirection vers l'interface Gestionnaire...");
                GestionnaireMenu.afficherMenuGestionnaire();
                break;
            case 2:
                System.out.println("Redirection vers l'interface Client...");
                ClientMenu.afficherMenuClient();
                break;
            case 3:
                System.out.println("Fermeture du système FinBank...");
                System.out.println("Au revoir et merci d'avoir utilisé nos services !");
                return false;
            default:
                System.out.println("Choix invalide. Veuillez choisir entre 1, 2 ou 3.");
        }
        return true;
    }

    private static void closeResources() {
        if (scanner != null) {
            scanner.close();
        }
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void waitForUserInput() {
        System.out.println("Appuyez sur Entree pour continuer...");
        scanner.nextLine();
    }

}
