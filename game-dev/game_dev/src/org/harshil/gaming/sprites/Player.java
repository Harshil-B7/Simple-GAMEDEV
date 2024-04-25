package org.harshil.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Player {
	public int x;
	public int y;
	public int w;
	public int h;
	public int speed;
	ImageIcon image; 
	 public Player() {
w = 270;
h = 285;
x = 40;
y = 525;
image = new ImageIcon (Player.class.getResource("player.gif"));

}public void draw(Graphics pen) {
	pen.drawImage(image.getImage(), x, y, w, h, null);
}
public void move() {
	x=x+speed;
}
public boolean outOfScreen() {
	return x>1600;}
}
