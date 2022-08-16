package structural.bridge.remotes;

/**
 * Created on 16.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public interface Remote {
    void power();

    void volumeDown();

    void volumeUp();

    void channelDown();

    void channelUp();

    void showDeviceStatus();
}
