package structural.bridge.remotes;

import lombok.extern.slf4j.Slf4j;
import structural.bridge.device.Device;

/**
 * Created on 16.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class BasicRemote implements Remote{

    protected Device device;

    public BasicRemote(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
      log.info("Remote: power toggle!");
      if (device.isEnabled()){
          device.disable();
      } else {
          device.enable();
      }
    }

    @Override
    public void volumeDown() {
        log.info("Remote: volume Down!");
        device.setVolume(device.getVolume() - 5);
    }

    @Override
    public void volumeUp() {
        log.info("Remote: volume Up!");
        device.setVolume(device.getVolume() + 5);
    }

    @Override
    public void channelDown() {
        log.info("Remote: previous channel!");
        device.setChannel(device.getChannel() - 1);
    }

    @Override
    public void channelUp() {
        log.info("Remote: next channel!");
        device.setChannel(device.getChannel() + 1);
    }

    @Override
    public void showDeviceStatus() {
        log.info("Remote: show status of {}", device.getName());
        this.device.printStatus();
    }
}
