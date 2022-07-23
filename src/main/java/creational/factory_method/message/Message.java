package creational.factory_method.message;

/**
 * Created on 23.07.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public abstract class Message {

    public abstract String getContent();

    public void addDefaultHeaders(){
        //add some default headers
    }

    public void encrypt(){
        // Encrypting of the message content
    }
}
