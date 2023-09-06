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
    protected static void addPostText(String loginUser){
        String title = Input.string("Write your post title: ");
        String content = Input.string("Write your post: ");
        Storage.postList.add(new PostText(loginUser, title, content));
    }
    /*
     * Method to add a new image post.
     * */
    protected static void addPostImage(String loginUser){
        String title = Input.string("Write your post title: ");
        int height = Input.integer("Height: ");
        int width = Input.integer("Width: ");
        Storage.postList.add(new PostImage(loginUser, title, height, width));
    }
    /*
     * Method to add a new video post.
     * */
    protected static void addPostVideo(String loginUser){
        String title = Input.string("Write your post title: ");
        int quality = Input.integer("Quality: ");
        int length = Input.integer("Length: ");
        Storage.postList.add(new PostVideo(loginUser, title, quality, length));
    }

    /*
     * Method to add a new comment to a post.
     * */
    protected static void addComment(String loginUser, int postID){
        String comment = Input.string("Write your comment: ");
        Storage.commentList.add(new Comment(loginUser, postID, comment));
    }

    /*
     * Method to delete users from user list.
     * */
    protected static void deleteUser(String name){

        for(Comment c: Storage.commentList){
            if(c.getCommentOwner().toString().equals(name)){
                Storage.commentList.remove(c);
            }
        }
        for(Post p: Storage.postList){
            if(p.getPostOwner().toString().equals(name)){
                Storage.postList.remove(p);
            }
        }
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
    protected static void deletePost(int pt){
        for (Post p: Storage.postList) {
            if (p.postID == pt){
                Storage.postList.remove(p);
                System.out.println("The post was deleted.");
            }
        }
    }
    /*
     * Method to delete comments from comment list.
     * */
    protected static void deleteComment(int cm){
        for (Comment c: Storage.commentList) {
            if (c.commentID == cm){
                Storage.commentList.remove(c);
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
