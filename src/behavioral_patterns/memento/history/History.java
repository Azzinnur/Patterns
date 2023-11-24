package behavioral_patterns.memento.history;

import behavioral_patterns.memento.commands.MemCommand;

import java.util.ArrayList;
import java.util.List;

// Класс-опекун, в котором хранятся снимки
public class History {
    private List<Pair> commandHistory = new ArrayList<>();
    private int virtualSize;

    // Класс, который явлеяется снимком состояния. Хранит в себе последнюю команду и объект всмомогательного класса
    // Мементо.
    private class Pair {
        MemCommand command;
        Memento memento;

        Pair(MemCommand c, Memento m) {
            command = c;
            memento = m;
        }

        private MemCommand getCommand() {
            return command;
        }

        private Memento getMemento() {
            return memento;
        }
    }

    public void push(MemCommand c, Memento m) {
        if (virtualSize != commandHistory.size() && virtualSize > 0) {
            commandHistory = commandHistory.subList(0, virtualSize - 1);
        }
        commandHistory.add(new Pair(c, m));
        virtualSize = commandHistory.size();
    }

    public boolean undo() {
        Pair pair = getUndo();
        if (pair == null) {
            return false;
        }
        System.out.println("Отменяю операцию '" + pair.getCommand().getName() + "'");
        pair.getMemento().restore();
        return true;
    }

    public boolean redo() {
        Pair pair = getRedo();
        if (pair == null) {
            return false;
        }
        System.out.println("Воспроизвожу операцию '" + pair.getCommand().getName() + "'");
        pair.getMemento().restore();
        pair.getCommand().execute();
        return true;
    }

    private Pair getUndo() {
        if (virtualSize == 0) {
            return null;
        }
        virtualSize = Math.max(0, virtualSize - 1);
        return commandHistory.get(virtualSize);
    }

    private Pair getRedo() {
        if (virtualSize == commandHistory.size()) {
            return null;
        }
        virtualSize = Math.min(commandHistory.size(), virtualSize + 1);
        return commandHistory.get(virtualSize - 1);
    }
}
