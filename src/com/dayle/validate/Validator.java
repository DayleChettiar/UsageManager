package com.dayle.validate;

import javax.servlet.http.HttpServletRequest; 

public class Validator {

    // performs simple validation on add user form
    public boolean validateForm(String userName, String email, String phoneNumber, String usgType, HttpServletRequest request) {

        boolean errorFlag = false;
        boolean userNameError;
        boolean emailError;
        boolean phoneError;
        boolean usgTypeError;

        if (userName == null || userName.equals("") || userName.contains("^[0-9]*$")) {
            errorFlag = true;
            userNameError = true;
            request.setAttribute("userNameError", userNameError);
        }
        if (email == null || email.equals("") || !email.contains("@") || !email.contains(".")) {
            errorFlag = true;
            emailError = true;
            request.setAttribute("emailError", emailError);
        }
        if (phoneNumber == null || phoneNumber.equals("") || phoneNumber.length() < 9 || !phoneNumber.contains("^[0-9-]*$")) {
            errorFlag = true;
            phoneError = true;
            request.setAttribute("phoneError", phoneError);
        }
        if (usgType == null || usgType.equals("") || !usgType.contains("^[A-Z]*$")) {
            errorFlag = true;
            usgTypeError = true;
            request.setAttribute("usgTypeError", usgTypeError);
        }

        return errorFlag;
    }
}
