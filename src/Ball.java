import processing.core.PVector;

/**
 * Created by Vankog on 17.12.2016.
 */
public class Ball {
	float size;
	float mass;
	PVector acc;
	PVector vel;
	PVector loc;
	Springs sketch;

	Ball(Springs sketch) {
		this.sketch = sketch;
		size = 34;
		mass = size / 34;
		acc = new PVector(0, 0);
		vel = new PVector(0, 0);
		loc = new PVector(sketch.width / 2, sketch.height / 2);
	}

	Ball(Springs sketch, PVector locaton) {
		this(sketch);
		loc = locaton;
	}

	void update() {
		vel.add(acc);
		loc.add(vel);

		//reset acceleration
		acc = new PVector(0, 0);
	}

	void applyForce(PVector force) {
		acc.add(PVector.mult(force, mass));
	}

	void draw() {
		sketch.stroke(255);
		sketch.fill(255);
		sketch.ellipse(loc.x, loc.y, size, size);
	}
}
