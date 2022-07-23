package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UsersStorage {

    private static final HashMap<Integer, User> users = new HashMap<>();

    public static List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    public static void addUser(User user) {
        users.put(user.getId(), user);
        System.out.println("User is successful added");
    }

    public static User getUserById(int id) {
        return users.get(id);
    }

    public static void printAllUsers() {
        //System.out.println("List of all users:");
        for (Integer userId : users.keySet()) {
            System.out.println(userId + " " + users.get(userId));
        }
    }

    public static void deleteUser(User user) {
        users.remove(user.getId());
    }
}
