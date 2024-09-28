package postcard.model.images;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Objects;

public class Ace implements Paintable, Movable {
    private final RoundRectangle2D.Float card;
    private int xOfAce;
    private int yOfAce;
    private int xOfFlippedOverAce;
    private int yOfFlippedOverAce;
    private final char icon;
    private int xOfIcon;
    private int yOfIcon;
    private final Color color;

    public Ace(int x, int y, char suitIcon, Color color) {
        card = new RoundRectangle2D.Float(x, y, 250, 400, 15, 15);
        xOfAce = x + 10;
        yOfAce = y + 40;
        xOfFlippedOverAce = (int)(card.width + x - 35);
        yOfFlippedOverAce = (int)(card.height + y - 10);
        xOfIcon = (int) Math.round(x + card.width / 3.3);
        yOfIcon = (int) Math.round(y + card.height / 1.7);
        icon = suitIcon;
        this.color = Objects.requireNonNull(color, "Параметр color не должен быть null!");
    }

    @Override
    public void moveByX(int toMove) {
        card.x += toMove;
        xOfAce += toMove;
        xOfFlippedOverAce += toMove;
        xOfIcon += toMove;
    }

    @Override
    public void moveByY(int toMove) {
        card.y += toMove;
        yOfAce += toMove;
        yOfFlippedOverAce += toMove;
        yOfIcon += toMove;
    }

    @Override
    public void moveTo(int x, int y) {
        moveByX((int)(x - card.x));
        moveByY((int)(y - card.y));
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        graphics2D.setColor(Color.WHITE);
        graphics2D.fill(card);
        graphics2D.setColor(Color.BLACK);
        graphics2D.setStroke(new BasicStroke(2));
        graphics2D.draw(card);
        graphics2D.setColor(color);
        graphics2D.setFont(new Font(null, Font.BOLD, 40));
        graphics2D.drawString("A", xOfAce, yOfAce);
        graphics2D.drawString(String.valueOf((char) 0x2C6F), xOfFlippedOverAce, yOfFlippedOverAce);
        graphics2D.setFont(new Font(null, Font.BOLD, 150));
        graphics2D.drawString(String.valueOf(icon), xOfIcon, yOfIcon);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ace ace = (Ace) o;
        return xOfAce == ace.xOfAce && yOfAce == ace.yOfAce && xOfFlippedOverAce == ace.xOfFlippedOverAce && yOfFlippedOverAce == ace.yOfFlippedOverAce && icon == ace.icon && xOfIcon == ace.xOfIcon && yOfIcon == ace.yOfIcon && Objects.equals(card, ace.card) && Objects.equals(color, ace.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(card, xOfAce, yOfAce, xOfFlippedOverAce, yOfFlippedOverAce, icon, xOfIcon, yOfIcon, color);
    }
}
