package com.hospital.exception;

public class InvalidPatientNameException extends Exception{
    
    public InvalidPatientNameException(String message)
    {
        super(message);
    }
}
