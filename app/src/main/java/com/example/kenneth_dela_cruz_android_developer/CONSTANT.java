package com.example.kenneth_dela_cruz_android_developer;

import java.util.regex.Pattern;

public  class CONSTANT {

    public final String passError = "Password must contains at least 1 special character[ex.@#$%!^&+],at least 5 characters and no white spaces ";

    final Pattern passwordPattern = java.util.regex.Pattern.compile("^" +
            "(?=.*[@#$%^&!+=])" +     // at least 1 special character
            "(?=\\S+$)" +            // no white spaces
            ".{5,}" +                // at least 5 characters
            "$");

}
