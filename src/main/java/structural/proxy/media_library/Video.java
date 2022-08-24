package structural.proxy.media_library;

/**
 * Created on 24.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class Video {
    public final String id;
    public final String title;
    public final String data;

    public Video(String id, String title) {
        this.id = id;
        this.title = title;
        this.data = "Some video data.";
    }
}
