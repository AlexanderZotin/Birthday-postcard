package postcard.model.animations;

import postcard.model.images.Ace;
import java.awt.Color;

public class TwoAces extends Animation {
    private final Ace peakAce = new Ace(-175, 100, '♠', Color.BLACK);
    private final Ace heartAce = new Ace(300, 70, '♥', Color.RED);

    @Override
    public void start() {
        isStarted = true;
        addText("И в бридже тебе тоже успехов.");
        displayedNow.add(heartAce);
        displayedNow.add(peakAce);
        timer.schedule(this, 0, 20);
    }

    @Override
    public void run() {
        if(runCounts == 200) {
            stopAnimation();
        } else if(runCounts < 50) {
            peakAce.moveByY(-4);
            peakAce.moveByX(5);
        } else if(runCounts < 90) {
            peakAce.moveByY(4);
            peakAce.moveByX(5);
        }
        runCounts++;
    }
}
