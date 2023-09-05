package cd.redsocial;

/*
 * Class to handle video type posts.
 * Extends Post class.
 * Must contain a title, quality and length of the video.
 */

public class PostVideo extends Post {
    protected String videoTitle;
    protected int videoQuality;
    protected int videoLength;
    /*
     * PostVideo class constructor.
     * Calls Post's constructor.
     * Post type will always be "Video".
     * Needs a title String, quality int and length int.
     * */
    protected PostVideo(String username, String videoTitle, int videoQuality, int videoLength) {
        super(username);
        super.postType = "Video";
        this.videoTitle = videoTitle;
        this.videoQuality = videoQuality;
        this.videoLength = videoLength;
    }
}
