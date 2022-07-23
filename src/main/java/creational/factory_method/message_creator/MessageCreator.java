package creational.factory_method.message_creator;

import creational.factory_method.message.Message;

/**
 * Created on 23.07.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public abstract class MessageCreator {
    public Message getMessage(){
        Message msg = createMessage();

        msg.addDefaultHeaders();
        msg.encrypt();

        return msg;
    }

    //Factory method
    public abstract Message createMessage();
}
