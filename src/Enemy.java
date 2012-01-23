import processing.core.*;

public class Enemy {

	int x, y, s;
	static PApplet p;

	Enemy(int y_,int x_) {
		x = x_;
		y = y_;
		s = 1;
	}

	void move() {
		x -= s;
	}
	void draw() {
		p.noStroke();
		p.fill(200);
		p.ellipse(x,y,10,10);
	}
}
