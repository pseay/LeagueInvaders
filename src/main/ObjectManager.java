package main;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	Rocketship rocket;
	ArrayList<Projectiles> projectileList = new ArrayList<Projectiles>();

	public ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
	}

	public void addProjectile(Projectiles p) {
		projectileList.add(p);
	}

	public void update() {
		rocket.update();
		for (Projectiles p : projectileList) {
			p.update();
		}
	}

	public void draw(Graphics g) {
		rocket.draw(g);
		for (Projectiles p : projectileList) {
			p.draw(g);
		}
	}

}
