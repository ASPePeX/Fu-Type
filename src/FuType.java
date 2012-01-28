
import java.util.ArrayList;
import processing.core.PApplet;

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
	float skillMod = 1;
	int frameCount = 0;

	public void setup() {
		noCursor();
		frameRate(30);
		size(800, 600);
		Ship.p = this;
		for (int i = 0; i < bg.length; i++) {
			bg[i].p = this;
			bg[i] = new BG();
		}

	}

	public void draw() {
		// skillMod increase
		frameCount++;
		if (frameCount % 600 == 0) {
			skillMod += 1;
		}

		background(0);
		fill(255, 255, 255);
		text("Skillmod: " + ((int) skillMod), 10, 60);
		Ship.draw();

		// Background
		for (int i = 0; i < bg.length; i++) {
			bg[i].draw();
			bg[i].move();
		}

		// Shot movement and collision checks
		if (shots.size() > 0) {
			for (int i = 0; i < shots.size(); i++) {
				Weapon shot = (Weapon) shots.get(i);
				if (shot.x < width && shot.x > 0) {
					shot.move();
					shot.draw();
				} else {
					shots.remove(i);
				}
				// Collision check - shot <=> ship
				if (dist(shot.x, shot.y, mouseX, mouseY) < foe1.hb
						&& !(shot.player)) {
					shots.remove(i);
					s1.score -= 500;
					s1.drawHit();
				}
			}
		}

		// Enemy movement, valitity- and collisionchecks
		if (enemy1.size() > 0) {
			for (int i = 0; i < enemy1.size(); i++) {
				Enemy1 foe1 = (Enemy1) enemy1.get(i);
				if (foe1.x < width + 50 && foe1.x > 0 - 50) {
					foe1.move();
					foe1.draw();
					for (int j = 0; j < shots.size(); j++) {
						Weapon shot = (Weapon) shots.get(j);
						if (dist(shot.x, shot.y, foe1.x, foe1.y) < foe1.hb
								&& shot.player) {
							enemy1.remove(i);
							shots.remove(j);
							s1.score += foe1.w;
							foe1.drawHit();
						}
					}
				} else {
					enemy1.remove(i);
				}
				// Collision check - ship <=> enemy
				if (dist(mouseX, mouseY, foe1.x, foe1.y) < (s1.hb + foe1.hb)) {
					enemy1.remove(i);
					s1.score -= foe1.w * 10;
					foe1.drawHit();
					s1.drawHit();
				}

			}
		}
		if (enemy2.size() > 0) {
			for (int i = 0; i < enemy2.size(); i++) {
				Enemy2 foe2 = (Enemy2) enemy2.get(i);
				if (foe2.x < width + 50 && foe2.x > 0 - 50) {
					foe2.move();
					foe2.draw();
					for (int j = 0; j < shots.size(); j++) {
						Weapon shot = (Weapon) shots.get(j);
						if (dist(shot.x, shot.y, foe2.x, foe2.y) < foe2.hb
								&& shot.player) {
							enemy2.remove(i);
							shots.remove(j);
							s1.score += foe2.w;
							foe2.drawHit();
						}
					}

				} else {
					enemy2.remove(i);
				}
				// Collision check - ship <=> enemy
				if (dist(mouseX, mouseY, foe2.x, foe2.y) < (s1.hb + foe2.hb)) {
					enemy2.remove(i);
					s1.score -= foe2.w * 10;
					foe2.drawHit();
					s1.drawHit();
				}
			}
		}
		if (enemy3.size() > 0) {
			for (int i = 0; i < enemy3.size(); i++) {
				Enemy3 foe3 = (Enemy3) enemy3.get(i);
				if (foe3.x < width + 50 && foe3.x > 0 - 50) {
					foe3.move();
					foe3.draw();
					for (int j = 0; j < shots.size(); j++) {
						Weapon shot = (Weapon) shots.get(j);
						if (dist(shot.x, shot.y, foe3.x, foe3.y) < foe3.hb
								&& shot.player) {
							enemy3.remove(i);
							shots.remove(j);
							s1.score += foe3.w;
							foe3.drawHit();
						}
					}
					// Shot probability check
					if ((((skillMod / 100) + 1) * random(1000)) > (1000 - foe3.shoot)) {
						Weapon shot = new Weapon(foe3.x, foe3.y, false);
						shot.p = this;
						shots.add(shot);
					}
				} else {
					enemy3.remove(i);
				}
				// Collision check - ship <=> enemy
				if (dist(mouseX, mouseY, foe3.x, foe3.y) < (s1.hb + foe3.hb)) {
					enemy3.remove(i);
					s1.score -= foe3.w * 10;
					foe3.drawHit();
					s1.drawHit();
				}
			}
		}

		// Enemy spawns
		if ((((skillMod / 100) + 1) * random(1000)) > (1000 - Enemy1.spawn)) {
			Enemy1 foe1 = new Enemy1((int) random(height), width);
			foe1.p = this;
			enemy1.add(foe1);
		}
		if ((((skillMod / 100) + 1) * random(1000)) > (1000 - Enemy2.spawn)) {
			Enemy2 foe2 = new Enemy2((int) random(height), width);
			foe2.p = this;
			enemy2.add(foe2);
		}
		if ((((skillMod / 100) + 1) * random(1000)) > (1000 - Enemy3.spawn)) {
			Enemy3 foe3 = new Enemy3((int) random(height), width);
			foe3.p = this;
			enemy3.add(foe3);
		}

	}

	// mouse shooting
	public void mousePressed() {
		Weapon shot = new Weapon(mouseX, mouseY, true);
		shot.p = this;
		shots.add(shot);
	}

	/**
	 * @param args
	 */
	static public void main(String args[]) {
		PApplet.main(new String[] { "--bgcolor=#F0F0F0", "FuType" });
	}
}
