package behavioral.state.states;

import behavioral.state.ui.Player;

/**
 * Created on 06.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Concrete implementation of State. Concrete States could pass Context into Other Concrete States.
 */
public class PlayingState extends State{

    PlayingState(Player player) {
        super(player);
    }

    @Override
    public String onLock() {
        player.changeState(new LockedState(player));
        player.setCurrentTrackAfterStop();
        return "Stop playing";
    }

    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return "Paused...";
    }

    @Override
    public String onNext() {
        return player.nextTrack();
    }

    @Override
    public String onPrevious() {
        return player.previousTrack();
    }
}
