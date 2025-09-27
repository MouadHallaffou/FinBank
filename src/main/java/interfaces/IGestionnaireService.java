package main.java.interfaces;

import java.util.ArrayList;

import main.java.models.Client;

public interface IGestionnaireService {
    ArrayList<Client> getClients();
    void addClient(Client client);
    Client createClient();
    boolean authenticateGestionnaire(String email, String password);
}
