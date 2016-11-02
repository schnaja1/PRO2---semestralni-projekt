package cz.uhk.fim.pro2.game.model;

import com.sun.prism.paint.Color;

public class Tube {
	private float positionX;
	private float height;
	private Color color;
	
	public float getPositionX() {
		return positionX;
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

	
	public Tube(float d, float e, Color green) {
		super();
		this.positionX = d;
		this.height = e;
		this.color = green;
	}
	
}
