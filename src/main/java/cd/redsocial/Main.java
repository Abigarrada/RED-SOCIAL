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
            menuChoice = Input.integer("Welcome to RedSocial! \n" +
                    "Select an option to continue: \n" +
                    "1: Register \n" +
                    "2: Log in \n" +
                    "3: Exit \n" +
                    "Enter one number below to continue... \n");
            switch (menuChoice)
            {
                case 1:
                    String createUser = Input.string("Enter your username: ");
                    User newUser = new User(createUser);
                    Storage.addUserToList(newUser);
                    break;
                case 2:
                    String loginUser = Input.string("Enter your username: ");
                    for (User u: Storage.userList) {
                        if (u.getUsername().equals(loginUser)){
                            int loginMenu;
                            do {
                                loginMenu = Input.integer("Welcome, " + loginUser + "!\n" +
                                        "Select one action: \n" +
                                        "1: Add new post \n" +
                                        "2: Add new comment \n" +
                                        "3: Show user's list \n" +
                                        "4: Show total number of users \n" +
                                        "5: Show posts list \n" +
                                        "6: Show total number of posts \n" +
                                        "7: Show comments list \n" +
                                        "8: Show total number of comments \n" +
                                        "9: Delete user \n" +
                                        "10: Go back \n");
                                switch (loginMenu) {
                                    case 1:
                                        int pType;
                                        do {
                                            pType = Input.integer("Select post type: \n" +
                                                    "1: Text \n" +
                                                    "2: Image \n" +
                                                    "3: Video \n" +
                                                    "4: Go back");
                                            switch (pType) {
                                                case 1:
                                                    Storage.addPostText(loginUser);
                                                    break;
                                                case 2:
                                                    Storage.addPostImage(loginUser);
                                                    break;
                                                case 3:
                                                    Storage.addPostVideo(loginUser);
                                                    break;
                                                case 4:
                                                    break;
                                                default:
                                                    System.out.println("You must choose a value between 1 and 3.");
                                            }
                                        }while (pType != 4);
                                        break;
                                    case 2:
                                        int postID = 0;
                                        for (Post p: Storage.postList) {
                                            postID++;
                                            System.out.println("Post ID: " + postID);
                                            System.out.println(p);
                                        }
                                        System.out.println("Select a post to create a comment: ");
                                        Storage.addComment(loginUser, postID);
                                        break;
                                    case 3:
                                        Storage.getUserList();
                                        break;
                                    case 4:
                                        System.out.println(User.getCountUsers());
                                        break;
                                    case 5:
                                        Storage.getPostList();
                                        break;
                                    case 6:
                                        System.out.println(Post.getCountPost());
                                        break;
                                    case 7:
                                        Storage.getCommentList();
                                        break;
                                    case 8:
                                        System.out.println(Comment.getCountComment());
                                        break;
                                    case 9:
                                        String dUser = Input.string("Confirm your username to delete the account: ");
                                        Storage.deleteUser(dUser);
                                        break;
                                    case 10:
                                        break;
                                }
                            }while (loginMenu != 10);
                        } else{
                            System.out.println("First register to log in.");
                        }
                    }
                case 3:
                    break;
                default:
                    System.out.println("You must choose a value between 1 and 3.");
            }
        } while (menuChoice != 3);

    }
}
