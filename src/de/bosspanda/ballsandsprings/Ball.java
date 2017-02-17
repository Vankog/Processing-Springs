package de.bosspanda.ballsandsprings;

import processing.core.PVector;


/**
 * Created by Vankog on 17.12.2016.
 * The com.BossPanda.Sketch.Ball Object
 */
public class Ball {
    public static final float  BALL_SIZE = 34.0f;
    public static final float  COLOR = 255.0f;
    private float mass;
    private PVector acc;
    private PVector vel;
    private PVector loc;

    public PVector getLoc() {
        return loc;
    }

    public void setLoc(PVector loc) {
        this.loc = loc;
    }

    Ball(PVector location) {
        mass = BALL_SIZE / BALL_SIZE;     // set mass to 1
        acc = new PVector(0.0f, 0.0f);
        vel = new PVector(0.0f, 0.0f);
        loc = location;
    }

    void update() {
        vel.add(acc);
        loc.add(vel);

        //reset acceleration
        acc = new PVector(0.0f, 0.0f);
    }

    void applyForce(PVector force) {
        acc.add(PVector.mult(force, mass));
    }
}
