package behavioral_patterns.state.states;

// Интерфейс, в который вынесены варианты состояния в виде статических констант.
public interface StateConstants {
    static final String BLOCKED = "Заблокировано";
    static final String STOPPED = "Воспроизведение остановлено";
    static final String READY = "Готов к воспроизведению";
    static final String PAUSED = "Пауза";

}
