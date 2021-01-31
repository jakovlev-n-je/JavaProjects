package com.vgu.cs.course2.group11.yakovlev_n_je.player.states;

public class Improved extends State {

    @Override
    public void jump() {
        System.out.println("Высокий прыжок!");
    }

    @Override
    public void shoot() {
        System.out.println("Обычный выстрел!");
    }

    @Override
    public State powerUp() {
        return new Fiery();
    }

    @Override
    public State powerDown() {
        return new Normal();
    }
}
