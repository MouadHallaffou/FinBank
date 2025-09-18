package main.java.models;

import java.util.ArrayList;
import main.java.services.GestionnaireService;

public class Gestionnaire extends User {
    private ArrayList<User> gestionnaires = new ArrayList<>();

    public Gestionnaire(int userID, String firstName, String lastName, String email, String password) {
        super(userID, firstName, lastName, email, password);
    }

    public Gestionnaire() {
    }

    public ArrayList<User> getGestionnaires() {
        return gestionnaires;
    }

    public void setGestionnaires(ArrayList<User> gestionnaires) {
        this.gestionnaires = gestionnaires;
    }

    public void addGestionnaire() {
        GestionnaireService gestionnaireController = new GestionnaireService();
        gestionnaires.add(gestionnaireController.createNewGestionnaire());
    }

}
