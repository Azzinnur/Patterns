package creative_patterns.prototype.shapes;

import java.util.Objects;

public class Circle extends Shape {
    private int radius;

    public Circle() {}

    public Circle(int radius) {
        this.radius = radius;
    }

    public Circle(Circle target) {
        super(target);
        if (target != null) {
            this.radius = target.getRadius();
        }
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Circle) || !super.equals(o)) return false;
        Circle circle2 = (Circle) o;
        return radius == circle2.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public Shape copy() {
        return new Circle(this);
    }

}
