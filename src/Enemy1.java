public class Enemy1 extends Enemy {

	int sp;
	Enemy1(int y_,int x_) {
		super(y_,x_);
		s = 5;
		sp = 100; 
	}
	void draw() {
		p.stroke(200);
		p.fill(0);
		p.ellipse(x,y,15,15);
		p.fill(200,0,0);
		p.ellipse(x, y, 5,5);
	}
}
