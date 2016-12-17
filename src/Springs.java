import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by Vankog on 17.12.2016.
 */
public class Springs extends PApplet {
	final int sizeX = 640;
	final int sizeY = 480;

	Spring spring;
	PVector gravity = new PVector(0, 1);

	public static void main(String[] args) {
		PApplet.main("Springs", args);
	}

	//setup screen
	public void settings() {
		size(sizeX, sizeY);
	}

	public void setup() {
		spring = new Spring(this);
	}

	public void mouseClicked() {
	}

	public void draw() {
		background(0);
		stroke(255);
		fill(255);

		//PVector mouseForce = new PVector(mouseX, mouseY);
		//mouseForce.sub(ball.loc).setMag(0.01);
		//ball.applyForce(mouseForce);
		spring.applyForce(spring.getSpringForce());
		if (mousePressed)
			spring.applyForce(new PVector(0.5f, 0.5f));
		spring.applyForce(gravity);
		spring.update();
		spring.draw();
	}
}
