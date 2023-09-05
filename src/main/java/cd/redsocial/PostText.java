package cd.redsocial;

/*
 * Class to handle text type posts.
 * Extends Post class.
 * Must contain a string of text.
 */

public class PostText extends Post{
    protected String textContent;
    protected PostText(String username, String postType, String textContent) {
        super(username);
        super.postType = postType;
        this.textContent = textContent;
    }
}
