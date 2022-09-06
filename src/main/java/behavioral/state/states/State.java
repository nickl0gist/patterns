package behavioral.state.states;

import behavioral.state.ui.Player;

/**
 * Created on 06.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Common abstaract class for all Player's states.
 */
public abstract class State {

    static final String LOCKED = "Locked...";

    Player player;

    /**
     * Context (Player) passes itself to State's constructor. It allows State to call Player's properties and methods if needed.
     * @param player Context object
     */
    State (Player player){
        this.player = player;
    }

    public abstract String onLock();
    public abstract String onPlay();
    public abstract String onNext();
    public abstract String onPrevious();
}
