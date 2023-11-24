package behavioral_patterns.command.commands;

import java.util.ArrayDeque;
import java.util.Deque;

// Класс-буфер для хранения истории команд
public class CommandHistory {
    private final Deque<Command> history = new ArrayDeque<>();

    public void push(Command c) {
        history.push(c);
    }

    public Command pop() {
        return history.pop();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

}
