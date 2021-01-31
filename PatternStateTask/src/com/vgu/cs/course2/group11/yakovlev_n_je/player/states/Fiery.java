package com.vgu.cs.course2.group11.yakovlev_n_je.player.states;

import com.vgu.cs.course2.group11.yakovlev_n_je.exceptions.StateException;

public class Fiery extends State {

    @Override
    public void jump() {
        System.out.println("Высокий прыжок!");
    }

    @Override
    public void shoot() {
        System.out.println("Выстрел огненным шаром!");
    }

    @Override
    public State powerUp() throws StateException {
        throw new StateException("Maximum value is already set");
    }

    @Override
    public State powerDown() {
        return new Improved();
    }
}
