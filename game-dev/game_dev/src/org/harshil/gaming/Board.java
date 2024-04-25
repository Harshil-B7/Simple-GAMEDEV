package org.harshil.gaming;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.harshil.gaming.sprites.Enemy;
import org.harshil.gaming.sprites.Player;

public class Board extends JPanel 
{ 
	private static final long serialVersionUID = 1L;
	Timer timer;
    BufferedImage backgroundImage; 
    Player player;
    Enemy enemies[]= new Enemy[3];
    public Board() 
    {
	setSize(1600, 900);
	loadBackgroundImage();
	player=new Player();
	loadEnemies();
	gameLoop();
	setFocusable(true);
	bindEvents();
    }
    private void loadEnemies() 
    {
    int x = 350;
    int gap=450;
    int speed=4;
    for(int i = 0; i<enemies.length; i++) 
    { 
    	enemies[i] = new Enemy (x,speed);
    	x=x + gap;
    	speed+=2;
    }
    }
    private void gameLoop() {
    	timer=new Timer(50,(e)->repaint());
    	timer.start();
    }
    private void loadBackgroundImage() {
    try {
    backgroundImage = ImageIO.read(Board.class.getResource("game-bg.jpg")); 
    } 
    catch (IOException e) {
    System.out.println("Background Image Not Found....");
    System.exit(1);
    e.printStackTrace();
    }
    }
    private void bindEvents() {
	addKeyListener(new KeyListener(){

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()== KeyEvent.VK_RIGHT)
			  player.speed=6;
			if(e.getKeyCode()== KeyEvent.VK_LEFT)
				  player.speed=-6;
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			player.speed=0;
		}
	});
    }
    private void gameOver (Graphics pen) { 
    	if(player.outOfScreen()) {
    		pen.setFont(new Font("times", Font. BOLD, 70));
    		pen.setColor(Color.MAGENTA);
    		pen.drawString("Game Win", 700, 350);
    		timer.stop();
    		return;
    		}
    	for (Enemy enemy:enemies) { 
    		if(isCollide (enemy)) 
    		{
    	    pen.setFont(new Font("times", Font.BOLD, 75)); 
    	    pen.setColor(Color.BLACK);
    	    timer.stop();
    	    pen.drawString("GAME OVER", 700, 350);
    	}
    	}
    	}
    	private boolean isCollide (Enemy enemy) 
    	{ 
    	int xDistance = Math.abs(player.x-enemy.x);
    	int yDistance= Math.abs(player.y - enemy.y);
    	int maxH =Math.max(player.h,enemy.h); 
    	int maxW = Math.max(player.w,enemy.w);
    	return xDistance <= maxW-147 && yDistance <= maxH-180;
    	}
    private void printEnemies(Graphics pen) { 
	for (Enemy enemy:enemies) 
	{ 
		enemy.draw(pen);
		enemy.move();
}
}
public void paintComponent (Graphics pen) {
super.paintComponent (pen); 
pen.drawImage(backgroundImage,0,0,1600,900,null);
player.draw(pen);
player.move();
printEnemies(pen);
gameOver(pen);
}}

