package structural.bridge.remotes;

import lombok.extern.slf4j.Slf4j;
import structural.bridge.device.Device;

/**
 * Created on 16.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute(){
      log.info("Remote: mute!");
      device.setVolume(0);
    }

    public void unMute(){
        log.info("Remote: unmute!");
        device.setVolume(30);
    }
}
