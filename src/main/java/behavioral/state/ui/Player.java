package behavioral.state.ui;

import behavioral.state.states.ReadyState;
import behavioral.state.states.State;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 06.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Context object
 */
public class Player {

    private static final String PLAYING_STRING = "Playing: ";

    @Getter
    private State state;

    @Setter
    @Getter
    private boolean playing = false;

    private final List<String> playlist = new ArrayList<>();
    private int currentTrack = 0;

    public Player() {
        // Set current state to Ready
        this.state = new ReadyState(this);

        //Set playing to true at the start.
        setPlaying(true);

        //Add 12 tracks to be played.
        for (int i = 1; i <= 12; i++) {
            playlist.add("Track " + i);
        }
    }

    public void changeState(State state) {
        this.state = state;
    }

    public String startPlayback() {
        return PLAYING_STRING + playlist.get(currentTrack);
    }

    public String nextTrack() {
        currentTrack++;
        if (currentTrack > playlist.size() - 1) {
            currentTrack = 0;
        }
        return PLAYING_STRING + playlist.get(currentTrack);
    }

    public String previousTrack() {
        currentTrack--;
        if (currentTrack < 0) {
            currentTrack = playlist.size() - 1;
        }
        return PLAYING_STRING + playlist.get(currentTrack);
    }


    public void setCurrentTrackAfterStop() {
        this.currentTrack = 0;
    }
}
