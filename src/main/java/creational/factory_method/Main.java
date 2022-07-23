package creational.factory_method;

import creational.factory_method.message.Message;
import creational.factory_method.message_creator.JSONMessageCreator;
import creational.factory_method.message_creator.MessageCreator;
import creational.factory_method.message_creator.TextMessageCreator;
import lombok.extern.slf4j.Slf4j;

/**
 * Created on 23.07.2022
 * <br>Study of the Factory Method design pattern
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        printMessage(new JSONMessageCreator());
        printMessage(new TextMessageCreator());
    }

    public static void printMessage(MessageCreator messageCreator){
        Message msg = messageCreator.getMessage();
        log.info(msg.getContent());
    }
}
