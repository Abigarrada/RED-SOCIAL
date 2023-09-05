package cd.redsocial;

/*
 * Class to handle image type posts.
 * Extends Post class.
 * Must contain a title and image dimensions.
 */

public class PostImage extends Post {
    protected String imageTitle;
    protected int imageHeight;
    protected int imageWidth;
    /*
     * PostImage class constructor.
     * Calls Post's constructor.
     * Post type will always be "Image".
     * Needs a title String and dimensions.
     * */
    protected PostImage(String username, String imageTitle, int imageHeight, int imageWidth) {
        super(username);
        super.postType = "Image";
        this.imageTitle = imageTitle;
        this.imageHeight = imageHeight;
        this.imageWidth = imageWidth;
    }
}
