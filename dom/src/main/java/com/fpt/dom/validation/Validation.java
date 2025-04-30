package com.fpt.dom.validation;

import com.fpt.dom.constant.ValidationConstant;

public class Validation {


    public static boolean checkPassword(String password) {
        return password.matches(ValidationConstant.PASSWORD_CHECK);
    }

    public static boolean checkEmail(String email) {
        return  email.matches(ValidationConstant.EMAIL_CHECK);
    }

    public static boolean checkPhone(String phone) {
        return  phone.matches(ValidationConstant.PHONE_CHECK);
    }

}
