package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cz.uhk.fim.pro2.game.gui.MainFrame;

public class Tube {
	private static final int GAP = 200;

	private float positionX;
	private float height;
	private Color color;
	
	public void paint(Graphics g){
		g.setColor(Color.GREEN);
		
		Rectangle topRectangle = getTopRectangle();
		g.fillRect(
				(int)topRectangle.getX(), 
				(int)topRectangle.getY(), 
				(int)topRectangle.getWidth(),
				(int)topRectangle.getHeight());
		
		Rectangle bottomRectangle = getBottomRectangle();
		g.fillRect(
				(int)bottomRectangle.getX(), 
				(int)bottomRectangle.getY(), 
				(int)bottomRectangle.getWidth(),
				(int)bottomRectangle.getHeight());
		
	}

	
	public float getPositionX() {
		return positionX;
	}

	public Rectangle getTopRectangle(){
		return new Rectangle(
				(int) positionX - 25,
				(int) height, 
				50, 
				(int)(MainFrame.HEIGHT-height)
			);
	}
	
	public Rectangle getBottomRectangle(){
		return new Rectangle(
				(int)positionX - 25, 
				0,
				50, 
				(int)height - GAP
			);
	}
	
	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public float getHeight() {
		return height;
	}

	
	public Tube(float d, float e) {
		super();
		this.positionX = d;
		this.height = e;
		this.color = Color.GREEN;
	}
	
	public void update(float deltaTime){
		positionX -=  World.SPEED * deltaTime;
	}
}
