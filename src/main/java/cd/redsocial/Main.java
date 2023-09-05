package cd.redsocial;

import java.util.*;

/*
 * Main class with menu options.
 * */

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int menuChoice;

        /*
         * Menu display by console.
         */
        do {
            System.out.println("Select an option: \n" +
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
            menuChoice = sc.nextInt();
            switch (menuChoice)
            {
                case 1:
                    System.out.println("Enter your username: ");
                    String createUser = sc.nextLine();
                    User newUser = new User(createUser);
                    break;
                case 2:
                    System.out.println("Enter your username: ");
                    String userP = sc.nextLine();
                    if(userP != null){
                        System.out.println("Select post type: " +
                                "1: Text \n" +
                                "2: Image \n" +
                                "3: Video \n");
                        int pType = sc.nextInt();

                        switch (pType) {
                            case 1:
                                System.out.println("Write your post: ");
                                String pContent = sc.nextLine();
                                PostText newPost1 = new PostText(userP, "Text", pContent);
                                //TODO add to post list
                                break;
                            case 2:
                                System.out.println("Write your post title: ");
                                String iTitle = sc.nextLine();
                                String iDimensions = sc.nextLine();
                                PostImage newPost2 = new PostImage(userP, "Image", iTitle, iDimensions);
                                //TODO add to post list
                            case 3:
                                System.out.println("Write your post title: ");
                                String vTitle = sc.nextLine();
                                String vQuality = sc.nextLine();
                                String vLength = sc.nextLine();
                                PostVideo newPost3 = new PostVideo(userP, "Video", vTitle, vQuality, vLength);
                                //TODO add to post list
                            case 4:
                                System.out.println("Goodbye!");
                                break;
                            default:
                                System.out.println("You must choose a value between 1 and 4.");
                        }
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
