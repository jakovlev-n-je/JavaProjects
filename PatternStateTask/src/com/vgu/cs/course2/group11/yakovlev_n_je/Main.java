package com.vgu.cs.course2.group11.yakovlev_n_je;

import com.vgu.cs.course2.group11.yakovlev_n_je.exceptions.StateException;
import com.vgu.cs.course2.group11.yakovlev_n_je.player.Player;

public class Main {

    public static void main(String[] args) throws StateException {
        Player mario = new Player();
        for (int i = 0; i < 2; i++) {
            mario.jump();
            mario.shoot();
            mario.powerUp();
            System.out.print('\n');
        }
        for (int i = 0; i < 3; i++) {
            mario.jump();
            mario.shoot();
            mario.powerDown();
            System.out.print('\n');
        }
    }
}
