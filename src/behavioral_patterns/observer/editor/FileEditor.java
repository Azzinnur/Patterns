package behavioral_patterns.observer.editor;

import behavioral_patterns.observer.publisher.EventManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileEditor {
    private EventManager events;
    private File file;

    public FileEditor() {
        this.events = new EventManager("open", "save");
    }

    public void openFile(String filePath) throws FileNotFoundException {
        this.file = new File(filePath);
        Scanner scanner = new Scanner(file);
        System.out.println(scanner.nextLine());
        scanner.close();
        events.notify("open", file);
    }

    public void saveFile() throws Exception {
        if(this.file != null) {
            events.notify("save", file);
        } else {
            throw new Exception("Откройте файл, перед тем как его сохранять!");
        }
    }

    public EventManager getEvents() {
        return events;
    }

}
