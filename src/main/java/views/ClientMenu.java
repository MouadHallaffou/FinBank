package main.java.views;

import java.util.InputMismatchException;
import java.util.Scanner;
import main.java.controllers.ClientController;
import main.java.services.FichierService;

public class ClientMenu {
    private static Scanner scanner = Console.getScanner();

    public static void afficherMenuClient() {
        System.out.println("Authentification Client requise...\n");

        // TODO: Ajouter authentification client (login/password)

        while (true) {
            showClientMainMenu();

            try {
                int choice = readUserChoice();

                if (!executeClientChoice(choice)) {
                    break; 
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Erreur : Veuillez entrer un numero valide.");
                scanner.nextLine(); 
            }

            Console.waitForUserInput();
        }
    }

    private static void showClientMainMenu() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║        MENU CLIENT - FinBank            ║");
        System.out.println("╚═════════════════════════════════════════╝");
        System.out.println();
        System.out.println("Vos Operations Bancaires :");
        System.out.println();
        System.out.println("1 ➤ Effectuer un Depot");
        System.out.println("2 ➤ Effectuer un Retrait");
        System.out.println("3 ➤ Effectuer un Virement");
        System.out.println("4 ➤ Telecharger Releve de Compte");
        System.out.println("5 ➤ Retour au menu principal");
        System.out.println();
        System.out.print("Entrez votre choix (1-5): ");
    }

    private static int readUserChoice() {
        String input = scanner.nextLine().trim();
        return Integer.parseInt(input);
    }

    private static boolean executeClientChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Preparation de l'operation de depôt...");
                ClientController.Deposit();
                break;
            case 2:
                System.out.println("Preparation de l'operation de retrait...");
                ClientController.Withdraw();
                break;
            case 3:
                System.out.println("Preparation de l'operation de virement...");
                ClientController.Transfer();
                break;
            case 4:
                System.out.println("Generation du releve de compte...");
                FichierService.genererReleve();
                break;
            case 5:
                System.out.println("Retour au menu principal...");
                return false;
            default:
                System.out.println("Choix invalide. Veuillez choisir entre 1 et 5.");
        }
        return true;
    }

}
