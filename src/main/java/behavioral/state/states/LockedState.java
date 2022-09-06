package behavioral.state.states;

import behavioral.state.ui.Player;

/**
 * Created on 06.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Concrete implementation of State. Concrete States could pass Context into Other Concrete States.
 */
public class LockedState extends State{

    LockedState(Player player) {
        super(player);
        player.setPlaying(false);
    }

    @Override
    public String onLock() {
        // if current states was Playing
        if (player.isPlaying()) {
            player.changeState(new ReadyState(player));
            return "Stop playing";
        } else { // any other state (Ready, Locked)
            return LOCKED;
        }
    }

    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return "Ready";
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
