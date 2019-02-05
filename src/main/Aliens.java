package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Aliens extends GameObject{
	public Aliens(int x, int y, int width, int height)
	{
		super(x,y,width,height);
	}
	
	void update()
	{
		super.update();
		y+=new Random().nextInt(9);
	}
	
	void draw(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
}
