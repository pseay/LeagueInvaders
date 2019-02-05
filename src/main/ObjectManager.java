package main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	int score = 0;
	Rocketship rocket;
	ArrayList<Projectiles> projectileList = new ArrayList<Projectiles>();
	ArrayList<Aliens> aliens = new ArrayList<Aliens>();
	long enemyTimer = 0;
	final int enemySpawnTime = 1000;
	
	public ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
	}
	
	int getScore()
	{
		return score;
	}
	void setScore(int score)
	{
		this.score = score;
	}
	
	public void addAlien(Aliens al)
	{
		aliens.add(al);
	}
	
	public void addProjectile(Projectiles p) {
		projectileList.add(p);
	}

	public void update() {
		rocket.update();
		for (Projectiles p : projectileList) {
			p.update();
		}
		for (Aliens a : aliens)
		{
			a.update();
		}
	}
	
	void manageEnemies()
	{
		if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
            addAlien(new Aliens(new Random().nextInt(LeagueInvaders.WIDTH - 50), 0, 50, 50));
            enemyTimer = System.currentTimeMillis();
		}
	}
	
	public void draw(Graphics g) {
		rocket.draw(g);
		for (Projectiles p : projectileList) {
			p.draw(g);
		}
		for (Aliens a : aliens) {
			a.draw(g);
		}
	}
	
	void purgeObjects()
	{
		for (int i = 0; i < aliens.size(); i++) {
			Aliens al = aliens.get(i);
			if (al.isAlive == false) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectileList.size(); i++)
		{
			Projectiles pro = projectileList.get(i);
			if (pro.isAlive == false)
			{
				projectileList.remove(i);
			}
		}
	}
	
	public void checkCollision()
	{
		for(Aliens al : aliens)
		{
			if (rocket.collisionBox.intersects(al.collisionBox))
			{
				rocket.isAlive = false;
				
				
			}
			for (Projectiles p : projectileList)
			{
				if (p.collisionBox.intersects(al.collisionBox))
				{
					score++;
					al.isAlive = false;
				}
			}
		}
	}

}
