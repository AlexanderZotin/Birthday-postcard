package postcard.model.images;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.geom.QuadCurve2D;
import java.util.Objects;

public class Heart implements Paintable, Movable {
    private final QuadCurve2D.Float rightCurve =
            new QuadCurve2D.Float(275, 100, 100, 10, 260, 225);
    private final QuadCurve2D.Float leftCurve =
            new QuadCurve2D.Float(280, 100, 450, 10, 290, 225);
    private final Polygon filling = new Polygon(new int[]{170, 350, 315, 276, 240}, new int[]{90, 90, 225, 280, 230}, 5);

    public Heart(int x, int y) {
        moveTo(x, y);
    }

    @Override
    public void moveByX(int toMove) {
        rightCurve.x1 += toMove;
        rightCurve.x2 += toMove;
        rightCurve.ctrlx += toMove;
        leftCurve.ctrlx += toMove;
        leftCurve.x1 += toMove;
        leftCurve.x2 += toMove;
        for(int i = 0; i < filling.xpoints.length; i++) {
            filling.xpoints[i] += toMove;
        }
    }

    @Override
    public void moveByY(int toMove) {
        rightCurve.y1 += toMove;
        rightCurve.y2 += toMove;
        rightCurve.ctrly += toMove;
        leftCurve.ctrly += toMove;
        leftCurve.y1 += toMove;
        leftCurve.y2 += toMove;
        for(int i = 0; i < filling.ypoints.length; i++) {
            filling.ypoints[i] += toMove;
        }
    }

    @Override
    public void moveTo(int x, int y) {
        moveByX((int) (x - leftCurve.x1));
        moveByY((int) (y - leftCurve.y1));
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        graphics2D.setColor(Color.RED);
        graphics2D.setStroke(new BasicStroke(40, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
        graphics2D.draw(rightCurve);
        graphics2D.draw(leftCurve);
        graphics2D.fillPolygon(filling);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Heart otherHeart = (Heart) other;
        return Objects.equals(rightCurve, otherHeart.rightCurve)
                && Objects.equals(leftCurve, otherHeart.leftCurve)
                && Objects.equals(filling, otherHeart.filling);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rightCurve, leftCurve, filling);
    }
}
