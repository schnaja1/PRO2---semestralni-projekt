package cz.uhk.fim.pro2.game.model;

public class Heart {
	private float positionX;
	private float poitionY;
	
	public Heart(float positionX, float poitionY) {
		super();
		this.positionX = positionX;
		this.poitionY = poitionY;
	}
	public float getPositionX() {
		return positionX;
	}
	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}
	public float getPoitionY() {
		return poitionY;
	}
	public void setPoitionY(float poitionY) {
		this.poitionY = poitionY;
	}
}
