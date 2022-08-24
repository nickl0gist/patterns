package structural.proxy.media_library;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created on 24.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br>Implementation of Remote Youtube service
 */
@Slf4j
public class ExternalYouTubeService implements ExternalYouTubeLibrary{
    @Override
    public HashMap<String, Video> popularVideos() {
        connectToServer("http://www.youtube.com");
        return getRandomVideos();
    }

    @Override
    public Video getVideo(String videoId) {
        connectToServer("http://www.youtube.com/" + videoId);
        return getSomeVideo(videoId);
    }

    // -----------------------------------------------------------------------
    // Fake methods to simulate network activity. They as slow as a real life.

    private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private void experienceNetworkLatency() {
        int randomLatency = random(5, 10);
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                log.error(Arrays.toString(ex.getStackTrace()));
            }
        }
    }

    private void connectToServer(String server) {
        log.info("Connecting to {}...", server);
        experienceNetworkLatency();
        log.info("Connected!\n");
    }

    private HashMap<String, Video> getRandomVideos() {
        log.info("Downloading populars... ");

        experienceNetworkLatency();
        HashMap<String, Video> videoHashMap = new HashMap<>();
        videoHashMap.put("meowcatz", new Video("cutecats", "Catzzzz.avi"));
        videoHashMap.put("detailing", new Video("car_polishing", "Car polishing.mp4"));
        videoHashMap.put("tango", new Video("tango_dance", "Tango dancing video.mpq"));
        videoHashMap.put("funny_videos", new Video("funny", "Cube #13.mov"));
        videoHashMap.put("cook_tutorial", new Video("cook_tutorial", "Cake baking.avi"));

        log.info("Done!\n");
        return videoHashMap;
    }

    private Video getSomeVideo(String videoId) {
        log.info("Downloading video... ");

        experienceNetworkLatency();
        Video video = new Video(videoId, "Some video title");

        log.info("Done!\n");
        return video;
    }
}
