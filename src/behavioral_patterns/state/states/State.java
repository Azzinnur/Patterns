package behavioral_patterns.state.states;

import behavioral_patterns.state.ui.Player;

//Общий астрактный класс для всех состояний
public abstract class State implements StateConstants{
    Player player;

    //...
    State(Player player) {
        this.player = player;
    }

    public abstract String onLock();

    public abstract String onPlay();

    public abstract String onNext();

    public abstract String onPrevious();
}
