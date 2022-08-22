package structural.facade.media_library;

/**
 * Created on 22.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class NoSuchCodecException extends Exception{
    public NoSuchCodecException(String message) {
        super(message);
    }
}
