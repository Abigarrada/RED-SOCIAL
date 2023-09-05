package cd.redsocial;

import java.util.*;


/*
 * Class to handle users.
 * Must contain username, following users's list, post's list and comment's list.
 * Users can be created, listed and deleted.
 * One user can follow/unfollow another user.
 */

public class User {
    protected String username;
    protected static List<String> userList = new ArrayList<>();
    protected static List<String> postList = new ArrayList<>();
    protected static List<String> commentList = new ArrayList<>();
    protected List<String> followingList = new ArrayList<>();
    protected List<String> followersUserList = new ArrayList<>();
    private static int countUsers = 0;
    Scanner sc = new Scanner(System.in);

    protected User(String username) {
        if(username.trim().equals("")){
            this.username = setUsername(username);
            userList.add(countUsers, username);
            countUsers++;
            System.out.println("User " + username + " was created succesfully.");
        } else{
            System.out.println("You must introduce a valid username.");
        }
    }

    protected String getUsername() {
        return username;
    }
    protected String setUsername(String username) {
        username = sc.nextLine();
        this.username = username;
        return this.username;
    }
    protected static void getUserList() {
        for (String u: userList) {
            System.out.println(u);
        }
    }
    protected static void getPostList() {
        for (String p: postList) {
            System.out.println(p);
        }
    }
    protected static void getCommentList() {
        for (String c: commentList) {
            System.out.println(c);
        }
    }
    protected void getFollowingList() {
        for (String f: followingList) {
            System.out.println(f);
        }
    }
    protected void getFollowersUserList() {
        for (String fs: followersUserList) {
            System.out.println(fs);
        }
    }
    public static int getCountUsers() {
        return countUsers;
    }
    protected static void deleteUser(String name){
        int count = 0;
        for (String u: userList) {
            count++;
            if (u.equals(name)){
                userList.remove(count);
                System.out.println("The user " + name + " was deleted succesfully.");
            }
        }
    }
    protected void followUser(String name){
        followingList.add(name);
        System.out.println("You're now following " + name);
    }
    protected void removeFollowedUser(String name){
        int i = 0;
        try {
            for (String ff: followingList) {
                i++;
                if (ff.equals(name)){
                    followingList.remove(i);
                    System.out.println("The user " + name + " was deleted succesfully from your following list.");
                }
            }
        } catch (Exception e) {
            throw new ConcurrentModificationException(e);
        }

    }



}
