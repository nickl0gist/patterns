package structural.proxy.downloader;

import lombok.extern.slf4j.Slf4j;
import structural.proxy.media_library.ExternalYouTubeLibrary;
import structural.proxy.media_library.Video;

import java.util.HashMap;

/**
 * Created on 24.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Videoo Files downloader.
 */
@Slf4j
public class YouTubeDownloader {
    private final ExternalYouTubeLibrary api;

    public YouTubeDownloader(ExternalYouTubeLibrary api) {
        this.api = api;
    }

    public void renderVideoPage(String videoId) {
        Video video = api.getVideo(videoId);
        log.info("-------------------------------");
        log.info("Here some fancy HTML assumed.");
        log.info("ID: " + video.id);
        log.info("Title: " + video.title);
        log.info("Video: " + video.data);
        log.info("-------------------------------\n");
    }

    public void renderPopularVideos() {
        HashMap<String, Video> list = api.popularVideos();
        log.info("-------------------------------");
        log.info("Most popular videos on YouTube (Some fancy HTML here :) )");
        for (Video video : list.values()) {
            log.info("ID: " + video.id + " / Title: " + video.title);
        }
        log.info("-------------------------------\n");
    }
}
