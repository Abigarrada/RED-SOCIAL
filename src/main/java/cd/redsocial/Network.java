package cd.redsocial;

import java.util.*;

public class Network {

    protected static List<User> userList = new ArrayList<>();
    protected static List<Post> postList = new ArrayList<>();
    protected static List<Comment> commentList = new ArrayList<>();

    protected String username;

    protected Network(String username) {
        if (username.trim().isEmpty()) {
            System.out.println("You must introduce a valid username.");
        } else {
            this.username = username.toLowerCase();
        }
    }

    /*
     * Method to get the current user's username.
     * */
    protected String getUsername() {

        return username;
    }

}
