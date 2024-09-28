package postcard.model.images;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Objects;

public class BrilliantMoveIcon implements Paintable {
    private final Ellipse2D.Float circle;
    private final int xOfString;
    private final int yOfString;
    private static final String text = "!!";
    public static final Color TURQUOISE = new Color(64, 224, 208);
    private static final Font font = new Font("Serif", Font.BOLD, 60);

    public BrilliantMoveIcon(int x, int y) {
        circle = new Ellipse2D.Float(x, y, 70, 70);
        xOfString = x + 15;
        yOfString = y + 55;
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        graphics2D.setColor(TURQUOISE);
        graphics2D.fill(circle);
        graphics2D.setColor(Color.WHITE);
        graphics2D.setFont(font);
        graphics2D.drawString(text, xOfString, yOfString);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        BrilliantMoveIcon that = (BrilliantMoveIcon) otherObject;
        return xOfString == that.xOfString && yOfString == that.yOfString
                && Objects.equals(circle, that.circle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(circle, xOfString, yOfString);
    }
}
