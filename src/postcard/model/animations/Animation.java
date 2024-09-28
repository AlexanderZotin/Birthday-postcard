package postcard.model.animations;

import postcard.model.images.Paintable;
import postcard.model.images.Text;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Animation extends TimerTask implements Paintable {
    protected boolean isStarted;
    protected Animation next;
    //В проекте используются таймеры, то есть многопоточность фактически присутствует
    protected List<Paintable> displayedNow = new CopyOnWriteArrayList<>();
    protected Timer timer = new Timer();
    protected int runCounts;

    protected void addText(String... strings) {
        Font font = new Font("Serif", Font.ITALIC, 30);
        int y = 520;
        for(String current: strings) {
            Text text = new Text(current, y, 500, font, Color.BLUE);
            displayedNow.add(text);
            y += 30;
        }
    }

    protected void stopAnimation() {
        cancel();
        displayedNow.clear();
        isStarted = false;
        if(next == null) System.exit(0);
        else next.start();
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void andThen(Animation next) {
        this.next = next;
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        for(Paintable current : displayedNow) {
            current.paint(graphics2D);
        }
    }

    public abstract void start();
    public abstract void run();
}
