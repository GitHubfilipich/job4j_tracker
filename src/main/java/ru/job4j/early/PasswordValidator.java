package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (password.toLowerCase().equals(password)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (password.toUpperCase().equals(password)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        for (int i = 0;; i++) {
            if (Character.isDigit(password.charAt(i))) {
                break;
            }
            if (i == password.length() - 1) {
                throw new IllegalArgumentException("Password should contain at least one figure");
            }
        }
        for (int i = 0;; i++) {
            if (!Character.isLetterOrDigit(password.charAt(i)) && !Character.isWhitespace(password.charAt(i))) {
                break;
            }
            if (i == password.length() - 1) {
                throw new IllegalArgumentException("Password should contain at least one special symbol");
            }
        }
        if (password.toUpperCase().contains("QWERTY")
                || password.contains("12345")
                || password.toUpperCase().contains("PASSWORD")
                || password.toUpperCase().contains("ADMIN")
                || password.toUpperCase().contains("USER")) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }
}
