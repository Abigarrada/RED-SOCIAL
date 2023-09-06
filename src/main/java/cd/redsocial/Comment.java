package cd.redsocial;

import java.util.*;

/*
 * Class to handle comments.
 * Must contain a text, date and owner.
 * Comments must be related to a post.
 * Comments can be created, listed and deleted.
 */

public class Comment {
    protected int commentID;
    protected Calendar commentDate;
    protected User commentOwner;
    protected String commentText;
    private static int countComments = 0;
    protected Post refersTo;

    /*
     * Comment class constructor.
     * Needs a username (owner) and post(refersTo), gets date/time from system and adds an element to the count of comments.
     * */
    protected Comment(String username, int postID, String commentText) {
        for (User u: Storage.userList) {
            if (u.getUsername().equals(username)){
                this.commentOwner = u;
            }
        }
        for (Post p: Storage.postList) {
            if (p.getPostID() == postID){
                this.refersTo = p;
            }
        }
        this.commentDate = Calendar.getInstance();
        this.commentText = commentText;
        this.commentID = countComments;
        countComments++;
    }

    /*
     * Method to get one comment's owner.
     * */
    public User getCommentOwner() {

        return commentOwner;
    }
    /*
     * Method to set the owner of a comment.
     * */
    public void setCommentOwner(User owner) {

        this.commentOwner = owner;
    }
    /*
     * Method to get the content of a post.
     * */
    public String getCommentText() {

        return commentText;
    }
    /*
     * Method to get the total number of comments created.
     * */
    public static int getCountComment() {

        return countComments;
    }
}
