package com.vgu.cs.course2.group11.yakovlev_n_je.player.states;

import com.vgu.cs.course2.group11.yakovlev_n_je.exceptions.StateException;

public class Normal extends State {

    @Override
    public void jump() {
        System.out.println("Обычный прыжок!");
    }

    @Override
    public void shoot() {
        System.out.println("Обычный выстрел!");
    }

    @Override
    public State powerUp() {
        return new Improved();
    }

    @Override
    public State powerDown() throws StateException {
        throw new StateException("Minimum value is already set");
    }
}
