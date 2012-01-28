
import processing.core.PApplet;

public class Ship {
	static float x, y;
	static int hb, score, scorehigh;
	static PApplet p;

	Ship(float x_, float y_) {
		x = x_;
		y = y_;
		hb = 15;
	}

	public static void draw() {
		p.fill(255);
		p.triangle(p.mouseX - 10, p.mouseY - 10, p.mouseX + 10, p.mouseY,
				p.mouseX - 10, p.mouseY + 10);
		if (score > scorehigh)
			scorehigh = score;
		p.text("Highscore: " + scorehigh, 10, 20);
		p.text("Score: " + score, 10, 40);
	}

	public static void drawHit() {
		p.fill(255, 255, 0);
		p.ellipse(p.mouseX, p.mouseY, 40, 40);
		p.fill(255, 0, 0);
		p.ellipse(p.mouseX, p.mouseY, 20, 20);
	}
}
