package structural.facade.media_library;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 22.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class BitrateReader {
    public static VideoFile read(VideoFile file, Codec codec){
      log.info("Reading file...");
      return file;
    }

    public static VideoFile convert(VideoFile buffer, Codec codec) {
        log.info("Writing file...");
        return buffer;
    }
}
