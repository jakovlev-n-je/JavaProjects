package com.vgu.cs.course2.group11.yakovlev_n_je.player.states;

import com.vgu.cs.course2.group11.yakovlev_n_je.exceptions.StateException;

public abstract class State {

    public abstract void jump();

    public abstract void shoot();

    public abstract State powerUp() throws StateException;

    public abstract State powerDown() throws StateException;
}
