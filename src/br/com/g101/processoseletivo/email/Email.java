package br.com.g101.processoseletivo.email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private String email;

    public Email() {
    }

    public Email(String email) {
        if (email.isEmpty() || email.isBlank() && email.trim().length() < 2) {
            throw new IllegalArgumentException("Email inválido");
        }

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Email inválido");
        }

        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
