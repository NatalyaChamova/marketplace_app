package main.java;

public class RequiredFieldInvalidException extends RuntimeException {
    public RequiredFieldInvalidException(String fieldName) {
        super(fieldName + " is invalid");
    }
}
