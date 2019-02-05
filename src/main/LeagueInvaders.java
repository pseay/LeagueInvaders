package main;

import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {

	JFrame jf;
	GamePanel gp;
	final static int WIDTH = 500;
	final static int HEIGHT = 800;

	public LeagueInvaders() {
		jf = new JFrame();
		gp = new GamePanel();
	}

	public static void main(String[] args) {
		LeagueInvaders game = new LeagueInvaders();
		game.setup();
	}
	
	void setup() {
		jf.add(gp);
		jf.addKeyListener(gp);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		jf.pack();
		jf.setVisible(true);
		gp.startGame();
	}
}
