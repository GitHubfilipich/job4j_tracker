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
        boolean containFigure = false;
        boolean containSpecialSymbol = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                containFigure = true;
            }
            if (!Character.isLetterOrDigit(password.charAt(i)) && !Character.isWhitespace(password.charAt(i))) {
                containSpecialSymbol = true;
            }
            if (containFigure && containSpecialSymbol) {
                break;
            }
        }
        if (!containFigure) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!containSpecialSymbol) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        String[] words = {"QWERTY", "12345", "PASSWORD", "ADMIN", "USER"};
        for (String word : words) {
            if (password.toUpperCase().contains(word)) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }
        return password;
    }
}
