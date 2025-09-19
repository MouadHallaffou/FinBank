package main.java.services;

import java.util.ArrayList;
import java.util.Scanner;

import main.java.enums.CompteEnums;
import main.java.models.Client;
import main.java.models.Compte;
import main.java.models.Gestionnaire;
import main.java.utils.Validation;

public class GestionnaireService {
    private static Scanner scanner = new Scanner(System.in);
    private static int nextUserID = 1;
    private static ArrayList<Client> clients = new ArrayList<>();

    public static ArrayList<Client> getClients() {
        return clients;
    }

    public static void addClientToArraylist(Client client) {
        clients.add(client);
        // System.out.println("Client ajouté à la liste. Total clients : " + clients.size());
    }

    public static Gestionnaire createDefaultGestionnaire() {
        Gestionnaire defaultGestionnaire = new Gestionnaire();
        defaultGestionnaire.setUserID(nextUserID++);
        defaultGestionnaire.setFirstName("MOUAD");
        defaultGestionnaire.setLastName("HALLAFFOU");
        defaultGestionnaire.setEmail("mouad@gmail.com");
        defaultGestionnaire.setPassword("1234");
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
        System.out.println("║         CREATION NOUVEAU CLIENT         ║");
        System.out.println("╚═════════════════════════════════════════╝");
        System.out.println();

        Client client = new Client();

        client.setUserID(nextUserID++);
        System.out.println("ID Client assigné : " + client.getUserID());
        System.out.println();

        System.out.print("Prénom du client : ");
        String firstName = scanner.nextLine().trim().toUpperCase();
        while (firstName.isEmpty()) {
            System.out.print("Le prénom ne peut pas être vide. Prénom : ");
            firstName = scanner.nextLine().trim().toUpperCase();
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

        addClientToArraylist(client);

        return client;
    }

    private static boolean hasActiveAccount(Client client) {
        boolean hasActiveAccount = true;
        for (Compte compte : client.getComptes().values()) {
            if (compte.getStatusCompte() == CompteEnums.StatusCompte.ACTIVE) {
                hasActiveAccount = true;
                break;
            }
        }
        return hasActiveAccount;
    }

    public static Client authenticateClient(String email, String password) {
        if (getClients().isEmpty()) {
            System.out.println("Aucun client enregistré dans le système.");
            return null;
        }
        // System.out.println("il existe " + getClients().size() + " clients...");
        for (Client client : getClients()) {
            if (email.equals(client.getEmail())) {

                if (hasActiveAccount(client)) {
                    if (password.equals(client.getPassword())) {
                        String fullname = client.getFirstName() + " " + client.getLastName();
                        System.out.println("╔═════════════════════════════════════════╗");
                        System.out.println("║     WELCOME " + fullname + " to FinBank    ");
                        System.out.println("╚═════════════════════════════════════════╝");
                        System.out.println();
                        System.out.println("Authentification réussie pour : " + client.getFirstName() + " "
                                + client.getLastName());
                        return client;
                    } else {
                        System.err.println("Erreur : Mot de passe incorrect pour l'email : " + email);
                        return null;
                    }
                } else {
                    System.err.println("Erreur : Le client avec l'email " + email + " n'a pas de compte actif.");
                    return null;
                }
            }
        }
        System.err.println("Erreur : Aucun client trouvé avec l'email : " + email);
        return null;
    }

    public static void updateInfo() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║         MODIFIER LES INFORMATIONS       ║");
        System.out.println("╚═════════════════════════════════════════╝");

        System.out.print("Entrez l'email du client à modifier: ");
        String checkedEmail = scanner.nextLine().trim();

        for (Client client : getClients()) {
            if (client.getEmail().equals(checkedEmail)) {
                System.out.print("Nouveau prénom (actuel: " + client.getFirstName() + "): ");
                String newFirstName = scanner.nextLine().trim();
                if (!newFirstName.isEmpty()) {
                    client.setFirstName(newFirstName);
                }

                System.out.print("Nouveau nom (actuel: " + client.getLastName() + "): ");
                String newLastName = scanner.nextLine().trim().toUpperCase();
                if (!newLastName.isEmpty() && Validation.isValidLastName(newLastName)) {
                    client.setLastName(newLastName);
                } else if (!newLastName.isEmpty()) {
                    System.out.println(" Nom invalide. Le nom n'a pas été modifié.");
                }

                System.out.print("Nouvel email (actuel: " + client.getEmail() + "): ");
                String newEmail = scanner.nextLine().trim();
                if (!newEmail.isEmpty() && Validation.isValidEmail(newEmail)) {
                    client.setEmail(newEmail);
                } else if (!newEmail.isEmpty()) {
                    System.out.println(" Email invalide. L'email n'a pas été modifié.");
                }

                System.out.print("Nouveau mot de passe : ");
                String newPassword = scanner.nextLine().trim();
                if (!newPassword.isEmpty()) {
                    client.setPassword(newPassword);
                }

                System.out.println("Informations mises à jour avec succès !");
                return;
            }
        }

        System.err.println("Aucun client trouvé avec cet email.");
    }

    public static void closeCompte() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║            FERMUTURE DE COMPTE          ║");
        System.out.println("╚═════════════════════════════════════════╝");
        System.out.print("entre le nemero de compte a fermme: ");
        String numCompte = scanner.nextLine().trim();

        for (Client client : getClients()) {
            if (client.getComptes().containsKey(numCompte)) {
                System.out.println("are you sure to close this compte ? (yes/no)");
                String confirmation = scanner.nextLine().trim();
                if (confirmation.equals("yes")) {
                    Compte compte = client.getComptes().get(numCompte);
                    compte.setStatusCompte(CompteEnums.StatusCompte.CLOSED);
                    System.out.println("Compte numéro " + numCompte + " fermé avec succès.");
                } else {
                    System.out.println("Fermeture du compte annulée.");
                }
                return;
            }
        }
    }

    public static void consulteReleves() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║           CONSULTE LES RELEVES          ║");
        System.out.println("╚═════════════════════════════════════════╝");

        if (getClients().isEmpty()) {
            System.err.println("Aucun client enregistré dans le système.");
            return;
        }

        System.out.println("Choisissez une option :");
        System.out.println("1. Voir les releves d'un client specifique ?");
        System.out.println("2. Voir les relevees de tous les clients ?");
        System.out.print("Votre choix : ");

        String choix = scanner.nextLine().trim();

        switch (choix) {
            case "1":
                consulteRelevesClient();
                break;
            case "2":
                consulteRelevevesTousClients();
                break;
            default:
                System.err.println("Choix invalide.");
        }
    }

    private static void consulteRelevesClient() {
        System.out.print("Entrez l'email du client : ");
        String email = scanner.nextLine().trim();

        for (Client client : getClients()) {
            if (client.getEmail().equals(email)) {
                System.out.println("\n--- Relevés de " + client.getFirstName() + " " + client.getLastName() + " ---");
                if (client.getComptes().isEmpty()) {
                    System.out.println("Ce client n'a aucun compte.");
                } else {
                    for (Compte compte : client.getComptes().values()) {
                        System.out.println("Compte N: " + compte.getAccountNumber());
                        System.out.println("Type: " + compte.getTypeCompte());
                        System.out.println("Solde: " + compte.getSolde() + " MAD");
                        System.out.println("Historique: " + compte.getHistoriqueTransactions());
                        System.out.println("----------------------------");
                    }
                }
                return;
            }
        }
        System.out.println("Aucun client trouvé avec cet email.");
    }

    private static void consulteRelevevesTousClients() {
        System.out.println("\n--- Relevés de tous les clients ---");
        for (Client client : getClients()) {
            System.out.println(
                    "\nClient: " + client.getFirstName() + " " + client.getLastName() + " (" + client.getEmail() + ")");
            if (client.getComptes().isEmpty()) {
                System.out.println("  Aucun compte");
            } else {
                for (Compte compte : client.getComptes().values()) {
                    System.out.println("  Compte N°: " + compte.getAccountNumber());
                    System.out.println("  Solde: " + compte.getSolde() + " MAD");
                    System.out.println("  Type: " + compte.getTypeCompte());
                }
            }
            System.out.println("----------------------------");
        }
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

}
