import processing.core.*;

public class Ship {
	static float x, y;
	// w Waffen Array, ws Weapon Selected
	static int[] w = new int[3];
	static int ws;
	static PApplet p;

	Ship(float x_, float y_) {
		x = x_;
		y = y_;
		w[0] = 1;
		w[1] = 0;
		w[2] = 0;
		ws = 0;
	}

	public static void draw() {
		p.fill(255);
		p.triangle(p.mouseX - 10, p.mouseY - 10, p.mouseX + 10, p.mouseY,
				p.mouseX - 10, p.mouseY + 10);
	}

}
