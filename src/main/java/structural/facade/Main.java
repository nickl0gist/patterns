package structural.facade;

import structural.facade.media_library.NoSuchCodecException;
import structural.facade.media_library.VideoConversionFacade;

import java.io.File;

/**
 * Created on 22.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Studu of Facade Design Pattern
 */
public class Main {
    public static void main(String[] args) throws NoSuchCodecException {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("SomeVideo.ogg", "mp4");
    }
}
