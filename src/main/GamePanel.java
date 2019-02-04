package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	Timer t;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font instructionsFont;
	Rocketship rocket;
	ObjectManager om;

	public GamePanel() {
		t = new Timer(50 / 3, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		instructionsFont = new Font("Arial", Font.PLAIN, 25);
		rocket = new Rocketship(250, 700, 50, 50);
		om = new ObjectManager(rocket);
	}

	void startGame() {
		t.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
			rocket.draw(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		System.out.println(keyCode);
		if (keyCode == 10) {
			currentState++;
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		} else if (keyCode == 32) {
			om.addProjectile(new Projectiles(rocket.x + 20, rocket.y, 10, 10));
		} else if (keyCode == 37) {
			// left
			rocket.setLeft(true);
		} else if (keyCode == 38) {
			// up
			rocket.setUp(true);
		} else if (keyCode == 39) {
			// right
			rocket.setRight(true);
		} else if (keyCode == 40) {
			// down
			rocket.setDown(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == 37) {
			// left
			rocket.setLeft(false);
		} else if (keyCode == 38) {
			// up
			rocket.setUp(false);
		} else if (keyCode == 39) {
			// right
			rocket.setRight(false);
		} else if (keyCode == 40) {
			// down
			rocket.setDown(false);
		}
	}

	void updateMenuState() {

	}

	void updateGameState() {
		om.update();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 20, 200);
		g.setFont(instructionsFont);
		g.drawString("Press ENTER to start", 125, 350);
		g.drawString("Press SPACE for instructions", 100, 500);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		om.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", 100, 200);
		g.setFont(instructionsFont);
		g.drawString("You killed VALUE enemies", 125, 350);
		g.drawString("Press ENTER to restart", 100, 500);
	}
}
