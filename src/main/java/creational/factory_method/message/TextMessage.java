package creational.factory_method.message;

/**
 * Created on 23.07.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class TextMessage extends Message{
    @Override
    public String getContent() {
        return "Text Message:\n";
    }
}
