package main;

import java.awt.Graphics;
import java.util.Random;

public class Aliens extends GameObject {
	public Aliens(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	void update() {
		super.update();
		if (new Random().nextInt(2) == 0) {
			if (new Random().nextInt(2) == 0) {
				if (new Random().nextInt(2) == 0) {
					y += new Random().nextInt(60);
				}
			}
		}
		final int left = 2;
		final int right = 3;
		switch (new Random().nextInt(2) + 2) {
		case left:
			x -= 15;
			break;
		case right:
			x += 15;
			break;
		}
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}
}
