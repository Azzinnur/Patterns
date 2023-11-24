package behavioral_patterns.state.states;

import behavioral_patterns.state.ui.Player;

public class ReadyState extends State{

    public ReadyState(Player player) {
        super(player);
    }

    @Override
    public String onLock() {
        player.changeState(new LockedState(player));
        return BLOCKED;
    }

    @Override
    public String onPlay() {
        String action = player.startPlayback();
        player.changeState(new PlayingState(player));
        return action;
    }

    @Override
    public String onNext() {
                return player.nextTrack() + READY;
    }

    @Override
    public String onPrevious() {
        return player.previousTrack() + READY;
    }
}
