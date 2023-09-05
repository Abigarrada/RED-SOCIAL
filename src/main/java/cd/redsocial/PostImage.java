package cd.redsocial;

/*
 * Class to handle image type posts.
 * Extends Post class.
 * Must contain a title and image dimensions.
 */

public class PostImage extends Post {
    protected String imageTitle;
    protected String imageDimensions;
    protected PostImage(String username, String postType, String imageTitle, String imageDimensions) {
        super(username);
        super.postType = postType;
        this.imageTitle = imageTitle;
        this.imageDimensions = imageDimensions;
    }
}
