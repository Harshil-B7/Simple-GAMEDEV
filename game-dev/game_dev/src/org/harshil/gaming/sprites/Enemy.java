package org.harshil.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Enemy{
	public int x;
	public int y;
	public int w;
	public int h;
	public int speed;
	ImageIcon image; 
	public Enemy(int x,int speed) {
	w = 150;
	h = 150;
	this.speed=speed;
	this.x = x;
	y = 40;
	image = new ImageIcon (Enemy.class.getResource("enemy.gif"));
	}
	public void draw(Graphics pen) {
		pen.drawImage(image.getImage(), x, y, w, h, null);
	}
	public void move() {
		if(y>900)
			y=0;
		y=y+speed;
	}
	}
