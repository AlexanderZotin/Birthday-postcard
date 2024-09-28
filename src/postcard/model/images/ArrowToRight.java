package postcard.model.images;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Objects;

public class ArrowToRight implements Paintable {
    private final Polygon polygon;

    public ArrowToRight(int xBegin, int yBegin) {
        polygon = new Polygon(new int[]{xBegin, xBegin + 240, xBegin + 240, xBegin + 285, xBegin + 240, xBegin + 240, xBegin},
                new int[] {yBegin, yBegin, yBegin - 20, yBegin + 15, yBegin + 50, yBegin + 30, yBegin + 30},
                7);
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        graphics2D.setColor(BrilliantMoveIcon.TURQUOISE);
        graphics2D.fillPolygon(polygon);
    }

    @Override
    public boolean equals(Object otherObject) {
        if(this == otherObject) return true;
        if(otherObject == null || getClass() != otherObject.getClass()) return false;
        ArrowToRight that = (ArrowToRight) otherObject;
        return Objects.equals(polygon, that.polygon);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(polygon);
    }
}
