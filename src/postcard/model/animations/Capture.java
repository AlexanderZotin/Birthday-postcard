package postcard.model.animations;

import postcard.model.images.King;
import postcard.model.images.Pawn;

public class Capture extends Animation {
    private final Pawn pawn = new Pawn(120, 160);
    private final King king = new King(400, 110);

    @Override
    public void start() {
        isStarted = true;
        displayedNow.add(pawn);
        displayedNow.add(king);
        addText("и встречать интересные стратегические", "эндшпили, которые, как ты говорил,",
                "гораздо более захватывающие,", "чем тактические бои.");
        timer.schedule(this, 0, 20);
    }

    @Override
    public void run() {
        if(runCounts == 350) {
            stopAnimation();
        } else if(runCounts == 60) {
            displayedNow.remove(pawn);
        } else if(runCounts < 60) {
            king.moveByX(-5);
        }
        runCounts++;
    }
}
