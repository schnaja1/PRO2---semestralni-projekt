package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Heart {
	private float positionX;
	private float positionY;
	
	public Heart(float positionX, float positionY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
	}
	public void paint(Graphics g, BufferedImage img){
		Rectangle rectangle = getRectangle();
		if(img == null){
			
			g.setColor(Color.RED);
			g.fillRect(
					(int) rectangle.getX(),
					(int)rectangle.getY(),
					(int) rectangle.getHeight(),
					(int) rectangle.getWidth());
		}
		else {
			g.drawImage(img,
					(int) rectangle.getX(),
					(int)rectangle.getY(),
					(int) rectangle.getHeight(),
					(int) rectangle.getWidth(),
		 			null);
		}
	}
	
	public static float getRandomHeight(){
		return new Random().nextFloat()*600+100;
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
