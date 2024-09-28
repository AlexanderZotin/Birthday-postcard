package postcard.model.images;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Objects;

public class King implements Paintable, Movable {
    private static final BasicStroke strokeForCurves = new BasicStroke(40);

    private final QuadCurve2D.Float leftCurve =
            new QuadCurve2D.Float(240, 100, 100, 60, 250, 300);
    private final QuadCurve2D.Float rightCurve =
            new QuadCurve2D.Float(290, 100, 435, 60, 300, 285);

    private final RoundRectangle2D.Float upperRect =
            new RoundRectangle2D.Float(230, 35, 80, 30, 10, 10);
    private final RoundRectangle2D.Float center =
            new RoundRectangle2D.Float(250, 10, 40, 320, 10, 10);
    public final RoundRectangle2D.Float rectOnBase =
            new RoundRectangle2D.Float(200, 270, 150, 40, 15, 15);
    private final RoundRectangle2D.Float base =
            new RoundRectangle2D.Float(170, 300, 205, 50, 15, 15);

    private final Rectangle2D.Float filling = new Rectangle2D.Float(225, 240, 100, 30);

    public King(int x, int y) {
        moveTo(x, y);
    }

    @Override
    public void moveByX(int toMove) {
        leftCurve.x1 += toMove;
        leftCurve.x2 += toMove;
        leftCurve.ctrlx += toMove;
        rightCurve.x1 += toMove;
        rightCurve.x2 += toMove;
        rightCurve.ctrlx += toMove;
        center.x += toMove;
        base.x += toMove;
        upperRect.x += toMove;
        rectOnBase.x += toMove;
        filling.x += toMove;
    }

    @Override
    public void moveByY(int toMove) {
        leftCurve.y1 += toMove;
        leftCurve.y2 += toMove;
        leftCurve.ctrly += toMove;
        rightCurve.y1 += toMove;
        rightCurve.y2 += toMove;
        rightCurve.ctrly += toMove;
        center.y += toMove;
        base.y += toMove;
        upperRect.y += toMove;
        rectOnBase.y += toMove;
        filling.y += toMove;
    }

    @Override
    public void moveTo(int x, int y) {
        moveByX((int) (x - center.x));
        moveByY((int) (y - center.y));
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        graphics2D.setColor(new Color(187, 165, 142));
        graphics2D.setStroke(strokeForCurves);
        graphics2D.draw(leftCurve);
        graphics2D.draw(rightCurve);
        graphics2D.fill(base);
        graphics2D.fill(upperRect);
        graphics2D.fill(rectOnBase);
        graphics2D.fill(filling);
        graphics2D.fill(center);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        King otherKing = (King) otherObject;
        return Objects.equals(leftCurve, otherKing.leftCurve)
                && Objects.equals(rightCurve, otherKing.rightCurve)
                && Objects.equals(upperRect, otherKing.upperRect)
                && Objects.equals(center, otherKing.center)
                && Objects.equals(rectOnBase, otherKing.rectOnBase)
                && Objects.equals(base, otherKing.base)
                && Objects.equals(filling, otherKing.filling);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftCurve, rightCurve, upperRect, center, rectOnBase, base, filling);
    }
}
