package cd.redsocial;

/*
 * Class to handle text type posts.
 * Extends Post class.
 * Must contain a string of text.
 */

public class PostText extends Post{
    protected String textContent;
    /*
     * PostText class constructor.
     * Calls Post's constructor.
     * Post type will always be "Text".
     * Needs a content String.
     * */
    protected PostText(String username, String textContent) {
        super(username);
        super.postType = "Text";
        this.textContent = textContent;
    }
}
