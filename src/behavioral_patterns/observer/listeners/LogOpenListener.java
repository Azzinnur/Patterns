package behavioral_patterns.observer.listeners;

import java.io.File;

public class LogOpenListener implements EventListener{
    private File log;

    public LogOpenListener(String fileName) {
        this.log = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.printf("Запись в лог-файл %s: была выполнена операция %s c файлом %s%n", log, eventType, file);
    }
}
