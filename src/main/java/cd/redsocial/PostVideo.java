package cd.redsocial;

/*
 * Class to handle video type posts.
 * Extends Post class.
 * Must contain a title, quality and length of the video.
 */

public class PostVideo extends Post {
    protected String videoTitle;
    protected String videoQuality;
    protected String videoLength;
    protected PostVideo(String username, String postType, String videoTitle, String videoQuality, String videoLength) {
        super(username);
        super.postType = postType;
        this.videoTitle = videoTitle;
        this.videoQuality = videoQuality;
        this.videoLength = videoLength;
    }
}
