package main.java.controllers;

import main.java.models.Client;
import main.java.models.User;

import java.util.Scanner;

public class ClientController {
    private static Scanner scanner = new Scanner(System.in);

    public static void Deposit() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║            DEPÔT D'ARGENT               ║");
        System.out.println("╚═════════════════════════════════════════╝");
    }

    public static void Withdraw() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║           RETRAIT D'ARGENT              ║");
        System.out.println("╚═════════════════════════════════════════╝");
    }

    public static void Transfer() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║             VIREMENT                    ║");
        System.out.println("╚═════════════════════════════════════════╝");
    }


}
