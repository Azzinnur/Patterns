package behavioral_patterns.observer.listeners;

import java.io.File;

//Интерфейс подписчика с единственным методом оповещения.
public interface EventListener {
    void update(String eventType, File file);
}
