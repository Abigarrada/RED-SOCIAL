package cd.redsocial;

import java.util.*;

/*
 * Abstract class to handle posts.
 * Must contain date and comment list.
 * Posts can be text, image or video.
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
        /*
        if(postType.equals("Text")){
            this.postType = "Text";
            this.postDate = Calendar.getInstance();
            this.postContent = postContent;
            postList.add(postContent);
            countPost++;
        } if(postType.equals("Image")){
            this.postType = "Image";
            this.postDate = Calendar.getInstance();
            this.postContent = postContent;
            postList.add(postContent);
            countPost++;
        } if(postType.equals("Video")){
            this.postType = "Video";
            this.postDate = Calendar.getInstance();
            this.postContent = postContent;
            postList.add(postContent);
            countPost++;
        } else {
            System.out.println("Select a valid post type: Text/Image/Video.");;
        }*/
    }

    /*
     * Method to get the total number of posts created.
     * */
    public static int getCountPost() {
        return countPost;
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

}
