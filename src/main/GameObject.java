package main;

import java.awt.Graphics;

public class GameObject {

	int x, y, width, height;
	boolean isAlive;

	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		isAlive = true;
	}

	void update() {

	}

	void draw(Graphics g) {
		g.fillRect(x, y, 100, 100);
	}

}
