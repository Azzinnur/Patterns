package creative_patterns.prototype.shapes;

import java.util.Objects;

public class Rectangle extends Shape {
    private int width;
    private int height;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rectangle) || !super.equals(o)) return false;
        Rectangle rectangle2 = (Rectangle) o;
        return width == rectangle2.width && height == rectangle2.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), width, height);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle() {
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(Rectangle target) {
        super(target);
        if (target != null) {
            height = target.getHeight();
            width = target.getWidth();
        }
    }

    @Override
    public Shape copy() {
        return new Rectangle(this);
    }
}
