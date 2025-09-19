package main.java.exception;

public class InsufisantSoldeException extends Exception{

    public void throwCheckedException() throws Exception {
        throw new Exception("This is a checked exception");
    }
    
}
