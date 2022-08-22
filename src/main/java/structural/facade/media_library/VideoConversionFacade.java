package structural.facade.media_library;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * Created on 22.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class VideoConversionFacade {
    public File convertVideo(String fileName, String format) throws NoSuchCodecException {
        log.info("Conversion started.");
        VideoFile file = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.getCodec(file);
        Codec destinationCodec = getCodecByFormat(format);
        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        File result = (new AudioMixer()).fix(intermediateResult);
        log.info("Conversion completed.");
        return result;
    }

    private Codec getCodecByFormat(String format){
        Codec destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new MPEG4CompressionCodec();
        } else {
            destinationCodec = new OggCompressionCodec();
        }
        return destinationCodec;
    }
}
