package cd.redsocial;

import util.Input;

import java.util.*;

public class Storage {

    protected static List<User> userList = new ArrayList<>();
    protected static List<Post> postList = new ArrayList<>();
    protected static List<Comment> commentList = new ArrayList<>();

    /*
     * Method to add a new user to the users list.
     * */
    protected static void addUserToList(User u){

        Storage.userList.add(u);
    }
    /*
     * Method to add a new text post.
     * */
    protected void addPostText(){
        String content = Input.string("Write your post: ");
        Storage.postList.add(new PostText(getUsername(), content));
    }
    /*
     * Method to add a new image post.
     * */
    protected void addPostImage(){
        String title = Input.string("Write your post title: ");
        int height = Input.integer("Height: ");
        int width = Input.integer("Width: ");
        Storage.postList.add(new PostImage(getUsername(), title, height, width));
    }
    /*
     * Method to add a new video post.
     * */
    protected void addPostVideo(){
        String title = Input.string("Write your post title: ");
        int quality = Input.integer("Quality: ");
        int length = Input.integer("Length: ");
        Storage.postList.add(new PostVideo(getUsername(), title, quality, length));
    }

    /*
     * Method to add a new comment to a post.
     * */
    protected void addComment(){
        String comment = Input.string("Write your comment: ");
        Storage.commentList.add(new Comment(getUsername(), getPostID(), comment));
    }

    /*
     * Method to delete users from user list.
     * */
    protected static void deleteUser(String name){

        for (User u: Storage.userList) {
            if (u.getUsername().equals(name)){
                Storage.userList.remove(u);
                System.out.println("The user was deleted.");
            }
        }
    }
    /*
     * Method to delete posts from post list.
     * */
    protected void deletePost(String pt){
        int count = 0;
        for (Post p: Storage.postList) {
            count++;
            if (p.equals(pt)){
                Storage.postList.remove(count);
                System.out.println("The post was deleted.");
            }
        }
    }
    /*
     * Method to delete comments from comment list.
     * */
    protected void deleteComment(String cm){ //TODO: this returns an error, must be modified
        int count = 0;
        for (Comment c: Storage.commentList) {
            count++;
            if (c.equals(cm)){
                Storage.commentList.remove(count);
                System.out.println("The comment was deleted.");
            }
        }
    }
    /*
     * Method to get the list of users.
     * */
    protected static void getUserList() {
        for (User u: Storage.userList) {
            System.out.println(u.getUsername());
        }
    }
    /*
     * Method to get the list of posts made by the current user.
     * */
    protected static void getPostList() {
        for (Post p: Storage.postList) {
            System.out.println(p);
        }
    }
    /*
     * Method to get the list of comments made by the current user.
     * */
    protected static void getCommentList() {
        for (Comment c: Storage.commentList) {
            System.out.println(c);
        }
    }


}
