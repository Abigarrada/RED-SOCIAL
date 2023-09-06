package cd.redsocial;

import util.Input;

import java.util.*;

/*
 * Abstract class to create posts.
 * Extends users.
 * Posts can be text, image or video.
 * Must contain date and comment list.
 * Posts can be created, listed and deleted.
 * Must contain the number of comments created per post.
 */

public abstract class Post extends Network {
    protected int postID;
    protected User postOwner;
    protected Calendar postDate;
    protected String postType;
    protected static int countPost = 0;

    /*
     * Post class constructor.
     * Needs a username, gets date/time from system and adds an element to the count of posts.
     * */
    protected Post(String username){
        super(username);
        for (User u: userList) {
            if (u.getUsername().equals(username)){
                this.postOwner = u;
            }
        }
        this.postID = countPost;
        this.postDate = Calendar.getInstance();
        countPost++;
    }

    /*
     * Method to add a new comment to a post.
     * */
    protected void addComment(){
        String comment = Input.string("Write your comment: ");
        commentList.add(new Comment(this.getUsername(), this.getPostID(), comment));
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
