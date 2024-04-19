package com.example.neo_tour.util;

public class PhoneNumberAlreadyUsedException extends RuntimeException{
    public PhoneNumberAlreadyUsedException(String phoneNumberAlreadyUsed) {
        super(phoneNumberAlreadyUsed);
    }
}
