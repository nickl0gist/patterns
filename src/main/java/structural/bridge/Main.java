package structural.bridge;

import lombok.extern.slf4j.Slf4j;
import structural.bridge.device.Device;
import structural.bridge.device.Radio;
import structural.bridge.device.TV;
import structural.bridge.remotes.AdvancedRemote;
import structural.bridge.remotes.BasicRemote;

/**
 * Created on 16.08.2022
 * Study of Bridge design pattern. Remotes - Abstraction layer, Device - implementation layer.
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        testDevice(new TV("Philips"));
        testDevice(new Radio("Sanyo"));
    }

    public static void testDevice(Device device){
        log.info("Test of Basic Remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        basicRemote.volumeDown();
        basicRemote.channelUp();
        basicRemote.showDeviceStatus();

        log.info("Test of Advanced Remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.mute();
        advancedRemote.channelUp();
        advancedRemote.showDeviceStatus();
    }
}
