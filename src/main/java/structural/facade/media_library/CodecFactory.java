package structural.facade.media_library;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 22.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class CodecFactory {
    public static Codec getCodec(VideoFile file) throws NoSuchCodecException {
        String type = file.getCodecType();
        switch (type){
            case "mp4":
                log.info("Extracting mpeg audio...");
                return new MPEG4CompressionCodec();
            case "ogg":
                log.info("Extracting ogg audio...");
                return new OggCompressionCodec();
            default:
                throw new NoSuchCodecException("The Codec " + type + " does not exist.");
        }
    }
}
