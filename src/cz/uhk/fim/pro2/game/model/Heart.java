package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Heart {
	private float positionX;
	private float positionY;
	
	public Heart(float positionX, float positionY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
	}
	public void paint(Graphics g){
		g.setColor(Color.RED);
		
		Rectangle rectangle = getRectangle();
		g.fillRect(
			(int) rectangle.getX(),
			(int)rectangle.getY(),
			(int) rectangle.getHeight(),
			(int) rectangle.getWidth());
	}
	public Rectangle getRectangle(){
		return new Rectangle((int) positionX - 25,(int) positionY - 25,50, 50);
	}
	public float getPositionX() {
		return positionX;
	}
	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}
	public float getPositionY() {
		return positionY;
	}
	public void setPositionY(float poitionY) {
		this.positionY = poitionY;
	}
	public void update(float deltaTime){
		positionX -=  World.SPEED * deltaTime;
	}
}
