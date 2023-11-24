package behavioral_patterns.mediator.mediator;

// Класс заметок, который является "расходным материалом" нашего приложения.
public class Note {
    private String name = "New note";

    private String text;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return name;
    }

}
