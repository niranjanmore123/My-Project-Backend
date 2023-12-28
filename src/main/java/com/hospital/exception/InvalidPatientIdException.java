package com.hospital.exception;

public class InvalidPatientIdException extends Exception{
    
    public InvalidPatientIdException(String message)
    {
        super(message);
    }
}