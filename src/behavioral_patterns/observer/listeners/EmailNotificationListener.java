package behavioral_patterns.observer.listeners;

import java.io.File;

public class EmailNotificationListener implements EventListener {
    private String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.printf("Письмо на %s: была выполнена операция %s c файлом %s%n", email, eventType, file);
    }
}
