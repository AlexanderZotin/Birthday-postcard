package postcard.view;

import postcard.model.animations.Animation;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import lombok.NonNull;

public class Picture extends JPanel {
    //В проекте используются таймеры, то есть многопоточность фактически присутствует
    private final List<Animation> allAnimations = new CopyOnWriteArrayList<>();

    public void addAnimation(@NonNull Animation animation) {
        allAnimations.add(animation);
    }

    @Override
    public void removeAll() {
        allAnimations.clear();
    }

    @Override
    public void paintComponent(Graphics g) {
        var graphics2D = (Graphics2D) g;
        for(Animation current : allAnimations) {
            if(current.isStarted()) {
                current.paint(graphics2D);
            }
        }
    }
}
