package creative_patterns.prototype.shapes;

import creative_patterns.prototype.Copyable;

import java.util.List;
import java.util.Objects;

public abstract class Shape implements Copyable {
    private int x;
    private int y;
    private String color;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    protected Shape() {
    }

    protected Shape(Shape target) {
        if (target != null) {
            this.x = target.x;
            this.y = target.y;
            this.color = target.color;
        }
    }

    public abstract Shape copy();

    @Override
    public int hashCode() {
        return Objects.hash(x, y, color);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Shape)) return false;
        Shape shape2 = (Shape) object2;
        return shape2.x == x && shape2.y == y && Objects.equals(shape2.color, color);
    }

    public static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        for (Shape shape : shapes) {
            shapesCopy.add(shape.copy());
        }

        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println(i + ": Формы являются различными объектами (+)");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println(i + ": Но они равны по equals (+)");
                } else {
                    System.out.println(i + ": Но они не равны по equals (-)");
                }
            } else {
                System.out.println(i + ": Формы являются идентичными объектами (-)");
            }
        }
    }
}
