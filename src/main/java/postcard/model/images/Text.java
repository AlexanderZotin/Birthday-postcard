package postcard.model.images;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import lombok.NonNull;

public class Text implements Paintable {
    private final String value;
    private final int y;
    private final int specifier;
    private final Font font;
    private final Color color;

    public Text(@NonNull String value, int y, int windowWidth, @NonNull Font font, @NonNull Color color) {
        this.value = value;
        this.y = y;
        specifier = (int) Math.round(windowWidth / 14.5 + font.getSize2D() / 14.5 + value.length() / 14.5);
        this.font = font;
        this.color = color;
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        graphics2D.setFont(font);
        graphics2D.setColor(color);
        graphics2D.drawString(String.format("%" + specifier + "s", value), 0, y);
    }
}
