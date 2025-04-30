package com.fpt.dom.constant;

public class ValidationConstant {

    private ValidationConstant() {
    }

    public static final String PASSWORD_CHECK = "^(?!.* {2}).{6,}$";
    public static final String EMAIL_CHECK = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    public static final String PHONE_CHECK = "^\\d{10}$";


}
