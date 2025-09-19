package main.java.utils;

public class Validation {

    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }

    public static boolean isValidFirstName(String firstName) {
        return firstName != null && !firstName.trim().isEmpty();
    }

    public static boolean isValidLastName(String lastName) {
        return lastName != null && !lastName.trim().isEmpty();
    }

    public static boolean isPositifSolde(Double solde) {
        return solde != null && solde > 0;
    }

    public static boolean CompareSolde(Double soldeCompte , Double depositSolde) {
        return soldeCompte > 0 && depositSolde > 0 && soldeCompte >= depositSolde;
    }

}
