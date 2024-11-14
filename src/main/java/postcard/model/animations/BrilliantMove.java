package postcard.model.animations;

import postcard.model.images.ArrowToRight;
import postcard.model.images.BrilliantMoveIcon;
import postcard.model.images.Pawn;

public class BrilliantMove extends Animation {
    private final Pawn pawn = new Pawn(10, 150);
    private final BrilliantMoveIcon brilliantMoveIcon = new BrilliantMoveIcon(325, 125);
    private final ArrowToRight arrow = new ArrowToRight(10, 250);

    @Override
    public void start() {
        started = true;
        displayedNow.add(pawn);
        addText("Желаю тебе делать ещё больше", "блестящих ходов");
        timer.schedule(this, 0, 20);
    }

    @Override
    public void run() {
        if(runCounts == 300) {
            stopAnimation();
        } else if(runCounts == 50) {
            displayedNow.add(brilliantMoveIcon);
            displayedNow.add(arrow);
        } else if(runCounts < 50) {
            pawn.moveByX(5);
        }
        runCounts++;
    }
}
