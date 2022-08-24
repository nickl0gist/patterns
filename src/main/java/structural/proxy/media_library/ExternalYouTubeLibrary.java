package structural.proxy.media_library;

import java.util.HashMap;

/**
 * Created on 24.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public interface ExternalYouTubeLibrary {
    HashMap<String, Video> popularVideos();

    Video getVideo(String videoId);
}
