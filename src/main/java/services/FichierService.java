package main.java.services;

import java.util.Scanner;

import main.java.models.Client;
import main.java.models.Compte;
import main.java.models.Transaction;

public class FichierService {
    private static Scanner scanner = new Scanner(System.in);

    public static void genererReleve() {
        //
    }

    public static void consulteReleves() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║           CONSULTE LES RELEVES          ║");
        System.out.println("╚═════════════════════════════════════════╝");

        System.out.print("entre votre nemero de compte: ");
        String nemuroCmpte = scanner.next().trim();
        Client client = new Client();
        boolean compteFound = false;
  
        for (Compte compte : client.getComptes().values()) {
            if (compte.getAccountNumber().equals(nemuroCmpte)) {
                compteFound = true;
                System.out.println("  Compte N : " + compte.getAccountNumber());
                System.out.println("  Solde: " + compte.getSolde() + " MAD");
                System.out.println("  Type: " + compte.getTypeCompte());
                
                if (compte.getHistoriqueTransactions().isEmpty()) {
                    System.out.println("aucun transactions effectue!");
                } else {
                    for (Transaction trans : compte.getHistoriqueTransactions()) {
                        System.out.println("----------------------------");
                        System.out.println("idTranction: " + trans.getIdTranction());
                        System.out.println("Type: " + trans.getType());
                        System.out.println("Montant: " + trans.getMontant() + " MAD");
                        System.out.println("Date: " + trans.getDateTransaction());
                        System.out.println("----------------------------");
                    }
                }
                break;
            }
        }
        
        if (!compteFound) {
            System.err.println("nemuroCmpte de compte incorecte !");
        }

    }

}
