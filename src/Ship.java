import processing.core.*;

public class Ship {
	static float x, y;
	//w Waffen Array, ws Weapon Selected
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

	public static void moveUp() {
		y = (float) (y - 1.5);
	}
	public static void moveDown() {
		y = (float) (y + 1.5);
	}
	public static void moveLeft() {
		x = (float) (x - 1.5);
	}
	public static void moveRight() {
		x = (float) (x + 1.5);
	}
	
	public void shoot() {
		
	}

	
	public static void draw() {
		p.triangle(x - 10, y - 10, x + 10, y, x - 10, y + 10);
	}

}
