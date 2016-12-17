import processing.core.PVector;

/**
 * Created by Vankog on 17.12.2016.
 */
public class Spring {
	PVector originLoc;
	PVector distance;
	Ball ball;
	float restLen;
	//spring coefficient
	float k = 0.03f;
	Springs sketch;

	Spring(Springs sketch) {
		this.sketch = sketch;
		restLen = sketch.height / 2 - 50;
		originLoc = new PVector(sketch.width / 2, 0);
		ball = new Ball(sketch);
		distance = PVector.sub(originLoc, ball.loc);
	}

	public void update() {
		ball.update();
		distance = PVector.sub(originLoc, ball.loc);
	}

	public void draw() {
		sketch.stroke(255);
		sketch.fill(255);
		sketch.line(originLoc.x, originLoc.y, ball.loc.x, ball.loc.y);
		ball.draw();
	}

	// F = -K × X × spring.normalize()×-1
	// K = spring coefficient, X = displacement
	public PVector getSpringForce() {
		float x = distance.mag() - restLen;

		PVector springForce = distance.copy().normalize().mult(k * x);
		return springForce;
	}

	public void applyForce(PVector force) {
		ball.applyForce(force);
	}
}
