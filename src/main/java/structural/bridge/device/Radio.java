package structural.bridge.device;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 16.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class Radio implements Device{

    private boolean on = false;
    private int volume = 20;
    private int channel = 1;
    private String name;

    public Radio(String name) {
        this.name = name;
    }

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        if (percent > 100){
            volume = 100;
        } else volume = Math.max(percent, 0);
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void printStatus() {
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        log.info("| I'm a radio: {}", name);
        log.info("| Current status is {}", on ? "enabled." : "disabled.");
        log.info("| Current volume is {}", volume);
        log.info("| Current channel is {}", channel);
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }
}
