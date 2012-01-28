public class Enemy3 extends Enemy {

	// sp = shot probability
	int sp;

	Enemy3(int y_, int x_) {
		super(y_, x_);
		s = 5;
		spawn = 110;
		shoot = 50;
	}

	void draw() {
		p.noStroke();
		p.fill(100);
		p.triangle(x + 10, y + 10, x - 10, y, x + 10, y - 10);

	}
}