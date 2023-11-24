package behavioral_patterns.visitor.visitor;

import behavioral_patterns.visitor.shapes.VisShape;
import structure_patterns.composite.shapes.Circle;
import structure_patterns.composite.shapes.CompoundShape;
import structure_patterns.composite.shapes.Dot;
import structure_patterns.composite.shapes.Rectangle;

public class XMLExportVisitor implements Visitor, XMLStringConstants {

    public String export(VisShape... args) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\n");
        for (VisShape shape : args) {
            sb.append(shape.accept(this)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String visitDot(Dot dot) {
        return "<dot>" + "\n" +
                OPEN_ID + dot.getId() + CLOSE_ID +
                OPEN_X + +dot.getX() + CLOSE_X +
                OPEN_Y + dot.getY() + CLOSE_Y +
                OPEN_COLOR + dot.getColorRGB() + CLOSE_COLOR +
                "</dot>";
    }

    @Override
    public String visitCircle(Circle circle) {
        return "<circle>" + "\n" +
                OPEN_ID + circle.getId() + CLOSE_ID +
                OPEN_X + circle.getX() + CLOSE_X +
                OPEN_Y + circle.getY() + CLOSE_Y +
                OPEN_RADIUS + circle.getRadius() + CLOSE_RADIUS +
                OPEN_COLOR + circle.getColorRGB() + CLOSE_COLOR +
                "</circle>";
    }

    @Override
    public String visitRectangle(Rectangle rectangle) {
        return "<rectangle>" + "\n" +
                OPEN_ID + rectangle.getId() + CLOSE_ID +
                OPEN_X + rectangle.getX() + CLOSE_X +
                OPEN_Y + rectangle.getY() + CLOSE_Y +
                OPEN_WIDTH + rectangle.getWidth() + CLOSE_WIDTH +
                OPEN_HEIGHT + rectangle.getHeight() + CLOSE_HEIGHT +
                OPEN_COLOR + rectangle.getColorRGB() + CLOSE_COLOR +
                "</rectangle>";
    }

    @Override
    public String visitCompoundShape(CompoundShape compoundShape) {
        return "<compound_shape>" + "\n" +
                OPEN_ID + compoundShape.getId() + CLOSE_ID +
                visitCompoundShapeComponents(compoundShape) +
                "</compound_shape>";
    }

    private String visitCompoundShapeComponents(CompoundShape compoundShape) {
        StringBuilder sb = new StringBuilder();
        for (VisShape shape : compoundShape.getChildren()) {
            String obj = shape.accept(this);
            obj = "    " + obj.replace("\n", "\n    ") + "\n";
            sb.append(obj);
        }
        return sb.toString();
    }
}
