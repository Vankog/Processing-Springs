package de.bosspanda.ballsandsprings;

import processing.core.PVector;

/**
 * Created by Vankog on 17.12.2016.
 * The com.BossPanda.Sketch.Spring object.
 */
public class Spring {
    public static final float COLOR = 255.0f;
    //spring coefficient
    private static final float COEFF = 0.03f;

    public PVector getOriginLoc() {
        return originLoc;
    }
    public void setOriginLoc(PVector originLoc) {
        this.originLoc = originLoc;
    }
    public PVector getBallLoc() {
        return ball.getLoc();
    }
    public void setBallLoc(PVector ballLoc) {
        ball.setLoc(ballLoc);
    }
    public Ball getBall() {
        return ball;
    }
    public void setBall(Ball ball) {
        this.ball = ball;
    }

    private PVector originLoc;
    private PVector distance;

    private Ball ball;
    private float restLen;

    Spring(PVector origin, float len, Ball attachedBall) {
        restLen = len;
        originLoc = origin;
        ball = attachedBall;
        distance = PVector.sub(originLoc, ball.getLoc());
    }

    public void update() {
        ball.update();
        distance = PVector.sub(originLoc, ball.getLoc());
    }

    // F = -K × X × spring.normalize()×-1
    // K = spring coefficient, X = displacement
    public PVector getSpringForce() {
        float x = distance.mag() - restLen;

        return distance.copy().normalize().mult(COEFF * x);
    }

    public void applyForce(PVector force) {
        ball.applyForce(force);
    }

}
