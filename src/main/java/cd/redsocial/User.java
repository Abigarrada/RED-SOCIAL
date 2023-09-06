package cd.redsocial;

import util.Input;

import java.util.*;

/*
 * Class to handle users.
 * Must contain username, following users' list, post's list and comment's list.
 * Users can be created, listed and deleted.
 * One user can follow/unfollow another user.
 */

public class User{

    protected String username;
    protected List<String> followingList = new ArrayList<>();
    protected List<String> followersUserList = new ArrayList<>();
    protected static int countUsers = 0;

    /*
     * User class constructor.
     * Verifies if username is not empty.
     * Needs a username and adds an element to the count of users.
     * */
    protected User(String username) {
        if (username.trim().isEmpty()) {
            System.out.println("You must introduce a valid username.");
        } else {
            this.username = username.toLowerCase();
            countUsers++;
        }
    }

    /*
     * Method to get the current user's username.
     * */
    protected String getUsername() {

        return username;
    }
    /*
     * Method to change the current user's username.
     * */
    protected void setUsername(String username) {
        username = Input.string("Select a new username: ");
        this.username = username;
    }

    /*
     * Method to get the list of users followed by the current user.
     * */
    protected void getFollowingList() {
        for (String f: followingList) {
            System.out.println(f);
        }
    }
    /*
     * Method to get the total of users created.
     * */
    public static int getCountUsers() {

        return countUsers;
    }

    /*
     * Method to add a new user to the current user's following list.
     * */
    protected void followUser(String name){
        followingList.add(name);
        System.out.println("You're now following " + name);
    }
    /*
     * Method to delete a new user to the current user's following list.
     * */
    protected void removeFollowedUser(String name){
        int i = 0;
        try {
            for (String ff: followingList) {
                i++;
                if (ff.equals(name)){
                    followingList.remove(i);
                    System.out.println("The user " + name + " was deleted from your following list.");
                }
            }
        } catch (Exception e) {
            throw new ConcurrentModificationException(e);
        }

    }


}
