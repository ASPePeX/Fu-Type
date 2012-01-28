import processing.core.PVector;

public class Enemy2 extends Enemy {

	int sp;
	PVector ev;

	Enemy2(int y_, int x_) {
		super(y_, x_);
		s = 5;
		spawn = 5;
		w = 150;
		hb = 28;
	}

	void move() {
		// movement in direction of the ship
		ev = new PVector(x, y);
		ev.sub(p.mouseX, p.mouseY, 0);
		ev.limit(s);
		x = x - (int) ev.x;
		y = y - (int) ev.y;
	}

	void draw() {
		p.noStroke();
		p.fill(100);
		p.ellipse(x, y, 35, 35);
		p.fill(200, 0, 0);
		p.ellipse(x, y, 5, 5);
		p.fill(0, 200, 0);
		p.ellipse(x - 8, y - 8, 5, 5);
		p.ellipse(x + 8, y + 8, 5, 5);
		p.fill(0, 0, 200);
		p.ellipse(x + 8, y - 8, 5, 5);
		p.ellipse(x - 8, y + 8, 5, 5);
	}
}
