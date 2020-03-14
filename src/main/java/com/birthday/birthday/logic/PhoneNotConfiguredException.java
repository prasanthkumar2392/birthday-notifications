package com.birthday.birthday.logic;

public class PhoneNotConfiguredException extends RuntimeException {
    public PhoneNotConfiguredException(Exception e) {
        super(e);
    }
}
