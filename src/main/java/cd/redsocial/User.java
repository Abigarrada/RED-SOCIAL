package cd.redsocial;

import util.Input;

import java.util.*;

/*
 * Class to handle users.
 * Must contain username, following users' list, post's list and comment's list.
 * Users can be created, listed and deleted.
 * One user can follow/unfollow another user.
 */

public class User extends Network {
    protected List<String> followingList = new ArrayList<>();
    protected List<String> followersUserList = new ArrayList<>();
    protected static int countUsers = 0;
    Scanner sc = new Scanner(System.in);

    /*
     * User class constructor.
     * Verifies if username is not empty.
     * Needs a username and adds an element to the count of users.
     * */
    protected User(String username) {
        super(username);
        countUsers++;
    }

    /*
     * Method to add a new user to the users list.
     * */
    protected static void addUserToList(User u){
        userList.add(u);
    }
    /*
     * Method to add a new text post.
     * */
    protected void addPostText(){
        String content = Input.string("Write your post: ");
        postList.add(new PostText(this.getUsername(), content));
    }
    /*
     * Method to add a new image post.
     * */
    protected void addPostImage(){
        String title = Input.string("Write your post title: ");
        int height = Input.integer("Height: ");
        int width = Input.integer("Width: ");
        postList.add(new PostImage(this.getUsername(), title, height, width));
    }
    /*
     * Method to add a new video post.
     * */
    protected void addPostVideo(){
        String title = Input.string("Write your post title: ");
        int quality = Input.integer("Quality: ");
        int length = Input.integer("Length: ");
        postList.add(new PostVideo(this.getUsername(), title, quality, length));
    }
    /*
     * Method to change the current user's username.
     * */
    protected void setUsername(String username) {
        username = Input.string("Select a new username: ");
        this.username = username;
    }
    /*
     * Method to get the list of users.
     * */
    protected static void getUserList() {
        for (User u: userList) {
            System.out.println(u.getUsername());
        }
    }
    /*
     * Method to get the list of posts made by the current user.
     * */
    protected static void getPostList() {
        for (Post p: postList) {
            System.out.println(p);
        }
    }
    /*
     * Method to get the list of comments made by the current user.
     * */
    protected static void getCommentList() {
        for (Comment c: commentList) {
            System.out.println(c);
        }
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
     * Method to get the total users of posts created.
     * */
    public static int getCountUsers() {

        return countUsers;
    }
    /*
     * Method to delete users from user list.
     * */
    protected static void deleteUser(String name){

        for (User u: userList) {
            if (u.getUsername().equals(name)){
                userList.remove(u);
                System.out.println("The user was deleted.");
            }
        }
    }
    /*
     * Method to delete posts from post list.
     * */
    protected void deletePost(String pt){
        int count = 0;
        for (Post p: postList) {
            count++;
            if (p.equals(pt)){
                postList.remove(count);
                System.out.println("The post was deleted.");
            }
        }
    }
    /*
     * Method to delete comments from comment list.
     * */
    protected void deleteComment(String cm){ //TODO: this returns an error, must be modified
        int count = 0;
        for (Comment c: commentList) {
            count++;
            if (c.equals(cm)){
                commentList.remove(count);
                System.out.println("The comment was deleted.");
            }
        }
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
