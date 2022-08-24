package structural.proxy;

import lombok.extern.slf4j.Slf4j;
import structural.proxy.downloader.YouTubeDownloader;
import structural.proxy.media_library.ExternalYouTubeService;
import structural.proxy.proxy.YouTubeCacheProxy;

/**
 * Created on 24.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br>Study of Proxy Design Pattern
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ExternalYouTubeService());
        YouTubeDownloader smartDownloader = new YouTubeDownloader(new YouTubeCacheProxy());

        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        log.info("Time saved by caching proxy: {} ms", (naive - smart));
    }

    private static long test(YouTubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        // User behavior in our app:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("tango");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("funny_videos");

        // Users might visit the same page quite often.
        downloader.renderVideoPage("tango");
        downloader.renderVideoPage("cook_tutorial");

        long estimatedTime = System.currentTimeMillis() - startTime;
        log.info("Time elapsed: {} ms\n", estimatedTime);
        return estimatedTime;
    }
}
