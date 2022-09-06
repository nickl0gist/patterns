package behavioral.state.states;

import behavioral.state.ui.Player;

/**
 * Created on 06.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Concrete implementation of State. Concrete States could pass Context into Other Concrete States.
 * <br> ReadyState can change state to Playing or Locked State. No option to change Tracks.
 */
public class ReadyState extends State{

    public ReadyState(Player player) {
        super(player);
    }

    @Override
    public String onLock() {
        player.changeState(new LockedState(player));
        return LOCKED;
    }

    @Override
    public String onPlay() {
        String action = player.startPlayback();
        player.changeState(new PlayingState(player));
        return action;
    }

    @Override
    public String onNext() {
        return LOCKED;
    }

    @Override
    public String onPrevious() {
        return LOCKED;
    }
}
