package cd.redsocial;

import util.Input;

import java.util.*;

/*
 * Class to handle users.
 * Must contain username, following users's list, post's list and comment's list.
 * Users can be created, listed and deleted.
 * One user can follow/unfollow another user.
 */

public class User {
    protected String username;
    protected static List<User> userList = new ArrayList<>();
    protected static List<Post> postList = new ArrayList<>();
    protected static List<String> commentList = new ArrayList<>();
    protected List<String> followingList = new ArrayList<>();
    protected List<String> followersUserList = new ArrayList<>();
    private static int countUsers = 0;
    Scanner sc = new Scanner(System.in);

    /*
     * User class constructor.
     * Verifies if username is not empty.
     * Needs a username and adds an element to the count of users.
     * */
    protected User(String username) {
        if(username.trim().isEmpty()){
            System.out.println("You must introduce a valid username.");
        } else{
            this.username = username.toLowerCase();
            countUsers++;
        }
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
        postList.add(new PostImage(this.getUsername(), title, quality, length));
    }
    /*
     * Method to add a new comment to a post.
     * */
    protected void addComment(){
        String comment = Input.string("Write your comment: ");
        postList.add(new Comment(this.getUsername(), comment));
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
     * Method to get the list of users.
     * */
    protected static void getUserList() {
        for (String u: userList) {
            System.out.println(u);
        }
    }
    /*
     * Method to get the list of posts made by the current user.
     * */
    protected static void getPostList() {
        for (String p: postList) {
            System.out.println(p);
        }
    }
    /*
     * Method to get the list of comments made by the current user.
     * */
    protected static void getCommentList() {
        for (String c: commentList) {
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
        int count = 0;
        for (String u: userList) {
            count++;
            if (u.equals(name)){
                userList.remove(count);
                System.out.println("The user " + name + " was deleted succesfully.");
            }
        }
    }
    /*
     * Method to delete posts from post list.
     * */
    protected void deletePost(String pt){ //TODO: this returns an error, must be modified
        for (String p: postList) {
            if (p.equals(pt)){
                postList.remove(pt);
                System.out.println("The post " + pt + "was deleted succesfully.");
            }
        }
    }
    /*
     * Method to delete comments from comment list.
     * */
    protected void deleteComment(String cm){ //TODO: this returns an error, must be modified
        for (String c: commentList) {
            if (c.equals(cm)){
                commentList.remove(cm);
                System.out.println("The post " + cm + "was deleted succesfully.");
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
                    System.out.println("The user " + name + " was deleted succesfully from your following list.");
                }
            }
        } catch (Exception e) {
            throw new ConcurrentModificationException(e);
        }

    }


}
