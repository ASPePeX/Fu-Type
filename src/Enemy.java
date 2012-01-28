
import processing.core.PApplet;

public class Enemy {
// x, y, s = speed, w = worth (score), hb = hitbox, spawn(rate), shoot = shootprobability
	int x, y, s;
	static int w, hb;
	static float spawn, shoot;
	static PApplet p;

	Enemy(int y_, int x_) {
		x = x_;
		y = y_;
		s = 1;
		shoot = 0;
	}

	void move() {
		x -= s;
	}

	void draw() {
		p.noStroke();
		p.fill(200);
		p.ellipse(x, y, 10, 10);
	}
	void drawHit() {
		p.fill(255,255,0);
		p.ellipse(x,y,40,40);
		p.fill(255,0,0);
		p.ellipse(x,y,20,20);
	}
}
