package postcard.model.images;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.QuadCurve2D;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Medal implements Paintable, Movable {
    private final Ellipse2D.Float innerRound;
    private final Ellipse2D.Float outerRound;
    private final QuadCurve2D.Float ribbon;
    private final byte place;
    private int xOfNumberPlace;
    private int yOfNumberPlace;

    public Medal(int x, int y, byte place) {
        this.place = place;
        outerRound = new Ellipse2D.Float(x, y, 100, 100);
        innerRound = new Ellipse2D.Float(x + 15, y + 15, 70, 70);
        ribbon = new QuadCurve2D.Float(x + 40, y, x + 45, y - 550, x + 60, y);
        xOfNumberPlace = x + 35;
        yOfNumberPlace = y + 65;
    }

    @Override
    public void moveByX(int toMove) {
        innerRound.x += toMove;
        outerRound.x += toMove;
        ribbon.x1 += toMove;
        ribbon.ctrlx += toMove;
        ribbon.x2 += toMove;
        xOfNumberPlace += toMove;
    }

    @Override
    public void moveByY(int toMove) {
        innerRound.y += toMove;
        outerRound.y += toMove;
        ribbon.y1 += toMove;
        ribbon.ctrly += toMove;
        ribbon.y2 += toMove;
        yOfNumberPlace += toMove;
    }

    @Override
    public void moveTo(int x, int y) {
        moveByX((int) (x - outerRound.x));
        moveByY((int) (y - outerRound.y));
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        Color gold = new Color(187, 165, 61);
        graphics2D.setColor(gold);
        graphics2D.fill(outerRound);
        graphics2D.setColor(new Color(255, 215, 0));
        graphics2D.fill(innerRound);
        graphics2D.setColor(new Color(34,139,34));
        graphics2D.setStroke(new BasicStroke(10));
        graphics2D.draw(ribbon);
        graphics2D.setColor(gold);
        graphics2D.setFont(new Font(null, Font.BOLD, 50));
        graphics2D.drawString(String.valueOf(place), xOfNumberPlace, yOfNumberPlace);
    }
}
