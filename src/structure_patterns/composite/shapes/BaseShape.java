package structure_patterns.composite.shapes;

import behavioral_patterns.memento.shapes.MemShape;
import behavioral_patterns.visitor.shapes.VisShape;

import java.awt.*;
import java.io.Serializable;

// Единый общий абстрактный класс для всего приложения. Имплементация интефейса MemShape нужна для использования
// классов форм в паттерне Снимок (Memento). Имплементация интефейса VisShape нужна для использования
// классов форм в паттерне Посетитель (Visitor).
public abstract class BaseShape implements MemShape, VisShape {
    protected int x;
    protected int y;
    protected Color color;
    private boolean selected = false;

    protected BaseShape() {}

    protected BaseShape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void moveBy(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public boolean isInsideBounds(int x, int y) {
        return x > getX() && x < (getX() + getWidth()) &&
                y > getY() && y < (getY() + getHeight());
    }

    @Override
    public void select() {
        selected = true;
    }

    @Override
    public void unSelect() {
        selected = false;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    void enableSelectionStyle(Graphics graphics) {
        graphics.setColor(Color.LIGHT_GRAY);

        Graphics2D g2 = (Graphics2D) graphics;
        float[] dash1 = {2.0f};
        g2.setStroke(new BasicStroke(1.0f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                2.0f, dash1, 0.0f));
    }

    void disableSelectionStyle(Graphics graphics) {
        graphics.setColor(color);
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setStroke(new BasicStroke());
    }


    @Override
    public void paint(Graphics graphics) {
        if (isSelected()) {
            enableSelectionStyle(graphics);
        } else {
            disableSelectionStyle(graphics);
        }
    }

    // Дополнительная логика, имплементируемая с интерфейсом VisShape для использовании класса в паттерне Посетитель.
    protected int id;
    protected BaseShape(int id, int x, int y, Color color) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getColorRGB() {
        return "[" + this.color.getRed() + "," + this.color.getGreen() + "," + this.color.getBlue() +"]";
    }

    // Дополнительная логика, имплементируемая с интерфейсом MemShape для использовании класса в паттерне Снимок.
    protected int dx;
    protected int dy;

    @Override
    public void drag() {
        dx = x;
        dy = y;
    }

    @Override
    public void drop() {
        this.x = dx;
        this.y = dy;
    }

    @Override
    public void moveTo(int x, int y) {
        this.x = dx + x;
        this.y = dy + y;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

}
