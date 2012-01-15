import processing.core.*;

public class FuType extends PApplet {

	public void setup() {
		size(800, 600);
		Ship s1 = new Ship(100, 100);
		Ship.p = this;
		Weapon w[] = new Weapon[200];
		
	}

	public void draw() {
		background(0);
		Ship.draw();

	if (keyPressed) {
			if (key == 's') {
				Ship.moveDown();
			}
			else if (key == 'w') {
				Ship.moveUp();
			}
			else if (key == 'a') {
				Ship.moveLeft();
			}
			else if (key == 'd') {
				Ship.moveRight();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(new String[] { "--bgcolor=#ECE9D8", "Fu-Type" });
	}

}
