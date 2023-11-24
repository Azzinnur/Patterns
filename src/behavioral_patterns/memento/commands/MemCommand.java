package behavioral_patterns.memento.commands;

// Базовый интерфейс комманд. Подробнее про петтерн команда см. behavioral_patterns.command
public interface MemCommand {
    String getName();
    void execute();
}
