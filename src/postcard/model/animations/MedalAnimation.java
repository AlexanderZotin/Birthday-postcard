package postcard.model.animations;

import postcard.model.images.Ace;
import postcard.model.images.Medal;
import java.awt.Color;

public class MedalAnimation extends Animation {
    private final Medal medal = new Medal(200, -100, (byte) 3);
    private final Ace card = new Ace(-200, 90, '♦', Color.RED);

    @Override
    public void start() {
        isStarted = true;
        displayedNow.add(card);
        displayedNow.add(medal);
        addText("Ты недавно получил медаль на турнире,", "и я надеюсь, что результаты",
                "будут только лучше.");
        timer.schedule(this, 0, 20);
    }

    @Override
    public void run() {
        if(runCounts == 350) {
            stopAnimation();
        } else if(runCounts < 105) {
            card.moveByX(5);
        } else if(runCounts < 180) {
            medal.moveByY(5);
        }
        runCounts++;
    }
}
