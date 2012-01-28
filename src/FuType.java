import java.util.ArrayList;
import processing.core.*;

public class FuType extends PApplet {
	BG bg[] = new BG[100];
	Ship s1 = new Ship(100, 100);
	ArrayList shots = new ArrayList();
	ArrayList enemy1 = new ArrayList();
	ArrayList enemy2 = new ArrayList();
	ArrayList enemy3 = new ArrayList();
	Weapon shot;
	Enemy1 foe1;
	Enemy2 foe2;
	Enemy3 foe3;

	public void setup() {
		noCursor();
		frameRate(30);
		size(800, 600);
		// Weapon w[] = new Weapon[200];
		Ship.p = this;
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

		// Enemy movement, valitity- and collisionchecks
		if (enemy1.size() > 0)
			for (int i = 0; i < enemy1.size(); i++) {
				Enemy1 foe1 = (Enemy1) enemy1.get(i);
				if (foe1.x < width + 50 && foe1.x > 0 - 50) {
					foe1.move();
					foe1.draw();
					for (int j = 0; j < shots.size(); j++) {
						Weapon shot = (Weapon) shots.get(j);
						if (dist(shot.x, shot.y, foe1.x, foe1.y) < 10
								&& shot.player) {
							enemy1.remove(i);
							shots.remove(j);
						}
					}
				} else {
					enemy1.remove(i);
				}
			}

		if (enemy2.size() > 0)
			for (int i = 0; i < enemy2.size(); i++) {
				Enemy2 foe2 = (Enemy2) enemy2.get(i);
				if (foe2.x < width + 50 && foe2.x > 0 - 50) {
					foe2.move();
					foe2.draw();
					for (int j = 0; j < shots.size(); j++) {
						Weapon shot = (Weapon) shots.get(j);
						if (dist(shot.x, shot.y, foe2.x, foe2.y) < 20
								&& shot.player) {
							enemy2.remove(i);
							shots.remove(j);
						}
					}

				} else {
					enemy2.remove(i);
				}
			}
		if (enemy3.size() > 0)
			for (int i = 0; i < enemy3.size(); i++) {
				Enemy3 foe3 = (Enemy3) enemy3.get(i);
				if (foe3.x < width + 50 && foe3.x > 0 - 50) {
					foe3.move();
					foe3.draw();
					// Shot probability check
					for (int j = 0; j < shots.size(); j++) {
						Weapon shot = (Weapon) shots.get(j);
						if (dist(shot.x, shot.y, foe3.x, foe3.y) < 15
								&& shot.player) {
							enemy3.remove(i);
							shots.remove(j);
						}
					}
					if (random(1000) > 1000 - foe3.shoot) {
						Weapon shot = new Weapon(foe3.x, foe3.y, false);
						shot.p = this;
						shots.add(shot);
					}
				} else {
					enemy3.remove(i);
				}
			}
		// Collision Checks
		// Enemy spawns - if clause defines spawn rate
		if (random(1000) > 980) {
			Enemy1 foe1 = new Enemy1((int) random(height), width);
			foe1.p = this;
			enemy1.add(foe1);
		}
		if (random(1000) > 990) {
			Enemy2 foe2 = new Enemy2((int) random(height), width);
			foe2.p = this;
			enemy2.add(foe2);
		}
		if (random(1000) > 980) {
			Enemy3 foe3 = new Enemy3((int) random(height), width);
			foe3.p = this;
			enemy3.add(foe3);
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
