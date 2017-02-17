package de.bosspanda.ballsandsprings;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by Vankog on 17.12.2016.
 * Shows a suspended spring with interactions.
 */
public class Sketch extends PApplet {
    private static final int SIZE_X = 640;
    private static final int SIZE_Y = 480;
    private static final float COLOR = 255.0f;
    private static final float BG_COLOR = 0.0f;

    private Spring spring;
    private PVector gravity = new PVector(0.0f, 1.0f);

    //setup screen
    public void settings() {
        size(SIZE_X, SIZE_Y);
    }

    public void setup() {
        Ball ball = new Ball(new PVector(width / 2.0f, height / 2.0f));
        PVector loc = new PVector(width / 2.0f, 0.0f);
        float len = (height / 2.0f) - 50.0f;
        spring = new Spring(loc, len, ball);
    }

    public void mouseClicked() {
    }

    public void draw() {
        background(BG_COLOR);
        stroke(COLOR);
        fill(COLOR);

        PVector mouseForce = new PVector(mouseX, mouseY);
        mouseForce.sub(spring.getBallLoc()).setMag(0.3f);
        spring.applyForce(spring.getSpringForce());
        if (mousePressed)
            spring.applyForce(mouseForce);
            //spring.applyForce(new PVector(0.5f, 0.5f));
        spring.applyForce(gravity);
        spring.update();
        drawSpring(spring);
    }

    private void drawSpring(Spring springToDraw) {
        stroke(Spring.COLOR);
        fill(Spring.COLOR);
        PVector originLoc = springToDraw.getOriginLoc();
        PVector ballLoc = springToDraw.getBallLoc();
        line(originLoc.x, originLoc.y, ballLoc.x, ballLoc.y);

        drawBall(springToDraw.getBall());
    }

    private void drawBall(Ball ballToDraw) {
        stroke(Ball.COLOR);
        fill(Ball.COLOR);
        PVector ballLoc = ballToDraw.getLoc();
        ellipse(ballLoc.x, ballLoc.y, Ball.BALL_SIZE, Ball.BALL_SIZE);
    }
}
