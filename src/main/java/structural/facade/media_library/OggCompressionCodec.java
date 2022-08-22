package structural.facade.media_library;

import lombok.Getter;

/**
 * Created on 22.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Getter
public class OggCompressionCodec implements Codec {
    private String type = "ogg";
}
