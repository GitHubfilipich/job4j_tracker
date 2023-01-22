package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User foundUser = null;
        for (User u: users) {
            if (u != null && u.getUsername().equals(login)) {
                foundUser = u;
                break;
            }
        }
        if (foundUser == null) {
            throw new UserNotFoundException("User not found");
        }
        return foundUser;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user == null || !user.isValid()) {
            throw new UserInvalidException("Not valid user");
        }
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("Less than 3 symbols");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ie) {
            System.out.println("User not valid");
        } catch (UserNotFoundException ne) {
            System.out.println("User not found");
        }

    }
}
