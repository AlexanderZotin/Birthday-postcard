package postcard.model.images;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Font;
import java.util.Objects;

public class Text implements Paintable {
    private final String value;
    private final int y;
    private final int specifier;
    private final Font font;
    private final Color color;

    public Text(String value, int y, int windowWidth, Font font, Color color) {
        this.value = Objects.requireNonNull(value, "Параметр value не может быть null!");
        this.y = y;
        specifier = (int) Math.round(windowWidth / 14.5 + font.getSize2D() / 14.5 + value.length() / 14.5);
        this.font = Objects.requireNonNull(font, "Параметр font не должен быть null!");
        this.color = Objects.requireNonNull(color, "Параметр color не должен быть null!");
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        graphics2D.setFont(font);
        graphics2D.setColor(color);
        graphics2D.drawString(String.format("%" + specifier + "s", value), 0, y);
    }
}
