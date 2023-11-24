package structure_patterns.composite.shapes;

import java.awt.*;
import java.io.Serializable;

// Единый интерфейс для всего приложения. Расширение Serializable необходимо для паттерна Memento (снимок).
public interface Shape extends Serializable {
    int getX();

    int getY();

    int getWidth();

    int getHeight();

    void moveBy(int x, int y);

    boolean isInsideBounds(int x, int y);

    void select();

    void unSelect();

    boolean isSelected();

    void paint(Graphics graphics);

}
