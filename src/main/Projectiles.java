package main;

import java.awt.Color;
import java.awt.Graphics;

public class Projectiles extends GameObject {
	int speed;

	public Projectiles(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
	}

	void update() {
		y -= speed;
		if (y < 0) {
			isAlive = false;
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}
}
