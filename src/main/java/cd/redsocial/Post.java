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

public abstract class Post extends User {
    protected Calendar postDate;
    protected String postType;
    protected static int countPost = 0;

    /*
     * Post class constructor.
     * Needs a username, gets date/time from system and adds an element to the count of posts.
     * */
    protected Post(String username){
        super(username);
        this.postDate = Calendar.getInstance();
        countPost++;
    }

    /*
     * Method to get the total number of posts created.
     * */
    public static int getCountPost() {
        return countPost;
    }


}
