package creational.factory_method.message_creator;

import creational.factory_method.message.JSONMessage;
import creational.factory_method.message.Message;

/**
 * Created on 23.07.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class JSONMessageCreator extends MessageCreator{

    @Override
    public Message createMessage() {
        return new JSONMessage();
    }
}
