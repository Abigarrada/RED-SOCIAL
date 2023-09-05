package cd.redsocial;

import util.Input;

import java.util.*;

/*
 * Main class with menu options.
 * */

public class Main {
    public static void main(String[] args) {

        int menuChoice;

        /*
         * Menu display by console.
         */
        do {
            menuChoice = Input.integer("Select an option: \n" +
                    "1: create new user \n" +
                    "2: create new post \n" +
                    "3: create new comment \n" +
                    "4: delete an user \n" +
                    "5: show user's list \n" +
                    "6: show total number of users \n" +
                    "7: show posts list \n" +
                    "8: show total number of posts \n" +
                    "9: show comments list \n" +
                    "10: show total number of comments \n" +
                    "11: exit \n" +
                    "Enter one number below to continue...\n");
            switch (menuChoice)
            {
                case 1:
                    String createUser = Input.string("Enter your username: ");
                    User newUser = new User(createUser);
                    User.addUserToList(newUser);
                    break;
                case 2:
                    int pType = Input.integer("Select post type: " +
                            "1: Text \n" +
                            "2: Image \n" +
                            "3: Video \n");
                        switch (pType) {
                            case 1:
                               // addPostText();
                                break;
                            case 2:
                               // addPostImage();
                            case 3:
                                // addPostVideo();
                            default:
                                System.out.println("You must choose a value between 1 and 3.");
                        }
                    break;
                case 3:
                    System.out.println("Enter your username: ");
                    String userC = sc.nextLine();
                    System.out.println("Create your comment: ");
                    String cContent = sc.nextLine();
                    Comment newComment = new Comment(userC, cContent);
                    break;
                case 4:
                    System.out.println("Enter the username you want to delete: ");
                    String dUser = sc.nextLine();
                    User.deleteUser(dUser);
                    break;
                case 5:
                    User.getUserList();
                    break;
                case 6:
                    User.getCountUsers();
                    break;
                case 7:
                    User.getPostList();
                    break;
                case 8:
                    Post.getCountPost();
                    break;
                case 9:
                    User.getCommentList();
                    break;
                case 10:
                    Comment.getCountComment();
                    break;
                case 11:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("You must choose a value between 1 and 11.");
            }
        } while (menuChoice != 11);


    }
}
