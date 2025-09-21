package main.java.interfaces;

import main.java.models.Client;
import main.java.models.Compte;

public interface IBanqueService {
    void Deposit();
    void Withdraw() throws Exception;
    void Transfer();
    Compte createCompteForClient(Client client);
}
