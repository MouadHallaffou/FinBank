package main.java.models;

import java.util.HashMap;

public class Client extends User {
    private HashMap<String, Compte> comptes = new HashMap<>();

    public Client(int userID, String firstName, String lastName, String email, String password,
            HashMap<String, Compte> comptes) {
        super(userID, firstName, lastName, email, password);
        this.comptes = comptes;
    }

    public Client() {
    }

    public void setComptes(HashMap<String, Compte> comptes) {
        this.comptes = comptes;
    }

    public HashMap<String, Compte> getComptes() {
        return comptes;
    }
    @Override
    public User login(String email, String password) {
        if (this.email.equals(email) && this.password.equals(password)) {
            return this;
        }
        return null;
    }
}
