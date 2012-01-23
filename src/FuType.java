import java.util.ArrayList;
import processing.core.*;

public class FuType extends PApplet {
	BG bg[] = new BG[100];
	ArrayList shots = new ArrayList();
	Weapon shot;

	public void setup() {
		noCursor();
		frameRate(30);
		size(800, 600);
		Ship s1 = new Ship(100, 100);
		Ship.p = this;
		// Weapon w[] = new Weapon[200];

		for (int i = 0; i < bg.length; i++) {
			bg[i].p = this;
			bg[i] = new BG();
		}

	}

	public void draw() {
		background(0);
		Ship.draw();

		for (int i = 0; i < bg.length; i++) {
			bg[i].draw();
			bg[i].move();
		}

		if (shots.size() > 0) {
			for (int i = 0; i < shots.size(); i++) {
				Weapon shot = (Weapon) shots.get(i);
				if (shot.x < width && shot.x > 0) {
					shot.move();
					shot.draw();
				} else {
					shots.remove(i);
				}
			}
		}
	}

	public void mousePressed() {
		Weapon shot = new Weapon(mouseX, mouseY, true);
		shot.p = this;
		shots.add(shot);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(new String[] { "--bgcolor=#ECE9D8", "Fu-Type" });
	}

}
