package main.java.interfaces;

import main.java.models.Client;

public interface IClientService {
    boolean authenticationClient();
    Client getAuthenticatedClient();
}
