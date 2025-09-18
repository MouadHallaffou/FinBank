package main.java.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Client extends User {
    private ArrayList<User> clients = new ArrayList<>();
    private HashMap<String, Compte> comptes = new HashMap<>();

    public Client(int userID, String firstName, String lastName, String email, String password, ArrayList<User> clients,
            HashMap<String, Compte> comptes) {
        super(userID, firstName, lastName, email, password);
        this.clients = clients;
        this.comptes = comptes;
    }

    public Client() {
    }

    public void setClients(ArrayList<User> clients) {
        this.clients = clients;
    }

    public void setComptes(HashMap<String, Compte> comptes) {
        this.comptes = comptes;
    }

    public ArrayList<User> getClients() {
        return clients;
    }

    public HashMap<String, Compte> getComptes() {
        return comptes;
    }

    public void addClient(User client) {
        clients.add(client);
    }

}
