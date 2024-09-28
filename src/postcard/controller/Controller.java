package postcard.controller;

import postcard.model.animations.*;
import postcard.view.Picture;
import postcard.view.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class Controller implements ActionListener {
    private final Window view;
    private final Picture picture = new Picture();

    public Controller(Window view) {
        this.view = Objects.requireNonNull(view, "Параметр view не должен быть null!");
        view.setPicture(picture);
    }

    public void bindViewToListener() {
        view.addButtonToListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.removeButton();
        view.revalidate();
        Animation[] animations = new Animation[] {
                new HearthAnimation("Дорогой папа!", "Поздравляю тебя с днём рождения!"),
                new BrilliantMove(),
                new Capture(),
                new TwoAces(),
                new MedalAnimation(),
                new HearthAnimation("Твой Шурик")
        };
        prepareAnimations(animations);
        animations[0].start();
        scheduleRepainting();
    }

    private void prepareAnimations(Animation[] animations) {
        for(int i = 0; i < animations.length; i++) {
            picture.addAnimation(animations[i]);
            if(i != 0) animations[i - 1].andThen(animations[i]);
        }
    }

    private void scheduleRepainting() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                view.repaint();
            }
        }, 0,  1);
    }
}
