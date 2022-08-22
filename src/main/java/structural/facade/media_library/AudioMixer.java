package structural.facade.media_library;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * Created on 22.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class AudioMixer {
    public File fix(VideoFile videoFile){
      log.info("Fixing audio...");
      return new File("tmp");
    }
}
