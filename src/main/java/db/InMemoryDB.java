package db;

import java.util.ArrayList;

public class InMemoryDB {
    private static ArrayList<User> userDatabase = new ArrayList();

    static {
        registerUser(new User("123456789", "Eranga","Bandara","Gampaha",20));
        registerUser(new User("122356789", "Kamal","Bandara","Gampaha",20));
        registerUser(new User("124556789", "Nalin","Bandara","Gampaha",20));
        registerUser(new User("126856789", "Sumana","Bandara","Gampaha",20));
        registerUser(new User("123458889", "Visura","Bandara","Gampaha",20));
    }
    public static User findUser(String nic) {
        for (User user : userDatabase) {
            if (user.getNic().equalsIgnoreCase(nic)) return user;
        }
        return null;
    }

    public static ArrayList<User> findUsers(String query){
        ArrayList<User> searchResult = new ArrayList<>();
        for (User user : userDatabase) {
            if(user.getNic().contains(query) || user.getFirstName().contains(query) || user.getLastName().contains(query) || user.getAddress().contains(query)){
                searchResult.add(user);
            }
        }
        return searchResult;
    }

    public static boolean registerUser(User newUser) {
        /*for (User user : userDatabase) {
            if(user.getNic().equalsIgnoreCase(newUser.getNic())) return false;
        }*/
        if (findUser(newUser.getNic()) != null) return false;
        userDatabase.add(newUser);
        return true;
    }


    public static void removeUser(String nic) {
        /*for (User user : userDatabase) {
            if (user.getNic().equals(nic)){
                userDatabase.remove(user);
                return;
            }
        }*/
        User user = findUser(nic);
        if (user != null) userDatabase.remove(user);
    }

    public static ArrayList<User> getUserDatabase() {
        return userDatabase;
    }

}
