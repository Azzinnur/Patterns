package behavioral_patterns.state.states;

import behavioral_patterns.state.ui.Player;

public class PlayingState extends State{
    public PlayingState(Player player) {
        super(player);
    }

    @Override
    public String onLock() {
        player.changeState(new LockedState(player));
        return STOPPED;
    }

    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return PAUSED;
    }

    @Override
    public String onNext() {
        return player.nextTrackPlaying();
    }

    @Override
    public String onPrevious() {
        return player.previousTrackPlaying();
    }
}
