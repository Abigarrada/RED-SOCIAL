package cd.redsocial;

import java.util.*;


/*
 * Class to handle comments.
 * Must contain a text, date and owner.
 * Comments must be related to a post.
 * Comments can be created, listed and deleted.
 */

public class Comment /*extends Post*/ {
    protected Calendar commentDate;
    protected User owner;
    protected String commentText;
    private static int countComments = 0;
    protected Post refersTo; //TODO: clarify the post one comment refers to

    /*
     * Comment class constructor.
     * Needs a username and post, gets date/time from system and adds an element to the count of posts.
     * */
    protected Comment(String username, String commentText) {

        this.commentDate = Calendar.getInstance();
        this.commentText = commentText;
        // commentList.add(commentText);
        countComments++;
    }

    public Calendar getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Calendar commentDate) {
        this.commentDate = commentDate;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public static int getCountComment() {
        return countComments;
    }
}
