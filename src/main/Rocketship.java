package main;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speed;
	boolean right, left, up, down = false;

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
	}

	void setUp(boolean setterTemp) {
		this.up = setterTemp;
	}

	void setDown(boolean setterTemp) {
		this.down = setterTemp;
	}

	void setRight(boolean setterTemp) {
		this.right = setterTemp;
	}

	void setLeft(boolean setterTemp) {
		this.left = setterTemp;
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}

	void update() {
		super.update();
		if (right == true && x < 450) {
			x += speed;
		}
		if (left == true && x > 0) {
			x -= speed;
		}
		if (down == true && y < 750) {
			y += speed;
		}
		if (up == true && y > 0) {
			y -= speed;
		}
	}
}
