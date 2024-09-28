package postcard.model.animations;

import postcard.model.images.Heart;

public class HearthAnimation extends Animation {
    private final Heart heart = new Heart(300, - 300);

    public HearthAnimation(String... strings) {
        addText(strings);
    }

    @Override
    public void start() {
        isStarted = true;
        displayedNow.add(heart);
        timer.schedule(this, 0, 20);
    }

    @Override
    public void run() {
        if(runCounts > 300) {
            stopAnimation();
        } else if(runCounts < 80) {
            heart.moveByY(5);
        }
        runCounts++;
    }
}
