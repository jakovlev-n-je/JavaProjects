package com.vgu.cs.course2.group11.yakovlev_n_je.player;

import com.vgu.cs.course2.group11.yakovlev_n_je.exceptions.StateException;
import com.vgu.cs.course2.group11.yakovlev_n_je.player.states.Normal;
import com.vgu.cs.course2.group11.yakovlev_n_je.player.states.State;

public class Player {

    private State state;

    public Player() {
        state = new Normal();
    }

    public void jump() {
        state.jump();
    }

    public void shoot() {
        state.shoot();
    }

    public void powerUp() throws StateException {
        state = state.powerUp();
    }

    public void powerDown() throws StateException {
        state = state.powerDown();
    }
}
