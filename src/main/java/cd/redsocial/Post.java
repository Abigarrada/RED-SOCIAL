package cd.redsocial;

import java.util.*;

/*
 * Abstract class to create posts.
 * Extends users.
 * Posts can be text, image or video.
 * Must contain date and comment list.
 * Posts can be created, listed and deleted.
 * Must contain the number of comments created per post.
 */

public abstract class Post {
    protected int postID;
    protected User postOwner;
    protected Date postDate;
    protected String postType;
    protected static int countPost = 0;

    /*
     * Post class constructor.
     * Needs a username, gets date from system and adds an element to the count of posts.
     * */
    protected Post(String username){
        for (User u: Storage.userList) {
            if (u.getUsername().equals(username)){
                this.postOwner = u;
            }
        }
        this.postID = countPost;
        this.postDate = new Date();
        countPost++;
    }


    /*
     * Method to get one post's ID.
     * */
    public int getPostID() {
        return postID;
    }
    /*
     * Method to get one post's owner.
     * */
    public User getPostOwner() {

        return postOwner;
    }
    /*
     * Method to get the total number of posts created.
     * */
    public static int getCountPost() {

        return countPost;
    }


}
