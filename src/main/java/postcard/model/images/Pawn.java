package postcard.model.images;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.RoundRectangle2D;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Pawn implements Paintable, Movable {
    private final Ellipse2D.Float head = new Ellipse2D.Float(253, 120, 90, 90);
    private final Ellipse2D.Float neck = new Ellipse2D.Float(240, 200, 115, 26);
    private final RoundRectangle2D.Float base =
            new RoundRectangle2D.Float(212, 350, 175, 65, 60, 60);

    private final QuadCurve2D.Float leftCurve =
            new QuadCurve2D.Float(260,215,315,315,230,360);

    private final QuadCurve2D.Float rightCurve =
            new QuadCurve2D.Float(340, 215, 285, 285, 370, 360);

    private final Polygon filling = new Polygon(new int[] {260, 275, 285, 245, 365, 317, 324, 330},
            new int[] {205, 265, 290, 360, 360, 290, 265, 205}, 8);

    private static final BasicStroke strokeForCurves =
            new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);

    public Pawn(int x, int y) {
        moveTo(x, y);
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        graphics2D.setColor(new Color(35,35,35));
        graphics2D.setStroke(strokeForCurves);
        graphics2D.fill(base);
        graphics2D.fill(head);
        graphics2D.fill(neck);
        graphics2D.draw(leftCurve);
        graphics2D.draw(rightCurve);
        graphics2D.fillPolygon(filling);
    }

    @Override
    public void moveByX(int toMove) {
        base.x += toMove;
        head.x += toMove;
        neck.x += toMove;
        leftCurve.x1 += toMove;
        leftCurve.x2 += toMove;
        leftCurve.ctrlx += toMove;
        rightCurve.x1 += toMove;
        rightCurve.x2 += toMove;
        rightCurve.ctrlx += toMove;
        for(int i = 0; i < filling.xpoints.length; i++) {
            filling.xpoints[i] += toMove;
        }
    }

    @Override
    public void moveByY(int toMove) {
        base.y += toMove;
        head.y += toMove;
        neck.y += toMove;
        leftCurve.y1 += toMove;
        leftCurve.y2 += toMove;
        leftCurve.ctrly += toMove;
        rightCurve.y1 += toMove;
        rightCurve.y2 += toMove;
        rightCurve.ctrly += toMove;
        for(int i = 0; i < filling.ypoints.length; i++) {
            filling.ypoints[i] += toMove;
        }
    }

    @Override
    public void moveTo(int x, int y) {
        moveByX((int) (x - head.x));
        moveByY((int)(y - head.y));
    }
}
