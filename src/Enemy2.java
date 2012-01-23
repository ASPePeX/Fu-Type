public class Enemy2 extends Enemy {

	int sp;

	Enemy2(int y_, int x_) {
		super(y_, x_);
		s = 5;
		spawn = 100;
	}

	void draw() {
		p.noStroke();
		p.fill(100);
		p.ellipse(x, y, 35, 35);
		p.fill(200,0,0);
		p.ellipse(x, y, 5,5);
		p.fill(0, 200, 0);
		p.ellipse(x - 8, y - 8, 5, 5);
		p.ellipse(x + 8, y + 8, 5, 5);
		p.fill(0, 0, 200);
		p.ellipse(x + 8, y - 8, 5, 5);
		p.ellipse(x - 8, y + 8, 5, 5);
	}
}
