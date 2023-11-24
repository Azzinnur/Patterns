package creative_patterns.prototype;

import creative_patterns.prototype.shapes.Circle;
import creative_patterns.prototype.shapes.Rectangle;
import creative_patterns.prototype.shapes.Shape;

import java.util.HashMap;
import java.util.Map;

public class ColouredShapeCache {
    private Map<String, Shape> cache = new HashMap<>();

    public ColouredShapeCache() {
        Circle circle = new Circle();
        circle.setX(5);
        circle.setY(7);
        circle.setRadius(45);
        circle.setColor("Green");

        Rectangle rectangle = new Rectangle();
        rectangle.setX(6);
        rectangle.setY(9);
        rectangle.setWidth(8);
        rectangle.setHeight(10);
        rectangle.setColor("Blue");

        cache.put("Big green circle", circle);
        cache.put("Medium blue rectangle", rectangle);
    }

    public Shape put(String key, Shape shape) {
        cache.put(key, shape);
        return shape;
    }

    public Shape get(String key) {
        return cache.get(key).copy();
    }
}
