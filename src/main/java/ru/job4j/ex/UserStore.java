package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (int i = 0; i < users.length; i++) {
            if (login.equals(users[i].getUsername())) {
                user = users[i];
            break;
            }
        }
        if ( user == null) {
            throw new UserNotFoundException("НЕту");
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
boolean valid = false;
if (user.isValid() && user.getUsername().length() >3) {
    valid = true;
}else {
    throw new UserInvalidException("не валидный, прости Господи");
}
return valid;
    }

    public static void main(String[] args)  {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
        User user = findUser(users, "Petr Arsentev");
        if (validate(user)) {
            System.out.println("This user has an access");
        }
        } catch (UserInvalidException ea) {
        ea.printStackTrace();
        } catch (UserNotFoundException ee) {
            ee.printStackTrace();
        }
    }
}