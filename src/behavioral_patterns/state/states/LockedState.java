package behavioral_patterns.state.states;

import behavioral_patterns.state.ui.Player;

public class LockedState extends State {

    LockedState(Player player) {
        super(player);
        player.setPlaying(false);
    }

    @Override
    public String onLock() {
        if (player.isPlaying()) {
            player.changeState(new ReadyState(player));
            return STOPPED;
        } else {
            player.setCurrentTrackAfterStop();
            return BLOCKED;
        }
    }

    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return READY;
    }

    @Override
    public String onNext() {
        return BLOCKED;
    }

    @Override
    public String onPrevious() {
        return BLOCKED;
    }
}
