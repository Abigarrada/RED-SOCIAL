package cd.redsocial;

import util.Input;

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
                    "Enter one number below to continue... \n");
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
                                //addPostText();
                                break;
                            case 2:
                                //addPostImage();
                                break;
                            case 3:
                                //addPostVideo();
                                break;
                            default:
                                System.out.println("You must choose a value between 1 and 3.");
                        }
                    break;
                case 3:
                    //addComment();
                    break;
                case 4:
                    String dUser = Input.string("Enter the username you want to delete: ");
                    User.deleteUser(dUser);
                    break;
                case 5:
                    User.getUserList();
                    break;
                case 6:
                    System.out.println(User.getCountUsers());
                    break;
                case 7:
                    User.getPostList();
                    break;
                case 8:
                    System.out.println(Post.getCountPost());
                    break;
                case 9:
                    User.getCommentList();
                    break;
                case 10:
                    System.out.println(Comment.getCountComment());
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
