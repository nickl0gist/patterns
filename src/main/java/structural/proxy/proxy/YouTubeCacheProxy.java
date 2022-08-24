package structural.proxy.proxy;

import lombok.extern.slf4j.Slf4j;
import structural.proxy.media_library.ExternalYouTubeLibrary;
import structural.proxy.media_library.ExternalYouTubeService;
import structural.proxy.media_library.Video;

import java.util.HashMap;

/**
 * Created on 24.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Proxy class to work with cache.
 */
@Slf4j
public class YouTubeCacheProxy implements ExternalYouTubeLibrary {
    private final ExternalYouTubeLibrary youTubeService;
    private HashMap<String, Video> cachePopularVideos = new HashMap<>();
    private HashMap<String, Video> cacheAll = new HashMap<>();

    public YouTubeCacheProxy() {
        this.youTubeService = new ExternalYouTubeService();
    }

    @Override
    public HashMap<String, Video> popularVideos() {
        if(cachePopularVideos.isEmpty()){
            cachePopularVideos = youTubeService.popularVideos();
        } else {
            log.info("Retrieved list from cache.");
        }
        return cachePopularVideos;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = youTubeService.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            log.info("Retrieved video '{}' from cache.", videoId);
        }
        return video;
    }

    public void reset(){
        cachePopularVideos.clear();
        cacheAll.clear();
    }
}
