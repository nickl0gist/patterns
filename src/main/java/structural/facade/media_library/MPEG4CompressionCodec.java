package structural.facade.media_library;

import lombok.Getter;

/**
 * Created on 22.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Getter
public class MPEG4CompressionCodec implements Codec {
    private String type = "mp4";
}
