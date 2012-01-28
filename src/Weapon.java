

import processing.core.PApplet;

public class Weapon {
	int x, y;
	// player is set when the shot originates from the player. true => shot
	// direction left to right, damages Enemies, doesn't damage player. false =>
	// the other way around.
	boolean player;

	static PApplet p;

	Weapon(int x_, int y_, boolean player_) {
		x = x_;
		y = y_;
		player = player_;
	}

	public void move() {
		if (player) {
			x += 15;
		} else {
			x -= 15;
		}
	}

	public void draw() {
		p.noStroke();
		if (player)
			p.fill(0, 255, 0);
		else
			p.fill(255, 0, 0);
		p.ellipse(x, y, 4, 4);
	}

}
