package creational.factory_method.message_creator;

import creational.factory_method.message.Message;
import creational.factory_method.message.TextMessage;

/**
 * Created on 23.07.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class TextMessageCreator extends MessageCreator{

    @Override
    public Message createMessage() {
        return new TextMessage();
    }
}
