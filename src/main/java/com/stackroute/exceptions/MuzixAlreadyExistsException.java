/**
 * Custom Exception created here
 */
package com.stackroute.exceptions;

public class MuzixAlreadyExistsException extends Exception {

    //Message variable
    private String message;

    //Empty Constructor
    public MuzixAlreadyExistsException() {
    }

    //Parameterized constructor
    public MuzixAlreadyExistsException(String message) {
        this.message = message;
    }
}
