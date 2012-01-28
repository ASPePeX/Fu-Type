public class Enemy1 extends Enemy {

	Enemy1(int y_, int x_) {
		super(y_, x_);
		s = 5;
		spawn = 120;
		w = 100;
		hb = 10;
	}

	void draw() {
		p.fill(100);
		p.ellipse(x, y, 15, 15);
		p.fill(200, 0, 0);
		p.ellipse(x, y, 5, 5);
	}
}
